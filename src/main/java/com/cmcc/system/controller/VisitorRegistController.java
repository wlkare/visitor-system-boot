package com.cmcc.system.controller;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.VisitorInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
 　　* @description: 查询当前租户下所有历史访客接口
 　　* @param
 　　* @return
 　　* @author Mr.Wang
 　　* @date 2019/4/18 9:05
     */
    @ApiOperation(value = "接待人查询历史访客记录")
    @GetMapping("/getReceiverHistoryVisitors")
    public Result getReceiverHistoryVisitors(@ApiParam(name="phoneNumber",value="接待人手机号",required=true)
                                             @PathVariable String phoneNumber){
        return Result.success();
    }


    /**
     * @description: 新增访客申请
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/18 9:14
     */
    @ApiOperation(value = "新增访客申请")
    @GetMapping("/addVisitorApproval")
    public Result addVisitorApproval(){
        return Result.success();
    }



    /**
     * @description: 保存访客信息表单
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 9:24
     */
    @ApiOperation(value = "保存访客申请信息")
    @GetMapping("/saveVisitorApproval")
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
}
