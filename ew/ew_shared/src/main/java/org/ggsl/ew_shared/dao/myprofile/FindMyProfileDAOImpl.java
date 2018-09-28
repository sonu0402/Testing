package org.ggsl.ew_shared.dao.myprofile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.ggsl.ew_shared.exception.GenericCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class FindMyProfileDAOImpl implements FindMyProfileDAO {
	@Autowired
	private EntityManager manager;
	Object[] myTeamObject;

	@Override
	public Object[] getMyProfileetails(Integer userId) throws GenericCustomException {
		String sqlQuery = "select user_employee.user_name,user_employee.email_id,employee.work_phone,employee.work_phone_ext,user_employee.gen_id,employee.employee_designation,user_employee.FUNCTION_NAME,user_employee.Location_NAME,(select user_master.user_name from user_master where user_master.user_id = user_employee.supervisor_id)supervisor,(select employee.employee_designation from employee where employee.user_id = user_employee.supervisor_id)supervisor_desg,(select bu_name from business_unit where bu_id = employee.bu_id ) bu_name from user_employee,user_master,employee where user_employee.user_id = user_master.user_id and user_employee.user_id = employee.user_id and employee.employee_id=:userId";
		try {
		myTeamObject = (Object[])this.manager.createNativeQuery(sqlQuery).setParameter("userId", userId).getSingleResult();
		} catch(NoResultException e){
			throw new GenericCustomException("11");
			}
		return myTeamObject;
		
	}

}
