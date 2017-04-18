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

import com.fsoft.bn.service.BNNewsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class BNNewsClp extends BaseModelImpl<BNNews> implements BNNews {
	public BNNewsClp() {
	}

	public Class<?> getModelClass() {
		return BNNews.class;
	}

	public String getModelClassName() {
		return BNNews.class.getName();
	}

	public long getPrimaryKey() {
		return _newsId;
	}

	public void setPrimaryKey(long primaryKey) {
		setNewsId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_newsId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsId", getNewsId());
		attributes.put("newsTitle", getNewsTitle());
		attributes.put("newsContent", getNewsContent());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsId = (Long)attributes.get("newsId");

		if (newsId != null) {
			setNewsId(newsId);
		}

		String newsTitle = (String)attributes.get("newsTitle");

		if (newsTitle != null) {
			setNewsTitle(newsTitle);
		}

		String newsContent = (String)attributes.get("newsContent");

		if (newsContent != null) {
			setNewsContent(newsContent);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
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

	public void setDateToString(java.lang.String dateToString) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getDateToString() {
		throw new UnsupportedOperationException();
	}

	public BaseModel<?> getBNNewsRemoteModel() {
		return _bnNewsRemoteModel;
	}

	public void setBNNewsRemoteModel(BaseModel<?> bnNewsRemoteModel) {
		_bnNewsRemoteModel = bnNewsRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BNNewsLocalServiceUtil.addBNNews(this);
		}
		else {
			BNNewsLocalServiceUtil.updateBNNews(this);
		}
	}

	@Override
	public BNNews toEscapedModel() {
		return (BNNews)Proxy.newProxyInstance(BNNews.class.getClassLoader(),
			new Class[] { BNNews.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BNNewsClp clone = new BNNewsClp();

		clone.setNewsId(getNewsId());
		clone.setNewsTitle(getNewsTitle());
		clone.setNewsContent(getNewsContent());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(BNNews bnNews) {
		long primaryKey = bnNews.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BNNewsClp bnNews = null;

		try {
			bnNews = (BNNewsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = bnNews.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{newsId=");
		sb.append(getNewsId());
		sb.append(", newsTitle=");
		sb.append(getNewsTitle());
		sb.append(", newsContent=");
		sb.append(getNewsContent());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.BNNews");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>newsId</column-name><column-value><![CDATA[");
		sb.append(getNewsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsTitle</column-name><column-value><![CDATA[");
		sb.append(getNewsTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsContent</column-name><column-value><![CDATA[");
		sb.append(getNewsContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _newsId;
	private String _newsTitle;
	private String _newsContent;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BaseModel<?> _bnNewsRemoteModel;
}