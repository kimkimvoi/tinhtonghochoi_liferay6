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
 * This class is a wrapper for {@link InvestmentProjectsService}.
 * </p>
 *
 * @author    FSOFT
 * @see       InvestmentProjectsService
 * @generated
 */
public class InvestmentProjectsServiceWrapper
	implements InvestmentProjectsService,
		ServiceWrapper<InvestmentProjectsService> {
	public InvestmentProjectsServiceWrapper(
		InvestmentProjectsService investmentProjectsService) {
		_investmentProjectsService = investmentProjectsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _investmentProjectsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_investmentProjectsService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _investmentProjectsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InvestmentProjectsService getWrappedInvestmentProjectsService() {
		return _investmentProjectsService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInvestmentProjectsService(
		InvestmentProjectsService investmentProjectsService) {
		_investmentProjectsService = investmentProjectsService;
	}

	public InvestmentProjectsService getWrappedService() {
		return _investmentProjectsService;
	}

	public void setWrappedService(
		InvestmentProjectsService investmentProjectsService) {
		_investmentProjectsService = investmentProjectsService;
	}

	private InvestmentProjectsService _investmentProjectsService;
}