package org.ggsl.ew_eip.controllers;

import org.ggsl.ew_eip.service.userdetails.FindUserEmployeeService;
import org.ggsl.ew_shared.entity.UserEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEmployeeController {
	
	@Autowired
	FindUserEmployeeService userEmployeeService ;
		
	@GetMapping(value = "/useremployee/{id}")
	public UserEmployee getUserEmployeeDetails(@PathVariable(name = "id") Integer userId) {
		UserEmployee userEmployee=null;
		userEmployee = userEmployeeService.getUserEmployeeById(userId);
		return userEmployee;
	}
	
	
}
