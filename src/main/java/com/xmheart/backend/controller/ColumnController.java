package com.xmheart.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmheart.model.XPWColumn;
import com.xmheart.service.ColumnService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "栏目管理接口")
@Controller
public class ColumnController {
    
    @Autowired 
    private ColumnService ColumnService;
    
    @ApiOperation(value = "获取所有栏目", notes = "获取所有栏目")
    @RequestMapping(value = { "/columns" }, method = RequestMethod.GET)
    public ResponseEntity<?> columns() {
        List<XPWColumn> list = ColumnService.getColumns();
        
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(list);
    }

}
