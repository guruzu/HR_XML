/**
 * 
 */
package com.hibernaterecipes.otherrequests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Guruzu
 *
 */
public class Launch { 
	static
	{
		//PropertyConfigurator.configure("D:/dev/HR_XML/bin/log4j.properties");
		
	}
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
		Logger logger = LoggerFactory.getLogger(Launch.class);
	    logger.debug("MainLaunch ");
	    
		Session session = getSession();
		
		Transaction tx = session.beginTransaction();
		/*Product product = new Product();
		product.setProductName("Product 13");*/
		
		//Product parentProduct = (Product)session.get(Product.class, new Integer(1));
		//System.out.println(parentProduct);
		
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.eq("productId", new Integer(1)));
		//crit.uniqueResult();
		
		List<Product> products = crit.list();
		for(Product prod:products)
		{
			System.out.println(prod);
			/*if(prod.getProductId().equals(new Integer(131072)))
				product.setParentProduct(prod);*/
		}
		/*session.save(product);
		tx.commit();*/
		
		
		session.close();
		
	}

}
