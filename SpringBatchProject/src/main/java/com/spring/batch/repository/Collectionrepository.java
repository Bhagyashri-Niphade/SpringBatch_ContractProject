package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Collection;

//repository for collection table with integer type primary key
@Repository
public interface Collectionrepository extends JpaRepository<Collection, Integer>{

}
