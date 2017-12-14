package com.niit.classybackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javassist.SerialVersionUID;

@Entity
@Table
@Component
public class Category1
{
	private static final long SerialVersionUID=1l;
	@Id
	private String cid;
	private String cname;
	@OneToMany(mappedBy="category1")
	private List<Product> product;
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Category1()
	{
		this.cid="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getCid()
	{
		return cid;
	}
	public void setCid(String cid)
	{
		this.cid = cid;
	}
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
	}
	

}
