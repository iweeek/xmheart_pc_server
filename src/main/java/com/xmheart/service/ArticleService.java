package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleWithBLOBs;


/**
 * The Interface NewsService.
 * 用于处理文章相关
 */
public interface ArticleService {

	int create(XPWArticleWithBLOBs article);

    int update(XPWArticleWithBLOBs article);

    List<XPWArticle> show(String keyword);

    List<XPWArticle> index();


}
