package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWArticle;


/**
 * The Interface NewsService.
 * 用于处理文章相关
 */
public interface ArticleService {

	int create(XPWArticle article);

    int update(XPWArticle article);

    List<XPWArticle> show(String keyword);

    List<XPWArticle> index();

    List<XPWArticle> index(Long columnId);

    XPWArticle read(XPWArticle article);

    List<XPWArticle> index(Long columnId, boolean isPublished);

    List<XPWArticle> index(Long columnId, boolean isPublished, boolean isPinned);

    int swapPinOrder(Long articleId1, Long articleId2);


}
