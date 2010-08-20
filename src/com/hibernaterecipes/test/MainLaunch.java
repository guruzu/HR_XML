/**
 * 
 */
package com.hibernaterecipes.test;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernaterecipes.bookstore.Book;

/**
 * @author Guruzu
 *
 */
public class MainLaunch { 
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
		Logger logger = LoggerFactory.getLogger(MainLaunch.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		Statistics stats = sessionFactory.getStatistics();
		//stats.setStatisticsEnabled(true);
		Transaction tx = session.beginTransaction();
		List<Book> books = session.createQuery("from Book").list();
		for(Book bo : books)
		{
			System.out.println(bo.getIsbn());
		}
		//stats.getSessionOpenCount();
		//stats.logSummary();
		session.close();
		
	}

	

}
