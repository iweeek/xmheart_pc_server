package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWNav;

public interface ColumnService {

	List<XPWColumn> getFirstColumns();

	List<XPWColumn> getChildColumns(String parent);

	List<XPWNav> getNavs();

}
