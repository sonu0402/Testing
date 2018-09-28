package org.ggsl.ew_shared.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.ggsl.ew_shared.entity.HrAccessRights;
import org.ggsl.ew_shared.repository.userdetails.HrAccessRightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FindUsersByHrDAOImpl implements FindUsersByHrDAO {
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private HrAccessRightsRepository hrRepo;
	
	private HrAccessRights hrRights = null;
	
	
	@Override
	public List<Object[]> getUserDetailsByHr(Integer userId, Integer hrRoleId, Integer functionId , Integer customerId) {
		// TODO Auto-generated method stub
		
				
		hrRights =  hrRepo.getHrAccessRights(userId, hrRoleId, 11); // Can view User details.(11)
		
		if(hrRights!=null && hrRights.getHr_functioning().equalsIgnoreCase("Y")) {
			
			String whereClause = "";
			
			
			if(hrRights!=null && hrRights.getSpecific_bu().equalsIgnoreCase("Y")) {
				
				whereClause +="  and BU_ID in ("+hrRights.getBu_id()+") ";
			}
			
			if(hrRights!=null && hrRights.getSpecific_et().equalsIgnoreCase("Y")) {
				
				whereClause += " and EMP_TYPE in ("+hrRights.getEt_id()+") "; 
			}
			
			if(hrRights!=null && hrRights.getSpecific_functions().equalsIgnoreCase("Y")) {
				
				whereClause += " and FUNCTION_ID in ("+hrRights.getFunctions_id()+") "; 
			}
			
			if(hrRights!=null && hrRights.getSpecific_grades().equalsIgnoreCase("Y")) {
				
				whereClause += " and GRADE_ID in ("+hrRights.getGrades_id()+") "; 
			}
			
			if(hrRights!=null && hrRights.getSpecific_locations().equalsIgnoreCase("Y")) {
				
				whereClause += " and LOCATION_ID in ("+hrRights.getLocations_id()+") "; 
			}
			
			if(hrRights!=null && hrRights.getSpecific_co().equalsIgnoreCase("Y")) {
				
				whereClause += " and COMPANY_ID in ("+hrRights.getCo_id()+") "; 
			}
			
			
			String sqlQuery = "select user_employee.user_name,user_employee.email_id,employee.work_phone,employee.work_phone_ext,user_employee.gen_id,employee.employee_designation,user_employee.FUNCTION_NAME,user_employee.Location_NAME,(select user_master.user_name from user_master where user_master.user_id = user_employee.supervisor_id)supervisor,(select employee.employee_designation from employee where employee.user_id = user_employee.supervisor_id)supervisor_desg,(select bu_name from business_unit where bu_id = employee.bu_id ) bu_name from user_employee,user_master,employee where user_employee.user_id = user_master.user_id and user_employee.user_id = employee.user_id and employee_customer_id = :customerId and employee.status = 'Active' and employee.employee_id in (select Employee_id from employee where employee_cust_id =:customerId "+whereClause+" ) ORDER BY user_master.user_name";
			
			@SuppressWarnings("unchecked")
			List<Object[]> usersObject = (List<Object[]>)this.manager.createNativeQuery(sqlQuery).setParameter("customerId", customerId)
																.getResultList();
			
			return usersObject;
			
		}else {
			
			List<Object[]> usersObject = null;
			return usersObject;
		}
		
		
	
	}
	
	

}
