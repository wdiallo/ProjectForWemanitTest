package com.wemanity.ecommerce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeItem;
	private String nameItem;
	private double priceItem;
	@ManyToOne
	@JoinColumn(name="categoryItem")
	private Category categoryItem;
	@ManyToOne
	@JoinColumn(name="brandItem")
	private Brand brandItem;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String nameItem, double priceItem) {
		super();
		this.nameItem = nameItem;
		this.priceItem = priceItem;
	}

	public Long getCodeItem() {
		return codeItem;
	}

	public void setCodeItem(Long codeItem) {
		this.codeItem = codeItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public double getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}

	public Category getCategoryItem() {
		return categoryItem;
	}

	public void setCodeCategory(Category categoryItem) {
		this.categoryItem = categoryItem;
	}

	public Brand getBrandItem() {
		return brandItem;
	}

	public void setBrandItem(Brand brandItem) {
		this.brandItem = brandItem;
	}
	
	
}
