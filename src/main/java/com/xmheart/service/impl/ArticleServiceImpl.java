package com.xmheart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmheart.mapper.XPWArticleMapper;
import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleExample;
import com.xmheart.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	XPWArticleMapper articleMapper;

	@Override
	public int create(XPWArticle article) {
		int ret = articleMapper.insert(article);
		return ret;
	}

    @Override
    public int update(XPWArticle article) {
        int ret = articleMapper.updateByPrimaryKeySelective(article);
        return ret;
    }

    @Override
    public List<XPWArticle> show(String keyword) {
        XPWArticleExample example = new XPWArticleExample();
        example.createCriteria().andTitleLike("%" + keyword + "%");
        List<XPWArticle> list = articleMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<XPWArticle> index() {
        XPWArticleExample example = new XPWArticleExample();
        example.setOrderByClause("is_pinned desc, pin_order asc, publish_time desc");
        List<XPWArticle> list = articleMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<XPWArticle> index(Long columnId) {
        XPWArticleExample example = new XPWArticleExample();
        example.createCriteria().andColumnIdEqualTo(columnId);
        example.setOrderByClause("is_pinned desc, pin_order asc, publish_time desc");
        List<XPWArticle> list = articleMapper.selectByExample(example);
        return list;
    }

    @Override
    public XPWArticle read(XPWArticle article) {
        XPWArticleExample example = new XPWArticleExample();
        example.createCriteria().andIdEqualTo(article.getId());
        List<XPWArticle> list = articleMapper.selectByExampleWithBLOBs(example);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public List<XPWArticle> index(Long columnId, boolean isPublished) {
        XPWArticleExample example = new XPWArticleExample();
        example.createCriteria().andIsPublishedEqualTo(isPublished).andColumnIdEqualTo(columnId);
        example.setOrderByClause("is_pinned desc, pin_order asc, publish_time desc");
        List<XPWArticle> list = articleMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<XPWArticle> index(Long columnId, boolean isPublished, boolean isPinned) {
        XPWArticleExample example = new XPWArticleExample();
        example.createCriteria().andIsPublishedEqualTo(isPublished).andColumnIdEqualTo(columnId).andIsPinnedEqualTo(isPinned);
        example.setOrderByClause("pin_order asc");
        List<XPWArticle> list = articleMapper.selectByExample(example);
        return list;
    }

    @Override
    public int swapPinOrder(Long articleId1, Long articleId2) {
        XPWArticle article1 = articleMapper.selectByPrimaryKey(articleId1);
        XPWArticle article2 = articleMapper.selectByPrimaryKey(articleId2);
        
        //只有置顶的文章才可以交换pinOrder
        if (!article1.getIsPinned() || !article2.getIsPinned()) {
            return -1;
        }
        
        Byte order1 = article1.getPinOrder();
        article1.setPinOrder(article2.getPinOrder());
        articleMapper.updateByPrimaryKey(article1);
        
        article2.setPinOrder(order1);
        articleMapper.updateByPrimaryKey(article2);
        
        return 0;
    }



}
