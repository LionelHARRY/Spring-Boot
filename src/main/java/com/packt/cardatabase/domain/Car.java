package com.packt.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String brand, model, color, registerNumber;
	int year, price;
	
	//Owners can have many cars
	//LAZY is the default value for ToOne
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "owner")
	
	private Owner owner;

	public Car() {
		
	}
	
	public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
