package com.xmheart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWArticleMapper;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	XPWArticleMapper articleMapper;

	@Override
	public int create(XPWArticleWithBLOBs article) {
		int ret = articleMapper.insert(article);
		return ret;
	}

    @Override
    public int update(XPWArticleWithBLOBs article) {
        int ret = articleMapper.updateByPrimaryKeyWithBLOBs(article);
        return ret;
    }



}
