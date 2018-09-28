package org.ggsl.ew_eip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "education_attachment")
@Data
public class EducationAttachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2349760463045222924L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edu_attach_generator")
	@SequenceGenerator(name = "edu_attach_generator", sequenceName = "education_attachment_seq", allocationSize = 1)
	@Column(name = "education_attachment_id", updatable = false)
	private Integer educationAttachmentId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EDUCATION_ID")
	@JsonBackReference
	private EmployeeEducation educationId;

	@Column(name = "file_path")
	private String filePath;

	@Type(type = "yes_no")
	@Column(name = "active_status")
	private boolean activeStatus;

}
