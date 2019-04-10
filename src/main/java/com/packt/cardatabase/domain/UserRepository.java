package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Offers methods for fetching entities using pagination and sorting 
 * Good if dealing with large amount of data.
 * 
 * <p>Provides CRUD functionalities. 
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
}
