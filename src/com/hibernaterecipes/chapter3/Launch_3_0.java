/**
 * 
 */
package com.hibernaterecipes.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

import com.hibernaterecipes.chapter2.BookCh2;

/**
 * @author Guruzu
 *
 */
public class Launch_3_0 {
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
		BookCh2 book = (BookCh2)session.get(BookCh2.class, new Long(1));
		Orders ord = new Orders();
		ord.setHolidayAddress("132,vacation street, Maimi, Fl - 23232");
		ord.setHolidayPhone("123-526-7555");
		ord.setHolidayRecipient("John Doe");
		ord.setWeekdayRecipient("John Doe");
		ord.setWeekdayAddress("564, Permanent home, Scottsdale, AZ - 85254");
		ord.setWeekdayPhone("123-231-6321");
		System.out.println("book "+book.getName()+" price "+book.getPrice());
		ord.setBook(book);
		session.save(ord);
		tx.commit();
		stats.getSessionOpenCount();
		stats.logSummary();
		session.close();

	}

}
