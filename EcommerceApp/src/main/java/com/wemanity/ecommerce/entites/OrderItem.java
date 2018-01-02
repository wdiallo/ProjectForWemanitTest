package com.wemanity.ecommerce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"customerOrder", "itemOrder"}))
public class OrderItem implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeOrdItem;
	private int quantity;
	private double priceUnit;
	@ManyToOne
	@JoinColumn(name="customerOrder")
	private OrderCustomer customerOrder;
	@ManyToOne
	@JoinColumn(name="itemOrder")
	private Item itemOrder;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int quantity, double priceUnit) {
		super();
		this.quantity = quantity;
		this.priceUnit = priceUnit;
	}

	public Long getCodeOrdItem() {
		return codeOrdItem;
	}

	public void setCodeOrdItem(Long codeOrdItem) {
		this.codeOrdItem = codeOrdItem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}

	public OrderCustomer getOrderCustomer() {
		return customerOrder;
	}

	public void setOrderCustomer(OrderCustomer orderCustomer) {
		this.customerOrder = orderCustomer;
	}

	public Item getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(Item itemOrder) {
		this.itemOrder = itemOrder;
	}
	
	
}
