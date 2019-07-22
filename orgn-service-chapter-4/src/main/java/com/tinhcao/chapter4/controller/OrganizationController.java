package com.tinhcao.chapter4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinhcao.chapter4.config.OrganizationConfigurationProperties;
import com.tinhcao.chapter4.model.Organization;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationConfigurationProperties organizationConfigurationProperties;

	@GetMapping(value = "/{organizationId}")
	public Organization getOrganization(@PathVariable(name = "organizationId") String organizationId) {
		return new Organization(organizationId, "org test", "contact name", "caodangtinh@gmail.com", "0964700368");
	}
	
	@GetMapping(value = "/name")
	public String getConfigurationValue() {
		return organizationConfigurationProperties.getName();
	}
}
