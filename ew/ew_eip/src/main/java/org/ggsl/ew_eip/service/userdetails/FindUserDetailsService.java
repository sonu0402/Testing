package org.ggsl.ew_eip.service.userdetails;

import java.util.Map;

import org.ggsl.ew_shared.entity.UserMaster;

public interface FindUserDetailsService {

	Map<String, String> getUserNameById(Integer userId);
	UserMaster getUserDetailsById(Integer userId);

}
