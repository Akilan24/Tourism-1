package com.tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.model.Admin;
import com.tourism.model.Travels;
import com.tourism.repository.AdminRepository;
import com.tourism.service.AdminService;


@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@Autowired
	AdminRepository repo;
	
	@RequestMapping("/admintest")
	public String test() {
		return "Test Admin Controller";
	}
	@RequestMapping("/register")
	public ResponseEntity<?> registerAdmin(@RequestBody Admin a){
	   return new ResponseEntity<>(adminservice.registerAdmin(a),HttpStatus.OK);
	}
	@GetMapping("/login")
	public ResponseEntity<?> loginAdmin(@RequestBody Admin a){
		return new ResponseEntity<>(adminservice.loginAdmin(a),HttpStatus.OK);
	}
	@GetMapping("/view")
	public ResponseEntity<?> viewAdmin(){
		return new ResponseEntity<>(adminservice.viewAdmin(),HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin a){
		return new ResponseEntity<>(adminservice.updateAdmin(a),HttpStatus.OK);
	}
	@RequestMapping("/viewadmins")
	public ResponseEntity<?> listAdmin(){
		return new ResponseEntity<>(adminservice.listAdmin(),HttpStatus.OK);
	}
	
	@GetMapping("/getadmin/{adminid}")
	public ResponseEntity<?> findAdmin(@PathVariable("adminid") String adminid){
		return new ResponseEntity<>(adminservice.findAdmin(adminid),HttpStatus.OK);
	}
	@DeleteMapping("/deleteadmin/{adminid}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("adminid") String adminid){
		return new ResponseEntity<>(adminservice.deleteAdmin(adminid),HttpStatus.OK);
	}
	@RequestMapping("/viewcustomers")
	public ResponseEntity<?> listCustomers(){
		return new ResponseEntity<>(adminservice.listCustomers(),HttpStatus.OK);
	}
	
	@RequestMapping("/getcustomer/{CustomerId}")
	public ResponseEntity<?> findCustomer(@PathVariable("CustomerId") String CustomerId){
		return new ResponseEntity<>(adminservice.findCustomer(CustomerId),HttpStatus.OK);
	}
	@RequestMapping("/viewtravels")
	public ResponseEntity<?> listTravels(){
		return new ResponseEntity<>(adminservice.listTravels(),HttpStatus.OK);
	}
	@PostMapping("/addtravels")
	public ResponseEntity<?> addTravels(@RequestBody Travels t){
		return new ResponseEntity<>(adminservice.addtravels(t),HttpStatus.OK);
	}
	@RequestMapping("/gettravel/{TravelsId}")
	public ResponseEntity<?> findTravels(@PathVariable("TravelsId") int TravelsId){
		return new ResponseEntity<>(adminservice.findtravels(TravelsId),HttpStatus.OK);
	}
	@DeleteMapping("/deletetravel/{TravelsId}")
	public ResponseEntity<?> deleteTravels(@PathVariable("TravelsId") int TravelsId){
		return new ResponseEntity<>(adminservice.deletetravels(TravelsId),HttpStatus.OK);
	}
	@RequestMapping("/viewtpackages")
	public ResponseEntity<?> listTpackages(){
		return new ResponseEntity<>(adminservice.viewtpackages(),HttpStatus.OK);
	}
	@RequestMapping("/gettpackages/{TravelsId}")
	public ResponseEntity<?> findTpackages(@PathVariable("TravelsId") int TravelsId){
		return new ResponseEntity<>(adminservice.findtpackages(TravelsId),HttpStatus.OK);
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logoutAdmin(){
		return new ResponseEntity<>(adminservice.logout(),HttpStatus.OK);	
	}
}
