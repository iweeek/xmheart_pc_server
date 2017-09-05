package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWNewsMediaArticleMapper;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleExample;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;
import com.xmheart.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	static final long MEDIA_NEWS_COLUMN_ID = 20;
	static final long HOSPITAL_NEWS_COLUMN_ID = 21;
	
	@Autowired
	XPWNewsMediaArticleMapper xpwNewsMediaArticleMapper;

	@Override
	public List<XPWNewsMediaArticleWithBLOBs> getPinnedMediaNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andColumnIdEqualTo(MEDIA_NEWS_COLUMN_ID).andIsPinnedEqualTo(true);
		
		List<XPWNewsMediaArticleWithBLOBs> list = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public List<XPWNewsMediaArticleWithBLOBs> getNoPinnedMediaNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andColumnIdEqualTo(MEDIA_NEWS_COLUMN_ID).andIsPinnedEqualTo(false);
		
		List<XPWNewsMediaArticleWithBLOBs> list = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	@Override
	public XPWNewsMediaArticle getNewsByTitle(String title) {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andIdEqualTo((long) 781);
		XPWNewsMediaArticle article = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example).get(0);
		
		return article;
	}

	@Override
	public List<XPWNewsMediaArticleWithBLOBs> getPinnedHospitalNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andColumnIdEqualTo(HOSPITAL_NEWS_COLUMN_ID).andIsPinnedEqualTo(true);
		
		List<XPWNewsMediaArticleWithBLOBs> list = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public List<XPWNewsMediaArticleWithBLOBs> getNoPinnedHospitalNews() {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andColumnIdEqualTo(HOSPITAL_NEWS_COLUMN_ID).andIsPinnedEqualTo(false);
		
		List<XPWNewsMediaArticleWithBLOBs> list = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}
	

}
