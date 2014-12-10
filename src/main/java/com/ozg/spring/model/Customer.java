package com.ozg.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author ozgur tas
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Version
	@Column(name="version")
	private int version = 0;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_created")
	private Date dateCreated;

	@Column(name="last_update_date")
	private Date lastUpdateDate;

	@Column(name="note")
	private String note;
	
	@Column(name="name")
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", note="+note+", date created="+dateCreated + ", version="+version+", last update Date:"+lastUpdateDate;
	}

	public int getVersion() {
	    return version;
	}

	public void setVersion(int version) {
	    this.version = version;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public Date getDateCreated() {
	    return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
	    this.dateCreated = dateCreated;
	}

	public Date getLastUpdateDate() {
	    return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
	    this.lastUpdateDate = lastUpdateDate;
	}

	public String getNote() {
	    return note;
	}

	public void setNote(String note) {
	    this.note = note;
	}
}
