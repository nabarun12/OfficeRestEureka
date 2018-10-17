package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataservice.DataService;
import com.example.model.Sampledata;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin
@RestController
@RequestMapping(value = "/service")
public class RequestController {

	@Autowired
	DataService dataService;

	@RequestMapping(value = "/getData", method = RequestMethod.GET, produces = "application/json")
	public List<Sampledata> getData() {

		return dataService.getData();

	}

	@RequestMapping(value = "/getFriendsData", method = RequestMethod.GET, produces = "application/json")
	public List<Sampledata> getFriendsData() throws JsonProcessingException, IOException {

		return dataService.getFriendsData();

	}

	@ExceptionHandler
	public String eatException(Exception ex) {

		return ex.getMessage();
	}
}
