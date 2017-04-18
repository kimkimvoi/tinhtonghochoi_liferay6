package com.fsoft.bn.domain;

public class AnalyticViewMode {
	/**
	 * 
	 */
	String id;
	String title;
	String content;
	String solieu;
	String viewMode;

	public String getViewMode() {
		return viewMode;
	}
	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSolieu() {
		return solieu;
	}
	public void setSolieu(String solieu) {
		this.solieu = solieu;
	}
	public AnalyticViewMode() {
		super();
	}
}
