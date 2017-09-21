package com.xmheart.service;

import com.xmheart.model.XPWArticleWithBLOBs;


/**
 * The Interface NewsService.
 * 用于处理文章相关
 */
public interface ArticleService {

	int create(XPWArticleWithBLOBs article);

    int update(XPWArticleWithBLOBs article);


}
