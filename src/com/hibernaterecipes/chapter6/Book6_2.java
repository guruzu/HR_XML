/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author Guruzu
 *
 */
public class Book6_2 implements Serializable{
		
	private Long book_id;
	private String isbn;
	private String name;
	private Date publishDate;
	private Integer price;
	private Collection chapters=new ArrayList();
	
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
	public Collection getChapters() {
		return chapters;
	}
	public void setChapters(Collection chapters) {
		this.chapters = chapters;
	}
	
	
}
