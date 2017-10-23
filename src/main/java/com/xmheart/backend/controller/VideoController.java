package com.xmheart.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xmheart.model.XPWVideo;
import com.xmheart.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "影像管理接口")
@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    @ApiOperation(value = "创建一个视频", notes = "创建一篇视频")
    @RequestMapping(value = { "/videos" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("视频标题") @RequestParam String title,
            @ApiParam("视频缩略图的地址") @RequestParam(required = false) String imgUrl,
            @ApiParam("视频地址") @RequestParam(required = false) String videoUrl,
            @ApiParam("视频描述") @RequestParam(required = false) String brief,
            @ApiParam("是否置顶") @RequestParam(required = false) Boolean isPinned,
            @ApiParam("图片地址") @RequestParam(required = false) Boolean isPublished) {
        XPWVideo video = new XPWVideo();

        video.setTitle(title);

        if (imgUrl != null) {
            video.setUrl(imgUrl);
        }

        if (videoUrl != null) {
            video.setImgUrl(videoUrl);
        }

        if (brief != null) {
            video.setBrief(brief);
        }

        if (isPinned != null) {
            video.setIsPinned(isPinned);
        }
        
        if (isPublished != null) {
            video.setIsPublished(isPublished);
        }

        int ret = videoService.create(video);
        if (ret > 0) {
            video.setUrl("/videoNewsDetail?id=" + String.valueOf(video.getId()));
            videoService.update(video);
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        }

    }
    
    @ApiOperation(value = "更新一个视频", notes = "更新一篇视频")
    @RequestMapping(value = { "/videos/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("视频Id") @PathVariable Long id,
            @ApiParam("视频标题") @RequestParam(required = false) String title,
            @ApiParam("视频缩略图的地址") @RequestParam(required = false) String imgUrl,
            @ApiParam("视频地址") @RequestParam(required = false) String videoUrl,
            @ApiParam("视频描述") @RequestParam(required = false) String brief,
            @ApiParam("是否置顶") @RequestParam(required = false) Boolean isPinned,
            @ApiParam("图片地址") @RequestParam(required = false) Boolean isPublished) {
        XPWVideo video = new XPWVideo();
        
        video.setId(id);

        if (title != null) {
            video.setTitle(title);
        }

        if (imgUrl != null) {
            video.setUrl(imgUrl);
        }

        if (videoUrl != null) {
            video.setImgUrl(videoUrl);
        }

        if (brief != null) {
            video.setBrief(brief);
        }

        if (isPinned != null) {
            video.setIsPinned(isPinned);
        }
        
        
        if (isPublished != null) {
            video.setIsPublished(isPublished);
        }

        int ret = videoService.update(video);
        if (ret > 0) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
