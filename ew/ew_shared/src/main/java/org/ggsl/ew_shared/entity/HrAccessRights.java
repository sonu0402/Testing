package org.ggsl.ew_shared.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Immutable
@Table(name = "hraccess_right")
@Data
public class HrAccessRights implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "HRROLE_ID")
	private Integer hrRoleId;
	
	@Column(name = "HR_FUNCTIONING" , length = 1)
	private String hr_functioning;
	
	@Column(name = "HRROLE_FUNCTIONID")
	private Integer functionId;
	
	@Column(name = "ALLEMPLOYEES" , length = 1)
	private String allemployees	;
	
	@Column(name = "SPECIFIC_FUNCTIONS" , length = 1)
	private String specific_functions;
	
	@Column(name = "SPECIFIC_GRADES" , length = 1)
	private String specific_grades;
	
	@Column(name = "SPECIFIC_LOCATIONS" , length = 1)
	private String specific_locations;
	
	@Column(name = "SPECIFIC_BU" , length = 1)
	private String specific_bu;
	
	@Column(name = "SPECIFIC_ET" , length = 1)
	private String specific_et;
	
	@Column(name = "FUNCTIONS_ID" , length = 3000)
	private String functions_id;
	
	@Column(name = "GRADES_ID" , length = 1000)
	private String grades_id;
	
	@Column(name = "LOCATIONS_ID" , length = 3000)
	private String locations_id;
	
	@Column(name = "BU_ID" , length = 1000)
	private String bu_id;
	
	@Column(name = "ET_ID" , length = 1000)
	private String et_id;
	
	@Column(name = "SPECIFIC_CO" , length = 1)
	private String specific_co;
	
	@Column(name = "CO_ID" , length = 500)
	private String co_id;
	
	@Column(name = "SELF_EDITABLE")
	private Integer self_editable;
	

}
