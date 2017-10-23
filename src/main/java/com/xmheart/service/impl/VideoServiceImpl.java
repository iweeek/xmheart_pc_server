package com.xmheart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWVideoMapper;
import com.xmheart.model.XPWVideo;
import com.xmheart.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    XPWVideoMapper videoMapper;
    
    @Override
    public int create(XPWVideo video) {
        int ret = videoMapper.insert(video);
        return ret;
    }
    
    @Override
    public int update(XPWVideo video) {
        int ret = videoMapper.updateByPrimaryKeySelective(video);
        return ret;
    }
	
}
