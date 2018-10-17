package com.example.restcall;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.model.Sampledata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Component
public class CallRestAPI {

	@Value("${friendsUrl}")
	public String friendsUrl;
/*
	@Value("#{bigbangtheoryUrl}")
	private String jackUrl;*/

	public String getFriendsUrl() {
		return friendsUrl;
	}

	public void setFriendsUrl(String friendsUrl) {
		this.friendsUrl = friendsUrl;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Autowired
	private RestTemplate restTemplate;

	public List<Sampledata> getFriendsData() throws JsonProcessingException, IOException {

		List<Sampledata> listSampledata = new ArrayList<Sampledata>();
		Sampledata sample;
		String name ;
		int age ;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(friendsUrl + "/service/getData", String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseEntity.getBody());
		Iterator<JsonNode> iter= root.elements();
		Entry<String,JsonNode> entry;
		while(iter.hasNext()){
			JsonNode jsonNode = iter.next();
			name = jsonNode.path("name").toString().replace("\"","");
			age = jsonNode.path("age").asInt();
			sample = new Sampledata(name,age);
			listSampledata.add(sample);
			
		}
		
		return listSampledata;
	}

}
