/**
 * 
 */
package com.hibernaterecipes.chapter7;

/**
 * @author Guruzu
 *
 */
public class Chapter7_1 {
	
	
	private Long id;
	private Book7_1 book;
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
	
	public Book7_1 getBook() {
		return book;
	}
	public void setBook(Book7_1 book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "Chapter7_1 [book=" + book.getBookName() + ", id=" + id + ", noOfPages="
				+ noOfPages + ", title=" + title + "]";
	}
	
	

}
