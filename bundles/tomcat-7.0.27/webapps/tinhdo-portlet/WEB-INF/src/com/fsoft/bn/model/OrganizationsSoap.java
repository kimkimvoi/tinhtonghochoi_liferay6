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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    FSOFT
 * @generated
 */
public class OrganizationsSoap implements Serializable {
	public static OrganizationsSoap toSoapModel(Organizations model) {
		OrganizationsSoap soapModel = new OrganizationsSoap();

		soapModel.setOrganizations_id(model.getOrganizations_id());
		soapModel.setOrganizations_name(model.getOrganizations_name());
		soapModel.setOrganizations_description(model.getOrganizations_description());
		soapModel.setOrganizations_address(model.getOrganizations_address());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static OrganizationsSoap[] toSoapModels(Organizations[] models) {
		OrganizationsSoap[] soapModels = new OrganizationsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationsSoap[][] toSoapModels(Organizations[][] models) {
		OrganizationsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationsSoap[] toSoapModels(List<Organizations> models) {
		List<OrganizationsSoap> soapModels = new ArrayList<OrganizationsSoap>(models.size());

		for (Organizations model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationsSoap[soapModels.size()]);
	}

	public OrganizationsSoap() {
	}

	public long getPrimaryKey() {
		return _organizations_id;
	}

	public void setPrimaryKey(long pk) {
		setOrganizations_id(pk);
	}

	public long getOrganizations_id() {
		return _organizations_id;
	}

	public void setOrganizations_id(long organizations_id) {
		_organizations_id = organizations_id;
	}

	public String getOrganizations_name() {
		return _organizations_name;
	}

	public void setOrganizations_name(String organizations_name) {
		_organizations_name = organizations_name;
	}

	public String getOrganizations_description() {
		return _organizations_description;
	}

	public void setOrganizations_description(String organizations_description) {
		_organizations_description = organizations_description;
	}

	public String getOrganizations_address() {
		return _organizations_address;
	}

	public void setOrganizations_address(String organizations_address) {
		_organizations_address = organizations_address;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _organizations_id;
	private String _organizations_name;
	private String _organizations_description;
	private String _organizations_address;
	private boolean _deleted;
	private Date _createDate;
	private Date _modifiedDate;
}