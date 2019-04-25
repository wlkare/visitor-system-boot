package com.cmcc.system.entity;

import java.util.Date;

public class VisitorRegist {
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

    public String getVisitorRegistId() {
        return visitorRegistId;
    }

    public void setVisitorRegistId(String visitorRegistId) {
        this.visitorRegistId = visitorRegistId == null ? null : visitorRegistId.trim();
    }

    public String getVisitorPurpose() {
        return visitorPurpose;
    }

    public void setVisitorPurpose(String visitorPurpose) {
        this.visitorPurpose = visitorPurpose == null ? null : visitorPurpose.trim();
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId == null ? null : lesseeId.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber == null ? null : receiverPhoneNumber.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Date visitingTime) {
        this.visitingTime = visitingTime;
    }
}