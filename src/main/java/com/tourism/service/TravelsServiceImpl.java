package com.tourism.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.model.TPackages;
import com.tourism.model.Travels;
import com.tourism.repository.TravelsRepository;

@Service
public class TravelsServiceImpl implements TravelsService{

	@Autowired
    TravelsRepository travelsrepo;
	@Autowired
	TPackagesService tpackageservice;
	@Autowired
	TravelsService travelsservice;
	@Autowired
	BDetailsService bdetailsService;
	private String status="";
	private int user=0;
	@Override
	public void saveTravels(Travels t) {
	 travelsrepo.save(t);
		
	}

	@Override
	public List<Travels> fetchTravelsList() {
		List<Travels> list=travelsrepo.findAll();
		return list;
	}

	@Override
	public Travels updateTravels(Travels t, int TravelsId) {
		 Travels t1=travelsrepo.getById(TravelsId);
		 t1.setTravelsname(t.getTravelsname());
		 t1.setAddress(t.getAddress());
		 t1.setPhonenumber(t.getPhonenumber());
		 t1.setEmail(t.getEmail());
		 return t1;
	}

	@Override
	public Travels deleteTravelsById(int TravelsId) {
		  Travels t1=travelsrepo.getById(TravelsId);
		  travelsrepo.deleteById(TravelsId);
		  return t1;
	}

	@Override
	public Travels getTravelsById(int TravelsId) {
		 Travels t1=travelsrepo.getById(TravelsId);
		 return t1;
	}

	@Override
	public String login(Travels t) {
		   try{
			   if(status.matches("login")) {
		    	if(travelsrepo.existsById(t.getTravelsid()) && travelsrepo.getById(t.getTravelsid()).getPass().matches(t.getPass())){
		             status="Login";
		             user=t.getTravelsid();
			    	 return "Login Successful";	
		    		}
		        else 
		          throw new Exception("TravelsId or Password is Incorrect");}		    
				  throw new Exception("You have to Login.");
					}catch(Exception e) {
					      return e.getMessage();
					}
	}

	@Override
	public String updatetravels() {
		try{
			if(status.matches("login")) {
			if(travelsservice.getTravelsById(user)!=null) {
	          travelsservice.saveTravels(travelsservice.getTravelsById(user));
	          return travelsservice.getTravelsById(user).toString();
			}
			else
				throw new Exception("TravelsId is not found.");}
		    else
				  throw new Exception("You have to Login.");
			}catch(Exception e) {
			      return e.getMessage();
			}
	}

	@Override
	public String listtpackages() {
		try{  
			if(status.matches("login")) 
			    return tpackageservice.fetchTPackagesList().stream().filter(t->Integer.toString(t.getTravelsid()).matches(Integer.toString(user))).toString();
		    else
			  throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String findtpackages(int tpid) {
		try{
			if(status.matches("login")) {
			if(tpackageservice.getTPackagesById(tpid)!=null) 
				return tpackageservice.getTPackagesById(tpid).toString();
			else 
		       throw new Exception("TPId is not found.");}
			else
				throw new Exception("You have to Login.");
	}catch(Exception e) {
	      return e.getMessage();
	}
	}

	@Override
	public String addtpackage(TPackages t) {
		try{
			if(status.matches("login")) {
		     tpackageservice.saveTPackages(t);
	      	return "Tpackage added.";}
			else
				throw new Exception("You have to Login.");
	       }catch(Exception e) {
		    	return e.getMessage();
	       } 
	}

	@Override
	public String updatetpackage(int tpid) {
		try{
			if(status.matches("login")) {
			if(tpackageservice.getTPackagesById(tpid)!=null) {
	          tpackageservice.saveTPackages(tpackageservice.getTPackagesById(tpid));
	          return tpackageservice.getTPackagesById(tpid).toString();
			}
			else 
				throw new Exception("TPId is not found.");}
		else
			throw new Exception("You have to Login.");
       }catch(Exception e) {
	    	return e.getMessage();
       }
	}

	@Override
	public String deletepackage(int tpid) {
		try{
			if(status.matches("login")) {
			if(tpackageservice.getTPackagesById(tpid)!=null) 
			   return tpackageservice.deleteTPackagesById(tpid).toString();
			else 
				throw new Exception("TPId is not found.");}
			else
				throw new Exception("You have to Login.");
	}catch(Exception e) {
	      return e.getMessage();
	}
	}

	@Override
	public String viewbookdetails() {
		try{ 
			if(status.matches("login")) 
			   return bdetailsService.fetchBDetailsList().stream().filter(b->b.getTravelsname().matches(travelsrepo.getById(user).getTravelsname())).toString();
			else
				throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String logout() {
		if(status.matches("login")) {
			  System.out.println("Logout Successful");
	          status="";
	          user=0;
		      return "Logout Successful";}
			return null;
		}
	}

