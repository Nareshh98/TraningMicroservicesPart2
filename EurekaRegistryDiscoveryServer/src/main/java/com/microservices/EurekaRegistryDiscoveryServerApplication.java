package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer      // we have add 
public class EurekaRegistryDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistryDiscoveryServerApplication.class, args);
	}

}
