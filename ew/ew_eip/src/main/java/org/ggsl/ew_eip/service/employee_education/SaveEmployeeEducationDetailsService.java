package org.ggsl.ew_eip.service.employee_education;

import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.springframework.web.multipart.MultipartFile;

public interface SaveEmployeeEducationDetailsService {

	Integer saveEmployeeEducation(String subTabType, MultipartFile file, EmployeeEducation employeeEducation,
			int custId, int userId, String moduleCode);

}
