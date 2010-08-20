/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerClassHierarchy;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class VideoDisc extends Disc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6857479057343664829L;
	
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
		return "VideoDisc [director=" + director + ", language=" + language
				+ ", getDiscId()=" + getDiscId() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
	

}
