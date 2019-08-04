package com.tinhcao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "endpoint")
@Component
public class ServerEndpointConfig {
    private String organizationServiceEndpoint;

    public String getOrganizationServiceEndpoint() {
        return organizationServiceEndpoint;
    }

    public void setOrganizationServiceEndpoint(String organizationServiceEndpoint) {
        this.organizationServiceEndpoint = organizationServiceEndpoint;
    }

}
