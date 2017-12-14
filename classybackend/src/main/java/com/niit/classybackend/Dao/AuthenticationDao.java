package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Authentication;

public interface AuthenticationDao {
	public boolean saveupdate(Authentication authentication);
	public boolean delete(Authentication authentication);
	public Authentication get(String roleid);
	public List<Authentication> list();


}
