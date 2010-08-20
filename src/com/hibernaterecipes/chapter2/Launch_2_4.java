/**
 * 
 */
package com.hibernaterecipes.chapter2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * @author Guruzu
 *
 */
public class Launch_2_4 { 
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
		Transaction trans = session.beginTransaction();
		/*for(int i =0;i<1;i++)
		{
			BookCh2 book = new BookCh2();
			//book.setName("Book Name "+(i+1));
			book.setPrice(39);
			//book.setPublishDate(new Date());
			session.save(book);
		}
		trans.commit();*/
		/*long id = 163840;
		DetachedCriteria crit = DetachedCriteria.forClass(BookCh2.class);
		crit.add(Restrictions.eq("isbn", id));
		Criteria cc = crit.getExecutableCriteria(session);
		
		List<BookCh2> books = cc.list();
		
		for(BookCh2 bo : books)
		{
			
			System.out.println(bo);
			Transaction tx = session.beginTransaction();
			bo.setPrice(50);
			session.update(bo);
			tx.commit();
			
		}*/
		System.out.println("****************************");
		System.out.println("Results Using Query  ");
		List<BookCh2> booksList = session.createQuery("from bkch2").list();
		for(BookCh2 bo : booksList)
		{
			System.out.println(bo);
		}
		session.close();
		
	}

}
