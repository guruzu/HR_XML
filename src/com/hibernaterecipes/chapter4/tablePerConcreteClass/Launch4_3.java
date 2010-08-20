/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerConcreteClass;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hibernaterecipes.chapter4.tablePerSubClass.AudioDisc_2;
import com.hibernaterecipes.chapter4.tablePerSubClass.Disc_2;

/**
 * @author Guruzu
 *
 */
public class Launch4_3 { 
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
		Logger logger = LoggerFactory.getLogger(Launch4_3.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		
		//Statistics stats = sessionFactory.getStatistics();
		/*AudioDisc3 aDisc = new AudioDisc3();
		aDisc.setName("Again");
		aDisc.setNoOfSongs(6);
		aDisc.setPrice(9);
		aDisc.setSinger("MJ");
		VideoDisc_3 vDisc = new VideoDisc_3();
		vDisc.setName("AgainVideo");
		vDisc.setDirector("MJ");
		vDisc.setLanguage("English");
		vDisc.setPrice(20);
		session.saveOrUpdate(aDisc);
		session.saveOrUpdate(vDisc);*/
		
		
		List<AudioDisc3> aDiscs = session.createQuery("from AudioDisc3").list();
		for(AudioDisc3 disc : aDiscs)
		{
			System.out.println(disc);
		}
		
		tx.commit();
		session.close();
		
	}

}
