package com.xmheart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWIndexMapper;
import com.xmheart.model.XPWIndex;
import com.xmheart.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    XPWIndexMapper indexMapper;
    
    @Override
    public XPWIndex read() {
        XPWIndex index = indexMapper.selectByExample(null).get(0);
        return index;
    }

    @Override
    public int update(XPWIndex index) {
        int ret = indexMapper.updateByPrimaryKey(index);
        return ret;
    }
	

}
