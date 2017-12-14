package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Product;

public interface ProductDao
{
	public boolean saveupdate(Product Product);
	public boolean delete(Product Product);
	public Product get(String p_id);
	public List<Product> list();
	public List<Product>getProductByCategory(String cid);//taking info by category by passing cid
	public List<Product>getProductBySupplier(String supid);
	

}
