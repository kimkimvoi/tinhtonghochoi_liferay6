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
public class RecruitmentLanguagesSoap implements Serializable {
	public static RecruitmentLanguagesSoap toSoapModel(
		RecruitmentLanguages model) {
		RecruitmentLanguagesSoap soapModel = new RecruitmentLanguagesSoap();

		soapModel.setRecruitment_languages_id(model.getRecruitment_languages_id());
		soapModel.setRecruitment_id(model.getRecruitment_id());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setLevel(model.getLevel());
		soapModel.setCertificate(model.getCertificate());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static RecruitmentLanguagesSoap[] toSoapModels(
		RecruitmentLanguages[] models) {
		RecruitmentLanguagesSoap[] soapModels = new RecruitmentLanguagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentLanguagesSoap[][] toSoapModels(
		RecruitmentLanguages[][] models) {
		RecruitmentLanguagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecruitmentLanguagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecruitmentLanguagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecruitmentLanguagesSoap[] toSoapModels(
		List<RecruitmentLanguages> models) {
		List<RecruitmentLanguagesSoap> soapModels = new ArrayList<RecruitmentLanguagesSoap>(models.size());

		for (RecruitmentLanguages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecruitmentLanguagesSoap[soapModels.size()]);
	}

	public RecruitmentLanguagesSoap() {
	}

	public String getPrimaryKey() {
		return _recruitment_languages_id;
	}

	public void setPrimaryKey(String pk) {
		setRecruitment_languages_id(pk);
	}

	public String getRecruitment_languages_id() {
		return _recruitment_languages_id;
	}

	public void setRecruitment_languages_id(String recruitment_languages_id) {
		_recruitment_languages_id = recruitment_languages_id;
	}

	public String getRecruitment_id() {
		return _recruitment_id;
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		_level = level;
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

	private String _recruitment_languages_id;
	private String _recruitment_id;
	private String _language;
	private String _level;
	private String _certificate;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}