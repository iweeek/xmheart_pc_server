package com.xmheart.backend.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.xmheart.model.XPWArticle;
import com.xmheart.service.ArticleService;
import com.xmheart.service.ColumnService;
import com.xmheart.util.FileUtil;
import com.xmheart.util.PathUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "文章管理接口")
@Controller
public class ArticleController {
	
	@Autowired 
	ArticleService articleService;
	
    @Autowired
    private ColumnService columnService;
	
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
    public ResponseEntity<?> create(@ApiParam("子栏目Id，必填") @RequestParam Long columnId, 
            @ApiParam("文章标题，必填") @RequestParam String title, 
            @ApiParam("文章配图，可选") @RequestParam(required = false) String imgUrl, 
            @ApiParam("文章关键字，可选") @RequestParam(required = false) String tags, 
            @ApiParam("文章摘要，可选") @RequestParam(required = false) String brief, 
            @ApiParam("文章内容，可选") @RequestParam(required = false) String content) {
		XPWArticle article = new XPWArticle();
		
		article.setColumnId(columnId);
		String columnName = columnService.getColumnById(columnId).getColumnName();
		article.setColumnName(columnName);
		article.setTitle(title);
		
		if (imgUrl != null) {
		    article.setImgUrl(imgUrl);
		} else {
		    article.setImgUrl("");
		}
		
		//创建的时候不设置这几项
		article.setIsPinned(false);
		article.setIsPublished(false);
		article.setUrl("");
		article.setPinOrder((byte) 0);
		
		if (tags != null) {
		    article.setTags(tags);
		} else {
		   article.setTags("");
		}
		
		if (brief != null) {
		    article.setBrief(brief);
		} else {
		    article.setBrief("");
		}
		
		if (content != null) {
		    article.setContent(content);
		} else {
		    article.setContent("");
		}
		
		int ret = articleService.create(article);
		if (ret > 0) {
		    article.setUrl("/newsDetail?id=" + String.valueOf(article.getId()));
		    articleService.update(article);
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
		}
    }
	
	@ApiOperation(value = "交换文章置顶顺序", notes = "交换文章置顶顺序")
    @RequestMapping(value = { "/articles/swapPinOrder" }, method = RequestMethod.POST)
	public ResponseEntity<?> swapPinOrder(@ApiParam("文章1的Id") Long articleId1, 
	        @ApiParam("文章2的Id") Long articleId2) {
	    articleService.swapPinOrder(articleId1, articleId2);
	    return ResponseEntity.ok(null);
	}
	
    @ApiOperation(value = "更新一篇文章", notes = "更新一篇文章")
    @RequestMapping(value = { "/articles/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("文章Id，必填") @PathVariable Long id,  
            @ApiParam("栏目Id，仅限于子栏目，可选") @RequestParam(required = false) Long columnId, 
            @ApiParam("文章配图，可选") @RequestParam(required = false) String imgUrl, 
            @ApiParam("文章是否置顶，可选") @RequestParam(required = false) Boolean isPinned, 
            @ApiParam("文章置顶的顺序，可选") @RequestParam(required = false) Byte pinOrder, 
            @ApiParam("文章是否发表，可选") @RequestParam(required = false) Boolean isPublished, 
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
        
        //pinOrder和isPinned具有联动性
        if (isPinned != null) {
            article.setIsPinned(isPinned);
            if (isPinned) {
                if (pinOrder != null) {
                    article.setPinOrder(pinOrder);
                }
            } else {
                article.setPinOrder((byte) 0);
            }
        }
        

        
        if (isPublished != null) {
            article.setIsPublished(isPublished);
            if (isPublished) {
                article.setPublishTime(new Date());
            }
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
        
        article = articleService.read(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        }
    }
	
    @RequestMapping(value = { "/uploadImage" }, method = RequestMethod.POST)
    public ResponseEntity<?> uploadImage(@ApiParam("图片") @RequestParam MultipartFile image) {
        String imagePath = "";
        String imageUrl = "";
        try {
            imagePath = FileUtil.uploadImage(PathUtil.IMG_STORAGE_PATH, image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        imageUrl = PathUtil.ORIGIN + File.separator + PathUtil.IMG_FOLDER_PATH + imagePath;
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(imageUrl);
    }
    
    @ApiOperation(value = "搜索文章", notes = "搜索文章")
    @RequestMapping(value = { "/articles/show" }, method = RequestMethod.GET)
    public ResponseEntity<?> show(@ApiParam("文章标题的关键字") @RequestParam String keyword, 
            @ApiParam("文章的栏目Id") @RequestParam(required = false) Long columnId) {
        
        List<XPWArticle> list;
        if (columnId != null) {
            list = articleService.show(columnId, keyword);
        } else {
            list = articleService.show(keyword);
        }
        
        if (list.size() != 0) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(null);
        }
    }


}
