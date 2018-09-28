package org.ggsl.ew_utility.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "company_image")
@Data
public class CompanyImage implements Serializable {

	private static final long serialVersionUID = -2493594023645144359L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_image_generator")
	@SequenceGenerator(name = "company_image_generator", sequenceName = "company_image_gen", allocationSize = 50)
	@Column(name = "COMPANY_IMAGE_ID", updatable = false, nullable = false)
	private Integer companyImageId;
	@Column(name = "COMPANY_COMP_ID")
	private Integer companyCompId;
	@Column(name = "COMPANY_CUST_ID")
	private Integer companyCustId;
	@Column(name = "IMAGE_ACTIVE", length = 2)
	private Short imageActive;
	@Column(name = "IMAGE_CONTENT_TYPE", length = 20)
	private String imageContentType;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "COMPANY_IMAGE_DATA")
	private byte[] companyImageData;
}
