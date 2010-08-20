/**
 * 
 */
package com.hibernaterecipes.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

/**
 * @author Guruzu
 *
 */
public class Launch_3_2 {
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
		OrdersCh3_2 ord = new OrdersCh3_2();
		Phone wdPhn = new Phone();
		Phone hlPhn = new Phone();
		wdPhn.setAreaCode("480");
		wdPhn.setTelNo("5463152");
		hlPhn.setAreaCode("702");
		hlPhn.setTelNo("5643569");
		ContactCh3_2 cnt = new ContactCh3_2();
		ContactCh3_2 weekDayCnt = new ContactCh3_2();
		cnt.setAddress("132,vacation street, Maimi, Fl - 23232");
		cnt.setPhone(wdPhn);
		cnt.setRecipient("John Doe 1");
		weekDayCnt.setRecipient("John Doe");
		weekDayCnt.setAddress("512364, Permanent home, Scottsdale, AZ - 85254");
		weekDayCnt.setPhone(hlPhn);
		ord.setWeekdayContact(weekDayCnt);
		ord.setHolidayContact(cnt);
		session.save(ord);
		tx.commit();
		stats.getSessionOpenCount();
		stats.logSummary();
		session.close();

	}

}
