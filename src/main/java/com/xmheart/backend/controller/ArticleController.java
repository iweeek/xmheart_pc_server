package com.xmheart.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.xmheart.model.XPWArticle;
import com.xmheart.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "文章管理接口")
@Controller
public class ArticleController {
	
	@Autowired 
	ArticleService articleService;
	
   @ApiOperation(value = "获取文章", notes = "获取文章")
    @RequestMapping(value = { "/articles" }, method = RequestMethod.GET)
    public ResponseEntity<?> index(@ApiParam("开始页号") @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @ApiParam("每页的数目") @RequestParam(required = false, defaultValue = "10") Integer pageSize, 
            @ApiParam("栏目Id") @RequestParam(required = false) Long columnId) {
        List<XPWArticle> list;
       
        PageHelper.startPage(pageNo, pageSize);
        
        if (columnId == null) {
            list = articleService.index();
        } else {
            list = articleService.index(columnId);
        }
        
        return ResponseEntity.ok(list);
        
    }
	
    //TODO 这个接口要移到后台系统中去
	@ApiOperation(value = "创建一篇文章", notes = "创建一篇文章")
	@RequestMapping(value = { "/articles" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("栏目Id，仅限于子栏目") @RequestParam Long columnId, 
            @ApiParam("文章标题") @RequestParam String title, @ApiParam("文章内容") @RequestParam String content, 
            @ApiParam("文章关键字") @RequestParam String tags, @ApiParam("文章摘要") @RequestParam String brief) {
		XPWArticle article = new XPWArticle();
		
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
    public ResponseEntity<?> update(@ApiParam("文章Id，必填") @PathVariable Long id,  
            @ApiParam("栏目Id，仅限于子栏目，可选") @RequestParam(required = false) Long columnId, 
            @ApiParam("文章配图，可选") @RequestParam(required = false) String imgUrl, 
            @ApiParam("文章是否置顶，可选") @RequestParam(required = false) Boolean isPinned, 
            @ApiParam("文章关键字，可选") @RequestParam(required = false) String tags, 
            @ApiParam("文章标题，可选") @RequestParam(required = false) String title, 
            @ApiParam("文章摘要，可选") @RequestParam(required = false) String brief,
            @ApiParam("文章内容，可选") @RequestParam(required = false) String content) {
        
        XPWArticle article = new XPWArticle();
        article.setId(id);
        if (columnId != null) {
            article.setColumnId(columnId);
        }
        
        if (imgUrl != null) {
            article.setImgUrl(imgUrl);
        }
        
        if (isPinned != null) {
            article.setIsPinned(isPinned);
        }
        
        if (tags != null) {
            article.setTags(tags);
        }
        
        if (title != null) {
            article.setTitle(title);
        }
        
        if (brief != null) {
            article.setBrief(brief);
        }
        
        if (content != null) {
            article.setContent(content);
        }
        
        int ret = articleService.update(article);
        if (ret > 0) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        }
    }
    
    @ApiOperation(value = "获取一篇文章", notes = "获取一篇文章")
    @RequestMapping(value = { "/articles/{id}" }, method = RequestMethod.GET)
    public ResponseEntity<?> read(@ApiParam("文章Id，必填") @PathVariable Long id) {
        
        XPWArticle article = new XPWArticle();
        
        article.setId(id);
        
        article = articleService.read(article);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        }
    }
	


}
