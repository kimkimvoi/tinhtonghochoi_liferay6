package com.fsoft.bn.domain;

import java.io.Serializable;

public class AttachFileModel extends FileModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// store questionId or answerId
	private String documentId;	
	private String description;

	
	public AttachFileModel(long fileId, String title, String description, String url, String documentId) {
		this.fileId = fileId;
		this.title = title;
		this.description = description;
		this.url = url;
		this.documentId = documentId;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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
	
}
