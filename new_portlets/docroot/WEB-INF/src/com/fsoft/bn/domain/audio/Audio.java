package com.fsoft.bn.domain.audio;

import java.io.Serializable;

/**
 * This is model class of Audio
 * @author VangND1
 *
 */
public class Audio implements Serializable {
	/**
	 * Generated serial version.
	 */
	private static final long serialVersionUID = 2241296416917496049L;
	/**
	 * DLFile id
	 */
	private String id;
	/**
	 * Author of audio
	 */
	private String author;
	/**
	 * Title of audio
	 */
	private String title;
	/**
	 * Category of audio
	 */
	private String category;
	/**
	 * URL file path audio
	 */
	private String url;
	
	/**
	 * Default constructor
	 */
	public Audio() {
	}
	/**
	 * Constructor with custom parameter
	 * @param author
	 * @param title
	 * @param url
	 */
	public Audio(String id, String author, String title, String url , String category) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.url = url;
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
