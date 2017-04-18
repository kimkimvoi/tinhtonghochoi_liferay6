package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.List;

public class AdvertisementConfigModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PictureModel> pictures;
	private String durationTime;
	private String imageWidth;
	private String imageHeigh;
	private String portletId;

	public List<PictureModel> getPictures() {
		return pictures;
	}

	public void setPictures(List<PictureModel> pictures) {
		this.pictures = pictures;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}

	public String getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}

	public String getImageHeigh() {
		return imageHeigh;
	}

	public void setImageHeigh(String imageHeigh) {
		this.imageHeigh = imageHeigh;
	}

	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}

}
