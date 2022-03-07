package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Product;

//repository for product table with String type primary key
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	//method to retrive product object using productcode
	Product getProductByProductCode(String productCode);
}