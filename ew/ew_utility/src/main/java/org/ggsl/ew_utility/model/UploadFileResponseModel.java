package org.ggsl.ew_utility.model;

import lombok.Data;

@Data
public class UploadFileResponseModel {

	private String fileName;
	private String contentType;
	private String download;
}
