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

import com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException;
import com.fsoft.bn.model.RecruitmentTrainingCourses;
import com.fsoft.bn.model.impl.RecruitmentTrainingCoursesImpl;
import com.fsoft.bn.model.impl.RecruitmentTrainingCoursesModelImpl;

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
 * The persistence implementation for the recruitment training courses service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentTrainingCoursesPersistence
 * @see RecruitmentTrainingCoursesUtil
 * @generated
 */
public class RecruitmentTrainingCoursesPersistenceImpl
	extends BasePersistenceImpl<RecruitmentTrainingCourses>
	implements RecruitmentTrainingCoursesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitmentTrainingCoursesUtil} to access the recruitment training courses persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitmentTrainingCoursesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentTrainingCoursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentTrainingCoursesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the recruitment training courses in the entity cache if it is enabled.
	 *
	 * @param recruitmentTrainingCourses the recruitment training courses
	 */
	public void cacheResult(
		RecruitmentTrainingCourses recruitmentTrainingCourses) {
		EntityCacheUtil.putResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesImpl.class,
			recruitmentTrainingCourses.getPrimaryKey(),
			recruitmentTrainingCourses);

		recruitmentTrainingCourses.resetOriginalValues();
	}

	/**
	 * Caches the recruitment training courseses in the entity cache if it is enabled.
	 *
	 * @param recruitmentTrainingCourseses the recruitment training courseses
	 */
	public void cacheResult(
		List<RecruitmentTrainingCourses> recruitmentTrainingCourseses) {
		for (RecruitmentTrainingCourses recruitmentTrainingCourses : recruitmentTrainingCourseses) {
			if (EntityCacheUtil.getResult(
						RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentTrainingCoursesImpl.class,
						recruitmentTrainingCourses.getPrimaryKey()) == null) {
				cacheResult(recruitmentTrainingCourses);
			}
			else {
				recruitmentTrainingCourses.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruitment training courseses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecruitmentTrainingCoursesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecruitmentTrainingCoursesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruitment training courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		RecruitmentTrainingCourses recruitmentTrainingCourses) {
		EntityCacheUtil.removeResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesImpl.class,
			recruitmentTrainingCourses.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RecruitmentTrainingCourses> recruitmentTrainingCourseses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecruitmentTrainingCourses recruitmentTrainingCourses : recruitmentTrainingCourseses) {
			EntityCacheUtil.removeResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentTrainingCoursesImpl.class,
				recruitmentTrainingCourses.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recruitment training courses with the primary key. Does not add the recruitment training courses to the database.
	 *
	 * @param recruitment_training_courses_id the primary key for the new recruitment training courses
	 * @return the new recruitment training courses
	 */
	public RecruitmentTrainingCourses create(
		String recruitment_training_courses_id) {
		RecruitmentTrainingCourses recruitmentTrainingCourses = new RecruitmentTrainingCoursesImpl();

		recruitmentTrainingCourses.setNew(true);
		recruitmentTrainingCourses.setPrimaryKey(recruitment_training_courses_id);

		return recruitmentTrainingCourses;
	}

	/**
	 * Removes the recruitment training courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_training_courses_id the primary key of the recruitment training courses
	 * @return the recruitment training courses that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentTrainingCourses remove(
		String recruitment_training_courses_id)
		throws NoSuchRecruitmentTrainingCoursesException, SystemException {
		return remove((Serializable)recruitment_training_courses_id);
	}

	/**
	 * Removes the recruitment training courses with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruitment training courses
	 * @return the recruitment training courses that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentTrainingCourses remove(Serializable primaryKey)
		throws NoSuchRecruitmentTrainingCoursesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RecruitmentTrainingCourses recruitmentTrainingCourses = (RecruitmentTrainingCourses)session.get(RecruitmentTrainingCoursesImpl.class,
					primaryKey);

			if (recruitmentTrainingCourses == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitmentTrainingCoursesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitmentTrainingCourses);
		}
		catch (NoSuchRecruitmentTrainingCoursesException nsee) {
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
	protected RecruitmentTrainingCourses removeImpl(
		RecruitmentTrainingCourses recruitmentTrainingCourses)
		throws SystemException {
		recruitmentTrainingCourses = toUnwrappedModel(recruitmentTrainingCourses);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, recruitmentTrainingCourses);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(recruitmentTrainingCourses);

		return recruitmentTrainingCourses;
	}

	@Override
	public RecruitmentTrainingCourses updateImpl(
		com.fsoft.bn.model.RecruitmentTrainingCourses recruitmentTrainingCourses,
		boolean merge) throws SystemException {
		recruitmentTrainingCourses = toUnwrappedModel(recruitmentTrainingCourses);

		boolean isNew = recruitmentTrainingCourses.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, recruitmentTrainingCourses, merge);

			recruitmentTrainingCourses.setNew(false);
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

		EntityCacheUtil.putResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentTrainingCoursesImpl.class,
			recruitmentTrainingCourses.getPrimaryKey(),
			recruitmentTrainingCourses);

		return recruitmentTrainingCourses;
	}

	protected RecruitmentTrainingCourses toUnwrappedModel(
		RecruitmentTrainingCourses recruitmentTrainingCourses) {
		if (recruitmentTrainingCourses instanceof RecruitmentTrainingCoursesImpl) {
			return recruitmentTrainingCourses;
		}

		RecruitmentTrainingCoursesImpl recruitmentTrainingCoursesImpl = new RecruitmentTrainingCoursesImpl();

		recruitmentTrainingCoursesImpl.setNew(recruitmentTrainingCourses.isNew());
		recruitmentTrainingCoursesImpl.setPrimaryKey(recruitmentTrainingCourses.getPrimaryKey());

		recruitmentTrainingCoursesImpl.setRecruitment_training_courses_id(recruitmentTrainingCourses.getRecruitment_training_courses_id());
		recruitmentTrainingCoursesImpl.setRecruitment_id(recruitmentTrainingCourses.getRecruitment_id());
		recruitmentTrainingCoursesImpl.setConductedBy(recruitmentTrainingCourses.getConductedBy());
		recruitmentTrainingCoursesImpl.setCourseName(recruitmentTrainingCourses.getCourseName());
		recruitmentTrainingCoursesImpl.setCourseDesc(recruitmentTrainingCourses.getCourseDesc());
		recruitmentTrainingCoursesImpl.setCourseDate(recruitmentTrainingCourses.getCourseDate());
		recruitmentTrainingCoursesImpl.setCertificate(recruitmentTrainingCourses.getCertificate());
		recruitmentTrainingCoursesImpl.setCreated_date(recruitmentTrainingCourses.getCreated_date());
		recruitmentTrainingCoursesImpl.setModified_date(recruitmentTrainingCourses.getModified_date());
		recruitmentTrainingCoursesImpl.setDeleted(recruitmentTrainingCourses.isDeleted());

		return recruitmentTrainingCoursesImpl;
	}

	/**
	 * Returns the recruitment training courses with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment training courses
	 * @return the recruitment training courses
	 * @throws com.liferay.portal.NoSuchModelException if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentTrainingCourses findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment training courses with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException} if it could not be found.
	 *
	 * @param recruitment_training_courses_id the primary key of the recruitment training courses
	 * @return the recruitment training courses
	 * @throws com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentTrainingCourses findByPrimaryKey(
		String recruitment_training_courses_id)
		throws NoSuchRecruitmentTrainingCoursesException, SystemException {
		RecruitmentTrainingCourses recruitmentTrainingCourses = fetchByPrimaryKey(recruitment_training_courses_id);

		if (recruitmentTrainingCourses == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					recruitment_training_courses_id);
			}

			throw new NoSuchRecruitmentTrainingCoursesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recruitment_training_courses_id);
		}

		return recruitmentTrainingCourses;
	}

	/**
	 * Returns the recruitment training courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment training courses
	 * @return the recruitment training courses, or <code>null</code> if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentTrainingCourses fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment training courses with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitment_training_courses_id the primary key of the recruitment training courses
	 * @return the recruitment training courses, or <code>null</code> if a recruitment training courses with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentTrainingCourses fetchByPrimaryKey(
		String recruitment_training_courses_id) throws SystemException {
		RecruitmentTrainingCourses recruitmentTrainingCourses = (RecruitmentTrainingCourses)EntityCacheUtil.getResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentTrainingCoursesImpl.class,
				recruitment_training_courses_id);

		if (recruitmentTrainingCourses == _nullRecruitmentTrainingCourses) {
			return null;
		}

		if (recruitmentTrainingCourses == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				recruitmentTrainingCourses = (RecruitmentTrainingCourses)session.get(RecruitmentTrainingCoursesImpl.class,
						recruitment_training_courses_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (recruitmentTrainingCourses != null) {
					cacheResult(recruitmentTrainingCourses);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RecruitmentTrainingCoursesModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentTrainingCoursesImpl.class,
						recruitment_training_courses_id,
						_nullRecruitmentTrainingCourses);
				}

				closeSession(session);
			}
		}

		return recruitmentTrainingCourses;
	}

	/**
	 * Returns all the recruitment training courseses.
	 *
	 * @return the recruitment training courseses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentTrainingCourses> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruitment training courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment training courseses
	 * @param end the upper bound of the range of recruitment training courseses (not inclusive)
	 * @return the range of recruitment training courseses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentTrainingCourses> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruitment training courseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment training courseses
	 * @param end the upper bound of the range of recruitment training courseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruitment training courseses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentTrainingCourses> findAll(int start, int end,
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

		List<RecruitmentTrainingCourses> list = (List<RecruitmentTrainingCourses>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECRUITMENTTRAININGCOURSES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITMENTTRAININGCOURSES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RecruitmentTrainingCourses>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RecruitmentTrainingCourses>)QueryUtil.list(q,
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
	 * Removes all the recruitment training courseses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RecruitmentTrainingCourses recruitmentTrainingCourses : findAll()) {
			remove(recruitmentTrainingCourses);
		}
	}

	/**
	 * Returns the number of recruitment training courseses.
	 *
	 * @return the number of recruitment training courseses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITMENTTRAININGCOURSES);

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
	 * Initializes the recruitment training courses persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.RecruitmentTrainingCourses")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RecruitmentTrainingCourses>> listenersList = new ArrayList<ModelListener<RecruitmentTrainingCourses>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RecruitmentTrainingCourses>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecruitmentTrainingCoursesImpl.class.getName());
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
	private static final String _SQL_SELECT_RECRUITMENTTRAININGCOURSES = "SELECT recruitmentTrainingCourses FROM RecruitmentTrainingCourses recruitmentTrainingCourses";
	private static final String _SQL_COUNT_RECRUITMENTTRAININGCOURSES = "SELECT COUNT(recruitmentTrainingCourses) FROM RecruitmentTrainingCourses recruitmentTrainingCourses";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitmentTrainingCourses.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecruitmentTrainingCourses exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecruitmentTrainingCoursesPersistenceImpl.class);
	private static RecruitmentTrainingCourses _nullRecruitmentTrainingCourses = new RecruitmentTrainingCoursesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RecruitmentTrainingCourses> toCacheModel() {
				return _nullRecruitmentTrainingCoursesCacheModel;
			}
		};

	private static CacheModel<RecruitmentTrainingCourses> _nullRecruitmentTrainingCoursesCacheModel =
		new CacheModel<RecruitmentTrainingCourses>() {
			public RecruitmentTrainingCourses toEntityModel() {
				return _nullRecruitmentTrainingCourses;
			}
		};
}