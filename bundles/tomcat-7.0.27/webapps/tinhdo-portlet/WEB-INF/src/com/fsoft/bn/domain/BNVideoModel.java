/**
 * 
 */
package com.fsoft.bn.domain;

import java.io.Serializable;

/**
 * This class using handle video on jsp
 * 
 * @author VangND1
 * 
 */
public class BNVideoModel extends FileModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * image thums
	 */
	private String imageThums;

	/**
	 * default constructor
	 */
	public BNVideoModel() {
	}

	/**
	 * @return the imageThums
	 */
	public String getImageThums() {
		return imageThums;
	}

	/**
	 * @param imageThums the imageThums to set
	 */
	public void setImageThums(String imageThums) {
		this.imageThums = imageThums;
	}

}
