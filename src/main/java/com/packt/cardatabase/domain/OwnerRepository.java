package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Offers methods for fetching entities using pagination and sorting 
 * Good if dealing with large amount of data.
 * 
 * <p>Provides CRUD functionalities. 
 *
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	List<Owner> findByFirstname(String firstname);
	List<Owner> findByLastname(String lastname);
}
