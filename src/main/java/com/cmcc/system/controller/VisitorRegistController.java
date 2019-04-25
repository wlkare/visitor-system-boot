package com.cmcc.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.utils.ExcelUtil;
import com.cmcc.system.entity.VisitorInfo;
import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.*;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * @description: 保存访客信息表单
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 9:24
     */
    @ApiOperation(value = "保存访客申请信息")
    @PostMapping("/saveVisitorApproval")
    public Result savaVisitorApproval(@ApiParam(value = "访客信息，JSON格式", name = "visitorInfos",required = true)
                                          @RequestParam String visitorInfos,
                                      @ApiParam(value = "访客目的", name = "visitorPurpose", required = true)
                                          @RequestParam String visitorPurpose,
                                      @ApiParam(value = "租户ID", name = "lesseeId", required = true)
                                          @RequestParam String lesseeId,
                                      @ApiParam(value = "接待人姓名", name = "receiverName", required = true)
                                          @RequestParam String receiverName,
                                      @ApiParam(value = "接待人手机号", name = "receiverPhoneNumber", required = true)
                                          @RequestParam String receiverPhoneNumber,
                                      @ApiParam(value = "预约时间", name = "visitingTime", required = true)
                                          @RequestParam Date visitingTime,
                                      @ApiParam(value = "备注", name = "remark", required = false)
                                          @RequestParam String remark){

        try {
            VisitorInfoVo visitorInfoVo = new VisitorInfoVo();
            List<VisitorInfo> listVisitorInfos = JSONObject.parseArray(visitorInfos,VisitorInfo.class);
            visitorInfoVo.setVisitorInfos(listVisitorInfos);
            visitorInfoVo.setVisitorPurpose(visitorPurpose);
            visitorInfoVo.setLesseeId(lesseeId);
            visitorInfoVo.setReceiverName(receiverName);
            visitorInfoVo.setReceiverPhoneNumber(receiverPhoneNumber);
            visitorInfoVo.setVisitingTime(visitingTime);
            visitorInfoVo.setRemark(remark);

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
    @GetMapping("/receiverQueryHistoryVisitors")
    public Result receiverQueryHistoryVisitors(@ApiParam(name="phoneNumber",value="接待人手机号",required=true)
                                               @RequestParam String phoneNumber){
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
    @GetMapping("/queryHistoryVisitorsDetails")
    public Result queryHistoryVisitorsDetails(@ApiParam(name="visitorInfoId",value="申请人ID",required=true)
                                               @RequestParam String visitorInfoId){

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
    @PostMapping("/apprrovalProcess")
    public Result apprrovalProcess(@ApiParam(name="visitorRegistId",value="登记ID",required=true) @RequestParam String visitorRegistId,
                                   @ApiParam(name="status",value="审批状态，1：同意，2：拒绝",required=true) @RequestParam Byte status){
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
    @PostMapping(value = "/visitorEntryTimes")
    public Result visitorEntryTimes(@ApiParam(name="visitorInfoId",value="访客ID",required=true) @RequestParam String visitorInfoId,
                                            @ApiParam(name="enterTime",value="访客进入时间(yyyy-MM-dd HH:mm:ss)",required=true) @RequestParam Date enterTime){
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
    @PostMapping(value = "/visitorLeaveTimes")
    public Result visitorLeaveTimes(@ApiParam(name="visitorInfoId",value="访客ID",required=true) @RequestParam String visitorInfoId,
                                            @ApiParam(name="leaveTime",value="访客离开时间(yyyy-MM-dd HH:mm:ss)", required=true) @RequestParam Date leaveTime){
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

    /**
     * @description: 管理员分页查询访客记录
     * @param  pageNum 开始页码，pageSize 每页大小，inSysApprovalVo 搜索条件封装实体类
     * @return  Result
     * @author Mr.Wang
     * @date 2019/4/24 10:12
     */
    @ApiOperation(value="管理员分页查询访客记录", notes="管理员根据条件查询访客记录")
    @GetMapping(value = "/getPage")
    public Result getAllVisitorsInfo(@ApiParam(name="pageNum",value="页码，从1开始，默认为1",required=true)
                                         @RequestParam(value="pageNum",defaultValue="1") int pageNum,
                                     @ApiParam(name="pageSize",value="每页大小，默认为10",required=true)
                                         @RequestParam(value="pageSize",defaultValue="10") int pageSize,
                                         QueryConditionsVo queryConditionsVo){
        try {
            Page<HistorySearchVo> pageHistory = visitorRegistService.getPageHistory(pageNum, pageSize, queryConditionsVo);
            if (pageHistory.size() > 0){
                return Result.success(pageHistory);
            }else {
                return Result.failure(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);

    }

    /**
     * @description: 导出访客记录
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/24 14:11
     */
    @ApiOperation(value = "导出访客数据", notes = "导出访客数据")
    @GetMapping(value="/exportVisitorInfos")
    public void exportApproval(HttpServletResponse response, QueryConditionsVo queryConditionsVo) {

        HSSFWorkbook wb = null;
        String fileName = "VisitorHistory.xls";

        try {
            List<Map<String, Object>> list = visitorRegistService.getExportVisitorsHistory(queryConditionsVo);
            String[] titles = {"访单编号", "访客姓名", "访客类型", "预约时间", "访客目的", "接待人", "访单状态"};

            //sheet名
            if (list.size() > 0 && !list.isEmpty()){
                String sheetName = "访客记录表";
                String[][] content = new String[list.size()][titles.length];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (int i = 0; i < list.size(); i++) {
                    content[i] = new String[titles.length];
                    Map<String, Object> obj = list.get(i);
                    content[i][0] = obj.get("visitorRegistId").toString();
                    String visitorName = obj.get("visitorName").toString();
                    if (visitorName != null) {
                        content[i][1] = visitorName;
                    }
                    String visitorType = obj.get("visitorType").toString();
                    if ("0".equals(visitorType)) {
                        content[i][2] = "申请人";
                    } else {
                        content[i][2] = "随从人员";
                    }

                    Date visitingTime = (Date) obj.get("visitingTime");
                    if (visitingTime != null) {
                        content[i][3] = sdf.format(visitingTime);
                    } else {
                        content[i][3] = "";
                    }

                    content[i][4] = obj.get("visitorPurpose").toString();
                    //log.info("receiveName{}", obj.get("receiveName"));
                    // String receiverName = obj.get("receiverName").toString();

                    content[i][5] = obj.get("receiverName").toString();

                    String processApprovalStatus = obj.get("processApprovalStatus").toString();
                    if ("0".equals(processApprovalStatus)) {
                        content[i][6] = "待审批";
                    } else if ("1".equals(processApprovalStatus)) {
                        content[i][6] = "已同意";
                    } else if ("2".equals(processApprovalStatus)) {
                        content[i][6] = "已拒绝";
                    } else if ("3".equals(processApprovalStatus)) {
                        content[i][6] = "已结束";
                    }
                }
                //创建HSSFWorkbook
                wb = ExcelUtil.getHSSFWorkbook(sheetName, titles, content, wb);
                response.setContentType("application/force-download;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                response.addHeader("Content-Disposition","attachment;fileName=" +new String(fileName.getBytes("utf-8"),"iso-8859-1"));
                ExcelUtil.setResponseHeader(response, fileName);
                OutputStream os = response.getOutputStream();
                wb.write(os);
                os.flush();
                os.close();

            }

        } catch (Exception e) {
            log.error("文件流读写异常");
        }

    }

    /**
     * @description: 删除访客记录
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/25 17:03
     */
    @ApiOperation(value = "删除访客记录")
    @DeleteMapping("/deleteVisitorRegistInfos")
    public Result deleteVisitorRegistInfos(@ApiParam(name="visitorRegistId",value="登记ID",required=true)
                                       @RequestParam String visitorRegistId){

        try {
            int i = visitorRegistService.deleteVisitorRegistInfos(visitorRegistId);
            if (i > 0){
                return Result.success();
            }else {
                Result.failure(ResultCode.DATA_IS_WRONG);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }
}
