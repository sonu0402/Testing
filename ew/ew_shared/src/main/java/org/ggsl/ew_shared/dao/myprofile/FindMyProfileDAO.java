package org.ggsl.ew_shared.dao.myprofile;

import org.ggsl.ew_shared.exception.GenericCustomException;

public interface FindMyProfileDAO {

	Object[] getMyProfileetails(Integer userId) throws GenericCustomException;

}