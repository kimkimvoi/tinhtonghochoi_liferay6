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

package com.fsoft.bn.service.persistence;

import com.fsoft.bn.NoSuchInvestmentProjectsException;
import com.fsoft.bn.model.InvestmentProjects;
import com.fsoft.bn.model.impl.InvestmentProjectsImpl;
import com.fsoft.bn.model.impl.InvestmentProjectsModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the investment projects service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see InvestmentProjectsPersistence
 * @see InvestmentProjectsUtil
 * @generated
 */
public class InvestmentProjectsPersistenceImpl extends BasePersistenceImpl<InvestmentProjects>
	implements InvestmentProjectsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvestmentProjectsUtil} to access the investment projects persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvestmentProjectsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsModelImpl.FINDER_CACHE_ENABLED,
			InvestmentProjectsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsModelImpl.FINDER_CACHE_ENABLED,
			InvestmentProjectsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the investment projects in the entity cache if it is enabled.
	 *
	 * @param investmentProjects the investment projects
	 */
	public void cacheResult(InvestmentProjects investmentProjects) {
		EntityCacheUtil.putResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsImpl.class, investmentProjects.getPrimaryKey(),
			investmentProjects);

		investmentProjects.resetOriginalValues();
	}

	/**
	 * Caches the investment projectses in the entity cache if it is enabled.
	 *
	 * @param investmentProjectses the investment projectses
	 */
	public void cacheResult(List<InvestmentProjects> investmentProjectses) {
		for (InvestmentProjects investmentProjects : investmentProjectses) {
			if (EntityCacheUtil.getResult(
						InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
						InvestmentProjectsImpl.class,
						investmentProjects.getPrimaryKey()) == null) {
				cacheResult(investmentProjects);
			}
			else {
				investmentProjects.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all investment projectses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvestmentProjectsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvestmentProjectsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the investment projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvestmentProjects investmentProjects) {
		EntityCacheUtil.removeResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsImpl.class, investmentProjects.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InvestmentProjects> investmentProjectses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InvestmentProjects investmentProjects : investmentProjectses) {
			EntityCacheUtil.removeResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
				InvestmentProjectsImpl.class, investmentProjects.getPrimaryKey());
		}
	}

	/**
	 * Creates a new investment projects with the primary key. Does not add the investment projects to the database.
	 *
	 * @param project_id the primary key for the new investment projects
	 * @return the new investment projects
	 */
	public InvestmentProjects create(String project_id) {
		InvestmentProjects investmentProjects = new InvestmentProjectsImpl();

		investmentProjects.setNew(true);
		investmentProjects.setPrimaryKey(project_id);

		return investmentProjects;
	}

	/**
	 * Removes the investment projects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param project_id the primary key of the investment projects
	 * @return the investment projects that was removed
	 * @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InvestmentProjects remove(String project_id)
		throws NoSuchInvestmentProjectsException, SystemException {
		return remove((Serializable)project_id);
	}

	/**
	 * Removes the investment projects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the investment projects
	 * @return the investment projects that was removed
	 * @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvestmentProjects remove(Serializable primaryKey)
		throws NoSuchInvestmentProjectsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InvestmentProjects investmentProjects = (InvestmentProjects)session.get(InvestmentProjectsImpl.class,
					primaryKey);

			if (investmentProjects == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvestmentProjectsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(investmentProjects);
		}
		catch (NoSuchInvestmentProjectsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected InvestmentProjects removeImpl(
		InvestmentProjects investmentProjects) throws SystemException {
		investmentProjects = toUnwrappedModel(investmentProjects);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, investmentProjects);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(investmentProjects);

		return investmentProjects;
	}

	@Override
	public InvestmentProjects updateImpl(
		com.fsoft.bn.model.InvestmentProjects investmentProjects, boolean merge)
		throws SystemException {
		investmentProjects = toUnwrappedModel(investmentProjects);

		boolean isNew = investmentProjects.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, investmentProjects, merge);

			investmentProjects.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
			InvestmentProjectsImpl.class, investmentProjects.getPrimaryKey(),
			investmentProjects);

		return investmentProjects;
	}

	protected InvestmentProjects toUnwrappedModel(
		InvestmentProjects investmentProjects) {
		if (investmentProjects instanceof InvestmentProjectsImpl) {
			return investmentProjects;
		}

		InvestmentProjectsImpl investmentProjectsImpl = new InvestmentProjectsImpl();

		investmentProjectsImpl.setNew(investmentProjects.isNew());
		investmentProjectsImpl.setPrimaryKey(investmentProjects.getPrimaryKey());

		investmentProjectsImpl.setProject_id(investmentProjects.getProject_id());
		investmentProjectsImpl.setProject_name(investmentProjects.getProject_name());
		investmentProjectsImpl.setTotal_investment_min(investmentProjects.getTotal_investment_min());
		investmentProjectsImpl.setTotal_investment_max(investmentProjects.getTotal_investment_max());
		investmentProjectsImpl.setImplementation_location(investmentProjects.getImplementation_location());
		investmentProjectsImpl.setStart_time(investmentProjects.getStart_time());
		investmentProjectsImpl.setEnd_time(investmentProjects.getEnd_time());
		investmentProjectsImpl.setProject_purpose(investmentProjects.getProject_purpose());
		investmentProjectsImpl.setCharter_capital(investmentProjects.getCharter_capital());
		investmentProjectsImpl.setProject_category_id(investmentProjects.getProject_category_id());
		investmentProjectsImpl.setProject_status_id(investmentProjects.getProject_status_id());
		investmentProjectsImpl.setInvestment_form_id(investmentProjects.getInvestment_form_id());
		investmentProjectsImpl.setCompetent_organization_id(investmentProjects.getCompetent_organization_id());
		investmentProjectsImpl.setKey_project(investmentProjects.isKey_project());
		investmentProjectsImpl.setTechnical_specifications(investmentProjects.getTechnical_specifications());
		investmentProjectsImpl.setCurrency_type_id(investmentProjects.getCurrency_type_id());
		investmentProjectsImpl.setCreated_date(investmentProjects.getCreated_date());
		investmentProjectsImpl.setModified_date(investmentProjects.getModified_date());
		investmentProjectsImpl.setDeleted(investmentProjects.isDeleted());

		return investmentProjectsImpl;
	}

	/**
	 * Returns the investment projects with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the investment projects
	 * @return the investment projects
	 * @throws com.liferay.portal.NoSuchModelException if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvestmentProjects findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the investment projects with the primary key or throws a {@link com.fsoft.bn.NoSuchInvestmentProjectsException} if it could not be found.
	 *
	 * @param project_id the primary key of the investment projects
	 * @return the investment projects
	 * @throws com.fsoft.bn.NoSuchInvestmentProjectsException if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InvestmentProjects findByPrimaryKey(String project_id)
		throws NoSuchInvestmentProjectsException, SystemException {
		InvestmentProjects investmentProjects = fetchByPrimaryKey(project_id);

		if (investmentProjects == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + project_id);
			}

			throw new NoSuchInvestmentProjectsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				project_id);
		}

		return investmentProjects;
	}

	/**
	 * Returns the investment projects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the investment projects
	 * @return the investment projects, or <code>null</code> if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvestmentProjects fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the investment projects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param project_id the primary key of the investment projects
	 * @return the investment projects, or <code>null</code> if a investment projects with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public InvestmentProjects fetchByPrimaryKey(String project_id)
		throws SystemException {
		InvestmentProjects investmentProjects = (InvestmentProjects)EntityCacheUtil.getResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
				InvestmentProjectsImpl.class, project_id);

		if (investmentProjects == _nullInvestmentProjects) {
			return null;
		}

		if (investmentProjects == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				investmentProjects = (InvestmentProjects)session.get(InvestmentProjectsImpl.class,
						project_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (investmentProjects != null) {
					cacheResult(investmentProjects);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(InvestmentProjectsModelImpl.ENTITY_CACHE_ENABLED,
						InvestmentProjectsImpl.class, project_id,
						_nullInvestmentProjects);
				}

				closeSession(session);
			}
		}

		return investmentProjects;
	}

	/**
	 * Returns all the investment projectses.
	 *
	 * @return the investment projectses
	 * @throws SystemException if a system exception occurred
	 */
	public List<InvestmentProjects> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<InvestmentProjects> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the investment projectses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of investment projectses
	 * @param end the upper bound of the range of investment projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of investment projectses
	 * @throws SystemException if a system exception occurred
	 */
	public List<InvestmentProjects> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<InvestmentProjects> list = (List<InvestmentProjects>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVESTMENTPROJECTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVESTMENTPROJECTS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<InvestmentProjects>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<InvestmentProjects>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the investment projectses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (InvestmentProjects investmentProjects : findAll()) {
			remove(investmentProjects);
		}
	}

	/**
	 * Returns the number of investment projectses.
	 *
	 * @return the number of investment projectses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_INVESTMENTPROJECTS);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the investment projects persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.InvestmentProjects")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InvestmentProjects>> listenersList = new ArrayList<ModelListener<InvestmentProjects>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InvestmentProjects>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(InvestmentProjectsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AnswerPersistence.class)
	protected AnswerPersistence answerPersistence;
	@BeanReference(type = AnswerAttachedFilePersistence.class)
	protected AnswerAttachedFilePersistence answerAttachedFilePersistence;
	@BeanReference(type = BNContactPersistence.class)
	protected BNContactPersistence bnContactPersistence;
	@BeanReference(type = BNNewsPersistence.class)
	protected BNNewsPersistence bnNewsPersistence;
	@BeanReference(type = InvestmentProjectsPersistence.class)
	protected InvestmentProjectsPersistence investmentProjectsPersistence;
	@BeanReference(type = OrganizationsPersistence.class)
	protected OrganizationsPersistence organizationsPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionAttachedFilePersistence.class)
	protected QuestionAttachedFilePersistence questionAttachedFilePersistence;
	@BeanReference(type = SchedulePersistence.class)
	protected SchedulePersistence schedulePersistence;
	@BeanReference(type = StaffInfoPersistence.class)
	protected StaffInfoPersistence staffInfoPersistence;
	@BeanReference(type = UserfulContactPhonePersistence.class)
	protected UserfulContactPhonePersistence userfulContactPhonePersistence;
	@BeanReference(type = UserSchedulePersistence.class)
	protected UserSchedulePersistence userSchedulePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_INVESTMENTPROJECTS = "SELECT investmentProjects FROM InvestmentProjects investmentProjects";
	private static final String _SQL_COUNT_INVESTMENTPROJECTS = "SELECT COUNT(investmentProjects) FROM InvestmentProjects investmentProjects";
	private static final String _ORDER_BY_ENTITY_ALIAS = "investmentProjects.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InvestmentProjects exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvestmentProjectsPersistenceImpl.class);
	private static InvestmentProjects _nullInvestmentProjects = new InvestmentProjectsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InvestmentProjects> toCacheModel() {
				return _nullInvestmentProjectsCacheModel;
			}
		};

	private static CacheModel<InvestmentProjects> _nullInvestmentProjectsCacheModel =
		new CacheModel<InvestmentProjects>() {
			public InvestmentProjects toEntityModel() {
				return _nullInvestmentProjects;
			}
		};
}