package com.cmcc.system.vo;

import com.cmcc.system.entity.VisitorInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;

/**
 * @program: VisitorInfoRequest
 * @description: 访客表单信息请求 类
 * @author: Mr.Wang
 * @create: 2019-04-19 08:55
 * @Version 1.0
 **/
public class VisitorInfoVo {


    @ApiModelProperty(value = "访客信息", name = "visitorInfo", required = true)
    private List<VisitorInfo> visitorInfos;

    @ApiModelProperty(value = "访客目的", name = "visitorPurpose", required = true)
    private String visitorPurpose;

    @ApiModelProperty(value = "租户ID", name = "lesseeId", required = true)
    private String lesseeId;

    @ApiModelProperty(value = "接待人姓名", name = "receiverName", required = false)
    private String receiverName;

    @ApiModelProperty(value = "接待人手机号", name = "receiverPhoneNumber", required = true)
    private String receiverPhoneNumber;

    @ApiParam(hidden = true)
    private Date creationTime;

    @ApiModelProperty(hidden = true)
    private Date approvalTime;

    @ApiModelProperty(value = "备注", name = "remark", required = false)
    private String remark;

    public List<VisitorInfo> getVisitorInfos() {
        return visitorInfos;
    }

    public void setVisitorInfos(List<VisitorInfo> visitorInfos) {
        this.visitorInfos = visitorInfos;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public VisitorInfoVo(List<VisitorInfo> visitorInfos, String visitorPurpose, String lesseeId, String receiverPhoneNumber) {
        this.visitorInfos = visitorInfos;
        this.visitorPurpose = visitorPurpose;
        this.lesseeId = lesseeId;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public VisitorInfoVo() {
    }
}
