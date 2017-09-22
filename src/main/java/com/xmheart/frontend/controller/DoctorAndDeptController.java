package com.xmheart.frontend.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;
import com.xmheart.service.DoctorAndDeptService;

@Controller
public class DoctorAndDeptController {

	@Autowired
	private ColumnService ColumnService;

	@Autowired
	private DoctorAndDeptService doctorAndDeptService;

	static final long NEWS_COLUMN_ID = 5;
	static final long EXPERT_COLUMN_ID = 3;
	
	private final String DOCTOR_DEPT_COLUMN_NAME = "名医名科";

//    private static Map<String, String> secColumns = new HashMap<String, String>();

    private Model addCommonHeader(Model model) {

    	List<XPWColumn> columnList = ColumnService.getFirstColumns();
    	Map<String, String> firstColumns = new LinkedHashMap<String, String>();
    	Map<String, List<XPWColumn>> columnMap = new LinkedHashMap<String, List<XPWColumn>>();
    	Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();

    	for (XPWColumn column : columnList) {
    		firstColumns.put(column.getColumnName(), column.getUrl());

    		List<XPWColumn> secColList = ColumnService.getChildColumnsById(column.getId());
    		if (secColList.size() > 0) {
    			columnMap.put(column.getColumnName(), secColList);
    		}

    		List<XPWNav> navList = ColumnService.getNavsByColumnId(column.getId());

    		if (navList.size() > 0) {
    			navMap.put(column.getColumnName(), navList);
    		}
    	}

    	model.addAttribute("firstColumns", firstColumns);
    	model.addAttribute("columnMap", columnMap);
    	model.addAttribute("navMap", navMap);
    	model.addAttribute("firstColumnName", DOCTOR_DEPT_COLUMN_NAME);

    	return model;
    }

    @RequestMapping(value = { "/doctorDept" }, method = RequestMethod.GET)
    public String doctorDept(Model model) {
    	model = addCommonHeader(model);

    	List<XPWDoctor> doctors = doctorAndDeptService.getDoctors();
    	model.addAttribute("doctors", doctors);

    	List<XPWDept> depts = doctorAndDeptService.getOutServiceDepts();
    	model.addAttribute("depts", depts);

        return "doctor_dept";
    }

    @RequestMapping(value = { "/doctorDetail" }, method = RequestMethod.GET)
    public String doctorInfo(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);

    	XPWDoctor doctor = doctorAndDeptService.getDoctorAndDeptById(id);
    	model.addAttribute("doctor", doctor);
//    	model.addAttribute("dept", doctor.getDept());
        return "doctor_detail";
    }

    @RequestMapping(value = { "/deptDoctor" }, method = RequestMethod.GET)
    public String deptDoctor(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);

    	XPWDept dept = doctorAndDeptService.getDeptAndDoctorsById(id);
    	model.addAttribute("dept", dept);
        return "dept_doctor";
    }
    
    @RequestMapping(value = { "/deptDetail" }, method = RequestMethod.GET)
    public String deptDetail(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);

    	XPWDept dept = doctorAndDeptService.getDeptAndDoctorsById(id);
    	model.addAttribute("dept", dept);
//    	model.addAttribute("dept", doctor.getDept());
        return "dept_detail";
    }
}