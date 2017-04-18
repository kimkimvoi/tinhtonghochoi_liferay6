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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Question service. Represents a row in the &quot;BN_Question&quot; database table, with each column mapped to a property of this class.
 *
 * @author FSOFT
 * @see QuestionModel
 * @see com.fsoft.bn.model.impl.QuestionImpl
 * @see com.fsoft.bn.model.impl.QuestionModelImpl
 * @generated
 */
public interface Question extends QuestionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.fsoft.bn.model.impl.QuestionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* @return the statusDisplay
	*/
	public java.lang.String getStatusDisplay();

	/**
	* @param statusDisplay the statusDisplay to set
	*/
	public void setStatusDisplay(java.lang.String statusDisplay);

	/**
	* @return the dateDisplay
	*/
	public java.lang.String getDateDisplay();

	/**
	* @param dateDisplay the dateDisplay to set
	*/
	public void setDateDisplay(java.lang.String dateDisplay);
}