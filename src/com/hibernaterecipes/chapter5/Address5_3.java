/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class Address5_3 implements Serializable{
	
	private static final long serialVersionUID = -605474766287314591L;
	private Long addressId;
	private String city;
	private String street;
	private String doorplate;
	private Customer5_3 customer;
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long id) {
		this.addressId = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDoorplate() {
		return doorplate;
	}
	public void setDoorplate(String doorplate) {
		this.doorplate = doorplate;
	}
	public Customer5_3 getCustomer() {
		return customer;
	}
	public void setCustomer(Customer5_3 customer) {
		this.customer = customer;
	}
	
	
}
