/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

import com.hibernaterecipes.chapter3.Address;

/**
 * @author Guruzu
 *
 */
public class Launch_4_5 {
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
		OrdersCh4_5 ord = new OrdersCh4_5();
		
		Address wdAdd = new Address();
		setAddress(wdAdd,"56","vacation street 121", "Maimi", "Fl" , 23232);
		Address hlAdd = new Address();
		setAddress(hlAdd,"fdse1233", "Permanent home", "Scottsdale", "AZ" , 85254);
		session.save(wdAdd);
		session.save(hlAdd);
		tx.commit();
		
		tx = session.beginTransaction();
		PhoneCh4_4 wdPhn = new PhoneCh4_4();
		wdPhn.setAreaCode("623");
		wdPhn.setTelNo("564217879");
		PhoneCh4_4 hlPhn = new PhoneCh4_4();
		hlPhn.setAreaCode("979");
		hlPhn.setTelNo("897541");
		
		ContactCh4_5 cnt = new ContactCh4_5();
		ContactCh4_5 weekDayCnt = new ContactCh4_5();
		cnt.setPhone(wdPhn);
		cnt.setRecipient("John Doe 2");
		cnt.setAddress(hlAdd);
		weekDayCnt.setRecipient("John Doe 3");
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
