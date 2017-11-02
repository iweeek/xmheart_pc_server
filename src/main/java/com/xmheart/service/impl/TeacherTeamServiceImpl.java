package com.xmheart.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWDeptMapper;
import com.xmheart.mapper.XPWDoctorMapper;
import com.xmheart.mapper.XPWTeacherMapper;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDeptExample;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWDoctorExample;
import com.xmheart.model.XPWTeacher;
import com.xmheart.model.XPWTeacherExample;
import com.xmheart.service.DoctorAndDeptService;
import com.xmheart.service.TeacherTeamService;

@Service
public class TeacherTeamServiceImpl implements TeacherTeamService {
	
	@Autowired
	private XPWTeacherMapper xpwTeacherMapper;
	
	@Autowired
	private XPWDeptMapper xpwDeptMapper;

	@Override
	public List<XPWTeacher> getDisplayTeachers() {
	    XPWTeacherExample example = new XPWTeacherExample();
	    example.createCriteria().andIsDisplayedEqualTo(true);
		List<XPWTeacher> list = xpwTeacherMapper.selectByExample(example);
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
	public XPWTeacher getTeacherAndDeptById(Long id) {
		XPWTeacher teacher = xpwTeacherMapper.selectTeacherWithDeptByPrimaryKey(id);
		return teacher;
	}

	@Override
	public XPWDept getDeptAndTeachersById(Long id) {
		XPWDept dept = xpwDeptMapper.selectDeptWithTeachersByPrimaryKey(id);
		return dept;
	}

    @Override
    public List<XPWTeacher> getTeachersByDeptId(Long deptId) {
        XPWTeacherExample example = new XPWTeacherExample();
        example.createCriteria().andDeptIdEqualTo(deptId);
        
        List<XPWTeacher> list = xpwTeacherMapper.selectByExample(example);
        return list;
    }

    @Override
    public XPWTeacher getTeacherById(Long id) {
        XPWTeacher teacher = xpwTeacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    @Override
    public int updateTeacher(XPWTeacher teacher) {
        int ret = xpwTeacherMapper.updateByPrimaryKeySelective(teacher);
        return ret;
    }

    @Override
    public int createTeacher(XPWTeacher teacher) {
        int ret = xpwTeacherMapper.insertSelective(teacher);
        return ret;
    }

    @Override
    public List<XPWDept> getDepts() {
        List<XPWDept> list = xpwDeptMapper.selectByExampleWithBLOBs(null);
        return list;
    }

    @Override
    public XPWDept getDeptById(Long id) {
        XPWDept dept = xpwDeptMapper.selectByPrimaryKey(id);
        return dept;
    }

    @Override
    public int updateDept(XPWDept dept) {
        int ret = xpwDeptMapper.updateByPrimaryKeySelective(dept);
        return ret;
    }

    @Override
    public int createDept(XPWDept dept) {
        int ret = xpwDeptMapper.insertSelective(dept);
        return ret;
    }

}
