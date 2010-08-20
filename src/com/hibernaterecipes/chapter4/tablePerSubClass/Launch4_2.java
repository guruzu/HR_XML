/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerSubClass;

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
public class Launch4_2 { 
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
		Logger logger = LoggerFactory.getLogger(Launch4_2.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		/*AudioDisc_2 aDisc = new AudioDisc_2();
		aDisc.setName("Again");
		aDisc.setNoOfSongs(6);
		aDisc.setPrice(9);
		aDisc.setSinger("MJ");
		VideoDisc_2 vDisc = new VideoDisc_2();
		vDisc.setName("AgainVideo");
		vDisc.setDirector("MJ");
		vDisc.setLanguage("English");
		vDisc.setPrice(20);
		session.saveOrUpdate(aDisc);
		session.saveOrUpdate(vDisc);*/
		//stats.getSessionOpenCount();
		//stats.logSummary();
		//List<AudioDisc_2> aDiscs = session.createQuery("from AudioDisc_2").list();
		/*for(AudioDisc_2 aDisc : aDiscs)
		{
		*/	//System.out.println(aDisc);
		//}
		
		List<Disc_2> discs = session.createQuery("from Disc_2").list();
		for(Disc_2 disc : discs)
		{
			System.out.println(disc);
		}
		List<AudioDisc_2> aDiscs = session.createQuery("from AudioDisc_2").list();
		for(AudioDisc_2 disc : aDiscs)
		{
			System.out.println(disc);
		}
		tx.commit();
		session.close();
		
	}

}
