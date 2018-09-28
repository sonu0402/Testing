package org.ggsl.ew_eip.service.myteam;

import java.util.ArrayList;
import java.util.List;

import org.ggsl.ew_eip.dao.teamdetails.FindMyTeamDAO;
import org.ggsl.ew_eip.model.MyTeamModel;
import org.ggsl.ew_shared.dao.FindUsersByHrDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FindMyallTeamServiceImpl implements FindMyallTeamService {
	
	
	@Autowired
	private FindMyTeamDAO findMyTeamDAO;
	
	@Autowired
	private FindUsersByHrDAO findUsersByHrDAO;
	
	@Override
	public List<MyTeamModel> getMyallTeamDetails(Integer customerId, Integer userId , Integer hrRoleId , Integer functionId) {
		// TODO Auto-generated method stub
			
		
		
			List<MyTeamModel> myTeamList = new ArrayList<>();
			
			List<Object[]> myTeamObject = findMyTeamDAO.getMyTeamDetails(customerId, userId);
			
			if(myTeamObject!=null && myTeamObject.size()>0)
			myTeamObject.stream().forEach((record) -> {
				MyTeamModel teamModel = new MyTeamModel();
				teamModel.setUserName((String) record[0]);
				teamModel.setEmailId((String) record[1]);
				teamModel.setWorkPhone((String) record[2]);
				teamModel.setWorkPhoneExt((String) record[3]);
				teamModel.setGenId((String) record[4]);
				teamModel.setEmployeeDesignation((String) record[5]);
				teamModel.setFunctionName((String) record[6]);
				teamModel.setLocationName((String) record[7]);
				teamModel.setSupervisor((String) record[8]);
				teamModel.setSupervisorDesg((String) record[9]);
				teamModel.setBuName((String) record[10]);
				myTeamList.add(teamModel);
			});
		
		
			List<Object[]> myallTeamObject = findUsersByHrDAO.getUserDetailsByHr( userId,  hrRoleId,  functionId , customerId);
			
			if(myallTeamObject!=null && myallTeamObject.size()>0)
			myallTeamObject.stream().forEach((record) -> {
				MyTeamModel teamModel = new MyTeamModel();
				teamModel.setUserName((String) record[0]);
				teamModel.setEmailId((String) record[1]);
				teamModel.setWorkPhone((String) record[2]);
				teamModel.setWorkPhoneExt((String) record[3]);
				teamModel.setGenId((String) record[4]);
				teamModel.setEmployeeDesignation((String) record[5]);
				teamModel.setFunctionName((String) record[6]);
				teamModel.setLocationName((String) record[7]);
				teamModel.setSupervisor((String) record[8]);
				teamModel.setSupervisorDesg((String) record[9]);
				teamModel.setBuName((String) record[10]);
				myTeamList.add(teamModel);
			});
			
			return myTeamList;

	}
	
	
}
