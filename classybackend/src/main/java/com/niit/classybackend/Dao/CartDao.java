package com.niit.classybackend.Dao;

import java.util.List;


import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.Product;

public interface CartDao 
{
	public boolean saveupdate(Cart Cart);
	public boolean delete(Cart Cart);
	public Cart get(String c_id);
	public List<Cart> list();
	

}
