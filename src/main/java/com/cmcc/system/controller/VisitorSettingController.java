package com.cmcc.system.controller;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.system.entity.VisitorSetting;
import com.cmcc.system.service.VisitorSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: VisitorSettingController
 * @description: 访客目的控制层
 * @author: Mr.Wang
 * @create: 2019-04-17 16:36
 * @Version 1.0
 **/
@Api(value = "访客目的接口")
@RestController
@RequestMapping("/visitPurpose")
public class VisitorSettingController {

    private Logger log =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    VisitorSettingService visitorSettingService;

    /**
     * 来访目的查询
     */
    @ApiOperation(value = "查询所有来访目的")
    @GetMapping("/getVisitPurpose/{lesseeId}")
    public Result getVisitorPurpose(@ApiParam(name="lesseeId",value="租户编号",required=true)
                                        @PathVariable String lesseeId){
        try {
            List<VisitorSetting> purposes = visitorSettingService.selectAllPurposeByLesseeId(lesseeId);
            if (purposes.size() > 0){
                return Result.success(purposes);
            }else {
                return Result.failure(ResultCode.RESULE_DATA_NONE);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }

    /**
     * @description: 添加来访目的
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/18 10:28
     */
    @ApiOperation(value = "管理员添加来访目的")
    @GetMapping("/addVisitPurpose")
    public Result addVisitorPurpose(VisitorSetting visitorSetting){

        try {
            visitorSetting.setVisitorPurposeId(IdGenerateUtil.uuid3());
            visitorSetting.setLesseeId("com2");
            int t = visitorSettingService.addVisitorPurpose(visitorSetting);
            if(t > 0){
                return Result.success();
            }else {
                return Result.failure(ResultCode.DATA_IS_WRONG);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.failure(ResultCode.SYSTEM_INNER_ERROR);
    }




}
