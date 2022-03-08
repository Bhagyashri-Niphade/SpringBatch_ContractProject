package com.spring.batch.entity;

import java.util.Objects;

import javax.persistence.*;

/**
 * This is an entity class which represents the 'Contract' table in the
 * database.
 * 
 * @author Bhagyashri Niphade
 */
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


    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Contract)) return false;
        if (!super.equals(object)) return false;
        Contract contract = (Contract) object;
        return getId() == contract.getId() &&
                getClientnumber() == contract.getClientnumber() &&
                getCollectionday() == contract.getCollectionday() &&
                java.util.Objects.equals(getProductCode(), contract.getProductCode()) &&
                java.util.Objects.equals(getStatus(), contract.getStatus());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getClientnumber(), getCollectionday(), getProductCode(), getStatus());
    }
}
