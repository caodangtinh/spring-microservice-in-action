package com.tinhcao.controller;

import com.tinhcao.entity.Organization;
import com.tinhcao.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organizations")
public class OrganizationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;
    
    @GetMapping(value = "/")
    public String home() {
    	return "organizationservice";
    }

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

    @DeleteMapping(value = "/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("orgId") String orgId, @RequestBody Organization org) {
        organizationService.deleteOrg(org);
    }
}
