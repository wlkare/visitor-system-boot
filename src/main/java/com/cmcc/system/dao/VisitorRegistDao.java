package com.cmcc.system.dao;

import com.cmcc.system.entity.VisitorRegist;
import com.cmcc.system.vo.HistorySearchVo;
import com.cmcc.system.vo.QueryConditionsVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据条件分页查询所有访客记录
     */
    Page<HistorySearchVo> getPageHistory(QueryConditionsVo record);

    /**
     *导出excel历史纪录
     */
    List<Map<String, Object>> getExportVisitorsHistory(QueryConditionsVo queryConditionsVo);

}