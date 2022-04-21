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

import com.tourism.model.TPackages;
import com.tourism.model.Travels;
import com.tourism.service.TravelsService;

@RestController
@RequestMapping("/Travels")
public class TravelsController {

	@Autowired
	TravelsService travelsservice;
	@RequestMapping("/travelstest")
	public String test() {
		return "Test Travels Controller";
	}
	@GetMapping("/login")
	public ResponseEntity<?> logintravels(@RequestBody Travels t){
		return new ResponseEntity<>(travelsservice.login(t),HttpStatus.OK);
	}
	@PutMapping("/updatetravel")
	public ResponseEntity<?> updateTravels(){
		return new ResponseEntity<>(travelsservice.updatetravels(),HttpStatus.OK);
	}
	@RequestMapping("/viewtpackages")
	public ResponseEntity<?> listTpackages(){
		return new ResponseEntity<>(travelsservice.listtpackages(),HttpStatus.OK);
	}
	@RequestMapping("/gettpackage/{tpid}")
	public ResponseEntity<?> findTpackages(@PathVariable("tpid") int tpid){
		return new ResponseEntity<>(travelsservice.findtpackages(tpid),HttpStatus.OK);
	}
	@PostMapping("/addtpackage")
	public ResponseEntity<?> saveTpackage(@RequestBody TPackages t){
		return new ResponseEntity<>(travelsservice.addtpackage(t),HttpStatus.OK);
	}
	@PutMapping("/updatetpackage/{tpid}")
	public ResponseEntity<?> updateTPackages(@PathVariable("tpid") int tpid){
		return new ResponseEntity<>(travelsservice.updatetpackage(tpid),HttpStatus.OK);
	}
	@DeleteMapping("/deletetpackage/{tpid}")
	public ResponseEntity<?> deleteTPackages(@PathVariable("tpid") int tpid){
		return new ResponseEntity<>(travelsservice.deletepackage(tpid),HttpStatus.OK);
	}
	@RequestMapping("/viewbookdetails")
	public ResponseEntity<?> listBDetails(){
		return new ResponseEntity<>(travelsservice.viewbookdetails(),HttpStatus.OK);
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logoutAdmin(){
		return new ResponseEntity<>(travelsservice.logout(),HttpStatus.OK);	
	}
}
