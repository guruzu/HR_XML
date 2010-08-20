/**
 * 
 */
package com.hibernaterecipes.chapter4.tablePerSubClass;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class AudioDisc_2 extends Disc_2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1542177945025584005L;
	
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
	@Override
	public String toString() {
		return "AudioDisc_2 [noOfSongs=" + noOfSongs + ", singer=" + singer
				+ ", getDiscId()=" + getDiscId() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + "]";
	}
	
	
	
	

}
