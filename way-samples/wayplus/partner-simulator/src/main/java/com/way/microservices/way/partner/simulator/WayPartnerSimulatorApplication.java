package com.way.microservices.way.partner.simulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WayPartnerSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WayPartnerSimulatorApplication.class, args);
	}

}
