package com.niit.classyfrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.User1;
@Controller
public class LoginController {

		@Autowired
		User1 user;
		@Autowired
		UserDao userDao;
		
		@RequestMapping("/login")
		public String login(){
		return "login";
		}
		
		@RequestMapping(value="/j_spring_security_check")
	    public String processRegistration(@RequestParam("j_username")String email,@RequestParam("j_password")String password,
	   		 Model model,HttpSession session )
	    {
			System.out.println("sdfads");
			
			User1 u=userDao.isvalid(email, password);
			if(u==null)
			{
				System.out.println("kjhdfskj");
				 model.addAttribute("msg","Invalid user name and password");
		    		return "redirect:/login"; 
		    }
			else 
			{
				 session.setAttribute("user", u);
	    		 session.setAttribute("name",u.getUname());
//	    		 session.setAttribute("items",u.getCart().getcartItem());
	    		 return "redirect:/"; 
			}
			
			
		}
		
		@RequestMapping(value= "/j_spring_security_logout")
		public String logout(HttpServletRequest request, HttpSession Session, Model model){
			Session.invalidate();
			Session =request.getSession(true);
			model.addAttribute("logout", "logout successful");
			return "redirect:/";
		}
		
	}



