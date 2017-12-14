package com.niit.classybackend;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.CartDao;
import com.niit.classybackend.Dao.CartItemDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.CartItem;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.User1;

public class CartTest {
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		Cart cart=(Cart)context.getBean("cart");
		Product product=(Product)context.getBean("product");//component name in modelclass
		ProductDao productDao=(ProductDao)context.getBean("productDao");//repository and application context
		UserDao userDao=(UserDao)context.getBean("userDao");
		User1 user=(User1)context.getBean("user1");
		CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		CartItem cartItem=(CartItem)context.getBean("cartItem");
		
		user=userDao.get("UDD6FEE");
		
		//cart=user.getCart();		
   	 	   	 if(cart.getC_id()==null)
   	  	 {
	   		 System.out.println("data is not existing");
	   	 }
	   	 
   	 	   	 else
	   {
		   System.out.println("data exist");
	   }
	}
	}
