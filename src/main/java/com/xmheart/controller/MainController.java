package com.xmheart.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.print.attribute.standard.MediaSize.NA;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.commons.lang3.text.WordUtils;
import org.omg.PortableServer.POAPackage.WrongAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWNewsMediaArticle;
import com.xmheart.model.XPWNewsMediaArticleWithBLOBs;
import com.xmheart.service.ColumnService;
import com.xmheart.service.ExpertAndDeptService;
import com.xmheart.service.NewsService;

import freemarker.template.Template;
import io.swagger.annotations.ApiOperation;

@Controller
public class MainController {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Autowired
	private ColumnService ColumnService;

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private ExpertAndDeptService expertAndDeptService;

	private final int PAGE_SIZE = 10;

	private final String NEWS_COLUMN_NAME = "新闻公告";
	private final String MEDIA_NEWS_COLUMN_NAME = "媒体看厦心";
	private final String HOSPITAL_NEWS_COLUMN_NAME = "医院新闻";
	private final String VIDEO_NEWS_COLUMN_NAME = "影像厦心";
	private final String ELECPAPER_NEWS_COLUMN_NAME = "电子院报";

	static final long NEWS_COLUMN_ID = 5;
	static final long EXPERT_COLUMN_ID = 3;
 
//    private static Map<String, String> secColumns = new HashMap<String, String>();

    private Model addCommonHeader(Model model) {

    	List<XPWColumn> columnList = ColumnService.getFirstColumns();
    	Map<String, String> firstColumns = new LinkedHashMap<String, String>();
    	Map<String, List<XPWColumn>> columnMap = new LinkedHashMap<String, List<XPWColumn>>();
    	Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();

    	for (XPWColumn column : columnList) {
    		firstColumns.put(column.getColumnName(), column.getUrl());
    		
    		List<XPWColumn> secColList = ColumnService.getChildColumnsById(column.getId());
    		if (secColList.size() > 0) {
    			columnMap.put(column.getColumnName(), secColList);
    		}

    		List<XPWNav> navList = ColumnService.getChildNavsById(column.getId());

    		if (navList.size() > 0) {
    			navMap.put(column.getColumnName(), navList);
    		}
    	}
    	
    	model.addAttribute("firstColumns", firstColumns);
    	model.addAttribute("columnMap", columnMap);
    	model.addAttribute("navMap", navMap);

    	return model;
    }

