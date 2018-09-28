package org.ggsl.ew_shared.repository.userdetails;

import org.ggsl.ew_shared.entity.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmployeeRepository extends JpaRepository<UserEmployee, Integer> {

	UserEmployee findByUserId(Integer userId);
}
