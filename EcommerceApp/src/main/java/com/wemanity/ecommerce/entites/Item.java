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
	@JoinColumn(name="codeCategory")
	private Category codeCategory;
	@ManyToOne
	@JoinColumn(name="codeBrand")
	private Brand codeBrand;
	
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

	public Category getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(Category codeCategory) {
		this.codeCategory = codeCategory;
	}

	public Brand getCodeBrand() {
		return codeBrand;
	}

	public void setCodeBrand(Brand codeBrand) {
		this.codeBrand = codeBrand;
	}
	
	
}
