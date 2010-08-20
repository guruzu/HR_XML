/**
 * 
 */
package com.hibernaterecipes.chapter9;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernaterecipes.chapter5.Book_5_1;
import com.hibernaterecipes.chapter5.Publisher;


/**
 * @author Guruzu
 *
 */
public class Launch9_1 { 
	static
	{
		//PropertyConfigurator.configure("D:/dev/HR_XML/bin/log4j.properties");
		
	}
	private static SessionFactory sessionFactory;  
	  
	public static Session getSession() {
		if(sessionFactory == null)
		{
			sessionFactory = new Configuration().configure()
			.buildSessionFactory();
		}
		Session hibernateSession = sessionFactory.openSession();  
		return hibernateSession;  
	}
	 
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Launch9_1.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		/*Transaction tx = session.beginTransaction();
		Publisher publisher = new Publisher();
		publisher.setAddress("4578, Price Road, chandler");
		publisher.setCode("564");
		publisher.setName("Apress");
		Serializable obj = session.save(publisher);
		if(obj instanceof Publisher)
			publisher = (Publisher) obj;
		Book_5_1 book = new Book_5_1();
		book.setIsbn("87787690");
		book.setName("Hibernate Recipes");
		book.setPublisher(publisher);
		session.save(book);
		tx.commit();*/
		//String sql ="from Publisher publisher where publisherCode in (select publisherCode from Book where publishDate < getDate())";
		
		/*Criteria crit = session.createCriteria(Book_5_1.class);
		crit.createAlias("publisher", "pub");
		crit.add(Restrictions.like("name", "Hibernate Recipes"));
		crit.add(Restrictions.like("pub.name", "res"));
		List list = crit.list();
		if(list != null && !list.isEmpty())
		{
			Book_5_1 book = (Book_5_1)list.get(0);
			System.out.println(book.getName());
		}*/
		/*Criteria crit = session.createCriteria(Book_5_1.class);
		crit.createAlias("publisher", "pub");
		crit.add(Restrictions.le("", ""));
		crit.add(Restrictions.eq("publishcode", "pub.code"));
		session.close();*/
		Criteria criteria = session.createCriteria(Book_5_1.class,"book")
		.add(Restrictions.like("name", "%Hibernate%"))
		.createCriteria("publisher")
		.add(Restrictions.eq("name", "Manning"));
		List list = criteria.list();
		if(list != null && !list.isEmpty())
		{
			Book_5_1 book = (Book_5_1)list.get(0);
			System.out.println(book.getName());
		}
		
	}

}
