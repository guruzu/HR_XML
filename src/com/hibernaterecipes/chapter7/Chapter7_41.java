/**
 * 
 */
package com.hibernaterecipes.chapter7;

import java.util.Set;

/**
 * @author Guruzu
 *
 */
public class Chapter7_41 {
	
	private Long id;
	private Set book;
	private String title;
	private int noOfPages;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the numOfPages
	 */
	public int getNoOfPages() {
		return noOfPages;
	}
	/**
	 * @param numOfPages the numOfPages to set
	 */
	public void setNoOfPages(int numOfPages) {
		this.noOfPages = numOfPages;
	}
	
	public Set getBook() {
		return book;
	}
	public void setBook(Set book) {
		this.book = book;
	}
	
	
	
	

}
