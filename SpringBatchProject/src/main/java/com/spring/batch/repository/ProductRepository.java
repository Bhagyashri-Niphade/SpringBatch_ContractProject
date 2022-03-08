package com.spring.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Product;

/**
 * This is a repository layer which deals with the database operations related
 * to the 'Product' table.
 * 
 * @author Bhagyashri Niphade
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

	Product getProductByProductCode(String productCode);
}