package com.findme.json;

import java.io.Serializable;
import java.util.Date;


public class JAppointment implements Serializable{
	
	private Long id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int capacity;
	private int status;
	
	private JProfessional professional;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public JProfessional getProfessional() {
		return professional;
	}
	public void setProfessional(JProfessional professional) {
		this.professional = professional;
	}
	
}
