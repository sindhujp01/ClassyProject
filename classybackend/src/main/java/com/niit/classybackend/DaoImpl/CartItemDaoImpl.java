package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.CartItemDao;
import com.niit.classybackend.model.CartItem;
import com.niit.classybackend.model.Product;

@Repository("cartItemDao")
@EnableTransactionManagement
public class CartItemDaoImpl implements CartItemDao
{
	 @Autowired
	 SessionFactory sessionFactory;
	 public CartItemDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(CartItem CartItem) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(CartItem);
		
		return true;
	}
	@Transactional
	public boolean delete(String c_itemid) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(c_itemid);
		return true;
	}
	@Transactional
	public CartItem get(String c_itemid) {
		// TODO Auto-generated method stub
		String q1="from CartItem where c_itemid='"+c_itemid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItem> list1 = (List<CartItem>) w.list();
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
	public List<CartItem> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<CartItem> cartItem= (List<CartItem>) sessionFactory.getCurrentSession().createCriteria(CartItem.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cartItem ;
	}
	@Transactional
	public List<CartItem> getCartItemByCart(String c_id)
	
	{
		String q1="from CartItem where c_id='"+c_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItem> list1 = (List<CartItem>) w.list();
		if(list1==null ||list1.isEmpty())
		{
			return null;
		}
		else
		{
			return list1;
		}
	}
	public List<CartItem> getlist(String c_id)
	{
		String q3="from CartItem where c_id='"+c_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q3);
		@SuppressWarnings("unchecked")
		List<CartItem> list1 = (List<CartItem>) w.list();
		if(list1==null ||list1.isEmpty())
		{
			return null;
		}
		else
		{
			return list1;
		}
	}
	
		public CartItem getListall(String c_id, String p_id)
		{
			String q2="from CartItem where c_id='" +c_id+ "' and p_id='" +p_id+ "'";
			Query w=sessionFactory.getCurrentSession().createQuery(q2);
			@SuppressWarnings("unchecked")
			List<CartItem> list2 = (List<CartItem>) w.list();
			if(list2==null ||list2.isEmpty())
			{
				return null;
			}
			else
			{
				return list2.get(0);
			}
			
		}
		@Override
		public List<CartItem> getCartItemByProductId(String p_id)
		{
			String q4="from CartItem where p_id='"+p_id+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q4);
			@SuppressWarnings("unchecked")
			List<CartItem> list1 = (List<CartItem>) w.list();
			if(list1==null ||list1.isEmpty())
			{
				return null;
			}
			else
			{
				return list1;
			}
		}

	}

	






