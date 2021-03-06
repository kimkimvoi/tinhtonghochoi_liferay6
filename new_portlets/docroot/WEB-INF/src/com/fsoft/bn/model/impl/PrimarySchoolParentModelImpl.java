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

import com.fsoft.bn.model.PrimarySchoolParent;
import com.fsoft.bn.model.PrimarySchoolParentModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the PrimarySchoolParent service. Represents a row in the &quot;BN_PrimarySchoolParent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.PrimarySchoolParentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PrimarySchoolParentImpl}.
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolParentImpl
 * @see com.fsoft.bn.model.PrimarySchoolParent
 * @see com.fsoft.bn.model.PrimarySchoolParentModel
 * @generated
 */
public class PrimarySchoolParentModelImpl extends BaseModelImpl<PrimarySchoolParent>
	implements PrimarySchoolParentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a primary school parent model instance should use the {@link com.fsoft.bn.model.PrimarySchoolParent} interface instead.
	 */
	public static final String TABLE_NAME = "BN_PrimarySchoolParent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "primarySchoolParent_id", Types.VARCHAR },
			{ "primaryStudent_id", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "nationality", Types.VARCHAR },
			{ "idCardNumber", Types.VARCHAR },
			{ "phoneNumber", Types.VARCHAR },
			{ "Email", Types.VARCHAR },
			{ "job", Types.VARCHAR },
			{ "job_position", Types.VARCHAR },
			{ "workplace", Types.VARCHAR },
			{ "isMother", Types.BOOLEAN },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_PrimarySchoolParent (primarySchoolParent_id VARCHAR(75) not null primary key,primaryStudent_id VARCHAR(75) null,name VARCHAR(75) null,nationality VARCHAR(75) null,idCardNumber VARCHAR(75) null,phoneNumber VARCHAR(75) null,Email VARCHAR(75) null,job VARCHAR(75) null,job_position VARCHAR(75) null,workplace VARCHAR(75) null,isMother BOOLEAN,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_PrimarySchoolParent";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.PrimarySchoolParent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.PrimarySchoolParent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.PrimarySchoolParent"));

	public PrimarySchoolParentModelImpl() {
	}

	public String getPrimaryKey() {
		return _primarySchoolParent_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setPrimarySchoolParent_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _primarySchoolParent_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	public Class<?> getModelClass() {
		return PrimarySchoolParent.class;
	}

	public String getModelClassName() {
		return PrimarySchoolParent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("primarySchoolParent_id", getPrimarySchoolParent_id());
		attributes.put("primaryStudent_id", getPrimaryStudent_id());
		attributes.put("name", getName());
		attributes.put("nationality", getNationality());
		attributes.put("idCardNumber", getIdCardNumber());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("Email", getEmail());
		attributes.put("job", getJob());
		attributes.put("job_position", getJob_position());
		attributes.put("workplace", getWorkplace());
		attributes.put("isMother", getIsMother());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String primarySchoolParent_id = (String)attributes.get(
				"primarySchoolParent_id");

		if (primarySchoolParent_id != null) {
			setPrimarySchoolParent_id(primarySchoolParent_id);
		}

		String primaryStudent_id = (String)attributes.get("primaryStudent_id");

		if (primaryStudent_id != null) {
			setPrimaryStudent_id(primaryStudent_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String idCardNumber = (String)attributes.get("idCardNumber");

		if (idCardNumber != null) {
			setIdCardNumber(idCardNumber);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		String job_position = (String)attributes.get("job_position");

		if (job_position != null) {
			setJob_position(job_position);
		}

		String workplace = (String)attributes.get("workplace");

		if (workplace != null) {
			setWorkplace(workplace);
		}

		Boolean isMother = (Boolean)attributes.get("isMother");

		if (isMother != null) {
			setIsMother(isMother);
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

	public String getPrimarySchoolParent_id() {
		if (_primarySchoolParent_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _primarySchoolParent_id;
		}
	}

	public void setPrimarySchoolParent_id(String primarySchoolParent_id) {
		_primarySchoolParent_id = primarySchoolParent_id;
	}

	public String getPrimaryStudent_id() {
		if (_primaryStudent_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _primaryStudent_id;
		}
	}

	public void setPrimaryStudent_id(String primaryStudent_id) {
		_primaryStudent_id = primaryStudent_id;
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

	public String getNationality() {
		if (_nationality == null) {
			return StringPool.BLANK;
		}
		else {
			return _nationality;
		}
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getIdCardNumber() {
		if (_idCardNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _idCardNumber;
		}
	}

	public void setIdCardNumber(String idCardNumber) {
		_idCardNumber = idCardNumber;
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
		if (_Email == null) {
			return StringPool.BLANK;
		}
		else {
			return _Email;
		}
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getJob() {
		if (_job == null) {
			return StringPool.BLANK;
		}
		else {
			return _job;
		}
	}

	public void setJob(String job) {
		_job = job;
	}

	public String getJob_position() {
		if (_job_position == null) {
			return StringPool.BLANK;
		}
		else {
			return _job_position;
		}
	}

	public void setJob_position(String job_position) {
		_job_position = job_position;
	}

	public String getWorkplace() {
		if (_workplace == null) {
			return StringPool.BLANK;
		}
		else {
			return _workplace;
		}
	}

	public void setWorkplace(String workplace) {
		_workplace = workplace;
	}

	public boolean getIsMother() {
		return _isMother;
	}

	public boolean isIsMother() {
		return _isMother;
	}

	public void setIsMother(boolean isMother) {
		_isMother = isMother;
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

	@Override
	public PrimarySchoolParent toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (PrimarySchoolParent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PrimarySchoolParentImpl primarySchoolParentImpl = new PrimarySchoolParentImpl();

		primarySchoolParentImpl.setPrimarySchoolParent_id(getPrimarySchoolParent_id());
		primarySchoolParentImpl.setPrimaryStudent_id(getPrimaryStudent_id());
		primarySchoolParentImpl.setName(getName());
		primarySchoolParentImpl.setNationality(getNationality());
		primarySchoolParentImpl.setIdCardNumber(getIdCardNumber());
		primarySchoolParentImpl.setPhoneNumber(getPhoneNumber());
		primarySchoolParentImpl.setEmail(getEmail());
		primarySchoolParentImpl.setJob(getJob());
		primarySchoolParentImpl.setJob_position(getJob_position());
		primarySchoolParentImpl.setWorkplace(getWorkplace());
		primarySchoolParentImpl.setIsMother(getIsMother());
		primarySchoolParentImpl.setCreated_date(getCreated_date());
		primarySchoolParentImpl.setModified_date(getModified_date());
		primarySchoolParentImpl.setDeleted(getDeleted());

		primarySchoolParentImpl.resetOriginalValues();

		return primarySchoolParentImpl;
	}

	public int compareTo(PrimarySchoolParent primarySchoolParent) {
		String primaryKey = primarySchoolParent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PrimarySchoolParent primarySchoolParent = null;

		try {
			primarySchoolParent = (PrimarySchoolParent)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = primarySchoolParent.getPrimaryKey();

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<PrimarySchoolParent> toCacheModel() {
		PrimarySchoolParentCacheModel primarySchoolParentCacheModel = new PrimarySchoolParentCacheModel();

		primarySchoolParentCacheModel.primarySchoolParent_id = getPrimarySchoolParent_id();

		String primarySchoolParent_id = primarySchoolParentCacheModel.primarySchoolParent_id;

		if ((primarySchoolParent_id != null) &&
				(primarySchoolParent_id.length() == 0)) {
			primarySchoolParentCacheModel.primarySchoolParent_id = null;
		}

		primarySchoolParentCacheModel.primaryStudent_id = getPrimaryStudent_id();

		String primaryStudent_id = primarySchoolParentCacheModel.primaryStudent_id;

		if ((primaryStudent_id != null) && (primaryStudent_id.length() == 0)) {
			primarySchoolParentCacheModel.primaryStudent_id = null;
		}

		primarySchoolParentCacheModel.name = getName();

		String name = primarySchoolParentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			primarySchoolParentCacheModel.name = null;
		}

		primarySchoolParentCacheModel.nationality = getNationality();

		String nationality = primarySchoolParentCacheModel.nationality;

		if ((nationality != null) && (nationality.length() == 0)) {
			primarySchoolParentCacheModel.nationality = null;
		}

		primarySchoolParentCacheModel.idCardNumber = getIdCardNumber();

		String idCardNumber = primarySchoolParentCacheModel.idCardNumber;

		if ((idCardNumber != null) && (idCardNumber.length() == 0)) {
			primarySchoolParentCacheModel.idCardNumber = null;
		}

		primarySchoolParentCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = primarySchoolParentCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			primarySchoolParentCacheModel.phoneNumber = null;
		}

		primarySchoolParentCacheModel.Email = getEmail();

		String Email = primarySchoolParentCacheModel.Email;

		if ((Email != null) && (Email.length() == 0)) {
			primarySchoolParentCacheModel.Email = null;
		}

		primarySchoolParentCacheModel.job = getJob();

		String job = primarySchoolParentCacheModel.job;

		if ((job != null) && (job.length() == 0)) {
			primarySchoolParentCacheModel.job = null;
		}

		primarySchoolParentCacheModel.job_position = getJob_position();

		String job_position = primarySchoolParentCacheModel.job_position;

		if ((job_position != null) && (job_position.length() == 0)) {
			primarySchoolParentCacheModel.job_position = null;
		}

		primarySchoolParentCacheModel.workplace = getWorkplace();

		String workplace = primarySchoolParentCacheModel.workplace;

		if ((workplace != null) && (workplace.length() == 0)) {
			primarySchoolParentCacheModel.workplace = null;
		}

		primarySchoolParentCacheModel.isMother = getIsMother();

		Date created_date = getCreated_date();

		if (created_date != null) {
			primarySchoolParentCacheModel.created_date = created_date.getTime();
		}
		else {
			primarySchoolParentCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			primarySchoolParentCacheModel.modified_date = modified_date.getTime();
		}
		else {
			primarySchoolParentCacheModel.modified_date = Long.MIN_VALUE;
		}

		primarySchoolParentCacheModel.deleted = getDeleted();

		return primarySchoolParentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{primarySchoolParent_id=");
		sb.append(getPrimarySchoolParent_id());
		sb.append(", primaryStudent_id=");
		sb.append(getPrimaryStudent_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", nationality=");
		sb.append(getNationality());
		sb.append(", idCardNumber=");
		sb.append(getIdCardNumber());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", job=");
		sb.append(getJob());
		sb.append(", job_position=");
		sb.append(getJob_position());
		sb.append(", workplace=");
		sb.append(getWorkplace());
		sb.append(", isMother=");
		sb.append(getIsMother());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.PrimarySchoolParent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>primarySchoolParent_id</column-name><column-value><![CDATA[");
		sb.append(getPrimarySchoolParent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>primaryStudent_id</column-name><column-value><![CDATA[");
		sb.append(getPrimaryStudent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationality</column-name><column-value><![CDATA[");
		sb.append(getNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCardNumber</column-name><column-value><![CDATA[");
		sb.append(getIdCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>job</column-name><column-value><![CDATA[");
		sb.append(getJob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>job_position</column-name><column-value><![CDATA[");
		sb.append(getJob_position());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workplace</column-name><column-value><![CDATA[");
		sb.append(getWorkplace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMother</column-name><column-value><![CDATA[");
		sb.append(getIsMother());
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

	private static ClassLoader _classLoader = PrimarySchoolParent.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			PrimarySchoolParent.class
		};
	private String _primarySchoolParent_id;
	private String _primaryStudent_id;
	private String _name;
	private String _nationality;
	private String _idCardNumber;
	private String _phoneNumber;
	private String _Email;
	private String _job;
	private String _job_position;
	private String _workplace;
	private boolean _isMother;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private PrimarySchoolParent _escapedModelProxy;
}