package org.ggsl.ew_eip.service.hr_rights;

import org.ggsl.ew_shared.repository.userdetails.HrAccessRightsRepository;
import org.ggsl.ew_shared.entity.HrAccessRights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMyHrAccessRightsServiceImpl implements FindMyHrAccessRightsService {
	
	
	
	@Autowired
	HrAccessRightsRepository hrAccessRightsRepository;
	
	@Override
	public HrAccessRights getMyHRAccessRights(Integer userId, Integer hrRoleId,Integer functionId) {
		
		HrAccessRights  myHrRights =  null ;
		
		//myHrRights = (HrRightsModel)findMyHrAccessRightsDAO.getMyHRAccessRights(userId, roleId, functionId);
	
		myHrRights = hrAccessRightsRepository.getHrAccessRights(userId, hrRoleId, functionId);
	
		return myHrRights;
	}

}