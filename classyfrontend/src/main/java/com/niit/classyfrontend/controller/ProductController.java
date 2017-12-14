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
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;
import com.niit.fileinput.Fileinput;
@Controller

public class ProductController {
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	String path="c:\\Users\\vishwanath m\\workspace2\\classyfrontend\\src\\main\\webapp\\resources\\images\\";
	@RequestMapping(value="/addpro", method=RequestMethod.POST)
	public ModelAndView addpro(@ModelAttribute("prod")Product product)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		if(productDao.saveupdate(product)==true)
		{
			Fileinput.upload(path, product.getPimg(), product.getP_id()+".jpg");
			obj.addObject("msg1","product added successfully");
		}
		else
		{
			obj.addObject("msg2","adding product failed ");
		}
		
		return obj;
	}
	@RequestMapping("/editproduct/{p_id}")
	public ModelAndView editproduct(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("products");
		product=productDao.get(p_id);
		List<Product> lp=productDao.list();
	   	obj.addObject("products",lp);
	   	obj.addObject("prod",product);
	    	return obj;
	}
	@RequestMapping("/deleteprod/{p_id}")
	public ModelAndView deleteproduct(@PathVariable("p_id")String p_id)
	{
		ModelAndView obj=new ModelAndView("redirect:/product");
		product=productDao.get(p_id);
		if(productDao.delete(product)==true)
		{
			obj.addObject("msg1","product deleted successfully");
		}
		else
		{
			obj.addObject("msg2","product deleted");
		}
		
		return obj;
	}
}
