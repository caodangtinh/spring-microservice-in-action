package com.tinhcao.chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceChapter4Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceChapter4Application.class, args);
	}

}
