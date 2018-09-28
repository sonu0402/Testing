package org.ggsl.ew_eip.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "emp_education")
@Data
public class EmployeeEducation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1529302815088237593L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_edu_generator")
	@SequenceGenerator(name = "emp_edu_generator", sequenceName = "emp_education_seq", allocationSize = 1)
	@Column(name = "SERIAL_NO", nullable = false, updatable = false)
	private Integer serialNo;
	@Column(name = "COLLEGE")
	private String college;
	@Column(name = "EGRADE", length = 150)
	private String egrade;
	@Column(name = "EMP_ID")
	private Integer empId;
	@Column(name = "QUALIFICATION", length = 150)
	private String qualification;
	@Column(name = "SPEC", length = 150)
	private String spec;

	@Column(name = "YEAR", length = 30)
	private String year;
	@Column(name = "EDU_LEVEL_ID")
	private Integer eduLevelId;
	@Column(name = "EMP_HIGHEST", length = 1)
	private Character empHighest;
	@Column(name = "RECEIVED_THIS_COMPANY", length = 1)
	private String receivedThisCompany;
	@Column(name = "EMP_EDU_STATUS", length = 2)
	private Short empEduStatus;
	@Column(name = "EMP_EDU_SR_ID")
	private Integer empEduSrId;
	@Column(name = "EMP_EDU_CR_DT")
	private LocalDateTime empEduCrDt;

	@Column(name = "EMP_EDU_APPR_DT")
	private LocalDateTime empEduApprDt;
	@Column(name = "EMP_EDU_REM_DT")
	private LocalDateTime empEduRemDt;
	@Column(name = "EMP_EDU_REM_BY")
	private Integer empEduRemBy;
	@Column(name = "EMP_EDU_CR_BY")
	private Integer empEduCrBy;
	@Column(name = "EMP_EDU_APPR_BY", length = 2)
	private Integer empEduApprBy;

	@Column(name = "EMP_EDU_REJ_COMM", length = 60)
	private String empEduRejComm;
	@Column(name = "EMP_EDU_APPR_DT_TZ", length = 20)
	private String empEduApprDtTz;
	@Column(name = "EMP_EDU_CR_DT_TZ", length = 20)
	private String empEduCrDtTz;
	@Column(name = "EMP_EDU_REM_DT_TZ", length = 20)
	private String empEduRemDtTz;

	@Column(name = "EMP_EDU_APPR_DT_OFFSET")
	private Integer empEduApprDtOffset;
	@Column(name = "EMP_EDU_CR_DT_OFFSET")
	private Integer empEduCrDtOffset;
	@Column(name = "EMP_EDU_REM_DT_OFFSET")
	private Integer empEduRemDtOffset;
	@Column(name = "ACTION_CODE")
	private Integer actionCode;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="educationId")
	@JsonManagedReference
	private List<EducationAttachment> attachments;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="employeeEducation")
	@JsonManagedReference
	private EmployeeEducationHistory history;

}
