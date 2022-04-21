package com.tourism.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tourism.model.BDetails;
import com.tourism.repository.BdetailsRepository;

@Service
public class BDetailsServiceImpl implements BDetailsService{

	@Autowired
	BdetailsRepository repo;
	@Autowired
    JdbcTemplate jd;
	@Override
	public List<BDetails> fetchBDetailsList() {
		List<BDetails> list=repo.findAll();
		return list;
	}
	public void saveBDetails(String customername,String travelsname,String route,String startingdate,String endingdate,int noofperson,double totalcost) {
		int bdid=0;
		if(repo.count()==0)
			bdid=101;
		else
			bdid=(int) (101+repo.count());
		String str="insert into bdetails values("+bdid+",'"+customername+"','"+travelsname+"','"+route+"','"+startingdate+"','"+endingdate+"',"+noofperson+","+totalcost+")";
	    jd.execute(str);
	}

	@Override
	public BDetails getBDetailsById(int bdid) {
		BDetails bd=repo.getById(bdid);
		return bd;
	}

}
