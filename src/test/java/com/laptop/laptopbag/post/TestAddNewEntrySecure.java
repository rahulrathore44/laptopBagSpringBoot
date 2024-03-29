package com.laptop.laptopbag.post;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.laptop.laptopbag.controller.LaptopDetailSecureController;
import com.laptop.laptopbag.model.Features;
import com.laptop.laptopbag.model.LaptopDetails;

@RunWith(SpringRunner.class)
@WebMvcTest(LaptopDetailSecureController.class)
public class TestAddNewEntrySecure {
	
	@Autowired
	private MockMvc mvc;
	
	private final String contextPath = "/laptop-bag/webapi/secure";
	
	private int id = (int) (Math.random() * 100);
	
	private LaptopDetails getLaptopWithRandomId() {
		LaptopDetails laptop = new LaptopDetails();
		laptop.setId(id);
		laptop.setLaptopName("Test Name");
		laptop.setBrandName("Test BrandName");
		Features feat = new Features();
		feat.setFeatures(Arrays.asList("One","Two","Three"));
		laptop.setFeatures(feat);
		return laptop;
	}
	
	private HttpHeaders getBasicAuthHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWRtaW46d2VsY29tZQ==");
		return headers;
	}
	
	@Test
	public void test_post_end_point_without_auth() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		String jsonContent = gson.toJson(getLaptopWithRandomId());
		ResultActions response = mvc.perform(post(contextPath + "/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(jsonContent));
		
		response.andExpect(status().isUnauthorized())
				.andExpect(jsonPath("$.errorCode", Matchers.not(Matchers.empty())));
	}
	
	@Test
	public void test_post_with_json_data_accept_json() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		String jsonContent = gson.toJson(getLaptopWithRandomId());
		ResultActions response = mvc.perform(post(contextPath + "/add")
				.headers(getBasicAuthHeader())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(jsonContent));
		
		response.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Id", is(id)));
	}
	
	@Test
	public void test_post_with_xml_data_accept_xml() throws Exception {
		XmlMapper xmlMapper = new XmlMapper();
		String xmlContent = xmlMapper.writeValueAsString(getLaptopWithRandomId());
		ResultActions response = mvc.perform(post(contextPath + "/add")
				.headers(getBasicAuthHeader())
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML).content(xmlContent));
		
		response.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
				.andExpect(xpath("/Laptop/Id").string(id + ""));
	}
	
	@Test
	public void test_post_with_json_data_accept_xml() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		String jsonContent = gson.toJson(getLaptopWithRandomId());
		
		ResultActions response = mvc.perform(post(contextPath + "/add")
				.headers(getBasicAuthHeader())
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_JSON).content(jsonContent));
		
		response.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
				.andExpect(xpath("/Laptop/Id").string(id + ""));
	}
	
	
	@Test
	public void test_post_with_xml_data_accept_json() throws Exception {
		XmlMapper xmlMapper = new XmlMapper();
		String xmlContent = xmlMapper.writeValueAsString(getLaptopWithRandomId());
		
		ResultActions response = mvc.perform(post(contextPath + "/add")
				.headers(getBasicAuthHeader())
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_XML).content(xmlContent));
		
		response.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.Id", is(id)));
	}
	
	
}
