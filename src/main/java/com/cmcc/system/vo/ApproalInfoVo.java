package com.cmcc.system.vo;

import java.util.Date;

public class ApproalInfoVo {

    private String visitorName;

    //审批状态，0：待审批，1：同意，2：拒绝, 3:已结束
    private Byte processApprovalStatus;

    private String visitorPhonenumber;

    private String visitorIdcard;

    private String visitorCompany;

    //随从人员人数
    private int count;

    private Date entryTime;

    private Date departureTime;

    private String visitorPurpose;

    private String receiverName;

    private String receiverPhoneNumber;

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

    public String getVisitorPurpose() {
        return visitorPurpose;
    }

    public void setVisitorPurpose(String visitorPurpose) {
        this.visitorPurpose = visitorPurpose;
    }

    public Byte getProcessApprovalStatus() {
        return processApprovalStatus;
    }

    public void setProcessApprovalStatus(Byte processApprovalStatus) {
        this.processApprovalStatus = processApprovalStatus;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
}
