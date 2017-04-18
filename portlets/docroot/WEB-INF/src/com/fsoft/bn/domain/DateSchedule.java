package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.Date;

public class DateSchedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String content;
	
	public DateSchedule(Date date, String content) {
		this.setDate(date);
		this.setContent(content);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
