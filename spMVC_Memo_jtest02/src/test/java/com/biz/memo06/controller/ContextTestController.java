package com.biz.memo06.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/WEB-INF/spring/appServlet/*-context.xml")
@WebAppConfiguration
public class ContextTestController {

	/*
	 * 변수에 protected 선언을 하면 다른클래스에서 직접 접근 할 수 없으나 상속받은 클래스에서는 직접접근 가능
	 */
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void test() throws Exception {
		mvc.perform(get("/"));
	}
}
