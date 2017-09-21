package com.xmheart.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "文章管理接口")
@Controller
public class ArticleController {
	
	@Autowired 
	ArticleService articleService;
	
    //TODO 这个接口要移到后台系统中去
	@ApiOperation(value = "创建一篇文章", notes = "创建一篇文章")
	@RequestMapping(value = { "/articles" }, method = RequestMethod.POST)
    public ResponseEntity<?> articles(@ApiParam("栏目Id，仅限于子栏目") @RequestParam Long columnId, 
            @ApiParam("文章标题") @RequestParam String title, @ApiParam("文章内容") @RequestParam String content, 
            @ApiParam("文章关键字") @RequestParam String tags, @ApiParam("文章摘要") @RequestParam String brief) {
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
	
    @ApiOperation(value = "更新一篇文章", notes = "更新一篇文章")
    @RequestMapping(value = { "/articles/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("栏目Id，仅限于子栏目") @RequestParam Long id,  
            @ApiParam("栏目Id，仅限于子栏目") @RequestParam Long columnId, 
            @ApiParam("文章标题") @RequestParam String title, @ApiParam("文章内容") @RequestParam String content, 
            @ApiParam("文章关键字") @RequestParam String tags, @ApiParam("文章摘要") @RequestParam String brief) {
        XPWArticleWithBLOBs article = new XPWArticleWithBLOBs();
        
        article.setColumnId(columnId);
        article.setImgUrl("");
        article.setIsPinned(false);
        article.setTags(tags);
        article.setTitle(title);
        article.setContent(content);
        
        int ret = articleService.update(article);
        if (ret > 0) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        }
    }
	


}
