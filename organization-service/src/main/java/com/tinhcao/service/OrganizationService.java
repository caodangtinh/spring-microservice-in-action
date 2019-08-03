package com.tinhcao.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinhcao.config.NameConfiguration;
import com.tinhcao.entity.Organization;
import com.tinhcao.repository.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private NameConfiguration nameConfiguration;

	public Organization getOrg(String organizationId) {
		Optional<Organization> org = organizationRepository.findById(organizationId);
		if (!org.isPresent())
			return null;
		Organization organization = org.get();
		organization.setName(nameConfiguration.getPrefix() + " " + organization.getName());
		return organization;
	}

	public void saveOrg(Organization org) {
		org.setId(UUID.randomUUID().toString());
		organizationRepository.save(org);
	}

	public void updateOrg(Organization org) {
		organizationRepository.save(org);
	}

	public void deleteOrg(Organization org) {
		organizationRepository.delete(org);
	}
}
