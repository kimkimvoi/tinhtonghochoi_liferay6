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
 * The base model interface for the PreschoolParent service. Represents a row in the &quot;BN_PreschoolParent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsoft.bn.model.impl.PreschoolParentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsoft.bn.model.impl.PreschoolParentImpl}.
 * </p>
 *
 * @author FSOFT
 * @see PreschoolParent
 * @see com.fsoft.bn.model.impl.PreschoolParentImpl
 * @see com.fsoft.bn.model.impl.PreschoolParentModelImpl
 * @generated
 */
public interface PreschoolParentModel extends BaseModel<PreschoolParent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a preschool parent model instance should use the {@link PreschoolParent} interface instead.
	 */

	/**
	 * Returns the primary key of this preschool parent.
	 *
	 * @return the primary key of this preschool parent
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this preschool parent.
	 *
	 * @param primaryKey the primary key of this preschool parent
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the preschool parent_id of this preschool parent.
	 *
	 * @return the preschool parent_id of this preschool parent
	 */
	@AutoEscape
	public String getPreschoolParent_id();

	/**
	 * Sets the preschool parent_id of this preschool parent.
	 *
	 * @param preschoolParent_id the preschool parent_id of this preschool parent
	 */
	public void setPreschoolParent_id(String preschoolParent_id);

	/**
	 * Returns the student_id of this preschool parent.
	 *
	 * @return the student_id of this preschool parent
	 */
	@AutoEscape
	public String getStudent_id();

	/**
	 * Sets the student_id of this preschool parent.
	 *
	 * @param student_id the student_id of this preschool parent
	 */
	public void setStudent_id(String student_id);

	/**
	 * Returns the name of this preschool parent.
	 *
	 * @return the name of this preschool parent
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this preschool parent.
	 *
	 * @param name the name of this preschool parent
	 */
	public void setName(String name);

	/**
	 * Returns the dob of this preschool parent.
	 *
	 * @return the dob of this preschool parent
	 */
	@AutoEscape
	public String getDob();

	/**
	 * Sets the dob of this preschool parent.
	 *
	 * @param dob the dob of this preschool parent
	 */
	public void setDob(String dob);

	/**
	 * Returns the place of birth of this preschool parent.
	 *
	 * @return the place of birth of this preschool parent
	 */
	@AutoEscape
	public String getPlaceOfBirth();

	/**
	 * Sets the place of birth of this preschool parent.
	 *
	 * @param placeOfBirth the place of birth of this preschool parent
	 */
	public void setPlaceOfBirth(String placeOfBirth);

	/**
	 * Returns the nationality of this preschool parent.
	 *
	 * @return the nationality of this preschool parent
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this preschool parent.
	 *
	 * @param nationality the nationality of this preschool parent
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the id card number of this preschool parent.
	 *
	 * @return the id card number of this preschool parent
	 */
	@AutoEscape
	public String getIdCardNumber();

	/**
	 * Sets the id card number of this preschool parent.
	 *
	 * @param idCardNumber the id card number of this preschool parent
	 */
	public void setIdCardNumber(String idCardNumber);

	/**
	 * Returns the job of this preschool parent.
	 *
	 * @return the job of this preschool parent
	 */
	@AutoEscape
	public String getJob();

	/**
	 * Sets the job of this preschool parent.
	 *
	 * @param job the job of this preschool parent
	 */
	public void setJob(String job);

	/**
	 * Returns the phone number of this preschool parent.
	 *
	 * @return the phone number of this preschool parent
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this preschool parent.
	 *
	 * @param phoneNumber the phone number of this preschool parent
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the email of this preschool parent.
	 *
	 * @return the email of this preschool parent
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this preschool parent.
	 *
	 * @param Email the email of this preschool parent
	 */
	public void setEmail(String Email);

	/**
	 * Returns the is mother of this preschool parent.
	 *
	 * @return the is mother of this preschool parent
	 */
	public boolean getIsMother();

	/**
	 * Returns <code>true</code> if this preschool parent is is mother.
	 *
	 * @return <code>true</code> if this preschool parent is is mother; <code>false</code> otherwise
	 */
	public boolean isIsMother();

	/**
	 * Sets whether this preschool parent is is mother.
	 *
	 * @param isMother the is mother of this preschool parent
	 */
	public void setIsMother(boolean isMother);

	/**
	 * Returns the created_date of this preschool parent.
	 *
	 * @return the created_date of this preschool parent
	 */
	public Date getCreated_date();

	/**
	 * Sets the created_date of this preschool parent.
	 *
	 * @param created_date the created_date of this preschool parent
	 */
	public void setCreated_date(Date created_date);

	/**
	 * Returns the modified_date of this preschool parent.
	 *
	 * @return the modified_date of this preschool parent
	 */
	public Date getModified_date();

	/**
	 * Sets the modified_date of this preschool parent.
	 *
	 * @param modified_date the modified_date of this preschool parent
	 */
	public void setModified_date(Date modified_date);

	/**
	 * Returns the deleted of this preschool parent.
	 *
	 * @return the deleted of this preschool parent
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this preschool parent is deleted.
	 *
	 * @return <code>true</code> if this preschool parent is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this preschool parent is deleted.
	 *
	 * @param deleted the deleted of this preschool parent
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

	public int compareTo(PreschoolParent preschoolParent);

	public int hashCode();

	public CacheModel<PreschoolParent> toCacheModel();

	public PreschoolParent toEscapedModel();

	public String toString();

	public String toXmlString();
}