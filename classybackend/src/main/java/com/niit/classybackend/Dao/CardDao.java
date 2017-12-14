package com.niit.classybackend.Dao;

import java.util.List;

import com.niit.classybackend.model.Card;

public interface CardDao 
{
	public boolean saveupdate(Card Card);
	public boolean delete(Card Card);
	public Card get(String card_id);
	public List<Card> list();

}
