package com.xmheart.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWColumnMapper;
import com.xmheart.mapper.XPWIndexMapper;
import com.xmheart.mapper.XPWNavMapper;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnExample;
import com.xmheart.model.XPWIndex;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWNavExample;
import com.xmheart.service.ColumnService;

@Service
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private XPWColumnMapper xpwColumnMapper;

	@Autowired
	private XPWNavMapper xpwNavMapper;
	
	@Autowired
	private XPWIndexMapper xpwIndexMapper;

	private int getLanguage() {
		XPWIndex index = xpwIndexMapper.selectByPrimaryKey((long) 1);
		return index.getLanguage();
	}
	
	@Override
	public List<XPWColumn> getTopFirstColumns() {
		XPWColumnExample example = new XPWColumnExample();
		example.createCriteria().andParentColumnIdEqualTo(0l).andPositionEqualTo(false);
		List<XPWColumn> list = null;
		if (getLanguage() == 1) {
			list = xpwColumnMapper.selectAllEnglishColumns();
		} else {
			list = xpwColumnMapper.selectByExample(example);
		}
		return list;
	}

	@Override
	public List<XPWColumn> getChildColumnsById(long id) {
		XPWColumnExample example = new XPWColumnExample();
		example.createCriteria().andParentColumnIdEqualTo(id);
		List<XPWColumn> list = null;
		if (getLanguage() == 1) {
			list = xpwColumnMapper.selectAllEnglishColumnsByParentColumnId(id);
		} else {
			list = xpwColumnMapper.selectByExample(example);
		}
		return list;
	}

	@Override
	public List<XPWNav> getNavsByColumnId(long id) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andColumnIdEqualTo(id);
		List<XPWNav> list = null;
		if (getLanguage() == 1) {
			list = xpwNavMapper.selectEnglishByColumnId(id);
		} else {
			list = xpwNavMapper.selectByExample(example);
		}
		return list;
	}
	
    @Override
    public List<XPWNav> getNavsByChildColumnIdOrderByPublishTime(long id) {
        XPWNavExample example = new XPWNavExample();
        example.createCriteria().andChildColumnIdEqualTo(id);
        List<XPWNav> list = xpwNavMapper.selectByExample(example);
        return list;
    }

	@Override
	public List<XPWNav> getNavListBySecondColumnName(String name) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andChildColumnNameEqualTo(name);
		List<XPWNav> list = xpwNavMapper.selectByExample(example);
		return list;
	}

	@Override
	public int createNav(XPWNav nav) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria()
			   .andChildColumnNameEqualTo(nav.getChildColumnName())
			   .andArticleTitleEqualTo(nav.getArticleTitle());
		List<XPWNav> list = xpwNavMapper.selectByExample(example);
		if (list.size() > 0) {
			// 已经存在
			return HttpServletResponse.SC_CONFLICT;
		} else {
			int result = xpwNavMapper.insertSelective(nav);
			if (result > 0) {
				return HttpServletResponse.SC_OK;
			} else {
				return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			}
		}
	}

	@Override
	public int updateNav(XPWNav nav) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andIdEqualTo(nav.getId());
		List<XPWNav> list = xpwNavMapper.selectByExample(example);
		if (list.size() > 0) {
			xpwNavMapper.updateByPrimaryKeySelective(nav);
			return HttpServletResponse.SC_OK;
		} else {
			return HttpServletResponse.SC_NOT_FOUND;
		}
	}
	
   @Override
    public int updateNavByExample(XPWNav nav) {
//        XPWNavExample example = new XPWNavExample();
//        example.createCriteria().andIdEqualTo(nav.getId());
//        List<XPWNav> list = xpwNavMapper.selectByExample(example);
        int ret = xpwNavMapper.updateByPrimaryKey(nav);
        if (ret > 0) {
            return HttpServletResponse.SC_OK;
        } else {
            return HttpServletResponse.SC_NOT_FOUND;
        }
    }
	
    @Override
    public List<XPWColumn> getColumns() {
        List<XPWColumn> list = xpwColumnMapper.selectByExample(null);
        return list;
    }

    @Override
    public List<XPWColumn> getColumnsByParentId(Long parentColumnId) {
        XPWColumnExample example = new XPWColumnExample();
        example.createCriteria().andParentColumnIdEqualTo(parentColumnId);
        List<XPWColumn> list = xpwColumnMapper.selectByExample(example);
        return list;
    }

    @Override
    public XPWColumn getColumnById(Long id) {
    		XPWColumn column = null;
    		if (getLanguage() == 1) {
    			column = xpwColumnMapper.selectEnglishByPrimaryKey(id);
    		} else {
    			column = xpwColumnMapper.selectByPrimaryKey(id);
    		}
        return column;
    }

    @Override
    public int updateColumn(XPWColumn column) {
        int ret = xpwColumnMapper.updateByPrimaryKeySelective(column);
        return ret;
    }

    @Override
    public XPWColumn getParentColumnById(long id) {
        long parentId = xpwColumnMapper.selectByPrimaryKey(id).getParentColumnId();
        XPWColumn column = null;
        if (getLanguage() == 1) {
        		column = xpwColumnMapper.selectEnglishByPrimaryKey(parentId);
		} else {
			column = xpwColumnMapper.selectByPrimaryKey(parentId);
		}
        return column;
    }

    @Override
    public List<XPWColumn> readSubColumn(Long id) {
        XPWColumnExample example = new XPWColumnExample();
        example.createCriteria().andParentColumnIdEqualTo(id);
        List<XPWColumn> list = xpwColumnMapper.selectByExample(example);
        return list;
    }
    
	@Override
	public List<XPWNav> getNavsByChildColumnName(String childColumnName) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andChildColumnNameEqualTo(childColumnName);
		List<XPWNav> list = xpwNavMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public List<XPWNav> getNavsByChildColumnId(Long id) {
		XPWNavExample example = new XPWNavExample();
		example.createCriteria().andChildColumnIdEqualTo(id);
		List<XPWNav> list = null;
		if (getLanguage() == 1) {
			list = xpwNavMapper.selectEnglishByChildColumnId(id);
		} else {
			list = xpwNavMapper.selectByExample(example);
		}
		
		return list;
	}

	@Override
	public XPWNav getNavById(Long id) {
		XPWNav nav = xpwNavMapper.selectByPrimaryKey(id);
        return nav;
	}

    @Override
    public List<XPWNav> getNavList() {
        List<XPWNav> list = xpwNavMapper.selectByExample(null);
        return list;
    }

}
