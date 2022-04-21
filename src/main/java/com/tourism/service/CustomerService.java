package com.tourism.service;

import java.util.List; 
import org.springframework.stereotype.Service;

import com.tourism.model.Customer;
import com.tourism.model.TPackages;
import com.tourism.model.Travels;

@Service
public interface CustomerService {

	void saveCustomer(Customer c);
	List<Customer> fetchCustomerList();
	Customer updateCustomer(Customer c,String CustomerId);
	Customer deleteCustomerById(String CustomerId);
	Customer getCustomerById(String CustomerId);
	String register(Customer c);
	String login(Customer c);
	String viewcustomer(Customer c);
	String updatecustomer(Customer c);
	String listtravels();
	String selecttravels(Travels t);
	String selecttpackage(TPackages t);
	String finddetails();
	String logout();
}
