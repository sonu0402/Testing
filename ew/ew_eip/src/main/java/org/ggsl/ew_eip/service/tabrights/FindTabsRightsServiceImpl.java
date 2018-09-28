package org.ggsl.ew_eip.service.tabrights;

import java.util.ArrayList;
import java.util.List;

import org.ggsl.ew_shared.dao.tabrights.TabRightsDAO;
import org.ggsl.ew_shared.model.TabRightsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindTabsRightsServiceImpl implements FindTabsRightsService{

	@Autowired
	TabRightsDAO tabRightsDAO;
	@Override
	public List<TabRightsModel> getTabRights(Integer userId) {
		
		List<TabRightsModel> tabRightsList = new ArrayList<>();
		List<Object[]> tabRightObject = tabRightsDAO.getTabRights(userId);
		tabRightObject.stream().forEach((record) -> {
			TabRightsModel tabRightModel = new TabRightsModel();
			tabRightModel.setEmpTabCustId((Integer) record[0]);
			tabRightModel.setEmpTabType((String) record[1]);
			tabRightModel.setEmpSubTab((String) record[2]);
			tabRightModel.setEmpTabApp((String) record[3]);
			tabRightModel.setEmpTabAdd((String) record[4]);
			tabRightModel.setEmpTabEdit((String) record[5]);
			tabRightModel.setEmpTabDelete((String) record[6]);
			tabRightModel.setSequence((Integer) record[7]);
			tabRightModel.setTabsMessage((String) record[8]);
			tabRightModel.setSubtabsMessage((String) record[9]);
			tabRightModel.setEmpTabAppEmploy((String) record[10]);
			tabRightModel.setEmpSupviewApp((String) record[11]);
			tabRightsList.add(tabRightModel);
		});
		return tabRightsList;
	}

	
	}

