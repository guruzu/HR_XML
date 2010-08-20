/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import com.hibernaterecipes.chapter3.Address;

/**
 * @author Guruzu
 *
 */
public class ContactCh4_5 {
	private String recipient;
	private PhoneCh4_4 phone;
	private Address address;
	
	public ContactCh4_5()
	{
		
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the phone
	 */
	public PhoneCh4_4 getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(PhoneCh4_4 phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
