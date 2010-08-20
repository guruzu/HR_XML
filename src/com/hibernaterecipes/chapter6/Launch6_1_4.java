/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.util.ArrayList;
import java.util.List;

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
public class Launch6_1_4 { 
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
		Logger logger = LoggerFactory.getLogger(Launch6_1_4.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Book6_4 book = new Book6_4();
		String[] chapters = new String[5];
		chapters[0]="chapter10";
		chapters[1]="chapter11";
		chapters[2]="chapter12";
		chapters[3]="chapter13";
		chapters[4]="chapter14";
		book.setChapters(chapters);
		book.setName("TextBook");
		book.setIsbn("8876876");
		session.save(book);
		tx.commit();
		
		
		session.close();
		
	}

}
