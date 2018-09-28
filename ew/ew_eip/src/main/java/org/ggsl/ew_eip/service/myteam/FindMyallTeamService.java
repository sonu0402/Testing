package org.ggsl.ew_eip.service.myteam;

import java.util.List;
import org.ggsl.ew_eip.model.MyTeamModel;

public interface FindMyallTeamService {
	
	List<MyTeamModel> getMyallTeamDetails(Integer customerId, Integer userId , Integer hrRoleId , Integer functionId);
}
