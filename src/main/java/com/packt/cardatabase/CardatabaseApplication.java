package com.packt.cardatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
	/**
	 * This annotation enable dependency injection
	 * 
	 * The dependency injection allows us to pass dependencies 
	 * objects into class
	 */
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}
	
	//CommandLinerRunner interface allow us to execute additional code
	//before the application has fully started
	@Bean
	CommandLineRunner runner() {
		return args ->{
			//Save some demo data
			/*
			Owner owner1 = new Owner("Toms", "Reiver");
			Owner owner2 = new Owner("John", "Stuart");
			Owner owner3 = new Owner("Jimmy", "Lovin");
			orepository.save(owner1);
			orepository.save(owner2);
			orepository.save(owner3);
			Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White", "SSJ-3002",  2014, 29000, owner1);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
			repository.save(car);
			car = new Car("Renault", "Clio", "Blue", "HJK-1161", 2016, 65490, owner3);
			repository.save(car);*/
			
			//username: user password: jepensedoncjesuis
			//urepository.save(new User("user", "$2a$04$4sgjT667uoyPt68vILzLnOOIHq4ByQsM1UwHEPB3sFqcCyfFFky9.", "USER"));
			//username: admin password: simplepw
			//urepository.save(new User("admin", "$2a$04$R2eY6pfaurH0pt1NRcshKuAzxQjHfiKuOsmWEuuez.SawZdc.eKOu", "ADMIN"));
			//username: lionel password: lionel
			//urepository.save(new User("lionel", "lionel", "ADMIN"));
		};
	}

}
