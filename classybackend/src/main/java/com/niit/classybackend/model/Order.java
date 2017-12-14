package com.niit.classybackend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Orders")
@Component

public class Order {
	
@Id
	private String order_no;
	private double grand_total;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="b_id")
	private Billingaddress billingaddress;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="s_id")
	private Shippingaddress shippingaddress;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="uid")
	private User1 user1;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="pid")
	private Pay pay;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<OrderItems> orderItems;
	
	
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public double getGrand_total() {
		return grand_total;
	}
	public void setGrand_total(double grand_total) {
		this.grand_total = grand_total;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Shippingaddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(Shippingaddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Billingaddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(Billingaddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}

	
	
}
