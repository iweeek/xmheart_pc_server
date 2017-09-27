package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;

public interface DoctorAndDeptService {

	List<XPWDoctor> getDoctors();

	List<XPWDept> getOutServiceDepts();

	XPWDoctor getDoctorAndDeptById(Long id);

	XPWDept getDeptAndDoctorsById(Long id);

    List<XPWDoctor> getDoctorsByDeptId(Long deptId);

    XPWDoctor getDoctorById(Long id);

    int update(XPWDoctor doctor);

    int create(XPWDoctor doctor);

}
