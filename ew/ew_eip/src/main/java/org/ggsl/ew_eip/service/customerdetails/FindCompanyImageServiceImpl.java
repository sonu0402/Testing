package org.ggsl.ew_eip.service.customerdetails;

import org.ggsl.ew_utility.entity.CompanyImage;
import org.ggsl.ew_utility.repository.FindCompanyImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCompanyImageServiceImpl implements FindCompanyImageService {

	@Autowired
	private FindCompanyImageRepository findCompanyImageRepository;
	
	private CompanyImage companyImage=null;

	@Override
	public CompanyImage getCompanyImageByCompanyCompId(Integer compid) {
		 companyImage = findCompanyImageRepository.findCompanyImageByCompIdAndImageActive(compid);
		return companyImage;
	}

}
