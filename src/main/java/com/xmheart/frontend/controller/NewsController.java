package com.xmheart.frontend.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.xmheart.util.HisDoctorComparator;
import com.xmheart.util.HisUtil;
import com.xmheart.util.XmlUtil;
import com.xmheart.util.soap.Service1;
import com.xmheart.util.soap.Service1Soap;

import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWColumnEnglish;
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWIndex;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWOnlineVideo;
import com.xmheart.model.XPWTeacher;
import com.xmheart.model.XPWXTIndex;
import com.xmheart.model.XPWVideo;
import com.xmheart.his.Response.Department;
import com.xmheart.his.Response.Departments;
import com.xmheart.his.Response.Doctors;
import com.xmheart.his.Response.RegisteredSource;
import com.xmheart.his.Response.RegisteredSourcePreInfo;
import com.xmheart.model.HisDoctor;
import com.xmheart.model.XPWArticle;
import com.xmheart.service.ArticleService;
import com.xmheart.service.ColumnEnglishService;
import com.xmheart.service.ColumnService;
import com.xmheart.service.DoctorAndDeptService;
import com.xmheart.service.IndexService;
import com.xmheart.service.NewsService;
import com.xmheart.service.OnlineVideoService;
import com.xmheart.service.TeacherTeamService;
import com.xmheart.service.VideoService;

import freemarker.template.Template;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Controller
public class NewsController {
    
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Autowired
	private ColumnService columnService;
	
    @Autowired
    private ColumnEnglishService columnEnglishService;
	
	@Autowired
	private NewsService newsService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private VideoService videoService;
	
    @Autowired
    private OnlineVideoService onlinevideoService;

	@Autowired
	private DoctorAndDeptService doctorAndDeptService;
	
    @Autowired
    private TeacherTeamService teacherTeamService;
	
	@Autowired
	private IndexService indexService;

	private final int PAGE_SIZE = 10;

	private final String HOSPITAL_NEWS_COLUMN_NAME = "医院新闻";

	static final long NEWS_COLUMN_ID = 5;
	static final long EXPERT_COLUMN_ID = 3;
	static final long TEACHER_COLUMN_ID = 49;
	static final long VIDEO_NEWS_COLUMN_ID = 22;
	static final long PATIENT_PRAISE_COLUMN_ID = 41;
	static final long ONLINE_VIDEO_NEWS_COLUMN_ID = 82;
	static final long ELEC_NEWS_PAPER_COLUMN_ID = 23;
	static final long CHEST_PAIN_COLUMN_ID = 77;
	// private static Map<String, String> secColumns = new HashMap<String,
	// String>();

	/**
	 * Adds the top nav.
	 *
	 * @param columnId
	 *            the column id
	 * @param model
	 *            the model
	 * @return the model
	 */
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
					List<XPWNav> secondColNavList = columnService.getNavsByChildColumnId(nav.getChildColumnId());
					secondColNavMap.put(nav.getChildColumnName(), secondColNavList);
				}
			}
		}

		model.addAttribute("firstColumns", firstColumns);
		model.addAttribute("columnMap", columnMap);
//		model.addAttribute("navMap", navMap);
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

		// 获取当前是中文还是英文
