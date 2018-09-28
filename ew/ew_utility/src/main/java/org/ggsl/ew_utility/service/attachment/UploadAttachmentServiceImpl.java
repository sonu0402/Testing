package org.ggsl.ew_utility.service.attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.ggsl.ew_utility.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadAttachmentServiceImpl implements UploadAttachmentService {

	private final Path fileStorageLocation;

	@Autowired
	public UploadAttachmentServiceImpl(FileStorageProperties fileStorageProperties) throws Exception {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		createDirectory(this.fileStorageLocation);
	}

	@Override
	public String uploadAttachment(MultipartFile file, String filePath) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(filePath);
			createDirectory(targetLocation);
			targetLocation = targetLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (IOException ex) {
			throw ex;
			// throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	private void createDirectory(Path directory) throws Exception {
		try {
			// if (!Files.isDirectory(directory)) {
			//	throw new Exception("Not a directory");
			//	}
			if (Files.notExists(directory)) {
				Files.createDirectories(directory);
			}
		} catch (Exception ex) {
			throw new Exception("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}
}
