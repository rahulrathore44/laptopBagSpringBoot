package com.laptop.laptopbag.get;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.laptop.laptopbag.controller.LaptopDetailController;

@WebMvcTest(LaptopDetailController.class)
public class TestLaptoDetailController {
	
	@Autowired
	private MockMvc mvc;
	
	private final String contextPath = "/laptop-bag/webapi/api";
	
	@Test
	public void test_Get_all_end_point_with_json_data() throws Exception {
		mvc.perform(get(contextPath + "/all").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].Id", is(1)));
	}
	
	@Test
	public void test_Get_all_end_point_with_xml_data() throws Exception {
		mvc.perform(get(contextPath + "/all").accept(MediaType.APPLICATION_XML)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_XML))
				.andExpect(xpath("//Id[text()=1]").exists());
	}
	
}
