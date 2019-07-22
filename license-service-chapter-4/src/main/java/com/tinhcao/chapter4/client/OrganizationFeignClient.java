package com.tinhcao.chapter4.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tinhcao.chapter4.model.Organization;

@FeignClient(name = "organization-service")
public interface OrganizationFeignClient {
	@GetMapping(value = "/v1/organizations/{organizationId}")
	public Organization getOrganization(@PathVariable(name = "organizationId") String organizationId);
	
	@GetMapping(value = "/v1/organizations/name")
	public String getOrgName();
}
