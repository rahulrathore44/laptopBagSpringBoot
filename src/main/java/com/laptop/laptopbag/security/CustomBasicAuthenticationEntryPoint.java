package com.laptop.laptopbag.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.google.gson.JsonObject;


public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        response.addHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        JsonObject error = new JsonObject();
        error.addProperty("errorCode", HttpStatus.UNAUTHORIZED.name());
        error.addProperty("errorMessage", "An error occured : " + authException.getMessage());
        
        PrintWriter writer = response.getWriter();
        writer.write(error.toString()); 
	}
    
	
    @Override
    public void afterPropertiesSet() {
        setRealmName("Mock_Realm");
        super.afterPropertiesSet();
    }
}
