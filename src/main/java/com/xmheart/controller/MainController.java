package com.xmheart.controller;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWNav;
import com.xmheart.service.ColumnService;

import freemarker.template.Template;
 
@Controller
public class MainController {
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Autowired
	private ColumnService ColumnService;
 
    private static Map<String, String> secColumns = new HashMap<String, String>();
    
    private Model addHeader(Model model) {
    	List<XPWColumn> columnList = ColumnService.getFirstColumns();
    	Map<String, String> firstColumns = new LinkedHashMap<String, String>();
    	Map<String, List<XPWColumn>> columnMap = new LinkedHashMap<String, List<XPWColumn>>();
    	Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();
    	
    	for (XPWColumn column : columnList) {
    		firstColumns.put(column.getColumnName(), column.getUrl());
    		model.addAttribute("firstColumns", firstColumns);
    		List<XPWColumn> secColList = ColumnService.getChildColumns(column.getColumnName());
    		if (secColList.size() > 0) {
    			columnMap.put(column.getColumnName(), secColList);
    		}
    		
    		List<XPWNav> navList = ColumnService.getChildNavs(column.getColumnName());
    		if (navList.size() > 0) {
    			navMap.put(column.getColumnName(), navList);
    		}
    	}
    	
    	model.addAttribute("columnMap", columnMap);
    	model.addAttribute("navMap", navMap);
    	
    	return model;
    }
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
    	model = addHeader(model);
        
        return "index";
    }
    
    @RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
    public ResponseEntity<?> edit(
			@RequestParam String page,
			HttpServletRequest request,
			Model model) {
//        model.addAttribute("columns", columns);
        
        try {
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(page + ".ftl");
            File file = new File(request.getServletContext().getRealPath(page + ".html"));
            file.createNewFile();
	        FileOutputStream outStream = new FileOutputStream(new File(file.getAbsolutePath()));
	        OutputStreamWriter writer =  new OutputStreamWriter(outStream, "UTF-8");
	        BufferedWriter bw = new BufferedWriter(writer);
	        //模板引擎解释模板
	        template.process(model, bw);
	        bw.flush();
	        bw.close();
	        outStream.close();
       } catch (Exception e) {
        e.printStackTrace();
       }
 
        return null;
    }
    
    @RequestMapping(value = { "/media", "/media.html" }, method = RequestMethod.GET)
    public String media(Model model) {
    	model = addHeader(model);
    	List<XPWColumn> list = ColumnService.getChildColumns("新闻公告");
    	model.addAttribute("pageName", new String("媒体看厦心"));
    	model.addAttribute("listMainNav", list);
        return "media";
    }
    
    @RequestMapping(value = { "/index/media-detail", "/index/media-detail.html" }, method = RequestMethod.GET)
    public String mediaDetail(Model model) {
 
//        model.addAttribute("columns", columns);
        return "media-detail";
    }
 
}