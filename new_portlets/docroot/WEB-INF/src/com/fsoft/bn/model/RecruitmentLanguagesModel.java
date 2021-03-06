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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RecruitmentLanguages service. Represents a row in the &quot;BN_RecruitmentLanguages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.RecruitmentLanguagesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.RecruitmentLanguagesImpl}.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentLanguages
 * @see com.fsoft.bn.model.impl.RecruitmentLanguagesImpl
 * @see com.fsoft.bn.model.impl.RecruitmentLanguagesModelImpl
 * @generated
 */
public interface RecruitmentLanguagesModel extends BaseModel<RecruitmentLanguages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recruitment languages model instance should use the {@link RecruitmentLanguages} interface instead.
	 */

	/**
	 * Returns the primary key of this recruitment languages.
	 *
	 * @return the primary key of this recruitment languages
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this recruitment languages.
	 *
	 * @param primaryKey the primary key of this recruitment languages
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the recruitment_languages_id of this recruitment languages.
	 *
	 * @return the recruitment_languages_id of this recruitment languages
	 */
	@AutoEscape
	public String getRecruitment_languages_id();

	/**
	 * Sets the recruitment_languages_id of this recruitment languages.
	 *
	 * @param recruitment_languages_id the recruitment_languages_id of this recruitment languages
	 */
	public void setRecruitment_languages_id(String recruitment_languages_id);

	/**
	 * Returns the recruitment_id of this recruitment languages.
	 *
	 * @return the recruitment_id of this recruitment languages
	 */
	@AutoEscape
	public String getRecruitment_id();

	/**
	 * Sets the recruitment_id of this recruitment languages.
	 *
	 * @param recruitment_id the recruitment_id of this recruitment languages
	 */
	public void setRecruitment_id(String recruitment_id);

	/**
	 * Returns the language of this recruitment languages.
	 *
	 * @return the language of this recruitment languages
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this recruitment languages.
	 *
	 * @param language the language of this recruitment languages
	 */
	public void setLanguage(String language);

	/**
	 * Returns the level of this recruitment languages.
	 *
	 * @return the level of this recruitment languages
	 */
	@AutoEscape
	public String getLevel();

	/**
	 * Sets the level of this recruitment languages.
	 *
	 * @param level the level of this recruitment languages
	 */
	public void setLevel(String level);

	/**
	 * Returns the certificate of this recruitment languages.
	 *
	 * @return the certificate of this recruitment languages
	 */
	@AutoEscape
	public String getCertificate();

	/**
	 * Sets the certificate of this recruitment languages.
	 *
	 * @param certificate the certificate of this recruitment languages
	 */
	public void setCertificate(String certificate);

	/**
	 * Returns the created_date of this recruitment languages.
	 *
	 * @return the created_date of this recruitment languages
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this recruitment languages.
	 *
	 * @param created_date the created_date of this recruitment languages
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this recruitment languages.
	 *
	 * @return the modified_date of this recruitment languages
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this recruitment languages.
	 *
	 * @param modified_date the modified_date of this recruitment languages
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this recruitment languages.
	 *
	 * @return the deleted of this recruitment languages
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this recruitment languages is deleted.
	 *
	 * @return <code>true</code> if this recruitment languages is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this recruitment languages is deleted.
	 *
	 * @param deleted the deleted of this recruitment languages
	 */
	public void setDeleted(boolean deleted);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(RecruitmentLanguages recruitmentLanguages);

	public int hashCode();

	public CacheModel<RecruitmentLanguages> toCacheModel();

	public RecruitmentLanguages toEscapedModel();

	public String toString();

	public String toXmlString();
}