package com.cmcc.system.service.impl;

import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.system.dao.VisitorInfoDao;
import com.cmcc.system.dao.VisitorRegistDao;
import com.cmcc.system.entity.VisitorInfo;
import com.cmcc.system.entity.VisitorRegist;
import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.ApproalInfoVo;
import com.cmcc.system.vo.VisitorInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VisitorRegistServiceImpl implements VisitorRegistService {

    @Autowired
    VisitorInfoDao visitorInfoDao;

    @Autowired
    VisitorRegistDao visitorRegistDao;

    @Override
    public int saveVisitorInfo(VisitorInfoVo visitorInfoVo) {
        VisitorRegist visitorRegist = new VisitorRegist();
        int t = 0;

        //1、保存登记表
        if (StringUtils.isNotBlank(visitorInfoVo.getReceiverPhoneNumber())){
            visitorRegist.setReceiverPhoneNumber(visitorInfoVo.getReceiverPhoneNumber());
        }
        if (StringUtils.isNotBlank(visitorInfoVo.getReceiverName())){
            visitorRegist.setReceiverName(visitorInfoVo.getReceiverName());
        }
        visitorRegist.setVisitorRegistId(IdGenerateUtil.uuid3());
        visitorRegist.setCreationTime(new Date());
        visitorRegist.setLesseeId(visitorInfoVo.getLesseeId());
        //表单提交时设定审批状态为0：待审批
        visitorRegist.setProcessApprovalStatus((byte)0);

        visitorRegist.setVisitorPurpose(visitorInfoVo.getVisitorPurpose());
        t = visitorRegistDao.insertSelective(visitorRegist);

        //2、保存访客信息
        if (t > 0){
            List<VisitorInfo> visitorInfos = visitorInfoVo.getVisitorInfos();
            for (VisitorInfo visitorInfo : visitorInfos) {
                VisitorInfo dataInfo = new VisitorInfo();
                if (visitorInfo.getVisitorName() != null){
                    dataInfo.setVisitorName(visitorInfo.getVisitorName());
                }
                if (visitorInfo.getVisitorIdcard() != null){
                    dataInfo.setVisitorIdcard(visitorInfo.getVisitorIdcard());
                }
                if (visitorInfo.getDepartureTime() != null){
                    dataInfo.setDepartureTime(visitorInfo.getDepartureTime());
                }
                if (visitorInfo.getEntryTime() != null){
                    dataInfo.setEntryTime(visitorInfo.getEntryTime());
                }
                dataInfo.setVisitorInfoId(IdGenerateUtil.uuid3());
                dataInfo.setVisitorType(visitorInfo.getVisitorType());
                dataInfo.setVisitorRegistId(visitorRegist.getVisitorRegistId());

                t = visitorInfoDao.insertSelective(dataInfo);
            }
        }

        return t;
    }

    @Override
    public List<ApplicantVo> queryHistoryVisitors(String phoneNumber) {

        //查询历史访客
        List<VisitorRegist> visitorRegists = visitorRegistDao.selectByPhoneNumber(phoneNumber);

        ArrayList<ApplicantVo> applicantVos = new ArrayList<>();

        for (VisitorRegist visitorRegist: visitorRegists) {

            ApplicantVo applicant = new ApplicantVo();

            //获取申请人
            VisitorInfo visitorInfo = visitorInfoDao.selectApplicant(visitorRegist.getVisitorRegistId(), "0");

            //申请人id
            applicant.setVisitorInfoId(visitorInfo.getVisitorInfoId());

            //登记表单id
            applicant.setVisitorRegistId(visitorInfo.getVisitorRegistId());

            //申请人姓名
            applicant.setVisitorName(visitorInfo.getVisitorName());

            //状态
            applicant.setProcessApprovalStatus(visitorRegist.getProcessApprovalStatus());

            //进入时间
            applicant.setEntryTime(visitorInfo.getEntryTime());

            //出门时间
            applicant.setDepartureTime(visitorInfo.getDepartureTime());

            applicantVos.add(applicant);
        }

        return applicantVos;
    }

    @Override
    public ApproalInfoVo visitorDetails(String visitorInfoId) {

        VisitorInfo visitorInfo = visitorInfoDao.selectByPrimaryKey(visitorInfoId);

        VisitorRegist visitorRegist = visitorRegistDao.selectByPrimaryKey(visitorInfo.getVisitorRegistId());

        //获取随从人员人数
        int entourages = visitorInfoDao.countEntourage(visitorInfo.getVisitorRegistId());

        ApproalInfoVo approalInfoVo = new ApproalInfoVo();

        approalInfoVo.setVisitorName(visitorInfo.getVisitorName());
        approalInfoVo.setProcessApprovalStatus(visitorRegist.getProcessApprovalStatus());
        approalInfoVo.setVisitorPhonenumber(visitorInfo.getVisitorPhonenumber());
        approalInfoVo.setVisitorIdcard(visitorInfo.getVisitorIdcard());
        approalInfoVo.setVisitorCompany(visitorInfo.getVisitorCompany());
        approalInfoVo.setCount(entourages-1);
        approalInfoVo.setEntryTime(visitorInfo.getEntryTime());
        approalInfoVo.setDepartureTime(visitorInfo.getDepartureTime());
        approalInfoVo.setVisitorPurpose(visitorRegist.getVisitorPurpose());
        approalInfoVo.setReceiverName(visitorRegist.getReceiverName());
        approalInfoVo.setReceiverPhoneNumber(visitorRegist.getReceiverPhoneNumber());

        return approalInfoVo;
    }

    @Override
    public int apprrovalProcess(String visitorRegistId,Byte status) {

        VisitorRegist visitorRegist = visitorRegistDao.selectByPrimaryKey(visitorRegistId);

        visitorRegist.setProcessApprovalStatus(status);
        visitorRegist.setApprovalTime(new Date());

        return visitorRegistDao.updateByPrimaryKey(visitorRegist);
    }

    @Override
    public int visitorEntryAndLeaveTimes(String visitorInfoId, Date enterTime, Date leaveTime) {

        VisitorInfo visitorInfo = visitorInfoDao.selectByPrimaryKey(visitorInfoId);

        if (enterTime != null){
            visitorInfo.setEntryTime(enterTime);
        }
        if (leaveTime != null){
            visitorInfo.setDepartureTime(leaveTime);
        }

        return visitorInfoDao.updateByPrimaryKeySelective(visitorInfo);
    }


}
