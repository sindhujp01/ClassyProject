package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.supplier1;

public interface SupplierDao {
	public boolean saveupdate(supplier1 supplier);
	public boolean delete(supplier1 supplier);
	public supplier1 get(String s_id);
	public List<supplier1> list();
	


}
