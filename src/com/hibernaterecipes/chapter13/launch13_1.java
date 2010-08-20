/**
 * 
 */
package com.hibernaterecipes.chapter13;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernaterecipes.chapter2.BookCh2;

/**
 * @author Guruzu
 *
 */
public class launch13_1 {
	static Logger log = Logger.getLogger(launch13_1.class);

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();  
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		BookCh2 book = new BookCh2();
		book.setName("Hibernate Receipes Book  2");
		book.setPrice(200);
		book.setPublishDate(new Date());
		session.saveOrUpdate(book);
		tx.commit();
		log.debug("Transaction Committed");
		
		} catch (RuntimeException e) {
			try{
				if(tx != null)
				{
					tx.rollback();
				}
			}catch(RuntimeException ex)
			{
				log.error("Cannot rollback transaction");
			}
				
			throw e;
		} finally {
			session.close();
		}

	}

}
