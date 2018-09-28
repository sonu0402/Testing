package org.ggsl.ew_eip.controllers;

import org.ggsl.ew_eip.service.hr_rights.FindMyHrAccessRightsService;
import org.ggsl.ew_shared.entity.HrAccessRights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrAccessRightsController {



	@Autowired
	private FindMyHrAccessRightsService findMyHrAccessRightsService;

	@GetMapping(value = "/myHrRights")
	public HrAccessRights getMyHRAccessRights(@RequestParam Integer userId, @RequestParam Integer hrRoleId , @RequestParam Integer functionId) {
		
		HrAccessRights  myHrRights = null;
		myHrRights = findMyHrAccessRightsService.getMyHRAccessRights(userId,hrRoleId,functionId);
		
		return myHrRights;
	}

}
