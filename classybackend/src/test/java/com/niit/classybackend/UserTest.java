package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.BillingaddressDao;

import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.Billingaddress;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.Shippingaddress;
import com.niit.classybackend.model.User1;


public class UserTest {
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		UserDao userDao=(UserDao)context.getBean("userDao");
		User1 user=(User1)context.getBean("user1");
		
		Billingaddress b=(Billingaddress)context.getBean("billingaddress");
		Cart c=(Cart)context.getBean("cart");
		
		
		b.setB_city("bangalore");
		b.setB_dno("1");
		b.setB_locality("bang");
		b.setB_pincode(56060);
		b.setB_state("karnataka");
		b.setB_street("6");
		user.setUname("sin");
		user.setPassword("12ab");
		user.setAddress("bangalore");
		user.setEmail("sindhujp01@gmail.com");
		user.setPhone("905367918");
//		c.setC_grandtotal("10001");
//		c.setC_totalitems("15");
			
		//user.setBillingaddress(b);
	   
	   // user.setCart(c);
	    userDao.saveupdate(user);
	}
	

}
