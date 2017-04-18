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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BNNews}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNNews
 * @generated
 */
public class BNNewsWrapper implements BNNews, ModelWrapper<BNNews> {
	public BNNewsWrapper(BNNews bnNews) {
		_bnNews = bnNews;
	}

	public Class<?> getModelClass() {
		return BNNews.class;
	}

	public String getModelClassName() {
		return BNNews.class.getName();
	}

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

	/**
	* Returns the primary key of this b n news.
	*
	* @return the primary key of this b n news
	*/
	public long getPrimaryKey() {
		return _bnNews.getPrimaryKey();
	}

	/**
	* Sets the primary key of this b n news.
	*
	* @param primaryKey the primary key of this b n news
	*/
	public void setPrimaryKey(long primaryKey) {
		_bnNews.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the news ID of this b n news.
	*
	* @return the news ID of this b n news
	*/
	public long getNewsId() {
		return _bnNews.getNewsId();
	}

	/**
	* Sets the news ID of this b n news.
	*
	* @param newsId the news ID of this b n news
	*/
	public void setNewsId(long newsId) {
		_bnNews.setNewsId(newsId);
	}

	/**
	* Returns the news title of this b n news.
	*
	* @return the news title of this b n news
	*/
	public java.lang.String getNewsTitle() {
		return _bnNews.getNewsTitle();
	}

	/**
	* Sets the news title of this b n news.
	*
	* @param newsTitle the news title of this b n news
	*/
	public void setNewsTitle(java.lang.String newsTitle) {
		_bnNews.setNewsTitle(newsTitle);
	}

	/**
	* Returns the news content of this b n news.
	*
	* @return the news content of this b n news
	*/
	public java.lang.String getNewsContent() {
		return _bnNews.getNewsContent();
	}

	/**
	* Sets the news content of this b n news.
	*
	* @param newsContent the news content of this b n news
	*/
	public void setNewsContent(java.lang.String newsContent) {
		_bnNews.setNewsContent(newsContent);
	}

	/**
	* Returns the created date of this b n news.
	*
	* @return the created date of this b n news
	*/
	public java.util.Date getCreatedDate() {
		return _bnNews.getCreatedDate();
	}

	/**
	* Sets the created date of this b n news.
	*
	* @param createdDate the created date of this b n news
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_bnNews.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this b n news.
	*
	* @return the modified date of this b n news
	*/
	public java.util.Date getModifiedDate() {
		return _bnNews.getModifiedDate();
	}

	/**
	* Sets the modified date of this b n news.
	*
	* @param modifiedDate the modified date of this b n news
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bnNews.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this b n news.
	*
	* @return the deleted of this b n news
	*/
	public boolean getDeleted() {
		return _bnNews.getDeleted();
	}

	/**
	* Returns <code>true</code> if this b n news is deleted.
	*
	* @return <code>true</code> if this b n news is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _bnNews.isDeleted();
	}

	/**
	* Sets whether this b n news is deleted.
	*
	* @param deleted the deleted of this b n news
	*/
	public void setDeleted(boolean deleted) {
		_bnNews.setDeleted(deleted);
	}

	public boolean isNew() {
		return _bnNews.isNew();
	}

	public void setNew(boolean n) {
		_bnNews.setNew(n);
	}

	public boolean isCachedModel() {
		return _bnNews.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bnNews.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bnNews.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bnNews.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bnNews.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bnNews.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bnNews.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BNNewsWrapper((BNNews)_bnNews.clone());
	}

	public int compareTo(com.fsoft.bn.model.BNNews bnNews) {
		return _bnNews.compareTo(bnNews);
	}

	@Override
	public int hashCode() {
		return _bnNews.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.BNNews> toCacheModel() {
		return _bnNews.toCacheModel();
	}

	public com.fsoft.bn.model.BNNews toEscapedModel() {
		return new BNNewsWrapper(_bnNews.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bnNews.toString();
	}

	public java.lang.String toXmlString() {
		return _bnNews.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bnNews.persist();
	}

	public java.lang.String getDateToString() {
		return _bnNews.getDateToString();
	}

	public void setDateToString(java.lang.String dateToString) {
		_bnNews.setDateToString(dateToString);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public BNNews getWrappedBNNews() {
		return _bnNews;
	}

	public BNNews getWrappedModel() {
		return _bnNews;
	}

	public void resetOriginalValues() {
		_bnNews.resetOriginalValues();
	}

	private BNNews _bnNews;
}