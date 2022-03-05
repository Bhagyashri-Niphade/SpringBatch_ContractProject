package com.spring.batch.entity;

import javax.persistence.*;

//Input table
@Entity
@Table(name = "contract")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int clientnumber;
	private int collectionday;
	private String productCode;
	private String status;

	public Contract() {
		super();
		
	}

	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientnumber() {
		return clientnumber;
	}

	public void setClientnumber(int clientnumber) {
		this.clientnumber = clientnumber;
	}

	public int getCollectionday() {
		return collectionday;
	}

	public void setCollectionday(int collectionday) {
		this.collectionday = collectionday;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
