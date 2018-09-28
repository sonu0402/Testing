package org.ggsl.ew_eip.service.myteam;

import java.util.List;

import org.ggsl.ew_eip.model.MyTeamModel;

public interface FindMyTeamService {

	List<MyTeamModel> getMyTeamDetails(Integer customerId, Integer userId);
}
