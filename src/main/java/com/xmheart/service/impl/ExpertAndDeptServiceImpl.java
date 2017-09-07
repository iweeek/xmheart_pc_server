package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWDeptMapper;
import com.xmheart.mapper.XPWExpertMapper;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWExpert;
import com.xmheart.model.XPWExpertExample;
import com.xmheart.service.ExpertAndDeptService;

@Service
public class ExpertAndDeptServiceImpl implements ExpertAndDeptService {
	
	@Autowired
	private XPWExpertMapper xpwExpertMapper;
	
	@Autowired
	private XPWDeptMapper xpwDeptMapper;

	@Override
	public List<XPWExpert> getExperts() {
		List<XPWExpert> list = xpwExpertMapper.selectByExample(null);
		return list;
	}

	@Override
	public List<XPWDept> getDepts() {
		List<XPWDept> list = xpwDeptMapper.selectByExample(null);
		return list;
	}

}
