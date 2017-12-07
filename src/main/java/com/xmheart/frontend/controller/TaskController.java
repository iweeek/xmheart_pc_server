package com.xmheart.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xmheart.his.Response.Doctors;
import com.xmheart.service.HisService;
import com.xmheart.util.HisUtil;

@Controller
public class TaskController {
    
    @Autowired
    private HisService hisService;
    
    @RequestMapping(value = { "/testDoctor" }, method = RequestMethod.POST)
    public void doctors(@RequestParam String type, @RequestParam String deptCode,
            @RequestParam String DeptName, @RequestParam String workDateStart, 
            @RequestParam String workDateEnd) {
        System.out.println("开始同步his_id......");
        Doctors d = HisUtil.doctors(type, deptCode, DeptName, workDateStart, workDateEnd);
        hisService.doctors(d);
    }
}
