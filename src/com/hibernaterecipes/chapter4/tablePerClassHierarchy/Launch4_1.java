/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerClassHierarchy;

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
public class Launch4_1 { 
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
		Logger logger = LoggerFactory.getLogger(Launch4_1.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		//Statistics stats = sessionFactory.getStatistics();
		/*AudioDisc aDisc = new AudioDisc();
		aDisc.setName("Never Again");
		aDisc.setNoOfSongs(6);
		aDisc.setPrice(9);
		aDisc.setSinger("MJ");
		VideoDisc vDisc = new VideoDisc();
		vDisc.setName("Transformers");
		vDisc.setDirector("Micheal Bay");
		vDisc.setLanguage("English");
		vDisc.setPrice(20);
		session.saveOrUpdate(aDisc);
		session.saveOrUpdate(vDisc);*/
		//stats.getSessionOpenCount();
		//stats.logSummary();
		List<Disc> aDiscs = session.createQuery("from Disc").list();
		for(Disc aDisc : aDiscs)
		{
			System.out.println(aDisc.getName());
		}
		tx.commit();
		session.close();
		
	}

}
