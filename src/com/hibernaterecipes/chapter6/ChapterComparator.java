/**
 * 
 */
package com.hibernaterecipes.chapter6;

import java.util.Comparator;

/**
 * @author Guruzu
 *
 */
public class ChapterComparator implements Comparator<String> {
	
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		// if o1 and o2 don’t instantiate the same class, throw an exception
		// if o1 is less than o2, return a negative number
		// if o1 is equal to o2, return a zero
		// if o1 is greater than o2, return a positive number
		if(o1.compareTo(o2)<1)
		{
			return 1;
		}else 
		{
			return -1;
		}
		
	}

}
