package com.biz.jtest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/WEB-INF/spring/testServlet/home-test-context.xml"})
public class HomeControllerTest {

	@Autowired
	HomeController hController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(hController).build();
	}
	
	@Test
	public void testHome() throws Exception {
		
		mockMvc.perform(get("/")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testWriteGET() throws Exception {
		mockMvc.perform(get("/write")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testWritePOST() throws Exception {
		mockMvc.perform(post("/write")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testWritePOSTParam() throws Exception {
		mockMvc.perform(post("/write").param("str","호호호호호랑이")).andExpect(status().isOk()).andDo(print());
	}

}
