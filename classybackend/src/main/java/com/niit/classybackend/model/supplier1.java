package com.niit.classybackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class supplier1 {
	private static final long SerialVersionUID=1l;
	@Id
	private String supid;
	private String supname;
	private String address;
	@OneToMany(mappedBy="supplier1")
	private List<Product> product;
	
	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public supplier1()
	{
		this.supid="S"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	
	public String getSupid() {
		return supid;
	}
	public void setSupid(String supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
