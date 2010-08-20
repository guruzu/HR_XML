/**
 * 
 */
package com.hibernaterecipes.chapter3;

import com.hibernaterecipes.chapter2.BookCh2;

/**
 * @author Guruzu
 *
 */
public class Orders {
	
	private Long id;
	private BookCh2 book;
	private String weekdayRecipient;
	private String weekdayPhone;
	private String weekdayAddress;
	private String holidayRecipient;
	private String holidayPhone;
	private String holidayAddress;
	
	public Orders()
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
	public BookCh2 getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(BookCh2 book) {
		this.book = book;
	}
	/**
	 * @return the weekdayRecipient
	 */
	public String getWeekdayRecipient() {
		return weekdayRecipient;
	}
	/**
	 * @param weekdayRecipient the weekdayRecipient to set
	 */
	public void setWeekdayRecipient(String weekdayRecipient) {
		this.weekdayRecipient = weekdayRecipient;
	}
	/**
	 * @return the weekdayPhone
	 */
	public String getWeekdayPhone() {
		return weekdayPhone;
	}
	/**
	 * @param weekdayPhone the weekdayPhone to set
	 */
	public void setWeekdayPhone(String weekdayPhone) {
		this.weekdayPhone = weekdayPhone;
	}
	/**
	 * @return the weekdayAddress
	 */
	public String getWeekdayAddress() {
		return weekdayAddress;
	}
	/**
	 * @param weekdayAddress the weekdayAddress to set
	 */
	public void setWeekdayAddress(String weekdayAddress) {
		this.weekdayAddress = weekdayAddress;
	}
	/**
	 * @return the holidayRecipient
	 */
	public String getHolidayRecipient() {
		return holidayRecipient;
	}
	/**
	 * @param holidayRecipient the holidayRecipient to set
	 */
	public void setHolidayRecipient(String holidayRecipient) {
		this.holidayRecipient = holidayRecipient;
	}
	/**
	 * @return the holidayPhone
	 */
	public String getHolidayPhone() {
		return holidayPhone;
	}
	/**
	 * @param holidayPhone the holidayPhone to set
	 */
	public void setHolidayPhone(String holidayPhone) {
		this.holidayPhone = holidayPhone;
	}
	/**
	 * @return the holidayAddress
	 */
	public String getHolidayAddress() {
		return holidayAddress;
	}
	/**
	 * @param holidayAddress the holidayAddress to set
	 */
	public void setHolidayAddress(String holidayAddress) {
		this.holidayAddress = holidayAddress;
	}
	
	

}
