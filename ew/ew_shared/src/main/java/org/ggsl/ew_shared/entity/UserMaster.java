package org.ggsl.ew_shared.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_master")
@Data
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4343825301056050352L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ACTIVE_FLAG", length = 1)
	private String activeFlag;
	@Column(name = "ERM_USER", length = 1)
	private String ermUser;
	@Column(name = "LOGIN_ID", length = 100)
	private String loginId;
	@Column(name = "PASSWORD", length = 30)
	private String password;
	@Column(name = "USER_NAME", length = 150)
	private String userName;
	@Column(name = "GRADE_ID")
	private Integer gradeId;
	@Column(name = "FUNCTION_ID")
	private Integer functionId;

	@Column(name = "BU_ID")
	private Integer buId;
	@Column(name = "LOCATION_ID")
	private Integer locationId;
	@Column(name = "SUPERVISOR_ID")
	private Integer supervisorId;
	@Column(name = "FIRSTTIME_ID")
	private Integer firsttimeId;
	@Column(name = "USER_CUST_ID")
	private Integer userCustId;
	@Column(name = "LICENSE_ACCEPTED_ON", length = 10)
	private LocalDateTime licenseAcceptedOn;
	@Column(name = "LICE_OFFSET")
	private Integer liceOffset;
	@Column(name = "USER_PWD_REQUESTED")
	private Integer userPwdRequested;

	@Column(name = "USER_PWD_REQUSTD_TIME", length = 10)
	private LocalDateTime userPwdRequstdTime;
	@Column(name = "USER_PWD_REQUSTD_TIME_TZ", length = 20)
	private String userPwdRequstdTimeTz;
	@Column(name = "USER_PWD_REQUSTD_TIME_OFFSET")
	private Integer userPwdRequstdTimeOffset;
	@Column(name = "USER_TOKEN", length = 100)
	private String userToken;
	@Column(name = "SALTVAL", length = 300)
	private String saltval;
	@Column(name = "ENC_PASS", length = 500)
	private String encPass;

}