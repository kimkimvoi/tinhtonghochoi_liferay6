package com.fsoft.bn.domain.alfresco;

import java.io.Serializable;

public class AlfWorkflowDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String url;
	private String name;
	private String title;
	private String description;
	private String version;
	
	public AlfWorkflowDefinition() {}
	
	public AlfWorkflowDefinition(String id, String url, String name, String title, String description, String version) {
		this.id = id;
		this.url = url;
		this.name = name;
		this.title = title;
		this.description = description;
		this.version = version;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
}
