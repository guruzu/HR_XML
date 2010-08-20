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
public class Launch_3_3 {
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
		OrdersCh3_3 ord = new OrdersCh3_3();
		
		Address wdAdd = new Address();
		setAddress(wdAdd,"132","vacation street", "Maimi", "Fl" , 23232);
		Address hlAdd = new Address();
		setAddress(hlAdd,"512364", "Permanent home", "Scottsdale", "AZ" , 85254);
		session.save(wdAdd);
		session.save(hlAdd);
		tx.commit();
		
		tx = session.beginTransaction();
		Phone wdPhn = new Phone();
		wdPhn.setAreaCode("480");
		wdPhn.setTelNo("5463152");
		Phone hlPhn = new Phone();
		hlPhn.setAreaCode("702");
		hlPhn.setTelNo("5643569");
		
		ContactCh3_3 cnt = new ContactCh3_3();
		ContactCh3_3 weekDayCnt = new ContactCh3_3();
		cnt.setPhone(wdPhn);
		cnt.setRecipient("John Doe 1");
		cnt.setAddress(hlAdd);
		weekDayCnt.setRecipient("John Doe");
		weekDayCnt.setPhone(hlPhn);
		weekDayCnt.setAddress(wdAdd);
		ord.setWeekdayContact(weekDayCnt);
		ord.setHolidayContact(cnt);
		session.save(ord);
		tx.commit();
		stats.getSessionOpenCount();
		stats.logSummary();
		session.close();

	}
	
	public static Address setAddress(Address add,String add1,String add2, String city, String state,int zipCode)
	{
		add.setAddress1(add1);
		add.setAddress2(add2);
		add.setCity(city);
		add.setState(state);
		add.setZipCode(zipCode);
		
		return add;
	}

}
