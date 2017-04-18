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

package com.fsoft.bn.service.impl;

import com.fsoft.bn.model.Organizations;
import com.fsoft.bn.service.base.OrganizationsLocalServiceBaseImpl;
import com.fsoft.bn.service.persistence.OrganizationsUtil;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the organizations local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.service.OrganizationsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author FSOFT
 * @see com.fsoft.bn.service.base.OrganizationsLocalServiceBaseImpl
 * @see com.fsoft.bn.service.OrganizationsLocalServiceUtil
 */
public class OrganizationsLocalServiceImpl
	extends OrganizationsLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.OrganizationsLocalServiceUtil} to access the organizations local service.
	 */
	public List<Organizations> getAllOrganization() throws SystemException {
		return OrganizationsUtil.findAll();
	}

}