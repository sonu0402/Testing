package org.ggsl.ew_shared.repository.userdetails;

import org.ggsl.ew_shared.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserMaster, Integer> {

	@Query("select userName from UserMaster where userId=:userId")
	String findUserNameByUserId(@Param(value = "userId") Integer userId);
	
	UserMaster findUserDetailsByUserId(Integer userId);

}
