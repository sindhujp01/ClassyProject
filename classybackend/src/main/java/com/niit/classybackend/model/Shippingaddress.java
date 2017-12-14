package com.niit.classybackend.model;

import java.util.List;
import java.util.UUID;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Shippingaddress
{
	private static final long SerialVersionUID=1l;
	@Id
	private String s_id;
	private String s_dno;
	private String s_street;
	private String s_locality;
	private String s_city;
	private String s_state;
	private String s_pincode;
	@ManyToOne
	@JoinColumn(name="uid")
	private User1 user1;
	
	
	public User1 getUser1() {
		return user1;
	}
	public void setUser1(User1 user1) {
		this.user1 = user1;
	}
	public Shippingaddress()
	{
		this.s_id="S"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_dno() {
		return s_dno;
	}
	public void setS_dno(String s_dno) {
		this.s_dno = s_dno;
	}
	public String getS_street() {
		return s_street;
	}
	public void setS_street(String s_street) {
		this.s_street = s_street;
	}
	public String getS_locality() {
		return s_locality;
	}
	public void setS_locality(String s_locality) {
		this.s_locality = s_locality;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getS_pincode() {
		return s_pincode;
	}
	public void setS_pincode(String s_pincode) {
		this.s_pincode = s_pincode;
	}

}