    private Model addNewsHeader(Model model) {
    	List<XPWColumn> list = ColumnService.getChildColumnsById(NEWS_COLUMN_ID);
    	model.addAttribute("listMainNav", list);
    	
    	model.addAttribute("parentColumnName", NEWS_COLUMN_NAME);

    	return model;
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
    	model = addCommonHeader(model);

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

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/mediaNews" }, method = RequestMethod.GET)
    public String mediaNews(@RequestParam(required=false, defaultValue="1") Integer page, Model model) {
    	model = addCommonHeader(model);

    	model = addNewsHeader(model);

    	model.addAttribute("columnName", MEDIA_NEWS_COLUMN_NAME);

    	//获取置顶的新闻
    	List<XPWNewsMediaArticleWithBLOBs> pinnedMediaNewsList = newsService.getPinnedMediaNews();
    	model.addAttribute("pinnedMediaNewsList", pinnedMediaNewsList);

		PageHelper.startPage(page, PAGE_SIZE);
    	List<XPWNewsMediaArticleWithBLOBs> noPinnedMediaNewsList = newsService.getNoPinnedMediaNews();
    	model.addAttribute("noPinnedMediaNewsList", noPinnedMediaNewsList);

    	PageInfo pageInfo = new PageInfo(noPinnedMediaNewsList);
    	model.addAttribute("pageInfo", pageInfo);

        return "news";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/hospitalNews" }, method = RequestMethod.GET)
    public String hospitalNews(@RequestParam(required=false, defaultValue="1") Integer page, Model model) {
    	model = addCommonHeader(model);

    	model = addNewsHeader(model);

    	model.addAttribute("columnName", HOSPITAL_NEWS_COLUMN_NAME);

    	//获取置顶的新闻
    	List<XPWNewsMediaArticleWithBLOBs> pinnedNewsList = newsService.getPinnedHospitalNews();
    	model.addAttribute("pinnedMediaNewsList", pinnedNewsList);

		PageHelper.startPage(page, PAGE_SIZE);
    	List<XPWNewsMediaArticleWithBLOBs> noPinnedNewsList = newsService.getNoPinnedHospitalNews();
    	model.addAttribute("noPinnedMediaNewsList", noPinnedNewsList);

    	PageInfo pageInfo = new PageInfo(noPinnedNewsList);
    	model.addAttribute("pageInfo", pageInfo);

        return "news";
    }
    
    /**
	* 影像厦心列表页
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "影像厦心列表页", notes = "影像厦心列表页")
    @RequestMapping(value = { "/videoNews" }, method = RequestMethod.GET)
    public String videoNews(Model model,@RequestParam(required = false) Integer page) {
		
		if (page == null) {
			page = new Integer(1);
		}
		
    	model = addCommonHeader(model);
    	
    	model = addNewsHeader(model);
    	
    	model.addAttribute("columnName", VIDEO_NEWS_COLUMN_NAME);
    	
//    	model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);
//
//    	PageHelper.startPage(page, PAGE_SIZE);
//    	
//	    List<XPWElecNewspaper> list = newsService.getElecNewsPaper();
//	    model.addAttribute("newsPaperList", list);
//	    
//		PageInfo pageInfo = new PageInfo(list);
//    	model.addAttribute("pageInfo", pageInfo);

        return "video";
    }

	 /**
		* 影像厦心详情页
		*/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@ApiOperation(value = "影像厦心详情页", notes = "影像厦心详情页")
	    @RequestMapping(value = { "/videoNewsDetail" }, method = RequestMethod.GET)
	    public String videoNewsDetail(Model model,@RequestParam(required = false) Integer page) {
			
			if (page == null) {
				page = new Integer(1);
			}
			
	    	model = addCommonHeader(model);
	    	
	    	model = addNewsHeader(model);
	    	
	    	model.addAttribute("columnName", VIDEO_NEWS_COLUMN_NAME);
	    	
//	    	model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);
	//
//	    	PageHelper.startPage(page, PAGE_SIZE);
//	    	
//		    List<XPWElecNewspaper> list = newsService.getElecNewsPaper();
//		    model.addAttribute("newsPaperList", list);
//		    
//			PageInfo pageInfo = new PageInfo(list);
//	    	model.addAttribute("pageInfo", pageInfo);

	        return "video_img_detail";
	    }

	/**
	* 电子院报列表页
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "电子院报列表页", notes = "电子院报列表页")
    @RequestMapping(value = { "/elecNewsPaper" }, method = RequestMethod.GET)
    public String elecNewsPaper(Model model,@RequestParam(required = false) Integer page) {
		
		if (page == null) {
			page = new Integer(1);
		}
		
    	model = addCommonHeader(model);
    	
    	model = addNewsHeader(model);
    	
    	model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);

    	PageHelper.startPage(page, PAGE_SIZE);
    	
	    List<XPWElecNewspaper> list = newsService.getElecNewsPaper();
	    model.addAttribute("newsPaperList", list);
	    
		PageInfo pageInfo = new PageInfo(list);
    	model.addAttribute("pageInfo", pageInfo);

        return "news_paper";
    }
	
   @RequestMapping(value = { "/newsDetail" }, method = RequestMethod.GET)
    public String newsDetail(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);
    	
    	model = addNewsHeader(model);

    	XPWNewsMediaArticle article = newsService.getNewsById(id);
    	model.addAttribute("article", article);

        return "news_detail";

    }
    
    @RequestMapping(value = { "/doctorDept" }, method = RequestMethod.GET)
    public String doctor(Model model) {
    	model = addCommonHeader(model);
    	
    	List<XPWDoctor> experts = expertAndDeptService.getDoctors();
    	model.addAttribute("experts", experts);
    	
    	List<XPWDept> depts = expertAndDeptService.getDepts();
    	model.addAttribute("depts", depts);
    	
        return "doctor_dept";
    }
    
    @RequestMapping(value = { "/doctorDetail" }, method = RequestMethod.GET)
    public String doctorInfo(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);
    	
    	XPWDoctor doctor = expertAndDeptService.getDoctorAndDeptById(id);
    	model.addAttribute("doctor", doctor);
//    	model.addAttribute("dept", doctor.getDept());
        return "doctor_detail";
    }
    
    @RequestMapping(value = { "/deptDoctor" }, method = RequestMethod.GET)
    public String deptDoctor(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);
    	
    	XPWDept dept = expertAndDeptService.getDeptAndDoctorsById(id);
    	model.addAttribute("dept", dept);
        return "dept_doctor";
    }
    
    @RequestMapping(value = { "/deptDetail" }, method = RequestMethod.GET)
    public String deptDetail(@RequestParam Long id, Model model) {
    	model = addCommonHeader(model);
    	
    	XPWDept dept = expertAndDeptService.getDeptAndDoctorsById(id);
    	model.addAttribute("dept", dept);
//    	model.addAttribute("dept", doctor.getDept());
        return "dept_detail";
    }
 
}