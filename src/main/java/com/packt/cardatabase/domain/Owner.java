package com.packt.cardatabase.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * This class is considered as a java bean class because:
 * <ul>
 * 		<li>It has a no argument constructor</li>
 * 		<li>It is serializable</li>
 * 		<li>It has getters and setters</li>
 * </ul>
 *
 */
@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ownerid;
	private String firstname, lastname;
	
	//No need to specify FetchType.LAZY because it's default
	//Cascading only makes sense from parent to child association
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Car> cars;
	
	public Owner() {
	}
	
	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	
}
