package org.ggsl.ew_shared.repository.userdetails;

import org.ggsl.ew_shared.entity.HrAccessRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HrAccessRightsRepository extends JpaRepository<HrAccessRights, Integer> {
	
	@Query("select HrRight from HrAccessRights HrRight where HrRight.userId=:userId and HrRight.hrRoleId=:hrRoleId and HrRight.functionId=:functionId")
	HrAccessRights getHrAccessRights(@Param(value = "userId") Integer userId ,@Param(value = "hrRoleId") Integer hrRoleId ,@Param(value = "functionId") Integer functionId);
	
}
