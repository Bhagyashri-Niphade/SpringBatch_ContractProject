package com.spring.batch.entity;

import java.util.Objects;

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
	
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product)) return false;
        if (!super.equals(object)) return false;
        Product product = (Product) object;
        return getPremium() == product.getPremium() &&
                java.util.Objects.equals(productCode, product.productCode);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), productCode, getPremium());
    }
	
}
