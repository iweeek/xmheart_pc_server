package com.xmheart.frontend.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.model.XPWArticle;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWVideo;
import com.xmheart.service.ArticleService;
import com.xmheart.service.ColumnService;
import com.xmheart.service.DoctorAndDeptService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class SearchController {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private DoctorAndDeptService doctorAndDeptService;
    
    @Autowired
    private ColumnService columnService;
    
    @ApiOperation(value = "获取文章", notes = "获取文章")
    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public String search(Model model, @ApiParam("开始页号") @RequestParam(required = false, defaultValue = "1") Integer page,
            @ApiParam("每页的数目") @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @ApiParam("搜索类型") @RequestParam(required = false, defaultValue = "1") Integer type,
            @ApiParam("搜索关键字") @RequestParam(required = false) String keywords) {
        
        model = addTopNav(1, model);
        PageHelper.startPage(page, pageSize);
        model.addAttribute("keywords", keywords);
        model.addAttribute("type", type);
        model.addAttribute("isSearch", true);
        keywords = StringEscapeUtils.escapeSql(keywords);
        if (type == 1) {
            
            
        } else if (type ==2){
            List<XPWDoctor> list = doctorAndDeptService.searchDoctorByName(keywords);
            model.addAttribute("doctorList", list);
            PageInfo pageInfo = new PageInfo<>(list);
            model.addAttribute("pageInfo", pageInfo);
            
        } else if (type ==3){
            List<XPWArticle> list = articleService.searchArticleByTitle(keywords);
            model.addAttribute("articleList", list);
            PageInfo pageInfo = new PageInfo<>(list);
            model.addAttribute("pageInfo", pageInfo);
        }
        
        return "search";
    }
    
    private Model addTopNav(long columnId, Model model) {

        List<XPWColumn> columnList = columnService.getTopFirstColumns();
        Map<String, String> firstColumns = new LinkedHashMap<String, String>();
        Map<String, List<XPWColumn>> columnMap = new LinkedHashMap<String, List<XPWColumn>>();
        Map<Long, List<XPWNav>> navMap = new LinkedHashMap<Long, List<XPWNav>>();
        Map<String, List<XPWNav>> secondColNavMap = new LinkedHashMap<String, List<XPWNav>>();
        Map<String, List<XPWNav>> columnNavMap = new LinkedHashMap<String, List<XPWNav>>();
        
        
        for (XPWColumn column : columnList) {
            firstColumns.put(column.getColumnName(), column.getUrl());
            List<XPWColumn> secColList = columnService.getChildColumnsById(column.getId());
            if (secColList.size() > 0) {
                columnMap.put(column.getColumnName(), secColList);
            }

            List<XPWNav> navList = columnService.getNavsByColumnId(column.getId());
            for (XPWNav nav : navList) {
                nav.setBrief(nav.getBrief().replaceAll("\\n", "<br/>"));
            }
            columnNavMap.put(column.getColumnName(), navList);
            if (navList.size() > 0) {
                navMap.put(column.getId(), navList);
            }

            for (XPWNav nav : navList) {
                if (secondColNavMap.containsKey(nav.getChildColumnName()) == false) {
                    List<XPWNav> secondColNavList = columnService.getNavsByChildColumnName(nav.getChildColumnName());
                    secondColNavMap.put(nav.getChildColumnName(), secondColNavList);
                }
            }
        }

        model.addAttribute("firstColumns", firstColumns);
        model.addAttribute("columnMap", columnMap);
//      model.addAttribute("navMap", navMap);
        model.addAttribute("secondColNavMap", secondColNavMap);
        model.addAttribute("columnNavMap", columnNavMap);

        // 这个地方只能体现两级栏目关系
        XPWColumn parentColumn = columnService.getParentColumnById(columnId);
        
        List<XPWColumn> list = new ArrayList<XPWColumn>();
        // 有父栏目，父栏目是一级栏目
        if (parentColumn != null) {
            iterGetParentColumn(parentColumn, list);
            model.addAttribute("parentColList", list);
            model.addAttribute("firstColumnName", list.get(0).getColumnName());
        } else {
            XPWColumn column = columnService.getColumnById(columnId);
            model.addAttribute("firstColumnName", column.getColumnName());
        }

        return model;
    }
    
    private void iterGetParentColumn(XPWColumn column, List<XPWColumn> list) {
        if (list.size() == 0) {
            if (column.getParentColumnId() != 0) {
                iterGetParentColumn(columnService.getParentColumnById(column.getId()), list);
            } else {
                list.add(column);
                return;
            }
        } 
        
        list.add(column);
        
    }
}
