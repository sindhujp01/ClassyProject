package com.niit.classybackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;

public class category1Test {
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
		Category1 category=(Category1)context.getBean("category1");
		Product product=(Product)context.getBean("product");//component name in modelclass
		ProductDao productDao=(ProductDao)context.getBean("productDao");//repository and application context
		
		
		category.setCname("Sports");
	    //category.setCid("100");
        categoryDao.saveupdate(category);
        Category1 c=categoryDao.get("C710E19");
   	 List<Product> p=productDao.getProductByCategory(c.getCid());
   	 if(p==null||p.isEmpty())
   	 {
   		 categoryDao.delete(c);
   	 }
   	 else
   		 for(Product P:p)
   		 {
   			 productDao.delete(P);
   		 }
   if(	categoryDao.delete(c))
   {
	   System.out.println("category is deleted"); 
   }
   else
   {
	   System.out.println("category not deleted");
   }





	    //save n update
//	    if(categoryDao.saveupdate(category)==true)
//	    {
//	    	System.out.println("saved");
//	    	
//	    }
//	    else{
//	    	System.out.println("sorry not saved");
//	    	
//	     }
//	    
//	List<Category1> list = categoryDao.list();
//	for(Category1 c:list)
//	{
//		System.out.println(c.getCid());
//		System.out.println(c.getCname());
//		
//	}
//	if(categoryDao.delete("cat123")==true)
//	{
//		System.out.println("delete is successful");
//	}
//	else
//	{
//		System.out.println("sorry");
//	}
//	category=categoryDao.get("100");
//			if(category==null)
//			{
//				System.out.println("item not found");
//			}
//			else
//			{
//				System.out.println(category.getCid());
//				System.out.println(category.getCname());
//				
//			}
				
	
	
 }
}