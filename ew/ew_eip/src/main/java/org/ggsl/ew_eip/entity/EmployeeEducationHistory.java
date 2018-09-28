package org.ggsl.ew_eip.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "employee_education_history")
@Data
public class EmployeeEducationHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8457795276615827548L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_education_history_generator")
	@SequenceGenerator(name = "employee_education_history_generator", sequenceName = "employee_education_history_seq", allocationSize = 1)
	private Integer id;
	private LocalDateTime logTime;
//	@ManyToOne
//	@JoinColumn(name = "employee_education")
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonBackReference
	private EmployeeEducation employeeEducation;

	public EmployeeEducationHistory(LocalDateTime logTime, EmployeeEducation employeeEducation) {
		this.logTime = logTime;
		this.employeeEducation = employeeEducation;
	}
}
