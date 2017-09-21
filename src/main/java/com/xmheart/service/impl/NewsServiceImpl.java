package com.xmheart.service.impl;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWArticleMapper;
import com.xmheart.mapper.XPWElecNewspaperMapper;
import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleExample;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWElecNewspaperExample;
import com.xmheart.model.XPWElecNewspaperExample.Criteria;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.service.NewsService;

import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@Service
public class NewsServiceImpl implements NewsService {

	static final long MEDIA_NEWS_COLUMN_ID = 20;
	static final long HOSPITAL_NEWS_COLUMN_ID = 21;
	static final long ELEC_NEWS_COLUMN_ID = 23;

	@Autowired
	XPWArticleMapper xpwArticleMapper;
	@Autowired
	XPWElecNewspaperMapper xpwElecNewspaperMapper;

	@Override
	public List<XPWArticleWithBLOBs> getPinnedMediaNews() {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andColumnIdEqualTo(MEDIA_NEWS_COLUMN_ID).andIsPinnedEqualTo(true);

		List<XPWArticleWithBLOBs> list = xpwArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public List<XPWArticleWithBLOBs> getNoPinnedMediaNews() {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andColumnIdEqualTo(MEDIA_NEWS_COLUMN_ID).andIsPinnedEqualTo(false);

		List<XPWArticleWithBLOBs> list = xpwArticleMapper.selectByExampleWithBLOBs(example);

		return list;
	}

	@Override
	public List<XPWArticleWithBLOBs> getPinnedHospitalNews() {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andColumnIdEqualTo(HOSPITAL_NEWS_COLUMN_ID).andIsPinnedEqualTo(true);

		List<XPWArticleWithBLOBs> list = xpwArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public List<XPWArticleWithBLOBs> getNoPinnedHospitalNews() {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andColumnIdEqualTo(HOSPITAL_NEWS_COLUMN_ID).andIsPinnedEqualTo(false);

		List<XPWArticleWithBLOBs> list = xpwArticleMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public XPWArticle getNewsByTitle(String title) {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andTitleEqualTo(title);
		XPWArticle article = xpwArticleMapper.selectByExampleWithBLOBs(example).get(0);

		return article;
	}

	@Override
	public XPWArticleWithBLOBs getNewsById(Long id) {
		XPWArticleExample example = new XPWArticleExample();
		example.createCriteria().andIdEqualTo(id);
		XPWArticleWithBLOBs article = xpwArticleMapper.selectByExampleWithBLOBs(example).get(0);

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
	public List<String> getNewsPaperYears() {
		List<String> list = xpwElecNewspaperMapper.getNewsPaperYears();
		return list;
	}

	@Override
	public List<XPWArticleWithBLOBs> getNews() {
		List<XPWArticleWithBLOBs> list = xpwArticleMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public List<String> getNewsPaperTimes(String year) {
		List<String> list = xpwElecNewspaperMapper.getNewsPaperTimes(year);
		return list;
	}
		@Override
	public int updateNews(XPWArticleWithBLOBs news) {
		int ret = xpwArticleMapper.updateByPrimaryKeyWithBLOBs(news);
		return ret;
	}

}
