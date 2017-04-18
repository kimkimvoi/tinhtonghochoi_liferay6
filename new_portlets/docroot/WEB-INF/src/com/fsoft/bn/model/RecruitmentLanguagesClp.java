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

import com.fsoft.bn.service.RecruitmentLanguagesLocalServiceUtil;

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
public class RecruitmentLanguagesClp extends BaseModelImpl<RecruitmentLanguages>
	implements RecruitmentLanguages {
	public RecruitmentLanguagesClp() {
	}

	public Class<?> getModelClass() {
		return RecruitmentLanguages.class;
	}

	public String getModelClassName() {
		return RecruitmentLanguages.class.getName();
	}

	public String getPrimaryKey() {
		return _recruitment_languages_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_languages_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_languages_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_languages_id", getRecruitment_languages_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("language", getLanguage());
		attributes.put("level", getLevel());
		attributes.put("certificate", getCertificate());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_languages_id = (String)attributes.get(
				"recruitment_languages_id");

		if (recruitment_languages_id != null) {
			setRecruitment_languages_id(recruitment_languages_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String level = (String)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String certificate = (String)attributes.get("certificate");

		if (certificate != null) {
			setCertificate(certificate);
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

	public String getRecruitment_languages_id() {
		return _recruitment_languages_id;
	}

	public void setRecruitment_languages_id(String recruitment_languages_id) {
		_recruitment_languages_id = recruitment_languages_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		_level = level;
	}

	public String getCertificate() {
		return _certificate;
	}

	public void setCertificate(String certificate) {
		_certificate = certificate;
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

	public BaseModel<?> getRecruitmentLanguagesRemoteModel() {
		return _recruitmentLanguagesRemoteModel;
	}

	public void setRecruitmentLanguagesRemoteModel(
		BaseModel<?> recruitmentLanguagesRemoteModel) {
		_recruitmentLanguagesRemoteModel = recruitmentLanguagesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RecruitmentLanguagesLocalServiceUtil.addRecruitmentLanguages(this);
		}
		else {
			RecruitmentLanguagesLocalServiceUtil.updateRecruitmentLanguages(this);
		}
	}

	@Override
	public RecruitmentLanguages toEscapedModel() {
		return (RecruitmentLanguages)Proxy.newProxyInstance(RecruitmentLanguages.class.getClassLoader(),
			new Class[] { RecruitmentLanguages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecruitmentLanguagesClp clone = new RecruitmentLanguagesClp();

		clone.setRecruitment_languages_id(getRecruitment_languages_id());
		clone.setRecruitment_id(getRecruitment_id());
		clone.setLanguage(getLanguage());
		clone.setLevel(getLevel());
		clone.setCertificate(getCertificate());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(RecruitmentLanguages recruitmentLanguages) {
		String primaryKey = recruitmentLanguages.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentLanguagesClp recruitmentLanguages = null;

		try {
			recruitmentLanguages = (RecruitmentLanguagesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitmentLanguages.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{recruitment_languages_id=");
		sb.append(getRecruitment_languages_id());
		sb.append(", recruitment_id=");
		sb.append(getRecruitment_id());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", certificate=");
		sb.append(getCertificate());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.RecruitmentLanguages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_languages_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_languages_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificate</column-name><column-value><![CDATA[");
		sb.append(getCertificate());
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

	private String _recruitment_languages_id;
	private String _recruitment_id;
	private String _language;
	private String _level;
	private String _certificate;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _recruitmentLanguagesRemoteModel;
}