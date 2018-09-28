package org.ggsl.ew_shared.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	private Date timestamp;
	  private String messageData;
	  private String details;
	  private Integer statuscode;
	  
	 
	}


