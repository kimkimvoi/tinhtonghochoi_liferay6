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

import com.fsoft.bn.model.Recruitment;
import com.fsoft.bn.model.RecruitmentModel;

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
 * The base model implementation for the Recruitment service. Represents a row in the &quot;BN_Recruitment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsoft.bn.model.RecruitmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RecruitmentImpl}.
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentImpl
 * @see com.fsoft.bn.model.Recruitment
 * @see com.fsoft.bn.model.RecruitmentModel
 * @generated
 */
public class RecruitmentModelImpl extends BaseModelImpl<Recruitment>
	implements RecruitmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a recruitment model instance should use the {@link com.fsoft.bn.model.Recruitment} interface instead.
	 */
	public static final String TABLE_NAME = "BN_Recruitment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "recruitment_id", Types.VARCHAR },
			{ "candidate_name", Types.VARCHAR },
			{ "candidate_sex", Types.VARCHAR },
			{ "candidate_dob", Types.VARCHAR },
			{ "candidate_placeOfBirth", Types.VARCHAR },
			{ "candidate_nationality", Types.VARCHAR },
			{ "candidate_race", Types.VARCHAR },
			{ "candidate_religion", Types.VARCHAR },
			{ "candidate_IdCardNumber", Types.VARCHAR },
			{ "candidate_placeOfIssue", Types.VARCHAR },
			{ "candidate_permanentPlace", Types.VARCHAR },
			{ "candidate_temporaryPlace", Types.VARCHAR },
			{ "candidate_phoneNumber", Types.VARCHAR },
			{ "candidate_email", Types.VARCHAR },
			{ "candidate_position", Types.VARCHAR },
			{ "candidate_canStartDate", Types.VARCHAR },
			{ "candidate_currentSalary", Types.VARCHAR },
			{ "candidate_expectedSalary", Types.VARCHAR },
			{ "candidate_howToKnowBM", Types.VARCHAR },
			{ "candidate_whoIntroduce", Types.VARCHAR },
			{ "candidate_anyConfuse", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "created_date", Types.TIMESTAMP },
			{ "modified_date", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table BN_Recruitment (recruitment_id VARCHAR(75) not null primary key,candidate_name VARCHAR(75) null,candidate_sex VARCHAR(75) null,candidate_dob VARCHAR(75) null,candidate_placeOfBirth VARCHAR(75) null,candidate_nationality VARCHAR(75) null,candidate_race VARCHAR(75) null,candidate_religion VARCHAR(75) null,candidate_IdCardNumber VARCHAR(75) null,candidate_placeOfIssue VARCHAR(75) null,candidate_permanentPlace VARCHAR(75) null,candidate_temporaryPlace VARCHAR(75) null,candidate_phoneNumber VARCHAR(75) null,candidate_email VARCHAR(75) null,candidate_position VARCHAR(75) null,candidate_canStartDate VARCHAR(75) null,candidate_currentSalary VARCHAR(75) null,candidate_expectedSalary VARCHAR(75) null,candidate_howToKnowBM VARCHAR(75) null,candidate_whoIntroduce VARCHAR(75) null,candidate_anyConfuse VARCHAR(75) null,status VARCHAR(75) null,created_date DATE null,modified_date DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table BN_Recruitment";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.fsoft.bn.model.Recruitment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.fsoft.bn.model.Recruitment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.fsoft.bn.model.Recruitment"));

	public RecruitmentModelImpl() {
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

	public Class<?> getModelClass() {
		return Recruitment.class;
	}

	public String getModelClassName() {
		return Recruitment.class.getName();
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
		if (_recruitment_id == null) {
			return StringPool.BLANK;
		}
		else {
			return _recruitment_id;
		}
	}

	public void setRecruitment_id(String recruitment_id) {
		_recruitment_id = recruitment_id;
	}

	public String getCandidate_name() {
		if (_candidate_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_name;
		}
	}

	public void setCandidate_name(String candidate_name) {
		_candidate_name = candidate_name;
	}

	public String getCandidate_sex() {
		if (_candidate_sex == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_sex;
		}
	}

	public void setCandidate_sex(String candidate_sex) {
		_candidate_sex = candidate_sex;
	}

	public String getCandidate_dob() {
		if (_candidate_dob == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_dob;
		}
	}

	public void setCandidate_dob(String candidate_dob) {
		_candidate_dob = candidate_dob;
	}

	public String getCandidate_placeOfBirth() {
		if (_candidate_placeOfBirth == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_placeOfBirth;
		}
	}

	public void setCandidate_placeOfBirth(String candidate_placeOfBirth) {
		_candidate_placeOfBirth = candidate_placeOfBirth;
	}

	public String getCandidate_nationality() {
		if (_candidate_nationality == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_nationality;
		}
	}

	public void setCandidate_nationality(String candidate_nationality) {
		_candidate_nationality = candidate_nationality;
	}

	public String getCandidate_race() {
		if (_candidate_race == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_race;
		}
	}

	public void setCandidate_race(String candidate_race) {
		_candidate_race = candidate_race;
	}

	public String getCandidate_religion() {
		if (_candidate_religion == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_religion;
		}
	}

	public void setCandidate_religion(String candidate_religion) {
		_candidate_religion = candidate_religion;
	}

	public String getCandidate_IdCardNumber() {
		if (_candidate_IdCardNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_IdCardNumber;
		}
	}

	public void setCandidate_IdCardNumber(String candidate_IdCardNumber) {
		_candidate_IdCardNumber = candidate_IdCardNumber;
	}

	public String getCandidate_placeOfIssue() {
		if (_candidate_placeOfIssue == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_placeOfIssue;
		}
	}

	public void setCandidate_placeOfIssue(String candidate_placeOfIssue) {
		_candidate_placeOfIssue = candidate_placeOfIssue;
	}

	public String getCandidate_permanentPlace() {
		if (_candidate_permanentPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_permanentPlace;
		}
	}

	public void setCandidate_permanentPlace(String candidate_permanentPlace) {
		_candidate_permanentPlace = candidate_permanentPlace;
	}

	public String getCandidate_temporaryPlace() {
		if (_candidate_temporaryPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_temporaryPlace;
		}
	}

	public void setCandidate_temporaryPlace(String candidate_temporaryPlace) {
		_candidate_temporaryPlace = candidate_temporaryPlace;
	}

	public String getCandidate_phoneNumber() {
		if (_candidate_phoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_phoneNumber;
		}
	}

	public void setCandidate_phoneNumber(String candidate_phoneNumber) {
		_candidate_phoneNumber = candidate_phoneNumber;
	}

	public String getCandidate_email() {
		if (_candidate_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_email;
		}
	}

	public void setCandidate_email(String candidate_email) {
		_candidate_email = candidate_email;
	}

	public String getCandidate_position() {
		if (_candidate_position == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_position;
		}
	}

	public void setCandidate_position(String candidate_position) {
		_candidate_position = candidate_position;
	}

	public String getCandidate_canStartDate() {
		if (_candidate_canStartDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_canStartDate;
		}
	}

	public void setCandidate_canStartDate(String candidate_canStartDate) {
		_candidate_canStartDate = candidate_canStartDate;
	}

	public String getCandidate_currentSalary() {
		if (_candidate_currentSalary == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_currentSalary;
		}
	}

	public void setCandidate_currentSalary(String candidate_currentSalary) {
		_candidate_currentSalary = candidate_currentSalary;
	}

	public String getCandidate_expectedSalary() {
		if (_candidate_expectedSalary == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_expectedSalary;
		}
	}

	public void setCandidate_expectedSalary(String candidate_expectedSalary) {
		_candidate_expectedSalary = candidate_expectedSalary;
	}

	public String getCandidate_howToKnowBM() {
		if (_candidate_howToKnowBM == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_howToKnowBM;
		}
	}

	public void setCandidate_howToKnowBM(String candidate_howToKnowBM) {
		_candidate_howToKnowBM = candidate_howToKnowBM;
	}

	public String getCandidate_whoIntroduce() {
		if (_candidate_whoIntroduce == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_whoIntroduce;
		}
	}

	public void setCandidate_whoIntroduce(String candidate_whoIntroduce) {
		_candidate_whoIntroduce = candidate_whoIntroduce;
	}

	public String getCandidate_anyConfuse() {
		if (_candidate_anyConfuse == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidate_anyConfuse;
		}
	}

	public void setCandidate_anyConfuse(String candidate_anyConfuse) {
		_candidate_anyConfuse = candidate_anyConfuse;
	}

	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
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

	@Override
	public Recruitment toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Recruitment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		RecruitmentImpl recruitmentImpl = new RecruitmentImpl();

		recruitmentImpl.setRecruitment_id(getRecruitment_id());
		recruitmentImpl.setCandidate_name(getCandidate_name());
		recruitmentImpl.setCandidate_sex(getCandidate_sex());
		recruitmentImpl.setCandidate_dob(getCandidate_dob());
		recruitmentImpl.setCandidate_placeOfBirth(getCandidate_placeOfBirth());
		recruitmentImpl.setCandidate_nationality(getCandidate_nationality());
		recruitmentImpl.setCandidate_race(getCandidate_race());
		recruitmentImpl.setCandidate_religion(getCandidate_religion());
		recruitmentImpl.setCandidate_IdCardNumber(getCandidate_IdCardNumber());
		recruitmentImpl.setCandidate_placeOfIssue(getCandidate_placeOfIssue());
		recruitmentImpl.setCandidate_permanentPlace(getCandidate_permanentPlace());
		recruitmentImpl.setCandidate_temporaryPlace(getCandidate_temporaryPlace());
		recruitmentImpl.setCandidate_phoneNumber(getCandidate_phoneNumber());
		recruitmentImpl.setCandidate_email(getCandidate_email());
		recruitmentImpl.setCandidate_position(getCandidate_position());
		recruitmentImpl.setCandidate_canStartDate(getCandidate_canStartDate());
		recruitmentImpl.setCandidate_currentSalary(getCandidate_currentSalary());
		recruitmentImpl.setCandidate_expectedSalary(getCandidate_expectedSalary());
		recruitmentImpl.setCandidate_howToKnowBM(getCandidate_howToKnowBM());
		recruitmentImpl.setCandidate_whoIntroduce(getCandidate_whoIntroduce());
		recruitmentImpl.setCandidate_anyConfuse(getCandidate_anyConfuse());
		recruitmentImpl.setStatus(getStatus());
		recruitmentImpl.setCreated_date(getCreated_date());
		recruitmentImpl.setModified_date(getModified_date());
		recruitmentImpl.setDeleted(getDeleted());

		recruitmentImpl.resetOriginalValues();

		return recruitmentImpl;
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

		Recruitment recruitment = null;

		try {
			recruitment = (Recruitment)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Recruitment> toCacheModel() {
		RecruitmentCacheModel recruitmentCacheModel = new RecruitmentCacheModel();

		recruitmentCacheModel.recruitment_id = getRecruitment_id();

		String recruitment_id = recruitmentCacheModel.recruitment_id;

		if ((recruitment_id != null) && (recruitment_id.length() == 0)) {
			recruitmentCacheModel.recruitment_id = null;
		}

		recruitmentCacheModel.candidate_name = getCandidate_name();

		String candidate_name = recruitmentCacheModel.candidate_name;

		if ((candidate_name != null) && (candidate_name.length() == 0)) {
			recruitmentCacheModel.candidate_name = null;
		}

		recruitmentCacheModel.candidate_sex = getCandidate_sex();

		String candidate_sex = recruitmentCacheModel.candidate_sex;

		if ((candidate_sex != null) && (candidate_sex.length() == 0)) {
			recruitmentCacheModel.candidate_sex = null;
		}

		recruitmentCacheModel.candidate_dob = getCandidate_dob();

		String candidate_dob = recruitmentCacheModel.candidate_dob;

		if ((candidate_dob != null) && (candidate_dob.length() == 0)) {
			recruitmentCacheModel.candidate_dob = null;
		}

		recruitmentCacheModel.candidate_placeOfBirth = getCandidate_placeOfBirth();

		String candidate_placeOfBirth = recruitmentCacheModel.candidate_placeOfBirth;

		if ((candidate_placeOfBirth != null) &&
				(candidate_placeOfBirth.length() == 0)) {
			recruitmentCacheModel.candidate_placeOfBirth = null;
		}

		recruitmentCacheModel.candidate_nationality = getCandidate_nationality();

		String candidate_nationality = recruitmentCacheModel.candidate_nationality;

		if ((candidate_nationality != null) &&
				(candidate_nationality.length() == 0)) {
			recruitmentCacheModel.candidate_nationality = null;
		}

		recruitmentCacheModel.candidate_race = getCandidate_race();

		String candidate_race = recruitmentCacheModel.candidate_race;

		if ((candidate_race != null) && (candidate_race.length() == 0)) {
			recruitmentCacheModel.candidate_race = null;
		}

		recruitmentCacheModel.candidate_religion = getCandidate_religion();

		String candidate_religion = recruitmentCacheModel.candidate_religion;

		if ((candidate_religion != null) && (candidate_religion.length() == 0)) {
			recruitmentCacheModel.candidate_religion = null;
		}

		recruitmentCacheModel.candidate_IdCardNumber = getCandidate_IdCardNumber();

		String candidate_IdCardNumber = recruitmentCacheModel.candidate_IdCardNumber;

		if ((candidate_IdCardNumber != null) &&
				(candidate_IdCardNumber.length() == 0)) {
			recruitmentCacheModel.candidate_IdCardNumber = null;
		}

		recruitmentCacheModel.candidate_placeOfIssue = getCandidate_placeOfIssue();

		String candidate_placeOfIssue = recruitmentCacheModel.candidate_placeOfIssue;

		if ((candidate_placeOfIssue != null) &&
				(candidate_placeOfIssue.length() == 0)) {
			recruitmentCacheModel.candidate_placeOfIssue = null;
		}

		recruitmentCacheModel.candidate_permanentPlace = getCandidate_permanentPlace();

		String candidate_permanentPlace = recruitmentCacheModel.candidate_permanentPlace;

		if ((candidate_permanentPlace != null) &&
				(candidate_permanentPlace.length() == 0)) {
			recruitmentCacheModel.candidate_permanentPlace = null;
		}

		recruitmentCacheModel.candidate_temporaryPlace = getCandidate_temporaryPlace();

		String candidate_temporaryPlace = recruitmentCacheModel.candidate_temporaryPlace;

		if ((candidate_temporaryPlace != null) &&
				(candidate_temporaryPlace.length() == 0)) {
			recruitmentCacheModel.candidate_temporaryPlace = null;
		}

		recruitmentCacheModel.candidate_phoneNumber = getCandidate_phoneNumber();

		String candidate_phoneNumber = recruitmentCacheModel.candidate_phoneNumber;

		if ((candidate_phoneNumber != null) &&
				(candidate_phoneNumber.length() == 0)) {
			recruitmentCacheModel.candidate_phoneNumber = null;
		}

		recruitmentCacheModel.candidate_email = getCandidate_email();

		String candidate_email = recruitmentCacheModel.candidate_email;

		if ((candidate_email != null) && (candidate_email.length() == 0)) {
			recruitmentCacheModel.candidate_email = null;
		}

		recruitmentCacheModel.candidate_position = getCandidate_position();

		String candidate_position = recruitmentCacheModel.candidate_position;

		if ((candidate_position != null) && (candidate_position.length() == 0)) {
			recruitmentCacheModel.candidate_position = null;
		}

		recruitmentCacheModel.candidate_canStartDate = getCandidate_canStartDate();

		String candidate_canStartDate = recruitmentCacheModel.candidate_canStartDate;

		if ((candidate_canStartDate != null) &&
				(candidate_canStartDate.length() == 0)) {
			recruitmentCacheModel.candidate_canStartDate = null;
		}

		recruitmentCacheModel.candidate_currentSalary = getCandidate_currentSalary();

		String candidate_currentSalary = recruitmentCacheModel.candidate_currentSalary;

		if ((candidate_currentSalary != null) &&
				(candidate_currentSalary.length() == 0)) {
			recruitmentCacheModel.candidate_currentSalary = null;
		}

		recruitmentCacheModel.candidate_expectedSalary = getCandidate_expectedSalary();

		String candidate_expectedSalary = recruitmentCacheModel.candidate_expectedSalary;

		if ((candidate_expectedSalary != null) &&
				(candidate_expectedSalary.length() == 0)) {
			recruitmentCacheModel.candidate_expectedSalary = null;
		}

		recruitmentCacheModel.candidate_howToKnowBM = getCandidate_howToKnowBM();

		String candidate_howToKnowBM = recruitmentCacheModel.candidate_howToKnowBM;

		if ((candidate_howToKnowBM != null) &&
				(candidate_howToKnowBM.length() == 0)) {
			recruitmentCacheModel.candidate_howToKnowBM = null;
		}

		recruitmentCacheModel.candidate_whoIntroduce = getCandidate_whoIntroduce();

		String candidate_whoIntroduce = recruitmentCacheModel.candidate_whoIntroduce;

		if ((candidate_whoIntroduce != null) &&
				(candidate_whoIntroduce.length() == 0)) {
			recruitmentCacheModel.candidate_whoIntroduce = null;
		}

		recruitmentCacheModel.candidate_anyConfuse = getCandidate_anyConfuse();

		String candidate_anyConfuse = recruitmentCacheModel.candidate_anyConfuse;

		if ((candidate_anyConfuse != null) &&
				(candidate_anyConfuse.length() == 0)) {
			recruitmentCacheModel.candidate_anyConfuse = null;
		}

		recruitmentCacheModel.status = getStatus();

		String status = recruitmentCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			recruitmentCacheModel.status = null;
		}

		Date created_date = getCreated_date();

		if (created_date != null) {
			recruitmentCacheModel.created_date = created_date.getTime();
		}
		else {
			recruitmentCacheModel.created_date = Long.MIN_VALUE;
		}

		Date modified_date = getModified_date();

		if (modified_date != null) {
			recruitmentCacheModel.modified_date = modified_date.getTime();
		}
		else {
			recruitmentCacheModel.modified_date = Long.MIN_VALUE;
		}

		recruitmentCacheModel.deleted = getDeleted();

		return recruitmentCacheModel;
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

	private static ClassLoader _classLoader = Recruitment.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Recruitment.class
		};
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
	private Recruitment _escapedModelProxy;
}