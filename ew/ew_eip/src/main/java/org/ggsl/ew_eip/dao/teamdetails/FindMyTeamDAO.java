package org.ggsl.ew_eip.dao.teamdetails;

import java.util.List;

public interface FindMyTeamDAO {

	List<Object[]> getMyTeamDetails(Integer customerId, Integer userId);

}
