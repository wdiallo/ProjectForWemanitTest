package com.wemanity.ecommerce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeCat;
	private String nameCat;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String nameCat) {
		super();
		this.nameCat = nameCat;
	}

	public Long getCodeCat() {
		return codeCat;
	}

	public void setCodeCat(Long codeCat) {
		this.codeCat = codeCat;
	}

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	
}
