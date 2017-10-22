package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWVideo;


/**
 * The Interface NewsService.
 * 用于处理文章相关
 */
public interface VideoService {

    int create(XPWVideo video);

    int update(XPWVideo video);

}