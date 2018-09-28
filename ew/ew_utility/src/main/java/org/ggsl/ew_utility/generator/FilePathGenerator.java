package org.ggsl.ew_utility.generator;

import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	public String generateDestinationPath(String moduleId, int custId, int userId) {
		String destination = null;
		destination = String.join("/", getModuleRelativeFilePath(moduleId), generateUserDocumentPath(custId, userId),
				String.valueOf(System.currentTimeMillis()));
		return destination;
	}

	public String generateUserDocumentPath(int custId, int userId) {
		return String.join("/", "cust_" + custId, "user_" + userId);
	}

	public String getModuleRelativeFilePath(String moduleId) {
		String path;
		switch (moduleId) {
		case "EIP_Attch_Edu":
			path = "eip/attachment/education";
			break;
		default:
			path = null;
			break;
		}
		return path;
	}
	
}
