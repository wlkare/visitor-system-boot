package com.cmcc.system.entity;

import io.swagger.annotations.ApiParam;

public class VisitorSetting {
    @ApiParam(hidden = true)
    private String visitorPurposeId;

    @ApiParam(hidden = true)
    private String lesseeId;

    @ApiParam(value = "访客目的（必填）",required = true)
    private String visitPurpose;

    public String getVisitorPurposeId() {
        return visitorPurposeId;
    }

    public void setVisitorPurposeId(String visitorPurposeId) {
        this.visitorPurposeId = visitorPurposeId == null ? null : visitorPurposeId.trim();
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId == null ? null : lesseeId.trim();
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose == null ? null : visitPurpose.trim();
    }
}