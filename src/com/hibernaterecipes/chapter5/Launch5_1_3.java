/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Guruzu
 *
 */
public class Launch5_1_3 { 
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
		Logger logger = LoggerFactory.getLogger(Launch5_1_3.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Publisher publisher = new Publisher();
		publisher.setAddress("4578, Price Road, chandler");
		publisher.setCode("565");
		publisher.setName("Manning");
		/*Serializable obj = session.save(publisher);
		if(obj instanceof Publisher)
			publisher = (Publisher) obj;*/
		Book_5_1 book = new Book_5_1();
		book.setIsbn("87787691");
		book.setName("Hibernate Recipes");
		book.setPublisher(publisher);
		session.save(book);
		tx.commit();
		
		
		session.close();
		
	}

}
