package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWColumnMapper;
import com.xmheart.mapper.XPWNavMapper;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnExample;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWNavExample;
import com.xmheart.service.ColumnService;

@Service
public class ColumnServiceImpl implements ColumnService {
	
	@Autowired 
	private XPWColumnMapper xpwColumnMapper;
	
	@Autowired 
	private XPWNavMapper xpwNavMapper;

	@Override
	public List<XPWColumn> getFirstColumns() {
		XPWColumnExample example = new XPWColumnExample();
		example.createCriteria().andParentColumnIdEqualTo(0l);
		List<XPWColumn> list = xpwColumnMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<XPWColumn> getChildColumnsById(long id) {
		XPWColumnExample example = new XPWColumnExample();
		example.createCriteria().andParentColumnIdEqualTo(id);
		List<XPWColumn> list = xpwColumnMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<XPWNav> getChildNavsById(long id) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andColumnIdEqualTo(id);
		List<XPWNav> list = xpwNavMapper.selectByExample(example);
		return list;
	}

}
