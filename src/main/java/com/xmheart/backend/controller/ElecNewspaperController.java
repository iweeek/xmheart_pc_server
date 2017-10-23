package com.xmheart.backend.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.service.NewspaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "文章管理接口")
@Controller
public class ElecNewspaperController {

    @Autowired
    NewspaperService newspaperService;

    @ApiOperation(value = "创建一个院报", notes = "创建一个院报")
    @RequestMapping(value = { "/newspapers" }, method = RequestMethod.POST)
    public ResponseEntity<?> create(@ApiParam("院报标题") @RequestParam String title,
            @ApiParam("院报年份") @RequestParam(required = false) String year,
            @ApiParam("院报期数") @RequestParam(required = false) String times,
            @ApiParam("下载地址") @RequestParam(required = false) String downloadUrl,
            @ApiParam("图片地址") @RequestParam(required = false) String imageUrl) {
        XPWElecNewspaper newspaper = new XPWElecNewspaper();

        newspaper.setTitle(title);

        if (year != null) {
            newspaper.setYears(year);
        }

        if (times != null) {
            newspaper.setTimes(times);
        }

        if (downloadUrl != null) {
            newspaper.setDownloadUrl(downloadUrl);
        }

        if (imageUrl != null) {
            newspaper.setImageUrl(imageUrl);
        }

        int ret = newspaperService.create(newspaper);
        if (ret > 0) {
            newspaper.setUrl("/videoNewsDetail?id=" + String.valueOf(newspaper.getId()));
            newspaperService.update(newspaper);
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        }

    }
    
    @ApiOperation(value = "更新一个视频", notes = "更新一篇视频")
    @RequestMapping(value = { "/newspapers/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("院报Id") @PathVariable Long id,
            @ApiParam("院报标题") @RequestParam(required = false) String title,
            @ApiParam("院报年份") @RequestParam(required = false) String year,
            @ApiParam("院报期数") @RequestParam(required = false) String times,
            @ApiParam("下载地址") @RequestParam(required = false) String downloadUrl,
            @ApiParam("图片地址") @RequestParam(required = false) String imageUrl) {
        XPWElecNewspaper newspaper = new XPWElecNewspaper();

        
        newspaper.setId(id);

        if (title != null) { 
            newspaper.setTitle(title);
        }

        if (year != null) {
            newspaper.setYears(year);
        }

        if (times != null) {
            newspaper.setTimes(times);
        }

        if (downloadUrl != null) {
            newspaper.setDownloadUrl(downloadUrl);
        }

        if (imageUrl != null) {
            newspaper.setImageUrl(imageUrl);
        }

        int ret = newspaperService.update(newspaper);
        if (ret > 0) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
