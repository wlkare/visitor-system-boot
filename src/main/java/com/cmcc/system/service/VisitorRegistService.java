package com.cmcc.system.service;

import com.cmcc.system.entity.VisitorInfo;
import com.cmcc.system.entity.VisitorRegist;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.ApproalInfoVo;
import com.cmcc.system.vo.VisitorInfoVo;

import java.util.Date;
import java.util.List;

public interface VisitorRegistService {


     /**
      * @description: 保存访客表单申请信息
      * @param
      * @return
      * @author Mr.Wang
      * @date 2019/4/19 9:32
      */
     int saveVisitorInfo(VisitorInfoVo visitorInfoVo);

    /**
     * @description: 接待人查询历史访客
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 14:20
     */
    List<ApplicantVo> queryHistoryVisitors(String phoneNumber);

    /**
     * @description: 访客详情展示
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 9:40
     */
    ApproalInfoVo visitorDetails(String visitorInfoId);


    /**
     * @description: 审批处理
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 10:03
     */
    int apprrovalProcess(String visitorRegistId,Byte status);


    /**
     * @description: 访客出入时间接口,卡绑定预留接口
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 16:13
     */
    int visitorEntryAndLeaveTimes(String visitorInfoId, Date enterTime, Date leaveTime);
}


