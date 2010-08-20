/**
 * 
 */
package com.hibernaterecipes.chapter10;

import java.io.Serializable;
import java.util.Date;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernaterecipes.chapter2.BookCh2;


/**
 * @author Guruzu
 *
 */
public class Launch_10_1 { 
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
		/*Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		BookCh2 book = new BookCh2();
		book.setName("Book Name - hibernate 1");
		book.setPrice(79);
		book.setPublishDate(new Date());
		Serializable bookId = session.save(book);
		
		tx.commit();
		session.close();*/
		//retrievePersistentObject();
		//modifyPersistentObject();
		//reattacheDetachedObject();
		mergeDetachedObject();
	}
	public static void retrievePersistentObject()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		BookCh2 book = (BookCh2) session.load(BookCh2.class, new Long(294913));
		//BookCh2 book1 = (BookCh2) session.get(BookCh2.class, new Long(294912));
		//System.out.println("ISBN - "+book.getIsbn());
		
		tx.commit();
		session.close();
		System.out.println(book);
	}
	
	public static void modifyPersistentObject()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		BookCh2 book = (BookCh2) session.get(BookCh2.class, new Long(294912));
		book.setName("Book Name - hibernate 2");
		tx.commit();
		session.close();
	}
	
	public static void deletePersistentObject()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		BookCh2 book = (BookCh2) session.get(BookCh2.class, new Long(294912));
		session.delete(book);
		tx.commit();
		session.close();
	}
	
	public static void reattacheDetachedObject()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		BookCh2 book = (BookCh2) session.get(BookCh2.class, new Long(294912));
		tx.commit();
		session.close();
		book.setName("Detached Hibernate");
		Session session2 = getSession();
		Transaction tx2 = session2.beginTransaction();
		session2.update(book);
		tx2.commit();
		session2.close();
	}
	
	public static void mergeDetachedObject()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		BookCh2 book = (BookCh2) session.get(BookCh2.class, new Long(294912));
		tx.commit();
		session.close();
		book.setName("Detached Hibernate");
		Session session2 = getSession();
		Transaction tx2 = session2.beginTransaction();
		BookCh2 book2 = (BookCh2) session2.merge(book);
		tx2.commit();
		session2.close();
	}

}
