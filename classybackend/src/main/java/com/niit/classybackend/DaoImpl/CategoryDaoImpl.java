package com.niit.classybackend.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.classybackend.Dao.CategoryDao;
import com.niit.classybackend.model.Category1;

@Repository("categoryDao")
@EnableTransactionManagement
public class CategoryDaoImpl implements CategoryDao

{
 @Autowired
 SessionFactory sessionFactory;
 public CategoryDaoImpl(SessionFactory sessionFactory)
 {
	 this.sessionFactory=sessionFactory;
	 
 }
@Transactional
public boolean saveupdate(Category1 category) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().saveOrUpdate(category);
	
	return true;
}
@Transactional
public boolean delete(Category1 category) {
	// TODO Auto-generated method stub
	
	sessionFactory.getCurrentSession().delete(category);
	return true;
}
@Transactional
public Category1 get(String cid) {
	// TODO Auto-generated method stub
	String q1="from Category1 where cid='"+cid+"'";
	Query w=sessionFactory.getCurrentSession().createQuery(q1);
	@SuppressWarnings("unchecked")
	List<Category1> list1 = (List<Category1>) w.list();
	if(list1==null ||list1.isEmpty())
	{
		return null;
	}
	else
	{
		return list1.get(0);
	}

}

@Transactional
public List<Category1> list() {
	// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<Category1> category = (List<Category1>) sessionFactory.getCurrentSession().createCriteria(Category1.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
	return category;
}

}
