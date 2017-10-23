package com.xmheart.service;

import com.xmheart.model.XPWElecNewspaper;


/**
 * The Interface NewsService.
 * 用于处理院报相关
 */
public interface NewspaperService {

    int create(XPWElecNewspaper newspaper);

    int update(XPWElecNewspaper newspaper);

}
