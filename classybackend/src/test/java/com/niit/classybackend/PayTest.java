package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.classybackend.Dao.PayDao;
import com.niit.classybackend.model.Pay;

public class PayTest 
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		PayDao payDao=(PayDao)context.getBean("payDao");
		Pay pay=(Pay)context.getBean("pay");
		pay.setPaymentmethod("online transcation");
		pay.setPaymentstatus("enabl");
		payDao.saveupdate(pay);

   }
}
