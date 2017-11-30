package com.xmheart.frontend.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.xmheart.util.HisUtil;
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
import com.xmheart.model.XPWDept;
import com.xmheart.model.XPWDoctor;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWIndex;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWOnlineVideo;
import com.xmheart.model.XPWTeacher;
import com.xmheart.model.XPWXTIndex;
import com.xmheart.model.XPWVideo;
import com.xmheart.model.XPWArticle;
import com.xmheart.service.ArticleService;
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

import com.xmheart.his.Response.*;

@Controller
public class NewsController {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Autowired
	private ColumnService columnService;

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
					List<XPWNav> secondColNavList = columnService.getNavsByChildColumnName(nav.getChildColumnName());
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
	public String newsDetail(@RequestParam Long id, Model model) {
		XPWArticle article = newsService.getNewsById(id);
		model.addAttribute("article", article);
		long cateId = article.getColumnId();

		// 需要判断同品类
		XPWArticle articlePrev = newsService.getColPrevNewsById(cateId, id);
		model.addAttribute("articlePrev", articlePrev);

		XPWArticle articleNext = newsService.getColNextNewsById(cateId, id);
		model.addAttribute("articleNext", articleNext);

		model = addTopNav(article.getColumnId(), model);

		model = addLeftNav(article.getColumnId(), model);

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
	public String index(Model model) {
		model = addTopNav(1, model);

		XPWIndex index = indexService.indexRead();

		model.addAttribute("index", index);

		return "index";
	}
	
    @RequestMapping(value = { "/404" }, method = RequestMethod.GET)
    public String notFound(Model model) {
        model = addTopNav(1, model);



		TestDb his = HisUtil.testDb();

		model.addAttribute("his", his);

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
	public String xtIndex(Model model) {
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
	public String doctorInfo(@RequestParam Long id, Model model) {
		model = addTopNav(EXPERT_COLUMN_ID, model);

		XPWDoctor doctor = doctorAndDeptService.getDoctorAndDeptById(id);
		model.addAttribute("doctor", doctor);
		// model.addAttribute("dept", doctor.getDept());
		return "doctor_detail";
	}
	
    @RequestMapping(value = { "/teacherDetail" }, method = RequestMethod.GET)
    public String teacherInfo(@RequestParam Long id, Model model) {
        model = addTopNav(TEACHER_COLUMN_ID, model);

        XPWTeacher teacher = teacherTeamService.getTeacherAndDeptById(id);
        model.addAttribute("doctor", teacher);
        return "teacher_detail";
    }

	@RequestMapping(value = { "/deptDoctor" }, method = RequestMethod.GET)
	public String deptDoctor(@RequestParam Long id, Model model) {
		model = addTopNav(3l, model);

		XPWDept dept = doctorAndDeptService.getDeptAndDoctorsById(id);
		model.addAttribute("dept", dept);
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