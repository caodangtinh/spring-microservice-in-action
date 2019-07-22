package com.tinhcao.chapter4.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tinhcao.chapter4.model.Organization;

@Component
public class OrganizationRestTemplateClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Organization getOrganization(String organizationId) {
		String endPoint = String.format("http://organization-service/v1/organizations/{organizationId}");
		return restTemplate.exchange(endPoint, HttpMethod.GET, null, Organization.class, organizationId).getBody();
	}
	
	public String getOrgName() {
		String endPoint = String.format("http://organization-service/v1/organizations/name");
		return restTemplate.getForObject(endPoint, String.class);
	}
}
