package org.ggsl.ew_eip.controllers;

import org.ggsl.ew_eip.model.UserMasterAndEmployeeModel;
import org.ggsl.ew_eip.service.userdetails.FindUserMasterAndEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserEmployeeAndMasterController {
	@Autowired
	FindUserMasterAndEmployeeService userMasterAndEmployeeService;
	
	@GetMapping(value = "/usermasterandemployee/{id}")
	public UserMasterAndEmployeeModel getUserMasterAndEmployeeDetails(@PathVariable(name = "id") Integer userId) {
		UserMasterAndEmployeeModel userMasterEmployee=null;
		userMasterEmployee = userMasterAndEmployeeService.getUserMasterAndEmployeeDetails(userId);
		return userMasterEmployee;
		
	}


}
