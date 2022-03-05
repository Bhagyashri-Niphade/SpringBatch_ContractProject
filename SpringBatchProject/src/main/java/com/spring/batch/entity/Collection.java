package com.spring.batch.entity;

import javax.persistence.*;


//Output table
@Entity
@Table(name = "collection")
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int clientnumber;
	private String collectiondate;
	private int premium;
	
	public Collection() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollectiondate() {
		return collectiondate;
	}
	public void setCollectiondate(String date) {
		this.collectiondate = date;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	public int getClientnumber() {
		return clientnumber;
	}

	public void setClientnumber(int clientnumber) {
		this.clientnumber = clientnumber;
	}
}
