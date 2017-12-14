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
@Table
@Component
public class User1 {
	
	private static final long SerialVersionUID=1l;
	@Id
	private String uid;
	private String uname;
	private String password;
	private String address;
	private String email;
	private String phone;
	private String role="ROLE_USER";
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="role_id")
	private Authentication authentication;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="b_id")
	private Billingaddress billingaddress;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id")
	private Cart cart;
	
	@OneToMany(mappedBy="user1")
	private List<Shippingaddress> shippingaddress;
	
	public User1()
	{
		this.uid="U"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Billingaddress getBillingaddress() {
		return billingaddress;
	}


	public void setBillingaddress(Billingaddress billingaddress) {
		this.billingaddress = billingaddress;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public List<Shippingaddress> getShippingaddress() {
		return shippingaddress;
	}


	public void setShippingaddress(List<Shippingaddress> shippingaddress) {
		this.shippingaddress = shippingaddress;
	}


	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	}
