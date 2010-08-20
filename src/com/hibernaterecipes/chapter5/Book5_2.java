/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Guruzu
 *
 */
public class Book5_2 implements Serializable{
		
	private Long book_id;
	private String isbn;
	private String name;
	private Publisher5_2 publisher;
	private Date publishDate;
	private Integer price;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher5_2 getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher5_2 publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
