package org.ggsl.ew_eip.service.userdetails;

import org.ggsl.ew_eip.model.MyTeamModel;
import org.ggsl.ew_shared.dao.myprofile.FindMyProfileDAO;
import org.ggsl.ew_shared.exception.GenericCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindMyProfileDetailsServiceImpl implements FindMyProfileDetailsService {

	@Autowired
	FindMyProfileDAO myProfileDAO;
		MyTeamModel myProfileObjModel=new MyTeamModel();
	@Override
	public MyTeamModel getMyProfileDetailsById(Integer userId) throws GenericCustomException {
		
		Object[] myProfileObj=null;		
	    myProfileObj=myProfileDAO.getMyProfileetails(userId);
	    //returns profile details if entity exists for given userID
	    if(myProfileObj!=null) {
		myProfileObjModel=new MyTeamModel();
		myProfileObjModel.setUserName((String) myProfileObj[0]);
		myProfileObjModel.setEmailId((String) myProfileObj[1]);
		myProfileObjModel.setWorkPhone((String) myProfileObj[2]);
		myProfileObjModel.setWorkPhoneExt((String) myProfileObj[3]);
		myProfileObjModel.setGenId((String) myProfileObj[4]);
		myProfileObjModel.setEmployeeDesignation((String) myProfileObj[5]);
		myProfileObjModel.setFunctionName((String) myProfileObj[6]);
		myProfileObjModel.setLocationName((String) myProfileObj[7]);
		myProfileObjModel.setSupervisor((String) myProfileObj[8]);
		myProfileObjModel.setSupervisorDesg((String) myProfileObj[9]);
		myProfileObjModel.setBuName((String) myProfileObj[10]);
	    }
		
	    if (myProfileObj==null) {
	    	System.out.println("sdas");
	    	throw new GenericCustomException("1");
	    }
		return myProfileObjModel;
	}

}
