package com.xmheart.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xmheart.model.XPWColumn;
import com.xmheart.service.ColumnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "栏目管理接口")
@Controller
public class ColumnController {
    
    @Autowired 
    private ColumnService ColumnService;
    
    @ApiOperation(value = "获取所有栏目", notes = "获取所有栏目")
    @RequestMapping(value = { "/columns" }, method = RequestMethod.GET)
    public ResponseEntity<?> columns(@ApiParam("父栏目的Id，父栏目Id为0的表示没有父栏目") @RequestParam(required = false) Long parentColumnId) {
        
        List<XPWColumn> list;
        if (parentColumnId == null) {
            list = ColumnService.getColumns();
        } else {
            list = ColumnService.getColumnsByParentId(parentColumnId);
        }
        
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
    }

}
