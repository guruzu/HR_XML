/**
 * 
 */
package com.hibernaterecipes.chapter7;

import java.util.Date;
import java.util.Set;

/**
 * @author Guruzu   
 *
 */

public class Book7_1 {

	private Long book_id;
	
	private String isbn;
	
	private String bookName;
	
	private Date publishDate;
	
	private Integer price;
	
	private Set chapters;
	
	/**
	 * @return the chapters
	 */
	public Set getChapters() {
		return chapters;
	}
	/**
	 * @param chapters the chapters to set
	 */
	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}
	
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long bookId) {
		book_id = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Book7_1 [bookName=" + bookName + ", book_id=" + book_id
				+ ", chapters=" + chapters + ", isbn=" + isbn + ", price="
				+ price + ", publishDate=" + publishDate + "]";
	}
	
	public void addChapter(Chapter7_1 chapter)
	{
		chapter.setBook(this);
		chapters.add(chapter);
	}
}
