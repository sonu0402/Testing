package org.ggsl.ew_eip.controllers;

import java.util.List;

import org.ggsl.ew_eip.model.MyTeamModel;
import org.ggsl.ew_eip.service.myteam.FindMyTeamService;
import org.ggsl.ew_eip.service.myteam.FindMyallTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyTeamController {

	@Autowired
	private FindMyTeamService findMyTeamService;
	
	@Autowired
	private FindMyallTeamService findMyallTeamService;
	

	@GetMapping(value = "/myteam")
	public List<MyTeamModel> getMyTeamDetails(@RequestParam Integer customerId, @RequestParam Integer userId) {
		List<MyTeamModel> myTeamList = null;
		myTeamList = findMyTeamService.getMyTeamDetails(customerId,userId);
		return myTeamList;
	}
	
	
	@GetMapping(value = "/myallteam")
	public List<MyTeamModel> getMyallTeamDetails(@RequestParam Integer customerId, @RequestParam Integer userId , @RequestParam Integer hrRoleId ,  @RequestParam Integer functionId) {
		List<MyTeamModel> myallTeamList = null;
		myallTeamList = findMyallTeamService.getMyallTeamDetails(customerId, userId , hrRoleId , functionId);
		return myallTeamList;
	}
}
