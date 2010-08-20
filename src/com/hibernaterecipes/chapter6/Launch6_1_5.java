/**
 * 
 */
package com.hibernaterecipes.chapter6;


import java.util.HashMap;
import java.util.Map;

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
public class Launch6_1_5 { 
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
		Logger logger = LoggerFactory.getLogger(Launch6_1_5.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Book6_5 book = new Book6_5();
		HashMap chapters = new HashMap();
		chapters.put("key1", "chapter1");
		chapters.put("key2", "chapter2");
		chapters.put("key3", "chapter3");
		chapters.put("key4", "chapter4");
		book.setChapters(chapters);
		book.setName("TextBook");
		book.setIsbn("8876876");
		session.save(book);
		tx.commit();
		
		
		session.close();
		
	}

}
