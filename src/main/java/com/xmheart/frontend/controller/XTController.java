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
public class XTController {
    
    @Autowired
    private ColumnService columnService;
    
    private final String XTINDEX_COLUMN_NAME = "胸痛中心";
    
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

            List<XPWNav> navList = columnService.getNavsByColumnId(column.getId());

            if (navList.size() > 0) {
                navMap.put(column.getColumnName(), navList);
            }
        }

        model.addAttribute("firstColumns", firstColumns);
        model.addAttribute("columnMap", columnMap);
        model.addAttribute("navMap", navMap);
        model.addAttribute("firstColumnName", XTINDEX_COLUMN_NAME);

        return model;
    }
    
    @RequestMapping(value = {"/xtIndex"}, method = RequestMethod.GET)
    public String index(Model model) {
        model = addCommonHeader(model);

        return "xt_index";
    }
}
