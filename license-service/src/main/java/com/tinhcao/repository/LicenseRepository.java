package com.tinhcao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinhcao.entity.License;

@Repository
public interface LicenseRepository extends JpaRepository<License, String> {
	License findByLicenseIdAndOrganizationId(String licenseId, String organizationId);
}
