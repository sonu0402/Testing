package org.ggsl.ew_eip.service.employee_education;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.ggsl.ew_eip.entity.EducationAttachment;
import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.ggsl.ew_eip.entity.EmployeeEducationHistory;
import org.ggsl.ew_eip.repository.employee_education.EmployeeEducationRepository;
import org.ggsl.ew_utility.generator.FilePathGenerator;
import org.ggsl.ew_utility.service.attachment.UploadAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveEmployeeEducationDetailsServiceImpl implements SaveEmployeeEducationDetailsService {

	@Autowired
	private EmployeeEducationRepository educationRepository;
	@Autowired
	private UploadAttachmentService uploadAttachmentService;
	@Autowired
	private FilePathGenerator pathGenerator;

	@Override
	@Transactional(rollbackFor = Exception.class, timeout = 5)
	public Integer saveEmployeeEducation(String subTabType, MultipartFile file, EmployeeEducation employeeEducation,
			int custId, int userId, String moduleCode) {
		int success = 0;
		String destination = pathGenerator.generateDestinationPath(moduleCode, custId, userId);
		try {
//			List<EmployeeEducationHistory> history = new ArrayList<>();
//			history.add(new EmployeeEducationHistory(LocalDateTime.now(), employeeEducation));
			employeeEducation.setHistory(new EmployeeEducationHistory(LocalDateTime.now(), employeeEducation));
			if (file != null) {
				ArrayList<EducationAttachment> attachment = new ArrayList<EducationAttachment>();
				EducationAttachment edu_attch = new EducationAttachment(); // as of for example on upload one file
				edu_attch.setActiveStatus(true);
				edu_attch.setFilePath(destination);
				edu_attch.setEducationId(employeeEducation);
				attachment.add(edu_attch);
				employeeEducation.setAttachments(attachment);
				uploadAttachmentService.uploadAttachment(file, destination);
			}
			educationRepository.save(employeeEducation);
			success = 1;
			System.out.println("-------Education details added successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
		return success;
	}

}
