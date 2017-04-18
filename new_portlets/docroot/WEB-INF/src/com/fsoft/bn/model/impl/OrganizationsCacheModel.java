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

import com.fsoft.bn.model.Organizations;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Organizations in entity cache.
 *
 * @author FSOFT
 * @see Organizations
 * @generated
 */
public class OrganizationsCacheModel implements CacheModel<Organizations>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{organizations_id=");
		sb.append(organizations_id);
		sb.append(", organizations_name=");
		sb.append(organizations_name);
		sb.append(", organizations_description=");
		sb.append(organizations_description);
		sb.append(", organizations_address=");
		sb.append(organizations_address);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	public Organizations toEntityModel() {
		OrganizationsImpl organizationsImpl = new OrganizationsImpl();

		organizationsImpl.setOrganizations_id(organizations_id);

		if (organizations_name == null) {
			organizationsImpl.setOrganizations_name(StringPool.BLANK);
		}
		else {
			organizationsImpl.setOrganizations_name(organizations_name);
		}

		if (organizations_description == null) {
			organizationsImpl.setOrganizations_description(StringPool.BLANK);
		}
		else {
			organizationsImpl.setOrganizations_description(organizations_description);
		}

		if (organizations_address == null) {
			organizationsImpl.setOrganizations_address(StringPool.BLANK);
		}
		else {
			organizationsImpl.setOrganizations_address(organizations_address);
		}

		organizationsImpl.setDeleted(deleted);

		if (createDate == Long.MIN_VALUE) {
			organizationsImpl.setCreateDate(null);
		}
		else {
			organizationsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationsImpl.setModifiedDate(null);
		}
		else {
			organizationsImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationsImpl.resetOriginalValues();

		return organizationsImpl;
	}

	public long organizations_id;
	public String organizations_name;
	public String organizations_description;
	public String organizations_address;
	public boolean deleted;
	public long createDate;
	public long modifiedDate;
}