package com.tourism.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class TPackages implements Serializable{
	@Id
	int tpid;
	String route;
	String startingdate;
	String endingdate;
	double budgetperperson;
	int duration;
	int travelsid;
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
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
	public double getBudgetperperson() {
		return budgetperperson;
	}
	public void setBudgetperperson(double budgetperperson) {
		this.budgetperperson = budgetperperson;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTravelsid() {
		return travelsid;
	}
	public void setTravelsid(int travelsid) {
		this.travelsid = travelsid;
	}
	@Override
	public String toString() {
		return "\n{\ntpid=" + tpid + ",\nroute=" + route + ",\nstartingdate=" + startingdate + ",\nendingdate="
				+ endingdate + ",\nbudgetperperson=" + budgetperperson + ",\nduration=" + duration + ",\ntravelsid="
				+ travelsid + "\n}";
	}
}
