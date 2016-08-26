package com.findme.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Appointment implements java.io.Serializable {

	@ManyToOne
	private Professional owner;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.appointment")
	private Set<VisitorAppointment> visitorAppointment = new HashSet<VisitorAppointment>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appid;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date appStartTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date appEndTime;
	private int capacity;
	private int status;

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
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

	public Date getAppStartTime() {
		return appStartTime;
	}

	public void setAppStartTime(Date appStartTime) {
		this.appStartTime = appStartTime;
	}

	public Date getAppEndTime() {
		return appEndTime;
	}

	public void setAppEndTime(Date appEndTime) {
		this.appEndTime = appEndTime;
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

	public Professional getOwner() {
		return owner;
	}

	public void setOwner(Professional owner) {
		this.owner = owner;
	}

	public Set<VisitorAppointment> getVisitorAppointment() {
		return visitorAppointment;
	}

	public void setVisitorAppointment(Set<VisitorAppointment> visitorAppointment) {
		this.visitorAppointment = visitorAppointment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appEndTime == null) ? 0 : appEndTime.hashCode());
		result = prime * result + ((appStartTime == null) ? 0 : appStartTime.hashCode());
		result = prime * result + appid;
		result = prime * result + capacity;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + status;
		result = prime * result + ((visitorAppointment == null) ? 0 : visitorAppointment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (appEndTime == null) {
			if (other.appEndTime != null)
				return false;
		} else if (!appEndTime.equals(other.appEndTime))
			return false;
		if (appStartTime == null) {
			if (other.appStartTime != null)
				return false;
		} else if (!appStartTime.equals(other.appStartTime))
			return false;
		if (appid != other.appid)
			return false;
		if (capacity != other.capacity)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (status != other.status)
			return false;
		if (visitorAppointment == null) {
			if (other.visitorAppointment != null)
				return false;
		} else if (!visitorAppointment.equals(other.visitorAppointment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [owner=" + owner + ", visitorAppointment=" + visitorAppointment + ", appid=" + appid
				+ ", name=" + name + ", description=" + description + ", appStartTime=" + appStartTime + ", appEndTime="
				+ appEndTime + ", capacity=" + capacity + ", status=" + status + "]";
	}

}
