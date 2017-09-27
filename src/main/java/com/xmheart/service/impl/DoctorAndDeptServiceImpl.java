package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWDeptMapper;
import com.xmheart.mapper.XPWDoctorMapper;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDeptExample;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWDoctorExample;
import com.xmheart.service.DoctorAndDeptService;

@Service
public class DoctorAndDeptServiceImpl implements DoctorAndDeptService {
	
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
	public List<XPWDept> getOutServiceDepts() {
	    XPWDeptExample example = new XPWDeptExample();
	    example.createCriteria().andOutServiceEqualTo(true);
		List<XPWDept> list = xpwDeptMapper.selectByExampleWithBLOBs(example);
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

    @Override
    public List<XPWDoctor> getDoctorsByDeptId(Long deptId) {
        XPWDoctorExample example = new XPWDoctorExample();
        example.createCriteria().andDeptIdEqualTo(deptId);
        
        List<XPWDoctor> list = xpwDoctorMapper.selectByExample(example);
        return list;
    }

    @Override
    public XPWDoctor getDoctorById(Long id) {
        XPWDoctor doctor = xpwDoctorMapper.selectByPrimaryKey(id);
        return doctor;
    }

    @Override
    public int update(XPWDoctor doctor) {
        int ret = xpwDoctorMapper.updateByPrimaryKeySelective(doctor);
        return ret;
    }

    @Override
    public int create(XPWDoctor doctor) {
        int ret = xpwDoctorMapper.insertSelective(doctor);
        return ret;
    }

}
