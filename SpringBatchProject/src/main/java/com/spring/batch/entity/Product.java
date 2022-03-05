package com.spring.batch.entity;

import javax.persistence.*;
import org.springframework.stereotype.Component;

//table to map productcode and premium of product
@Entity
@Component
@Table(name = "product")
public class Product {
	
	@Id
	@Column(nullable = false, unique = true)
	private String productCode;
	
	private int premium;
	
	//default constructor
	public Product() {
	}
	

	public String getProductcode() {
		return productCode;
	}
	public void setProductcode(String productCode) {
		this.productCode = productCode;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	
}
