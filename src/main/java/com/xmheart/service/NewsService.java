package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;

public interface NewsService {

	List<XPWNewsMediaArticleWithBLOBs> getPinnedMediaNews();

	List<XPWNewsMediaArticleWithBLOBs> getNoPinnedMediaNews();

	List<XPWNewsMediaArticleWithBLOBs> getPinnedHospitalNews();

	List<XPWNewsMediaArticleWithBLOBs> getNoPinnedHospitalNews();
	
	XPWNewsMediaArticle getNewsByTitle(String title);

	XPWNewsMediaArticleWithBLOBs getNewsById(Long id);

	List<XPWElecNewspaper> getElecNewsPaper();

	List<XPWNewsMediaArticleWithBLOBs> getNews();

	int updateNews(XPWNewsMediaArticleWithBLOBs news);
}
