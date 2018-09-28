package org.ggsl.ew_eip.service.hr_rights;


import org.ggsl.ew_shared.entity.HrAccessRights;

public interface FindMyHrAccessRightsService {
	
	HrAccessRights getMyHRAccessRights(Integer userId, Integer hrRoleId,Integer functionId);
}
