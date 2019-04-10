package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Offers methods for fetching entities using pagination and sorting 
 * Good if dealing with large amount of data.
 * 
 * <p>Provides CRUD functionalities. 
 *
 */
@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car, Long>{
	//Fetch cars 'find'
	List<Car> findByColor(@Param("color") String color);
	List<Car> findByYear(int year);
	
	//Fetch cars 'and' or 'or'
	List<Car> findByBrandAndColor(String name, String color);
	List<Car> findByBrandOrBrand(String name, String colore);
	
	//Fetch cars 'find' and 'sort by'
	List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);
	
	//Sql statements
	//Fetch car by brand using sql
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(String brand);
}
