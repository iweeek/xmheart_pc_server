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

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "后台接口，导航管理接口")
@Controller
public class NavController {
    
    @Autowired 
    private ColumnService ColumnService;
    
    @ApiOperation(value = "根据一级栏目获取所有导航内容", notes = "根据一级栏目获取所有导航内容")
    @RequestMapping(value = { "/navs" }, method = RequestMethod.GET)
    public ResponseEntity<?> navs(@ApiParam("一级栏目的Id") @RequestParam Long columnId) {
        
        List<XPWNav> list;
        list = ColumnService.getNavsByColumnId(columnId);
        
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
    }
    
    @ApiOperation(value = "根据Id更新导航内容", notes = "根据Id更新导航内容")
    @RequestMapping(value = { "/navs/{id}" }, method = RequestMethod.POST)
    public ResponseEntity<?> update(@ApiParam("导航条目的Id") @PathVariable Long id, 
            @ApiParam("导航关联文章的名称") @PathVariable String articleTitle) {
        
        List<XPWNav> list = null;
//        list = ColumnService.getNavsByColumnId(columnId);
        
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
    }

}
