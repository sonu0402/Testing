package org.ggsl.ew_eip.service.employee_education;

import java.util.List;

import org.ggsl.ew_eip.entity.EmployeeEducation;

public interface FindEmployeeEducationDetailsService {

	List<EmployeeEducation> getEmployeeEducationDetailsByEmpId(Integer userId);

}
