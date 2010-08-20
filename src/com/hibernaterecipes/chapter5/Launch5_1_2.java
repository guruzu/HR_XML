/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Guruzu
 *
 */
public class Launch5_1_2 { 
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
		Logger logger = LoggerFactory.getLogger(Launch5_1_2.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		Customer5_2 customer = new Customer5_2();
		Address5_2 address = new Address5_2();
		address.setDoorplate("54213");
		address.setStreet("Main Street");
		address.setCity("Los Angeles");
		customer.setCountryCode("USA");
		customer.setEmail("abc@abc.bcd");
		customer.setFirstName("John");
		customer.setIdCardNo("5648231");
		customer.setLastName("Doe");
		address.setCustomer(customer);
		customer.setAddress(address);
		session.save(customer);
		tx.commit();
		
		
		session.close();
		
	}

}
