package com.laptop.laptopbag;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaptopbagApplication {
	private static final Logger oLog = LoggerFactory.getLogger(LaptopbagApplication.class);

	public static void main(String[] args) {
		int port = 9191;
		try {
			port = Integer.parseInt(System.getProperty("server.port"));
		} catch (Exception e) {
			oLog.error(String.format("Invalid Port Number/Port already in use %s", System.getProperty("server.port")));
		}
		SpringApplication app = new SpringApplication(LaptopbagApplication.class);
		oLog.info(String.format("Application is Running on Port %s", port));
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);
	}
}
