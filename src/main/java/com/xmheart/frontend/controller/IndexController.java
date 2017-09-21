package com.xmheart.frontend.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;

@Controller
public class IndexController {
    
    @Autowired
    private ColumnService columnService;
    
    private Model addCommonHeader(Model model) {

        List<XPWColumn> columnList = columnService.getFirstColumns();
        Map<String, String> firstColumns = new LinkedHashMap<String, String>();
        Map<String, List<XPWColumn>> columnMap = new LinkedHashMap<String, List<XPWColumn>>();
        Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();

        for (XPWColumn column : columnList) {
            firstColumns.put(column.getColumnName(), column.getUrl());

            List<XPWColumn> secColList = columnService.getChildColumnsById(column.getId());
            if (secColList.size() > 0) {
                columnMap.put(column.getColumnName(), secColList);
            }

            List<XPWNav> navList = columnService.getChildNavsById(column.getId());

            if (navList.size() > 0) {
                navMap.put(column.getColumnName(), navList);
            }
        }

        model.addAttribute("firstColumns", firstColumns);
        model.addAttribute("columnMap", columnMap);
        model.addAttribute("navMap", navMap);

        return model;
    }
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model = addCommonHeader(model);

        return "index";
    }
}
