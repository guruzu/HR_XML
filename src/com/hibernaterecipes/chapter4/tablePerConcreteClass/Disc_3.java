/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerConcreteClass;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public abstract class Disc_3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5119119376751110049L;
	
	private Long discId;
	private String name;
	private Integer price;
	public Long getDiscId() {
		return discId;
	}
	public void setDiscId(Long discId) {
		this.discId = discId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	

}
