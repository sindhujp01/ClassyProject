package com.niit.classybackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String orderitem_id;
	private String p_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_no")
	private Order order;
	
	public OrderItems()
	{
		this.orderitem_id="ORD_ID"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(String orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	

}
