package com.cmcc.system.service;

import com.cmcc.system.entity.VisitorSetting;

import java.util.List;

/**
 * @program: VisitorSettingService
 * @description: 访客目的service层
 * @author: Mr.Wang
 * @create: 2019-04-17 15:30
 * @Version 1.0
 **/
public interface VisitorSettingService {

    /**
     * 来访目的
     */
    List<VisitorSetting> selectAllPurposeByLesseeId(String lesseeId);

    //增加来访目的
    int addVisitorPurpose(VisitorSetting record);

    //删除
    int deleteByPrimaryKey(String visitorPurposeId);
}
