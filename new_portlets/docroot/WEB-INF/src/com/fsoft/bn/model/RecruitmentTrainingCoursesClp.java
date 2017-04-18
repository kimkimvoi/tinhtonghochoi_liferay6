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

import com.fsoft.bn.service.RecruitmentTrainingCoursesLocalServiceUtil;

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
public class RecruitmentTrainingCoursesClp extends BaseModelImpl<RecruitmentTrainingCourses>
	implements RecruitmentTrainingCourses {
	public RecruitmentTrainingCoursesClp() {
	}

	public Class<?> getModelClass() {
		return RecruitmentTrainingCourses.class;
	}

	public String getModelClassName() {
		return RecruitmentTrainingCourses.class.getName();
	}

	public String getPrimaryKey() {
		return _recruitment_training_courses_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_training_courses_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_training_courses_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_training_courses_id",
			getRecruitment_training_courses_id());
		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("conductedBy", getConductedBy());
		attributes.put("courseName", getCourseName());
		attributes.put("courseDesc", getCourseDesc());
		attributes.put("courseDate", getCourseDate());
		attributes.put("certificate", getCertificate());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_training_courses_id = (String)attributes.get(
				"recruitment_training_courses_id");

		if (recruitment_training_courses_id != null) {
			setRecruitment_training_courses_id(recruitment_training_courses_id);
		}

		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String conductedBy = (String)attributes.get("conductedBy");

		if (conductedBy != null) {
			setConductedBy(conductedBy);
		}

		String courseName = (String)attributes.get("courseName");

		if (courseName != null) {
			setCourseName(courseName);
		}

		String courseDesc = (String)attributes.get("courseDesc");

		if (courseDesc != null) {
			setCourseDesc(courseDesc);
		}

		String courseDate = (String)attributes.get("courseDate");

		if (courseDate != null) {
			setCourseDate(courseDate);
		}

		String certificate = (String)attributes.get("certificate");

		if (certificate != null) {
			setCertificate(certificate);
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

	public String getRecruitment_training_courses_id() {
		return _recruitment_training_courses_id;
	}

	public void setRecruitment_training_courses_id(
		String recruitment_training_courses_id) {
		_recruitment_training_courses_id = recruitment_training_courses_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getConductedBy() {
		return _conductedBy;
	}

	public void setConductedBy(String conductedBy) {
		_conductedBy = conductedBy;
	}

	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String courseName) {
		_courseName = courseName;
	}

	public String getCourseDesc() {
		return _courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		_courseDesc = courseDesc;
	}

	public String getCourseDate() {
		return _courseDate;
	}

	public void setCourseDate(String courseDate) {
		_courseDate = courseDate;
	}

	public String getCertificate() {
		return _certificate;
	}

	public void setCertificate(String certificate) {
		_certificate = certificate;
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

	public BaseModel<?> getRecruitmentTrainingCoursesRemoteModel() {
		return _recruitmentTrainingCoursesRemoteModel;
	}

	public void setRecruitmentTrainingCoursesRemoteModel(
		BaseModel<?> recruitmentTrainingCoursesRemoteModel) {
		_recruitmentTrainingCoursesRemoteModel = recruitmentTrainingCoursesRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RecruitmentTrainingCoursesLocalServiceUtil.addRecruitmentTrainingCourses(this);
		}
		else {
			RecruitmentTrainingCoursesLocalServiceUtil.updateRecruitmentTrainingCourses(this);
		}
	}

	@Override
	public RecruitmentTrainingCourses toEscapedModel() {
		return (RecruitmentTrainingCourses)Proxy.newProxyInstance(RecruitmentTrainingCourses.class.getClassLoader(),
			new Class[] { RecruitmentTrainingCourses.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecruitmentTrainingCoursesClp clone = new RecruitmentTrainingCoursesClp();

		clone.setRecruitment_training_courses_id(getRecruitment_training_courses_id());
		clone.setRecruitment_id(getRecruitment_id());
		clone.setConductedBy(getConductedBy());
		clone.setCourseName(getCourseName());
		clone.setCourseDesc(getCourseDesc());
		clone.setCourseDate(getCourseDate());
		clone.setCertificate(getCertificate());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(RecruitmentTrainingCourses recruitmentTrainingCourses) {
		String primaryKey = recruitmentTrainingCourses.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentTrainingCoursesClp recruitmentTrainingCourses = null;

		try {
			recruitmentTrainingCourses = (RecruitmentTrainingCoursesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitmentTrainingCourses.getPrimaryKey();

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

		sb.append("{recruitment_training_courses_id=");
		sb.append(getRecruitment_training_courses_id());
		sb.append(", recruitment_id=");
		sb.append(getRecruitment_id());
		sb.append(", conductedBy=");
		sb.append(getConductedBy());
		sb.append(", courseName=");
		sb.append(getCourseName());
		sb.append(", courseDesc=");
		sb.append(getCourseDesc());
		sb.append(", courseDate=");
		sb.append(getCourseDate());
		sb.append(", certificate=");
		sb.append(getCertificate());
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
		sb.append("com.fsoft.bn.model.RecruitmentTrainingCourses");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_training_courses_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_training_courses_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conductedBy</column-name><column-value><![CDATA[");
		sb.append(getConductedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseName</column-name><column-value><![CDATA[");
		sb.append(getCourseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDesc</column-name><column-value><![CDATA[");
		sb.append(getCourseDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDate</column-name><column-value><![CDATA[");
		sb.append(getCourseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificate</column-name><column-value><![CDATA[");
		sb.append(getCertificate());
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

	private String _recruitment_training_courses_id;
	private String _recruitment_id;
	private String _conductedBy;
	private String _courseName;
	private String _courseDesc;
	private String _courseDate;
	private String _certificate;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _recruitmentTrainingCoursesRemoteModel;
}