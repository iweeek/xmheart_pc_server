package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;

public interface DoctorAndDeptService {

	List<XPWDoctor> getDoctors();

	List<XPWDept> getOutServiceDepts();

	XPWDoctor getDoctorAndDeptById(Long id);

	XPWDept getDeptAndDoctorsById(Long id);

}
