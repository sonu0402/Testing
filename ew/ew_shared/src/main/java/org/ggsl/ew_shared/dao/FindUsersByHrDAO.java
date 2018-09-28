package org.ggsl.ew_shared.dao;

import java.util.List;

public interface FindUsersByHrDAO {

	List<Object[]> getUserDetailsByHr(Integer userId, Integer hrRoleId, Integer functionId , Integer customerId);
}
