package org.ggsl.ew_eip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class Webint {
	@RequestMapping({ "/", "/dashboard", "/myTeam", "/myTeamListView", "/myProfile" })
	public String initApp() {
		return "forward:/index.html";
	}
}
