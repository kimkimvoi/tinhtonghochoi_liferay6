package com.fsoft.bn.domain;

public class MarketInfo {
	private String marketInfoId;
	private String title;
	private String imageURL;
	private String summary;
	private String content;
	private String createdDate;
	private String detailUrl;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getMarketInfoId() {
		return marketInfoId;
	}

	public void setMarketInfoId(String marketInfoId) {
		this.marketInfoId = marketInfoId;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
}