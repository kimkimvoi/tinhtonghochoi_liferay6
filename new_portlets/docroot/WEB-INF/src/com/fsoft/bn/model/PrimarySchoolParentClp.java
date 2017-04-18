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

import com.fsoft.bn.service.PrimarySchoolParentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class PrimarySchoolParentClp extends BaseModelImpl<PrimarySchoolParent>
	implements PrimarySchoolParent {
	public PrimarySchoolParentClp() {
	}

	public Class<?> getModelClass() {
		return PrimarySchoolParent.class;
	}

	public String getModelClassName() {
		return PrimarySchoolParent.class.getName();
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
		return _primarySchoolParent_id;
	}

	public void setPrimarySchoolParent_id(String primarySchoolParent_id) {
		_primarySchoolParent_id = primarySchoolParent_id;
	}

	public String getPrimaryStudent_id() {
		return _primaryStudent_id;
	}

	public void setPrimaryStudent_id(String primaryStudent_id) {
		_primaryStudent_id = primaryStudent_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getIdCardNumber() {
		return _idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		_idCardNumber = idCardNumber;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
	}

	public String getJob_position() {
		return _job_position;
	}

	public void setJob_position(String job_position) {
		_job_position = job_position;
	}

	public String getWorkplace() {
		return _workplace;
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

	public BaseModel<?> getPrimarySchoolParentRemoteModel() {
		return _primarySchoolParentRemoteModel;
	}

	public void setPrimarySchoolParentRemoteModel(
		BaseModel<?> primarySchoolParentRemoteModel) {
		_primarySchoolParentRemoteModel = primarySchoolParentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PrimarySchoolParentLocalServiceUtil.addPrimarySchoolParent(this);
		}
		else {
			PrimarySchoolParentLocalServiceUtil.updatePrimarySchoolParent(this);
		}
	}

	@Override
	public PrimarySchoolParent toEscapedModel() {
		return (PrimarySchoolParent)Proxy.newProxyInstance(PrimarySchoolParent.class.getClassLoader(),
			new Class[] { PrimarySchoolParent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PrimarySchoolParentClp clone = new PrimarySchoolParentClp();

		clone.setPrimarySchoolParent_id(getPrimarySchoolParent_id());
		clone.setPrimaryStudent_id(getPrimaryStudent_id());
		clone.setName(getName());
		clone.setNationality(getNationality());
		clone.setIdCardNumber(getIdCardNumber());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setEmail(getEmail());
		clone.setJob(getJob());
		clone.setJob_position(getJob_position());
		clone.setWorkplace(getWorkplace());
		clone.setIsMother(getIsMother());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
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

		PrimarySchoolParentClp primarySchoolParent = null;

		try {
			primarySchoolParent = (PrimarySchoolParentClp)obj;
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
	private BaseModel<?> _primarySchoolParentRemoteModel;
}