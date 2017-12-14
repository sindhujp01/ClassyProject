package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.supplier1;

public class ProductTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		Product product=(Product)context.getBean("product");
		Category1 c=(Category1)context.getBean("category1");
		supplier1 s=(supplier1)context.getBean("supplier1");
		CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		c=categoryDao.get("C9CD63C");
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		s=supplierDao.get("SEBF9CB");

	product.setP_name("sin");
	product.setP_price(2000);
	product.setP_quantity("5");
	product.setP_description("bsfg");
    product.setCategory1(c);
    product.setSupplier1(s);
    productDao.saveupdate(product);
//    if(productDao.delete("PD32C6D")==true)
//    	{
//    		System.out.println("delete is successful");
//    	}
//    	else
//    	{
//    		System.out.println("sorry");
//    	}
    

	}

}
