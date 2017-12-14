package com.niit.classybackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.supplier1;

public class supplier1Test {
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		supplier1 supplier=(supplier1)context.getBean("supplier1");
		Product product=(Product)context.getBean("product");//component name in modelclass
		ProductDao productDao=(ProductDao)context.getBean("productDao");

	supplier.setSupname("silk");
	supplier.setAddress("mysore");
	supplierDao.saveupdate(supplier);
	supplier1 s=supplierDao.get("SE499EA");
   	 List<Product> p=productDao.getProductByCategory(s.getSupid());
   	 if(p==null||p.isEmpty())
   	 {
   		supplierDao.delete(s);
   	 }
   	 else
   		 for(Product P:p)
   		 {
   			 productDao.delete(P);
   		 }
   if(	supplierDao.delete(s))
   {
	   System.out.println("category is deleted"); 
   }
   else
   {
	   System.out.println("category not deleted");
   }


//		
//		
//		supplier.setSupname("sindhu");
//	    supplier.setSupid("100");
//	    supplier.setAddress("");
//	    
//	    //save n update
//	    if(supplierDao.saveupdate(supplier)==true)
//	    {
//	    	System.out.println("saved");
//	    	
//	    }
//	    else{
//	    	System.out.println("sorry not saved");
//	    	
//	     }
//	    
//	 

	}
}
