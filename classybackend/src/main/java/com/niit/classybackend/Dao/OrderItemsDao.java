package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Order;
import com.niit.classybackend.model.OrderItems;

public interface OrderItemsDao
{
	public boolean saveupdate(OrderItems orderitems);
	public boolean delete(OrderItems orderitems);
	public OrderItems get(String orderitem_no);
	public List<OrderItems>getOrderItemsByOrder(String order_no);
	public List<OrderItems> list();

}
