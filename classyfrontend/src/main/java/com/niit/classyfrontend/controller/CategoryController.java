package com.niit.classyfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;


@Controller
public class CategoryController 
{    
@Autowired
Category1 category1;
@Autowired
CategoryDao categoryDao;
@Autowired
ProductDao productDao;

@RequestMapping(value="/addcat", method=RequestMethod.POST)
public ModelAndView addcat(@ModelAttribute("category")Category1 category1)
{
	ModelAndView obj=new ModelAndView("redirect:/category");
	if(categoryDao.saveupdate(category1)==true)
	{
		obj.addObject("msg1","category added successfully");
	}
	else
	{
		obj.addObject("msg2","adding category failed ");
	}
	
	return obj;
}
@RequestMapping("/editcategory/{cid}")
public ModelAndView editcat(@PathVariable("cid")String cid)
{
	ModelAndView obj=new ModelAndView("category");
	category1=categoryDao.get(cid);
	List<Category1> lc=categoryDao.list();
   	obj.addObject("categories",lc);
   	obj.addObject("category",category1);
    	return obj;
}

@RequestMapping("/deletecat/{cid}")
public ModelAndView deletecat(@PathVariable("cid")String cid)
{
	ModelAndView obj=new ModelAndView("redirect:/category");
	category1=categoryDao.get(cid);
	List<Product> lists=productDao.getProductByCategory("category");
	if(lists==null||lists.isEmpty())
	{
		categoryDao.delete(category1);
		obj.addObject("msg1","category deleted successfully");
	}
	else
	{
		for(Product P:lists)
		{
			productDao.delete(P);
			
		}
		categoryDao.delete(category1);
		obj.addObject("msg2","category and list of product is been deleted");
	}
	return obj;
	
}}






	
	
