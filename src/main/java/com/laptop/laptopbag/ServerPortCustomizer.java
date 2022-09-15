package com.laptop.laptopbag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;


@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	private final Logger oLog = LoggerFactory.getLogger(ServerPortCustomizer.class);
	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		int port = 9191;
		try{
			port = Integer.parseInt(System.getProperty("server.port"));
		}catch (Exception e) {
			oLog.error(String.format("Invalid Port Number/Port already in use %s", System.getProperty("server.port")));
		}
		oLog.info(String.format("Application is Running on Port %s", port));
		factory.setPort(port);
	}

}