package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.OrderItemsDao;
import com.niit.classybackend.model.Card;
import com.niit.classybackend.model.OrderItems;
@Repository("orderItemsDao")
@EnableTransactionManagement
public class OrderItemsDaoImpl implements OrderItemsDao 
{
	
	@Autowired
	 SessionFactory sessionFactory;
	 public OrderItemsDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(OrderItems OrderItems) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(OrderItems);
		
		return true;
	}
	@Transactional
	public boolean delete(OrderItems OrderItems) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(OrderItems);
		return true;
	}
	@Transactional
	public OrderItems get(String orderitem_id) {
		// TODO Auto-generated method stub
		String q1="from OrderItems where orderitem_id='"+orderitem_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list1 = (List<OrderItems>) w.list();
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
	public List<OrderItems> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<OrderItems> OrderItems= (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return  OrderItems;
	}
	public List<OrderItems>getOrderItemsByOrder(String order_no)
	{
		String q2="from OrderItems where orderitem_id='"+order_no+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<OrderItems> list2 = (List<OrderItems>) w.list();
		if(list2==null ||list2.isEmpty())
		{
			return null;
		}
		else
		{
			return list2;
		}
	}

}
