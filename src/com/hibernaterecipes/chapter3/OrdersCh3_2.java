/**
 * 
 */
package com.hibernaterecipes.chapter3;

import com.hibernaterecipes.bookstore.Book;

/**
 * @author Guruzu
 *
 */
public class OrdersCh3_2 {
	
	private Long id;
	private Book book;
	private ContactCh3_2 weekdayContact;
	private ContactCh3_2 holidayContact;
	
	public OrdersCh3_2()
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
	 * @return the weekdayContact
	 */
	public ContactCh3_2 getWeekdayContact() {
		return weekdayContact;
	}

	/**
	 * @param weekdayContact the weekdayContact to set
	 */
	public void setWeekdayContact(ContactCh3_2 weekdayContact) {
		this.weekdayContact = weekdayContact;
	}

	/**
	 * @return the holidayContact
	 */
	public ContactCh3_2 getHolidayContact() {
		return holidayContact;
	}

	/**
	 * @param holidayContact the holidayContact to set
	 */
	public void setHolidayContact(ContactCh3_2 holidayContact) {
		this.holidayContact = holidayContact;
	}
	
	

}
