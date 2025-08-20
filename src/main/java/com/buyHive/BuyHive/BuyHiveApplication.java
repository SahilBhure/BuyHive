package com.buyHive.BuyHive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"Data"})
@SpringBootApplication
public class BuyHiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyHiveApplication.class, args);
	}

}
