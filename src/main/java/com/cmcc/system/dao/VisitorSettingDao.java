package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorSetting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitorSettingDao {
    int deleteByPrimaryKey(String visitorPurposeId);

    int insert(VisitorSetting record);

    int insertSelective(VisitorSetting record);

    VisitorSetting selectByPrimaryKey(String visitorPurposeId);

    int updateByPrimaryKeySelective(VisitorSetting record);

    int updateByPrimaryKey(VisitorSetting record);

    /**
     * 通过租户Id查询所有访客目的
     */
    List<VisitorSetting> selectAllPurposeByLesseeId(String lesseeId);
}