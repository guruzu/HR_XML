/**
 * 
 */
package com.hibernaterecipes.chapter3;

import java.util.Set;

import com.hibernaterecipes.bookstore.Book;

/**
 * @author Guruzu
 *
 */
public class OrdersCh3_4_1 {
	
	private Long id;
	private Book book;
	private Set contacts;
	
	
	public OrdersCh3_4_1()
	{
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the contacts
	 */
	public Set getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

	
	

}
