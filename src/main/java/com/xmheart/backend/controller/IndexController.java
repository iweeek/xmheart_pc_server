package com.xmheart.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xmheart.model.XPWIndex;
import com.xmheart.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "首页管理接口")
@Controller
public class IndexController {
	
	@Autowired 
	IndexService indexService;
	
    @ApiOperation(value = "获取首页信息", notes = "获取首页信息")
    @RequestMapping(value = { "/indexPage" }, method = RequestMethod.GET)
    public ResponseEntity<?> index() {
        
        XPWIndex index = indexService.read();

        return ResponseEntity.ok(index);
        
    }
    
    @ApiOperation(value = "更新首页信息", notes = "更新首页信息")
    @RequestMapping(value = { "/indexPage/{id}" }, method = RequestMethod.PUT)
    public ResponseEntity<?> update(@ApiParam("首页信息的Id") @PathVariable Long id,
            @ApiParam("轮播图1的地址") @RequestParam() String bannerImage1Url, 
            @ApiParam("轮播图2的地址") @RequestParam() String bannerImage2Url,
            @ApiParam("轮播图3的地址") @RequestParam() String bannerImage3Url,
            @ApiParam("轮播文章1的地址") @RequestParam() String bannerArticle1Url,
            @ApiParam("轮播文章2的地址") @RequestParam() String bannerArticle2Url,
            @ApiParam("轮播文章3的地址") @RequestParam() String bannerArticle3Url,
            @ApiParam("轮播文章1的摘要") @RequestParam() String bannerArticle1Brief,
            @ApiParam("轮播文章2的摘要") @RequestParam() String bannerArticle2Brief,
            @ApiParam("轮播文章3的摘要") @RequestParam() String bannerArticle3Brief
            ) {
        XPWIndex index = new XPWIndex();
        index.setId(id);
        index.setBannerImage1Url(bannerImage1Url);
        index.setBannerImage2Url(bannerImage2Url);
        index.setBannerImage3Url(bannerImage3Url);
        index.setBannerArticle1Url(bannerArticle1Url);
        index.setBannerArticle2Url(bannerArticle2Url);
        index.setBannerArticle3Url(bannerArticle3Url);
        index.setBannerArticle1Brief(bannerArticle1Brief);
        index.setBannerArticle2Brief(bannerArticle2Brief);
        index.setBannerArticle3Brief(bannerArticle3Brief);
        
        int ret = indexService.update(index);
        if (ret > 0) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    
}
