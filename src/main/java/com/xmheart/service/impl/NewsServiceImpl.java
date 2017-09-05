package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.mapper.XPWNewsMediaArticleMapper;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleExample;
import com.xmheart.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	XPWNewsMediaArticleMapper xpwNewsMediaArticleMapper;

	@Override
	public List<XPWNewsMediaArticle> getPinnedMediaNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andIsPinnedEqualTo(true);
		
		List<XPWNewsMediaArticle> list = xpwNewsMediaArticleMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<XPWNewsMediaArticle> getNoPinnedMediaNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andIsPinnedEqualTo(false).andColumnNameEqualTo("媒体看厦心");
		
		List<XPWNewsMediaArticle> list = xpwNewsMediaArticleMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public XPWNewsMediaArticle getNewsByTitle(String title) {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andIdEqualTo((long) 781);
		XPWNewsMediaArticle article = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example).get(0);
		
		return article;
	}
	

}
