package com.niit.classybackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.classybackend.Dao.CardDao;
import com.niit.classybackend.model.Card;
@Repository("cardDao")
@EnableTransactionManagement
public class CardDaoImpl implements CardDao
{
	 @Autowired
	 SessionFactory sessionFactory;
	 public CardDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory=sessionFactory;
		 
	 }
	@Transactional
	public boolean saveupdate(Card Card) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(Card);
		
		return true;
	}
	@Transactional
	public boolean delete(Card Card) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(Card);
		return true;
	}
	@Transactional
	public Card get(String card_id) {
		// TODO Auto-generated method stub
		String q1="from Cards where card_id='"+card_id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Card> list1 = (List<Card>) w.list();
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
	public List<Card> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Card> card= (List<Card>) sessionFactory.getCurrentSession().createCriteria(Card.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return  card;
	}



}
