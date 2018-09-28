package org.ggsl.ew_eip;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerInfo {

	@RequestMapping("/controllerinfo")
	public String userInformation() {
		return "USER API RUN TEST :: OK";
	}
}