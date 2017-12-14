package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.ShippingaddressDao;

import com.niit.classybackend.model.Shippingaddress;
@Repository("shippingaddressDao")
@EnableTransactionManagement
public class ShippingaddressDaoImpl implements ShippingaddressDao 
{
	@Autowired
	 SessionFactory sessionFactory;
	 public ShippingaddressDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Shippingaddress Shippingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Shippingaddress);
		
		return true;
	}
	@Transactional
	public boolean delete(Shippingaddress Shippingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Shippingaddress);
		return true;
	}
	@Transactional
	public Shippingaddress get(String s_id) {
		// TODO Auto-generated method stub
		String q1="from Shippingaddresss where s_id='"+s_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list1 = (List<Shippingaddress>) w.list();
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
	public List<Shippingaddress> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Shippingaddress> shippingaddress= (List<Shippingaddress>) sessionFactory.getCurrentSession().createCriteria(Shippingaddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return shippingaddress ;
	}
	@Override
	public List<Shippingaddress> getAddByUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}



}

