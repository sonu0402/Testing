package org.ggsl.ew_eip.controllers;

import java.util.Map;

import org.ggsl.ew_eip.service.userdetails.FindUserDetailsService;
import org.ggsl.ew_shared.entity.UserMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private FindUserDetailsService userDetailsService;

	@GetMapping(value = "/username/{id}")
	public Map<String, String> getUserName(@PathVariable(name = "id") Integer userId) {
		Map<String, String> userMap = null;
		userMap = userDetailsService.getUserNameById(userId);
		return userMap;
	}
	
	@GetMapping(value = "/userdetails/{id}")
	public UserMaster getUserDetails(@PathVariable(name = "id") Integer userId) {
		UserMaster userMaster=null;
		userMaster = userDetailsService.getUserDetailsById(userId);
		return userMaster;
	}
	

	
	
	
}
