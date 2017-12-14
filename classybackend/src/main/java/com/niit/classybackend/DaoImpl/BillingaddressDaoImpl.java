package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.BillingaddressDao;
import com.niit.classybackend.model.Billingaddress;
@Repository("billingaddressDao")
@EnableTransactionManagement
public class BillingaddressDaoImpl implements BillingaddressDao
{

	 @Autowired
	 SessionFactory sessionFactory;
	 public BillingaddressDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Billingaddress Billingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Billingaddress);
		
		return true;
	}
	@Transactional
	public boolean delete(Billingaddress Billingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Billingaddress);
		return true;
	}
	@Transactional
	public Billingaddress get(String b_id) {
		// TODO Auto-generated method stub
		String q1="from Billingaddress where b_id='"+b_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Billingaddress> list1 = (List<Billingaddress>) w.list();
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
	public List<Billingaddress> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Billingaddress> billingaddress= (List<Billingaddress>) sessionFactory.getCurrentSession().createCriteria(Billingaddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return billingaddress ;
	}
	
	@Override
	public Billingaddress getByUser(String uid) 
	{
		String q2="from Billingaddress where uid='"+uid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q2);
		@SuppressWarnings("unchecked")
		List<Billingaddress> list1 = (List<Billingaddress>) w.list();
		if(list1==null ||list1.isEmpty())
		{
			return null;
		}
		else
		{
			return list1.get(0);
		}
		
	}
  

}
