package com.wemanity.ecommerce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements  Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codeCustomer;
	private String nameCustomer;
	private String addressCustomer;
	private String phoneNumber;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String nameCustomer, String addressCustomer, String phoneNumber) {
		super();
		this.nameCustomer = nameCustomer;
		this.addressCustomer = addressCustomer;
		this.phoneNumber = phoneNumber;
	}

	public long getCodeCustomer() {
		return codeCustomer;
	}

	public void setCodeCustomer(long codeCustomer) {
		this.codeCustomer = codeCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
