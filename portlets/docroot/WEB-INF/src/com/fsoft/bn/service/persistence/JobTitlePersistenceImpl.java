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

import com.fsoft.bn.NoSuchJobTitleException;
import com.fsoft.bn.model.JobTitle;
import com.fsoft.bn.model.impl.JobTitleImpl;
import com.fsoft.bn.model.impl.JobTitleModelImpl;

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
 * The persistence implementation for the job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see JobTitlePersistence
 * @see JobTitleUtil
 * @generated
 */
public class JobTitlePersistenceImpl extends BasePersistenceImpl<JobTitle>
	implements JobTitlePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobTitleUtil} to access the job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobTitleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, JobTitleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the job title in the entity cache if it is enabled.
	 *
	 * @param jobTitle the job title
	 */
	public void cacheResult(JobTitle jobTitle) {
		EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey(), jobTitle);

		jobTitle.resetOriginalValues();
	}

	/**
	 * Caches the job titles in the entity cache if it is enabled.
	 *
	 * @param jobTitles the job titles
	 */
	public void cacheResult(List<JobTitle> jobTitles) {
		for (JobTitle jobTitle : jobTitles) {
			if (EntityCacheUtil.getResult(
						JobTitleModelImpl.ENTITY_CACHE_ENABLED,
						JobTitleImpl.class, jobTitle.getPrimaryKey()) == null) {
				cacheResult(jobTitle);
			}
			else {
				jobTitle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobTitleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobTitleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job title.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobTitle jobTitle) {
		EntityCacheUtil.removeResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobTitle> jobTitles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobTitle jobTitle : jobTitles) {
			EntityCacheUtil.removeResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
				JobTitleImpl.class, jobTitle.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job title with the primary key. Does not add the job title to the database.
	 *
	 * @param job_title_id the primary key for the new job title
	 * @return the new job title
	 */
	public JobTitle create(String job_title_id) {
		JobTitle jobTitle = new JobTitleImpl();

		jobTitle.setNew(true);
		jobTitle.setPrimaryKey(job_title_id);

		return jobTitle;
	}

	/**
	 * Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param job_title_id the primary key of the job title
	 * @return the job title that was removed
	 * @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobTitle remove(String job_title_id)
		throws NoSuchJobTitleException, SystemException {
		return remove((Serializable)job_title_id);
	}

	/**
	 * Removes the job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title that was removed
	 * @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle remove(Serializable primaryKey)
		throws NoSuchJobTitleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobTitle jobTitle = (JobTitle)session.get(JobTitleImpl.class,
					primaryKey);

			if (jobTitle == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobTitle);
		}
		catch (NoSuchJobTitleException nsee) {
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
	protected JobTitle removeImpl(JobTitle jobTitle) throws SystemException {
		jobTitle = toUnwrappedModel(jobTitle);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, jobTitle);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(jobTitle);

		return jobTitle;
	}

	@Override
	public JobTitle updateImpl(com.fsoft.bn.model.JobTitle jobTitle,
		boolean merge) throws SystemException {
		jobTitle = toUnwrappedModel(jobTitle);

		boolean isNew = jobTitle.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, jobTitle, merge);

			jobTitle.setNew(false);
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

		EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
			JobTitleImpl.class, jobTitle.getPrimaryKey(), jobTitle);

		return jobTitle;
	}

	protected JobTitle toUnwrappedModel(JobTitle jobTitle) {
		if (jobTitle instanceof JobTitleImpl) {
			return jobTitle;
		}

		JobTitleImpl jobTitleImpl = new JobTitleImpl();

		jobTitleImpl.setNew(jobTitle.isNew());
		jobTitleImpl.setPrimaryKey(jobTitle.getPrimaryKey());

		jobTitleImpl.setJob_title_id(jobTitle.getJob_title_id());
		jobTitleImpl.setUser_id(jobTitle.getUser_id());
		jobTitleImpl.setJob_id(jobTitle.getJob_id());
		jobTitleImpl.setCreated_date(jobTitle.getCreated_date());
		jobTitleImpl.setModified_date(jobTitle.getModified_date());
		jobTitleImpl.setDeleted(jobTitle.isDeleted());

		return jobTitleImpl;
	}

	/**
	 * Returns the job title with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title
	 * @throws com.liferay.portal.NoSuchModelException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the job title with the primary key or throws a {@link com.fsoft.bn.NoSuchJobTitleException} if it could not be found.
	 *
	 * @param job_title_id the primary key of the job title
	 * @return the job title
	 * @throws com.fsoft.bn.NoSuchJobTitleException if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobTitle findByPrimaryKey(String job_title_id)
		throws NoSuchJobTitleException, SystemException {
		JobTitle jobTitle = fetchByPrimaryKey(job_title_id);

		if (jobTitle == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + job_title_id);
			}

			throw new NoSuchJobTitleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				job_title_id);
		}

		return jobTitle;
	}

	/**
	 * Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job title
	 * @return the job title, or <code>null</code> if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobTitle fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param job_title_id the primary key of the job title
	 * @return the job title, or <code>null</code> if a job title with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public JobTitle fetchByPrimaryKey(String job_title_id)
		throws SystemException {
		JobTitle jobTitle = (JobTitle)EntityCacheUtil.getResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
				JobTitleImpl.class, job_title_id);

		if (jobTitle == _nullJobTitle) {
			return null;
		}

		if (jobTitle == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				jobTitle = (JobTitle)session.get(JobTitleImpl.class,
						job_title_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (jobTitle != null) {
					cacheResult(jobTitle);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(JobTitleModelImpl.ENTITY_CACHE_ENABLED,
						JobTitleImpl.class, job_title_id, _nullJobTitle);
				}

				closeSession(session);
			}
		}

		return jobTitle;
	}

	/**
	 * Returns all the job titles.
	 *
	 * @return the job titles
	 * @throws SystemException if a system exception occurred
	 */
	public List<JobTitle> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @return the range of job titles
	 * @throws SystemException if a system exception occurred
	 */
	public List<JobTitle> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of job titles
	 * @param end the upper bound of the range of job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job titles
	 * @throws SystemException if a system exception occurred
	 */
	public List<JobTitle> findAll(int start, int end,
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

		List<JobTitle> list = (List<JobTitle>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBTITLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBTITLE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<JobTitle>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the job titles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (JobTitle jobTitle : findAll()) {
			remove(jobTitle);
		}
	}

	/**
	 * Returns the number of job titles.
	 *
	 * @return the number of job titles
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBTITLE);

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
	 * Initializes the job title persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.JobTitle")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobTitle>> listenersList = new ArrayList<ModelListener<JobTitle>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobTitle>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobTitleImpl.class.getName());
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
	@BeanReference(type = JobTitlePersistence.class)
	protected JobTitlePersistence jobTitlePersistence;
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
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_JOBTITLE = "SELECT jobTitle FROM JobTitle jobTitle";
	private static final String _SQL_COUNT_JOBTITLE = "SELECT COUNT(jobTitle) FROM JobTitle jobTitle";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobTitle.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobTitle exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobTitlePersistenceImpl.class);
	private static JobTitle _nullJobTitle = new JobTitleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobTitle> toCacheModel() {
				return _nullJobTitleCacheModel;
			}
		};

	private static CacheModel<JobTitle> _nullJobTitleCacheModel = new CacheModel<JobTitle>() {
			public JobTitle toEntityModel() {
				return _nullJobTitle;
			}
		};
}