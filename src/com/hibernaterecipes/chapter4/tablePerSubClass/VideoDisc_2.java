/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerSubClass;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class VideoDisc_2 extends Disc_2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3052184294723526581L;
	
	private String director;
	private String language;
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "VideoDisc_2 [director=" + director + ", language=" + language
				+ ", getDiscId()=" + getDiscId() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
	

}
