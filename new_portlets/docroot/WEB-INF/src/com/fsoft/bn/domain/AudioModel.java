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
public class AudioModel extends FileModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7484570856973578109L;
	/**
	 * author
	 */
	private String author;
	private String category;
	/**
	 * Default constructor
	 */
	public AudioModel() {
	}
	/**
	 * 
	 */
	public AudioModel(long fileId, String title, String url) {
		super(fileId, title, url);
	}
	/**
	 * 
	 * @param fileId 
	 * @param title 
	 */
	public AudioModel(long fileId, String title) {
		super(fileId, title);
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
}
