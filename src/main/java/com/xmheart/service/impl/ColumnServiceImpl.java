package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWColumnMapper;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnExample;
import com.xmheart.service.ColumnService;

@Service
public class ColumnServiceImpl implements ColumnService {
	
	@Autowired 
	private XPWColumnMapper xpwColumnMapper;

	@Override
	public List<XPWColumn> getFirstColumn() {
		XPWColumnExample example = new XPWColumnExample();
		example.createCriteria().andParentColumnNameEqualTo("");
		List<XPWColumn> list = xpwColumnMapper.selectByExample(example);
		return list;
	}

}
