package com.xmheart.backend.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWVideo;
import com.xmheart.service.ArticleService;
import com.xmheart.service.ColumnService;
import com.xmheart.util.FileUtil;
import com.xmheart.util.PathUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "文章管理接口")
@Controller
public class VideoController {
	
    //TODO 这个接口要移到后台系统中去
	@ApiOperation(value = "创建一个视频", notes = "创建一篇视频")
	@RequestMapping(value = { "/videos" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("视频标题") @RequestParam String title,
            @ApiParam("视频url") @RequestParam(required = false) String url,
            @ApiParam("视频图片") @RequestParam(required = false) String imgUrl,
            @ApiParam("视频描述") @RequestParam(required = false) String brief,
            @ApiParam("是否置顶") @RequestParam(required = false) Boolean isPinned) {
		XPWVideo video = new XPWVideo();
		
		video.setTitle(title);
		
		if (url != null) {
		    video.setUrl(url);
		}
		
		if (imgUrl != null) {
		    video.setImgUrl(url);
		}
		
		if (brief != null) {
		    video.setBrief(brief);
		}
		
		if (isPinned != null) {
		    video.setIsPinned(isPinned);
		}
		
//		int ret = articleService.create(article);
//		if (ret > 0) {
//		    article.setUrl("/newsDetail?id=" + String.valueOf(article.getId()));
//		    articleService.update(article);
//			return ResponseEntity.ok(null);
//		} else {
//			return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
//		}
		
		return null;
    }

}
