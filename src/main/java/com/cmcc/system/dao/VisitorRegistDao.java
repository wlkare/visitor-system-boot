package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorRegist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitorRegistDao {
    int deleteByPrimaryKey(String visitorRegistId);

    int insert(VisitorRegist record);

    int insertSelective(VisitorRegist record);

    VisitorRegist selectByPrimaryKey(String visitorRegistId);

    int updateByPrimaryKeySelective(VisitorRegist record);

    int updateByPrimaryKey(VisitorRegist record);

    //接待人通过手机号查询所有历史访客
    List<VisitorRegist> selectByPhoneNumber(String phoneNumber);

}