package com.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.model.TPackages;
import com.tourism.model.Travels;

@Service
public interface TravelsService {

	void saveTravels(Travels t);
	List<Travels> fetchTravelsList();
	Travels updateTravels(Travels t,int TravelsId);
	Travels deleteTravelsById(int TravelsId);
	Travels getTravelsById(int TravelsId);
	String login(Travels t);
	String updatetravels();
	String listtpackages();
	String findtpackages(int tpid);
	String addtpackage(TPackages t);
	String updatetpackage(int tpid);
	String deletepackage(int tpid);
	String viewbookdetails();
	String logout();
}
