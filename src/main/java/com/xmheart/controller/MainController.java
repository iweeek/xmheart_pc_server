package com.xmheart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmheart.model.Department;
import com.xmheart.model.DepartmentService;
 
@Controller
public class MainController {
 
   @Autowired
   private DepartmentService deptService;
 
   @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
   public String welcomePage(Model model) {
       List<Department> list = deptService.listDepartment();
       model.addAttribute("departments", list);
       return "index";
   }
}