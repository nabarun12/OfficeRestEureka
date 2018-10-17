package com.example.dataservice;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Sampledata;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
@Repository
public interface DataService {
	
	public List<Sampledata> getData();

	public List<Sampledata> getFriendsData() throws JsonProcessingException, IOException;
	

}
