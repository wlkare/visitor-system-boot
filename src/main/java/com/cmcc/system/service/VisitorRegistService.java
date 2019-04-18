package com.cmcc.system.service;

import com.cmcc.system.vo.ApproalInfoVo;

import java.util.List;

public interface VisitorRegistService {

    /**
     * 查询审批记录
     * @return
     */
     List<ApproalInfoVo> queryApproalHistory(String phoneNumber, String visitorRegistId, boolean visitorType);
}
