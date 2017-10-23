package com.xmheart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWElecNewspaperMapper;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.service.NewspaperService;

@Service
public class NewspaperServiceImpl implements NewspaperService {

    @Autowired
    XPWElecNewspaperMapper newspaperMapper;
    
    @Override
    public int create(XPWElecNewspaper newspaper) {
        int ret = newspaperMapper.insert(newspaper);
        return ret;
    }

    @Override
    public int update(XPWElecNewspaper newspaper) {
        int ret = newspaperMapper.updateByPrimaryKeySelective(newspaper);
        return ret;
    }
	
}
