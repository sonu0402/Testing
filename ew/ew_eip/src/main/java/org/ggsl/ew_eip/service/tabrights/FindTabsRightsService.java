package org.ggsl.ew_eip.service.tabrights;

import java.util.List;

import org.ggsl.ew_shared.model.TabRightsModel;

public interface FindTabsRightsService {

	List<TabRightsModel> getTabRights(Integer userId);

	

}