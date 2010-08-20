/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
public class Launch6_1_1 { 
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
		Logger logger = LoggerFactory.getLogger(Launch6_1_1.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Book6_1 book = new Book6_1();
		Set<String> chapters = new HashSet<String>();
		chapters.add("chapter1");
		chapters.add("chapter2");
		chapters.add("chapter3");
		chapters.add("chapter4");
		chapters.add("chapter5");
		book.setChapters(chapters);
		book.setName("TextBook");
		book.setIsbn("8876876");
		session.save(book);
		tx.commit();
		
		
		session.close();
		
	}

}
