package com.cmcc.system.vo;

import java.util.Date;

/**
 * @program: ApplicantVo
 * @description: 历史访客 展示类
 * @author: Mr.Wang
 * @create: 2019-04-19 14:09
 * @Version 1.0
 **/
public class ApplicantVo {

    private String visitorName;

    //审批状态，0：待审批，1：同意，2：拒绝, 3:已结束
    private Byte processApprovalStatus;

    private Date entryTime;

    private Date departureTime;

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public Byte getProcessApprovalStatus() {
        return processApprovalStatus;
    }

    public void setProcessApprovalStatus(Byte processApprovalStatus) {
        this.processApprovalStatus = processApprovalStatus;
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

    public ApplicantVo(String visitorName, Byte processApprovalStatus, Date entryTime, Date departureTime) {
        this.visitorName = visitorName;
        this.processApprovalStatus = processApprovalStatus;
        this.entryTime = entryTime;
        this.departureTime = departureTime;
    }

    public ApplicantVo() {
    }
}
