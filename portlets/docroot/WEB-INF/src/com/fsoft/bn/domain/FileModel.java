package com.fsoft.bn.domain;

import java.io.Serializable;

public class FileModel implements Serializable {

	private static final long serialVersionUID = 1L;
	protected long fileId;
	protected String title;
	protected String url;
	protected String viewCount;
	
	public FileModel() {}
	
	public FileModel(long fileId, String title) {
		this.fileId = fileId;
		this.title = title;
	}
	
	public FileModel(long fileId, String title, String url) {
		this.fileId = fileId;
		this.title = title;
		this.url = url;
	}

	@Override
	public String toString() {
		return fileId + ":" + title + ":" + url;
	}
	
	public String toTreeView() {
		return "<li><span class=\"file\" onclick='clickFile(" + fileId + ")'>" + title + "</span></li>";
	}
	
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
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

	/**
	 * @return the viewCount
	 */
	public String getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	

}
