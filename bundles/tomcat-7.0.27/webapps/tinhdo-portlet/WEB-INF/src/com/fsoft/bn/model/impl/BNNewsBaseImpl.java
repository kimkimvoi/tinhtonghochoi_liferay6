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

import com.fsoft.bn.model.BNNews;
import com.fsoft.bn.service.BNNewsLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the BNNews service. Represents a row in the &quot;BN_BNNews&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BNNewsImpl}.
 * </p>
 *
 * @author FSOFT
 * @see BNNewsImpl
 * @see com.fsoft.bn.model.BNNews
 * @generated
 */
public abstract class BNNewsBaseImpl extends BNNewsModelImpl implements BNNews {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a b n news model instance should use the {@link BNNews} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			BNNewsLocalServiceUtil.addBNNews(this);
		}
		else {
			BNNewsLocalServiceUtil.updateBNNews(this);
		}
	}
}