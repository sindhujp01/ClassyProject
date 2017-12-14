package com.niit.classyfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.classybackend.Dao.BillingaddressDao;
import com.niit.classybackend.Dao.CardDao;
import com.niit.classybackend.Dao.CartDao;
import com.niit.classybackend.Dao.CartItemDao;
import com.niit.classybackend.Dao.OrderDao;
import com.niit.classybackend.Dao.OrderItemsDao;
import com.niit.classybackend.Dao.PayDao;
import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.Dao.ShippingaddressDao;
import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.Billingaddress;
import com.niit.classybackend.model.Card;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.CartItem;
import com.niit.classybackend.model.Order;
import com.niit.classybackend.model.OrderItems;
import com.niit.classybackend.model.Pay;
import com.niit.classybackend.model.Product;
import com.niit.classybackend.model.Shippingaddress;
import com.niit.classybackend.model.User1;
import com.niit.classyfrontend.otp.Otpganarater;
@Controller
public class OrderController {
	
		@Autowired
		Cart cart;
		@Autowired
		CartDao cartDao;
		@Autowired
		CartItem cartItem;
		@Autowired
		CartItemDao cartItemDao;
		@Autowired
		Card card;
		@Autowired
		CardDao cardDao;
		@Autowired
		Billingaddress billingaddress;
		@Autowired
		BillingaddressDao billingaddressDao;
		@Autowired
		Shippingaddress shippingaddress;
		@Autowired
		ShippingaddressDao shippingaddressDao;
		@Autowired
		Pay pay;
		@Autowired
		PayDao payDao;
		@Autowired
		Order order;
		@Autowired
		OrderDao orderDao;
		@Autowired
		OrderItems orderItems;
		@Autowired
		OrderItemsDao orderItemsDao;
		@Autowired
		Product product;
		@Autowired
		ProductDao productDao;
		@Autowired
		User1 user1;
		@Autowired
		UserDao userDao;
		@Autowired
		List<CartItem> cartItems;
		
		@Autowired
	    private JavaMailSender mailSender;
		
		String o;
		
