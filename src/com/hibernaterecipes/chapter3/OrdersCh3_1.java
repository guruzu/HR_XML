/**
 * 
 */
package com.hibernaterecipes.chapter3;

import com.hibernaterecipes.bookstore.Book;

/**
 * @author Guruzu
 *
 */
public class OrdersCh3_1 {
	
	private Long id;
	private Book book;
	private Contact weekdayContact;
	private Contact holidayContact;
	
	public OrdersCh3_1()
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
	public Contact getWeekdayContact() {
		return weekdayContact;
	}

	/**
	 * @param weekdayContact the weekdayContact to set
	 */
	public void setWeekdayContact(Contact weekdayContact) {
		this.weekdayContact = weekdayContact;
	}

	/**
	 * @return the holidayContact
	 */
	public Contact getHolidayContact() {
		return holidayContact;
	}

	/**
	 * @param holidayContact the holidayContact to set
	 */
	public void setHolidayContact(Contact holidayContact) {
		this.holidayContact = holidayContact;
	}
	
	

}
