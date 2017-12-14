package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.User1;

public interface UserDao {
	
		public boolean saveupdate(User1 user);
		public boolean delete(User1 user);
		public User1 get(String uid);
		public List<User1> list();
		public User1 isvalid(String email,String password);
        public User1 email(String email);
        

}

