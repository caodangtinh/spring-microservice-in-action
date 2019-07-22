package com.tinhcao.chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryChapter4Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryChapter4Application.class, args);
	}

}
