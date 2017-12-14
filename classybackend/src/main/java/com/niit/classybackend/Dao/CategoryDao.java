package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Category1;

public interface CategoryDao {
public boolean saveupdate(Category1 category);
public boolean delete(Category1 category);
public Category1 get(String cid);
public List<Category1> list();


}
