package com.niit.classybackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class CartItem {
	private static final long SerialVersionUID=1l;
	@Id
	private String c_itemid;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="p_id")
	private Product p;
	@ManyToOne
	@JoinColumn(name="c_id")
	private Cart cart;
	private float price;
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartItem()
	{
		this.c_itemid="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public String getC_itemid() {
		return c_itemid;
	}
	public void setC_itemid(String c_itemid) {
		this.c_itemid = c_itemid;
	}

}
