package com.xmheart.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xmheart.service.HisService;

@Controller
public class TaskController {
    
    @Autowired
    private HisService hisService;
    
    @RequestMapping(value = { "/testDoctor" }, method = RequestMethod.GET)
    public void doctors() {
        hisService.doctors();
    }
}
