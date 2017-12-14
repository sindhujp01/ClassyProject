package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.CartDao;
import com.niit.classybackend.Dao.CartItemDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.CartItem;
import com.niit.classybackend.model.Product;

public class CartItemTest {
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		CartItem cartItem=(CartItem)context.getBean("cartItem");
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		Cart cart=(Cart)context.getBean("cart");
		cart=cartDao.get("CA63E62");
	
		Product product=(Product)context.getBean("product");
		product.setP_description("adscd");
		product.setP_name("kurthi");
		product.setP_price(900);
		product.setP_quantity("2");
		cartItem.setP(product);
		cartItem.setCart(cart);
		cartItemDao.saveupdate(cartItem);
		
}
}