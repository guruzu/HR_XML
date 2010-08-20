/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

/**
 * @author Guruzu
 *
 */
public class Launch_4_4 {
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
		Session session = getSession();
		Statistics stats = sessionFactory.getStatistics();
		stats.setStatisticsEnabled(true);
		Transaction tx = session.beginTransaction();
		OrdersCh4_4 ord = new OrdersCh4_4();
		ord.setHolidayAddress("3453453,vacation street, Maimi, Fl - 23232");
		ord.setHolidayPhone("5345345");
		ord.setHolidayRecipient("John Doe");
		ord.setWeekdayRecipient("John Doe");
		ord.setWeekdayAddress("35555, Permanent home, Scottsdale, AZ - 85254");
		PhoneCh4_4 phn = new PhoneCh4_4();
		phn.setAreaCode("480");
		phn.setTelNo("7489512");
		ord.setWeekdayPhone(phn);
		session.save(ord);
		tx.commit();
		stats.getSessionOpenCount();
		stats.logSummary();
		session.close();

	}

}
