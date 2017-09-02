package com.xmheart.controller;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xmheart.form.PersonForm;
import com.xmheart.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
 
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
    
    private static Map<String, String> secColumns = new HashMap<String, String>();
    
    static {
    	secColumns.put("媒体看厦心", "media.html");
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