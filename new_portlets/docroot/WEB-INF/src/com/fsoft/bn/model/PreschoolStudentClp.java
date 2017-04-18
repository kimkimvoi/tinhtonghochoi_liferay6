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

import com.fsoft.bn.service.PreschoolStudentLocalServiceUtil;

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
public class PreschoolStudentClp extends BaseModelImpl<PreschoolStudent>
	implements PreschoolStudent {
	public PreschoolStudentClp() {
	}

	public Class<?> getModelClass() {
		return PreschoolStudent.class;
	}

	public String getModelClassName() {
		return PreschoolStudent.class.getName();
	}

	public String getPrimaryKey() {
		return _student_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setStudent_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _student_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("student_id", getStudent_id());
		attributes.put("student_name", getStudent_name());
		attributes.put("student_sex", getStudent_sex());
		attributes.put("student_dob", getStudent_dob());
		attributes.put("student_placeOfBirth", getStudent_placeOfBirth());
		attributes.put("student_nationality", getStudent_nationality());
		attributes.put("student_phoneNumber", getStudent_phoneNumber());
		attributes.put("student_address", getStudent_address());
		attributes.put("student_heatlhStatus", getStudent_heatlhStatus());
		attributes.put("student_height", getStudent_height());
		attributes.put("student_weight", getStudent_weight());
		attributes.put("student_contactName", getStudent_contactName());
		attributes.put("student_contactRelationship",
			getStudent_contactRelationship());
		attributes.put("student_contactPhoneNumber",
			getStudent_contactPhoneNumber());
		attributes.put("student_contactEmail", getStudent_contactEmail());
		attributes.put("student_howToKnowBM", getStudent_howToKnowBM());
		attributes.put("student_whoIntroduce", getStudent_whoIntroduce());
		attributes.put("student_anyConfuse", getStudent_anyConfuse());
		attributes.put("status", getStatus());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String student_id = (String)attributes.get("student_id");

		if (student_id != null) {
			setStudent_id(student_id);
		}

		String student_name = (String)attributes.get("student_name");

		if (student_name != null) {
			setStudent_name(student_name);
		}

		String student_sex = (String)attributes.get("student_sex");

		if (student_sex != null) {
			setStudent_sex(student_sex);
		}

		String student_dob = (String)attributes.get("student_dob");

		if (student_dob != null) {
			setStudent_dob(student_dob);
		}

		String student_placeOfBirth = (String)attributes.get(
				"student_placeOfBirth");

		if (student_placeOfBirth != null) {
			setStudent_placeOfBirth(student_placeOfBirth);
		}

		String student_nationality = (String)attributes.get(
				"student_nationality");

		if (student_nationality != null) {
			setStudent_nationality(student_nationality);
		}

		String student_phoneNumber = (String)attributes.get(
				"student_phoneNumber");

		if (student_phoneNumber != null) {
			setStudent_phoneNumber(student_phoneNumber);
		}

		String student_address = (String)attributes.get("student_address");

		if (student_address != null) {
			setStudent_address(student_address);
		}

		String student_heatlhStatus = (String)attributes.get(
				"student_heatlhStatus");

		if (student_heatlhStatus != null) {
			setStudent_heatlhStatus(student_heatlhStatus);
		}

		String student_height = (String)attributes.get("student_height");

		if (student_height != null) {
			setStudent_height(student_height);
		}

		String student_weight = (String)attributes.get("student_weight");

		if (student_weight != null) {
			setStudent_weight(student_weight);
		}

		String student_contactName = (String)attributes.get(
				"student_contactName");

		if (student_contactName != null) {
			setStudent_contactName(student_contactName);
		}

		String student_contactRelationship = (String)attributes.get(
				"student_contactRelationship");

		if (student_contactRelationship != null) {
			setStudent_contactRelationship(student_contactRelationship);
		}

		String student_contactPhoneNumber = (String)attributes.get(
				"student_contactPhoneNumber");

		if (student_contactPhoneNumber != null) {
			setStudent_contactPhoneNumber(student_contactPhoneNumber);
		}

		String student_contactEmail = (String)attributes.get(
				"student_contactEmail");

		if (student_contactEmail != null) {
			setStudent_contactEmail(student_contactEmail);
		}

		String student_howToKnowBM = (String)attributes.get(
				"student_howToKnowBM");

		if (student_howToKnowBM != null) {
			setStudent_howToKnowBM(student_howToKnowBM);
		}

		String student_whoIntroduce = (String)attributes.get(
				"student_whoIntroduce");

		if (student_whoIntroduce != null) {
			setStudent_whoIntroduce(student_whoIntroduce);
		}

		String student_anyConfuse = (String)attributes.get("student_anyConfuse");

		if (student_anyConfuse != null) {
			setStudent_anyConfuse(student_anyConfuse);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

	public String getStudent_id() {
		return _student_id;
	}

	public void setStudent_id(String student_id) {
		_student_id = student_id;
	}

	public String getStudent_name() {
		return _student_name;
	}

	public void setStudent_name(String student_name) {
		_student_name = student_name;
	}

	public String getStudent_sex() {
		return _student_sex;
	}

	public void setStudent_sex(String student_sex) {
		_student_sex = student_sex;
	}

	public String getStudent_dob() {
		return _student_dob;
	}

	public void setStudent_dob(String student_dob) {
		_student_dob = student_dob;
	}

	public String getStudent_placeOfBirth() {
		return _student_placeOfBirth;
	}

	public void setStudent_placeOfBirth(String student_placeOfBirth) {
		_student_placeOfBirth = student_placeOfBirth;
	}

	public String getStudent_nationality() {
		return _student_nationality;
	}

	public void setStudent_nationality(String student_nationality) {
		_student_nationality = student_nationality;
	}

	public String getStudent_phoneNumber() {
		return _student_phoneNumber;
	}

	public void setStudent_phoneNumber(String student_phoneNumber) {
		_student_phoneNumber = student_phoneNumber;
	}

	public String getStudent_address() {
		return _student_address;
	}

	public void setStudent_address(String student_address) {
		_student_address = student_address;
	}

	public String getStudent_heatlhStatus() {
		return _student_heatlhStatus;
	}

	public void setStudent_heatlhStatus(String student_heatlhStatus) {
		_student_heatlhStatus = student_heatlhStatus;
	}

	public String getStudent_height() {
		return _student_height;
	}

	public void setStudent_height(String student_height) {
		_student_height = student_height;
	}

	public String getStudent_weight() {
		return _student_weight;
	}

	public void setStudent_weight(String student_weight) {
		_student_weight = student_weight;
	}

	public String getStudent_contactName() {
		return _student_contactName;
	}

	public void setStudent_contactName(String student_contactName) {
		_student_contactName = student_contactName;
	}

	public String getStudent_contactRelationship() {
		return _student_contactRelationship;
	}

	public void setStudent_contactRelationship(
		String student_contactRelationship) {
		_student_contactRelationship = student_contactRelationship;
	}

	public String getStudent_contactPhoneNumber() {
		return _student_contactPhoneNumber;
	}

	public void setStudent_contactPhoneNumber(String student_contactPhoneNumber) {
		_student_contactPhoneNumber = student_contactPhoneNumber;
	}

	public String getStudent_contactEmail() {
		return _student_contactEmail;
	}

	public void setStudent_contactEmail(String student_contactEmail) {
		_student_contactEmail = student_contactEmail;
	}

	public String getStudent_howToKnowBM() {
		return _student_howToKnowBM;
	}

	public void setStudent_howToKnowBM(String student_howToKnowBM) {
		_student_howToKnowBM = student_howToKnowBM;
	}

	public String getStudent_whoIntroduce() {
		return _student_whoIntroduce;
	}

	public void setStudent_whoIntroduce(String student_whoIntroduce) {
		_student_whoIntroduce = student_whoIntroduce;
	}

	public String getStudent_anyConfuse() {
		return _student_anyConfuse;
	}

	public void setStudent_anyConfuse(String student_anyConfuse) {
		_student_anyConfuse = student_anyConfuse;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	public BaseModel<?> getPreschoolStudentRemoteModel() {
		return _preschoolStudentRemoteModel;
	}

	public void setPreschoolStudentRemoteModel(
		BaseModel<?> preschoolStudentRemoteModel) {
		_preschoolStudentRemoteModel = preschoolStudentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PreschoolStudentLocalServiceUtil.addPreschoolStudent(this);
		}
		else {
			PreschoolStudentLocalServiceUtil.updatePreschoolStudent(this);
		}
	}

	@Override
	public PreschoolStudent toEscapedModel() {
		return (PreschoolStudent)Proxy.newProxyInstance(PreschoolStudent.class.getClassLoader(),
			new Class[] { PreschoolStudent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PreschoolStudentClp clone = new PreschoolStudentClp();

		clone.setStudent_id(getStudent_id());
		clone.setStudent_name(getStudent_name());
		clone.setStudent_sex(getStudent_sex());
		clone.setStudent_dob(getStudent_dob());
		clone.setStudent_placeOfBirth(getStudent_placeOfBirth());
		clone.setStudent_nationality(getStudent_nationality());
		clone.setStudent_phoneNumber(getStudent_phoneNumber());
		clone.setStudent_address(getStudent_address());
		clone.setStudent_heatlhStatus(getStudent_heatlhStatus());
		clone.setStudent_height(getStudent_height());
		clone.setStudent_weight(getStudent_weight());
		clone.setStudent_contactName(getStudent_contactName());
		clone.setStudent_contactRelationship(getStudent_contactRelationship());
		clone.setStudent_contactPhoneNumber(getStudent_contactPhoneNumber());
		clone.setStudent_contactEmail(getStudent_contactEmail());
		clone.setStudent_howToKnowBM(getStudent_howToKnowBM());
		clone.setStudent_whoIntroduce(getStudent_whoIntroduce());
		clone.setStudent_anyConfuse(getStudent_anyConfuse());
		clone.setStatus(getStatus());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(PreschoolStudent preschoolStudent) {
		String primaryKey = preschoolStudent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PreschoolStudentClp preschoolStudent = null;

		try {
			preschoolStudent = (PreschoolStudentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = preschoolStudent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{student_id=");
		sb.append(getStudent_id());
		sb.append(", student_name=");
		sb.append(getStudent_name());
		sb.append(", student_sex=");
		sb.append(getStudent_sex());
		sb.append(", student_dob=");
		sb.append(getStudent_dob());
		sb.append(", student_placeOfBirth=");
		sb.append(getStudent_placeOfBirth());
		sb.append(", student_nationality=");
		sb.append(getStudent_nationality());
		sb.append(", student_phoneNumber=");
		sb.append(getStudent_phoneNumber());
		sb.append(", student_address=");
		sb.append(getStudent_address());
		sb.append(", student_heatlhStatus=");
		sb.append(getStudent_heatlhStatus());
		sb.append(", student_height=");
		sb.append(getStudent_height());
		sb.append(", student_weight=");
		sb.append(getStudent_weight());
		sb.append(", student_contactName=");
		sb.append(getStudent_contactName());
		sb.append(", student_contactRelationship=");
		sb.append(getStudent_contactRelationship());
		sb.append(", student_contactPhoneNumber=");
		sb.append(getStudent_contactPhoneNumber());
		sb.append(", student_contactEmail=");
		sb.append(getStudent_contactEmail());
		sb.append(", student_howToKnowBM=");
		sb.append(getStudent_howToKnowBM());
		sb.append(", student_whoIntroduce=");
		sb.append(getStudent_whoIntroduce());
		sb.append(", student_anyConfuse=");
		sb.append(getStudent_anyConfuse());
		sb.append(", status=");
		sb.append(getStatus());
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
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.PreschoolStudent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>student_id</column-name><column-value><![CDATA[");
		sb.append(getStudent_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_name</column-name><column-value><![CDATA[");
		sb.append(getStudent_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_sex</column-name><column-value><![CDATA[");
		sb.append(getStudent_sex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_dob</column-name><column-value><![CDATA[");
		sb.append(getStudent_dob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getStudent_placeOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_nationality</column-name><column-value><![CDATA[");
		sb.append(getStudent_nationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getStudent_phoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_address</column-name><column-value><![CDATA[");
		sb.append(getStudent_address());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_heatlhStatus</column-name><column-value><![CDATA[");
		sb.append(getStudent_heatlhStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_height</column-name><column-value><![CDATA[");
		sb.append(getStudent_height());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_weight</column-name><column-value><![CDATA[");
		sb.append(getStudent_weight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactName</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactRelationship</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactRelationship());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactPhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_contactEmail</column-name><column-value><![CDATA[");
		sb.append(getStudent_contactEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_howToKnowBM</column-name><column-value><![CDATA[");
		sb.append(getStudent_howToKnowBM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_whoIntroduce</column-name><column-value><![CDATA[");
		sb.append(getStudent_whoIntroduce());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>student_anyConfuse</column-name><column-value><![CDATA[");
		sb.append(getStudent_anyConfuse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private String _student_id;
	private String _student_name;
	private String _student_sex;
	private String _student_dob;
	private String _student_placeOfBirth;
	private String _student_nationality;
	private String _student_phoneNumber;
	private String _student_address;
	private String _student_heatlhStatus;
	private String _student_height;
	private String _student_weight;
	private String _student_contactName;
	private String _student_contactRelationship;
	private String _student_contactPhoneNumber;
	private String _student_contactEmail;
	private String _student_howToKnowBM;
	private String _student_whoIntroduce;
	private String _student_anyConfuse;
	private String _status;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _preschoolStudentRemoteModel;
}