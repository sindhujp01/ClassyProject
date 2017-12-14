package com.niit.classybackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.classybackend.Dao.SupplierDao;
import com.niit.classybackend.model.supplier1;


	@Repository("supplierDao")
	@EnableTransactionManagement


	public class SupplierDaoImpl implements SupplierDao

	{
	 @Autowired
	 SessionFactory sessionFactory;
	 public SupplierDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(supplier1 supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
		return true;
	}
	@Transactional
	public boolean delete(supplier1 supplier) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}
	@Transactional
	public supplier1 get(String supid) {
		// TODO Auto-generated method stub
		String q1="from supplier1 where supid='"+supid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<supplier1> list1 = (List<supplier1>) w.list();
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
	public List<supplier1> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<supplier1> supplier = (List<supplier1>) sessionFactory.getCurrentSession().createCriteria(supplier1.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return supplier;
	}

	}



