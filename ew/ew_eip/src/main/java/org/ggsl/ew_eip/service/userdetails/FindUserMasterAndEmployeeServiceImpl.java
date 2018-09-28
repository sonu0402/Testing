package org.ggsl.ew_eip.service.userdetails;

import org.ggsl.ew_eip.model.UserMasterAndEmployeeModel;
import org.ggsl.ew_shared.entity.UserEmployee;
import org.ggsl.ew_shared.entity.UserMaster;
import org.ggsl.ew_shared.repository.userdetails.UserDetailsRepository;
import org.ggsl.ew_shared.repository.userdetails.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserMasterAndEmployeeServiceImpl implements FindUserMasterAndEmployeeService {

	@Autowired
	UserDetailsRepository userDetailsRepo;
	@Autowired
	UserEmployeeRepository userEmployeeRepo;

	@Override
	public UserMasterAndEmployeeModel getUserMasterAndEmployeeDetails(Integer userId) {
		UserMasterAndEmployeeModel userMasterAndEmployee = new UserMasterAndEmployeeModel();

		// to fetch passsword from user master
		UserMaster userMasterObj = userDetailsRepo.findUserDetailsByUserId(userId);
		userMasterAndEmployee.setPassword(userMasterObj.getPassword());

		// to fetch username from user employee

		UserEmployee userEmployeeObj = userEmployeeRepo.findByUserId(userId);
		userMasterAndEmployee.setUserId(userId);
		userMasterAndEmployee.setUserName(userEmployeeObj.getUserName());

		return userMasterAndEmployee;

	}
}
