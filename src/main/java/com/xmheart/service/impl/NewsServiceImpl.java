package com.xmheart.service.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWElecNewspaperMapper;
import com.xmheart.mapper.XPWNewsMediaArticleMapper;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWElecNewspaperExample;
import com.xmheart.model.XPWElecNewspaperExample.Criteria;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleExample;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;
import com.xmheart.service.NewsService;

import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@Service
public class NewsServiceImpl implements NewsService {

	static final long MEDIA_NEWS_COLUMN_ID = 20;
	static final long HOSPITAL_NEWS_COLUMN_ID = 21;
	static final long ELEC_NEWS_COLUMN_ID = 23;

	@Autowired
	XPWNewsMediaArticleMapper xpwNewsMediaArticleMapper;
	@Autowired
	XPWElecNewspaperMapper xpwElecNewspaperMapper;

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

	@Override
	public XPWNewsMediaArticle getNewsByTitle(String title) {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andTitleEqualTo(title);
		XPWNewsMediaArticle article = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example).get(0);

		return article;
	}

	@Override
	public XPWNewsMediaArticleWithBLOBs getNewsById(Long id) {
		XPWNewsMediaArticleExample example = new XPWNewsMediaArticleExample();
		example.createCriteria().andIdEqualTo(id);
		XPWNewsMediaArticleWithBLOBs article = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(example).get(0);

		return article;
	}

	@Override
	public List<XPWElecNewspaper> getElecNewsPaper(String year, String time) {
		XPWElecNewspaperExample example = new XPWElecNewspaperExample();
		Criteria criteria = example.createCriteria();
		if (year != "") {
			criteria.andYearsEqualTo(year);
		}
		if (time != "") {
			criteria.andTimesEqualTo(time);
		}
		List<XPWElecNewspaper> list = xpwElecNewspaperMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<String> getNewPaperYears() {
		List<String> list = xpwElecNewspaperMapper.getNewsPaperYears();
		return list;
	}
	
	@Override
	public List<XPWNewsMediaArticleWithBLOBs> getNews() {
		List<XPWNewsMediaArticleWithBLOBs> list = xpwNewsMediaArticleMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public List<String> getNewsPaperTimes(String year) {
		List<String> list = xpwElecNewspaperMapper.getNewsPaperTimes(year);
		return list;
	}
		@Override
	public int updateNews(XPWNewsMediaArticleWithBLOBs news) {
		int ret = xpwNewsMediaArticleMapper.updateByPrimaryKeyWithBLOBs(news);
		return ret;
	}

}
