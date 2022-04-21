package com.tourism.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class BDetails implements Serializable{

	@Id
	int bdid;
	String customername;
	String travelsname;
	String route;
	String startingdate;
	String endingdate;
	int noofperson;
	double totalcost;
	public int getBdid() {
		return bdid;
	}
	public void setBdid(int bdid) {
		this.bdid = bdid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getTravelsname() {
		return travelsname;
	}
	public void setTravelsname(String travelsname) {
		this.travelsname = travelsname;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getStartingdate() {
		return startingdate;
	}
	public void setStartingdate(String startingdate) {
		this.startingdate = startingdate;
	}
	public String getEndingdate() {
		return endingdate;
	}
	public void setEndingdate(String endingdate) {
		this.endingdate = endingdate;
	}
	public int getNoofperson() {
		return noofperson;
	}
	public void setNoofperson(int noofperson) {
		this.noofperson = noofperson;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	@Override
	public String toString() {
		return "\n{\nbdid=" + bdid + ",\ncustomername=" + customername + ",\ntravelsname=" + travelsname + ",\nroute="
				+ route + ",\nstartingdate=" + startingdate + ",\nendingdate=" + endingdate + ",\nnoofperson=" + noofperson
				+ ",\ntotalcost=" + totalcost + "\n}";
	}
}
