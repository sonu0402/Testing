package org.ggsl.ew_eip.service.userdetails;

import java.util.HashMap;
import java.util.Map;

import org.ggsl.ew_shared.entity.UserMaster;
import org.ggsl.ew_shared.repository.userdetails.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserDetailsServiceImpl implements FindUserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepo;
	
	Map<String, String> userMap = new HashMap<>();
	UserMaster userMaster;
	@Override
	public Map<String, String> getUserNameById(Integer userId) {
		
		String userName = userDetailsRepo.findUserNameByUserId(userId);
		userMap.put("username", userName);
		return userMap;
	}

	@Override
	public UserMaster getUserDetailsById(Integer userId) {
		userMaster =userDetailsRepo.findUserDetailsByUserId(userId);
		return userMaster;
	}

}
