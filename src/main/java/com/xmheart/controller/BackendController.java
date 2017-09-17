package com.xmheart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class BackendController {
    //TODO 这个接口要移到后台系统中去
	@RequestMapping(value = { "/articles" }, method = RequestMethod.POST)
    public ResponseEntity<?> articles(@RequestParam Integer columnId, @RequestParam String title, @RequestParam String content, 
    		@RequestParam String tags, @RequestParam String brief, Model model) {


        return null;
    }

}
