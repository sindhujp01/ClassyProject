package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Shippingaddress;

public interface ShippingaddressDao 
{
	
		public boolean saveupdate(Shippingaddress Shippingaddress);
		public boolean delete(Shippingaddress Shippingaddress);
		public Shippingaddress get(String s_id);
		public List<Shippingaddress> list();
		public List<Shippingaddress> getAddByUser(String uid);


	
}
