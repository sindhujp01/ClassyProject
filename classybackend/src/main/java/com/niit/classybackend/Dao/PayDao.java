package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Pay;

public interface PayDao
{
	public boolean saveupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay get(String pid);
	public List<Pay> list();

}
