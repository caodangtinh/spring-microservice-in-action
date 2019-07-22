package com.tinhcao.chapter4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinhcao.chapter4.client.OrganizationDiscoveryClient;
import com.tinhcao.chapter4.client.OrganizationFeignClient;
import com.tinhcao.chapter4.client.OrganizationRestTemplateClient;
import com.tinhcao.chapter4.model.Organization;

@RestController
@RequestMapping(value = "v1/licenses")
public class LicenseController {
	@Autowired
	private OrganizationDiscoveryClient organizationDiscoveryClient;

	@Autowired
	private OrganizationRestTemplateClient organizationRestTemplateClient;
	
	@Autowired
	private OrganizationFeignClient organizationFeignClient;
	
	@GetMapping(value = "/{organizationId}/{type}")
	public Organization getOrganization(
			@PathVariable(name = "organizationId") String organizationId,
			@PathVariable(name = "type") String type) {
		switch (type) {
		case "discovery":
			return organizationDiscoveryClient.getOrganization(organizationId);
		case "rest":
			return organizationRestTemplateClient.getOrganization(organizationId);
		case "feign":
			return organizationFeignClient.getOrganization(organizationId);
		default:
			break;
		}
		return null;
	}
	
	@GetMapping(value = "/name/{type}")
	public String getOrgName(			
			@PathVariable(name = "type") String type) {
		switch (type) {
		case "discovery":
			return organizationDiscoveryClient.getOrgName();
		case "rest":
			return organizationRestTemplateClient.getOrgName();
		case "feign":
			return organizationFeignClient.getOrgName()	;
		default:
			break;
		}
		return null;
	}
	
}
