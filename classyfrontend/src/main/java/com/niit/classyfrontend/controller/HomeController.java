package com.niit.classyfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.Billingaddress;
import com.niit.classybackend.model.Category1;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.User1;
import com.niit.classybackend.model.supplier1;

@Controller
public class HomeController 
{
	@Autowired
	Category1 category1;
	@Autowired 
	CategoryDao categoryDao;
    @Autowired
    supplier1 supplier1;
    @Autowired
    SupplierDao supplierDao;
    @Autowired
    Product product;
    @Autowired
    ProductDao productDao;
    @Autowired
    User1 user;
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String homepage()
    {
    	return "home";
    }
    @RequestMapping("/about")
    public String about()
    {
    	return "about";
    }
    @RequestMapping("/contact")
    public String contact()
    {
    	return "contact";
    }
//    @RequestMapping("/login")
//    public String login()
//    {
//    	return "login";
//    }
    @RequestMapping("/bs")
    public String bs()
    {
    	return "bs";
    }
    @RequestMapping("/pay")
    public String pay()
    {
    	return "pay";
    }
    
    
    @RequestMapping("/table")
    public String table()
    {
    	return "table";
    }
    @RequestMapping("/signup")
    public String signup()
    {
    	return "signup";
    }
    @RequestMapping("/summer")
    public String summer()
    {
    	return "summer";
    }
    @RequestMapping("/indian")
    public String indian()
    {
    	return "indian";
    }
    @RequestMapping("/modern")
    public String modern()
    {
    	return "modern";
    }
    
    @RequestMapping("/home")
    public ModelAndView home()
    {
    	return new ModelAndView("home");
    }
    @RequestMapping("/category")
    public ModelAndView category()
    {
    	ModelAndView obj=new ModelAndView("category");
   	obj.addObject("category", new Category1());
   	List<Category1> lc=categoryDao.list();
   	obj.addObject("categories",lc);
    	return obj;
    }
    @RequestMapping("/supplier")
    public ModelAndView supplier()
    {
    	ModelAndView obj=new ModelAndView("supplier");
   	obj.addObject("supplier",supplier1);
   	List<supplier1> ls=supplierDao.list();
   	obj.addObject("suppliers",ls);
    	return obj;
    }
    @RequestMapping("/product")
    public ModelAndView product()
    {
    	ModelAndView obj=new ModelAndView("products");
   	obj.addObject("prod", new Product());
   	List<Product> lp=productDao.list();
   	obj.addObject("products",lp);
    	return obj;
    }
    @RequestMapping("/user")
    public ModelAndView user()
    {
    	ModelAndView obj=new ModelAndView("user");
   	obj.addObject("user",user);
   	Billingaddress b=new Billingaddress();
   	user.setBillingaddress(b);
   	List<User1> lu=userDao.list();
   	obj.addObject("supplieres",lu);
    	return obj;
    }
    
}
