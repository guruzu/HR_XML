/**
 * 
 */
package com.hibernaterecipes.chapter8;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernaterecipes.chapter2.BookCh2;
import com.hibernaterecipes.chapter7.Book7_1;
import com.hibernaterecipes.chapter7.Chapter7_1;


/**
 * @author Guruzu
 *
 */
public class Launch_8_2 { 
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
		
		//Transaction tx = session.beginTransaction();
		
		
		//org.hibernate.Query query = session.createQuery("from Book7_1 " +
		//		"book where book.chapters.title like 'Many-%'");
		//query.setLong(0, 520);
		//Book7_1 book71 = (Book7_1) query.uniqueResult();
		//System.out.println(book71);
		String QueryString1 = "from Book7_1 book join book.chapters chapter " +
				"where chapter.title = 'Many-To-Many Association'";
		String QueryString3 = "from Book7_1 book " +
				"where book.chapters.title = 'Many-To-Many Association'";
		
		String QueryString4 = "from Book7_1 book where book.chapters is not null";
		String QueryString5 = "from Book7_1 book where book.bookName is not null";
		String QueryString6 = "from Book7_1 book where book.chapters is not empty";
		String QueryString2 = "from Chapter7_1 " +
						"ch where ch.book.bookName like 'Hib%'";
		org.hibernate.Query query1 = session.createQuery(QueryString4);
		List<Chapter7_1> chptrs = query1.list();
		
		if(chptrs!= null && !chptrs.isEmpty())
		{
			System.out.println("ch71 "+ chptrs.get(0));
		}
		

		//tx.commit();
		
		session.close();
		
	}

}
