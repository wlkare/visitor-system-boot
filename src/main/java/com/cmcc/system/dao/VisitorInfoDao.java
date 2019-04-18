package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorInfoDao {
    int deleteByPrimaryKey(String visitorInfoId);

    int insert(VisitorInfo record);

    int insertSelective(VisitorInfo record);

    VisitorInfo selectByPrimaryKey(String visitorInfoId);

    int updateByPrimaryKeySelective(VisitorInfo record);

    int updateByPrimaryKey(VisitorInfo record);
}