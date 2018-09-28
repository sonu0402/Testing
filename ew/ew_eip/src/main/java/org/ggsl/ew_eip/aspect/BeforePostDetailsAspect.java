package org.ggsl.ew_eip.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.ggsl.ew_eip.entity.EmployeeEducation;
import org.ggsl.ew_shared.dao.tabrights.TabRightsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Aspect
@EnableAspectJAutoProxy
@ComponentScan(basePackages="org.ew_eip")
@Component
public class BeforePostDetailsAspect {
	
	@Autowired
	TabRightsDAO tabRightsDAO;
	
	//intercepted at addEducation details
	@Pointcut(value = "execution(* org.ew_eip.service.employee_education.*.*(..)) && args(subTabType,file,employeeEducation,custId,userId,moduleCode)", argNames="subTabType,file,employeeEducation,custId,userId,moduleCode")
	 
	public void postDetailsAspectExecution(final String subTabType, final MultipartFile file,final EmployeeEducation employeeEducation,final int custId,final int userId,
			final String moduleCode ){
	}
	

	//Advice called before adding education details to db. It will proceed to saveEmployeeEducation method only if customer is having proper rights
	@Around(value = "postDetailsAspectExecution(subTabType,file,employeeEducation,custId,userId,moduleCode)",argNames="subTabType,file,employeeEducation,custId,userId,moduleCode")
	public void aroundPostDetailsAspectExecution(final ProceedingJoinPoint pjp, final String subTabType, final MultipartFile file,final EmployeeEducation employeeEducation,final int custId,final int userId,
			final String moduleCode 
	  ) throws Throwable{
		System.out.println("Advice for Add called...");
		boolean isEditable=tabRightsDAO.isEditApplicable(subTabType, custId);
		if (isEditable) {
				pjp.proceed();
		} else {
			System.out.println("User not allowed to add details");
			
		}
			
	}
	

}
