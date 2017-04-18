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
 * This class is a wrapper for {@link Organizations}.
 * </p>
 *
 * @author    FSOFT
 * @see       Organizations
 * @generated
 */
public class OrganizationsWrapper implements Organizations,
	ModelWrapper<Organizations> {
	public OrganizationsWrapper(Organizations organizations) {
		_organizations = organizations;
	}

	public Class<?> getModelClass() {
		return Organizations.class;
	}

	public String getModelClassName() {
		return Organizations.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("organizations_id", getOrganizations_id());
		attributes.put("organizations_name", getOrganizations_name());
		attributes.put("organizations_description",
			getOrganizations_description());
		attributes.put("organizations_address", getOrganizations_address());
		attributes.put("deleted", getDeleted());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long organizations_id = (Long)attributes.get("organizations_id");

		if (organizations_id != null) {
			setOrganizations_id(organizations_id);
		}

		String organizations_name = (String)attributes.get("organizations_name");

		if (organizations_name != null) {
			setOrganizations_name(organizations_name);
		}

		String organizations_description = (String)attributes.get(
				"organizations_description");

		if (organizations_description != null) {
			setOrganizations_description(organizations_description);
		}

		String organizations_address = (String)attributes.get(
				"organizations_address");

		if (organizations_address != null) {
			setOrganizations_address(organizations_address);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this organizations.
	*
	* @return the primary key of this organizations
	*/
	public long getPrimaryKey() {
		return _organizations.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organizations.
	*
	* @param primaryKey the primary key of this organizations
	*/
	public void setPrimaryKey(long primaryKey) {
		_organizations.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the organizations_id of this organizations.
	*
	* @return the organizations_id of this organizations
	*/
	public long getOrganizations_id() {
		return _organizations.getOrganizations_id();
	}

	/**
	* Sets the organizations_id of this organizations.
	*
	* @param organizations_id the organizations_id of this organizations
	*/
	public void setOrganizations_id(long organizations_id) {
		_organizations.setOrganizations_id(organizations_id);
	}

	/**
	* Returns the organizations_name of this organizations.
	*
	* @return the organizations_name of this organizations
	*/
	public java.lang.String getOrganizations_name() {
		return _organizations.getOrganizations_name();
	}

	/**
	* Sets the organizations_name of this organizations.
	*
	* @param organizations_name the organizations_name of this organizations
	*/
	public void setOrganizations_name(java.lang.String organizations_name) {
		_organizations.setOrganizations_name(organizations_name);
	}

	/**
	* Returns the organizations_description of this organizations.
	*
	* @return the organizations_description of this organizations
	*/
	public java.lang.String getOrganizations_description() {
		return _organizations.getOrganizations_description();
	}

	/**
	* Sets the organizations_description of this organizations.
	*
	* @param organizations_description the organizations_description of this organizations
	*/
	public void setOrganizations_description(
		java.lang.String organizations_description) {
		_organizations.setOrganizations_description(organizations_description);
	}

	/**
	* Returns the organizations_address of this organizations.
	*
	* @return the organizations_address of this organizations
	*/
	public java.lang.String getOrganizations_address() {
		return _organizations.getOrganizations_address();
	}

	/**
	* Sets the organizations_address of this organizations.
	*
	* @param organizations_address the organizations_address of this organizations
	*/
	public void setOrganizations_address(java.lang.String organizations_address) {
		_organizations.setOrganizations_address(organizations_address);
	}

	/**
	* Returns the deleted of this organizations.
	*
	* @return the deleted of this organizations
	*/
	public boolean getDeleted() {
		return _organizations.getDeleted();
	}

	/**
	* Returns <code>true</code> if this organizations is deleted.
	*
	* @return <code>true</code> if this organizations is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _organizations.isDeleted();
	}

	/**
	* Sets whether this organizations is deleted.
	*
	* @param deleted the deleted of this organizations
	*/
	public void setDeleted(boolean deleted) {
		_organizations.setDeleted(deleted);
	}

	/**
	* Returns the create date of this organizations.
	*
	* @return the create date of this organizations
	*/
	public java.util.Date getCreateDate() {
		return _organizations.getCreateDate();
	}

	/**
	* Sets the create date of this organizations.
	*
	* @param createDate the create date of this organizations
	*/
	public void setCreateDate(java.util.Date createDate) {
		_organizations.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this organizations.
	*
	* @return the modified date of this organizations
	*/
	public java.util.Date getModifiedDate() {
		return _organizations.getModifiedDate();
	}

	/**
	* Sets the modified date of this organizations.
	*
	* @param modifiedDate the modified date of this organizations
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_organizations.setModifiedDate(modifiedDate);
	}

	public boolean isNew() {
		return _organizations.isNew();
	}

	public void setNew(boolean n) {
		_organizations.setNew(n);
	}

	public boolean isCachedModel() {
		return _organizations.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_organizations.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _organizations.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _organizations.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organizations.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organizations.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organizations.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationsWrapper((Organizations)_organizations.clone());
	}

	public int compareTo(com.fsoft.bn.model.Organizations organizations) {
		return _organizations.compareTo(organizations);
	}

	@Override
	public int hashCode() {
		return _organizations.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Organizations> toCacheModel() {
		return _organizations.toCacheModel();
	}

	public com.fsoft.bn.model.Organizations toEscapedModel() {
		return new OrganizationsWrapper(_organizations.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organizations.toString();
	}

	public java.lang.String toXmlString() {
		return _organizations.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organizations.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Organizations getWrappedOrganizations() {
		return _organizations;
	}

	public Organizations getWrappedModel() {
		return _organizations;
	}

	public void resetOriginalValues() {
		_organizations.resetOriginalValues();
	}

	private Organizations _organizations;
}