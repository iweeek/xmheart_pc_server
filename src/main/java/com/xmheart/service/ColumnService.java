package com.xmheart.service;

import java.util.List;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWNav;

public interface ColumnService {

	List<XPWColumn> getFirstColumns();

	List<XPWColumn> getChildColumnsById(long id);

	List<XPWNav> getChildNavsById(long id);

	List<XPWNav> getNavListBySecondColumnName(String name);

	List<XPWNav> getChildNavsByTitle(String title);

	int createNav(XPWNav nav);

	int updateNav(XPWNav nav);
}
