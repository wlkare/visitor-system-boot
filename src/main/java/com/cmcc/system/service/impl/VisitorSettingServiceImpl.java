package com.cmcc.system.service.impl;

import com.cmcc.system.dao.VisitorSettingDao;
import com.cmcc.system.entity.VisitorSetting;
import com.cmcc.system.service.VisitorSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: VisitorSettingServiceImpl
 * @description: 访客目的设置实现类
 * @author: Mr.Wang
 * @create: 2019-04-17 15:30
 * @Version 1.0
 **/
@Service
public class VisitorSettingServiceImpl implements VisitorSettingService {

    @Autowired
    VisitorSettingDao visitorSettingDao;

    @Override
    public List<VisitorSetting> selectAllPurposeByLesseeId(String lesseeId) {

        return visitorSettingDao.selectAllPurposeByLesseeId(lesseeId);
    }

    @Override
    public int addVisitorPurpose(VisitorSetting record) {
        int i = visitorSettingDao.insertSelective(record);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(String visitorPurposeId) {
        return visitorSettingDao.deleteByPrimaryKey(visitorPurposeId);
    }

}
