package com.cmcc;

import com.cmcc.system.dao.VisitorInfoDao;
import com.cmcc.system.dao.VisitorRegistDao;
import com.cmcc.system.entity.VisitorInfo;
import com.cmcc.system.entity.VisitorRegist;
import com.cmcc.system.service.VisitorRegistService;
import com.cmcc.system.vo.ApplicantVo;
import com.cmcc.system.vo.HistorySearchVo;
import com.cmcc.system.vo.QueryConditionsVo;
import com.cmcc.system.vo.VisitorInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorSystemBootApplicationTests {

    @Autowired
    VisitorRegistService visitorRegistService;

    @Autowired
    VisitorRegistDao visitorRegistDao;

    @Autowired
    VisitorInfoDao visitorInfoDao;

    @Test
    public void contextLoads() {

        VisitorInfo visitorInfo1 = new VisitorInfo("0", "张三丰", "98983464");
        VisitorInfo visitorInfo2 = new VisitorInfo("1", "刘备", "1454213464");
        VisitorInfo visitorInfo3 = new VisitorInfo("1", "关羽", "48679321");

        ArrayList<VisitorInfo> visitors = new ArrayList<>();
        visitors.add(visitorInfo1);
        visitors.add(visitorInfo2);
        visitors.add(visitorInfo3);

        VisitorInfoVo visitorInfoVo = new VisitorInfoVo(visitors,"外交","com2","89898999",new Date());

        visitorRegistService.saveVisitorInfo(visitorInfoVo);
    }

    @Test
    public void test(){

        List<VisitorRegist> visitorRegists = visitorRegistDao.selectByPhoneNumber("13465483");
        ArrayList<ApplicantVo> applicantVos = new ArrayList<>();

        for (VisitorRegist visitorRegist: visitorRegists) {

            ApplicantVo applicant = new ApplicantVo();

            //获取申请人
            System.out.println(visitorRegist.getVisitorRegistId());
            //VisitorInfo visitorInfo = visitorInfoDao.selectApplicant(visitorRegist.getVisitorRegistId(), true);
            visitorInfoDao.selectApplicant(visitorRegist.getVisitorRegistId(),"0");

        }
    }

    @Test
    public void test1() {

        QueryConditionsVo queryConditionsVo = new QueryConditionsVo();
        queryConditionsVo.setLesseeId("com2");
        //queryConditionsVo.setVisitorName("刘备");
        List<Map<String, Object>> exportVisitorsHistory = visitorRegistService.getExportVisitorsHistory(queryConditionsVo);
        System.out.println(exportVisitorsHistory);


    }
}
