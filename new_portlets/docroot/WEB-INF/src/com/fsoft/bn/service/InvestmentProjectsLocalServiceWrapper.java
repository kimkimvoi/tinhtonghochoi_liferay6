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
 * This class is a wrapper for {@link InvestmentProjectsLocalService}.
 * </p>
 *
 * @author    FSOFT
 * @see       InvestmentProjectsLocalService
 * @generated
 */
public class InvestmentProjectsLocalServiceWrapper
	implements InvestmentProjectsLocalService,
		ServiceWrapper<InvestmentProjectsLocalService> {
	public InvestmentProjectsLocalServiceWrapper(
		InvestmentProjectsLocalService investmentProjectsLocalService) {
		_investmentProjectsLocalService = investmentProjectsLocalService;
	}

	/**
	* Adds the investment projects to the database. Also notifies the appropriate model listeners.
	*
	* @param investmentProjects the investment projects
	* @return the investment projects that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects addInvestmentProjects(
		com.fsoft.bn.model.InvestmentProjects investmentProjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.addInvestmentProjects(investmentProjects);
	}

	/**
	* Creates a new investment projects with the primary key. Does not add the investment projects to the database.
	*
	* @param project_id the primary key for the new investment projects
	* @return the new investment projects
	*/
	public com.fsoft.bn.model.InvestmentProjects createInvestmentProjects(
		java.lang.String project_id) {
		return _investmentProjectsLocalService.createInvestmentProjects(project_id);
	}

	/**
	* Deletes the investment projects with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects that was removed
	* @throws PortalException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects deleteInvestmentProjects(
		java.lang.String project_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.deleteInvestmentProjects(project_id);
	}

	/**
	* Deletes the investment projects from the database. Also notifies the appropriate model listeners.
	*
	* @param investmentProjects the investment projects
	* @return the investment projects that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects deleteInvestmentProjects(
		com.fsoft.bn.model.InvestmentProjects investmentProjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.deleteInvestmentProjects(investmentProjects);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _investmentProjectsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.fsoft.bn.model.InvestmentProjects fetchInvestmentProjects(
		java.lang.String project_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.fetchInvestmentProjects(project_id);
	}

	/**
	* Returns the investment projects with the primary key.
	*
	* @param project_id the primary key of the investment projects
	* @return the investment projects
	* @throws PortalException if a investment projects with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects getInvestmentProjects(
		java.lang.String project_id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.getInvestmentProjects(project_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the investment projectses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of investment projectses
	* @param end the upper bound of the range of investment projectses (not inclusive)
	* @return the range of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.fsoft.bn.model.InvestmentProjects> getInvestmentProjectses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.getInvestmentProjectses(start,
			end);
	}

	/**
	* Returns the number of investment projectses.
	*
	* @return the number of investment projectses
	* @throws SystemException if a system exception occurred
	*/
	public int getInvestmentProjectsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.getInvestmentProjectsesCount();
	}

	/**
	* Updates the investment projects in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param investmentProjects the investment projects
	* @return the investment projects that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects updateInvestmentProjects(
		com.fsoft.bn.model.InvestmentProjects investmentProjects)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.updateInvestmentProjects(investmentProjects);
	}

	/**
	* Updates the investment projects in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param investmentProjects the investment projects
	* @param merge whether to merge the investment projects with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the investment projects that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.fsoft.bn.model.InvestmentProjects updateInvestmentProjects(
		com.fsoft.bn.model.InvestmentProjects investmentProjects, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _investmentProjectsLocalService.updateInvestmentProjects(investmentProjects,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _investmentProjectsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_investmentProjectsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _investmentProjectsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InvestmentProjectsLocalService getWrappedInvestmentProjectsLocalService() {
		return _investmentProjectsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInvestmentProjectsLocalService(
		InvestmentProjectsLocalService investmentProjectsLocalService) {
		_investmentProjectsLocalService = investmentProjectsLocalService;
	}

	public InvestmentProjectsLocalService getWrappedService() {
		return _investmentProjectsLocalService;
	}

	public void setWrappedService(
		InvestmentProjectsLocalService investmentProjectsLocalService) {
		_investmentProjectsLocalService = investmentProjectsLocalService;
	}

	private InvestmentProjectsLocalService _investmentProjectsLocalService;
}