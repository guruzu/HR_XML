/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerConcreteClass;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class AudioDisc3 extends Disc_3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8314602929677976050L;
	
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
