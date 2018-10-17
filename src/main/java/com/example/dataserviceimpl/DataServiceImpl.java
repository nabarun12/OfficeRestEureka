package com.example.dataserviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dataservice.DataService;
import com.example.model.Sampledata;
import com.example.restcall.CallRestAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class DataServiceImpl implements DataService {

	@Autowired 
	CallRestAPI callRest;
	
	@Override
	public List<Sampledata> getData() {

		List<Sampledata> dataList = new ArrayList<Sampledata>();
		Sampledata data1 = new Sampledata("pamela", 29);
        Sampledata data2 = new Sampledata("jim", 31);
		dataList.add(data1);
		dataList.add(data2);
		//return dataList;
        StringBuilder  strB = new StringBuilder("");
        strB.delete(0, strB.length());
        
        return dataList;
	}
	
	@Override
	public List<Sampledata> getFriendsData() throws JsonProcessingException, IOException {

		return callRest.getFriendsData();
        
	}

}
