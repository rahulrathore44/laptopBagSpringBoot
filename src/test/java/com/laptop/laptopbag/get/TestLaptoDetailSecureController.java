package com.laptop.laptopbag.get;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.laptop.laptopbag.controller.LaptopDetailSecureController;

@RunWith(SpringRunner.class)
@WebMvcTest(LaptopDetailSecureController.class)
public class TestLaptoDetailSecureController {
	
	@Autowired
	private MockMvc mvc;
	
	private final String contextPath = "/laptop-bag/webapi/secure";
	
	private HttpHeaders getBasicAuthHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic YWRtaW46d2VsY29tZQ==");
		return headers;
	}
	
	@Test
	public void test_Get_all_end_point_without_auth() throws Exception {
		mvc.perform(get(contextPath + "/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
	}
	
	@Test
	public void test_Get_all_end_point_with_json_data() throws Exception {
		mvc.perform(get(contextPath + "/all").headers(getBasicAuthHeader()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].Id", is(1)));
	}
	
}
