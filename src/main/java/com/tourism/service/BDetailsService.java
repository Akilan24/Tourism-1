package com.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.model.BDetails;

@Service
public interface BDetailsService {

	List<BDetails> fetchBDetailsList();
    void saveBDetails(String customername,String travelsname,String route,String startingdate,String endingdate,int noofperson,double totalcost);
	BDetails getBDetailsById(int bdid);
}
