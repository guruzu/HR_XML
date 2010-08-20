/**
 * 
 */
package com.hibernaterecipes.chapter8;

import java.util.Date;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;

import com.hibernaterecipes.bookstore.Book;
import com.hibernaterecipes.chapter2.BookCh2;


/**
 * @author Guruzu
 *
 */
public class Launch_8_1 { 
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
		//Statistics stats = sessionFactory.getStatistics();
		//stats.setStatisticsEnabled(true);
		Transaction tx = session.beginTransaction();
		
		String q1 = "from Book";
		String q2 = "select count(i) from Book i";
		String q3 = "select min(i.price),max(i.price) from Book i";
		org.hibernate.Query query = session.createQuery(q3);
		
		
		
		Criteria criteria = session.createCriteria(Book.class)
		.createAlias("publisher", "publisherAlias")
		.add(Restrictions.like("name", "%Hibernate%"))
		.add(Restrictions.eq("publisherAlias.name", "Manning"));
		List books = criteria.list();



		
		Object[] count = (Object[]) query.uniqueResult();
		System.out.println("count 0  "+count[0]);
		System.out.println("count 1 "+count[1]);
		
		
		
		
		
		
		
		
		
		/*for(int i =0;i<100;i++)
		{
			BookCh2 book = new BookCh2();
			book.setName("Book Name "+(i+1));
			book.setPrice(30+(2*i-1));
			book.setPublishDate(new Date());
			session.save(book);
		}*/
		tx.commit();
		//stats.getSessionOpenCount();
		//stats.logSummary();
		session.close();
		
	}

}
