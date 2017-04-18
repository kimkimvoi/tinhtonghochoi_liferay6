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
 * This class is a wrapper for {@link PreschoolStudent}.
 * </p>
 *
 * @author    FSOFT
 * @see       PreschoolStudent
 * @generated
 */
public class PreschoolStudentWrapper implements PreschoolStudent,
	ModelWrapper<PreschoolStudent> {
	public PreschoolStudentWrapper(PreschoolStudent preschoolStudent) {
		_preschoolStudent = preschoolStudent;
	}

	public Class<?> getModelClass() {
		return PreschoolStudent.class;
	}

	public String getModelClassName() {
		return PreschoolStudent.class.getName();
	}

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

	/**
	* Returns the primary key of this preschool student.
	*
	* @return the primary key of this preschool student
	*/
	public java.lang.String getPrimaryKey() {
		return _preschoolStudent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this preschool student.
	*
	* @param primaryKey the primary key of this preschool student
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_preschoolStudent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the student_id of this preschool student.
	*
	* @return the student_id of this preschool student
	*/
	public java.lang.String getStudent_id() {
		return _preschoolStudent.getStudent_id();
	}

	/**
	* Sets the student_id of this preschool student.
	*
	* @param student_id the student_id of this preschool student
	*/
	public void setStudent_id(java.lang.String student_id) {
		_preschoolStudent.setStudent_id(student_id);
	}

	/**
	* Returns the student_name of this preschool student.
	*
	* @return the student_name of this preschool student
	*/
	public java.lang.String getStudent_name() {
		return _preschoolStudent.getStudent_name();
	}

	/**
	* Sets the student_name of this preschool student.
	*
	* @param student_name the student_name of this preschool student
	*/
	public void setStudent_name(java.lang.String student_name) {
		_preschoolStudent.setStudent_name(student_name);
	}

	/**
	* Returns the student_sex of this preschool student.
	*
	* @return the student_sex of this preschool student
	*/
	public java.lang.String getStudent_sex() {
		return _preschoolStudent.getStudent_sex();
	}

	/**
	* Sets the student_sex of this preschool student.
	*
	* @param student_sex the student_sex of this preschool student
	*/
	public void setStudent_sex(java.lang.String student_sex) {
		_preschoolStudent.setStudent_sex(student_sex);
	}

	/**
	* Returns the student_dob of this preschool student.
	*
	* @return the student_dob of this preschool student
	*/
	public java.lang.String getStudent_dob() {
		return _preschoolStudent.getStudent_dob();
	}

	/**
	* Sets the student_dob of this preschool student.
	*
	* @param student_dob the student_dob of this preschool student
	*/
	public void setStudent_dob(java.lang.String student_dob) {
		_preschoolStudent.setStudent_dob(student_dob);
	}

	/**
	* Returns the student_place of birth of this preschool student.
	*
	* @return the student_place of birth of this preschool student
	*/
	public java.lang.String getStudent_placeOfBirth() {
		return _preschoolStudent.getStudent_placeOfBirth();
	}

	/**
	* Sets the student_place of birth of this preschool student.
	*
	* @param student_placeOfBirth the student_place of birth of this preschool student
	*/
	public void setStudent_placeOfBirth(java.lang.String student_placeOfBirth) {
		_preschoolStudent.setStudent_placeOfBirth(student_placeOfBirth);
	}

	/**
	* Returns the student_nationality of this preschool student.
	*
	* @return the student_nationality of this preschool student
	*/
	public java.lang.String getStudent_nationality() {
		return _preschoolStudent.getStudent_nationality();
	}

	/**
	* Sets the student_nationality of this preschool student.
	*
	* @param student_nationality the student_nationality of this preschool student
	*/
	public void setStudent_nationality(java.lang.String student_nationality) {
		_preschoolStudent.setStudent_nationality(student_nationality);
	}

	/**
	* Returns the student_phone number of this preschool student.
	*
	* @return the student_phone number of this preschool student
	*/
	public java.lang.String getStudent_phoneNumber() {
		return _preschoolStudent.getStudent_phoneNumber();
	}

	/**
	* Sets the student_phone number of this preschool student.
	*
	* @param student_phoneNumber the student_phone number of this preschool student
	*/
	public void setStudent_phoneNumber(java.lang.String student_phoneNumber) {
		_preschoolStudent.setStudent_phoneNumber(student_phoneNumber);
	}

	/**
	* Returns the student_address of this preschool student.
	*
	* @return the student_address of this preschool student
	*/
	public java.lang.String getStudent_address() {
		return _preschoolStudent.getStudent_address();
	}

	/**
	* Sets the student_address of this preschool student.
	*
	* @param student_address the student_address of this preschool student
	*/
	public void setStudent_address(java.lang.String student_address) {
		_preschoolStudent.setStudent_address(student_address);
	}

	/**
	* Returns the student_heatlh status of this preschool student.
	*
	* @return the student_heatlh status of this preschool student
	*/
	public java.lang.String getStudent_heatlhStatus() {
		return _preschoolStudent.getStudent_heatlhStatus();
	}

	/**
	* Sets the student_heatlh status of this preschool student.
	*
	* @param student_heatlhStatus the student_heatlh status of this preschool student
	*/
	public void setStudent_heatlhStatus(java.lang.String student_heatlhStatus) {
		_preschoolStudent.setStudent_heatlhStatus(student_heatlhStatus);
	}

	/**
	* Returns the student_height of this preschool student.
	*
	* @return the student_height of this preschool student
	*/
	public java.lang.String getStudent_height() {
		return _preschoolStudent.getStudent_height();
	}

	/**
	* Sets the student_height of this preschool student.
	*
	* @param student_height the student_height of this preschool student
	*/
	public void setStudent_height(java.lang.String student_height) {
		_preschoolStudent.setStudent_height(student_height);
	}

	/**
	* Returns the student_weight of this preschool student.
	*
	* @return the student_weight of this preschool student
	*/
	public java.lang.String getStudent_weight() {
		return _preschoolStudent.getStudent_weight();
	}

	/**
	* Sets the student_weight of this preschool student.
	*
	* @param student_weight the student_weight of this preschool student
	*/
	public void setStudent_weight(java.lang.String student_weight) {
		_preschoolStudent.setStudent_weight(student_weight);
	}

	/**
	* Returns the student_contact name of this preschool student.
	*
	* @return the student_contact name of this preschool student
	*/
	public java.lang.String getStudent_contactName() {
		return _preschoolStudent.getStudent_contactName();
	}

	/**
	* Sets the student_contact name of this preschool student.
	*
	* @param student_contactName the student_contact name of this preschool student
	*/
	public void setStudent_contactName(java.lang.String student_contactName) {
		_preschoolStudent.setStudent_contactName(student_contactName);
	}

	/**
	* Returns the student_contact relationship of this preschool student.
	*
	* @return the student_contact relationship of this preschool student
	*/
	public java.lang.String getStudent_contactRelationship() {
		return _preschoolStudent.getStudent_contactRelationship();
	}

	/**
	* Sets the student_contact relationship of this preschool student.
	*
	* @param student_contactRelationship the student_contact relationship of this preschool student
	*/
	public void setStudent_contactRelationship(
		java.lang.String student_contactRelationship) {
		_preschoolStudent.setStudent_contactRelationship(student_contactRelationship);
	}

	/**
	* Returns the student_contact phone number of this preschool student.
	*
	* @return the student_contact phone number of this preschool student
	*/
	public java.lang.String getStudent_contactPhoneNumber() {
		return _preschoolStudent.getStudent_contactPhoneNumber();
	}

	/**
	* Sets the student_contact phone number of this preschool student.
	*
	* @param student_contactPhoneNumber the student_contact phone number of this preschool student
	*/
	public void setStudent_contactPhoneNumber(
		java.lang.String student_contactPhoneNumber) {
		_preschoolStudent.setStudent_contactPhoneNumber(student_contactPhoneNumber);
	}

	/**
	* Returns the student_contact email of this preschool student.
	*
	* @return the student_contact email of this preschool student
	*/
	public java.lang.String getStudent_contactEmail() {
		return _preschoolStudent.getStudent_contactEmail();
	}

	/**
	* Sets the student_contact email of this preschool student.
	*
	* @param student_contactEmail the student_contact email of this preschool student
	*/
	public void setStudent_contactEmail(java.lang.String student_contactEmail) {
		_preschoolStudent.setStudent_contactEmail(student_contactEmail);
	}

	/**
	* Returns the student_how to know b m of this preschool student.
	*
	* @return the student_how to know b m of this preschool student
	*/
	public java.lang.String getStudent_howToKnowBM() {
		return _preschoolStudent.getStudent_howToKnowBM();
	}

	/**
	* Sets the student_how to know b m of this preschool student.
	*
	* @param student_howToKnowBM the student_how to know b m of this preschool student
	*/
	public void setStudent_howToKnowBM(java.lang.String student_howToKnowBM) {
		_preschoolStudent.setStudent_howToKnowBM(student_howToKnowBM);
	}

	/**
	* Returns the student_who introduce of this preschool student.
	*
	* @return the student_who introduce of this preschool student
	*/
	public java.lang.String getStudent_whoIntroduce() {
		return _preschoolStudent.getStudent_whoIntroduce();
	}

	/**
	* Sets the student_who introduce of this preschool student.
	*
	* @param student_whoIntroduce the student_who introduce of this preschool student
	*/
	public void setStudent_whoIntroduce(java.lang.String student_whoIntroduce) {
		_preschoolStudent.setStudent_whoIntroduce(student_whoIntroduce);
	}

	/**
	* Returns the student_any confuse of this preschool student.
	*
	* @return the student_any confuse of this preschool student
	*/
	public java.lang.String getStudent_anyConfuse() {
		return _preschoolStudent.getStudent_anyConfuse();
	}

	/**
	* Sets the student_any confuse of this preschool student.
	*
	* @param student_anyConfuse the student_any confuse of this preschool student
	*/
	public void setStudent_anyConfuse(java.lang.String student_anyConfuse) {
		_preschoolStudent.setStudent_anyConfuse(student_anyConfuse);
	}

	/**
	* Returns the status of this preschool student.
	*
	* @return the status of this preschool student
	*/
	public java.lang.String getStatus() {
		return _preschoolStudent.getStatus();
	}

	/**
	* Sets the status of this preschool student.
	*
	* @param status the status of this preschool student
	*/
	public void setStatus(java.lang.String status) {
		_preschoolStudent.setStatus(status);
	}

	/**
	* Returns the created_date of this preschool student.
	*
	* @return the created_date of this preschool student
	*/
	public java.util.Date getCreated_date() {
		return _preschoolStudent.getCreated_date();
	}

	/**
	* Sets the created_date of this preschool student.
	*
	* @param created_date the created_date of this preschool student
	*/
	public void setCreated_date(java.util.Date created_date) {
		_preschoolStudent.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this preschool student.
	*
	* @return the modified_date of this preschool student
	*/
	public java.util.Date getModified_date() {
		return _preschoolStudent.getModified_date();
	}

	/**
	* Sets the modified_date of this preschool student.
	*
	* @param modified_date the modified_date of this preschool student
	*/
	public void setModified_date(java.util.Date modified_date) {
		_preschoolStudent.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this preschool student.
	*
	* @return the deleted of this preschool student
	*/
	public boolean getDeleted() {
		return _preschoolStudent.getDeleted();
	}

	/**
	* Returns <code>true</code> if this preschool student is deleted.
	*
	* @return <code>true</code> if this preschool student is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _preschoolStudent.isDeleted();
	}

	/**
	* Sets whether this preschool student is deleted.
	*
	* @param deleted the deleted of this preschool student
	*/
	public void setDeleted(boolean deleted) {
		_preschoolStudent.setDeleted(deleted);
	}

	public boolean isNew() {
		return _preschoolStudent.isNew();
	}

	public void setNew(boolean n) {
		_preschoolStudent.setNew(n);
	}

	public boolean isCachedModel() {
		return _preschoolStudent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_preschoolStudent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _preschoolStudent.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _preschoolStudent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_preschoolStudent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _preschoolStudent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_preschoolStudent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PreschoolStudentWrapper((PreschoolStudent)_preschoolStudent.clone());
	}

	public int compareTo(com.fsoft.bn.model.PreschoolStudent preschoolStudent) {
		return _preschoolStudent.compareTo(preschoolStudent);
	}

	@Override
	public int hashCode() {
		return _preschoolStudent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.PreschoolStudent> toCacheModel() {
		return _preschoolStudent.toCacheModel();
	}

	public com.fsoft.bn.model.PreschoolStudent toEscapedModel() {
		return new PreschoolStudentWrapper(_preschoolStudent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _preschoolStudent.toString();
	}

	public java.lang.String toXmlString() {
		return _preschoolStudent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_preschoolStudent.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PreschoolStudent getWrappedPreschoolStudent() {
		return _preschoolStudent;
	}

	public PreschoolStudent getWrappedModel() {
		return _preschoolStudent;
	}

	public void resetOriginalValues() {
		_preschoolStudent.resetOriginalValues();
	}

	private PreschoolStudent _preschoolStudent;
}