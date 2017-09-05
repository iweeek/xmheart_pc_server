package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;

public interface NewsService {

	List<XPWNewsMediaArticleWithBLOBs> getPinnedMediaNews();

	List<XPWNewsMediaArticleWithBLOBs> getNoPinnedMediaNews();

	XPWNewsMediaArticle getNewsByTitle(String title);

	List<XPWNewsMediaArticleWithBLOBs> getPinnedHospitalNews();

	List<XPWNewsMediaArticleWithBLOBs> getNoPinnedHospitalNews();

}
