package com.cmcc.system.vo;

import java.util.Date;

/**
 * @program: HistorySearchVo
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-23 08:58
 * @Version 1.0
 **/
public class HistorySearchVo {

    private String visitorRegistId;

    private String visitorPurpose;

    private String lesseeId;

    private String receiverName;

    private String receiverPhoneNumber;

    //预约拜访时间
    private Date visitingTime;

    private Date creationTime;

    private Date approvalTime;

    //审批状态，0：待审批，1：同意，2：拒绝, 3:已结束
    private Byte processApprovalStatus;

    private String remark;

    private String visitorInfoId;

    //0:申请人，1:随从人员
    private String visitorType;

    private String visitorName;

    private String visitorPhonenumber;

    private String visitorIdcard;

    private String visitorCompany;

    private Date entryTime;

    private Date departureTime;

    public String getVisitorRegistId() {
        return visitorRegistId;
    }

    public void setVisitorRegistId(String visitorRegistId) {
        this.visitorRegistId = visitorRegistId;
    }

    public String getVisitorPurpose() {
        return visitorPurpose;
    }

    public void setVisitorPurpose(String visitorPurpose) {
        this.visitorPurpose = visitorPurpose;
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
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

    public Date getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Date visitingTime) {
        this.visitingTime = visitingTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Byte getProcessApprovalStatus() {
        return processApprovalStatus;
    }

    public void setProcessApprovalStatus(Byte processApprovalStatus) {
        this.processApprovalStatus = processApprovalStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVisitorInfoId() {
        return visitorInfoId;
    }

    public void setVisitorInfoId(String visitorInfoId) {
        this.visitorInfoId = visitorInfoId;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPhonenumber() {
        return visitorPhonenumber;
    }

    public void setVisitorPhonenumber(String visitorPhonenumber) {
        this.visitorPhonenumber = visitorPhonenumber;
    }

    public String getVisitorIdcard() {
        return visitorIdcard;
    }

    public void setVisitorIdcard(String visitorIdcard) {
        this.visitorIdcard = visitorIdcard;
    }

    public String getVisitorCompany() {
        return visitorCompany;
    }

    public void setVisitorCompany(String visitorCompany) {
        this.visitorCompany = visitorCompany;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "HistorySearchVo{" +
                "visitorRegistId='" + visitorRegistId + '\'' +
                ", visitorPurpose='" + visitorPurpose + '\'' +
                ", lesseeId='" + lesseeId + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhoneNumber='" + receiverPhoneNumber + '\'' +
                ", visitingTime=" + visitingTime +
                ", creationTime=" + creationTime +
                ", approvalTime=" + approvalTime +
                ", processApprovalStatus=" + processApprovalStatus +
                ", remark='" + remark + '\'' +
                ", visitorInfoId='" + visitorInfoId + '\'' +
                ", visitorType='" + visitorType + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", visitorPhonenumber='" + visitorPhonenumber + '\'' +
                ", visitorIdcard='" + visitorIdcard + '\'' +
                ", visitorCompany='" + visitorCompany + '\'' +
                ", entryTime=" + entryTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
