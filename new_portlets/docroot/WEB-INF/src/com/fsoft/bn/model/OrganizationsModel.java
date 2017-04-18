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
 * The base model interface for the Organizations service. Represents a row in the &quot;BN_Organizations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.OrganizationsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.OrganizationsImpl}.
 * </p>
 *
 * @author FSOFT
 * @see Organizations
 * @see com.fsoft.bn.model.impl.OrganizationsImpl
 * @see com.fsoft.bn.model.impl.OrganizationsModelImpl
 * @generated
 */
public interface OrganizationsModel extends BaseModel<Organizations> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a organizations model instance should use the {@link Organizations} interface instead.
	 */

	/**
	 * Returns the primary key of this organizations.
	 *
	 * @return the primary key of this organizations
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this organizations.
	 *
	 * @param primaryKey the primary key of this organizations
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the organizations_id of this organizations.
	 *
	 * @return the organizations_id of this organizations
	 */
	public long getOrganizations_id();

	/**
	 * Sets the organizations_id of this organizations.
	 *
	 * @param organizations_id the organizations_id of this organizations
	 */
	public void setOrganizations_id(long organizations_id);

	/**
	 * Returns the organizations_name of this organizations.
	 *
	 * @return the organizations_name of this organizations
	 */
	@AutoEscape
	public String getOrganizations_name();

	/**
	 * Sets the organizations_name of this organizations.
	 *
	 * @param organizations_name the organizations_name of this organizations
	 */
	public void setOrganizations_name(String organizations_name);

	/**
	 * Returns the organizations_description of this organizations.
	 *
	 * @return the organizations_description of this organizations
	 */
	@AutoEscape
	public String getOrganizations_description();

	/**
	 * Sets the organizations_description of this organizations.
	 *
	 * @param organizations_description the organizations_description of this organizations
	 */
	public void setOrganizations_description(String organizations_description);

	/**
	 * Returns the organizations_address of this organizations.
	 *
	 * @return the organizations_address of this organizations
	 */
	@AutoEscape
	public String getOrganizations_address();

	/**
	 * Sets the organizations_address of this organizations.
	 *
	 * @param organizations_address the organizations_address of this organizations
	 */
	public void setOrganizations_address(String organizations_address);

	/**
	 * Returns the deleted of this organizations.
	 *
	 * @return the deleted of this organizations
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this organizations is deleted.
	 *
	 * @return <code>true</code> if this organizations is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this organizations is deleted.
	 *
	 * @param deleted the deleted of this organizations
	 */
	public void setDeleted(boolean deleted);

	/**
	 * Returns the create date of this organizations.
	 *
	 * @return the create date of this organizations
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this organizations.
	 *
	 * @param createDate the create date of this organizations
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this organizations.
	 *
	 * @return the modified date of this organizations
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this organizations.
	 *
	 * @param modifiedDate the modified date of this organizations
	 */
	public void setModifiedDate(Date modifiedDate);

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

	public int compareTo(Organizations organizations);

	public int hashCode();

	public CacheModel<Organizations> toCacheModel();

	public Organizations toEscapedModel();

	public String toString();

	public String toXmlString();
}