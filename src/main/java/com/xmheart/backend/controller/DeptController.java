package com.xmheart.backend.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;
import com.xmheart.service.DoctorAndDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "后台科室相关接口")
@RestController
public class DeptController {

    @Autowired
    private DoctorAndDeptService doctorAndDeptService;
    
    @ApiOperation(value = "获取科室列表", notes = "获取科室列表")
    @RequestMapping(value = { "/depts" }, method = RequestMethod.GET)
    public ResponseEntity<?> index() {
        
        List<XPWDept> list;
        list = doctorAndDeptService.getDepts();
        if (list.size() == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
        }
    }
    
    @ApiOperation(value = "根据Id获取科室信息", notes = "根据Id获取科室信息")
    @RequestMapping(value = { "/dept/{id}" }, method = RequestMethod.GET)
    public ResponseEntity<?> read(@ApiParam("科室的Id") @PathVariable Long id) {
        
        XPWDept dept;
        dept = doctorAndDeptService.getDeptById(id);
        if (dept == null) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(dept);
        }
    }
    
    @ApiOperation(value = "根据Id更新科室信息", notes = "根据Id更新科室信息")
    @RequestMapping(value = { "/dept/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("科室的Id") @PathVariable Long id,
            @ApiParam("名称，可选") @RequestParam(required = false) String name,
            @ApiParam("介绍") @RequestParam(required = false) String intro,
            @ApiParam("是否是门诊科室") @RequestParam(required = false) Boolean outService,
            @ApiParam("是否可以展示") @RequestParam(required = false) Boolean isDisplayed) {
        
        XPWDept dept;
        dept = doctorAndDeptService.getDeptById(id);
        
        if (name != null) {
            dept.setName(name);
        }
        
        if (intro != null) {
            dept.setIntro(intro);
        }
        
        if (outService != null) {
            dept.setOutService(outService);
        }
        
        if (isDisplayed != null) {
            dept.setIsDisplayed(isDisplayed);
        }
        
        int ret = doctorAndDeptService.updateDept(dept);
        if (ret == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(dept);
        }
    }
    
    @ApiOperation(value = "创建科室信息", notes = "创建科室信息")
    @RequestMapping(value = { "/depts" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("科室的名称，可选") @RequestParam(required = false) String name,
            @ApiParam("介绍") @RequestParam(required = false) String intro,
            @ApiParam("是否是门诊科室") @RequestParam(required = false) Boolean outService,
            @ApiParam("是否可以展示") @RequestParam(required = false) Boolean isDisplayed) {
        
        XPWDept dept = new XPWDept();
        
        if (name != null) {
            dept.setName(name);
        }
        
        if (intro != null) {
            dept.setIntro(intro);
        }
        
        if (outService != null) {
            dept.setOutService(outService);
        }
        
        if (isDisplayed != null) {
            dept.setIsDisplayed(isDisplayed);
        }
        
        int ret = doctorAndDeptService.createDept(dept);
        if (ret == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(dept);
        }
    }
}