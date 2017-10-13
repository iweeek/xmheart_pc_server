package com.xmheart.backend.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.model.XPWDoctor;
import com.xmheart.service.DoctorAndDeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "后台医生相关接口")
@RestController
public class DoctorController {
    
    @Autowired
    private DoctorAndDeptService doctorAndDeptService;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiOperation(value = "获取医生列表", notes = "获取医生列表")
    @RequestMapping(value = { "/doctors" }, method = RequestMethod.GET)
    public ResponseEntity<?> index(@ApiParam("开始页号") @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @ApiParam("每页的数目") @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @ApiParam("科室的Id，可选") @RequestParam(required = false) Long deptId) {
        
        PageHelper.startPage(pageNo, pageSize);
        
        List<XPWDoctor> list;
        if (deptId == null) {
            list = doctorAndDeptService.getDisplayDoctors();
        } else {
            list = doctorAndDeptService.getDoctorsByDeptId(deptId);
        }
        
        PageInfo pageInfo = new PageInfo(list);
        
        JSONObject object = new JSONObject();
        object.append("list", list);
        object.append("pageInfo", pageInfo);
        
        if (list.size() == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
        }
    }
    
    @ApiOperation(value = "根据Id获取医生信息", notes = "根据Id获取医生信息")
    @RequestMapping(value = { "/doctors/{id}" }, method = RequestMethod.GET)
    public ResponseEntity<?> read(@ApiParam("医生的Id") @PathVariable Long id) {
        
        XPWDoctor doctor;
        doctor = doctorAndDeptService.getDoctorById(id);
        
        if (doctor == null) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(doctor);
        }
    }
    
    @ApiOperation(value = "根据Id更新医生信息", notes = "根据Id更新医生信息")
    @RequestMapping(value = { "/doctors/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("医生的Id") @PathVariable Long id,
            @ApiParam("医生的姓名，可选") @RequestParam(required = false) String name,
            @ApiParam("医生的头像，可选") @RequestParam(required = false) String imageUrl,
            @ApiParam("科室的Id，可选") @RequestParam(required = false) Long deptId,
            @ApiParam("职务，可选") @RequestParam(required = false) String duty,
            @ApiParam("职称，可选") @RequestParam(required = false) String professionalTitle,
            @ApiParam("介绍，可选") @RequestParam(required = false) String intro,
            @ApiParam("是否可以展示，可选") @RequestParam(required = false) Boolean isDisplayed) {
        
        XPWDoctor doctor;
        doctor = doctorAndDeptService.getDoctorById(id);
        
        if (name != null) {
            doctor.setName(name);
        }
        
        if (imageUrl != null) {
            doctor.setImageUrl(imageUrl);
        }
        
        if (deptId != null) {
            doctor.setDeptId(deptId);
        }
        
        if (duty != null) {
            doctor.setDuty(duty);
        }
        
        if (professionalTitle != null) {
            doctor.setProfessionalTitle(professionalTitle);
        }
        
        if (intro != null) {
            doctor.setIntro(intro);
        }
        
        if (isDisplayed != null) {
            doctor.setIsDisplayed(isDisplayed);
        }
        
        int ret = doctorAndDeptService.updateDoctor(doctor);
        if (ret == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_OK).body(doctor);
        }
    }
    
    @ApiOperation(value = "创建医生信息", notes = "创建医生信息")
    @RequestMapping(value = { "/doctors" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("医生的姓名，可选") @RequestParam(required = false) String name,
            @ApiParam("科室的Id，可选") @RequestParam(required = false) Long deptId,
            @ApiParam("职务，可选") @RequestParam(required = false) String duty,
            @ApiParam("职称，可选") @RequestParam(required = false) String professionalTitle,
            @ApiParam("介绍，可选") @RequestParam(required = false) String intro,
            @ApiParam("医生头像，可选") @RequestParam(required = false) String imageUrl,
            @ApiParam("是否可以展示，可选") @RequestParam(required = false) Boolean isDisplayed) {
        
        XPWDoctor doctor = new XPWDoctor();
        
        if (name != null) {
            doctor.setName(name);
        } else {
            doctor.setName("");
        }
        
        if (imageUrl != null) {
            doctor.setImageUrl(imageUrl);
        }
        
        if (deptId != null) {
            doctor.setDeptId(deptId);
        } else {
            doctor.setDeptId(0l);
        }
        
        if (duty != null) {
            doctor.setDuty(duty);
        } else {
            doctor.setDuty("");
        }
        
        if (professionalTitle != null) {
            doctor.setProfessionalTitle(professionalTitle);
        } else {
            doctor.setProfessionalTitle("");
        }
        
        if (intro != null) {
            doctor.setIntro(intro);
        } else {
            doctor.setIntro("");
        }
        
        if (isDisplayed != null) {
            doctor.setIsDisplayed(isDisplayed);
        } else {
            doctor.setIsDisplayed(false);
        }
        
        int ret = doctorAndDeptService.createDoctor(doctor);
        if (ret == 0) {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(doctor);
        }
    }

}