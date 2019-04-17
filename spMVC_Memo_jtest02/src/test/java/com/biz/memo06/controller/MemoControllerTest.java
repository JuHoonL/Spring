package com.biz.memo06.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.biz.memo06.service.MemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/WEB-INF/spring/testServlet/*-context.xml"})
public class MemoControllerTest {

	@InjectMocks
	MemoController mController;
	
	@Mock
	MemoService mService;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		
		//@Mocks @InjectMocks로 설정된 클래스들을 초기화
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(mController).build();
	}
	
	@Test
	public void testMemo() throws Exception {
		
		mockMvc.perform(get("/memo/update")).andExpect(status().isOk()).andDo(print());
		verify(mService).findById(1);
	}
}
