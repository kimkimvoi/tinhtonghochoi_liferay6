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
 * The base model interface for the PrimarySchoolAttachedFile service. Represents a row in the &quot;BN_PrimarySchoolAttachedFile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.PrimarySchoolAttachedFileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.PrimarySchoolAttachedFileImpl}.
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolAttachedFile
 * @see com.fsoft.bn.model.impl.PrimarySchoolAttachedFileImpl
 * @see com.fsoft.bn.model.impl.PrimarySchoolAttachedFileModelImpl
 * @generated
 */
public interface PrimarySchoolAttachedFileModel extends BaseModel<PrimarySchoolAttachedFile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a primary school attached file model instance should use the {@link PrimarySchoolAttachedFile} interface instead.
	 */

	/**
	 * Returns the primary key of this primary school attached file.
	 *
	 * @return the primary key of this primary school attached file
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this primary school attached file.
	 *
	 * @param primaryKey the primary key of this primary school attached file
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the primary school_attached_id of this primary school attached file.
	 *
	 * @return the primary school_attached_id of this primary school attached file
	 */
	@AutoEscape
	public String getPrimarySchool_attached_id();

	/**
	 * Sets the primary school_attached_id of this primary school attached file.
	 *
	 * @param primarySchool_attached_id the primary school_attached_id of this primary school attached file
	 */
	public void setPrimarySchool_attached_id(String primarySchool_attached_id);

	/**
	 * Returns the primary student_id of this primary school attached file.
	 *
	 * @return the primary student_id of this primary school attached file
	 */
	@AutoEscape
	public String getPrimaryStudent_id();

	/**
	 * Sets the primary student_id of this primary school attached file.
	 *
	 * @param primaryStudent_id the primary student_id of this primary school attached file
	 */
	public void setPrimaryStudent_id(String primaryStudent_id);

	/**
	 * Returns the attached_file_id of this primary school attached file.
	 *
	 * @return the attached_file_id of this primary school attached file
	 */
	@AutoEscape
	public String getAttached_file_id();

	/**
	 * Sets the attached_file_id of this primary school attached file.
	 *
	 * @param attached_file_id the attached_file_id of this primary school attached file
	 */
	public void setAttached_file_id(String attached_file_id);

	/**
	 * Returns the created_date of this primary school attached file.
	 *
	 * @return the created_date of this primary school attached file
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this primary school attached file.
	 *
	 * @param created_date the created_date of this primary school attached file
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this primary school attached file.
	 *
	 * @return the modified_date of this primary school attached file
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this primary school attached file.
	 *
	 * @param modified_date the modified_date of this primary school attached file
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this primary school attached file.
	 *
	 * @return the deleted of this primary school attached file
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this primary school attached file is deleted.
	 *
	 * @return <code>true</code> if this primary school attached file is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this primary school attached file is deleted.
	 *
	 * @param deleted the deleted of this primary school attached file
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

	public int compareTo(PrimarySchoolAttachedFile primarySchoolAttachedFile);

	public int hashCode();

	public CacheModel<PrimarySchoolAttachedFile> toCacheModel();

	public PrimarySchoolAttachedFile toEscapedModel();

	public String toString();

	public String toXmlString();
}