package com.cmcc.system.service.impl;

import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.ApproalInfoVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorRegistServiceImpl implements VisitorRegistService {
    @Override
    public List<ApproalInfoVo> queryApproalHistory(String phoneNumber, String visitorRegistId, boolean visitorType) {
        return null;
    }
}
