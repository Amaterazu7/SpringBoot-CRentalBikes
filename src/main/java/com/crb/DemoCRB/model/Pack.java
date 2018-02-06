package com.crb.DemoCRB.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pack {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	private Integer price;
	private String number;
	private String profile;
	
	public Pack(){} 
	
	public Pack(long id, Integer price, String number, String profile){
		this.id = id;
		this.number = number;
		this.price = price;
		this.profile = profile;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pack))
			return false;
		Pack other = (Pack) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", number=" + number + ", price=" + price +", profile=" + profile +"]";
	}
	

}
