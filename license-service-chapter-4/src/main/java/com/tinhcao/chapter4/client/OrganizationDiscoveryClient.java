package com.tinhcao.chapter4.client;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tinhcao.chapter4.model.Organization;

@Component
public class OrganizationDiscoveryClient {

	@Autowired
	private DiscoveryClient discoveryClient;

	public Organization getOrganization(String organizationId) {
		ServiceInstance firstOrganizationServiceInstance = getInstance();
		String endPoint = String.format("%s/v1/organizations/{organizationId}",
				firstOrganizationServiceInstance.getUri().toString());
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(endPoint, HttpMethod.GET, null, Organization.class,
				firstOrganizationServiceInstance.getInstanceId()).getBody();
	}

	public String getOrgName() {
		ServiceInstance firstOrganizationServiceInstance = getInstance();
		String endPoint = String.format("%s/v1/organizations/name",
				firstOrganizationServiceInstance.getUri().toString());
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(endPoint, String.class);
	}

	private ServiceInstance getInstance() {
		List<ServiceInstance> organizationServiceinstances = discoveryClient.getInstances("organization-service");
		if (organizationServiceinstances.size() == 0) {
			return null;
		}
		Random random = new Random();
		int randomService = random.nextInt(organizationServiceinstances.size());
		ServiceInstance firstOrganizationServiceInstance = organizationServiceinstances.get(randomService);
		return firstOrganizationServiceInstance;
	}
}
