package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Order;



public interface OrderDao {
	public boolean saveupdate(Order order);
	public boolean delete(Order order);
	public Order get(String order_no);
	public List<Order> list();

}
