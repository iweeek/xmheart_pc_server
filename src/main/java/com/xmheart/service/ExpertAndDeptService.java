package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWExpert;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;

public interface ExpertAndDeptService {

	List<XPWExpert> getExperts();

	List<XPWDept> getDepts();

}
