package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.classybackend.Dao.OrderDao;
import com.niit.classybackend.DaoImpl.OrderDaoImpl;
import com.niit.classybackend.model.Order;

public class OrderTest
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		OrderDao orderDao=(OrderDao)context.getBean("orderDao");
		Order order=(Order)context.getBean("order");
		order.setOrder_no("1");
		order.setGrand_total(1000);
        orderDao.saveupdate(order);

}
}