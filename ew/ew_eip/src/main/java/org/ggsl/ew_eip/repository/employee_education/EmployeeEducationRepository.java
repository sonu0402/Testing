package org.ggsl.ew_eip.repository.employee_education;

import java.util.List;

import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation, Integer> {
	List<EmployeeEducation> findAllByEmpId(Integer empId);
}
