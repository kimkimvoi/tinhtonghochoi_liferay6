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
 * This class is a wrapper for {@link RecruitmentEducationalHistory}.
 * </p>
 *
 * @author    FSOFT
 * @see       RecruitmentEducationalHistory
 * @generated
 */
public class RecruitmentEducationalHistoryWrapper
	implements RecruitmentEducationalHistory,
		ModelWrapper<RecruitmentEducationalHistory> {
	public RecruitmentEducationalHistoryWrapper(
		RecruitmentEducationalHistory recruitmentEducationalHistory) {
		_recruitmentEducationalHistory = recruitmentEducationalHistory;
	}

	public Class<?> getModelClass() {
		return RecruitmentEducationalHistory.class;
	}

	public String getModelClassName() {
		return RecruitmentEducationalHistory.class.getName();
	}

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

	/**
	* Returns the primary key of this recruitment educational history.
	*
	* @return the primary key of this recruitment educational history
	*/
	public java.lang.String getPrimaryKey() {
		return _recruitmentEducationalHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this recruitment educational history.
	*
	* @param primaryKey the primary key of this recruitment educational history
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_recruitmentEducationalHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recruitment_educational_history_id of this recruitment educational history.
	*
	* @return the recruitment_educational_history_id of this recruitment educational history
	*/
	public java.lang.String getRecruitment_educational_history_id() {
		return _recruitmentEducationalHistory.getRecruitment_educational_history_id();
	}

	/**
	* Sets the recruitment_educational_history_id of this recruitment educational history.
	*
	* @param recruitment_educational_history_id the recruitment_educational_history_id of this recruitment educational history
	*/
	public void setRecruitment_educational_history_id(
		java.lang.String recruitment_educational_history_id) {
		_recruitmentEducationalHistory.setRecruitment_educational_history_id(recruitment_educational_history_id);
	}

	/**
	* Returns the recruitment_id of this recruitment educational history.
	*
	* @return the recruitment_id of this recruitment educational history
	*/
	public java.lang.String getRecruitment_id() {
		return _recruitmentEducationalHistory.getRecruitment_id();
	}

	/**
	* Sets the recruitment_id of this recruitment educational history.
	*
	* @param recruitment_id the recruitment_id of this recruitment educational history
	*/
	public void setRecruitment_id(java.lang.String recruitment_id) {
		_recruitmentEducationalHistory.setRecruitment_id(recruitment_id);
	}

	/**
	* Returns the school of this recruitment educational history.
	*
	* @return the school of this recruitment educational history
	*/
	public java.lang.String getSchool() {
		return _recruitmentEducationalHistory.getSchool();
	}

	/**
	* Sets the school of this recruitment educational history.
	*
	* @param school the school of this recruitment educational history
	*/
	public void setSchool(java.lang.String school) {
		_recruitmentEducationalHistory.setSchool(school);
	}

	/**
	* Returns the type of training of this recruitment educational history.
	*
	* @return the type of training of this recruitment educational history
	*/
	public java.lang.String getTypeOfTraining() {
		return _recruitmentEducationalHistory.getTypeOfTraining();
	}

	/**
	* Sets the type of training of this recruitment educational history.
	*
	* @param typeOfTraining the type of training of this recruitment educational history
	*/
	public void setTypeOfTraining(java.lang.String typeOfTraining) {
		_recruitmentEducationalHistory.setTypeOfTraining(typeOfTraining);
	}

	/**
	* Returns the speciality of this recruitment educational history.
	*
	* @return the speciality of this recruitment educational history
	*/
	public java.lang.String getSpeciality() {
		return _recruitmentEducationalHistory.getSpeciality();
	}

	/**
	* Sets the speciality of this recruitment educational history.
	*
	* @param speciality the speciality of this recruitment educational history
	*/
	public void setSpeciality(java.lang.String speciality) {
		_recruitmentEducationalHistory.setSpeciality(speciality);
	}

	/**
	* Returns the type of degree of this recruitment educational history.
	*
	* @return the type of degree of this recruitment educational history
	*/
	public java.lang.String getTypeOfDegree() {
		return _recruitmentEducationalHistory.getTypeOfDegree();
	}

	/**
	* Sets the type of degree of this recruitment educational history.
	*
	* @param typeOfDegree the type of degree of this recruitment educational history
	*/
	public void setTypeOfDegree(java.lang.String typeOfDegree) {
		_recruitmentEducationalHistory.setTypeOfDegree(typeOfDegree);
	}

	/**
	* Returns the graduated year of this recruitment educational history.
	*
	* @return the graduated year of this recruitment educational history
	*/
	public java.lang.String getGraduatedYear() {
		return _recruitmentEducationalHistory.getGraduatedYear();
	}

	/**
	* Sets the graduated year of this recruitment educational history.
	*
	* @param graduatedYear the graduated year of this recruitment educational history
	*/
	public void setGraduatedYear(java.lang.String graduatedYear) {
		_recruitmentEducationalHistory.setGraduatedYear(graduatedYear);
	}

	/**
	* Returns the created_date of this recruitment educational history.
	*
	* @return the created_date of this recruitment educational history
	*/
	public java.util.Date getCreated_date() {
		return _recruitmentEducationalHistory.getCreated_date();
	}

	/**
	* Sets the created_date of this recruitment educational history.
	*
	* @param created_date the created_date of this recruitment educational history
	*/
	public void setCreated_date(java.util.Date created_date) {
		_recruitmentEducationalHistory.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this recruitment educational history.
	*
	* @return the modified_date of this recruitment educational history
	*/
	public java.util.Date getModified_date() {
		return _recruitmentEducationalHistory.getModified_date();
	}

	/**
	* Sets the modified_date of this recruitment educational history.
	*
	* @param modified_date the modified_date of this recruitment educational history
	*/
	public void setModified_date(java.util.Date modified_date) {
		_recruitmentEducationalHistory.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this recruitment educational history.
	*
	* @return the deleted of this recruitment educational history
	*/
	public boolean getDeleted() {
		return _recruitmentEducationalHistory.getDeleted();
	}

	/**
	* Returns <code>true</code> if this recruitment educational history is deleted.
	*
	* @return <code>true</code> if this recruitment educational history is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _recruitmentEducationalHistory.isDeleted();
	}

	/**
	* Sets whether this recruitment educational history is deleted.
	*
	* @param deleted the deleted of this recruitment educational history
	*/
	public void setDeleted(boolean deleted) {
		_recruitmentEducationalHistory.setDeleted(deleted);
	}

	public boolean isNew() {
		return _recruitmentEducationalHistory.isNew();
	}

	public void setNew(boolean n) {
		_recruitmentEducationalHistory.setNew(n);
	}

	public boolean isCachedModel() {
		return _recruitmentEducationalHistory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_recruitmentEducationalHistory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _recruitmentEducationalHistory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _recruitmentEducationalHistory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_recruitmentEducationalHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _recruitmentEducationalHistory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_recruitmentEducationalHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RecruitmentEducationalHistoryWrapper((RecruitmentEducationalHistory)_recruitmentEducationalHistory.clone());
	}

	public int compareTo(
		com.fsoft.bn.model.RecruitmentEducationalHistory recruitmentEducationalHistory) {
		return _recruitmentEducationalHistory.compareTo(recruitmentEducationalHistory);
	}

	@Override
	public int hashCode() {
		return _recruitmentEducationalHistory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.RecruitmentEducationalHistory> toCacheModel() {
		return _recruitmentEducationalHistory.toCacheModel();
	}

	public com.fsoft.bn.model.RecruitmentEducationalHistory toEscapedModel() {
		return new RecruitmentEducationalHistoryWrapper(_recruitmentEducationalHistory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _recruitmentEducationalHistory.toString();
	}

	public java.lang.String toXmlString() {
		return _recruitmentEducationalHistory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_recruitmentEducationalHistory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RecruitmentEducationalHistory getWrappedRecruitmentEducationalHistory() {
		return _recruitmentEducationalHistory;
	}

	public RecruitmentEducationalHistory getWrappedModel() {
		return _recruitmentEducationalHistory;
	}

	public void resetOriginalValues() {
		_recruitmentEducationalHistory.resetOriginalValues();
	}

	private RecruitmentEducationalHistory _recruitmentEducationalHistory;
}