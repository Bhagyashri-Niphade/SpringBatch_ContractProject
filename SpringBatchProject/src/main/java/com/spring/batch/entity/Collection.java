package com.spring.batch.entity;

import java.util.Objects;
import javax.persistence.*;

/**
 * This is an entity class which represents the 'Collection' table in the
 * database.
 * 
 * @author Bhagyashri Niphade
 */
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
	
	
	public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Collection)) return false;
        if (!super.equals(object)) return false;
        Collection that = (Collection) object;
        return getId() == that.getId() &&
                getClientnumber() == that.getClientnumber() &&
                getPremium() == that.getPremium() &&
                java.util.Objects.equals(getCollectiondate(), that.getCollectiondate());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getClientnumber(), getCollectiondate(), getPremium());
    }
}
