package org.ggsl.ew_eip.service.userdetails;

import org.ggsl.ew_shared.entity.UserEmployee;
import org.ggsl.ew_shared.repository.userdetails.UserEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserEmployeeServiceImpl implements FindUserEmployeeService {

	@Autowired
	UserEmployeeRepository userEmployeeRepo;
	UserEmployee userEmployee = null;

	@Override
	public UserEmployee getUserEmployeeById(Integer userId) {

		userEmployee = userEmployeeRepo.findByUserId(userId);

		return userEmployee;
	}

}
