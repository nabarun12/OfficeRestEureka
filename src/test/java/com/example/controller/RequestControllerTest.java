package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.dataservice.DataService;
import com.example.model.Sampledata;


@RunWith(SpringRunner.class)
@WebMvcTest(RequestController.class)
@ActiveProfiles("test")
public class RequestControllerTest {
	
	
	@MockBean
	DataService dataService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void TestGetData() throws Exception{
		
		Sampledata mockSampleData= new Sampledata("Phyllis", 46);
		List<Sampledata> mockSampleDataList = new ArrayList<Sampledata>();
		mockSampleDataList.add(mockSampleData);
		given(dataService.getData()).willReturn(mockSampleDataList);
		this.mockMvc.perform(get("/service/getData")).andExpect(status().isOk()).andExpect(content().string(containsString("Phyllis")));
		
		
	}
	
	

}
