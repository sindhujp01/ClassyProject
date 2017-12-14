package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.BillingaddressDao;

import com.niit.classybackend.model.Billingaddress;

public class BillingaddressTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		BillingaddressDao billingaddressDao=(BillingaddressDao)context.getBean("billingaddressDao");
		Billingaddress billingaddress=(Billingaddress)context.getBean("billingaddress");
		
		
		billingaddress.setB_dno("1");
		billingaddress.setB_street("6");
		billingaddress.setB_city("bangalore");
		billingaddress.setB_state("karnataka");
		billingaddress.setB_locality("bang");
		billingaddress.setB_pincode(56060);
		
		billingaddressDao.saveupdate(billingaddress);

}
}
