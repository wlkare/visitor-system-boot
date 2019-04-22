package com.cmcc.system.entity;


import java.util.Date;

public class VisitorInfo {
    private String visitorInfoId;

    //0:申请人，1:随从人员
    private String visitorType;

    private String visitorRegistId;

    private String visitorName;

    private String visitorPhonenumber;

    private String visitorIdcard;

    private String visitorCompany;

    private Date entryTime;

    private Date departureTime;

    public String getVisitorInfoId() {
        return visitorInfoId;
    }

    public void setVisitorInfoId(String visitorInfoId) {
        this.visitorInfoId = visitorInfoId == null ? null : visitorInfoId.trim();
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public String getVisitorRegistId() {
        return visitorRegistId;
    }

    public void setVisitorRegistId(String visitorRegistId) {
        this.visitorRegistId = visitorRegistId == null ? null : visitorRegistId.trim();
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName == null ? null : visitorName.trim();
    }

    public String getVisitorPhonenumber() {
        return visitorPhonenumber;
    }

    public void setVisitorPhonenumber(String visitorPhonenumber) {
        this.visitorPhonenumber = visitorPhonenumber == null ? null : visitorPhonenumber.trim();
    }

    public String getVisitorIdcard() {
        return visitorIdcard;
    }

    public void setVisitorIdcard(String visitorIdcard) {
        this.visitorIdcard = visitorIdcard == null ? null : visitorIdcard.trim();
    }

    public String getVisitorCompany() {
        return visitorCompany;
    }

    public void setVisitorCompany(String visitorCompany) {
        this.visitorCompany = visitorCompany == null ? null : visitorCompany.trim();
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

    public VisitorInfo() {
    }

    public VisitorInfo(String visitorType, String visitorName, String visitorPhonenumber) {
        this.visitorType = visitorType;
        this.visitorName = visitorName;
        this.visitorPhonenumber = visitorPhonenumber;
    }
}