package com.example.dataservice;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Sampledata;

@Component
@Repository
public interface DataService {
	
	public List<Sampledata> getData();
	

}
