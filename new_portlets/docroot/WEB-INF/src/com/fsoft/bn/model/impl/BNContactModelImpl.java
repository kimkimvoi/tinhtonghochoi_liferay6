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

import com.fsoft.bn.model.BNContact;
import com.fsoft.bn.model.BNContactModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BNContact service. Represents a row in the &quot;BN_BNContact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.BNContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BNContactImpl}.
 * </p>
 *
 * @author FSOFT
 * @see BNContactImpl
 * @see com.fsoft.bn.model.BNContact
 * @see com.fsoft.bn.model.BNContactModel
 * @generated
 */
public class BNContactModelImpl extends BaseModelImpl<BNContact>
	implements BNContactModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a b n contact model instance should use the {@link com.fsoft.bn.model.BNContact} interface instead.
	 */
	public static final String TABLE_NAME = "BN_BNContact";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contactId", Types.BIGINT },
			{ "departmentKey", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "regency", Types.VARCHAR },
			{ "phoneNumber", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_BNContact (contactId LONG not null primary key,departmentKey VARCHAR(75) null,name VARCHAR(75) null,regency VARCHAR(75) null,phoneNumber VARCHAR(75) null,email VARCHAR(75) null,createdDate DATE null,modifiedDate DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_BNContact";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.BNContact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.BNContact"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.BNContact"));

	public BNContactModelImpl() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return BNContact.class;
	}

	public String getModelClassName() {
		return BNContact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("departmentKey", getDepartmentKey());
		attributes.put("name", getName());
		attributes.put("regency", getRegency());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("email", getEmail());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String departmentKey = (String)attributes.get("departmentKey");

		if (departmentKey != null) {
			setDepartmentKey(departmentKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String regency = (String)attributes.get("regency");

		if (regency != null) {
			setRegency(regency);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getDepartmentKey() {
		if (_departmentKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _departmentKey;
		}
	}

	public void setDepartmentKey(String departmentKey) {
		_departmentKey = departmentKey;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	public String getRegency() {
		if (_regency == null) {
			return StringPool.BLANK;
		}
		else {
			return _regency;
		}
	}

	public void setRegency(String regency) {
		_regency = regency;
	}

	public String getPhoneNumber() {
		if (_phoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _phoneNumber;
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BNContact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BNContact toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (BNContact)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		BNContactImpl bnContactImpl = new BNContactImpl();

		bnContactImpl.setContactId(getContactId());
		bnContactImpl.setDepartmentKey(getDepartmentKey());
		bnContactImpl.setName(getName());
		bnContactImpl.setRegency(getRegency());
		bnContactImpl.setPhoneNumber(getPhoneNumber());
		bnContactImpl.setEmail(getEmail());
		bnContactImpl.setCreatedDate(getCreatedDate());
		bnContactImpl.setModifiedDate(getModifiedDate());
		bnContactImpl.setDeleted(getDeleted());

		bnContactImpl.resetOriginalValues();

		return bnContactImpl;
	}

	public int compareTo(BNContact bnContact) {
		long primaryKey = bnContact.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BNContact bnContact = null;

		try {
			bnContact = (BNContact)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = bnContact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<BNContact> toCacheModel() {
		BNContactCacheModel bnContactCacheModel = new BNContactCacheModel();

		bnContactCacheModel.contactId = getContactId();

		bnContactCacheModel.departmentKey = getDepartmentKey();

		String departmentKey = bnContactCacheModel.departmentKey;

		if ((departmentKey != null) && (departmentKey.length() == 0)) {
			bnContactCacheModel.departmentKey = null;
		}

		bnContactCacheModel.name = getName();

		String name = bnContactCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			bnContactCacheModel.name = null;
		}

		bnContactCacheModel.regency = getRegency();

		String regency = bnContactCacheModel.regency;

		if ((regency != null) && (regency.length() == 0)) {
			bnContactCacheModel.regency = null;
		}

		bnContactCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = bnContactCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			bnContactCacheModel.phoneNumber = null;
		}

		bnContactCacheModel.email = getEmail();

		String email = bnContactCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			bnContactCacheModel.email = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			bnContactCacheModel.createdDate = createdDate.getTime();
		}
		else {
			bnContactCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			bnContactCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			bnContactCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		bnContactCacheModel.deleted = getDeleted();

		return bnContactCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", departmentKey=");
		sb.append(getDepartmentKey());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", regency=");
		sb.append(getRegency());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.BNContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentKey</column-name><column-value><![CDATA[");
		sb.append(getDepartmentKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regency</column-name><column-value><![CDATA[");
		sb.append(getRegency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BNContact.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			BNContact.class
		};
	private long _contactId;
	private String _departmentKey;
	private String _name;
	private String _regency;
	private String _phoneNumber;
	private String _email;
	private Date _createdDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BNContact _escapedModelProxy;
}