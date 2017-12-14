package com.niit.classybackend.DaoImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.CartDao;
import com.niit.classybackend.model.Cart;
@Repository("cartDao")
@EnableTransactionManagement

public class CartDaoImpl implements CartDao
{
	 @Autowired
	 SessionFactory sessionFactory;
	 public CartDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Cart Cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Cart);
		
		return true;
	}
	@Transactional
	public boolean delete(Cart Cart) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete( Cart);
		return true;
	}
	@Transactional
	public Cart get(String c_id) {
		// TODO Auto-generated method stub
		String q1="from Cart where c_id='"+c_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Cart> list1 = (List<Cart>) w.list();
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
	public List<Cart> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Cart> cart= (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cart ;
	}



}
