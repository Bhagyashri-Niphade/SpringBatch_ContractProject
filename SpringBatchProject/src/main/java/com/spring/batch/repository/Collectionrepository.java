package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.batch.entity.Collection;

/**
 * This is a repository layer which deals with the database operations related
 * to the 'Collection' table.
 * 
 * @author Bhagyashri Niphade
 */
@Repository
public interface Collectionrepository extends JpaRepository<Collection, Integer>{

}
