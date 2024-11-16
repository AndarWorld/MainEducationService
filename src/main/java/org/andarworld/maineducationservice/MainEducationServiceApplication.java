package org.andarworld.maineducationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainEducationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainEducationServiceApplication.class, args);
	}

}
