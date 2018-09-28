package org.ggsl.ew_eip.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.ggsl.ew_eip.service.customerdetails.FindCompanyImageService;
import org.ggsl.ew_utility.entity.CompanyImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyImageController {

	@Autowired
	private FindCompanyImageService companyImageService;

	@RequestMapping(value = "/company-image/{compid}")
	public void getCompanyImage(@PathVariable Integer compid, HttpServletResponse response) throws IOException {
		CompanyImage companyImage = companyImageService.getCompanyImageByCompanyCompId(compid);
		response.setContentType(companyImage.getImageContentType());
		response.getOutputStream().write(companyImage.getCompanyImageData());
	}
}
