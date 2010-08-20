/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Guruzu
 *
 */
public class Book6_1 implements Serializable{
		
	private Long book_id;
	private String isbn;
	private String name;
	private Date publishDate;
	private Integer price;
	private Set chapters = new TreeSet();
	
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
	public Set getChapters() {
		return chapters;
	}
	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}
	
	
}
