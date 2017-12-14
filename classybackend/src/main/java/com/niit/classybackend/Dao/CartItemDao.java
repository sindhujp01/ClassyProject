package com.niit.classybackend.Dao;

import java.util.List;


import com.niit.classybackend.model.CartItem;


public interface CartItemDao {
	
	public boolean saveupdate(CartItem cartItem);
	public boolean delete(String c_itemid);
	
	public CartItem get(String c_itemid);
	public List<CartItem> list();
	
	public List<CartItem>getCartItemByProductId(String p_id);
    public CartItem getListall(String c_id, String p_id);
    public List<CartItem> getlist(String C_id);
}
