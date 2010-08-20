/**
 * 
 */
package com.hibernaterecipes.chapter10;

import java.util.Date;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Guruzu
 *
 */
public class Launch_10_5 {
	
	private static SessionFactory sessionFactory;  
	  
	public static Session getSession() {
		if(sessionFactory == null)
		{
			Configuration config = new Configuration();
			config.setInterceptor(new BookShopInterceptor());
			sessionFactory = config.configure().buildSessionFactory();
			//sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		//Session hibernateSession = sessionFactory.openSession(new BookShopInterceptor()); 
		Session hibernateSession = sessionFactory.openSession(); 
		return hibernateSession;  
	}
	
	public static void main(String[] args) {
		insertBooks();
		//modifyBooks();
	}
	static void printBooks()
	{
		System.out.println("Started main");
		Session session = getSession();
		List<Book> books = session.createQuery("from bookchapter10_1").list();
		if(books != null)
		{
			for(Book book:books)
			{
				System.out.println("Name "+book.getName());
			}
		}
		System.out.println("Ended main");
	}
	
	static void insertBooks()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(" Started ");
		Book2 book = new Book2();
		book.setIsbn("PBN125");
		book.setName("Spring Recipes ");
		book.setPrice(30);
		book.setPublishDate(new Date());
		book.setPublisher("Apress");
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
		System.out.println(" ended ");
	}
	
	static void modifyBooks()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(" Started ");
		List<Book2> books = session.createQuery("from bookchapter10_1").list();
		if(books != null)
		{
			for(Book2 book:books)
			{
				book.setName("Spring Recipes updated");
				session.saveOrUpdate(book);
			}
		}
		
		tx.commit();
		session.close();
		System.out.println(" ended ");
	}

}
