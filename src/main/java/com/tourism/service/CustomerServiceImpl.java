package com.tourism.service;

import java.text.SimpleDateFormat; 
import java.util.Calendar;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.model.BDetails;
import com.tourism.model.Customer;
import com.tourism.model.TPackages;
import com.tourism.model.Travels;
import com.tourism.repository.CustomerRepository;
import com.tourism.repository.TPackagesRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
    
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	CustomerService customerservice;
	@Autowired
	TravelsService travelsservice;
	@Autowired
	TPackagesService tpackageservice;
	@Autowired
	TPackagesRepository tpackagesrepo;
	@Autowired
	BDetailsService bdetailsservice;
	private String status="";
	private String user="";
	private int travid=0;
	@Override
	public void saveCustomer(Customer c) {
		customerrepo.save(c);		
	}

	@Override
	public List<Customer> fetchCustomerList() {
		List<Customer> list=customerrepo.findAll();
		return list;
	}

	@Override
	public Customer updateCustomer(Customer c, String CustomerId) {
		Customer c1=customerrepo.getById(CustomerId);
		c1.setCustomername(c.getCustomername());
		c1.setAddress(c.getAddress());
		c1.setEmail(c.getEmail());
		c1.setGender(c.getGender());
		c1.setNoofperson(c.getNoofperson());
		c1.setPhonenumber(c.getPhonenumber());
		c1.setPass(c.getPass());
		return c1;
	}

	@Override
	public Customer deleteCustomerById(String CustomerId) {
		  Customer c1=customerrepo.getById(CustomerId);
		  customerrepo.deleteById(CustomerId);
		  return c1;
	}

	@Override
	public Customer getCustomerById(String CustomerId) {
		 Customer c1=customerrepo.getById(CustomerId);
		 return c1;
	}

	@Override
	public String register(Customer c) {
		  try{
		    	if(!customerrepo.existsById(c.getCustomerid())){
		    		if(c.getCustomerid().matches("^[a-zA-Z\\\\d*]{8}$")) {
		    		if(c.getPhonenumber().length()==10 && c.getPhonenumber().matches("[0-9]{10}")){
		    			if(c.getEmail().matches("[A-za-z0-9~!@#$%^&*()_+{}:<>?|]{3,10}"+"@gmail.com")) {
		    				if(c.getPass().matches("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8}$") && c.getPass().length()==8) {
		    					customerservice.saveCustomer(c);
		    		    		return "Registered Successfully";	
		    				}
		    				else 
		    					throw new Exception("Enter the vaild Password. eg:Abc@1def");	    				
		    			}
		    			else 
		    				throw new Exception("Enter the vaild Email Id");    			
		    		}
		    		else 
		    			throw new Exception("Enter the valid phonenumber");	    		
		    	  }
		    		else 
		    			throw new Exception("Enter the valid CustomerId. eg:Abc123de");	    		
		    	}
		    	else 
		    		throw new Exception("This Customer Id is already exist.Create another");	    	
		    }catch(Exception e) 
		    {
		    	return e.getMessage();
		    }
	}

	@Override
	public String login(Customer c) {
		  try{
		    	if(customerrepo.getById(c.getCustomerid()).getCustomerid().matches(c.getCustomerid()) && customerrepo.getById(c.getCustomerid()).getPass().matches(c.getPass())){
		             status="Login";
		             user=c.getCustomerid();
			    	 return "Login Successful";	
		    		}
		        else 
		          throw new Exception("CustomerId or Password is Incorrect");
		    }catch(Exception e) {
		    	return e.getMessage();
		    }
	}

	@Override
	public String viewcustomer(Customer c) {
		try{
			if(status.matches("Login"))
				return customerservice.getCustomerById(user).toString();
		    else 
			  throw new Exception("You have to Login.");
	       }catch(Exception e) {
		    	return e.getMessage();
	       }
	}

	@Override
	public String updatecustomer(Customer c) {
		try{
			if(status.matches("Login"))
		    {
		     return updateCustomer(c,user).toString();
		    }
		    else 
			  throw new Exception("You have to Login.");
	       }catch(Exception e) {
		    	return e.getMessage();
	       }
	}

	@Override
	public String listtravels() {
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
	public String selecttravels(Travels t) {
		try{
			if(status.matches("Login"))
				return tpackageservice.fetchTPackagesList().stream().filter(tp->tp.getTravelsid()==tp.getTravelsid()).toString();	
		    else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String selecttpackage(TPackages t) {
		try{
			if(status.matches("Login"))
		    {  
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance(); 
				cal.setTime(sdf.parse(t.getStartingdate()));
				cal.add(Calendar.DAY_OF_MONTH, tpackagesrepo.getById(t.getTpid()).getDuration());
				bdetailsservice.saveBDetails(customerservice.getCustomerById(user).getCustomername(),travelsservice.getTravelsById(travid).getTravelsname(),tpackageservice.getTPackagesById(t.getTpid()).getRoute(),t.getStartingdate(),sdf.format(cal.getTime()),customerservice.getCustomerById(user).getNoofperson(),customerservice.getCustomerById(user).getNoofperson()*tpackageservice.getTPackagesById(t.getTpid()).getBudgetperperson());
				List<TPackages> tplist=tpackageservice.fetchTPackagesList().stream().filter(tp->Integer.toString(tp.getTravelsid()).matches(Integer.toString(travid)) && Integer.toString(tp.getTpid()).matches(Integer.toString(t.getTpid()))).toList();
			    return "Your travelpackage is "+tplist.get(0).getRoute();
				
		    }else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String finddetails() {
		try{
			if(status.matches("Login"))
		    {
				List<BDetails> tplist= bdetailsservice.fetchBDetailsList().stream().filter(b->b.getCustomername().matches(customerservice.getCustomerById(user).getCustomername())).toList();
				if(bdetailsservice.getBDetailsById(tplist.get(0).getBdid())!=null)
					return bdetailsservice.getBDetailsById(tplist.get(0).getBdid()).toString();
				else 
			       return "No booking history.";
		    }else 
		    	throw new Exception("You have to Login.");
		}catch(Exception e) {
		      return e.getMessage();
		}
	}

	@Override
	public String logout() {
		if(status.matches("Login")) {
            status="";
            user="";
	    	return "Logout Successful";
		}
		return null;
	}

}
