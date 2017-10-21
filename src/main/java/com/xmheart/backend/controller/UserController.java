package com.xmheart.backend.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.xmheart.model.XPWUser;
import com.xmheart.service.UserService;
import com.xmheart.util.ResponseBody;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * User Controller.
 * 
 * @author x1ny
 * @date 2017年5月26日
 */
@Api(tags = "User相关接口")
@RestController()
@RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
public class UserController {

//	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	* 
	*/
	@ApiOperation(value = "搜索用户信息", notes = "搜索用户信息")
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ResponseEntity<?> show() {
	    return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "更新用户信息", notes = "更新用户信息")
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> update(@ApiParam("用户Id") @PathVariable Long id,
			@ApiParam("密码") @RequestParam(required = false) String password) throws IOException {
		int result = -1;
		
		ResponseBody resBody = new ResponseBody<XPWUser>();
		
		XPWUser user = userService.read(id);
		if (user == null) {
			resBody.statusMsg = "没有找到该用户";
			resBody.obj = null;
			return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).body(resBody);
		}		
		
		if (password != null) {
		    user.setPassword(password);
		}
		
		result = userService.update(user, resBody);
		
		return ResponseEntity.status(result).body(resBody);
	}
	
}
