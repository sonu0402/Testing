package org.ggsl.ew_eip.controllers;

import java.util.List;

import javax.validation.Valid;

import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.ggsl.ew_eip.service.employee_education.FindEmployeeEducationDetailsService;
import org.ggsl.ew_eip.service.employee_education.SaveEmployeeEducationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EmployeeEducationController {
	@Autowired
	private SaveEmployeeEducationDetailsService saveEmployeeEducationDetailsService;
	@Autowired
	private FindEmployeeEducationDetailsService findEmployeeEducationDetailsService;

	@GetMapping(value = "/emp-educations/{userId}")
	public List<EmployeeEducation> getAllEmployeeEducationDetail(@PathVariable Integer userId) {
		List<EmployeeEducation> empEducationList = findEmployeeEducationDetailsService
				.getEmployeeEducationDetailsByEmpId(userId);
		return empEducationList;
	}

	@PostMapping("/emp-education/{subTabType}")
	public void saveEmployeeEducation(@Valid @ModelAttribute EmployeeEducation employeeEducation,
			@PathVariable String subTabType, @RequestParam(name = "file", required = false) MultipartFile file,
			BindingResult result, @RequestParam int custId, @RequestParam String moduleCode) throws Exception {
		System.out.println(result.hasErrors() + " " + result.getFieldError());
		saveEmployeeEducationDetailsService.saveEmployeeEducation(subTabType, file, employeeEducation, custId,
				employeeEducation.getEmpId(), moduleCode);
		return;
	}

//	public EmployeeEducation updateEmployeeEducation() {
//		return null;
//	}

}
