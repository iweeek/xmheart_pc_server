package com.xmheart.controller;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xmheart.config.ApplicationContextConfig;
import com.xmheart.form.PersonForm;
import com.xmheart.model.Person;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
 
@Controller
public class MainController {
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
 
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
    
    private static Map<String, String> secColumns = new HashMap<String, String>();
    
    static {
    	secColumns.put("媒体看厦心", "media");
    	secColumns.put("医院新闻", "list-news.htm");
    	secColumns.put("影像厦心", "video.html");
    	secColumns.put("电子院报", "news-paper.html");
    }
    
    private static Map<String, Map<String, String>> columns = new LinkedHashMap<String, Map<String, String>>();
    
    static {
    	columns.put("走进夏心", secColumns);
    	columns.put("新闻公告", secColumns);
    	columns.put("名医名科", secColumns);
    	columns.put("就医服务", secColumns);
    	columns.put("党群工作", secColumns);
    	columns.put("科研教学", secColumns);
    	columns.put("护理天地", secColumns);
    	columns.put("招贤纳士", secColumns);
    }
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("columns", columns);
 
        return "index";
    }
    
    @RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
    public ResponseEntity<?> edit(
			@RequestParam String page,
			HttpServletRequest request,
			Model model) {
        model.addAttribute("columns", columns);
        
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
    
//    @RequestMapping(value = { "/media" }, method = RequestMethod.GET)
    public String media(Model model) {
 
        model.addAttribute("columns", columns);
 
        return "media";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String addPersonForm(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String addPersonSave(Model model, //
            @ModelAttribute("personForm") PersonForm personForm) {
 
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:/index";
        }
        String error = "First Name & Last Name is required!";
        model.addAttribute("errorMessage", error);
        return "addPerson";
    }
 
}