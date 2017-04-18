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

package com.fsoft.bn.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BNSiteMapService}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNSiteMapService
 * @generated
 */
public class BNSiteMapServiceWrapper implements BNSiteMapService,
	ServiceWrapper<BNSiteMapService> {
	public BNSiteMapServiceWrapper(BNSiteMapService bnSiteMapService) {
		_bnSiteMapService = bnSiteMapService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bnSiteMapService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bnSiteMapService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bnSiteMapService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BNSiteMapService getWrappedBNSiteMapService() {
		return _bnSiteMapService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBNSiteMapService(BNSiteMapService bnSiteMapService) {
		_bnSiteMapService = bnSiteMapService;
	}

	public BNSiteMapService getWrappedService() {
		return _bnSiteMapService;
	}

	public void setWrappedService(BNSiteMapService bnSiteMapService) {
		_bnSiteMapService = bnSiteMapService;
	}

	private BNSiteMapService _bnSiteMapService;
}