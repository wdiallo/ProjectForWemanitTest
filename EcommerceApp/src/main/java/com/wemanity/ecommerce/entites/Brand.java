package com.wemanity.ecommerce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeBrand;
	private String nameBrand;
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(String nameMark) {
		super();
		this.nameBrand = nameMark;
	}

	public Long getCodeBrand() {
		return codeBrand;
	}

	public void setCodeBrand(Long codeBrand) {
		this.codeBrand = codeBrand;
	}

	public String getNameBrand() {
		return nameBrand;
	}

	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}
	
	
}
