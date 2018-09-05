package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataservice.DataService;
import com.example.model.Sampledata;

@CrossOrigin
@RestController
@RequestMapping(value = "/service")
public class RequestController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET , produces = "application/json")
	public List<Sampledata> getData(){
		
		return dataService.getData();
		
		 
		
	}
}
