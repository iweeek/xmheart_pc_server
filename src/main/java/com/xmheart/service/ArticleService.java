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

    XPWArticle read(Long id);

    List<XPWArticle> index(Long columnId, boolean isPublished);

    List<XPWArticle> index(Long columnId, boolean isPublished, boolean isPinned);

    int swapPinOrder(Long articleId1, Long articleId2);

    List<XPWArticle> show(Long columnId, String keyword);

    List<XPWArticle> showByColNameAndKey(String columnName, String keyword);

    Byte getMaxPinOrder();
}
