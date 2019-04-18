package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorRegist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorRegistDao {
    int deleteByPrimaryKey(String visitorRegistId);

    int insert(VisitorRegist record);

    int insertSelective(VisitorRegist record);

    VisitorRegist selectByPrimaryKey(String visitorRegistId);

    int updateByPrimaryKeySelective(VisitorRegist record);

    int updateByPrimaryKey(VisitorRegist record);
}