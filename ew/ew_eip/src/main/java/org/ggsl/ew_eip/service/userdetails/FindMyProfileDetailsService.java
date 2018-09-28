package org.ggsl.ew_eip.service.userdetails;

import org.ggsl.ew_eip.model.MyTeamModel;
import org.ggsl.ew_shared.exception.GenericCustomException;

public interface FindMyProfileDetailsService {

	MyTeamModel getMyProfileDetailsById(Integer userId) throws GenericCustomException;
}
