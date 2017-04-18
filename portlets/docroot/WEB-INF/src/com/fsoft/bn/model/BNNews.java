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
 * The extended model interface for the BNNews service. Represents a row in the &quot;BN_BNNews&quot; database table, with each column mapped to a property of this class.
 *
 * @author FSOFT
 * @see BNNewsModel
 * @see com.fsoft.bn.model.impl.BNNewsImpl
 * @see com.fsoft.bn.model.impl.BNNewsModelImpl
 * @generated
 */
public interface BNNews extends BNNewsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.fsoft.bn.model.impl.BNNewsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getDateToString();

	public void setDateToString(java.lang.String dateToString);
}