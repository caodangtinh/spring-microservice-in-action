package com.tinhcao.repository;

import com.tinhcao.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, String> {
    License findByLicenseIdAndOrganizationId(String licenseId, String organizationId);
}
