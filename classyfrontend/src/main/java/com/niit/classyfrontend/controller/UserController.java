package com.niit.classyfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.User1;

@Controller

public class UserController {
	@Autowired
	User1 user1;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public ModelAndView adduser(@ModelAttribute("user")User1 user1)
	{
		ModelAndView obj=new ModelAndView("redirect:/user");
		if(userDao.saveupdate(user1)==true)
		{
			obj.addObject("msg1","user added successfully");
		}
		else
		{
			obj.addObject("msg2","adding user failed ");
		}
		
		return obj;
	}

}
