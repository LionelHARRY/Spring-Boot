package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

/**
 * 
 * Handles Http requests
 *
 */
@RestController
public class CarController {
	@Autowired
	private CarRepository repository;
	
	/**
	 * Endpoint to where the method is mapped to.
	 * By default handles HTTP methods(GET, PUT, POST, etc...)
	 * Iterable allow the object to target the "foreach" statement
	 */
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		return repository.findAll();
	}
}
