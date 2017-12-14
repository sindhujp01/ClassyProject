package com.niit.classybackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.classybackend.Dao.UserDao;
import com.niit.classybackend.model.User1;
import com.niit.classybackend.model.Authentication;
import com.niit.classybackend.model.Billingaddress;
import com.niit.classybackend.model.Cart;
import com.niit.classybackend.model.Category1;
@Repository("userDao")
@EnableTransactionManagement

public class UserDaoImpl implements UserDao
{
	@Autowired
	 SessionFactory sessionFactory;
	 public UserDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(User1 user) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
		user.setCart(cart);
		sessionFactory.getCurrentSession().saveOrUpdate(user);

		Billingaddress bill = new Billingaddress();
		bill.setB_city(user.getAddress());
		bill.setB_dno(bill.getB_dno());
		bill.setB_locality(bill.getB_locality());
		
		user.setBillingaddress(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
		
		Authentication authentication = new Authentication();
		authentication.setUsername(user.getEmail());
		user.setAuthentication(authentication);
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		
		return true;
	}
	@Transactional
	public boolean delete(User1 user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}
	@Transactional
	public User1 get(String uid) {
		// TODO Auto-generated method stub
		String q1="from User1 where uid='"+uid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<User1> list1 = (List<User1>) w.list();
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
	public List<User1> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User1> user = (List<User1>) sessionFactory.getCurrentSession().createCriteria(User1.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return user;
	}
	@Transactional
	public User1 isvalid(String email,String password)
	{
		String q2="from User1 where email='"+email+"' and password='"+password+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<User1> list2 = (List<User1>) w.list();
		if(list2==null ||list2.isEmpty())
		{
			return null;
		}
		else
		{
			return list2.get(0);
		}

	}
	public User1 email(String email)
	{
		String q3="from User1 where email='"+email+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q3);
		@SuppressWarnings("unchecked")
		List<User1> list3 = (List<User1>) w.list();
		if(list3==null ||list3.isEmpty())
		{
			return null;
		}
		else
		{
			return list3.get(0);
		}

	}
	
	}

	