//		XPWIndex index = indexService.indexRead();
		
		return model;
	}
	
	private Model addEnglishTopNav(long columnId, Model model) {

        List<XPWColumnEnglish> columnList = columnEnglishService.getTopFirstColumns();
        Map<String, String> firstColumns = new LinkedHashMap<String, String>();
        Map<String, List<XPWColumnEnglish>> columnMap = new LinkedHashMap<String, List<XPWColumnEnglish>>();
        Map<Long, List<XPWNav>> navMap = new LinkedHashMap<Long, List<XPWNav>>();
        Map<String, List<XPWNav>> secondColNavMap = new LinkedHashMap<String, List<XPWNav>>();
        Map<String, List<XPWNav>> columnNavMap = new LinkedHashMap<String, List<XPWNav>>();
        
        
        for (XPWColumnEnglish column : columnList) {
            firstColumns.put(column.getColumnName(), column.getUrl());
            List<XPWColumnEnglish> secColList = columnEnglishService.getChildColumnsById(column.getId());
            if (secColList.size() > 0) {
                columnMap.put(column.getColumnName(), secColList);
            }

            List<XPWNav> navList = columnEnglishService.getNavsByColumnId(column.getId());
            for (XPWNav nav : navList) {
                nav.setBrief(nav.getBrief().replaceAll("\\n", "<br/>"));
            }
            columnNavMap.put(column.getColumnName(), navList);
            if (navList.size() > 0) {
                navMap.put(column.getId(), navList);
            }

            for (XPWNav nav : navList) {
                if (secondColNavMap.containsKey(nav.getChildColumnName()) == false) {
                    List<XPWNav> secondColNavList = columnEnglishService.getNavsByChildColumnId(nav.getChildColumnId());
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
        XPWColumnEnglish parentColumn = columnEnglishService.getParentColumnById(columnId);
        
        List<XPWColumnEnglish> list = new ArrayList<XPWColumnEnglish>();
        // 有父栏目，父栏目是一级栏目
        if (parentColumn != null) {
            System.out.println("递归循环了");
            iterGetParentColumn(parentColumn, list);
            model.addAttribute("parentColList", list);
            model.addAttribute("firstColumnName", list.get(0).getColumnName());
        } else {
            System.out.println("else递归循环了");
            XPWColumnEnglish column = columnEnglishService.getColumnById(columnId);
            model.addAttribute("firstColumnName", column.getColumnName());
        }

        // 获取当前是中文还是英文
//      XPWIndex index = indexService.indexRead();
        
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
	
    private void iterGetParentColumn(XPWColumnEnglish column, List<XPWColumnEnglish> list) {
        if (list.size() == 0) {
            if (column.getParentColumnId() != 0) {
                iterGetParentColumn(columnEnglishService.getParentColumnById(column.getId()), list);
            } else {
                list.add(column);
                return;
            }
        } 
        list.add(column);
    }

	private Model addLeftNav(long columnId, Model model) {
		List<XPWColumn> childColumns = columnService
				.getChildColumnsById(columnService.getParentColumnById(columnId).getId());
		model.addAttribute("leftNav", childColumns);

		String parentColumnName = columnService.getParentColumnById(columnId).getColumnName();
		model.addAttribute("parentColumnName", parentColumnName);
		return model;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public ResponseEntity<?> edit(@RequestParam String page, HttpServletRequest request, Model model) {
		// model.addAttribute("columns", columns);

		try {
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(page + ".ftl");
			File file = new File(request.getServletContext().getRealPath(page + ".html"));
			file.createNewFile();
			FileOutputStream outStream = new FileOutputStream(new File(file.getAbsolutePath()));
			OutputStreamWriter writer = new OutputStreamWriter(outStream, "UTF-8");
			BufferedWriter bw = new BufferedWriter(writer);
			// 模板引擎解释模板
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
	@RequestMapping(value = { "/col/{columnId}" }, method = RequestMethod.GET)
	public String columnArticleList(@RequestParam(required = false, defaultValue = "1") Integer page,
			@PathVariable Long columnId, Model model) {
		model = addTopNav(columnId, model);

		model = addLeftNav(columnId, model);

		String columnName = columnService.getColumnById(columnId).getColumnName();
		model.addAttribute("columnName", columnName);

		// 获取置顶的新闻
		boolean isPublished = true;
		boolean isPinned = true;

		PageHelper.startPage(page, PAGE_SIZE);
		List<XPWArticle> articleList = articleService.index(columnId, isPublished);
        PageInfo pageInfo = new PageInfo(articleList);
        model.addAttribute("pageInfo", pageInfo);
		// 顶部三个置顶文章
		List<XPWArticle> pinnedArticleList = articleService.index(columnId, isPublished, isPinned);
		if (pinnedArticleList.size() >= 3) {
			// 有 >=3 个的置顶文章
	        if (articleList.size() > 0) {
				if (page == 1) {
					pinnedArticleList = pinnedArticleList.subList(0, 3);
					model.addAttribute("pinnedArticleList", pinnedArticleList);
//				    articleList = articleList.subList(pinnedArticleList.size(), articleList.size());
					articleList = articleList.subList(pinnedArticleList.size(), articleList.size());
				    model.addAttribute("noPinnedArticleList", articleList);
				} else {
					model.addAttribute("noPinnedArticleList", articleList);
				}
			}
	        
		} else {
			// 底下的文章，一篇都没有置顶，全部显示成列表
	        if (articleList.size() > 0) {
	        		model.addAttribute("noPinnedArticleList", articleList);
	        }
		}

		return "news";
	}

	/*
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/hospitalNews" }, method = RequestMethod.GET)
	public String hospitalNews(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
		// model = addTopNav(model);

		// model = addHeader(model);

		model.addAttribute("columnName", HOSPITAL_NEWS_COLUMN_NAME);

		// 获取置顶的新闻
		List<XPWArticle> pinnedNewsList = newsService.getPinnedHospitalNews();
		model.addAttribute("pinnedMediaNewsList", pinnedNewsList);

		PageHelper.startPage(page, PAGE_SIZE);
		List<XPWArticle> noPinnedNewsList = newsService.getNoPinnedHospitalNews();
		model.addAttribute("noPinnedMediaNewsList", noPinnedNewsList);

		PageInfo pageInfo = new PageInfo(noPinnedNewsList);
		model.addAttribute("pageInfo", pageInfo);

		return "news";
	}
	*/

	/**
	 * 影像厦心列表页
	 */
	@ApiOperation(value = "影像厦心列表页", notes = "影像厦心列表页")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/videoNews" }, method = RequestMethod.GET)
	public String videoNews(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
		model = addTopNav(VIDEO_NEWS_COLUMN_ID, model);

		model = addLeftNav(VIDEO_NEWS_COLUMN_ID, model);

		String columnName = columnService.getColumnById(VIDEO_NEWS_COLUMN_ID).getColumnName();
		model.addAttribute("columnName", columnName);

		boolean isPublished = true;

		PageHelper.startPage(page, 6);
		List<XPWVideo> videoList = videoService.index(isPublished);
		PageInfo pageInfo = new PageInfo(videoList);

		model.addAttribute("pageInfo", pageInfo);

		model.addAttribute("videoList", videoList);

		for (XPWVideo video : videoList) {
			if (video.getImgUrl().equals("")) {
				// 默认图片
				video.setImgUrl("/img/pic/pic_002.jpg");
			}
		}
		return "video_list";
	}
	
	/**
     * 患者表扬列表页
     */
    @ApiOperation(value = "患者表扬列表页", notes = "患者表扬列表页")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = { "/patientPraised" }, method = RequestMethod.GET)
    public String patientPraised(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        model = addTopNav(PATIENT_PRAISE_COLUMN_ID, model);

        model = addLeftNav(PATIENT_PRAISE_COLUMN_ID, model);

        String columnName = columnService.getColumnById(PATIENT_PRAISE_COLUMN_ID).getColumnName();
        model.addAttribute("columnName", columnName);

        boolean isPublished = true;

        PageHelper.startPage(page, 6);
//        List<XPWArticle> videoList = videoService.index(isPublished);
        List<XPWArticle> articleList = articleService.index(PATIENT_PRAISE_COLUMN_ID, true);
        PageInfo pageInfo = new PageInfo(articleList);

        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("articleList", articleList);

        for (XPWArticle article : articleList) {
            if (article.getImgUrl().equals("")) {
                // 默认图片
                article.setImgUrl("/img/pic/pic_002.jpg");
            }
        }
        return "patient_list";
    }
	
	/**
     * 在线视频学习列表页
     */
    @ApiOperation(value = "在线视频学习列表页", notes = "在线视频学习列表页")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = { "/onlineVideoNews" }, method = RequestMethod.GET)
    public String onlineVideoNews(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        model = addTopNav(ONLINE_VIDEO_NEWS_COLUMN_ID, model);

        model = addLeftNav(ONLINE_VIDEO_NEWS_COLUMN_ID, model);

        String columnName = columnService.getColumnById(ONLINE_VIDEO_NEWS_COLUMN_ID).getColumnName();
        model.addAttribute("columnName", columnName);

        boolean isPublished = true;

        PageHelper.startPage(page, 6);
        List<XPWOnlineVideo> videoList = onlinevideoService.index(isPublished);
        PageInfo pageInfo = new PageInfo(videoList);

        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("videoList", videoList);

        for (XPWOnlineVideo video : videoList) {
            if (video.getImgUrl().equals("")) {
                // 默认图片
                video.setImgUrl("/img/pic/pic_002.jpg");
            }
        }
        return "online_video_list";
    }

	/**
	 * 影像厦心详情页
	 */
	@ApiOperation(value = "影像厦心详情页", notes = "影像厦心详情页")
	@RequestMapping(value = { "/videoNewsDetail" }, method = RequestMethod.GET)
	public String videoNewsDetail(Model model, @RequestParam Long id) {

		model = addTopNav(VIDEO_NEWS_COLUMN_ID, model);

		model = addLeftNav(VIDEO_NEWS_COLUMN_ID, model);

		String columnName = columnService.getColumnById(VIDEO_NEWS_COLUMN_ID).getColumnName();
		model.addAttribute("columnName", columnName);

		XPWVideo video = videoService.read(id);
		model.addAttribute("video", video);

		return "video_detail";
	}
	
	/**
     * 在线视频详情页
     */
    @ApiOperation(value = "在线视频详情页", notes = "在线视频详情页")
    @RequestMapping(value = { "/onlineVideoNewsDetail" }, method = RequestMethod.GET)
    public String onlineVideoNewsDetail(Model model, @RequestParam Long id) {

        model = addTopNav(ONLINE_VIDEO_NEWS_COLUMN_ID, model);

        model = addLeftNav(ONLINE_VIDEO_NEWS_COLUMN_ID, model);

        String columnName = columnService.getColumnById(ONLINE_VIDEO_NEWS_COLUMN_ID).getColumnName();
        model.addAttribute("columnName", columnName);

        XPWOnlineVideo video = onlinevideoService.read(id);
        model.addAttribute("video", video);

        return "online_video_detail";
    }

	/**
	 * 电子院报列表页
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "电子院报列表页", notes = "电子院报列表页")
	@RequestMapping(value = { "/elecNewsPaper" }, method = RequestMethod.GET)
	public String elecNewsPaper(Model model, @RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "") String year,
			@RequestParam(required = false, defaultValue = "") String times) {

//		List<String> years = newsService.getNewsPaperYears();
//		model.addAttribute("years", years);
//		model.addAttribute("curYear", year);
		
		if (!year.isEmpty() && !times.isEmpty()) {
			List<String> years = newsService.getNewsPaperYears();
			model.addAttribute("years", years);
			model.addAttribute("curYear", year);
			
			List<String> timesList = newsService.getNewsPaperTimes(year);
			model.addAttribute("times", timesList);
			model.addAttribute("curTimes", times);
			
			PageHelper.startPage(1, PAGE_SIZE);

			List<XPWElecNewspaper> list = newsService.getElecNewsPaper(year, times);
			if (list.size() != 0) {
				model.addAttribute("newsPaperList", list);
			}

			PageInfo pageInfo = new PageInfo(list);
			model.addAttribute("pageInfo", pageInfo);
		} else {
			// 获取最新
			List<String> years = newsService.getNewsPaperYears();
			model.addAttribute("years", years);
			model.addAttribute("curYear", years.get(0));
			
			List<String> timesList = newsService.getNewsPaperTimes(years.get(0));
			model.addAttribute("times", timesList);
			model.addAttribute("curTimes", timesList.get(timesList.size() - 1));
			
			PageHelper.startPage(1, PAGE_SIZE);

//			String newsTimes = "";
//			if (timesList.size() < 10) {
//				newsTimes = "0" + (timesList.size() - 1);
//			}
			List<XPWElecNewspaper> list = newsService.getElecNewsPaper(years.get(0), timesList.get(timesList.size() - 1));
			if (list.size() != 0) {
				model.addAttribute("newsPaperList", list);
			}

			PageInfo pageInfo = new PageInfo(list);
			model.addAttribute("pageInfo", pageInfo);
		}
//		List<String> timesList = newsService.getNewsPaperTimes(year);
//		model.addAttribute("times", timesList);
//		model.addAttribute("curTimes", times);

		// 得到最新的
//		if (year.equals("")) {
//			if (years.size() == 0) {
//				year = years.get(0);
//			} else {
//				year = years.get(years.size() - 1);
//			}
//		}
//
//		if (times.equals("")) {
//			if (timesList.size() == 0) {
//				times = timesList.get(0);
//			} else {
//				times = timesList.get(timesList.size() - 1);
//			}
//		}
		// 23是栏目Id，暂时写死
		model = addTopNav(ELEC_NEWS_PAPER_COLUMN_ID, model);

		model = addLeftNav(ELEC_NEWS_PAPER_COLUMN_ID, model);

		String columnName = columnService.getColumnById(ELEC_NEWS_PAPER_COLUMN_ID).getColumnName();
		model.addAttribute("pageName", columnName);

		model.addAttribute("page", page);

		return "news_paper";
	}

	@ApiOperation(value = "获取期数", notes = "根据年份获取期数")
	@RequestMapping(value = { "/getTimes" }, method = RequestMethod.GET)
	public ResponseEntity<?> getTimes(@ApiParam("年份") @RequestParam String year) {
		List<String> times = newsService.getNewsPaperTimes(year);

		return ResponseEntity.status(200).body(times);
	}

	@RequestMapping(value = { "/newsDetail" }, method = RequestMethod.GET)
	public String newsDetail(@RequestParam Long id, Model model, 
	        @RequestParam(required = false, defaultValue = "false")  Boolean isEnglish) {
		XPWArticle article = newsService.getNewsById(id);
		model.addAttribute("article", article);
		long cateId = article.getColumnId();

		// 需要判断同品类
		XPWArticle articlePrev = newsService.getColPrevNewsById(cateId, id);
		model.addAttribute("articlePrev", articlePrev);

		XPWArticle articleNext = newsService.getColNextNewsById(cateId, id);
		model.addAttribute("articleNext", articleNext);
		
		System.out.println("article.getColumnId():" + article.getColumnId());
		System.out.println("isEnglish:" + isEnglish);
		if (isEnglish) {
		    model = addEnglishTopNav(article.getColumnId(), model);
		} else {
		    model = addTopNav(article.getColumnId(), model);
		    model = addLeftNav(article.getColumnId(), model);
		}
		
		if (isEnglish) {
		    model.addAttribute("language", 1);
		} else {
		    model.addAttribute("language", 0);
		}

		return "news_detail";

	}

	@RequestMapping(value = { "/mapDetail" }, method = RequestMethod.GET)
	public String mapDetail(@RequestParam Long id, Model model) {

		XPWColumn column = columnService.getColumnById(id);
		XPWArticle article = new XPWArticle();

		article.setColumnName(column.getColumnName());
		article.setTitle(column.getColumnName());
		article.setPublishTime(column.getPublishTime());

		model.addAttribute("article", article);

		model = addTopNav(id, model);

		model = addLeftNav(id, model);

		return "map_detail";

	}

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @RequestMapping(value = { "/replaceCSS" }, method = RequestMethod.GET)
	// public ResponseEntity<?> replaceCSS() {
	//
	// int pageNo = 1;
	// PageHelper.startPage(pageNo, PAGE_SIZE);
	// List<XPWDept> list = doctorAndDeptService.getDepts();
	// PageInfo pageInfo = new PageInfo(list);
	//
	// do {
	// for (XPWDept dept : list) {
	// String content = dept.getIntro();
	// if (content == null) {
	// continue;
	// }
	// content = delHTMLTag(content);
	// content = content.substring(0, 100);
	// dept.setBrief(content);
	// doctorAndDeptService.updateDept(dept);
	// }
	//
	// pageNo++;
	// PageHelper.startPage(pageNo, PAGE_SIZE);
	// list = doctorAndDeptService.getDepts();
	// } while (pageNo <= pageInfo.getPages());
	//
	// return null;
	// }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = { "/replaceCSS" }, method = RequestMethod.GET)
	public ResponseEntity<?> replaceCSS() {

		int pageNo = 1;
//		PageHelper.startPage(pageNo, PAGE_SIZE);
		List<XPWArticle> list = articleService.index();
//		PageInfo pageInfo = new PageInfo(list);

//		do {
			for (XPWArticle doctor : list) {
				String content = doctor.getContent();
				content = delHTMLTag(content);
				if (content.length() > 200) {
					content = content.substring(0, 200);
				}
				doctor.setBrief(content);
				articleService.update(doctor);
			}

//			pageNo++;
//			PageHelper.startPage(pageNo, PAGE_SIZE);
//			list = articleService.getDisplayDoctors();
//		} while (pageNo <= pageInfo.getPages());

		return null;
	}

	// @RequestMapping(value = { "/uploadImage" }, method = RequestMethod.GET)
	// public ResponseEntity<?> uploadImage(@ApiParam("图片") @RequestParam
	// MultipartFile image) {
	// String imagePath = "";
	// String imageUrl = "";
	// try {
	// imagePath = FileUtil.uploadImage(PathUtil.IMG_STORAGE_PATH, image);
	// } catch (IOException e) {
	// e.printStackTrace();
	// return null;
	// }
	//
	// imageUrl = PathUtil.ORIGIN + File.separator + PathUtil.IMG_FOLDER_PATH +
	// imagePath;
	// return
	// ResponseEntity.status(HttpServletResponse.SC_CREATED).body(imageUrl);
	// }

	public String delHTMLTag(String htmlStr) {
		if (htmlStr != null) {
			String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	
			Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			Matcher m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签
	
			Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			Matcher m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签
	
			htmlStr = htmlStr.replace(" ", "");
			htmlStr = htmlStr.replaceAll("\\s*|\t|\r|\n", "");
			htmlStr = htmlStr.replace("“", "");
			htmlStr = htmlStr.replace("”", "");
			htmlStr = htmlStr.replaceAll("　", "");
			htmlStr = htmlStr.replaceAll("&nbsp;", " ");
	
			return htmlStr.trim(); // 返回文本字符串
		}
		return null;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model, @RequestParam(required = false, defaultValue = "false")  Boolean isEnglish) {
		model = addTopNav(1, model);

		XPWIndex index = indexService.indexRead();

		model.addAttribute("index", index);

		if (isEnglish) {
		    xtIndex(model, true);
		    model.addAttribute("language", 1);
		    return "index_english";
		} else {
		    model.addAttribute("language", 0);
		    return "index";
		}
	}
	
	@RequestMapping(value = { "/registerTime" }, method = RequestMethod.POST)
	public void registerTime(Model model, @RequestParam String doctorCode, @RequestParam String deptCode,
	         @RequestParam String deptName, @RequestParam String doctorName, @RequestParam String workTime,
             @RequestParam String workDateStart, @RequestParam String workDateEnd) {
	    HisUtil.registerTime(deptCode, deptName, doctorCode, doctorName, workTime, workDateStart, workDateEnd);
	}
	
    @RequestMapping(value = { "/departments" }, method = RequestMethod.POST)
    public void departments(Model model, @RequestParam String type, @RequestParam String workTime,
             @RequestParam String workDateStart, @RequestParam String workDateEnd) {
        HisUtil.departments(type, workTime, workDateStart, workDateEnd);
    }
    
    @RequestMapping(value = { "/hisDoctors" }, method = RequestMethod.POST)
    public void hisDoctors(Model model, @RequestParam String type, @RequestParam String deptCode,
            @RequestParam String DeptName, @RequestParam String workDateStart, @RequestParam String workDateEnd) {
        HisUtil.doctors(type, deptCode, DeptName, workDateStart, workDateEnd);
    }
    
    @RequestMapping(value = { "/registeredSource" }, method = RequestMethod.POST)
    public void registeredSource(Model model, @RequestParam String deptCode, @RequestParam String doctorCode,
            @RequestParam String status, @RequestParam String workTime,
            @RequestParam String workDateStart, @RequestParam String workDateEnd) {
        HisUtil.registeredSource(deptCode, doctorCode, status, workTime, workDateStart, workDateEnd);
    }
    
    @RequestMapping(value = { "/registeredSourceTime" }, method = RequestMethod.POST)
    public void registeredSourceTime(Model model, @RequestParam String workDate, @RequestParam String workType,
            @RequestParam String deptCode, @RequestParam String docCode) {
        HisUtil.registeredSourceTime(workDate, workType, deptCode, docCode);
    }
    
    @RequestMapping(value = { "/registered" }, method = RequestMethod.POST)
    public void registered(Model model, @RequestParam String orderId, @RequestParam String idCardNo,
            @RequestParam String cardNo, @RequestParam String mobile,@RequestParam String name,
            @RequestParam String workdate, @RequestParam String workType,@RequestParam String deptCode,
            @RequestParam String docCode, @RequestParam String stime,@RequestParam String userid,
            @RequestParam String customTime, @RequestParam String sickId) {
        HisUtil.registered(orderId, idCardNo, cardNo, mobile, name, workdate, workType, 
                deptCode, docCode, stime, userid, customTime, sickId);
    }
    
    @RequestMapping(value = { "/unRegistered" }, method = RequestMethod.POST)
    public void unRegistered(Model model, @RequestParam String orderId, @RequestParam String seqNumber,
            @RequestParam String reason, @RequestParam String cardNo,@RequestParam String name,
            @RequestParam String workdate, @RequestParam String workType,@RequestParam String deptCode,
            @RequestParam String docCode, @RequestParam String userid,
            @RequestParam String customTime, @RequestParam String sickId) {
        HisUtil.unRegistered(orderId, seqNumber, reason, cardNo, name, 
                workdate, workType, deptCode, docCode, userid, customTime, sickId);
    }
    
    @RequestMapping(value = { "/registerInfo" }, method = RequestMethod.POST)
    public void registerInfo(Model model, @RequestParam String IDCardNo, @RequestParam String seqNumber,
            @RequestParam String workdate, @RequestParam String cardNo,@RequestParam String deptCode,
            @RequestParam String docCode, @RequestParam String status, @RequestParam String sickId) {
        HisUtil.registerInfo(IDCardNo, seqNumber, workdate, cardNo, deptCode, docCode, status, sickId);
    }
    
    @RequestMapping(value = { "/patientInfo" }, method = RequestMethod.POST)
    public void patientInfo(Model model, @RequestParam String IDCardNo, @RequestParam String mobile,
            @RequestParam String name, @RequestParam String cardNo,@RequestParam String mcardNo,
            @RequestParam String sickId) {
        
        System.out.println("request string: " + "\n" +
                "IDCardNo: " + IDCardNo + "\n" + 
                "mobile: " + mobile + "\n" + 
                "name: " + name + "\n" + 
                "cardNo: " + cardNo + "\n" + 
                "mcardNo: " + mcardNo + "\n" +
                "sickId: " + sickId + "\n" );
        HisUtil.patientInfo(IDCardNo, mobile, name, cardNo, mcardNo, sickId);
    }
    
    @RequestMapping(value = { "/noCardRegister" }, method = RequestMethod.POST)
    public void noCardRegister(Model model, @RequestParam String IDCardNo, @RequestParam String mobile,
            @RequestParam String name, @RequestParam String address,@RequestParam String birthDay,
            @RequestParam String sex, @RequestParam String userID) {
        HisUtil.noCardRegister(IDCardNo, mobile, name, address, birthDay, sex, userID);
        System.out.println("request string :" + "\n" +
                "IDCardNo: " + IDCardNo + "\n" + 
                "mobile: " + mobile + "\n" + 
                "name: " + name + "\n" + 
                "address: " + address + "\n" + 
                "birthDay: " + birthDay + "\n" +
                "sex: " + sex + "\n" +
                "userID: " + userID + "\n" 
                );
    }
    @RequestMapping(value = { "/language" }, method = RequestMethod.GET)
    public String language(Model model, @RequestParam(required = false, defaultValue = "false") Boolean isEnglish) {
        System.out.println(isEnglish);
        if (isEnglish) {
            xtIndex(model, true);
            return "index_english";
        } else {
            index(model, false);
            return "index";
        }
    }
    
    @RequestMapping(value = { "/404" }, method = RequestMethod.GET)
    public String notFound(Model model/*, @RequestParam String doctorCode,
            @RequestParam String deptCode, @RequestParam String deptName, @RequestParam String doctorName
            , @RequestParam String workDateStart, @RequestParam String workDateEnd*/) {
        model = addTopNav(1, model);
// 
//        String workTime = "0";
//        
//        String type = "0";
//        String DeptName = "";
//        String status = "2";
//        String workDate = "2017-12-01";// 排班时间 Date
//        String workType = "1";// 排班类别(1上午;2下午)
//        String docCode = "1";//
//        
//        String orderId = "1"; // 订单号
//        String idCardNo = "1"; //身份证
//        String cardNo = "1"; //就诊卡号
//        String mobile = "15167727527"; 
//        String name = "倪军"; 
//        String workdate = "20171201"; 
//        String stime = "08:00:00"; 
//        String userid = ""; //微信号
//        String customTime = "20171201"; //第三方系统时间
//        String sickId = "1"; //病人唯一号
//        
//        String seqNumber = ""; // HIS序号
//        String reason = ""; // 取消原因
//        String IDCardNo = "1"; 
//        String mcardNo = ""; // 医疗保险号
//        String address = ""; // 医疗保险号
//        String birthDay = ""; // 医疗保险号
//        String sex = ""; // 医疗保险号
//        String userID = ""; // 医疗保险号
        

//		TestDb his = HisUtil.testDb();
//		HisUtil.registerTime(deptCode, deptName, doctorCode, doctorName, workTime, workDateStart, workDateEnd);
//		HisUtil.departments(type, workTime, workDateStart, workDateEnd);
//		HisUtil.doctors(type, deptCode, DeptName, workDateStart, workDateEnd);
//		HisUtil.registeredSource(deptCode, doctorCode, status, workTime, workDateStart, workDateEnd);
//		HisUtil.registeredSourceTime(workDate, workType, deptCode, docCode);
//		HisUtil.registered(orderId, idCardNo, cardNo, mobile, name, workdate, workType, 
//		        deptCode, docCode, stime, userid, customTime, sickId);
//		HisUtil.unRegistered(orderId, seqNumber, reason, cardNo, name, 
//		        workdate, workType, deptCode, docCode, userid, customTime, sickId);
//		HisUtil.registerInfo(IDCardNo, seqNumber, workdate, cardNo, deptCode, docCode, status, sickId);
//		HisUtil.patientInfo(IDCardNo, mobile, name, cardNo, mcardNo, sickId);
//		HisUtil.noCardRegister(IDCardNo, mobile, name, address, birthDay, sex, userID);
		
//		model.addAttribute("his", his);

//        XPWIndex index = indexService.indexRead();

//        model.addAttribute("index", index);

        return "404";
    }
	
//	@RequestMapping(value = {"/search" }, method = RequestMethod.GET)
//	public String search(Model model) {
//		model = addTopNav(1, model);
//
//		return "search";
//	}
	

	@RequestMapping(value = { "/xtIndex" }, method = RequestMethod.GET)
	public String xtIndex(Model model, @RequestParam(required = false, defaultValue = "false") Boolean isEnglish) {
		if (isEnglish) {
		    model = addEnglishTopNav(1, model);
		    
		    List<XPWColumnEnglish> firstColList = columnEnglishService.getColumnsByParentId(CHEST_PAIN_COLUMN_ID);
            Map<String, String> xtfirstColumns = new LinkedHashMap<String, String>();
            Map<String, List<XPWColumnEnglish>> secondColList = new LinkedHashMap<String, List<XPWColumnEnglish>>();
            Map<String, List<XPWColumnEnglish>> thirdColList = new LinkedHashMap<String, List<XPWColumnEnglish>>();
            Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();
    
            for (XPWColumnEnglish column : firstColList) {
                List<XPWColumnEnglish> secColList = columnEnglishService.getColumnsByParentId(column.getId());
                xtfirstColumns.put(column.getColumnName(), column.getUrl());
                if (secColList.size() > 0) {
                    secondColList.put(column.getColumnName(), secColList);
                }
    
                for (XPWColumnEnglish newColumn : secColList) {
                    List<XPWColumnEnglish> thiColLost = columnEnglishService.getColumnsByParentId(newColumn.getId());
                    if (thiColLost.size() > 0) {
                        thirdColList.put(newColumn.getColumnName(), thiColLost);
                    }
    
                    List<XPWNav> nav = columnService.getNavListBySecondColumnName(newColumn.getColumnName());
                    if (nav.size() != 0) {
                        navMap.put(newColumn.getColumnName(), nav);
                    }
                }
            }
    
            XPWXTIndex index = indexService.xtIndexRead();
    
            model.addAttribute("firstColList", firstColList);
            model.addAttribute("secondColList", secondColList);
            model.addAttribute("thirdColList", thirdColList);
            model.addAttribute("navMap", navMap);
            model.addAttribute("xtfirstColumns", xtfirstColumns);
            model.addAttribute("index", index);
    
            model.addAttribute("language", 1);
		} else {
		    model = addTopNav(1, model);
		    
        		List<XPWColumn> firstColList = columnService.getColumnsByParentId(CHEST_PAIN_COLUMN_ID);
        		Map<String, String> xtfirstColumns = new LinkedHashMap<String, String>();
        		Map<String, List<XPWColumn>> secondColList = new LinkedHashMap<String, List<XPWColumn>>();
        		Map<String, List<XPWColumn>> thirdColList = new LinkedHashMap<String, List<XPWColumn>>();
        		Map<String, List<XPWNav>> navMap = new LinkedHashMap<String, List<XPWNav>>();
        
        		for (XPWColumn column : firstColList) {
        			List<XPWColumn> secColList = columnService.getColumnsByParentId(column.getId());
        			xtfirstColumns.put(column.getColumnName(), column.getUrl());
        			if (secColList.size() > 0) {
        				secondColList.put(column.getColumnName(), secColList);
        			}
        
        			for (XPWColumn newColumn : secColList) {
        				List<XPWColumn> thiColLost = columnService.getColumnsByParentId(newColumn.getId());
        				if (thiColLost.size() > 0) {
        					thirdColList.put(newColumn.getColumnName(), thiColLost);
        				}
        
        				List<XPWNav> nav = columnService.getNavListBySecondColumnName(newColumn.getColumnName());
        				if (nav.size() != 0) {
        					navMap.put(newColumn.getColumnName(), nav);
        				}
        			}
        		}
        
        		XPWXTIndex index = indexService.xtIndexRead();
        
        		model.addAttribute("firstColList", firstColList);
        		model.addAttribute("secondColList", secondColList);
        		model.addAttribute("thirdColList", thirdColList);
        		model.addAttribute("navMap", navMap);
        		model.addAttribute("xtfirstColumns", xtfirstColumns);
        		model.addAttribute("index", index);
        		
        		model.addAttribute("language", 0);
		}
		return "xt_index";
	}

	@RequestMapping(value = { "/doctorDept" }, method = RequestMethod.GET)
	public String doctorDept(Model model) {
		model = addTopNav(EXPERT_COLUMN_ID, model);
		List<XPWDoctor> doctors = doctorAndDeptService.getDisplayDoctors();
		model.addAttribute("doctors", doctors);

		List<XPWDept> depts = doctorAndDeptService.getOutServiceDepts();
		model.addAttribute("depts", depts);

		return "doctor_dept";
	}
	
   @RequestMapping(value = { "/teacherTeam" }, method = RequestMethod.GET)
    public String teacherTeam(Model model) {
       
       model = addTopNav(TEACHER_COLUMN_ID, model);

       model = addLeftNav(TEACHER_COLUMN_ID, model);

       String columnName = columnService.getColumnById(TEACHER_COLUMN_ID).getColumnName();
       model.addAttribute("columnName", columnName);
       
//       model = addTopNav(TEACHER_COLUMN_ID, model);
       List<XPWTeacher> teachers = teacherTeamService.getDisplayTeachers();
       model.addAttribute("teachers", teachers);

       List<XPWDept> depts = teacherTeamService.getOutServiceDepts();
       model.addAttribute("depts", depts);

       return "teacher_dept";
    }

	@RequestMapping(value = { "/doctorDetail" }, method = RequestMethod.GET)
	public String doctorDetail(@RequestParam Long id, Model model, @RequestParam String deptCode, 
	        @RequestParam(required = false, defaultValue = "0") String status, @RequestParam String workTime) {
		model = addTopNav(EXPERT_COLUMN_ID, model);

		XPWDoctor doctor = doctorAndDeptService.getDoctorAndDeptById(id);
		model.addAttribute("doctor", doctor);
		
		DateTime workDateStart = new DateTime();
//        workDateStart = workDateStart.withDayOfWeek(1);
        DateTime workDateEnd = workDateStart.plusDays(6);
        
        Map<String, String> currentWeek = new LinkedHashMap<String, String>();
        DateTime temp = workDateStart.withDayOfWeek(1);
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                currentWeek.put("星期一", temp.toString("yyyy-MM-dd"));
            } else if (i == 1) {
                currentWeek.put("星期二", temp.toString("yyyy-MM-dd"));
            } else if (i == 2) {
                currentWeek.put("星期三", temp.toString("yyyy-MM-dd"));
            } else if (i == 3) {
                currentWeek.put("星期四", temp.toString("yyyy-MM-dd"));
            } else if (i == 4) {
                currentWeek.put("星期五", temp.toString("yyyy-MM-dd"));
            } else if (i == 5) {
                currentWeek.put("星期六", temp.toString("yyyy-MM-dd"));
            } else {
                currentWeek.put("星期天", temp.toString("yyyy-MM-dd"));
            }
            
            temp = temp.plusDays(1);
        }
        model.addAttribute("currentWeek", currentWeek);
		
        System.out.println("request string :" + "\n" +
                "deptCode: " + deptCode + "\n" + 
                "doctorCode: " + String.valueOf(doctor.getHisId()) + "\n" + 
                "status: " + status + "\n" + 
                "workTime: " + workTime + "\n" + 
                "workDateStart: " + workDateStart.toString("yyyy-MM-dd") + "\n" + 
                "workDateEnd: " + workDateEnd.toString("yyyy-MM-dd") + "\n" 
                );
        
        RegisteredSource rs = HisUtil.registeredSource(deptCode, String.valueOf(doctor.getHisId()), status, workTime, 
                workDateStart.toString("yyyy-MM-dd"), workDateEnd.toString("yyyy-MM-dd"));
//        String resp = "<Resp><TransactionCode>JK2004</TransactionCode><RespCode>0</RespCode><RespMessage>成功</RespMessage><CountNum>2</CountNum><PreInfo><WorkDate>2017-12-01</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259776</DocCode><DeptName>心外科门诊</DeptName><DocName>孙勇</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-02</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259776</DocCode><DeptName>心外科门诊</DeptName><DocName>孙勇</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>6</SpaceTime><PreLimit>20</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>20</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo></Resp>";
//        System.out.println("4.4 RegisteredSource \n" + resp);
//        RegisteredSource rs = (RegisteredSource)XmlUtil.xmlToObject(resp, RegisteredSource.class);
        List<String> isForenoonVisits = new ArrayList(7);
        List<String> isAfternoonVisits = new ArrayList(7);
        int counter = 0;
        
        if (rs.getRespCode().equals("-1")) {
            for (int i = 0; i < 7; i++) {
                isForenoonVisits.add("-1");
                isAfternoonVisits.add("-1");
            }
            model.addAttribute("isForenoonVisits", isForenoonVisits);
            model.addAttribute("isAfternoonVisits", isAfternoonVisits);
        } else {
            for (String day : currentWeek.values()) {
                isForenoonVisits.add("-1");
                isAfternoonVisits.add("-1");
                for (int j = 0; j < rs.getPreInfo().size(); j++) {
                    RegisteredSourcePreInfo preInfo = rs.getPreInfo().get(j);
                    if (preInfo.getWorkType().equals("1")) {
                        // 上午
                        if (day.equals(preInfo.getWorkDate())) {
                            isForenoonVisits.set(counter, "0");
                        }
                        continue;
                    } 
                    if (preInfo.getWorkType().equals("2")) {
                        // 下午
                        if (day.equals(preInfo.getWorkDate())) {
                            isAfternoonVisits.set(counter, "0");
                        }
                        continue;
                    }
                }
                counter++;
            }
            model.addAttribute("isForenoonVisits", isForenoonVisits);
            model.addAttribute("isAfternoonVisits", isAfternoonVisits);
        }
        System.out.println(rs);
        System.out.println(isForenoonVisits);
        System.out.println(isAfternoonVisits);
//		RegisteredSource registeredSource = HisUtil.registeredSource(deptCode, doctorCode, status, workTime, workDateStart, workDateEnd);
//		model.addAttribute("registeredSource", registeredSource);
		// model.addAttribute("dept", doctor.getDept());
		return "doctor_detail";
	}
	
	 public static RegisteredSource registeredSource(String deptCode, String doctorCode, String status,
	            String workTime, String workDateStart, String workDateEnd) {
	        String requestXml = "<Req>" +
	                "<oracode>00002</oracode>" +
	                "<oraauthcode>ZS20171211</oraauthcode>" +
	                "<TransactionCode>JK2004</TransactionCode>" +
	                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
	                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
	                "<DoctorCode>" + doctorCode + "</DoctorCode>" +
	                "<DeptCode>" + deptCode + "</DeptCode>" +
	                "<WorkTime>" + workTime + "</WorkTime>" +
	                "<Status>" + status + "</Status>" +
	                "</Req>";
	        String tradeCode = "JK2004";
	        Service1 service = new Service1();
	        Service1Soap service1Soap =  service.getService1Soap();
	        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
	        System.out.println("4.4 RegisteredSource \n" + retMsg);
	        return (RegisteredSource)XmlUtil.xmlToObject(retMsg, RegisteredSource.class);
	    }
	
	public static void main(String[] args) {
        DateTime workDateStart = new DateTime();
//        workDateStart = workDateStart.withDayOfWeek(1);
        DateTime workDateEnd = workDateStart.plusDays(6);
        
        List<String> week = new ArrayList();
        DateTime temp = workDateStart.withDayOfWeek(1);
        do {
            week.add(temp.toString("yyyy-MM-dd"));
            temp = temp.plusDays(1);
        } while (temp.isBefore(workDateEnd.plusDays(1)));
        
        int dayOfWeek2 = workDateStart.getDayOfWeek();
        System.out.println(dayOfWeek2);
        System.out.println(week);
//        System.out.println("workDateStart.toString(\"yyyy-MM-dd\")" + workDateStart.toString("yyyy-MM-dd"));
//        System.out.println("workDateEnd.toString(\"yyyy-MM-dd\")" + workDateEnd.toString("yyyy-MM-dd"));
    }
	
    @RequestMapping(value = { "/teacherDetail" }, method = RequestMethod.GET)
    public String teacherDetail(@RequestParam Long id, Model model) {
        model = addTopNav(TEACHER_COLUMN_ID, model);

        XPWTeacher teacher = teacherTeamService.getTeacherAndDeptById(id);
        model.addAttribute("doctor", teacher);
        return "teacher_detail";
    }

	@RequestMapping(value = { "/deptDoctor" }, method = RequestMethod.GET)
	public String deptDoctor(@RequestParam Long id, Model model,
	        @RequestParam String deptCode, @RequestParam String doctorCode,
            @RequestParam String status, @RequestParam String workTime) {
		model = addTopNav(3l, model);

		XPWIndex index = indexService.indexRead();
        model.addAttribute("index", index);
        
        XPWDept dept = doctorAndDeptService.getDeptAndDoctorsById(id);
        model.addAttribute("dept", dept);
        
        DateTime workDateStart = new DateTime();
//        workDateStart = workDateStart.withDayOfWeek(1);
        DateTime workDateEnd = workDateStart.plusDays(6);
        
        Map<String, String> currentWeek = new LinkedHashMap<String, String>();
        DateTime temp = workDateStart.plusDays(0);
        for (int i = 0; i < 7; i++) {
            int dayOfWeek = temp.getDayOfWeek();
            if (dayOfWeek == 1) {
                currentWeek.put("星期一", temp.toString("yyyy-MM-dd"));
            } else if (dayOfWeek == 2) {
                currentWeek.put("星期二", temp.toString("yyyy-MM-dd"));
            } else if (dayOfWeek == 3) {
                currentWeek.put("星期三", temp.toString("yyyy-MM-dd"));
            } else if (dayOfWeek == 4) {
                currentWeek.put("星期四", temp.toString("yyyy-MM-dd"));
            } else if (dayOfWeek == 5) {
                currentWeek.put("星期五", temp.toString("yyyy-MM-dd"));
            } else if (dayOfWeek == 6) {
                currentWeek.put("星期六", temp.toString("yyyy-MM-dd"));
            } else {
                currentWeek.put("星期天", temp.toString("yyyy-MM-dd"));
            }
            
            temp = temp.plusDays(1);
        }
        model.addAttribute("currentWeek", currentWeek);
        System.out.println("request string :" + "\n" +
                "deptCode: " + deptCode + "\n" + 
                "doctorCode: " + doctorCode + "\n" + 
                "status: " + status + "\n" + 
                "workTime: " + workTime + "\n" + 
                "workDateStart: " + workDateStart.toString("yyyy-MM-dd") + "\n" + 
                "workDateEnd: " + workDateEnd.toString("yyyy-MM-dd") + "\n" 
                );
        
//        System.out.println("request string :" + "\n" +
//                "type: " + type + "\n" + 
//                "workTime: " + workTime + "\n" + 
//                "workDateStart: " + workDateStart.toString("yyyy-MM-dd") + "\n" + 
//                "workDateEnd: " + workDateEnd.toString("yyyy-MM-dd") + "\n" 
//                );
        
//        Departments rs = HisUtil.departments(type, workTime, workDateStart.toString("yyyy-MM-dd"), workDateEnd.toString("yyyy-MM-dd"));
//        String resp = "<Resp><TransactionCode>JK2002</TransactionCode><RespCode>0</RespCode><RespMessage>成功</RespMessage><UpperDept><UpperDeptCode>41000</UpperDeptCode><UpperDeptName>胸痛中心</UpperDeptName><Dept><DeptCode>41000</DeptCode><DeptName>胸痛中心</DeptName><DeptLocus>ccc</DeptLocus><Memo>ddd</Memo><Date><WorkDate></WorkDate></Date></Dept></UpperDept><UpperDept><UpperDeptCode>30100</UpperDeptCode><UpperDeptName>心内科门诊</UpperDeptName><Dept><DeptCode>30100</DeptCode><DeptName>心内科门诊</DeptName><DeptLocus>5号楼4楼</DeptLocus><Memo>ddd</Memo><Date><WorkDate>2017-12-07</WorkDate><WorkDate>2017-12-05</WorkDate><WorkDate>2017-12-08</WorkDate><WorkDate>2017-12-06</WorkDate><WorkDate>2017-12-04</WorkDate><WorkDate>2017-12-03</WorkDate></Date></Dept></UpperDept><UpperDept><UpperDeptCode>30200</UpperDeptCode><UpperDeptName>心外科门诊</UpperDeptName><Dept><DeptCode>30200</DeptCode><DeptName>心外科门诊</DeptName><DeptLocus>5号楼4楼</DeptLocus><Memo>ddd</Memo><Date><WorkDate>2017-12-07</WorkDate><WorkDate>2017-12-05</WorkDate><WorkDate>2017-12-08</WorkDate><WorkDate>2017-12-04</WorkDate><WorkDate>2017-12-06</WorkDate><WorkDate>2017-12-03</WorkDate></Date></Dept></UpperDept><UpperDept><UpperDeptCode>30300</UpperDeptCode><UpperDeptName>预约中心</UpperDeptName><Dept><DeptCode>30300</DeptCode><DeptName>预约中心</DeptName><DeptLocus>ccc</DeptLocus><Memo>ddd</Memo><Date><WorkDate></WorkDate></Date></Dept></UpperDept><UpperDept><UpperDeptCode>30400</UpperDeptCode><UpperDeptName>超声科门诊</UpperDeptName><Dept><DeptCode>30400</DeptCode><DeptName>超声科门诊</DeptName><DeptLocus>5号楼8楼</DeptLocus><Memo>ddd</Memo><Date><WorkDate></WorkDate></Date></Dept></UpperDept></Resp>";
//        Departments rs = (Departments)XmlUtil.xmlToObject(resp, Departments.class);
//        System.out.println("4.2 departments \n" + resp);
        
//        List<String> isVisits = new ArrayList(7);
//        Map<String, String> isVisits = new LinkedHashMap<String, String>();
//        int counter = 0;
//        // 上午
//        if (rs.getRespCode().equals("-1")) {
//            for (String day : currentWeek.values()) {
//                isVisits.put(day, "-1");
//            }
//            model.addAttribute("isVisits", isVisits);
//        } else {
//            for (String day : currentWeek.values()) {
//                isVisits.put(day, "-1");
//                for (int j = 0; j < rs.getUpperDept().size(); j++) {
//                    Department department = rs.getUpperDept().get(j);
//                    List<String> workDates = department.getDept().getDate().getWorkDate();
//                    for (int k = 0; k < department.getDept().getDate().getWorkDate().size(); k++) {
//                        if (workDates.get(k).equals(day)) {
//                            isVisits.put(day, "0");
//                        }
//                    }
//                }
//                counter++;
//            }
//            model.addAttribute("isVisits", isVisits);
//        }
       
        RegisteredSource ret = HisUtil.registeredSource(deptCode, doctorCode, status, workTime, workDateStart.toString("yyyy-MM-dd"), workDateEnd.toString("yyyy-MM-dd"));
        
        // TODO 注意，注意，这里一定要注意
//        String res = "<Resp><TransactionCode>JK2004</TransactionCode><RespCode>0</RespCode><RespMessage>成功</RespMessage><CountNum>59</CountNum><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259729</DocCode><DeptName>心内科门诊</DeptName><DocName>陈炳煌</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:05:00</STime><ETime>11:30:00</ETime><SpaceTime>8</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259944</DocCode><DeptName>心内科门诊</DeptName><DocName>傅国根</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>35</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>35</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>261164</DocCode><DeptName>心内科门诊</DeptName><DocName>王建</DocName><TitleName>医师</TitleName><TitleCode>025</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>45</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>45</PreNum><Remark>普通号</Remark><CliniqueCode>诊室3</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259748</DocCode><DeptName>心内科门诊</DeptName><DocName>郑剑涛</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>261624</DocCode><DeptName>心内科门诊</DeptName><DocName>郑明日</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259777</DocCode><DeptName>心外科门诊</DeptName><DocName>伍源</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:30:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259752</DocCode><DeptName>心外科门诊</DeptName><DocName>杨谦</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:45:00</STime><ETime>11:30:00</ETime><SpaceTime>6</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259734</DocCode><DeptName>心内科门诊</DeptName><DocName>陈伟斌</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:35:00</STime><ETime>17:18:00</ETime><SpaceTime>7</SpaceTime><PreLimit>23</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>23</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>261144</DocCode><DeptName>心内科门诊</DeptName><DocName>戴翠莲</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259944</DocCode><DeptName>心内科门诊</DeptName><DocName>傅国根</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>35</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>35</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259739</DocCode><DeptName>心内科门诊</DeptName><DocName>江宏飞</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259726</DocCode><DeptName>心内科门诊</DeptName><DocName>王斌</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259747</DocCode><DeptName>心内科门诊</DeptName><DocName>曾昭萍</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:05:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>0</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>0</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259773</DocCode><DeptName>心外科门诊</DeptName><DocName>强海峰</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259776</DocCode><DeptName>心外科门诊</DeptName><DocName>孙勇</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259732</DocCode><DeptName>心内科门诊</DeptName><DocName>蔡彬妮</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:45:00</STime><ETime>17:30:00</ETime><SpaceTime>6</SpaceTime><PreLimit>24</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>24</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>262145</DocCode><DeptName>心内科门诊</DeptName><DocName>李强</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:00:00</ETime><SpaceTime>8</SpaceTime><PreLimit>22</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>22</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259741</DocCode><DeptName>心内科门诊</DeptName><DocName>刘文辉</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259727</DocCode><DeptName>心内科门诊</DeptName><DocName>叶涛</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259773</DocCode><DeptName>心外科门诊</DeptName><DocName>强海峰</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>25</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-12</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259776</DocCode><DeptName>心外科门诊</DeptName><DocName>孙勇</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>6</SpaceTime><PreLimit>20</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>20</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>261144</DocCode><DeptName>心内科门诊</DeptName><DocName>戴翠莲</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259741</DocCode><DeptName>心内科门诊</DeptName><DocName>刘文辉</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>8</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259745</DocCode><DeptName>心内科门诊</DeptName><DocName>王挹青</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>07:50:00</STime><ETime>11:45:00</ETime><SpaceTime>10</SpaceTime><PreLimit>22</PreLimit><Status>0</Status><RegistCode>7</RegistCode><RegistName>特需专家</RegistName><PreNum>22</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>150</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259747</DocCode><DeptName>心内科门诊</DeptName><DocName>曾昭萍</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259771</DocCode><DeptName>心外科门诊</DeptName><DocName>郝晓斌</DocName><TitleName>医师</TitleName><TitleCode>025</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259772</DocCode><DeptName>心外科门诊</DeptName><DocName>林智</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:50:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259740</DocCode><DeptName>心内科门诊</DeptName><DocName>李琳琳</DocName><TitleName>主治医师</TitleName><TitleCode>024</TitleCode><STime>14:35:00</STime><ETime>17:15:00</ETime><SpaceTime>4</SpaceTime><PreLimit>0</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>0</PreNum><Remark>普通号</Remark><CliniqueCode>诊室7</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259748</DocCode><DeptName>心内科门诊</DeptName><DocName>郑剑涛</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:35:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>261624</DocCode><DeptName>心内科门诊</DeptName><DocName>郑明日</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259749</DocCode><DeptName>心内科门诊</DeptName><DocName>周法光</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-15</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259771</DocCode><DeptName>心外科门诊</DeptName><DocName>郝晓斌</DocName><TitleName>医师</TitleName><TitleCode>025</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>4</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-16</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259729</DocCode><DeptName>心内科门诊</DeptName><DocName>陈炳煌</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>9</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>7</RegistCode><RegistName>特需专家</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>150</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-16</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259745</DocCode><DeptName>心内科门诊</DeptName><DocName>王挹青</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>07:50:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259746</DocCode><DeptName>心内科门诊</DeptName><DocName>肖国胜</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:35:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259772</DocCode><DeptName>心外科门诊</DeptName><DocName>林智</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-11</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259777</DocCode><DeptName>心外科门诊</DeptName><DocName>伍源</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259725</DocCode><DeptName>心内科门诊</DeptName><DocName>黄卫斌</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>4</SpaceTime><PreLimit>40</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>40</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259727</DocCode><DeptName>心内科门诊</DeptName><DocName>叶涛</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:05:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259749</DocCode><DeptName>心内科门诊</DeptName><DocName>周法光</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259754</DocCode><DeptName>心外科门诊</DeptName><DocName>邱风</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>09:00:00</STime><ETime>11:30:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259774</DocCode><DeptName>心外科门诊</DeptName><DocName>饶健</DocName><TitleName>主治医师</TitleName><TitleCode>024</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>4</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259724</DocCode><DeptName>心内科门诊</DeptName><DocName>陈水龙</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259738</DocCode><DeptName>心内科门诊</DeptName><DocName>郭晋村</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259731</DocCode><DeptName>心内科门诊</DeptName><DocName>李桂阳</DocName><TitleName>主治医师</TitleName><TitleCode>024</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>0</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>0</PreNum><Remark>普通号</Remark><CliniqueCode>诊室7</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259764</DocCode><DeptName>心内科门诊</DeptName><DocName>王焱</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>14:38:00</STime><ETime>17:20:00</ETime><SpaceTime>8</SpaceTime><PreLimit>20</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>20</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-14</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259774</DocCode><DeptName>心外科门诊</DeptName><DocName>饶健</DocName><TitleName>主治医师</TitleName><TitleCode>024</TitleCode><STime>14:45:00</STime><ETime>17:00:00</ETime><SpaceTime>4</SpaceTime><PreLimit>20</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>20</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-17</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259994</DocCode><DeptName>心内科门诊</DeptName><DocName>李枚娟</DocName><TitleName>主治医师</TitleName><TitleCode>024</TitleCode><STime>07:30:00</STime><ETime>11:45:00</ETime><SpaceTime>4</SpaceTime><PreLimit>45</PreLimit><Status>0</Status><RegistCode>2</RegistCode><RegistName>急诊号</RegistName><PreNum>45</PreNum><Remark>急诊号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>20</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259729</DocCode><DeptName>心内科门诊</DeptName><DocName>陈炳煌</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:05:00</STime><ETime>11:30:00</ETime><SpaceTime>8</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259734</DocCode><DeptName>心内科门诊</DeptName><DocName>陈伟斌</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:05:00</STime><ETime>11:45:00</ETime><SpaceTime>7</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>30</PreNum><Remark>专家号</Remark><CliniqueCode>诊室4</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259725</DocCode><DeptName>心内科门诊</DeptName><DocName>黄卫斌</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:00:00</STime><ETime>11:45:00</ETime><SpaceTime>4</SpaceTime><PreLimit>40</PreLimit><Status>0</Status><RegistCode>3</RegistCode><RegistName>专家号</RegistName><PreNum>40</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>40</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30100</DeptCode><DocCode>259746</DocCode><DeptName>心内科门诊</DeptName><DocName>肖国胜</DocName><TitleName>主任医师</TitleName><TitleCode>022</TitleCode><STime>08:05:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>4</RegistCode><RegistName>主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>28</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>261366</DocCode><DeptName>心外科门诊</DeptName><DocName>刘菲</DocName><TitleName>无</TitleName><TitleCode>053</TitleCode><STime>09:00:00</STime><ETime>11:45:00</ETime><SpaceTime>5</SpaceTime><PreLimit>30</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>30</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>1</WorkType><DeptCode>30200</DeptCode><DocCode>259778</DocCode><DeptName>心外科门诊</DeptName><DocName>尤颢</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>08:45:00</STime><ETime>11:45:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259724</DocCode><DeptName>心内科门诊</DeptName><DocName>陈水龙</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室5</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259739</DocCode><DeptName>心内科门诊</DeptName><DocName>江宏飞</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:30:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室9</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>2</WorkType><DeptCode>30100</DeptCode><DocCode>259726</DocCode><DeptName>心内科门诊</DeptName><DocName>王斌</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>14:35:00</STime><ETime>17:00:00</ETime><SpaceTime>6</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>25</PreNum><Remark>专家号</Remark><CliniqueCode>诊室6</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>261366</DocCode><DeptName>心外科门诊</DeptName><DocName>刘菲</DocName><TitleName>无</TitleName><TitleCode>053</TitleCode><STime>15:00:00</STime><ETime>17:00:00</ETime><SpaceTime>5</SpaceTime><PreLimit>25</PreLimit><Status>0</Status><RegistCode>1</RegistCode><RegistName>普通号</RegistName><PreNum>25</PreNum><Remark>普通号</Remark><CliniqueCode>诊室2</CliniqueCode> <ClinicFee>13</ClinicFee> <QueryType>2</QueryType> </PreInfo><PreInfo><WorkDate>2017-12-13</WorkDate><WorkType>2</WorkType><DeptCode>30200</DeptCode><DocCode>259778</DocCode><DeptName>心外科门诊</DeptName><DocName>尤颢</DocName><TitleName>副主任医师</TitleName><TitleCode>023</TitleCode><STime>15:00:00</STime><ETime>17:15:00</ETime><SpaceTime>6</SpaceTime><PreLimit>20</PreLimit><Status>0</Status><RegistCode>5</RegistCode><RegistName>副主任号</RegistName><PreNum>20</PreNum><Remark>专家号</Remark><CliniqueCode>诊室1</CliniqueCode> <ClinicFee>23</ClinicFee> <QueryType>1</QueryType> </PreInfo></Resp>";
//        RegisteredSource ret = (RegisteredSource)XmlUtil.xmlToObject(res, RegisteredSource.class);
//        System.out.println("4.4 RegisteredSource \n" + res);
        
        Map<String, Set<HisDoctor>> visits = new LinkedHashMap<String, Set<HisDoctor>>();
        Iterator<String> iterator = currentWeek.values().iterator();
        while (iterator.hasNext()) {
            String current = iterator.next();
            
            HisDoctorComparator comparator = new HisDoctorComparator();
            Set<HisDoctor> doctors = new TreeSet<HisDoctor>(comparator);
//            SortedSet<HisDoctor> set = new TreeSet<HisDoctor>(comparator);
            for (int i = 0; i < ret.getPreInfo().size(); i++) {
                if (dept.getHisId().toString().equals(ret.getPreInfo().get(i).getDeptCode())) {
                    // 当前科室
                    if (current.equals(ret.getPreInfo().get(i).getWorkDate())) {
                        // 当前这一天
                        if (ret.getPreInfo().get(i).getWorkType().equals("1")) {
                            // 上午
                            HisDoctor doc = new HisDoctor();
                            doc.setName(ret.getPreInfo().get(i).getDocName());
                            doc.setWorkType(1);
                            doctors.add(doc);
                        } else {
                            // 下午
                            HisDoctor doc = new HisDoctor();
                            doc.setName(ret.getPreInfo().get(i).getDocName());
                            doc.setWorkType(2);
                            doctors.add(doc);
                        }
                    }
                }
            }
            visits.put(current, doctors);
        }
        model.addAttribute("visits", visits);
        
//		System.out.println(isVisits);
		System.out.println(visits);
		return "dept_doctor";
	}

	@RequestMapping(value = { "/deptDetail" }, method = RequestMethod.GET)
	public String deptDetail(@RequestParam Long id, Model model) {
		model = addTopNav(3l, model);

		XPWDept dept = doctorAndDeptService.getDeptAndDoctorsById(id);
		model.addAttribute("dept", dept);
		// model.addAttribute("dept", doctor.getDept());
		return "dept_detail";
	}
	
}