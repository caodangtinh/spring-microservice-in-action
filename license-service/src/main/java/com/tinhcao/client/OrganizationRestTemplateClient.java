package com.tinhcao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tinhcao.config.ServerEndpointConfig;
import com.tinhcao.model.Organization;

@Component
public class OrganizationRestTemplateClient {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private ServerEndpointConfig serverEndpointConfig;

	public Organization getOrganization(String organizationId) {
		ResponseEntity<Organization> restExchange = restTemplate.exchange(
				serverEndpointConfig.getOrganizationServiceEndpoint() + "/{organizationId}", HttpMethod.GET, null, Organization.class,
				organizationId);
		return restExchange.getBody();
	}
}
