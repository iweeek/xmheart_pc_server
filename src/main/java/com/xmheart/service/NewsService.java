package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.model.XPWElecNewspaper;

public interface NewsService {

	List<XPWArticleWithBLOBs> getPinnedMediaNews();

	List<XPWArticleWithBLOBs> getNoPinnedMediaNews();

	List<XPWArticleWithBLOBs> getPinnedHospitalNews();

	List<XPWArticleWithBLOBs> getNoPinnedHospitalNews();

	XPWArticle getNewsByTitle(String title);

	XPWArticleWithBLOBs getNewsById(Long id);

	List<XPWElecNewspaper> getElecNewsPaper(String year, String time);

	List<String> getNewPaperYears();

	List<String> getNewsPaperTimes(String year);

	List<XPWArticleWithBLOBs> getNews();

	int updateNews(XPWArticleWithBLOBs news);

}
