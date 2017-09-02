package com.xmheart.controller;
 
import java.util.ArrayList;
import java.util.List;
 
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
    
    private static List<String> columns = new ArrayList<String>();
    
    static {
    	columns.add("走进夏心");
    	columns.add("新闻公告");
    	columns.add("名医名科");
    	columns.add("就医服务");
    	columns.add("党群工作");
    	columns.add("科研教学");
    	columns.add("护理天地");
    	columns.add("招贤纳士");
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