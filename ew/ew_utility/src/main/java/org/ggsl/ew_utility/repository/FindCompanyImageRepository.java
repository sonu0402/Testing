package org.ggsl.ew_utility.repository;

import org.ggsl.ew_utility.entity.CompanyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FindCompanyImageRepository extends JpaRepository<CompanyImage, Integer> {
	@Query("from CompanyImage where companyCompId=:compId and imageActive=1")
	CompanyImage findCompanyImageByCompIdAndImageActive(@Param(value = "compId") Integer companyId);
}
