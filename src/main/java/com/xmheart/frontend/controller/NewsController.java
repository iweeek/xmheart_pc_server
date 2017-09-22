package com.xmheart.frontend.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmheart.util.FileUtil;
import com.xmheart.util.PathUtil;
import com.xmheart.model.XPWArticleWithBLOBs;
import com.xmheart.model.XPWColumn;
import com.xmheart.model.XPWElecNewspaper;
import com.xmheart.model.XPWNav;
import com.xmheart.model.XPWArticle;
import com.xmheart.service.ColumnService;
import com.xmheart.service.NewsService;

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
    private NewsService newsService;

    private final int PAGE_SIZE = 10;

    private final String NEWS_COLUMN_NAME = "新闻公告";
    private final String MEDIA_NEWS_COLUMN_NAME = "媒体看厦心";
    private final String HOSPITAL_NEWS_COLUMN_NAME = "医院新闻";
    private final String VIDEO_NEWS_COLUMN_NAME = "影像厦心";
    private final String ELECPAPER_NEWS_COLUMN_NAME = "电子院报";

    static final long NEWS_COLUMN_ID = 5;
    static final long EXPERT_COLUMN_ID = 3;

    // private static Map<String, String> secColumns = new HashMap<String,
    // String>();

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
        model.addAttribute("firstColumnName", NEWS_COLUMN_NAME);

        return model;
    }

    private Model addNewsHeader(Model model) {
        List<XPWColumn> list = columnService.getChildColumnsById(NEWS_COLUMN_ID);
        model.addAttribute("listMainNav", list);

        model.addAttribute("parentColumnName", NEWS_COLUMN_NAME);

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
    @RequestMapping(value = { "/mediaNews" }, method = RequestMethod.GET)
    public String mediaNews(@RequestParam(required = false, defaultValue = "1") Integer pageNo, Model model) {
        model = addCommonHeader(model);

        model = addNewsHeader(model);

        model.addAttribute("columnName", MEDIA_NEWS_COLUMN_NAME);

        // 获取置顶的新闻
        List<XPWArticle> pinnedMediaNewsList = newsService.getPinnedMediaNews();
        model.addAttribute("pinnedMediaNewsList", pinnedMediaNewsList);

        PageHelper.startPage(pageNo, PAGE_SIZE);
        List<XPWArticle> noPinnedMediaNewsList = newsService.getNoPinnedMediaNews();
        model.addAttribute("noPinnedMediaNewsList", noPinnedMediaNewsList);

        PageInfo pageInfo = new PageInfo(noPinnedMediaNewsList);
        model.addAttribute("pageInfo", pageInfo);

        return "news";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = { "/hospitalNews" }, method = RequestMethod.GET)
    public String hospitalNews(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        model = addCommonHeader(model);

        model = addNewsHeader(model);

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

    /**
     * 影像厦心列表页
     */
    @ApiOperation(value = "影像厦心列表页", notes = "影像厦心列表页")
    @RequestMapping(value = { "/videoNews" }, method = RequestMethod.GET)
    public String videoNews(Model model, @RequestParam(required = false) Integer page) {

        if (page == null) {
            page = new Integer(1);
        }

        model = addCommonHeader(model);

        model = addNewsHeader(model);

        model.addAttribute("columnName", VIDEO_NEWS_COLUMN_NAME);

        // model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);
        //
        // PageHelper.startPage(page, PAGE_SIZE);
        //
        // List<XPWElecNewspaper> list = newsService.getElecNewsPaper();
        // model.addAttribute("newsPaperList", list);
        //
        // PageInfo pageInfo = new PageInfo(list);
        // model.addAttribute("pageInfo", pageInfo);

        return "video";
    }

    /**
     * 影像厦心详情页
     */
    @ApiOperation(value = "影像厦心详情页", notes = "影像厦心详情页")
    @RequestMapping(value = { "/videoNewsDetail" }, method = RequestMethod.GET)
    public String videoNewsDetail(Model model, @RequestParam(required = false) Integer page) {

        if (page == null) {
            page = new Integer(1);
        }

        model = addCommonHeader(model);

        model = addNewsHeader(model);

        model.addAttribute("columnName", VIDEO_NEWS_COLUMN_NAME);

        // model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);
        //
        // PageHelper.startPage(page, PAGE_SIZE);
        //
        // List<XPWElecNewspaper> list = newsService.getElecNewsPaper();
        // model.addAttribute("newsPaperList", list);
        //
        // PageInfo pageInfo = new PageInfo(list);
        // model.addAttribute("pageInfo", pageInfo);

        return "video_img_detail";
    }

    /**
     * 电子院报列表页
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiOperation(value = "电子院报列表页", notes = "电子院报列表页")
    @RequestMapping(value = { "/elecNewsPaper" }, method = RequestMethod.GET)
    public String elecNewsPaper(Model model, @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer itemIndex, @RequestParam(required = false) String year,
            @RequestParam(required = false) String time) {

        if (page == null) {
            page = new Integer(1);
        }
        if (itemIndex == null) {
            itemIndex = new Integer(0);
        }
        if (year == null) {
            year = "";
        }
        if (time == null) {
            time = "";
        }
        model = addCommonHeader(model);

        model = addNewsHeader(model);

        model.addAttribute("pageName", ELECPAPER_NEWS_COLUMN_NAME);

        PageHelper.startPage(page, PAGE_SIZE);

        List<XPWElecNewspaper> list = newsService.getElecNewsPaper(year, time);
        model.addAttribute("newsPaperList", list);

        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo", pageInfo);

        List<String> years = newsService.getNewsPaperYears();
        model.addAttribute("years", years);

        List<String> times = newsService.getNewsPaperTimes(years.get(0));
        model.addAttribute("times", times);

        model.addAttribute("itemIndex", itemIndex);

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
        model = addCommonHeader(model);

        model = addNewsHeader(model);

        XPWArticle article = newsService.getNewsById(id);
        model.addAttribute("article", article);

        return "news_detail";

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value = { "/replaceCSS" }, method = RequestMethod.GET)
    public ResponseEntity<?> replaceCSS() {

        int pageNo = 1;
        PageHelper.startPage(pageNo, PAGE_SIZE);
        List<XPWArticle> list = newsService.getNews();
        PageInfo pageInfo = new PageInfo(list);

        do {
            for (XPWArticle news : list) {
                String content = news.getContent();
                content = delHTMLTag(content);
                news.setContent(content);
                newsService.updateNews(news);
            }

            pageNo++;
            PageHelper.startPage(pageNo, PAGE_SIZE);
            list = newsService.getNews();
        } while (pageNo <= pageInfo.getPages());

        return null;

    }

    @RequestMapping(value = { "/uploadImage" }, method = RequestMethod.GET)
    public ResponseEntity<?> uploadImage(@ApiParam("图片") @RequestParam MultipartFile image) {
        String imagePath = "";
        String imageUrl = "";
        try {
            imagePath = FileUtil.uploadImage(PathUtil.IMG_STORAGE_PATH, image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        imageUrl = PathUtil.ORIGIN + File.separator + PathUtil.IMG_FOLDER_PATH + imagePath;
        return ResponseEntity.status(HttpServletResponse.SC_CREATED).body(imageUrl);
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

}