/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import com.hibernaterecipes.bookstore.Book;

/**
 * @author Guruzu
 *
 */
public class OrdersCh4_5 {
	
	private Long id;
	private Book book;
	private ContactCh4_5 weekdayContact;
	private ContactCh4_5 holidayContact;
	
	public OrdersCh4_5()
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
	public ContactCh4_5 getWeekdayContact() {
		return weekdayContact;
	}

	/**
	 * @param weekdayContact the weekdayContact to set
	 */
	public void setWeekdayContact(ContactCh4_5 weekdayContact) {
		this.weekdayContact = weekdayContact;
	}

	/**
	 * @return the holidayContact
	 */
	public ContactCh4_5 getHolidayContact() {
		return holidayContact;
	}

	/**
	 * @param holidayContact the holidayContact to set
	 */
	public void setHolidayContact(ContactCh4_5 holidayContact) {
		this.holidayContact = holidayContact;
	}
	
	

}
