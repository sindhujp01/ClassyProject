package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.ShippingaddressDao;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.Shippingaddress;
import com.niit.classybackend.model.User1;


public class ShippingaddressTest {
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		ShippingaddressDao shippingaddressDao=(ShippingaddressDao)context.getBean("shippingaddressDao");
		Shippingaddress shippingaddress=(Shippingaddress)context.getBean("shippingaddress");
		
       
		 User1 u=(User1)context.getBean("user1");
        UserDao userDao=(UserDao)context.getBean("userDao");
       
        u=userDao.get("P81FE27");
		

		shippingaddress.setS_city("bangalore");
		shippingaddress.setS_dno("12");
		shippingaddress.setS_locality("bang");
		shippingaddress.setS_pincode("56060");
		shippingaddress.setS_state("karnataka");
		shippingaddress.setS_street("6th main");
		
		shippingaddressDao.saveupdate(shippingaddress);
		 shippingaddress.setUser1(u);
		 }
}