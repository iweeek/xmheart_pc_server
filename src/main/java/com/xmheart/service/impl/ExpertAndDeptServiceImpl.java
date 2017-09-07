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
	private XPWDoctorMapper XPWDoctorMapper;
	
	@Autowired
	private XPWDeptMapper xpwDeptMapper;

	@Override
	public List<XPWDoctor> getDoctors() {
		List<XPWDoctor> list = XPWDoctorMapper.selectByExample(null);
		return list;
	}

	@Override
	public List<XPWDept> getDepts() {
		List<XPWDept> list = xpwDeptMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public XPWDoctor getDoctorById(Long id) {
		XPWDoctor doctor = XPWDoctorMapper.selectByPrimaryKey(id);
		return doctor;
	}

}
