package com.fsoft.bn.domain;

import java.util.List;

public class PublicNews {
	private String id;
	private String title;
	private String number;
	private String publisher;
	private String key;
	private String signer;
	private String publisher_date;
	private String effect_date;
	private String type;
	private String fields;
	private String quote;
	private List<String> attachUrlList;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSigner() {
		return signer;
	}

	public void setSigner(String signer) {
		this.signer = signer;
	}

	public String getPublisher_date() {
		return publisher_date;
	}

	public void setPublisher_date(String publisher_date) {
		this.publisher_date = publisher_date;
	}

	public String getEffect_date() {
		return effect_date;
	}

	public void setEffect_date(String effect_date) {
		this.effect_date = effect_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public List<String> getAttachUrlList() {
		return attachUrlList;
	}

	public void setAttachUrlList(List<String> attachUrlList) {
		this.attachUrlList = attachUrlList;
	}

	public PublicNews() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
