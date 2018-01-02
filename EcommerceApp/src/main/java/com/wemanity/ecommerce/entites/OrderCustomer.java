package com.wemanity.ecommerce.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderCustomer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeOrder;
	private Date dateOrder;
	private boolean stateOrder;
	@ManyToOne
	@JoinColumn(name="customerOrder")
	private Customer customerOrder;
	
	public OrderCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderCustomer(Date dateOrder, boolean stateOrder) {
		super();
		this.dateOrder = dateOrder;
		this.stateOrder = stateOrder;
	}
	public Long getCodeOrder() {
		return codeOrder;
	}
	public void setCodeOrder(Long codeOrder) {
		this.codeOrder = codeOrder;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public boolean isStateOrder() {
		return stateOrder;
	}
	public void setStateOrder(boolean stateOrder) {
		this.stateOrder = stateOrder;
	}
	public Customer getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	
}
