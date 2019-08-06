package com.hcl.productanalytics.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductAnalyticsApplication {
	private static final Logger logger = LogManager.getLogger(ProductAnalyticsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProductAnalyticsApplication.class, args);
		logger.info("ProductAnalyticsApplication main method");
	}

}
