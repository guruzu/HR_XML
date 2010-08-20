/**
 * 
 */
package com.hibernaterecipes.chapter3;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

/**
 * @author Guruzu
 *
 */
public class Launch_3_4_1 {
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
		Set contacts = new HashSet();
		OrdersCh3_4_1 ord = new OrdersCh3_4_1();
		Contact cnt = new Contact();
		Contact weekDayCnt = new Contact();
		cnt.setAddress("132,vacation street, Maimi, Fl - 23232");
		cnt.setPhone("123-526-7555");
		cnt.setRecipient("John Doe 1");
		weekDayCnt.setRecipient("John Doe");
		weekDayCnt.setAddress("512364, Permanent home, Scottsdale, AZ - 85254");
		weekDayCnt.setPhone("123-231-6321");
		contacts.add(weekDayCnt);
		contacts.add(cnt);
		ord.setContacts(contacts);
		//ord.setWeekdayContact(weekDayCnt);
		//ord.setHolidayContact(cnt);
		session.save(ord);
		tx.commit();
		stats.getSessionOpenCount();
		stats.logSummary();
		session.close();

	}

}
