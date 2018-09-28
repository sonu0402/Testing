package org.ggsl.ew_shared.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Immutable
@Table(name = "user_employee")
@Data
public class UserEmployee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "employeeCode")
	private String EMPLOYEE_CODE;
	@Column(name = "supervisorId")
	private String SUPERVISOR_ID;
	@Column(name = "ORGANIZATION_ROLE")
	private String organizationRole;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "EMPLOYEE_ID", nullable = false)
	private Integer employeeId;
	@Column(name = "ORG_ROLEID")
	private Integer orgRoleId;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@Column(name = "GEN_ID")
	private String genId;
	@Column(name = "LOCATION_NAME")
	private String locationName;
	@Column(name = "LEVEL_NAME")
	private String levelName;
	@Column(name = "FUNCTION_NAME")
	private String functionName;
	@Column(name = "FUNCTION_LEVEL")
	private String functionLevel;
	@Column(name = "EMPLOYEE_CUSTOMER_ID", nullable = false)
	private Integer employeeCustomerId;
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	@Column(name = "SUPERVISIOR_NAME")
	private String supervisorName;
	@Column(name = "SUPERVISIOR_LOCATION")
	private String supervisorLocation;
	@Column(name = "SUPERVISIOR_CODE")
	private String supervisorCode;
	@Column(name = "EMPLOYEE_DESIGNATION")
	private String employeeDesignation;
	@Column(name = "SUPERVISOR_DESIGNATION")
	private String supervisorDesignation;
	@Column(name = "SUPERVISOR_ROLE")
	private String supervisorRole;
	@Column(name = "BU_NAME", nullable = false)
	private String buName;
	@Column(name = "CO_NAME")
	private String coName;
	@Column(name = "EMP_DOJ")
	private LocalDateTime empDOJ;
	@Column(name = "EMP_SEPDATE")
	private LocalDateTime empSepDate;
	@Column(name = "EMP_STATUS")
	private String empStatus;
	@Column(name = "EMP_BIRTHDATE")
	private LocalDate empBirthDate;
	@Column(name = "EMP_GRADE")
	private String empGrade;
	@Column(name = "EMP_GLEVEL")
	private String empGLevel;
	@Column(name = "EMP_EMPTYPE")
	private String empEmpType;

}