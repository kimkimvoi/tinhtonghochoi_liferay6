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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.BNNews;
import com.fsoft.bn.model.BNNewsModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BNNews service. Represents a row in the &quot;BN_BNNews&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.BNNewsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BNNewsImpl}.
 * </p>
 *
 * @author FSOFT
 * @see BNNewsImpl
 * @see com.fsoft.bn.model.BNNews
 * @see com.fsoft.bn.model.BNNewsModel
 * @generated
 */
public class BNNewsModelImpl extends BaseModelImpl<BNNews>
	implements BNNewsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a b n news model instance should use the {@link com.fsoft.bn.model.BNNews} interface instead.
	 */
	public static final String TABLE_NAME = "BN_BNNews";
	public static final Object[][] TABLE_COLUMNS = {
			{ "newsId", Types.BIGINT },
			{ "newsTitle", Types.VARCHAR },
			{ "newsContent", Types.VARCHAR },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_BNNews (newsId LONG not null primary key,newsTitle VARCHAR(255) null,newsContent STRING null,createdDate DATE null,modifiedDate DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_BNNews";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.BNNews"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.BNNews"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.BNNews"));

	public BNNewsModelImpl() {
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

	public Class<?> getModelClass() {
		return BNNews.class;
	}

	public String getModelClassName() {
		return BNNews.class.getName();
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
		if (_newsTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _newsTitle;
		}
	}

	public void setNewsTitle(String newsTitle) {
		_newsTitle = newsTitle;
	}

	public String getNewsContent() {
		if (_newsContent == null) {
			return StringPool.BLANK;
		}
		else {
			return _newsContent;
		}
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BNNews.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BNNews toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (BNNews)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		BNNewsImpl bnNewsImpl = new BNNewsImpl();

		bnNewsImpl.setNewsId(getNewsId());
		bnNewsImpl.setNewsTitle(getNewsTitle());
		bnNewsImpl.setNewsContent(getNewsContent());
		bnNewsImpl.setCreatedDate(getCreatedDate());
		bnNewsImpl.setModifiedDate(getModifiedDate());
		bnNewsImpl.setDeleted(getDeleted());

		bnNewsImpl.resetOriginalValues();

		return bnNewsImpl;
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

		BNNews bnNews = null;

		try {
			bnNews = (BNNews)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<BNNews> toCacheModel() {
		BNNewsCacheModel bnNewsCacheModel = new BNNewsCacheModel();

		bnNewsCacheModel.newsId = getNewsId();

		bnNewsCacheModel.newsTitle = getNewsTitle();

		String newsTitle = bnNewsCacheModel.newsTitle;

		if ((newsTitle != null) && (newsTitle.length() == 0)) {
			bnNewsCacheModel.newsTitle = null;
		}

		bnNewsCacheModel.newsContent = getNewsContent();

		String newsContent = bnNewsCacheModel.newsContent;

		if ((newsContent != null) && (newsContent.length() == 0)) {
			bnNewsCacheModel.newsContent = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			bnNewsCacheModel.createdDate = createdDate.getTime();
		}
		else {
			bnNewsCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			bnNewsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			bnNewsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		bnNewsCacheModel.deleted = getDeleted();

		return bnNewsCacheModel;
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

	private static ClassLoader _classLoader = BNNews.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			BNNews.class
		};
	private long _newsId;
	private String _newsTitle;
	private String _newsContent;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BNNews _escapedModelProxy;
}