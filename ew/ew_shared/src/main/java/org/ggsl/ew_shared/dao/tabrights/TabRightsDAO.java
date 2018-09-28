package org.ggsl.ew_shared.dao.tabrights;

import java.util.List;

public interface TabRightsDAO {

	List<Object[]> getTabRights(Integer userId);

	boolean isEditApplicable(String subTabType, Integer custId);

}
