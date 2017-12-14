package com.niit.classybackend.model;

import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
@Component
public class Product 
{
	private static final long SerialVersionUID=1l;
	@Id
	private String p_id;
	private String p_name;
	private String p_quantity;
	private int p_price;
	private String p_description;
	
	@Transient
	private MultipartFile pimg;
	public MultipartFile getPimg() {
		return pimg;
	}

	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}


	@ManyToOne
	@JoinColumn(name="cid")
	private Category1 category1;
	
	
	@ManyToOne
	@JoinColumn(name="supid")
	private supplier1 supplier1;
	
	
	public Product()
	{
		this.p_id="P"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Category1 getCategory1() {
		return category1;
	}

	public void setCategory1(Category1 category1) {
		this.category1 = category1;
	}
	
	public supplier1 getSupplier1() {
		return supplier1;
	}


	public void setSupplier1(supplier1 supplier1) {
		this.supplier1 = supplier1;
	}


	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_quantity() {
		return p_quantity;
	}
	public void setP_quantity(String p_quantity) {
		this.p_quantity = p_quantity;
	}
	
	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_description() {
		return p_description;
	}
	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
	
	
}
