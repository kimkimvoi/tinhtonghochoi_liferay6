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

import com.fsoft.bn.service.RecruitmentEducationalHistoryLocalServiceUtil;

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
public class RecruitmentEducationalHistoryClp extends BaseModelImpl<RecruitmentEducationalHistory>
	implements RecruitmentEducationalHistory {
	public RecruitmentEducationalHistoryClp() {
	}

	public Class<?> getModelClass() {
		return RecruitmentEducationalHistory.class;
	}

	public String getModelClassName() {
		return RecruitmentEducationalHistory.class.getName();
	}

	public String getPrimaryKey() {
		return _recruitment_educational_history_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_educational_history_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_educational_history_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_educational_history_id",
			getRecruitment_educational_history_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("school", getSchool());
		attributes.put("typeOfTraining", getTypeOfTraining());
		attributes.put("speciality", getSpeciality());
		attributes.put("typeOfDegree", getTypeOfDegree());
		attributes.put("graduatedYear", getGraduatedYear());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_educational_history_id = (String)attributes.get(
				"recruitment_educational_history_id");

		if (recruitment_educational_history_id != null) {
			setRecruitment_educational_history_id(recruitment_educational_history_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String school = (String)attributes.get("school");

		if (school != null) {
			setSchool(school);
		}

		String typeOfTraining = (String)attributes.get("typeOfTraining");

		if (typeOfTraining != null) {
			setTypeOfTraining(typeOfTraining);
		}

		String speciality = (String)attributes.get("speciality");

		if (speciality != null) {
			setSpeciality(speciality);
		}

		String typeOfDegree = (String)attributes.get("typeOfDegree");

		if (typeOfDegree != null) {
			setTypeOfDegree(typeOfDegree);
		}

		String graduatedYear = (String)attributes.get("graduatedYear");

		if (graduatedYear != null) {
			setGraduatedYear(graduatedYear);
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

	public String getRecruitment_educational_history_id() {
		return _recruitment_educational_history_id;
	}

	public void setRecruitment_educational_history_id(
		String recruitment_educational_history_id) {
		_recruitment_educational_history_id = recruitment_educational_history_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getSchool() {
		return _school;
	}

	public void setSchool(String school) {
		_school = school;
	}

	public String getTypeOfTraining() {
		return _typeOfTraining;
	}

	public void setTypeOfTraining(String typeOfTraining) {
		_typeOfTraining = typeOfTraining;
	}

	public String getSpeciality() {
		return _speciality;
	}

	public void setSpeciality(String speciality) {
		_speciality = speciality;
	}

	public String getTypeOfDegree() {
		return _typeOfDegree;
	}

	public void setTypeOfDegree(String typeOfDegree) {
		_typeOfDegree = typeOfDegree;
	}

	public String getGraduatedYear() {
		return _graduatedYear;
	}

	public void setGraduatedYear(String graduatedYear) {
		_graduatedYear = graduatedYear;
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

	public BaseModel<?> getRecruitmentEducationalHistoryRemoteModel() {
		return _recruitmentEducationalHistoryRemoteModel;
	}

	public void setRecruitmentEducationalHistoryRemoteModel(
		BaseModel<?> recruitmentEducationalHistoryRemoteModel) {
		_recruitmentEducationalHistoryRemoteModel = recruitmentEducationalHistoryRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RecruitmentEducationalHistoryLocalServiceUtil.addRecruitmentEducationalHistory(this);
		}
		else {
			RecruitmentEducationalHistoryLocalServiceUtil.updateRecruitmentEducationalHistory(this);
		}
	}

	@Override
	public RecruitmentEducationalHistory toEscapedModel() {
		return (RecruitmentEducationalHistory)Proxy.newProxyInstance(RecruitmentEducationalHistory.class.getClassLoader(),
			new Class[] { RecruitmentEducationalHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecruitmentEducationalHistoryClp clone = new RecruitmentEducationalHistoryClp();

		clone.setRecruitment_educational_history_id(getRecruitment_educational_history_id());
		clone.setRecruitment_id(getRecruitment_id());
		clone.setSchool(getSchool());
		clone.setTypeOfTraining(getTypeOfTraining());
		clone.setSpeciality(getSpeciality());
		clone.setTypeOfDegree(getTypeOfDegree());
		clone.setGraduatedYear(getGraduatedYear());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(
		RecruitmentEducationalHistory recruitmentEducationalHistory) {
		String primaryKey = recruitmentEducationalHistory.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentEducationalHistoryClp recruitmentEducationalHistory = null;

		try {
			recruitmentEducationalHistory = (RecruitmentEducationalHistoryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitmentEducationalHistory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{recruitment_educational_history_id=");
		sb.append(getRecruitment_educational_history_id());
		sb.append(", recruitment_id=");
		sb.append(getRecruitment_id());
		sb.append(", school=");
		sb.append(getSchool());
		sb.append(", typeOfTraining=");
		sb.append(getTypeOfTraining());
		sb.append(", speciality=");
		sb.append(getSpeciality());
		sb.append(", typeOfDegree=");
		sb.append(getTypeOfDegree());
		sb.append(", graduatedYear=");
		sb.append(getGraduatedYear());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.RecruitmentEducationalHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_educational_history_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_educational_history_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>school</column-name><column-value><![CDATA[");
		sb.append(getSchool());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfTraining</column-name><column-value><![CDATA[");
		sb.append(getTypeOfTraining());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>speciality</column-name><column-value><![CDATA[");
		sb.append(getSpeciality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfDegree</column-name><column-value><![CDATA[");
		sb.append(getTypeOfDegree());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graduatedYear</column-name><column-value><![CDATA[");
		sb.append(getGraduatedYear());
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

	private String _recruitment_educational_history_id;
	private String _recruitment_id;
	private String _school;
	private String _typeOfTraining;
	private String _speciality;
	private String _typeOfDegree;
	private String _graduatedYear;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _recruitmentEducationalHistoryRemoteModel;
}