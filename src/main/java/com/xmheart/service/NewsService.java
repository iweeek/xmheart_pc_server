package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWNewsMediaArticle;

public interface NewsService {

	List<XPWNewsMediaArticle> getPinnedMediaNews();

	List<XPWNewsMediaArticle> getNoPinnedMediaNews();

	XPWNewsMediaArticle getNewsByTitle(String title);

	List<XPWNewsMediaArticle> getPinnedHospitalNews();

	List<XPWNewsMediaArticle> getNoPinnedHospitalNews();

}
