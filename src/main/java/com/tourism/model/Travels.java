package com.tourism.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Travels implements Serializable{
@Id
int travelsid;
String travelsname;
String phonenumber;
String address;
String email;
String pass;
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public int getTravelsid() {
	return travelsid;
}
public void setTravelsid(int travelsid) {
	this.travelsid = travelsid;
}
public String getTravelsname() {
	return travelsname;
}
public void setTravelsname(String travelsname) {
	this.travelsname = travelsname;
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
@Override
public String toString() {
	return "\n{\ntravelsid=" + travelsid + ",\ntravelsname=" + travelsname + ",\nphonenumber=" + phonenumber
			+ ",\naddress=" + address + ",\nemail=" + email + "\n}";
}
}
