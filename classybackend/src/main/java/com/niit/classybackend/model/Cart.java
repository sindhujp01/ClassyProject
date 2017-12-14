package com.niit.classybackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table
public class Cart 
{
	@Id
	private String c_id;
	private double c_grandtotal=0.0;
	private double c_totalitems=0.0;
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartItem;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="uid")
	private User1 user1;
	
	public List<CartItem> getcartItem() {
		return cartItem;
	}
	public void setcartItem(List<CartItem> cartItem)
	{
		this.cartItem = cartItem;
	}
	public Cart()
	{
		this.c_id="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public double getC_grandtotal() {
		return c_grandtotal;
	}
	public void setC_grandtotal(double c_grandtotal) {
		this.c_grandtotal = c_grandtotal;
	}
	public double getC_totalitems() {
		return c_totalitems;
	}
	public void setC_totalitems(double c_totalitems) {
		this.c_totalitems = c_totalitems;
	}
	
}
