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
 * The base model interface for the StaffInfo service. Represents a row in the &quot;BN_StaffInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.StaffInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.StaffInfoImpl}.
 * </p>
 *
 * @author FSOFT
 * @see StaffInfo
 * @see com.fsoft.bn.model.impl.StaffInfoImpl
 * @see com.fsoft.bn.model.impl.StaffInfoModelImpl
 * @generated
 */
public interface StaffInfoModel extends BaseModel<StaffInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a staff info model instance should use the {@link StaffInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this staff info.
	 *
	 * @return the primary key of this staff info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this staff info.
	 *
	 * @param primaryKey the primary key of this staff info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the staff_id of this staff info.
	 *
	 * @return the staff_id of this staff info
	 */
	public long getStaff_id();

	/**
	 * Sets the staff_id of this staff info.
	 *
	 * @param staff_id the staff_id of this staff info
	 */
	public void setStaff_id(long staff_id);

	/**
	 * Returns the staff_firstname of this staff info.
	 *
	 * @return the staff_firstname of this staff info
	 */
	@AutoEscape
	public String getStaff_firstname();

	/**
	 * Sets the staff_firstname of this staff info.
	 *
	 * @param staff_firstname the staff_firstname of this staff info
	 */
	public void setStaff_firstname(String staff_firstname);

	/**
	 * Returns the staff_middlename of this staff info.
	 *
	 * @return the staff_middlename of this staff info
	 */
	@AutoEscape
	public String getStaff_middlename();

	/**
	 * Sets the staff_middlename of this staff info.
	 *
	 * @param staff_middlename the staff_middlename of this staff info
	 */
	public void setStaff_middlename(String staff_middlename);

	/**
	 * Returns the staff_lastname of this staff info.
	 *
	 * @return the staff_lastname of this staff info
	 */
	@AutoEscape
	public String getStaff_lastname();

	/**
	 * Sets the staff_lastname of this staff info.
	 *
	 * @param staff_lastname the staff_lastname of this staff info
	 */
	public void setStaff_lastname(String staff_lastname);

	/**
	 * Returns the staff_birthday of this staff info.
	 *
	 * @return the staff_birthday of this staff info
	 */
	public Date getStaff_birthday();

	/**
	 * Sets the staff_birthday of this staff info.
	 *
	 * @param staff_birthday the staff_birthday of this staff info
	 */
	public void setStaff_birthday(Date staff_birthday);

	/**
	 * Returns the staff_phone of this staff info.
	 *
	 * @return the staff_phone of this staff info
	 */
	@AutoEscape
	public String getStaff_phone();

	/**
	 * Sets the staff_phone of this staff info.
	 *
	 * @param staff_phone the staff_phone of this staff info
	 */
	public void setStaff_phone(String staff_phone);

	/**
	 * Returns the staff_email of this staff info.
	 *
	 * @return the staff_email of this staff info
	 */
	@AutoEscape
	public String getStaff_email();

	/**
	 * Sets the staff_email of this staff info.
	 *
	 * @param staff_email the staff_email of this staff info
	 */
	public void setStaff_email(String staff_email);

	/**
	 * Returns the staff_sex of this staff info.
	 *
	 * @return the staff_sex of this staff info
	 */
	@AutoEscape
	public String getStaff_sex();

	/**
	 * Sets the staff_sex of this staff info.
	 *
	 * @param staff_sex the staff_sex of this staff info
	 */
	public void setStaff_sex(String staff_sex);

	/**
	 * Returns the staff_role of this staff info.
	 *
	 * @return the staff_role of this staff info
	 */
	@AutoEscape
	public String getStaff_role();

	/**
	 * Sets the staff_role of this staff info.
	 *
	 * @param staff_role the staff_role of this staff info
	 */
	public void setStaff_role(String staff_role);

	/**
	 * Returns the deleted of this staff info.
	 *
	 * @return the deleted of this staff info
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this staff info is deleted.
	 *
	 * @return <code>true</code> if this staff info is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this staff info is deleted.
	 *
	 * @param deleted the deleted of this staff info
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the create date of this staff info.
	 *
	 * @return the create date of this staff info
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this staff info.
	 *
	 * @param createDate the create date of this staff info
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this staff info.
	 *
	 * @return the modified date of this staff info
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this staff info.
	 *
	 * @param modifiedDate the modified date of this staff info
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the organizations_id of this staff info.
	 *
	 * @return the organizations_id of this staff info
	 */
	public long getOrganizations_id();

	/**
	 * Sets the organizations_id of this staff info.
	 *
	 * @param organizations_id the organizations_id of this staff info
	 */
	public void setOrganizations_id(long organizations_id);

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

	public int compareTo(StaffInfo staffInfo);

	public int hashCode();

	public CacheModel<StaffInfo> toCacheModel();

	public StaffInfo toEscapedModel();

	public String toString();

	public String toXmlString();
}