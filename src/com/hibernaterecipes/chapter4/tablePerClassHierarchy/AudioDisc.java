/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerClassHierarchy;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class AudioDisc extends Disc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -761204256335489047L;
	
	private Integer noOfSongs;
	private String singer;
	public Integer getNoOfSongs() {
		return noOfSongs;
	}
	public void setNoOfSongs(Integer noOfSongs) {
		this.noOfSongs = noOfSongs;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	

}
