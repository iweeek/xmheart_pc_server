package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWDeptMapper;
import com.xmheart.mapper.XPWDoctorMapper;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWDoctorExample;
import com.xmheart.service.ExpertAndDeptService;

@Service
public class ExpertAndDeptServiceImpl implements ExpertAndDeptService {
	
	@Autowired
	private XPWDoctorMapper xpwDoctorMapper;
	
	@Autowired
	private XPWDeptMapper xpwDeptMapper;

	@Override
	public List<XPWDoctor> getDoctors() {
		List<XPWDoctor> list = xpwDoctorMapper.selectByExample(null);
		return list;
	}

	@Override
	public List<XPWDept> getDepts() {
		List<XPWDept> list = xpwDeptMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public XPWDoctor getDoctorAndDeptById(Long id) {
		XPWDoctor doctor = xpwDoctorMapper.selectDoctorWithDeptByPrimaryKey(id);
		return doctor;
	}

	@Override
	public XPWDept getDeptAndDoctorsById(Long id) {
		XPWDept dept = xpwDeptMapper.selectDeptWithDoctorsByPrimaryKey(id);
		return dept;
	}

}
