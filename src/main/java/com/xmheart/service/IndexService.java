package com.xmheart.service;

import com.xmheart.model.XPWIndex;


/**
 * The Interface IndexService.
 * 首页相关接口
 */
public interface IndexService {

    XPWIndex read();

    int update(XPWIndex index);

}
