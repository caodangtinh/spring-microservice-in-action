package com.tinhcao.service;

import com.tinhcao.client.OrganizationRestTemplateClient;
import com.tinhcao.entity.License;
import com.tinhcao.model.Organization;
import com.tinhcao.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private OrganizationRestTemplateClient organizationRestTemplateClient;

    public License getLicense(String organizationId, String licenseId) {
        License license = licenseRepository.findByLicenseIdAndOrganizationId(licenseId, organizationId);
        Organization org = organizationRestTemplateClient.getOrganization(organizationId);
        return license.withOrganizationName(org.getName()).withContactName(org.getContactName())
                .withContactEmail(org.getContactEmail()).withContactPhone(org.getContactPhone());
    }

}
