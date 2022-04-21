package com.tourism.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.model.Customer;
import com.tourism.model.TPackages;
import com.tourism.model.Travels;
import com.tourism.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;
		
	@RequestMapping("/customertest")
	public String test() {
		return "Test Customer Controller";
	}
	@GetMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer c) throws Exception{
		return new ResponseEntity<>(customerservice.register(c), HttpStatus.NOT_FOUND);
	}
	@GetMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer c){
		return new ResponseEntity<>(customerservice.login(c), HttpStatus.NOT_FOUND);
	}
	@GetMapping("/view")
	public ResponseEntity<?> viewcustomer(){
		return new ResponseEntity<>(customerservice.viewcustomer(null), HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer c){
        return new ResponseEntity<>(customerservice.updatecustomer(c), HttpStatus.NOT_FOUND);
	}
	@RequestMapping("/viewtravels")
	public ResponseEntity<?> listTravels(){
		return new ResponseEntity<>(customerservice.listtravels(), HttpStatus.NOT_FOUND);
	}
	@RequestMapping("/selecttravels")
	public ResponseEntity<?> selecttravels(@RequestBody Travels t){
		return new ResponseEntity<>(customerservice.selecttravels(t), HttpStatus.NOT_FOUND);
	}
	@RequestMapping("/selecttpackage")
	public ResponseEntity<?> selecttpackage(@RequestBody TPackages t){
		return new ResponseEntity<>(customerservice.selecttpackage(t), HttpStatus.NOT_FOUND);
	}
	@RequestMapping("/getbookdetail")
	public ResponseEntity<?> findbdetails(){
		return new ResponseEntity<>(customerservice.finddetails(), HttpStatus.NOT_FOUND);
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logoutCustomer(){
		return new ResponseEntity<>(customerservice.logout(), HttpStatus.NOT_FOUND);
	}
}
