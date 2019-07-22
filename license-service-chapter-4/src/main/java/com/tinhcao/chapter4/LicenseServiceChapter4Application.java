package com.tinhcao.chapter4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LicenseServiceChapter4Application {

	public static void main(String[] args) {
		SpringApplication.run(LicenseServiceChapter4Application.class, args);
	}

}
