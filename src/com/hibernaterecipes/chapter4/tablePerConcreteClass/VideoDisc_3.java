/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerConcreteClass;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class VideoDisc_3 extends Disc_3 implements Serializable {

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
	
	

}
