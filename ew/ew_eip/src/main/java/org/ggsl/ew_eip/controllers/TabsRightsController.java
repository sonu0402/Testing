package org.ggsl.ew_eip.controllers;

import java.util.List;

import org.ggsl.ew_eip.service.tabrights.FindTabsRightsService;
import org.ggsl.ew_shared.model.TabRightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TabsRightsController {
	
	@Autowired
	FindTabsRightsService findTabsRights;
	
	@GetMapping(value = "/tabsrights/{id}")
	public List<TabRightsModel> getTabRights(@PathVariable(name = "id") Integer userId) {
		List<TabRightsModel> tabRightsList;
		tabRightsList = findTabsRights.getTabRights(userId);
		return tabRightsList ;
	}
	

}
