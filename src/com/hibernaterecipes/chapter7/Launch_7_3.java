/**
 * 
 */
package com.hibernaterecipes.chapter7;

import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
public class Launch_7_3 { 
	
	private static Logger log = LoggerFactory.getLogger( Launch_7_3.class );
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
	
 
	public static void main(String[] args) {
		log.debug("In main----------------------------------------");
		System.out.println("In main sop -------------------------");
		Session session = getSession();
		Statistics stats = sessionFactory.getStatistics();

		Transaction tx = session.beginTransaction();

		Book7_3 book = new Book7_3();
		book.setIsbn("234234wef2323");
		book.setBookName("Hibernate Recipes ");
		book.setPrice(79l);
		book.setPublishDate(new Date());
		//session.save(book);
		
		Chapter7_3 chapter = new Chapter7_3();
		//chapter.setBook_id(book.getBook_id());
		//chapter.setIsbn(book.getIsbn());
		chapter.setNoOfPages(10);
		chapter.setTitle("One-To-Many Association");
		Chapter7_3 chapter1 = new Chapter7_3();
		//chapter1.setIsbn(book.getIsbn());
		chapter1.setNoOfPages(15);
		chapter1.setTitle("Many-To-Many Association");
		//session.save(chapter);
		//session.save(chapter1);
		Set chapters = new HashSet<Chapter7_3>();
		chapters.add(chapter);
		
		book.setChapters(chapters);
		session.saveOrUpdate(book);
		/*Query query = session.createQuery("from com.hibernaterecipes.chapter7.Book7_1");
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
		System.out.println("getBookName - " + bookResult.getBookName());*/
		//session.delete(book);
		tx.commit();

		session.close();
	}

}
