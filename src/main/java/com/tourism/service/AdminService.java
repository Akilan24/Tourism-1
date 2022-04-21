package com.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.model.Admin;
import com.tourism.model.Travels;

@Service
public interface AdminService {

	void saveAdmin(Admin a);
	List<Admin> fetchAdminList();
	Admin updateAdmin(Admin a,String adminid);
	Admin deleteAdminById(String adminid);
	Admin getAdminById(String adminid);
	String registerAdmin(Admin a);
	String loginAdmin(Admin a);
	String viewAdmin();
	String updateAdmin(Admin a);
	String listAdmin();
	String findAdmin(String adminid);
	String deleteAdmin(String adminid);
	String listCustomers();
	String findCustomer(String customerid);
	String listTravels();
	String addtravels(Travels t);
	String findtravels(int travels);
	String deletetravels(int travelsid);
	String viewtpackages();
	String findtpackages(int travelsid);
	String logout();
          
}
