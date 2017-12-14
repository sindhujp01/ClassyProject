package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.AuthenticationDao;
import com.niit.classybackend.model.Authentication;
import com.niit.classybackend.model.Pay;
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao{
	@Autowired
	 SessionFactory sessionFactory;
	 public AuthenticationDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Authentication Authentication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Authentication);
		
		return true;
	}
	@Transactional
	public boolean delete(Authentication Authentication) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Authentication);
		return true;
	}
	@Transactional
	public  Authentication get(String roleid) {
		// TODO Auto-generated method stub
		String q1="from Authentication where roleid='"+roleid+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Authentication> list1 = (List<Authentication>) w.list();
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
	public List<Authentication> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Authentication> authentication= (List<Authentication>) sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return  authentication;
	}

	

}
