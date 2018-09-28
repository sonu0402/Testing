package org.ggsl.ew_eip.service.employee_education;

import java.util.List;

import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.ggsl.ew_eip.repository.employee_education.EmployeeEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindEmployeeEducationDetailsServiceImpl implements FindEmployeeEducationDetailsService {

	@Autowired
	private EmployeeEducationRepository employeeEducationRepository;

	@Override
	public List<EmployeeEducation> getEmployeeEducationDetailsByEmpId(Integer userId) {

		return employeeEducationRepository.findAllByEmpId(userId);
	}

}
