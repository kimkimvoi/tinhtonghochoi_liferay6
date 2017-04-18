package com.fsoft.bn.domain;

import java.util.Date;
import java.util.List;

public class OperatorSteering {
	private String id;
	private String title;
	private Date create_date;
	private String summary;
	private String timeStart;
	private String timeEnd;
	private String content;
	private List<String> attachUrlList;
	
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
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getAttachUrlList() {
		return attachUrlList;
	}
	public void setAttachUrlList(List<String> attachUrlList) {
		this.attachUrlList = attachUrlList;
	}
}
