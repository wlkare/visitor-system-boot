package com.cmcc.system.service;

import com.cmcc.system.entity.VisitorInfo;
import com.cmcc.system.entity.VisitorRegist;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.ApproalInfoVo;
import com.cmcc.system.vo.VisitorInfoVo;

import java.util.List;

public interface VisitorRegistService {

    /**
     * 接待人查询历史访客，包括所有状态的工单
     * @return
     */
     List<ApproalInfoVo> queryApproalHistory(String phoneNumber, String visitorRegistId, boolean visitorType);

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
}