		@RequestMapping("/Buyall")
		public String orderall(Model model,HttpSession session) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user1 = userDao.email(currusername);
				cart = user1.getCart();
				product=null;
				cartItems = cartItemDao.getlist(cart.getC_id());
				if(cartItems==null || cartItems.isEmpty())
				{
					return "redirect:/viewcart";
				}
				else
				{
					billingaddress = billingaddressDao.get(user1.getUid());
					List<Shippingaddress> shippingaddresies = shippingaddressDao.getAddByUser(user1.getUid());
					
					model.addAttribute("billingaddress", billingaddress);
					model.addAttribute("user1", user1);
					model.addAttribute("shippingaddresies", shippingaddresies);
					model.addAttribute("shippingaddress", new Shippingaddress());
					session.setAttribute("p", product);
				}
				return "addressorder";
			}
			else
			{
				return "redirect:/";
			}

		}
		
		@RequestMapping("/Buy/{p_id}/{ci_id}")
		public String order(@PathVariable("p_id") String id, Model model,HttpSession session) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user1 = userDao.email(currusername);
				cart = user1.getCart();
				cartItems=null;
				product = productDao.get(id);
				billingaddress = billingaddressDao.get(user1.getUid());
				List<Shippingaddress> shippingaddresies = shippingaddressDao.getAddByUser(user1.getUid());
				
				model.addAttribute("billingaddress", billingaddress);
				model.addAttribute("user1", user1);
				model.addAttribute("shippingaddresies", shippingaddresies);
				model.addAttribute("shippingaddress", new Shippingaddress());
				session.setAttribute("p", product);
				return "addressorder";
			} else {
				return "redirect:/";
			}

		}

		@RequestMapping("/orderConfirm")
		public String payment(@ModelAttribute("shippingaddress") Shippingaddress sh, Model model) {
//			if(cartItems==null || cartItems.isEmpty())
//			{
//				System.out.println("sorry");
//			}
			sh.setUser1(user1);
			shippingaddress = sh;
			model.addAttribute("billingaddress", billingaddress);
			model.addAttribute("shippingaddress", shippingaddress);
			model.addAttribute("prot", product);
			model.addAttribute("cartItems",cartItems);
			model.addAttribute("cart",cart);
			return "orderconfirm";
		}

		@RequestMapping("/previous")
		public String previous(Model model) {
			List<Shippingaddress> shippingaddresies = shippingaddressDao.getAddByUser(user1.getUid());
			model.addAttribute("shippingaddresies", shippingaddresies);
			model.addAttribute("billingaddress", billingaddress);
			model.addAttribute("shippingaddress", shippingaddress);
			model.addAttribute("product", product);
			
			return "addressorder";
		}

		@RequestMapping("/pay")
		public String pay(Model model) {
//			List<Card> cards = cardDao.getcardbyuser(user1.getUid());
//			model.addAttribute("cards", cards);
//			model.addAttribute("card", new Card());
			return "Payment";
		}

		@RequestMapping("/payment")
		public String payment(@RequestParam("payb") String str, @RequestParam("otp")String otp, @ModelAttribute("card")Card c, Model model) {
					
	 		System.out.println(1324);
			int a;
			System.out.println(str);
					
			if (str.equalsIgnoreCase("Start Subscription")) {
				a = 2;
			} else {
				a = Integer.parseInt(str);
			}
			System.out.println(a);
			
			switch (a) {
			case 1:
					if(otp.equals(o))
					{
						pay.setPaymentmethod("COD");
						pay.setPaymentstatus("no");
					}
					else
					{
						return "redirect:/pay";
					}
				 
				break;
			case 2:
				pay.setPaymentmethod("card");
				pay.setPaymentstatus("yes");
				payDao.saveupdate(pay);
				cardDao.saveupdate(c);

				break;
			case 3:
				pay.setPaymentmethod("Internet Banking");
				pay.setPaymentstatus("yes");

			}

			return "redirect:/orderconfirmation";
		}

		@RequestMapping("/orderconfirmation")
		public String orderconformation(HttpSession session) {
			System.out.println(32);
			order.setBillingaddress(billingaddress);
			order.setShippingaddress(shippingaddress);
			order.setPay(pay);
			order.setUser1(user1);
			System.out.println(524);
			if (cartItems == null || cartItems.isEmpty()) 
			{
				order.setGrand_total(product.getP_price());
				orderDao.saveupdate(order);
				orderItems.setOrder(order);
				orderItems.setP_id(product.getP_id());
				orderItemsDao.saveupdate(orderItems);
				cart.setC_grandtotal(cart.getC_grandtotal() - cartItem.getPrice());
				cart.setC_totalitems(cart.getC_totalitems() - 1);
				session.setAttribute("items", cart.getC_totalitems());
				cartDao.saveupdate(cart);
				cartItemDao.delete(cartItemDao.getListall(cart.getC_id(),product.getP_id()).getC_itemid());
				System.out.println(324);
			}
			else
			{ 
				System.out.println(656);
				order.setGrand_total(cart.getC_grandtotal());
				orderDao.saveupdate(order);
				for(CartItem c:cartItems)
				{
					System.out.println(3444);
					orderItems.setOrder(order);
					orderItems.setP_id(c.getP().getP_id());
					System.out.println(3443);
					orderItemsDao.saveupdate(orderItems);
					cartItemDao.delete(c.getC_itemid());
				}
				cart.setC_grandtotal(0.0);
				cart.setC_totalitems(0);
				System.out.println(346);
				session.setAttribute("items", cart.getC_totalitems());
				cartDao.saveupdate(cart);
			}
			cartItems=null;
			cartItem=null;
			product=null;
			order=new Order();
			orderItems=new OrderItems();
			System.out.println(565);
			return "thankyou";
		}

	@RequestMapping(value="/SendMail")
	public void SendMail() {
		System.out.println(21312);
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
		String currusername = authentication.getName();
		user1 = userDao.email(currusername);      
		Otpganarater ot=new Otpganarater();
//		String o=ot.Otpga();
		o=ot.Otpga();
		String recipientAddress = user1.getEmail();
		String subject="OTP";
	//String subject = request.getParameter("subject");
	String message = "your one time password is "+o+" ";

	// prints debug info
	System.out.println("To:" + recipientAddress);
	System.out.println("Subject: " + subject);
	System.out.println("Message: " + message);

	    
	//System.out.println("OTP:"+ otp);
	// creates a simple e-mail object
	SimpleMailMessage email = new SimpleMailMessage();
	email.setTo(recipientAddress);
	email.setSubject(subject);
	email.setText(message);
	//email.setSubject(otp);
	// sends the e-mail
	mailSender.send(email);

	 
	// forwards to the view named "Result"
	//return "Result";
	}
	}
	}


