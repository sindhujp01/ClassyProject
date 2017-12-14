package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.PayDao;
import com.niit.classybackend.model.Pay;
@Repository("payDao")
@EnableTransactionManagement
public class PayDaoImpl implements PayDao
{
	 @Autowired
	 SessionFactory sessionFactory;
	 public PayDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Pay Pay) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Pay);
		
		return true;
	}
	@Transactional
	public boolean delete(Pay Pay) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Pay);
		return true;
	}
	@Transactional
	public  Pay get(String pid) {
		// TODO Auto-generated method stub
		String q1="from Pay where pid='"+pid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Pay> list1 = (List<Pay>) w.list();
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
	public List<Pay> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Pay> pay= (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return  pay;
	}




}
