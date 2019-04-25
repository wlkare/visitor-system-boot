package com.cmcc.system.vo;

import io.swagger.annotations.ApiParam;

import java.util.Date;

/**
 * @program: QueryConditionsVo
 * @description: 查询条件 VO
 * @author: Mr.Wang
 * @create: 2019-04-24 09:15
 * @Version 1.0
 **/
public class QueryConditionsVo {

    @ApiParam(value="租户(搜索选填)",required = false)
    private String lesseeId;

    @ApiParam(value="访单ID(搜索选填)",required = false)
    private String visitorRegistId;

    @ApiParam(value="访客ID(搜索选填)",required = false)
    private String visitorInfoId;

    @ApiParam(value="接待人姓名(搜索选填)",required = false)
    private String receiverName;

    @ApiParam(value="接待人手机号(搜索选填)",required = false)
    private String receiverPhoneNumber;

    @ApiParam(value="访客姓名(搜索选填)",required = false)
    private String visitorName;

    @ApiParam(value="预约时间区域开始时间(搜索选填)",required = false)
    private Date vistingStartTime;

    @ApiParam(value="预约时间区域结束时间(搜索选填)",required = false)
    private Date visitingEndTime;

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
    }

    public String getVisitorRegistId() {
        return visitorRegistId;
    }

    public void setVisitorRegistId(String visitorRegistId) {
        this.visitorRegistId = visitorRegistId;
    }

    public String getVisitorInfoId() {
        return visitorInfoId;
    }

    public void setVisitorInfoId(String visitorInfoId) {
        this.visitorInfoId = visitorInfoId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Date getVistingStartTime() {
        return vistingStartTime;
    }

    public void setVistingStartTime(Date vistingStartTime) {
        this.vistingStartTime = vistingStartTime;
    }

    public Date getVisitingEndTime() {
        return visitingEndTime;
    }

    public void setVisitingEndTime(Date visitingEndTime) {
        this.visitingEndTime = visitingEndTime;
    }
}
