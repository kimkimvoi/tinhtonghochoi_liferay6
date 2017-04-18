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
 * This class is a wrapper for {@link RecruitmentLanguages}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentLanguages
 * @generated
 */
public class RecruitmentLanguagesWrapper implements RecruitmentLanguages,
	ModelWrapper<RecruitmentLanguages> {
	public RecruitmentLanguagesWrapper(
		RecruitmentLanguages recruitmentLanguages) {
		_recruitmentLanguages = recruitmentLanguages;
	}

	public Class<?> getModelClass() {
		return RecruitmentLanguages.class;
	}

	public String getModelClassName() {
		return RecruitmentLanguages.class.getName();
	}

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

	/**
	* Returns the primary key of this recruitment languages.
	*
	* @return the primary key of this recruitment languages
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitmentLanguages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment languages.
	*
	* @param primaryKey the primary key of this recruitment languages
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitmentLanguages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_languages_id of this recruitment languages.
	*
	* @return the recruitment_languages_id of this recruitment languages
	*/
	public java.lang.String getRecruitment_languages_id() {
		return _recruitmentLanguages.getRecruitment_languages_id();
	}

	/**
	* Sets the recruitment_languages_id of this recruitment languages.
	*
	* @param recruitment_languages_id the recruitment_languages_id of this recruitment languages
	*/
	public void setRecruitment_languages_id(
		java.lang.String recruitment_languages_id) {
		_recruitmentLanguages.setRecruitment_languages_id(recruitment_languages_id);
	}

	/**
	* Returns the recruitment_id of this recruitment languages.
	*
	* @return the recruitment_id of this recruitment languages
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitmentLanguages.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment languages.
	*
	* @param recruitment_id the recruitment_id of this recruitment languages
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitmentLanguages.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the language of this recruitment languages.
	*
	* @return the language of this recruitment languages
	*/
	public java.lang.String getLanguage() {
		return _recruitmentLanguages.getLanguage();
	}

	/**
	* Sets the language of this recruitment languages.
	*
	* @param language the language of this recruitment languages
	*/
	public void setLanguage(java.lang.String language) {
		_recruitmentLanguages.setLanguage(language);
	}

	/**
	* Returns the level of this recruitment languages.
	*
	* @return the level of this recruitment languages
	*/
	public java.lang.String getLevel() {
		return _recruitmentLanguages.getLevel();
	}

	/**
	* Sets the level of this recruitment languages.
	*
	* @param level the level of this recruitment languages
	*/
	public void setLevel(java.lang.String level) {
		_recruitmentLanguages.setLevel(level);
	}

	/**
	* Returns the certificate of this recruitment languages.
	*
	* @return the certificate of this recruitment languages
	*/
	public java.lang.String getCertificate() {
		return _recruitmentLanguages.getCertificate();
	}

	/**
	* Sets the certificate of this recruitment languages.
	*
	* @param certificate the certificate of this recruitment languages
	*/
	public void setCertificate(java.lang.String certificate) {
		_recruitmentLanguages.setCertificate(certificate);
	}

	/**
	* Returns the created_date of this recruitment languages.
	*
	* @return the created_date of this recruitment languages
	*/
	public java.util.Date getCreated_date() {
		return _recruitmentLanguages.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment languages.
	*
	* @param created_date the created_date of this recruitment languages
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitmentLanguages.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment languages.
	*
	* @return the modified_date of this recruitment languages
	*/
	public java.util.Date getModified_date() {
		return _recruitmentLanguages.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment languages.
	*
	* @param modified_date the modified_date of this recruitment languages
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitmentLanguages.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment languages.
	*
	* @return the deleted of this recruitment languages
	*/
	public boolean getDeleted() {
		return _recruitmentLanguages.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment languages is deleted.
	*
	* @return <code>true</code> if this recruitment languages is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitmentLanguages.isDeleted();
	}

	/**
	* Sets whether this recruitment languages is deleted.
	*
	* @param deleted the deleted of this recruitment languages
	*/
	public void setDeleted(boolean deleted) {
		_recruitmentLanguages.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitmentLanguages.isNew();
	}

	public void setNew(boolean n) {
		_recruitmentLanguages.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitmentLanguages.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitmentLanguages.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitmentLanguages.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitmentLanguages.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitmentLanguages.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitmentLanguages.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitmentLanguages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentLanguagesWrapper((RecruitmentLanguages)_recruitmentLanguages.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages) {
		return _recruitmentLanguages.compareTo(recruitmentLanguages);
	}

	@Override
	public int hashCode() {
		return _recruitmentLanguages.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.RecruitmentLanguages> toCacheModel() {
		return _recruitmentLanguages.toCacheModel();
	}

	public com.fsoft.bn.model.RecruitmentLanguages toEscapedModel() {
		return new RecruitmentLanguagesWrapper(_recruitmentLanguages.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitmentLanguages.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitmentLanguages.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitmentLanguages.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RecruitmentLanguages getWrappedRecruitmentLanguages() {
		return _recruitmentLanguages;
	}

	public RecruitmentLanguages getWrappedModel() {
		return _recruitmentLanguages;
	}

	public void resetOriginalValues() {
		_recruitmentLanguages.resetOriginalValues();
	}

	private RecruitmentLanguages _recruitmentLanguages;
}