package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Contract;

//repository for contract table with integer primary key
@Repository
public interface Contarctrepository extends JpaRepository<Contract, Integer>{

	
}
