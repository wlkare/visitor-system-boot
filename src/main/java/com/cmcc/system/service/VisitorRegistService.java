package com.cmcc.system.service;

import com.cmcc.system.vo.*;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface VisitorRegistService {


     /**
      * @description: 保存访客表单申请信息
      * @param
      * @return
      * @author Mr.Wang
      * @date 2019/4/19 9:32
      */
     int saveVisitorInfo(VisitorInfoVo visitorInfoVo);

    /**
     * @description: 接待人查询历史访客
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/19 14:20
     */
    List<ApplicantVo> queryHistoryVisitors(String phoneNumber);

    /**
     * @description: 访客详情展示
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 9:40
     */
    ApproalInfoVo visitorDetails(String visitorInfoId);


    /**
     * @description: 审批处理
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 10:03
     */
    int apprrovalProcess(String visitorRegistId,Byte status);


    /**
     * @description: 访客出入时间接口,卡绑定预留接口
     * @param
     * @return
     * @author Mr.Wang
     * @date 2019/4/22 16:13
     */
    int visitorEntryTime(String visitorInfoId, Date enterTime);

    int visitorLeaveTime(String visitorInfoId, Date leaveTime);

    /**
     * 管理员分页查询历史记录
     */
    Page<HistorySearchVo> getPageHistory(int pageNum, int pageSize, QueryConditionsVo queryConditionsVo);

    /**
     * 导出excel
     */
    List<Map<String, Object>> getExportVisitorsHistory(QueryConditionsVo queryConditionsVo);

    /**
     * 删除访客表单信息
     */
    int deleteVisitorRegistInfos(String visitorRegistId);
}


