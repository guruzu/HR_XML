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
public class Launch5_1_4 { 
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
		Logger logger = LoggerFactory.getLogger(Launch5_1_4.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Publisher5_2 publisher = new Publisher5_2();
		publisher.setAddress("4578, Price Road, chandler");
		publisher.setCode("564");
		publisher.setName("Apress");
		
		Book5_2 book = new Book5_2();
		book.setIsbn("87787690");
		book.setName("Hibernate Recipes");
		book.setPublisher(publisher);
		session.save(book);
		tx.commit();
		
		
		session.close();
		
	}

}
