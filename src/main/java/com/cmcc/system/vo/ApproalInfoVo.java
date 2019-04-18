package com.cmcc.system.vo;

import java.util.Date;

public class ApproalInfoVo {

    private String visitorName;

    private String visitorPhonenumber;

    private String visitorIdcard;

    private String visitorCompany;

    private Date entryTime;

    private Date departureTime;

    private String visitorPurpose;

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
}
