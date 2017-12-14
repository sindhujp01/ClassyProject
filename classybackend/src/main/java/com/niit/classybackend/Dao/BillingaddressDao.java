package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Billingaddress;

public interface BillingaddressDao
{
	
		public boolean saveupdate(Billingaddress billingaddress);
		public boolean delete(Billingaddress billingaddress);
		public Billingaddress get(String b_id);
		public List<Billingaddress> list();
		public Billingaddress getByUser(String uid);


}
