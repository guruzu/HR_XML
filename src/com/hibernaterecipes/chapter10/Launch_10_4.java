/**
 * 
 */
package com.hibernaterecipes.chapter10;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.FilterDefinition;


/**
 * @author Guruzu
 *
 */
public class Launch_10_4 { 
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
		//insertRanks();
		//insertBooks();
		fetchKidsbooks(new Long(2),new Long(3));
	}
	
	static void fetchKidsbooks(Long userRank,Long requestedRank)
	{
		Session session = getSession();
		Filter filter = session.enableFilter("filterByRank");
		filter.setParameter("currentRank", userRank);
		filter.setParameter("requestedRank", requestedRank);
		List<Book> books = session.createQuery("from bookchapter10 where userRank<="+requestedRank.toString()).list();
		if(books != null)
		{
			for(Book book:books)
			{
				System.out.println("Name "+book.getName());
			}
		}
	}
	
	static void insertRanks()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(" Started ");
		UserRank userRank = new UserRank();
		userRank.setRank(new Long(1));
		userRank.setUserType("kid");
		session.saveOrUpdate(userRank);
		tx.commit();
		session.close();
		System.out.println(" ended ");
	}
	
	static void insertBooks()
	{
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		System.out.println(" Started ");
		Book book = new Book();
		UserRank userRank = (UserRank) session.get(UserRank.class, new Long(1));
		 
		book.setIsbn("PBN128");
		book.setName("Spring Recipes for kids");
		book.setPrice(30);
		book.setPublishDate(new Date());
		book.setPublisher("Apress");
		//book.setUserRank(userRank);
		//book.setUserRank(1);
		session.saveOrUpdate(book);
		tx.commit();
		session.close();
		System.out.println(" ended ");
	}

}
