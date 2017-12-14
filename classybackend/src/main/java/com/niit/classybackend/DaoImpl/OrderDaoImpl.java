package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.OrderDao;
import com.niit.classybackend.model.Order;

@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao
{
	@Autowired
	 SessionFactory sessionFactory;
	 public OrderDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Order Order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Order);
		
		return true;
	}
	@Transactional
	public boolean delete(Order Order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Order);
		return true;
	}
	@Transactional
	public  Order get(String Order_no) {
		// TODO Auto-generated method stub
		String q1="from Order where order_no='"+Order_no+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Order> list1 = (List<Order>) w.list();
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
	public List<Order> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Order> order= (List<Order>) sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return  order;
	}

 
	
}
