package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;

public interface ExpertAndDeptService {

	List<XPWDoctor> getDoctors();

	List<XPWDept> getDepts();

	XPWDoctor getDoctorAndDeptById(Long id);

}
