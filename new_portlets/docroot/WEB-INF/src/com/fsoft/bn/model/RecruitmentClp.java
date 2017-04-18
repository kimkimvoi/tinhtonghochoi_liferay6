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

import com.fsoft.bn.service.RecruitmentLocalServiceUtil;

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
public class RecruitmentClp extends BaseModelImpl<Recruitment>
	implements Recruitment {
	public RecruitmentClp() {
	}

	public Class<?> getModelClass() {
		return Recruitment.class;
	}

	public String getModelClassName() {
		return Recruitment.class.getName();
	}

	public String getPrimaryKey() {
		return _recruitment_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setRecruitment_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _recruitment_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recruitment_id", getRecruitment_id());
		attributes.put("candidate_name", getCandidate_name());
		attributes.put("candidate_sex", getCandidate_sex());
		attributes.put("candidate_dob", getCandidate_dob());
		attributes.put("candidate_placeOfBirth", getCandidate_placeOfBirth());
		attributes.put("candidate_nationality", getCandidate_nationality());
		attributes.put("candidate_race", getCandidate_race());
		attributes.put("candidate_religion", getCandidate_religion());
		attributes.put("candidate_IdCardNumber", getCandidate_IdCardNumber());
		attributes.put("candidate_placeOfIssue", getCandidate_placeOfIssue());
		attributes.put("candidate_permanentPlace", getCandidate_permanentPlace());
		attributes.put("candidate_temporaryPlace", getCandidate_temporaryPlace());
		attributes.put("candidate_phoneNumber", getCandidate_phoneNumber());
		attributes.put("candidate_email", getCandidate_email());
		attributes.put("candidate_position", getCandidate_position());
		attributes.put("candidate_canStartDate", getCandidate_canStartDate());
		attributes.put("candidate_currentSalary", getCandidate_currentSalary());
		attributes.put("candidate_expectedSalary", getCandidate_expectedSalary());
		attributes.put("candidate_howToKnowBM", getCandidate_howToKnowBM());
		attributes.put("candidate_whoIntroduce", getCandidate_whoIntroduce());
		attributes.put("candidate_anyConfuse", getCandidate_anyConfuse());
		attributes.put("status", getStatus());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String recruitment_id = (String)attributes.get("recruitment_id");

		if (recruitment_id != null) {
			setRecruitment_id(recruitment_id);
		}

		String candidate_name = (String)attributes.get("candidate_name");

		if (candidate_name != null) {
			setCandidate_name(candidate_name);
		}

		String candidate_sex = (String)attributes.get("candidate_sex");

		if (candidate_sex != null) {
			setCandidate_sex(candidate_sex);
		}

		String candidate_dob = (String)attributes.get("candidate_dob");

		if (candidate_dob != null) {
			setCandidate_dob(candidate_dob);
		}

		String candidate_placeOfBirth = (String)attributes.get(
				"candidate_placeOfBirth");

		if (candidate_placeOfBirth != null) {
			setCandidate_placeOfBirth(candidate_placeOfBirth);
		}

		String candidate_nationality = (String)attributes.get(
				"candidate_nationality");

		if (candidate_nationality != null) {
			setCandidate_nationality(candidate_nationality);
		}

		String candidate_race = (String)attributes.get("candidate_race");

		if (candidate_race != null) {
			setCandidate_race(candidate_race);
		}

		String candidate_religion = (String)attributes.get("candidate_religion");

		if (candidate_religion != null) {
			setCandidate_religion(candidate_religion);
		}

		String candidate_IdCardNumber = (String)attributes.get(
				"candidate_IdCardNumber");

		if (candidate_IdCardNumber != null) {
			setCandidate_IdCardNumber(candidate_IdCardNumber);
		}

		String candidate_placeOfIssue = (String)attributes.get(
				"candidate_placeOfIssue");

		if (candidate_placeOfIssue != null) {
			setCandidate_placeOfIssue(candidate_placeOfIssue);
		}

		String candidate_permanentPlace = (String)attributes.get(
				"candidate_permanentPlace");

		if (candidate_permanentPlace != null) {
			setCandidate_permanentPlace(candidate_permanentPlace);
		}

		String candidate_temporaryPlace = (String)attributes.get(
				"candidate_temporaryPlace");

		if (candidate_temporaryPlace != null) {
			setCandidate_temporaryPlace(candidate_temporaryPlace);
		}

		String candidate_phoneNumber = (String)attributes.get(
				"candidate_phoneNumber");

		if (candidate_phoneNumber != null) {
			setCandidate_phoneNumber(candidate_phoneNumber);
		}

		String candidate_email = (String)attributes.get("candidate_email");

		if (candidate_email != null) {
			setCandidate_email(candidate_email);
		}

		String candidate_position = (String)attributes.get("candidate_position");

		if (candidate_position != null) {
			setCandidate_position(candidate_position);
		}

		String candidate_canStartDate = (String)attributes.get(
				"candidate_canStartDate");

		if (candidate_canStartDate != null) {
			setCandidate_canStartDate(candidate_canStartDate);
		}

		String candidate_currentSalary = (String)attributes.get(
				"candidate_currentSalary");

		if (candidate_currentSalary != null) {
			setCandidate_currentSalary(candidate_currentSalary);
		}

		String candidate_expectedSalary = (String)attributes.get(
				"candidate_expectedSalary");

		if (candidate_expectedSalary != null) {
			setCandidate_expectedSalary(candidate_expectedSalary);
		}

		String candidate_howToKnowBM = (String)attributes.get(
				"candidate_howToKnowBM");

		if (candidate_howToKnowBM != null) {
			setCandidate_howToKnowBM(candidate_howToKnowBM);
		}

		String candidate_whoIntroduce = (String)attributes.get(
				"candidate_whoIntroduce");

		if (candidate_whoIntroduce != null) {
			setCandidate_whoIntroduce(candidate_whoIntroduce);
		}

		String candidate_anyConfuse = (String)attributes.get(
				"candidate_anyConfuse");

		if (candidate_anyConfuse != null) {
			setCandidate_anyConfuse(candidate_anyConfuse);
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

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getCandidate_name() {
		return _candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		_candidate_name = candidate_name;
	}

	public String getCandidate_sex() {
		return _candidate_sex;
	}

	public void setCandidate_sex(String candidate_sex) {
		_candidate_sex = candidate_sex;
	}

	public String getCandidate_dob() {
		return _candidate_dob;
	}

	public void setCandidate_dob(String candidate_dob) {
		_candidate_dob = candidate_dob;
	}

	public String getCandidate_placeOfBirth() {
		return _candidate_placeOfBirth;
	}

	public void setCandidate_placeOfBirth(String candidate_placeOfBirth) {
		_candidate_placeOfBirth = candidate_placeOfBirth;
	}

	public String getCandidate_nationality() {
		return _candidate_nationality;
	}

	public void setCandidate_nationality(String candidate_nationality) {
		_candidate_nationality = candidate_nationality;
	}

	public String getCandidate_race() {
		return _candidate_race;
	}

	public void setCandidate_race(String candidate_race) {
		_candidate_race = candidate_race;
	}

	public String getCandidate_religion() {
		return _candidate_religion;
	}

	public void setCandidate_religion(String candidate_religion) {
		_candidate_religion = candidate_religion;
	}

	public String getCandidate_IdCardNumber() {
		return _candidate_IdCardNumber;
	}

	public void setCandidate_IdCardNumber(String candidate_IdCardNumber) {
		_candidate_IdCardNumber = candidate_IdCardNumber;
	}

	public String getCandidate_placeOfIssue() {
		return _candidate_placeOfIssue;
	}

	public void setCandidate_placeOfIssue(String candidate_placeOfIssue) {
		_candidate_placeOfIssue = candidate_placeOfIssue;
	}

	public String getCandidate_permanentPlace() {
		return _candidate_permanentPlace;
	}

	public void setCandidate_permanentPlace(String candidate_permanentPlace) {
		_candidate_permanentPlace = candidate_permanentPlace;
	}

	public String getCandidate_temporaryPlace() {
		return _candidate_temporaryPlace;
	}

	public void setCandidate_temporaryPlace(String candidate_temporaryPlace) {
		_candidate_temporaryPlace = candidate_temporaryPlace;
	}

	public String getCandidate_phoneNumber() {
		return _candidate_phoneNumber;
	}

	public void setCandidate_phoneNumber(String candidate_phoneNumber) {
		_candidate_phoneNumber = candidate_phoneNumber;
	}

	public String getCandidate_email() {
		return _candidate_email;
	}

	public void setCandidate_email(String candidate_email) {
		_candidate_email = candidate_email;
	}

	public String getCandidate_position() {
		return _candidate_position;
	}

	public void setCandidate_position(String candidate_position) {
		_candidate_position = candidate_position;
	}

	public String getCandidate_canStartDate() {
		return _candidate_canStartDate;
	}

	public void setCandidate_canStartDate(String candidate_canStartDate) {
		_candidate_canStartDate = candidate_canStartDate;
	}

	public String getCandidate_currentSalary() {
		return _candidate_currentSalary;
	}

	public void setCandidate_currentSalary(String candidate_currentSalary) {
		_candidate_currentSalary = candidate_currentSalary;
	}

	public String getCandidate_expectedSalary() {
		return _candidate_expectedSalary;
	}

	public void setCandidate_expectedSalary(String candidate_expectedSalary) {
		_candidate_expectedSalary = candidate_expectedSalary;
	}

	public String getCandidate_howToKnowBM() {
		return _candidate_howToKnowBM;
	}

	public void setCandidate_howToKnowBM(String candidate_howToKnowBM) {
		_candidate_howToKnowBM = candidate_howToKnowBM;
	}

	public String getCandidate_whoIntroduce() {
		return _candidate_whoIntroduce;
	}

	public void setCandidate_whoIntroduce(String candidate_whoIntroduce) {
		_candidate_whoIntroduce = candidate_whoIntroduce;
	}

	public String getCandidate_anyConfuse() {
		return _candidate_anyConfuse;
	}

	public void setCandidate_anyConfuse(String candidate_anyConfuse) {
		_candidate_anyConfuse = candidate_anyConfuse;
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

	public BaseModel<?> getRecruitmentRemoteModel() {
		return _recruitmentRemoteModel;
	}

	public void setRecruitmentRemoteModel(BaseModel<?> recruitmentRemoteModel) {
		_recruitmentRemoteModel = recruitmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RecruitmentLocalServiceUtil.addRecruitment(this);
		}
		else {
			RecruitmentLocalServiceUtil.updateRecruitment(this);
		}
	}

	@Override
	public Recruitment toEscapedModel() {
		return (Recruitment)Proxy.newProxyInstance(Recruitment.class.getClassLoader(),
			new Class[] { Recruitment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RecruitmentClp clone = new RecruitmentClp();

		clone.setRecruitment_id(getRecruitment_id());
		clone.setCandidate_name(getCandidate_name());
		clone.setCandidate_sex(getCandidate_sex());
		clone.setCandidate_dob(getCandidate_dob());
		clone.setCandidate_placeOfBirth(getCandidate_placeOfBirth());
		clone.setCandidate_nationality(getCandidate_nationality());
		clone.setCandidate_race(getCandidate_race());
		clone.setCandidate_religion(getCandidate_religion());
		clone.setCandidate_IdCardNumber(getCandidate_IdCardNumber());
		clone.setCandidate_placeOfIssue(getCandidate_placeOfIssue());
		clone.setCandidate_permanentPlace(getCandidate_permanentPlace());
		clone.setCandidate_temporaryPlace(getCandidate_temporaryPlace());
		clone.setCandidate_phoneNumber(getCandidate_phoneNumber());
		clone.setCandidate_email(getCandidate_email());
		clone.setCandidate_position(getCandidate_position());
		clone.setCandidate_canStartDate(getCandidate_canStartDate());
		clone.setCandidate_currentSalary(getCandidate_currentSalary());
		clone.setCandidate_expectedSalary(getCandidate_expectedSalary());
		clone.setCandidate_howToKnowBM(getCandidate_howToKnowBM());
		clone.setCandidate_whoIntroduce(getCandidate_whoIntroduce());
		clone.setCandidate_anyConfuse(getCandidate_anyConfuse());
		clone.setStatus(getStatus());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(Recruitment recruitment) {
		String primaryKey = recruitment.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		RecruitmentClp recruitment = null;

		try {
			recruitment = (RecruitmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = recruitment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(51);

		sb.append("{recruitment_id=");
		sb.append(getRecruitment_id());
		sb.append(", candidate_name=");
		sb.append(getCandidate_name());
		sb.append(", candidate_sex=");
		sb.append(getCandidate_sex());
		sb.append(", candidate_dob=");
		sb.append(getCandidate_dob());
		sb.append(", candidate_placeOfBirth=");
		sb.append(getCandidate_placeOfBirth());
		sb.append(", candidate_nationality=");
		sb.append(getCandidate_nationality());
		sb.append(", candidate_race=");
		sb.append(getCandidate_race());
		sb.append(", candidate_religion=");
		sb.append(getCandidate_religion());
		sb.append(", candidate_IdCardNumber=");
		sb.append(getCandidate_IdCardNumber());
		sb.append(", candidate_placeOfIssue=");
		sb.append(getCandidate_placeOfIssue());
		sb.append(", candidate_permanentPlace=");
		sb.append(getCandidate_permanentPlace());
		sb.append(", candidate_temporaryPlace=");
		sb.append(getCandidate_temporaryPlace());
		sb.append(", candidate_phoneNumber=");
		sb.append(getCandidate_phoneNumber());
		sb.append(", candidate_email=");
		sb.append(getCandidate_email());
		sb.append(", candidate_position=");
		sb.append(getCandidate_position());
		sb.append(", candidate_canStartDate=");
		sb.append(getCandidate_canStartDate());
		sb.append(", candidate_currentSalary=");
		sb.append(getCandidate_currentSalary());
		sb.append(", candidate_expectedSalary=");
		sb.append(getCandidate_expectedSalary());
		sb.append(", candidate_howToKnowBM=");
		sb.append(getCandidate_howToKnowBM());
		sb.append(", candidate_whoIntroduce=");
		sb.append(getCandidate_whoIntroduce());
		sb.append(", candidate_anyConfuse=");
		sb.append(getCandidate_anyConfuse());
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
		StringBundler sb = new StringBundler(79);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Recruitment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recruitment_id</column-name><column-value><![CDATA[");
		sb.append(getRecruitment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_name</column-name><column-value><![CDATA[");
		sb.append(getCandidate_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_sex</column-name><column-value><![CDATA[");
		sb.append(getCandidate_sex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_dob</column-name><column-value><![CDATA[");
		sb.append(getCandidate_dob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getCandidate_placeOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_nationality</column-name><column-value><![CDATA[");
		sb.append(getCandidate_nationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_race</column-name><column-value><![CDATA[");
		sb.append(getCandidate_race());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_religion</column-name><column-value><![CDATA[");
		sb.append(getCandidate_religion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_IdCardNumber</column-name><column-value><![CDATA[");
		sb.append(getCandidate_IdCardNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_placeOfIssue</column-name><column-value><![CDATA[");
		sb.append(getCandidate_placeOfIssue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_permanentPlace</column-name><column-value><![CDATA[");
		sb.append(getCandidate_permanentPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_temporaryPlace</column-name><column-value><![CDATA[");
		sb.append(getCandidate_temporaryPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getCandidate_phoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_email</column-name><column-value><![CDATA[");
		sb.append(getCandidate_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_position</column-name><column-value><![CDATA[");
		sb.append(getCandidate_position());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_canStartDate</column-name><column-value><![CDATA[");
		sb.append(getCandidate_canStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_currentSalary</column-name><column-value><![CDATA[");
		sb.append(getCandidate_currentSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_expectedSalary</column-name><column-value><![CDATA[");
		sb.append(getCandidate_expectedSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_howToKnowBM</column-name><column-value><![CDATA[");
		sb.append(getCandidate_howToKnowBM());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_whoIntroduce</column-name><column-value><![CDATA[");
		sb.append(getCandidate_whoIntroduce());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidate_anyConfuse</column-name><column-value><![CDATA[");
		sb.append(getCandidate_anyConfuse());
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

	private String _recruitment_id;
	private String _candidate_name;
	private String _candidate_sex;
	private String _candidate_dob;
	private String _candidate_placeOfBirth;
	private String _candidate_nationality;
	private String _candidate_race;
	private String _candidate_religion;
	private String _candidate_IdCardNumber;
	private String _candidate_placeOfIssue;
	private String _candidate_permanentPlace;
	private String _candidate_temporaryPlace;
	private String _candidate_phoneNumber;
	private String _candidate_email;
	private String _candidate_position;
	private String _candidate_canStartDate;
	private String _candidate_currentSalary;
	private String _candidate_expectedSalary;
	private String _candidate_howToKnowBM;
	private String _candidate_whoIntroduce;
	private String _candidate_anyConfuse;
	private String _status;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
	private BaseModel<?> _recruitmentRemoteModel;
}