package com.example.dataserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dataservice.DataService;
import com.example.model.Sampledata;

@Service
public class DataServiceImpl implements DataService {

	public List<Sampledata> getData() {

		List<Sampledata> dataList = new ArrayList<Sampledata>();
		Sampledata data1 = new Sampledata("monica", 29);
        Sampledata data2 = new Sampledata("chandler", 31);
		dataList.add(data1);
		dataList.add(data2);
		return dataList;

	}

}
