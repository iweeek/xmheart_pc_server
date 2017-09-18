package com.xmheart.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.service.ArticleService;

public class BackendController {
	
	@Autowired 
	ArticleService articleService;
    //TODO 这个接口要移到后台系统中去
	@RequestMapping(value = { "/articles" }, method = RequestMethod.POST)
    public ResponseEntity<?> articles(@RequestParam Long columnId, @RequestParam String title, @RequestParam String content, 
    		@RequestParam String tags, @RequestParam String brief, Model model) {
		XPWArticleWithBLOBs article = new XPWArticleWithBLOBs();
		
		article.setColumnId(columnId);
		article.setImgUrl("");
		article.setIsPinned(false);
		article.setTags(tags);
		article.setTitle(title);
		article.setContent(content);
		
		int ret = articleService.create(article);
		if (ret > 0) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
		}
    }

}
