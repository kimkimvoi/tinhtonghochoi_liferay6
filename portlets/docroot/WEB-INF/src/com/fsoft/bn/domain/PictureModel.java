package com.fsoft.bn.domain;

import java.io.Serializable;

public class PictureModel extends FileModel implements Serializable {
	/**
	 * default serial
	 */
	private static final long serialVersionUID = 1L;
	private boolean display;
	private String link;

	public PictureModel() {
		this.display = false;
	}
	
	public PictureModel(long fileId, String title, String url) {
		this.fileId = fileId;
		this.title = title;
		this.url = url;
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

	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public boolean getDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
