package com.niit.classybackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.classybackend.Dao.CardDao;
import com.niit.classybackend.model.Card;

public class CardTest 
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CardDao cardDao=(CardDao)context.getBean("cardDao");
		Card card=(Card)context.getBean("card");
		
		card.setCard_no("10");
		card.setCard_holdername("sindhu");
		card.setCard_expirydate("10th may");
		cardDao.saveupdate(card);
		


}

}
