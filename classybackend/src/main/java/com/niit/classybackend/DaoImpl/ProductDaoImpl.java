package com.niit.classybackend.DaoImpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.ProductDao;
import com.niit.classybackend.model.Product;
@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao 
{
	 @Autowired
	 SessionFactory sessionFactory;
	 public ProductDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Product Product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Product);
		
		return true;
	}
	@Transactional
	public boolean delete(Product Product) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(Product);
		return true;
	}
	@Transactional
	public Product get(String p_id) {
		// TODO Auto-generated method stub
		String q1="from Product where p_id='"+p_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);

		@SuppressWarnings("unchecked")
		List<Product> list1 = (List<Product>) w.list();
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
	public List<Product> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Product> product= (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return product ;
	}
	@Transactional
	public List<Product> getProductByCategory(String cid)
	{
			// TODO Auto-generated method stub
			String q1="from Product where cid='"+cid+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);

			@SuppressWarnings("unchecked")
			List<Product> list1 = (List<Product>) w.list();
			if(list1==null ||list1.isEmpty())
			{
				return null;
			}
			else
			{
				return list1;
			}

		}
	@Transactional
	public List<Product> getProductBySupplier(String supid)
	{
			// TODO Auto-generated method stub
			String q1="from Product where supid='"+supid+"'";
			Query w=sessionFactory.getCurrentSession().createQuery(q1);

			@SuppressWarnings("unchecked")
			List<Product> list1 = (List<Product>) w.list();
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
