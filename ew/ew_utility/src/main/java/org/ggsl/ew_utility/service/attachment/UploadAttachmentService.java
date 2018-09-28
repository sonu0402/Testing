package org.ggsl.ew_utility.service.attachment;

import org.springframework.web.multipart.MultipartFile;

public interface UploadAttachmentService {

	String uploadAttachment(MultipartFile file, String destination) throws Exception;

}
