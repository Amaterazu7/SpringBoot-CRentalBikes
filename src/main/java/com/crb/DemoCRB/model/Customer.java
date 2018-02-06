package com.crb.DemoCRB.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	private String name;
	private Integer dni;
	@ManyToOne
	private Pack pack;
	private Integer sumBikes;
	private boolean benefits;
	private Integer discount;
	private	Integer price;
	private Date startDate;
	
	public Customer(){}
	
	public Customer(long id, String name, Integer dni, Pack pack, Integer sumBikes, boolean benefits, Integer discount, Integer price, Date startDate){
		this.id = id;
		this.name = name;
		this.dni = dni;
		this.pack = pack;
		this.sumBikes = sumBikes;
		this.benefits = benefits;
		this.discount = discount;
		this.price = price;
		this.startDate = startDate;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	
	public Integer getSumBikes() {
		return sumBikes;
	}
	public void setSumBikes(Integer sumBikes) {
		this.sumBikes = sumBikes;
	}

	public boolean isBenefits() {
		return benefits;
	}
	public void setBenefits(boolean benefits) {
		this.benefits = benefits;
	}

	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	} 
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", dni=" + dni
				+ ", pack=" + pack +", sumBikes=" + sumBikes + ", benefits=" + benefits
				+ ", discount=" + discount +", price=" + price +", startDate=" + startDate +"]";
	}
	

}
