package com.xmheart.backend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xmheart.model.XPWRole;
import com.xmheart.model.XPWVideo;
import com.xmheart.service.RoleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;

	@RequestMapping(value = { "/role" }, method = RequestMethod.POST)
	public ResponseEntity<?> create(Model model,
			@ApiParam("角色名字") @RequestParam String name,
			@ApiParam("角色拥有的权限Id") @RequestParam Long[] privIds) {
		
		XPWRole role = new XPWRole();
		if (name != null) {
			role.setName(name);
		}
		
		if (privIds != null) {
			StringBuilder sb = new StringBuilder();
			for (long id : privIds) {
				System.out.println(id);
				sb.append(id);
				sb.append(",");
			}
			String idsStr = sb.substring(0, sb.toString().length() - 1);
			role.setPrivIds(idsStr);
		}
		int ret = roleService.create(role);
		if (ret > 0) {
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);
		}
	}
	
	@RequestMapping(value = { "/role/{id}" }, method = RequestMethod.POST)
	public ResponseEntity<?> update(Model model,
			@ApiParam("文章Id，必填") @PathVariable Long id, 
			@ApiParam("角色名字") @RequestParam String name,
			@ApiParam("角色拥有的权限Id") @RequestParam Long[] privIds) {
		
		XPWRole role = new XPWRole();
		role.setId(id);
		if (name != null) {
			role.setName(name);
		}
		
		if (privIds != null) {
			StringBuilder sb = new StringBuilder();
			for (long pId : privIds) {
				System.out.println(pId);
				sb.append(pId);
				sb.append(",");
			}
			String idsStr = sb.substring(0, sb.toString().length() - 1);
			role.setPrivIds(idsStr);
		}
		
		int ret = roleService.update(role);
		if (ret > 0) {
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);
		}
	}
	
	@RequestMapping(value = { "/role/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(Model model,
			@ApiParam("文章Id，必填") @PathVariable Long id) {
		
		int ret = roleService.delete(id);
		if (ret > 0) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);
		}
	}
	
	@RequestMapping(value = { "/role/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<?> read(Model model,
			@ApiParam("文章Id，必填") @PathVariable Long id) {
		XPWRole role = roleService.read(id);
		
		if (role != null) {
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN).body(null);
		}
	}
}
