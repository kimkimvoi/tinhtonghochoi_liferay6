package com.fsoft.bn.portlet.booklibrary;

public class BookModel {
	private String id;
	private String author;
	private String title;
	private String category;
	private String coverUrl;
	private String bookUrl;
	
	public BookModel() {}
	
	public BookModel(String id, String author, String title, String category, String coverUrl, String bookUrl) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.category = category;
		this.coverUrl = coverUrl;
		this.bookUrl = bookUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCoverUrl() {
		return coverUrl;
	}
	
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
}
