/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fsoft.bn.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    FSOFT
 * @generated
 */
public class BNNewsSoap implements Serializable {
	public static BNNewsSoap toSoapModel(BNNews model) {
		BNNewsSoap soapModel = new BNNewsSoap();

		soapModel.setNewsId(model.getNewsId());
		soapModel.setNewsTitle(model.getNewsTitle());
		soapModel.setNewsContent(model.getNewsContent());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static BNNewsSoap[] toSoapModels(BNNews[] models) {
		BNNewsSoap[] soapModels = new BNNewsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BNNewsSoap[][] toSoapModels(BNNews[][] models) {
		BNNewsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BNNewsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BNNewsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BNNewsSoap[] toSoapModels(List<BNNews> models) {
		List<BNNewsSoap> soapModels = new ArrayList<BNNewsSoap>(models.size());

		for (BNNews model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BNNewsSoap[soapModels.size()]);
	}

	public BNNewsSoap() {
	}

	public long getPrimaryKey() {
		return _newsId;
	}

	public void setPrimaryKey(long pk) {
		setNewsId(pk);
	}

	public long getNewsId() {
		return _newsId;
	}

	public void setNewsId(long newsId) {
		_newsId = newsId;
	}

	public String getNewsTitle() {
		return _newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		_newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return _newsContent;
	}

	public void setNewsContent(String newsContent) {
		_newsContent = newsContent;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private long _newsId;
	private String _newsTitle;
	private String _newsContent;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _deleted;
}