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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Recruitment}.
 * </p>
 *
 * @author    FSOFT
 * @see       Recruitment
 * @generated
 */
public class RecruitmentWrapper implements Recruitment,
	ModelWrapper<Recruitment> {
	public RecruitmentWrapper(Recruitment recruitment) {
		_recruitment = recruitment;
	}

	public Class<?> getModelClass() {
		return Recruitment.class;
	}

	public String getModelClassName() {
		return Recruitment.class.getName();
	}

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

	/**
	* Returns the primary key of this recruitment.
	*
	* @return the primary key of this recruitment
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment.
	*
	* @param primaryKey the primary key of this recruitment
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_id of this recruitment.
	*
	* @return the recruitment_id of this recruitment
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitment.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment.
	*
	* @param recruitment_id the recruitment_id of this recruitment
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitment.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the candidate_name of this recruitment.
	*
	* @return the candidate_name of this recruitment
	*/
	public java.lang.String getCandidate_name() {
		return _recruitment.getCandidate_name();
	}

	/**
	* Sets the candidate_name of this recruitment.
	*
	* @param candidate_name the candidate_name of this recruitment
	*/
	public void setCandidate_name(java.lang.String candidate_name) {
		_recruitment.setCandidate_name(candidate_name);
	}

	/**
	* Returns the candidate_sex of this recruitment.
	*
	* @return the candidate_sex of this recruitment
	*/
	public java.lang.String getCandidate_sex() {
		return _recruitment.getCandidate_sex();
	}

	/**
	* Sets the candidate_sex of this recruitment.
	*
	* @param candidate_sex the candidate_sex of this recruitment
	*/
	public void setCandidate_sex(java.lang.String candidate_sex) {
		_recruitment.setCandidate_sex(candidate_sex);
	}

	/**
	* Returns the candidate_dob of this recruitment.
	*
	* @return the candidate_dob of this recruitment
	*/
	public java.lang.String getCandidate_dob() {
		return _recruitment.getCandidate_dob();
	}

	/**
	* Sets the candidate_dob of this recruitment.
	*
	* @param candidate_dob the candidate_dob of this recruitment
	*/
	public void setCandidate_dob(java.lang.String candidate_dob) {
		_recruitment.setCandidate_dob(candidate_dob);
	}

	/**
	* Returns the candidate_place of birth of this recruitment.
	*
	* @return the candidate_place of birth of this recruitment
	*/
	public java.lang.String getCandidate_placeOfBirth() {
		return _recruitment.getCandidate_placeOfBirth();
	}

	/**
	* Sets the candidate_place of birth of this recruitment.
	*
	* @param candidate_placeOfBirth the candidate_place of birth of this recruitment
	*/
	public void setCandidate_placeOfBirth(
		java.lang.String candidate_placeOfBirth) {
		_recruitment.setCandidate_placeOfBirth(candidate_placeOfBirth);
	}

	/**
	* Returns the candidate_nationality of this recruitment.
	*
	* @return the candidate_nationality of this recruitment
	*/
	public java.lang.String getCandidate_nationality() {
		return _recruitment.getCandidate_nationality();
	}

	/**
	* Sets the candidate_nationality of this recruitment.
	*
	* @param candidate_nationality the candidate_nationality of this recruitment
	*/
	public void setCandidate_nationality(java.lang.String candidate_nationality) {
		_recruitment.setCandidate_nationality(candidate_nationality);
	}

	/**
	* Returns the candidate_race of this recruitment.
	*
	* @return the candidate_race of this recruitment
	*/
	public java.lang.String getCandidate_race() {
		return _recruitment.getCandidate_race();
	}

	/**
	* Sets the candidate_race of this recruitment.
	*
	* @param candidate_race the candidate_race of this recruitment
	*/
	public void setCandidate_race(java.lang.String candidate_race) {
		_recruitment.setCandidate_race(candidate_race);
	}

	/**
	* Returns the candidate_religion of this recruitment.
	*
	* @return the candidate_religion of this recruitment
	*/
	public java.lang.String getCandidate_religion() {
		return _recruitment.getCandidate_religion();
	}

	/**
	* Sets the candidate_religion of this recruitment.
	*
	* @param candidate_religion the candidate_religion of this recruitment
	*/
	public void setCandidate_religion(java.lang.String candidate_religion) {
		_recruitment.setCandidate_religion(candidate_religion);
	}

	/**
	* Returns the candidate_ ID card number of this recruitment.
	*
	* @return the candidate_ ID card number of this recruitment
	*/
	public java.lang.String getCandidate_IdCardNumber() {
		return _recruitment.getCandidate_IdCardNumber();
	}

	/**
	* Sets the candidate_ ID card number of this recruitment.
	*
	* @param candidate_IdCardNumber the candidate_ ID card number of this recruitment
	*/
	public void setCandidate_IdCardNumber(
		java.lang.String candidate_IdCardNumber) {
		_recruitment.setCandidate_IdCardNumber(candidate_IdCardNumber);
	}

	/**
	* Returns the candidate_place of issue of this recruitment.
	*
	* @return the candidate_place of issue of this recruitment
	*/
	public java.lang.String getCandidate_placeOfIssue() {
		return _recruitment.getCandidate_placeOfIssue();
	}

	/**
	* Sets the candidate_place of issue of this recruitment.
	*
	* @param candidate_placeOfIssue the candidate_place of issue of this recruitment
	*/
	public void setCandidate_placeOfIssue(
		java.lang.String candidate_placeOfIssue) {
		_recruitment.setCandidate_placeOfIssue(candidate_placeOfIssue);
	}

	/**
	* Returns the candidate_permanent place of this recruitment.
	*
	* @return the candidate_permanent place of this recruitment
	*/
	public java.lang.String getCandidate_permanentPlace() {
		return _recruitment.getCandidate_permanentPlace();
	}

	/**
	* Sets the candidate_permanent place of this recruitment.
	*
	* @param candidate_permanentPlace the candidate_permanent place of this recruitment
	*/
	public void setCandidate_permanentPlace(
		java.lang.String candidate_permanentPlace) {
		_recruitment.setCandidate_permanentPlace(candidate_permanentPlace);
	}

	/**
	* Returns the candidate_temporary place of this recruitment.
	*
	* @return the candidate_temporary place of this recruitment
	*/
	public java.lang.String getCandidate_temporaryPlace() {
		return _recruitment.getCandidate_temporaryPlace();
	}

	/**
	* Sets the candidate_temporary place of this recruitment.
	*
	* @param candidate_temporaryPlace the candidate_temporary place of this recruitment
	*/
	public void setCandidate_temporaryPlace(
		java.lang.String candidate_temporaryPlace) {
		_recruitment.setCandidate_temporaryPlace(candidate_temporaryPlace);
	}

	/**
	* Returns the candidate_phone number of this recruitment.
	*
	* @return the candidate_phone number of this recruitment
	*/
	public java.lang.String getCandidate_phoneNumber() {
		return _recruitment.getCandidate_phoneNumber();
	}

	/**
	* Sets the candidate_phone number of this recruitment.
	*
	* @param candidate_phoneNumber the candidate_phone number of this recruitment
	*/
	public void setCandidate_phoneNumber(java.lang.String candidate_phoneNumber) {
		_recruitment.setCandidate_phoneNumber(candidate_phoneNumber);
	}

	/**
	* Returns the candidate_email of this recruitment.
	*
	* @return the candidate_email of this recruitment
	*/
	public java.lang.String getCandidate_email() {
		return _recruitment.getCandidate_email();
	}

	/**
	* Sets the candidate_email of this recruitment.
	*
	* @param candidate_email the candidate_email of this recruitment
	*/
	public void setCandidate_email(java.lang.String candidate_email) {
		_recruitment.setCandidate_email(candidate_email);
	}

	/**
	* Returns the candidate_position of this recruitment.
	*
	* @return the candidate_position of this recruitment
	*/
	public java.lang.String getCandidate_position() {
		return _recruitment.getCandidate_position();
	}

	/**
	* Sets the candidate_position of this recruitment.
	*
	* @param candidate_position the candidate_position of this recruitment
	*/
	public void setCandidate_position(java.lang.String candidate_position) {
		_recruitment.setCandidate_position(candidate_position);
	}

	/**
	* Returns the candidate_can start date of this recruitment.
	*
	* @return the candidate_can start date of this recruitment
	*/
	public java.lang.String getCandidate_canStartDate() {
		return _recruitment.getCandidate_canStartDate();
	}

	/**
	* Sets the candidate_can start date of this recruitment.
	*
	* @param candidate_canStartDate the candidate_can start date of this recruitment
	*/
	public void setCandidate_canStartDate(
		java.lang.String candidate_canStartDate) {
		_recruitment.setCandidate_canStartDate(candidate_canStartDate);
	}

	/**
	* Returns the candidate_current salary of this recruitment.
	*
	* @return the candidate_current salary of this recruitment
	*/
	public java.lang.String getCandidate_currentSalary() {
		return _recruitment.getCandidate_currentSalary();
	}

	/**
	* Sets the candidate_current salary of this recruitment.
	*
	* @param candidate_currentSalary the candidate_current salary of this recruitment
	*/
	public void setCandidate_currentSalary(
		java.lang.String candidate_currentSalary) {
		_recruitment.setCandidate_currentSalary(candidate_currentSalary);
	}

	/**
	* Returns the candidate_expected salary of this recruitment.
	*
	* @return the candidate_expected salary of this recruitment
	*/
	public java.lang.String getCandidate_expectedSalary() {
		return _recruitment.getCandidate_expectedSalary();
	}

	/**
	* Sets the candidate_expected salary of this recruitment.
	*
	* @param candidate_expectedSalary the candidate_expected salary of this recruitment
	*/
	public void setCandidate_expectedSalary(
		java.lang.String candidate_expectedSalary) {
		_recruitment.setCandidate_expectedSalary(candidate_expectedSalary);
	}

	/**
	* Returns the candidate_how to know b m of this recruitment.
	*
	* @return the candidate_how to know b m of this recruitment
	*/
	public java.lang.String getCandidate_howToKnowBM() {
		return _recruitment.getCandidate_howToKnowBM();
	}

	/**
	* Sets the candidate_how to know b m of this recruitment.
	*
	* @param candidate_howToKnowBM the candidate_how to know b m of this recruitment
	*/
	public void setCandidate_howToKnowBM(java.lang.String candidate_howToKnowBM) {
		_recruitment.setCandidate_howToKnowBM(candidate_howToKnowBM);
	}

	/**
	* Returns the candidate_who introduce of this recruitment.
	*
	* @return the candidate_who introduce of this recruitment
	*/
	public java.lang.String getCandidate_whoIntroduce() {
		return _recruitment.getCandidate_whoIntroduce();
	}

	/**
	* Sets the candidate_who introduce of this recruitment.
	*
	* @param candidate_whoIntroduce the candidate_who introduce of this recruitment
	*/
	public void setCandidate_whoIntroduce(
		java.lang.String candidate_whoIntroduce) {
		_recruitment.setCandidate_whoIntroduce(candidate_whoIntroduce);
	}

	/**
	* Returns the candidate_any confuse of this recruitment.
	*
	* @return the candidate_any confuse of this recruitment
	*/
	public java.lang.String getCandidate_anyConfuse() {
		return _recruitment.getCandidate_anyConfuse();
	}

	/**
	* Sets the candidate_any confuse of this recruitment.
	*
	* @param candidate_anyConfuse the candidate_any confuse of this recruitment
	*/
	public void setCandidate_anyConfuse(java.lang.String candidate_anyConfuse) {
		_recruitment.setCandidate_anyConfuse(candidate_anyConfuse);
	}

	/**
	* Returns the status of this recruitment.
	*
	* @return the status of this recruitment
	*/
	public java.lang.String getStatus() {
		return _recruitment.getStatus();
	}

	/**
	* Sets the status of this recruitment.
	*
	* @param status the status of this recruitment
	*/
	public void setStatus(java.lang.String status) {
		_recruitment.setStatus(status);
	}

	/**
	* Returns the created_date of this recruitment.
	*
	* @return the created_date of this recruitment
	*/
	public java.util.Date getCreated_date() {
		return _recruitment.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment.
	*
	* @param created_date the created_date of this recruitment
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitment.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment.
	*
	* @return the modified_date of this recruitment
	*/
	public java.util.Date getModified_date() {
		return _recruitment.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment.
	*
	* @param modified_date the modified_date of this recruitment
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitment.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment.
	*
	* @return the deleted of this recruitment
	*/
	public boolean getDeleted() {
		return _recruitment.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment is deleted.
	*
	* @return <code>true</code> if this recruitment is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitment.isDeleted();
	}

	/**
	* Sets whether this recruitment is deleted.
	*
	* @param deleted the deleted of this recruitment
	*/
	public void setDeleted(boolean deleted) {
		_recruitment.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitment.isNew();
	}

	public void setNew(boolean n) {
		_recruitment.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentWrapper((Recruitment)_recruitment.clone());
	}

	public int compareTo(com.fsoft.bn.model.Recruitment recruitment) {
		return _recruitment.compareTo(recruitment);
	}

	@Override
	public int hashCode() {
		return _recruitment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Recruitment> toCacheModel() {
		return _recruitment.toCacheModel();
	}

	public com.fsoft.bn.model.Recruitment toEscapedModel() {
		return new RecruitmentWrapper(_recruitment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitment.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Recruitment getWrappedRecruitment() {
		return _recruitment;
	}

	public Recruitment getWrappedModel() {
		return _recruitment;
	}

	public void resetOriginalValues() {
		_recruitment.resetOriginalValues();
	}

	private Recruitment _recruitment;
}