package org.ggsl.ew_eip.dao.teamdetails;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FindMyTeamDAOImpl implements FindMyTeamDAO {
	@Autowired
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getMyTeamDetails(Integer customerId, Integer userId) {
		String sqlQuery = "select user_employee.user_name,user_employee.email_id,employee.work_phone,employee.work_phone_ext,user_employee.gen_id,employee.employee_designation,user_employee.FUNCTION_NAME,user_employee.Location_NAME,(select user_master.user_name from user_master where user_master.user_id = user_employee.supervisor_id)supervisor,(select employee.employee_designation from employee where employee.user_id = user_employee.supervisor_id)supervisor_desg,(select bu_name from business_unit where bu_id = employee.bu_id ) bu_name from user_employee,user_master,employee where user_employee.user_id = user_master.user_id and user_employee.user_id = employee.user_id and employee_customer_id = :customerId and employee.status = 'Active' and employee.employee_id in (select Employee_id from employee where reporting_id =:userId and employee_cust_id =:customerId) or ( user_employee.user_id = user_master.user_id and user_employee.user_id = employee.user_id and employee_customer_id = :customerId and employee.status = 'Active' and employee.functional_supervisor = :userId ) ORDER BY user_master.user_name";
		List<Object[]> myTeamObject =null;
		myTeamObject=(List<Object[]>)this.manager.createNativeQuery(sqlQuery).setParameter("customerId", customerId)
				.setParameter("userId",userId).getResultList();
				/*if(myTeamObject.size()==0)
			throw new GenericCustomException("1");*/
		return myTeamObject;
	}

}
