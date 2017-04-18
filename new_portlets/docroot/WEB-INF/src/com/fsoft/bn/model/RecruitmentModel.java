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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Recruitment service. Represents a row in the &quot;BN_Recruitment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.RecruitmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.RecruitmentImpl}.
 * </p>
 *
 * @author FSOFT
 * @see Recruitment
 * @see com.fsoft.bn.model.impl.RecruitmentImpl
 * @see com.fsoft.bn.model.impl.RecruitmentModelImpl
 * @generated
 */
public interface RecruitmentModel extends BaseModel<Recruitment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recruitment model instance should use the {@link Recruitment} interface instead.
	 */

	/**
	 * Returns the primary key of this recruitment.
	 *
	 * @return the primary key of this recruitment
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this recruitment.
	 *
	 * @param primaryKey the primary key of this recruitment
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the recruitment_id of this recruitment.
	 *
	 * @return the recruitment_id of this recruitment
	 */
	@AutoEscape
	public String getRecruitment_id();

	/**
	 * Sets the recruitment_id of this recruitment.
	 *
	 * @param recruitment_id the recruitment_id of this recruitment
	 */
	public void setRecruitment_id(String recruitment_id);

	/**
	 * Returns the candidate_name of this recruitment.
	 *
	 * @return the candidate_name of this recruitment
	 */
	@AutoEscape
	public String getCandidate_name();

	/**
	 * Sets the candidate_name of this recruitment.
	 *
	 * @param candidate_name the candidate_name of this recruitment
	 */
	public void setCandidate_name(String candidate_name);

	/**
	 * Returns the candidate_sex of this recruitment.
	 *
	 * @return the candidate_sex of this recruitment
	 */
	@AutoEscape
	public String getCandidate_sex();

	/**
	 * Sets the candidate_sex of this recruitment.
	 *
	 * @param candidate_sex the candidate_sex of this recruitment
	 */
	public void setCandidate_sex(String candidate_sex);

	/**
	 * Returns the candidate_dob of this recruitment.
	 *
	 * @return the candidate_dob of this recruitment
	 */
	@AutoEscape
	public String getCandidate_dob();

	/**
	 * Sets the candidate_dob of this recruitment.
	 *
	 * @param candidate_dob the candidate_dob of this recruitment
	 */
	public void setCandidate_dob(String candidate_dob);

	/**
	 * Returns the candidate_place of birth of this recruitment.
	 *
	 * @return the candidate_place of birth of this recruitment
	 */
	@AutoEscape
	public String getCandidate_placeOfBirth();

	/**
	 * Sets the candidate_place of birth of this recruitment.
	 *
	 * @param candidate_placeOfBirth the candidate_place of birth of this recruitment
	 */
	public void setCandidate_placeOfBirth(String candidate_placeOfBirth);

	/**
	 * Returns the candidate_nationality of this recruitment.
	 *
	 * @return the candidate_nationality of this recruitment
	 */
	@AutoEscape
	public String getCandidate_nationality();

	/**
	 * Sets the candidate_nationality of this recruitment.
	 *
	 * @param candidate_nationality the candidate_nationality of this recruitment
	 */
	public void setCandidate_nationality(String candidate_nationality);

	/**
	 * Returns the candidate_race of this recruitment.
	 *
	 * @return the candidate_race of this recruitment
	 */
	@AutoEscape
	public String getCandidate_race();

	/**
	 * Sets the candidate_race of this recruitment.
	 *
	 * @param candidate_race the candidate_race of this recruitment
	 */
	public void setCandidate_race(String candidate_race);

	/**
	 * Returns the candidate_religion of this recruitment.
	 *
	 * @return the candidate_religion of this recruitment
	 */
	@AutoEscape
	public String getCandidate_religion();

	/**
	 * Sets the candidate_religion of this recruitment.
	 *
	 * @param candidate_religion the candidate_religion of this recruitment
	 */
	public void setCandidate_religion(String candidate_religion);

	/**
	 * Returns the candidate_ ID card number of this recruitment.
	 *
	 * @return the candidate_ ID card number of this recruitment
	 */
	@AutoEscape
	public String getCandidate_IdCardNumber();

	/**
	 * Sets the candidate_ ID card number of this recruitment.
	 *
	 * @param candidate_IdCardNumber the candidate_ ID card number of this recruitment
	 */
	public void setCandidate_IdCardNumber(String candidate_IdCardNumber);

	/**
	 * Returns the candidate_place of issue of this recruitment.
	 *
	 * @return the candidate_place of issue of this recruitment
	 */
	@AutoEscape
	public String getCandidate_placeOfIssue();

	/**
	 * Sets the candidate_place of issue of this recruitment.
	 *
	 * @param candidate_placeOfIssue the candidate_place of issue of this recruitment
	 */
	public void setCandidate_placeOfIssue(String candidate_placeOfIssue);

	/**
	 * Returns the candidate_permanent place of this recruitment.
	 *
	 * @return the candidate_permanent place of this recruitment
	 */
	@AutoEscape
	public String getCandidate_permanentPlace();

	/**
	 * Sets the candidate_permanent place of this recruitment.
	 *
	 * @param candidate_permanentPlace the candidate_permanent place of this recruitment
	 */
	public void setCandidate_permanentPlace(String candidate_permanentPlace);

	/**
	 * Returns the candidate_temporary place of this recruitment.
	 *
	 * @return the candidate_temporary place of this recruitment
	 */
	@AutoEscape
	public String getCandidate_temporaryPlace();

	/**
	 * Sets the candidate_temporary place of this recruitment.
	 *
	 * @param candidate_temporaryPlace the candidate_temporary place of this recruitment
	 */
	public void setCandidate_temporaryPlace(String candidate_temporaryPlace);

	/**
	 * Returns the candidate_phone number of this recruitment.
	 *
	 * @return the candidate_phone number of this recruitment
	 */
	@AutoEscape
	public String getCandidate_phoneNumber();

	/**
	 * Sets the candidate_phone number of this recruitment.
	 *
	 * @param candidate_phoneNumber the candidate_phone number of this recruitment
	 */
	public void setCandidate_phoneNumber(String candidate_phoneNumber);

	/**
	 * Returns the candidate_email of this recruitment.
	 *
	 * @return the candidate_email of this recruitment
	 */
	@AutoEscape
	public String getCandidate_email();

	/**
	 * Sets the candidate_email of this recruitment.
	 *
	 * @param candidate_email the candidate_email of this recruitment
	 */
	public void setCandidate_email(String candidate_email);

	/**
	 * Returns the candidate_position of this recruitment.
	 *
	 * @return the candidate_position of this recruitment
	 */
	@AutoEscape
	public String getCandidate_position();

	/**
	 * Sets the candidate_position of this recruitment.
	 *
	 * @param candidate_position the candidate_position of this recruitment
	 */
	public void setCandidate_position(String candidate_position);

	/**
	 * Returns the candidate_can start date of this recruitment.
	 *
	 * @return the candidate_can start date of this recruitment
	 */
	@AutoEscape
	public String getCandidate_canStartDate();

	/**
	 * Sets the candidate_can start date of this recruitment.
	 *
	 * @param candidate_canStartDate the candidate_can start date of this recruitment
	 */
	public void setCandidate_canStartDate(String candidate_canStartDate);

	/**
	 * Returns the candidate_current salary of this recruitment.
	 *
	 * @return the candidate_current salary of this recruitment
	 */
	@AutoEscape
	public String getCandidate_currentSalary();

	/**
	 * Sets the candidate_current salary of this recruitment.
	 *
	 * @param candidate_currentSalary the candidate_current salary of this recruitment
	 */
	public void setCandidate_currentSalary(String candidate_currentSalary);

	/**
	 * Returns the candidate_expected salary of this recruitment.
	 *
	 * @return the candidate_expected salary of this recruitment
	 */
	@AutoEscape
	public String getCandidate_expectedSalary();

	/**
	 * Sets the candidate_expected salary of this recruitment.
	 *
	 * @param candidate_expectedSalary the candidate_expected salary of this recruitment
	 */
	public void setCandidate_expectedSalary(String candidate_expectedSalary);

	/**
	 * Returns the candidate_how to know b m of this recruitment.
	 *
	 * @return the candidate_how to know b m of this recruitment
	 */
	@AutoEscape
	public String getCandidate_howToKnowBM();

	/**
	 * Sets the candidate_how to know b m of this recruitment.
	 *
	 * @param candidate_howToKnowBM the candidate_how to know b m of this recruitment
	 */
	public void setCandidate_howToKnowBM(String candidate_howToKnowBM);

	/**
	 * Returns the candidate_who introduce of this recruitment.
	 *
	 * @return the candidate_who introduce of this recruitment
	 */
	@AutoEscape
	public String getCandidate_whoIntroduce();

	/**
	 * Sets the candidate_who introduce of this recruitment.
	 *
	 * @param candidate_whoIntroduce the candidate_who introduce of this recruitment
	 */
	public void setCandidate_whoIntroduce(String candidate_whoIntroduce);

	/**
	 * Returns the candidate_any confuse of this recruitment.
	 *
	 * @return the candidate_any confuse of this recruitment
	 */
	@AutoEscape
	public String getCandidate_anyConfuse();

	/**
	 * Sets the candidate_any confuse of this recruitment.
	 *
	 * @param candidate_anyConfuse the candidate_any confuse of this recruitment
	 */
	public void setCandidate_anyConfuse(String candidate_anyConfuse);

	/**
	 * Returns the status of this recruitment.
	 *
	 * @return the status of this recruitment
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this recruitment.
	 *
	 * @param status the status of this recruitment
	 */
	public void setStatus(String status);

	/**
	 * Returns the created_date of this recruitment.
	 *
	 * @return the created_date of this recruitment
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this recruitment.
	 *
	 * @param created_date the created_date of this recruitment
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this recruitment.
	 *
	 * @return the modified_date of this recruitment
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this recruitment.
	 *
	 * @param modified_date the modified_date of this recruitment
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this recruitment.
	 *
	 * @return the deleted of this recruitment
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this recruitment is deleted.
	 *
	 * @return <code>true</code> if this recruitment is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this recruitment is deleted.
	 *
	 * @param deleted the deleted of this recruitment
	 */
	public void setDeleted(boolean deleted);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Recruitment recruitment);

	public int hashCode();

	public CacheModel<Recruitment> toCacheModel();

	public Recruitment toEscapedModel();

	public String toString();

	public String toXmlString();
}