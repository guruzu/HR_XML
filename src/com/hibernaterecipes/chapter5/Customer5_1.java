/**
 * 
 */
package com.hibernaterecipes.chapter5;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class Customer5_1 implements Serializable {

	private static final long serialVersionUID = -3534434932962734600L;
	private Long id;
	private String countryCode;
	private String idCardNo;
	private String firstName;
	private String lastName;
	private Address5_1 address;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address5_1 getAddress() {
		return address;
	}
	public void setAddress(Address5_1 address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
