/**
 * 
 */
package com.hibernaterecipes.chapter2;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * @author Guruzu
 *
 */
public class Launch_2_1 { 
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
		Transaction tx = session.beginTransaction();
		/*for(int i =0;i<5;i++)
		{
			
			BookCh2 book = new BookCh2();
			book.setName("Hibernate Book Name "+(i+1));
			book.setPrice(200);
			book.setPublishDate(new Date());
			session.save(book);
			System.out.println("get isbn "+book.getIsbn());
			
			if(i % 25 == 0)
			{
				System.out.println("Flushing in batches");
				session.flush();
				session.clear();
				System.out.println("get isbn "+book.getIsbn());
			}
			
		}
		System.out.println(" commiting");
		tx.commit();
		session.close();
		System.out.println("session closed");*/
		//testUpdate();
		
		//testUpdateFix1();
		//testUpdateFix2();
		testPessimisticCC();
		
	}
	
	



	public static void testUpdate()
	{
		Session session = getSession();
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		Query query = session.createQuery("from bkch2 where name like ?");
		query.setString(0, "%Hibernate%");
		List books = query.list();
		for (Iterator iter = books.iterator(); iter.hasNext();) 
		{
			BookCh2 book = (BookCh2) iter.next();
			book.setPrice(new Integer(book.getPrice()- 10));
			session.saveOrUpdate(book);
		}
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null) 
				tx.rollback();
			
			throw e;
		} finally {
			session.close();
		}
	}
	
	public static void testUpdateFix1()
	{
		Session session = getSession();
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		Query query = session.createQuery("update bkch2 set price = price - ? where name like ?");
		query.setInteger(0, 10);
		query.setString(1, "%Hibernate%");
		int count = query.executeUpdate();
				
		tx.commit();
		} catch (HibernateException e) {
			if (tx != null) 
				tx.rollback();
			
			throw e;
		} finally {
			session.close();
		}
	}
	
	public static void testUpdateFix2()
	{
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		ScrollableResults books = session.createQuery("from bkch2 where name like 'Book%'")
		.setCacheMode(CacheMode.IGNORE)
	    .scroll(ScrollMode.FORWARD_ONLY);
		
		int count=0;
		while ( books.next() ) {
				BookCh2 book = (BookCh2) books.get(0);
				book.setPrice(new Integer(book.getPrice()- 10));
				if ( ++count % 25 == 0 ) {
					//flush a batch of updates and release memory:
					System.out.println("Flushing in batches");
					session.flush();
					session.clear();
			}
		}
		tx.commit();
		session.close();

	}
	
	/**
	 * 
	 */
	private static void testPessimisticCC() {
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		BookCh2 book = (BookCh2)session.get(BookCh2.class, new Long(32769));
		String name = (String) session.createQuery("select b.name from bkch2 b where b.isbn = :isbn")
						.setParameter("isbn", book.getIsbn()).uniqueResult();
		System.out.println("BOOk's Name- "+name);
		tx.commit();
		session.close();
		
	}
	

}
