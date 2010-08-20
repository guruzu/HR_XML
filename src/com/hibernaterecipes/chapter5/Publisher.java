/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class Publisher implements Serializable{
	
	private Long publisher_id;
	private String code;
	private String name;
	private String address;
	
	public Long getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(Long publisherId) {
		publisher_id = publisherId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
