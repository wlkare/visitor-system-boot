package com.cmcc.system.controller;

import com.cmcc.common.bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @description: 接待人审批访客申请
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/18 9:49
     */
}
