package com.tourism.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Customer implements Serializable{
@Id
String customerid;
String customername;
String phonenumber;
String address;
String email;
String gender;
int noofperson;
String pass;
public String getCustomerid() {
	return customerid;
}
public void setCustomerid(String customerid) {
	this.customerid = customerid;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getNoofperson() {
	return noofperson;
}
public void setNoofperson(int noofperson) {
	this.noofperson = noofperson;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
@Override
public String toString() {
	return "\n{\ncustomerid=" + customerid + ",\ncustomername=" + customername + ",\nphonenumber=" + phonenumber
			+ ",\naddress=" + address + ",\nemail=" + email + ",\ngender=" + gender + ",\nnoofperson=" + noofperson
			+ ",\npass=" + pass + "\n}";
}
}
