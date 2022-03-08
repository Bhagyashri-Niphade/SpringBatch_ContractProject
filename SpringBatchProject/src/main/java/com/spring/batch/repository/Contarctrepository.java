package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Contract;

/**
 * This is a repository layer which deals with the database operations related
 * to the 'Contract' table.
 * 
 * @author Bhagyashri Niphade
 */
@Repository
public interface Contarctrepository extends JpaRepository<Contract, Integer>{

}
