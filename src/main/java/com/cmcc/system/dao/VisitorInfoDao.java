package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VisitorInfoDao {
    int deleteByPrimaryKey(String visitorInfoId);

    int insert(VisitorInfo record);

    int insertSelective(VisitorInfo record);

    VisitorInfo selectByPrimaryKey(String visitorInfoId);

    int updateByPrimaryKeySelective(VisitorInfo record);

    int updateByPrimaryKey(VisitorInfo record);

    //通过访客登记ID，查询访客人员人数
    int countEntourage(String visitorRegistId);

    //通过访客登记ID、访客类型，查询申请人信息
    VisitorInfo selectApplicant(@Param("visitorRegistId") String visitorRegistId, @Param("visitorType") String visitorType);

    //通过登记ID删除信息
    int deleteByRegistId(String visitorRegistId);
}