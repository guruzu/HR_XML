/**
 * 
 */
package com.hibernaterecipes.chapter7;

import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.stat.Statistics;


/**
 * @author Guruzu
 *
 */
public class Launch_7_1 { 
	
	private static Logger log = LoggerFactory.getLogger( Launch_7_1.class );
	private static SessionFactory sessionFactory;  
	  
	public static Session getSession() {
		if(sessionFactory == null)
		{
			try { 
				sessionFactory = new Configuration().configure()
				.buildSessionFactory();
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		Session hibernateSession = sessionFactory.openSession();  
		return hibernateSession;  
	}
	
 
	/*public static void main(String[] args) {
		log.debug("In main----------------------------------------");
		System.out.println("In main sop -------------------------");
		Session session = getSession();
		Statistics stats = sessionFactory.getStatistics();

		Transaction tx = session.beginTransaction();

		Book7_1 book = new Book7_1();
		book.setIsbn("234234wef2323");
		book.setBookName("Hibernate Recipes ");
		book.setPrice(79l);
		book.setPublishDate(new Date());
		//session.save(book);
		
		Chapter7_1 chapter = new Chapter7_1();
		//chapter.setBook_id(book.getBook_id());
		chapter.setBook(book);
		chapter.setNoOfPages(10);
		chapter.setTitle("One-To-Many Association");
		Chapter7_1 chapter1 = new Chapter7_1();
		chapter1.setBook(book);
		chapter1.setNoOfPages(15);
		chapter1.setTitle("Many-To-Many Association");
		//session.save(chapter);
		//session.save(chapter1);
		Set chapters = new HashSet<Chapter7_1>();
		chapters.add(chapter);
		chapters.add(chapter1);
		book.setChapters(chapters);
		session.saveOrUpdate(book);
		Query query = session.createQuery("from com.hibernaterecipes.chapter7.Book7_1");
		Book7_1 bookResult = null;
		List<Book7_1> results = query.list();
		for (int i=0; i< results.size(); i++) {
			bookResult = results.get(i);
			Set chaptersRes = bookResult.getChapters();
			Iterator iter = chaptersRes.iterator();
			while(iter.hasNext()) {
				Chapter7_1 chap = (Chapter7_1) iter.next();
				System.out.println("Chapter id - " + chap.getId());
				System.out.println("Chapter name - " + chap.getTitle());
			}
			
		}
		System.out.println("getBookName - " + bookResult.getBookName());
		//session.delete(book);
		tx.commit();

		session.close();
	}*/
	/*public static void main(String[] args) {
		Chapter id - 819200
		Chapter name - Many-To-Many Association
		Chapter id - 819201
		Chapter name - One-To-Many Association
		getBookName - Hibernate Recipes 
		Session session = getSession();
		Query query = session.createQuery("from com.hibernaterecipes.chapter7.Book7_1");
		Book7_1 bookResult = null;
		List<Book7_1> results = query.list();
		for (int i=0; i< results.size(); i++) {
			bookResult = results.get(i);
			Set chaptersRes = bookResult.getChapters();
			Iterator iter = chaptersRes.iterator();
			while(iter.hasNext()) {
				Chapter7_1 chap = (Chapter7_1) iter.next();
				System.out.println("Chapter id - " + chap.getId());
				System.out.println("Chapter name - " + chap.getTitle());
			}
			
		}
	}*/
	
	/*public static void main(String[] args) {
		
		Session session = getSession();
		Query query = session.createQuery("from com.hibernaterecipes.chapter7.Chapter7_1");
		Chapter7_1 chapter=null;
		List<Chapter7_1> results = query.list();
		for (int i=0; i< results.size(); i++) {
			chapter = results.get(i);
			String bookName = chapter.getBook().getBookName();
			System.out.print(chapter.getTitle()+" - ");
			System.out.print(bookName);
			System.out.println(" ");
		}
		
		Chapter7_1 chapter = (Chapter7_1)session.load(com.hibernaterecipes.chapter7.Chapter7_1.class, new Integer(819200));
		
	}*/
	
	/*public static void main(String[] args) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Book7_1 book = (Book7_1)session.load(com.hibernaterecipes.chapter7.Book7_1.class, new Long(786432));
		System.out.println(book);
		Chapter7_1 chapter = new Chapter7_1();
		book.setBookName("Hibenrate 3");
		chapter.setNoOfPages(15);
		chapter.setTitle("Object States 2");
		chapter.setBook(book);
		book.getChapters().add(chapter);
		session.saveOrUpdate(chapter);
		tx.commit();
		session.flush();
	}*/
	
	/*public static void main(String[] args) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String userInput="Hibenrate 3";
		//String q="from Book7_1 book where book.bookName='Hibenrate 3' and size(book.chapters)>4";
		String q="from Book7_1 book where book.bookName='"+userInput+"'";
		Query query = session.createQuery(q);
		List books = query.list();
		if(books!=null)
		{
			Iterator it = books.iterator();
			while(it.hasNext())
			{
				Book7_1 book = (Book7_1)it.next();
				System.out.println("Book "+book);
			}
			
		}
		
	}*/
	
	/*public static List exampleSQLInjection(String userInput)
	{
		Session session = getSession();
		String q="from Book7_1 book where book.bookName='"+userInput+"'";
		Query query = session.createQuery(q);
		List books = query.list();
		return books;
	}
	public static void main(String[] args) {
		
		//List books = testSQLInjection("Hibenrate 3");
		List books = exampleSQLInjection("Hibenrate 3' or 'x'='x");
		if(books!=null)
		{
			System.out.println("Size- "+books.size());
			Iterator it = books.iterator();
			while(it.hasNext())
			{
				System.out.println("book- "+it.next());
			}
		}
	}*/
	/*public static void main(String[] args) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String q="select new map(book.isbn,book.bookName) from Book7_1 book";
		Query query = session.createQuery(q);
		List books = query.list();
		
		if(books!=null)
		{
			System.out.println("Size- "+books.size());
			Iterator it = books.iterator();
			while(it.hasNext())
			{
				Map book = (Map)it.next();
				Set bookSet = book.keySet();
				Iterator listIt = bookSet.iterator();
				while(listIt.hasNext())
				{
					String key = (String)listIt.next();
					System.out.println("Inside chapter{ Key- "+key+" },{ Value- "+book.get(key)+"}");
					
				}
				System.out.println(" ");
			}
		}
	}*/
	
	/*public static void main(String[] args) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		//String q="from Book7_1 book join book.chapters chapter where chapter.title=:title";// where book.chapters.title=:title";
		String q="from Book7_1 book where book.chapters.title=:title";
		Query query = session.createQuery(q);
		query.setString("title", "Many-To-Many Association");
		List books = query.list();
		
		if(books!=null)
		{
			System.out.println("Size- "+books.size());
			Iterator it = books.iterator();
			while(it.hasNext())
			{
				Object[] book= (Object[])it.next();
				System.out.println(book);
			}
		}
	}*/
	
	
	

}
