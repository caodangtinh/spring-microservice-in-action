package com.tinhcao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tinhcao.entity.Organization;
import com.tinhcao.service.OrganizationService;

@RestController
@RequestMapping("v1/organizations")
public class OrganizationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	private OrganizationService organizationService;

	@GetMapping(value = "/{organizationId}")
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		LOGGER.debug(String.format("Looking up data for org {}", organizationId));
		Organization org = organizationService.getOrg(organizationId);
		return org;
	}

	@PutMapping(value = "/{organizationId}")
	public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
		organizationService.updateOrg(org);
	}

	@PostMapping(value = "/{organizationId}")
	public void saveOrganization(@RequestBody Organization org) {
		organizationService.saveOrg(org);
	}

	@DeleteMapping(value = "/{organizationId}"	)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("orgId") String orgId, @RequestBody Organization org) {
		organizationService.deleteOrg(org);
	}
}
