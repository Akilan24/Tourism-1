package com.tourism.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.model.Admin;
import com.tourism.model.TPackages;
import com.tourism.model.Travels;
import com.tourism.repository.AdminRepository;

@Service
public class AdminServcieImpl implements AdminService{

	@Autowired
	AdminRepository repo;
	@Autowired
	AdminService adminservice;
	@Autowired
	CustomerService customerservice;
	@Autowired
	TravelsService travelsservice;
	@Autowired
	TPackagesService tpackagesservice;
	private String status="";
	private String admin="";
	@Override
	public void saveAdmin(Admin a) {
		repo.save(a);
	}

	@Override
	public List<Admin> fetchAdminList() {
		List<Admin> list=repo.findAll();
		return list;
	}

	@Override
	public Admin updateAdmin(Admin a, String adminid) {
		Admin a1=repo.getById(adminid);
		a1.setAdminname(a.getAdminname());
		a1.setAddress(a.getAddress());
		a1.setEmail(a.getEmail());
		a1.setGender(a.getGender());
		a1.setPhonenumber(a.getPhonenumber());
		a1.setPass(a.getPass());
		return a1;
	}

	@Override
	public Admin deleteAdminById(String adminid) {
		  Admin a1=repo.getById(adminid);
		  repo.deleteById(adminid);
		  return a1;
	}

	@Override
	public Admin getAdminById(String adminid) {
		 Admin a1=repo.getById(adminid);
		 return a1;
	}

	@Override
	public String registerAdmin(Admin a) {
	    try{
	    	if(!repo.existsById(a.getAdminid())){
	    		if(a.getAdminid().matches("^[a-zA-Z\\\\d*]{8}$")) {
	    		if(a.getPhonenumber().length()==10 && a.getPhonenumber().matches("[0-9]{10}")){
	    			if(a.getEmail().matches("[A-za-z0-9~!@#$%^&*()_+{}:<>?|]{3,10}"+"@gmail.com")) {
	    				if(a.getPass().matches("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$") && a.getPass().length()==8) {
	    					adminservice.saveAdmin(a);
	    		    		return "Registered Successfully";	
	    				}
	    				else 
	    					throw new Exception("Enter the vaild Password");	    				
	    			}
	    			else 
	    				throw new Exception("Enter the vaild Email Id");	    			
	    		}
	    		else 
	    			throw new Exception("Enter the valid phonenumber");	    		
	    	}
	    	 else 
	    			throw new Exception("Enter the valid AdminId. eg:Abc123de");	    		
	    	}
	    	else 
	    		throw new Exception("This Admin Id is already exist.Create another");	    	
	    }catch(Exception e) 
	    {
	    	return e.getMessage();
	    }
	}

	@Override
	public String loginAdmin(Admin a) {
		   try{
		    	if(repo.getById(a.getAdminid()).getAdminid().matches(a.getAdminid()) && repo.getById(a.getAdminid()).getPass().matches(a.getPass())){
		             status="Login";
		             admin=a.getAdminid();
			    	 return "Login Successful";	
		    		}
		        else 
		        
		          throw new Exception("AdminId or Password is Incorrect");		    
		    }catch(Exception e) {
		    	return e.getMessage();
		    }
	}

	@Override
	public String viewAdmin() {
		try{
			if(status.matches("Login"))		    
				return adminservice.getAdminById(admin).toString();		    
		    else 		    
			  throw new Exception("You have to Login.");		    
	       }catch(Exception e) {
		    	return e.getMessage();
	       }
	}

	@Override
	public String updateAdmin(Admin a) {
		try{
			if(status.matches("Login"))
		     return adminservice.updateAdmin(a, admin).toString();
		    else		    
			  throw new Exception("You have to Login.");		    
	       }catch(Exception e) {
		    	return e.getMessage();
	       }
	}

	@Override
	public String listAdmin() {
		try{
			if(status.matches("Login"))		   
	        	return adminservice.fetchAdminList().toString();		    
			else	        
				throw new Exception("You have to Login.");			
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String findAdmin(String adminid) {
		try{
			if(status.matches("Login"))
		    {
				if(adminservice.getAdminById(adminid)!=null) 
				  return adminservice.getAdminById(adminid).toString();
			    else 		   
				  return "AdminId is not found";
		    }else	        
				throw new Exception("You have to Login.");			
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String deleteAdmin(String adminid) {
		try{
			if(status.matches("Login"))
				return adminservice.deleteAdminById(adminid).getAdminid()+" is deleted.";
		    else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String listCustomers() {
		try{
			if(status.matches("Login"))
				return customerservice.fetchCustomerList().toString();
		    else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String findCustomer(String CustomerId) {
		try{
			if(status.matches("Login"))
			{
				if(customerservice.getCustomerById(CustomerId)!=null) {
					return customerservice.getCustomerById(CustomerId).toString();
		        }else 
			    return "CustomerId is not found.";		        
		    }else {
		    	throw new Exception("You have to Login.");
		    }
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String listTravels() {
		try{
			if(status.matches("Login"))
				return travelsservice.fetchTravelsList().toString();
		    else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String addtravels(Travels t) {
		travelsservice.saveTravels(t);
		return "Travels added.";
		
	}
    @Override
	public String findtravels(int TravelsId) {
    	try{
			if(status.matches("Login"))
		    {
				if(travelsservice.getTravelsById(TravelsId)!=null) 
					return travelsservice.getTravelsById(TravelsId).toString();		        
				else 
			    return "TravelsId is not found.";		        
		    }else 
		    	throw new Exception("You have to Login.");		    
		}catch(Exception e) {
		      return e.getMessage();
		}
	}
	@Override
	public String deletetravels(int TravelsId) {
		try{
			if(status.matches("Login"))
		    {
				if(travelsservice.getTravelsById(TravelsId)!=null) 
				   return travelsservice.deleteTravelsById(TravelsId).toString();				
				else 				
				   return "TravelsId is not found.";			    
		    }else 
		    	throw new Exception("You have to Login.");		    
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String viewtpackages() {
		try{
			if(status.matches("Login"))
				return tpackagesservice.fetchTPackagesList().toString();
		    else 
		    	throw new Exception("You have to Login.");		    
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String findtpackages(int TravelsId) {
		try{
			if(status.matches("Login"))
		    {   List<TPackages> tplist=tpackagesservice.fetchTPackagesList().stream().filter(t->Integer.toString(t.getTravelsid()).matches(Integer.toString(TravelsId))).toList();
				if(tplist!=null) 
					return tplist.toString();		        
				else 
			    return "No travel Packages are found.";		        
		    }else 
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
          admin="";
	      return "Logout Successful";}
		return null;
	}
    
}
