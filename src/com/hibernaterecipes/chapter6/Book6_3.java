/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Guruzu
 *
 */
public class Book6_3 implements Serializable{
		
	private Long book_id;
	private String isbn;
	private String name;
	private Date publishDate;
	private Integer price;
	private List chapters;
	
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
	public List getChapters() {
		return chapters;
	}
	public void setChapters(List chapters) {
		this.chapters = chapters;
	}
	
	
}
