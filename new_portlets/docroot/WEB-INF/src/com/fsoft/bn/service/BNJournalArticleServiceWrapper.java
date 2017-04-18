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
 * This class is a wrapper for {@link BNJournalArticleService}.
 * </p>
 *
 * @author    FSOFT
 * @see       BNJournalArticleService
 * @generated
 */
public class BNJournalArticleServiceWrapper implements BNJournalArticleService,
	ServiceWrapper<BNJournalArticleService> {
	public BNJournalArticleServiceWrapper(
		BNJournalArticleService bnJournalArticleService) {
		_bnJournalArticleService = bnJournalArticleService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bnJournalArticleService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bnJournalArticleService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bnJournalArticleService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BNJournalArticleService getWrappedBNJournalArticleService() {
		return _bnJournalArticleService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBNJournalArticleService(
		BNJournalArticleService bnJournalArticleService) {
		_bnJournalArticleService = bnJournalArticleService;
	}

	public BNJournalArticleService getWrappedService() {
		return _bnJournalArticleService;
	}

	public void setWrappedService(
		BNJournalArticleService bnJournalArticleService) {
		_bnJournalArticleService = bnJournalArticleService;
	}

	private BNJournalArticleService _bnJournalArticleService;
}