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

import com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException;
import com.fsoft.bn.model.RecruitmentEducationalHistory;
import com.fsoft.bn.model.impl.RecruitmentEducationalHistoryImpl;
import com.fsoft.bn.model.impl.RecruitmentEducationalHistoryModelImpl;

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
 * The persistence implementation for the recruitment educational history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentEducationalHistoryPersistence
 * @see RecruitmentEducationalHistoryUtil
 * @generated
 */
public class RecruitmentEducationalHistoryPersistenceImpl
	extends BasePersistenceImpl<RecruitmentEducationalHistory>
	implements RecruitmentEducationalHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitmentEducationalHistoryUtil} to access the recruitment educational history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitmentEducationalHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentEducationalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentEducationalHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the recruitment educational history in the entity cache if it is enabled.
	 *
	 * @param recruitmentEducationalHistory the recruitment educational history
	 */
	public void cacheResult(
		RecruitmentEducationalHistory recruitmentEducationalHistory) {
		EntityCacheUtil.putResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryImpl.class,
			recruitmentEducationalHistory.getPrimaryKey(),
			recruitmentEducationalHistory);

		recruitmentEducationalHistory.resetOriginalValues();
	}

	/**
	 * Caches the recruitment educational histories in the entity cache if it is enabled.
	 *
	 * @param recruitmentEducationalHistories the recruitment educational histories
	 */
	public void cacheResult(
		List<RecruitmentEducationalHistory> recruitmentEducationalHistories) {
		for (RecruitmentEducationalHistory recruitmentEducationalHistory : recruitmentEducationalHistories) {
			if (EntityCacheUtil.getResult(
						RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentEducationalHistoryImpl.class,
						recruitmentEducationalHistory.getPrimaryKey()) == null) {
				cacheResult(recruitmentEducationalHistory);
			}
			else {
				recruitmentEducationalHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruitment educational histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecruitmentEducationalHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecruitmentEducationalHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruitment educational history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		RecruitmentEducationalHistory recruitmentEducationalHistory) {
		EntityCacheUtil.removeResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryImpl.class,
			recruitmentEducationalHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RecruitmentEducationalHistory> recruitmentEducationalHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecruitmentEducationalHistory recruitmentEducationalHistory : recruitmentEducationalHistories) {
			EntityCacheUtil.removeResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentEducationalHistoryImpl.class,
				recruitmentEducationalHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recruitment educational history with the primary key. Does not add the recruitment educational history to the database.
	 *
	 * @param recruitment_educational_history_id the primary key for the new recruitment educational history
	 * @return the new recruitment educational history
	 */
	public RecruitmentEducationalHistory create(
		String recruitment_educational_history_id) {
		RecruitmentEducationalHistory recruitmentEducationalHistory = new RecruitmentEducationalHistoryImpl();

		recruitmentEducationalHistory.setNew(true);
		recruitmentEducationalHistory.setPrimaryKey(recruitment_educational_history_id);

		return recruitmentEducationalHistory;
	}

	/**
	 * Removes the recruitment educational history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_educational_history_id the primary key of the recruitment educational history
	 * @return the recruitment educational history that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentEducationalHistory remove(
		String recruitment_educational_history_id)
		throws NoSuchRecruitmentEducationalHistoryException, SystemException {
		return remove((Serializable)recruitment_educational_history_id);
	}

	/**
	 * Removes the recruitment educational history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruitment educational history
	 * @return the recruitment educational history that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentEducationalHistory remove(Serializable primaryKey)
		throws NoSuchRecruitmentEducationalHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RecruitmentEducationalHistory recruitmentEducationalHistory = (RecruitmentEducationalHistory)session.get(RecruitmentEducationalHistoryImpl.class,
					primaryKey);

			if (recruitmentEducationalHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitmentEducationalHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitmentEducationalHistory);
		}
		catch (NoSuchRecruitmentEducationalHistoryException nsee) {
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
	protected RecruitmentEducationalHistory removeImpl(
		RecruitmentEducationalHistory recruitmentEducationalHistory)
		throws SystemException {
		recruitmentEducationalHistory = toUnwrappedModel(recruitmentEducationalHistory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, recruitmentEducationalHistory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(recruitmentEducationalHistory);

		return recruitmentEducationalHistory;
	}

	@Override
	public RecruitmentEducationalHistory updateImpl(
		com.fsoft.bn.model.RecruitmentEducationalHistory recruitmentEducationalHistory,
		boolean merge) throws SystemException {
		recruitmentEducationalHistory = toUnwrappedModel(recruitmentEducationalHistory);

		boolean isNew = recruitmentEducationalHistory.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, recruitmentEducationalHistory,
				merge);

			recruitmentEducationalHistory.setNew(false);
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

		EntityCacheUtil.putResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentEducationalHistoryImpl.class,
			recruitmentEducationalHistory.getPrimaryKey(),
			recruitmentEducationalHistory);

		return recruitmentEducationalHistory;
	}

	protected RecruitmentEducationalHistory toUnwrappedModel(
		RecruitmentEducationalHistory recruitmentEducationalHistory) {
		if (recruitmentEducationalHistory instanceof RecruitmentEducationalHistoryImpl) {
			return recruitmentEducationalHistory;
		}

		RecruitmentEducationalHistoryImpl recruitmentEducationalHistoryImpl = new RecruitmentEducationalHistoryImpl();

		recruitmentEducationalHistoryImpl.setNew(recruitmentEducationalHistory.isNew());
		recruitmentEducationalHistoryImpl.setPrimaryKey(recruitmentEducationalHistory.getPrimaryKey());

		recruitmentEducationalHistoryImpl.setRecruitment_educational_history_id(recruitmentEducationalHistory.getRecruitment_educational_history_id());
		recruitmentEducationalHistoryImpl.setRecruitment_id(recruitmentEducationalHistory.getRecruitment_id());
		recruitmentEducationalHistoryImpl.setSchool(recruitmentEducationalHistory.getSchool());
		recruitmentEducationalHistoryImpl.setTypeOfTraining(recruitmentEducationalHistory.getTypeOfTraining());
		recruitmentEducationalHistoryImpl.setSpeciality(recruitmentEducationalHistory.getSpeciality());
		recruitmentEducationalHistoryImpl.setTypeOfDegree(recruitmentEducationalHistory.getTypeOfDegree());
		recruitmentEducationalHistoryImpl.setGraduatedYear(recruitmentEducationalHistory.getGraduatedYear());
		recruitmentEducationalHistoryImpl.setCreated_date(recruitmentEducationalHistory.getCreated_date());
		recruitmentEducationalHistoryImpl.setModified_date(recruitmentEducationalHistory.getModified_date());
		recruitmentEducationalHistoryImpl.setDeleted(recruitmentEducationalHistory.isDeleted());

		return recruitmentEducationalHistoryImpl;
	}

	/**
	 * Returns the recruitment educational history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment educational history
	 * @return the recruitment educational history
	 * @throws com.liferay.portal.NoSuchModelException if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentEducationalHistory findByPrimaryKey(
		Serializable primaryKey) throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment educational history with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException} if it could not be found.
	 *
	 * @param recruitment_educational_history_id the primary key of the recruitment educational history
	 * @return the recruitment educational history
	 * @throws com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentEducationalHistory findByPrimaryKey(
		String recruitment_educational_history_id)
		throws NoSuchRecruitmentEducationalHistoryException, SystemException {
		RecruitmentEducationalHistory recruitmentEducationalHistory = fetchByPrimaryKey(recruitment_educational_history_id);

		if (recruitmentEducationalHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					recruitment_educational_history_id);
			}

			throw new NoSuchRecruitmentEducationalHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recruitment_educational_history_id);
		}

		return recruitmentEducationalHistory;
	}

	/**
	 * Returns the recruitment educational history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment educational history
	 * @return the recruitment educational history, or <code>null</code> if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentEducationalHistory fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment educational history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitment_educational_history_id the primary key of the recruitment educational history
	 * @return the recruitment educational history, or <code>null</code> if a recruitment educational history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentEducationalHistory fetchByPrimaryKey(
		String recruitment_educational_history_id) throws SystemException {
		RecruitmentEducationalHistory recruitmentEducationalHistory = (RecruitmentEducationalHistory)EntityCacheUtil.getResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentEducationalHistoryImpl.class,
				recruitment_educational_history_id);

		if (recruitmentEducationalHistory == _nullRecruitmentEducationalHistory) {
			return null;
		}

		if (recruitmentEducationalHistory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				recruitmentEducationalHistory = (RecruitmentEducationalHistory)session.get(RecruitmentEducationalHistoryImpl.class,
						recruitment_educational_history_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (recruitmentEducationalHistory != null) {
					cacheResult(recruitmentEducationalHistory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RecruitmentEducationalHistoryModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentEducationalHistoryImpl.class,
						recruitment_educational_history_id,
						_nullRecruitmentEducationalHistory);
				}

				closeSession(session);
			}
		}

		return recruitmentEducationalHistory;
	}

	/**
	 * Returns all the recruitment educational histories.
	 *
	 * @return the recruitment educational histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentEducationalHistory> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruitment educational histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment educational histories
	 * @param end the upper bound of the range of recruitment educational histories (not inclusive)
	 * @return the range of recruitment educational histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentEducationalHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruitment educational histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment educational histories
	 * @param end the upper bound of the range of recruitment educational histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruitment educational histories
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentEducationalHistory> findAll(int start, int end,
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

		List<RecruitmentEducationalHistory> list = (List<RecruitmentEducationalHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECRUITMENTEDUCATIONALHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITMENTEDUCATIONALHISTORY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RecruitmentEducationalHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RecruitmentEducationalHistory>)QueryUtil.list(q,
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
	 * Removes all the recruitment educational histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RecruitmentEducationalHistory recruitmentEducationalHistory : findAll()) {
			remove(recruitmentEducationalHistory);
		}
	}

	/**
	 * Returns the number of recruitment educational histories.
	 *
	 * @return the number of recruitment educational histories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITMENTEDUCATIONALHISTORY);

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
	 * Initializes the recruitment educational history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.RecruitmentEducationalHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RecruitmentEducationalHistory>> listenersList =
					new ArrayList<ModelListener<RecruitmentEducationalHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RecruitmentEducationalHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecruitmentEducationalHistoryImpl.class.getName());
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
	@BeanReference(type = EnrolmentPersistence.class)
	protected EnrolmentPersistence enrolmentPersistence;
	@BeanReference(type = EnrolmentAttachedFilePersistence.class)
	protected EnrolmentAttachedFilePersistence enrolmentAttachedFilePersistence;
	@BeanReference(type = InvestmentProjectsPersistence.class)
	protected InvestmentProjectsPersistence investmentProjectsPersistence;
	@BeanReference(type = OrganizationsPersistence.class)
	protected OrganizationsPersistence organizationsPersistence;
	@BeanReference(type = PreschoolAttachedFilePersistence.class)
	protected PreschoolAttachedFilePersistence preschoolAttachedFilePersistence;
	@BeanReference(type = PreschoolParentPersistence.class)
	protected PreschoolParentPersistence preschoolParentPersistence;
	@BeanReference(type = PreschoolStudentPersistence.class)
	protected PreschoolStudentPersistence preschoolStudentPersistence;
	@BeanReference(type = PrimarySchoolAttachedFilePersistence.class)
	protected PrimarySchoolAttachedFilePersistence primarySchoolAttachedFilePersistence;
	@BeanReference(type = PrimarySchoolParentPersistence.class)
	protected PrimarySchoolParentPersistence primarySchoolParentPersistence;
	@BeanReference(type = PrimarySchoolStudentPersistence.class)
	protected PrimarySchoolStudentPersistence primarySchoolStudentPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionAttachedFilePersistence.class)
	protected QuestionAttachedFilePersistence questionAttachedFilePersistence;
	@BeanReference(type = RecruitmentPersistence.class)
	protected RecruitmentPersistence recruitmentPersistence;
	@BeanReference(type = RecruitmentAttachedFilePersistence.class)
	protected RecruitmentAttachedFilePersistence recruitmentAttachedFilePersistence;
	@BeanReference(type = RecruitmentEducationalHistoryPersistence.class)
	protected RecruitmentEducationalHistoryPersistence recruitmentEducationalHistoryPersistence;
	@BeanReference(type = RecruitmentLanguagesPersistence.class)
	protected RecruitmentLanguagesPersistence recruitmentLanguagesPersistence;
	@BeanReference(type = RecruitmentProgrammingsPersistence.class)
	protected RecruitmentProgrammingsPersistence recruitmentProgrammingsPersistence;
	@BeanReference(type = RecruitmentTrainingCoursesPersistence.class)
	protected RecruitmentTrainingCoursesPersistence recruitmentTrainingCoursesPersistence;
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
	private static final String _SQL_SELECT_RECRUITMENTEDUCATIONALHISTORY = "SELECT recruitmentEducationalHistory FROM RecruitmentEducationalHistory recruitmentEducationalHistory";
	private static final String _SQL_COUNT_RECRUITMENTEDUCATIONALHISTORY = "SELECT COUNT(recruitmentEducationalHistory) FROM RecruitmentEducationalHistory recruitmentEducationalHistory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitmentEducationalHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecruitmentEducationalHistory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecruitmentEducationalHistoryPersistenceImpl.class);
	private static RecruitmentEducationalHistory _nullRecruitmentEducationalHistory =
		new RecruitmentEducationalHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RecruitmentEducationalHistory> toCacheModel() {
				return _nullRecruitmentEducationalHistoryCacheModel;
			}
		};

	private static CacheModel<RecruitmentEducationalHistory> _nullRecruitmentEducationalHistoryCacheModel =
		new CacheModel<RecruitmentEducationalHistory>() {
			public RecruitmentEducationalHistory toEntityModel() {
				return _nullRecruitmentEducationalHistory;
			}
		};
}