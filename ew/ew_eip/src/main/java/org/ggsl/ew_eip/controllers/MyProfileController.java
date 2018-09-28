package org.ggsl.ew_eip.controllers;

import org.ggsl.ew_eip.model.MyTeamModel;
import org.ggsl.ew_eip.service.userdetails.FindMyProfileDetailsService;
import org.ggsl.ew_shared.exception.GenericCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyProfileController {
	@Autowired
	FindMyProfileDetailsService findMyProfileDetails;

	@GetMapping(value = "/mydetails/{id}")
	public MyTeamModel getMyProfileDetails(@PathVariable(name = "id") Integer userId) throws GenericCustomException {
		MyTeamModel myProfile = findMyProfileDetails.getMyProfileDetailsById(userId);
		return myProfile;
	}

}
