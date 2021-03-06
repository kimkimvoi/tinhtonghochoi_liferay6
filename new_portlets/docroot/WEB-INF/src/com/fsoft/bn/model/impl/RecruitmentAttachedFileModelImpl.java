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

import com.fsoft.bn.model.RecruitmentAttachedFile;
import com.fsoft.bn.model.RecruitmentAttachedFileModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RecruitmentAttachedFile service. Represents a row in the &quot;BN_RecruitmentAttachedFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.RecruitmentAttachedFileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecruitmentAttachedFileImpl}.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentAttachedFileImpl
 * @see com.fsoft.bn.model.RecruitmentAttachedFile
 * @see com.fsoft.bn.model.RecruitmentAttachedFileModel
 * @generated
 */
public class RecruitmentAttachedFileModelImpl extends BaseModelImpl<RecruitmentAttachedFile>
	implements RecruitmentAttachedFileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a recruitment attached file model instance should use the {@link com.fsoft.bn.model.RecruitmentAttachedFile} interface instead.
	 */
	public static final String TABLE_NAME = "BN_RecruitmentAttachedFile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "recruitment_attached_id", Types.VARCHAR },
			{ "recruitment_id", Types.VARCHAR },
			{ "attached_file_id", Types.VARCHAR },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_RecruitmentAttachedFile (recruitment_attached_id VARCHAR(75) not null primary key,recruitment_id VARCHAR(75) null,attached_file_id VARCHAR(75) null,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_RecruitmentAttachedFile";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.RecruitmentAttachedFile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.RecruitmentAttachedFile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.RecruitmentAttachedFile"));

	public RecruitmentAttachedFileModelImpl() {
	}

	public String getPrimaryKey() {
		return _recruitment_attached_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_attached_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_attached_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return RecruitmentAttachedFile.class;
	}

	public String getModelClassName() {
		return RecruitmentAttachedFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_attached_id", getRecruitment_attached_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("attached_file_id", getAttached_file_id());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_attached_id = (String)attributes.get(
				"recruitment_attached_id");

		if (recruitment_attached_id != null) {
			setRecruitment_attached_id(recruitment_attached_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String attached_file_id = (String)attributes.get("attached_file_id");

		if (attached_file_id != null) {
			setAttached_file_id(attached_file_id);
		}

		Date created_date = (Date)attributes.get("created_date");

		if (created_date != null) {
			setCreated_date(created_date);
		}

		Date modified_date = (Date)attributes.get("modified_date");

		if (modified_date != null) {
			setModified_date(modified_date);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	public String getRecruitment_attached_id() {
		if (_recruitment_attached_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _recruitment_attached_id;
		}
	}

	public void setRecruitment_attached_id(String recruitment_attached_id) {
		_recruitment_attached_id = recruitment_attached_id;
	}

	public String getRecruitment_id() {
		if (_recruitment_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _recruitment_id;
		}
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getAttached_file_id() {
		if (_attached_file_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _attached_file_id;
		}
	}

	public void setAttached_file_id(String attached_file_id) {
		_attached_file_id = attached_file_id;
	}

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public Date getModified_date() {
		return _modified_date;
	}

	public void setModified_date(Date modified_date) {
		_modified_date = modified_date;
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
	public RecruitmentAttachedFile toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (RecruitmentAttachedFile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		RecruitmentAttachedFileImpl recruitmentAttachedFileImpl = new RecruitmentAttachedFileImpl();

		recruitmentAttachedFileImpl.setRecruitment_attached_id(getRecruitment_attached_id());
		recruitmentAttachedFileImpl.setRecruitment_id(getRecruitment_id());
		recruitmentAttachedFileImpl.setAttached_file_id(getAttached_file_id());
		recruitmentAttachedFileImpl.setCreated_date(getCreated_date());
		recruitmentAttachedFileImpl.setModified_date(getModified_date());
		recruitmentAttachedFileImpl.setDeleted(getDeleted());

		recruitmentAttachedFileImpl.resetOriginalValues();

		return recruitmentAttachedFileImpl;
	}

	public int compareTo(RecruitmentAttachedFile recruitmentAttachedFile) {
		String primaryKey = recruitmentAttachedFile.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentAttachedFile recruitmentAttachedFile = null;

		try {
			recruitmentAttachedFile = (RecruitmentAttachedFile)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitmentAttachedFile.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<RecruitmentAttachedFile> toCacheModel() {
		RecruitmentAttachedFileCacheModel recruitmentAttachedFileCacheModel = new RecruitmentAttachedFileCacheModel();

		recruitmentAttachedFileCacheModel.recruitment_attached_id = getRecruitment_attached_id();

		String recruitment_attached_id = recruitmentAttachedFileCacheModel.recruitment_attached_id;

		if ((recruitment_attached_id != null) &&
				(recruitment_attached_id.length() == 0)) {
			recruitmentAttachedFileCacheModel.recruitment_attached_id = null;
		}

		recruitmentAttachedFileCacheModel.recruitment_id = getRecruitment_id();

		String recruitment_id = recruitmentAttachedFileCacheModel.recruitment_id;

		if ((recruitment_id != null) && (recruitment_id.length() == 0)) {
			recruitmentAttachedFileCacheModel.recruitment_id = null;
		}

		recruitmentAttachedFileCacheModel.attached_file_id = getAttached_file_id();

		String attached_file_id = recruitmentAttachedFileCacheModel.attached_file_id;

		if ((attached_file_id != null) && (attached_file_id.length() == 0)) {
			recruitmentAttachedFileCacheModel.attached_file_id = null;
		}

		Date created_date = getCreated_date();

		if (created_date != null) {
			recruitmentAttachedFileCacheModel.created_date = created_date.getTime();
		}
		else {
			recruitmentAttachedFileCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			recruitmentAttachedFileCacheModel.modified_date = modified_date.getTime();
		}
		else {
			recruitmentAttachedFileCacheModel.modified_date = Long.MIN_VALUE;
		}

		recruitmentAttachedFileCacheModel.deleted = getDeleted();

		return recruitmentAttachedFileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{recruitment_attached_id=");
		sb.append(getRecruitment_attached_id());
		sb.append(", recruitment_id=");
		sb.append(getRecruitment_id());
		sb.append(", attached_file_id=");
		sb.append(getAttached_file_id());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", modified_date=");
		sb.append(getModified_date());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.RecruitmentAttachedFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_attached_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_attached_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attached_file_id</column-name><column-value><![CDATA[");
		sb.append(getAttached_file_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified_date</column-name><column-value><![CDATA[");
		sb.append(getModified_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = RecruitmentAttachedFile.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			RecruitmentAttachedFile.class
		};
	private String _recruitment_attached_id;
	private String _recruitment_id;
	private String _attached_file_id;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private RecruitmentAttachedFile _escapedModelProxy;
}