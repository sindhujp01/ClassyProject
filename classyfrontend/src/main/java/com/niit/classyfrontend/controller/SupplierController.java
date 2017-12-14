package com.niit.classyfrontend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.supplier1;
@Controller

public class SupplierController {
	
	@Autowired
	supplier1 supplier1;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	ProductDao productDao;
	
@RequestMapping(value="/addsup", method=RequestMethod.POST)
public ModelAndView addcat(@ModelAttribute("supplier")supplier1 supplier1)
{
	ModelAndView obj=new ModelAndView("redirect:/supplier");
	if(supplierDao.saveupdate(supplier1)==true)
	{
		obj.addObject("msg1","supplier added successfully");
	}
	else
	{
		obj.addObject("msg2","adding supplier failed ");
	}
	
	return obj;
}
@RequestMapping("/editsupplier/{supid}")
public ModelAndView editsupplier(@PathVariable("supid")String supid)
{
	ModelAndView obj=new ModelAndView("supplier");
	supplier1=supplierDao.get(supid);
	List<supplier1> ls=supplierDao.list();
   	obj.addObject("suppliers",ls);
   	obj.addObject("supplier",supplier1);
    	return obj;
}
@RequestMapping("/deletesup/{supid}")
public ModelAndView deletesup(@PathVariable("supid")String supid)
{
	ModelAndView obj=new ModelAndView("redirect:/supplier");
	supplier1=supplierDao.get(supid);
	List<Product> lists=productDao.getProductBySupplier("supplier1");
	if(lists==null||lists.isEmpty())
	{
		supplierDao.delete(supplier1);
		obj.addObject("msg1","supplier deleted successfully");
	}
	else
	{
		for(Product P:lists)
		{
			productDao.delete(P);
			
		}
		supplierDao.delete(supplier1);
		obj.addObject("msg2","supplier and list of product is been deleted");
	}
	return obj;
}
}