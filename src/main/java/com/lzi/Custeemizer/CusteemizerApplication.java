package com.lzi.Custeemizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CusteemizerApplication {

	private static final Logger logger = LoggerFactory.getLogger(CusteemizerApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(CusteemizerApplication.class, args);
		logger.info("Hello to my application");
	}

}
