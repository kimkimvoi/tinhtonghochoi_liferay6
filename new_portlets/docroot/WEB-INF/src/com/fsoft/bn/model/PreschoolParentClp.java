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

import com.fsoft.bn.service.PreschoolParentLocalServiceUtil;

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
public class PreschoolParentClp extends BaseModelImpl<PreschoolParent>
	implements PreschoolParent {
	public PreschoolParentClp() {
	}

	public Class<?> getModelClass() {
		return PreschoolParent.class;
	}

	public String getModelClassName() {
		return PreschoolParent.class.getName();
	}

	public String getPrimaryKey() {
		return _preschoolParent_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setPreschoolParent_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _preschoolParent_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("preschoolParent_id", getPreschoolParent_id());
		attributes.put("student_id", getStudent_id());
		attributes.put("name", getName());
		attributes.put("dob", getDob());
		attributes.put("placeOfBirth", getPlaceOfBirth());
		attributes.put("nationality", getNationality());
		attributes.put("idCardNumber", getIdCardNumber());
		attributes.put("job", getJob());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("Email", getEmail());
		attributes.put("isMother", getIsMother());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String preschoolParent_id = (String)attributes.get("preschoolParent_id");

		if (preschoolParent_id != null) {
			setPreschoolParent_id(preschoolParent_id);
		}

		String student_id = (String)attributes.get("student_id");

		if (student_id != null) {
			setStudent_id(student_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dob = (String)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String placeOfBirth = (String)attributes.get("placeOfBirth");

		if (placeOfBirth != null) {
			setPlaceOfBirth(placeOfBirth);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String idCardNumber = (String)attributes.get("idCardNumber");

		if (idCardNumber != null) {
			setIdCardNumber(idCardNumber);
		}

		String job = (String)attributes.get("job");

		if (job != null) {
			setJob(job);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
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

	public String getPreschoolParent_id() {
		return _preschoolParent_id;
	}

	public void setPreschoolParent_id(String preschoolParent_id) {
		_preschoolParent_id = preschoolParent_id;
	}

	public String getStudent_id() {
		return _student_id;
	}

	public void setStudent_id(String student_id) {
		_student_id = student_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDob() {
		return _dob;
	}

	public void setDob(String dob) {
		_dob = dob;
	}

	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
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

	public String getJob() {
		return _job;
	}

	public void setJob(String job) {
		_job = job;
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

	public BaseModel<?> getPreschoolParentRemoteModel() {
		return _preschoolParentRemoteModel;
	}

	public void setPreschoolParentRemoteModel(
		BaseModel<?> preschoolParentRemoteModel) {
		_preschoolParentRemoteModel = preschoolParentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PreschoolParentLocalServiceUtil.addPreschoolParent(this);
		}
		else {
			PreschoolParentLocalServiceUtil.updatePreschoolParent(this);
		}
	}

	@Override
	public PreschoolParent toEscapedModel() {
		return (PreschoolParent)Proxy.newProxyInstance(PreschoolParent.class.getClassLoader(),
			new Class[] { PreschoolParent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PreschoolParentClp clone = new PreschoolParentClp();

		clone.setPreschoolParent_id(getPreschoolParent_id());
		clone.setStudent_id(getStudent_id());
		clone.setName(getName());
		clone.setDob(getDob());
		clone.setPlaceOfBirth(getPlaceOfBirth());
		clone.setNationality(getNationality());
		clone.setIdCardNumber(getIdCardNumber());
		clone.setJob(getJob());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setEmail(getEmail());
		clone.setIsMother(getIsMother());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(PreschoolParent preschoolParent) {
		String primaryKey = preschoolParent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PreschoolParentClp preschoolParent = null;

		try {
			preschoolParent = (PreschoolParentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = preschoolParent.getPrimaryKey();

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

		sb.append("{preschoolParent_id=");
		sb.append(getPreschoolParent_id());
		sb.append(", student_id=");
		sb.append(getStudent_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", dob=");
		sb.append(getDob());
		sb.append(", placeOfBirth=");
		sb.append(getPlaceOfBirth());
		sb.append(", nationality=");
		sb.append(getNationality());
		sb.append(", idCardNumber=");
		sb.append(getIdCardNumber());
		sb.append(", job=");
		sb.append(getJob());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", Email=");
		sb.append(getEmail());
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
		sb.append("com.fsoft.bn.model.PreschoolParent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>preschoolParent_id</column-name><column-value><![CDATA[");
		sb.append(getPreschoolParent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_id</column-name><column-value><![CDATA[");
		sb.append(getStudent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dob</column-name><column-value><![CDATA[");
		sb.append(getDob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getPlaceOfBirth());
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
			"<column><column-name>job</column-name><column-value><![CDATA[");
		sb.append(getJob());
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

	private String _preschoolParent_id;
	private String _student_id;
	private String _name;
	private String _dob;
	private String _placeOfBirth;
	private String _nationality;
	private String _idCardNumber;
	private String _job;
	private String _phoneNumber;
	private String _Email;
	private boolean _isMother;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _preschoolParentRemoteModel;
}