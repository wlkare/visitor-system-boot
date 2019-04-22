package com.cmcc.system.controller;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.ApproalInfoVo;
import com.cmcc.system.vo.VisitorInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: VisitorRegistController
 * @description: 访客信息登记 控制层
 * @author: Mr.Wang
 * @create: 2019-04-18 09:18
 * @Version 1.0
 **/
@Api(value = "访客信息登记、查询")
@RestController
@RequestMapping("/visitorRegist")
public class VisitorRegistController {

    private Logger log =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VisitorRegistService visitorRegistService;



    /**
     * @description: 保存访客信息表单 todo （访客信息填写有bug）
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 9:24
     */
    @ApiOperation(value = "保存访客申请信息")
    @PutMapping("/saveVisitorApproval")
    public Result savaVisitorApproval(VisitorInfoVo visitorInfoVo){

        try {
            int i = visitorRegistService.saveVisitorInfo(visitorInfoVo);
            if (i > 0){
                return Result.success();
            }else {
                return Result.failure(ResultCode.DATA_IS_WRONG);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 接待人查看历史访客
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 16:19
     */
    @ApiOperation(value = "接待人查看历史访客")
    @GetMapping("/receiverQueryHistoryVisitors/{phoneNumber}")
    public Result receiverQueryHistoryVisitors(@ApiParam(name="phoneNumber",value="接待人手机号",required=true)
                                               @PathVariable String phoneNumber){
        try {
            List<ApplicantVo> applicantVos = visitorRegistService.queryHistoryVisitors(phoneNumber);
            return Result.success(applicantVos);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 访客详情展示
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 10:33
     */
    @ApiOperation(value = "查看访客详情")
    @GetMapping("/queryHistoryVisitorsDetails/{visitorInfoId}")
    public Result queryHistoryVisitorsDetails(@ApiParam(name="visitorInfoId",value="申请人ID",required=true)
                                               @PathVariable String visitorInfoId){

        try {
            ApproalInfoVo approalInfoVo = visitorRegistService.visitorDetails(visitorInfoId);
            return Result.success(approalInfoVo);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 审批处理，todo 审批后需发送短信提醒申请人
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 10:56
     */
    @ApiOperation(value = "接待人进行审批，即更改审批状态")
    @PostMapping("/apprrovalProcess/{visitorRegistId}/{status}")
    public Result apprrovalProcess(@ApiParam(name="visitorRegistId",value="登记ID",required=true) @PathVariable String visitorRegistId,
                                   @ApiParam(name="status",value="审批状态，1：同意，2：拒绝",required=true) @PathVariable Byte status){
        try {
            int i = visitorRegistService.apprrovalProcess(visitorRegistId, status);
            if (i > 0){
                return Result.success();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 访客进入时间
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 16:21
     */
    @ApiOperation(value = "访客进入时间记录")
    @PostMapping(value = "/visitorEntryTimes/{visitorInfoId}/{enterTime}")
    public Result visitorEntryTimes(@ApiParam(name="visitorInfoId",value="访客ID",required=true) @PathVariable String visitorInfoId,
                                            @ApiParam(name="enterTime",value="访客进入时间(yyyy-MM-dd HH:mm:ss)",required=true) @PathVariable Date enterTime){
        try {
            int i = visitorRegistService.visitorEntryTime(visitorInfoId, enterTime);
            if (i > 0){
                return Result.success();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 访客进入时间
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 16:21
     */
    @ApiOperation(value = "访客离开时间记录")
    @PostMapping(value = "/visitorLeaveTimes/{visitorInfoId}/{leaveTime}")
    public Result visitorLeaveTimes(@ApiParam(name="visitorInfoId",value="访客ID",required=true) @PathVariable String visitorInfoId,
                                            @ApiParam(name="leaveTime",value="访客离开时间(yyyy-MM-dd HH:mm:ss)", required=true) @PathVariable Date leaveTime){
        try {
            int i = visitorRegistService.visitorLeaveTime(visitorInfoId, leaveTime);
            if (i > 0){
                return Result.success();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

}
