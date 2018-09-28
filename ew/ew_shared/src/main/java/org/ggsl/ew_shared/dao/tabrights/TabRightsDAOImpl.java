package org.ggsl.ew_shared.dao.tabrights;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TabRightsDAOImpl implements TabRightsDAO {

	@Autowired
	private EntityManager manager;
	@Override
	public List<Object[]> getTabRights(Integer userId) {
		String sqlQuery = "Select * from emp_tabs_rights where EMPTAB_CUST_ID in(select USER_CUST_ID from user_master where user_id=:userId)";
		@SuppressWarnings("unchecked")
		List<Object[]> tabRightsObject = (List<Object[]>)this.manager.createNativeQuery(sqlQuery).setParameter("userId", userId).getResultList();
		return tabRightsObject;
	}
	@Override
	public boolean isEditApplicable(String subTabType, Integer custId) {
		boolean isEditable=false;
		int count =0;
		String sqlQueryForEmployee="select count(*) from emp_tabs_rights where EMPTAB_CUST_ID=:custId and EMP_SUB_TAB=:subTabType and EMP_TAB_APP_EMPLOY='Y' and EMP_TAB_ADD='Y'";
		//String sqlQueryForHR="select count(*) from emp_tabs_rights where EMPTAB_CUST_ID =:custId and EMP_SUB_TAB=:subTabType and EMP_TAB_APP='Y' and EMP_TAB_ADD='Y'";
		
		//if(roleName.equals("HR")) {
			//System.out.println("called for HR");
			// count =(int) this.manager.createNativeQuery(sqlQueryForHR).setParameter("userId", userId).setParameter("tabType", tabType).getSingleResult();
		//} else if(roleName.equals("user")) {
			//System.out.println("called for user");
		
		
			 count =(int) this.manager.createNativeQuery(sqlQueryForEmployee).setParameter("custId", custId).setParameter("subTabType", subTabType).getSingleResult();
		
			if(count>0) 
				isEditable=true;
		
		return isEditable;
	
	
	
	}
	
}
