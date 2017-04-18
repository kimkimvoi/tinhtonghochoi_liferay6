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

import com.fsoft.bn.NoSuchUserScheduleException;
import com.fsoft.bn.model.UserSchedule;
import com.fsoft.bn.model.impl.UserScheduleImpl;
import com.fsoft.bn.model.impl.UserScheduleModelImpl;

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
 * The persistence implementation for the user schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserSchedulePersistence
 * @see UserScheduleUtil
 * @generated
 */
public class UserSchedulePersistenceImpl extends BasePersistenceImpl<UserSchedule>
	implements UserSchedulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserScheduleUtil} to access the user schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserScheduleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleModelImpl.FINDER_CACHE_ENABLED, UserScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleModelImpl.FINDER_CACHE_ENABLED, UserScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user schedule in the entity cache if it is enabled.
	 *
	 * @param userSchedule the user schedule
	 */
	public void cacheResult(UserSchedule userSchedule) {
		EntityCacheUtil.putResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleImpl.class, userSchedule.getPrimaryKey(), userSchedule);

		userSchedule.resetOriginalValues();
	}

	/**
	 * Caches the user schedules in the entity cache if it is enabled.
	 *
	 * @param userSchedules the user schedules
	 */
	public void cacheResult(List<UserSchedule> userSchedules) {
		for (UserSchedule userSchedule : userSchedules) {
			if (EntityCacheUtil.getResult(
						UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
						UserScheduleImpl.class, userSchedule.getPrimaryKey()) == null) {
				cacheResult(userSchedule);
			}
			else {
				userSchedule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user schedules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserScheduleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserScheduleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user schedule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserSchedule userSchedule) {
		EntityCacheUtil.removeResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleImpl.class, userSchedule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserSchedule> userSchedules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserSchedule userSchedule : userSchedules) {
			EntityCacheUtil.removeResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
				UserScheduleImpl.class, userSchedule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user schedule with the primary key. Does not add the user schedule to the database.
	 *
	 * @param user_schedule_id the primary key for the new user schedule
	 * @return the new user schedule
	 */
	public UserSchedule create(String user_schedule_id) {
		UserSchedule userSchedule = new UserScheduleImpl();

		userSchedule.setNew(true);
		userSchedule.setPrimaryKey(user_schedule_id);

		return userSchedule;
	}

	/**
	 * Removes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param user_schedule_id the primary key of the user schedule
	 * @return the user schedule that was removed
	 * @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSchedule remove(String user_schedule_id)
		throws NoSuchUserScheduleException, SystemException {
		return remove((Serializable)user_schedule_id);
	}

	/**
	 * Removes the user schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user schedule
	 * @return the user schedule that was removed
	 * @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSchedule remove(Serializable primaryKey)
		throws NoSuchUserScheduleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserSchedule userSchedule = (UserSchedule)session.get(UserScheduleImpl.class,
					primaryKey);

			if (userSchedule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userSchedule);
		}
		catch (NoSuchUserScheduleException nsee) {
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
	protected UserSchedule removeImpl(UserSchedule userSchedule)
		throws SystemException {
		userSchedule = toUnwrappedModel(userSchedule);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userSchedule);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userSchedule);

		return userSchedule;
	}

	@Override
	public UserSchedule updateImpl(
		com.fsoft.bn.model.UserSchedule userSchedule, boolean merge)
		throws SystemException {
		userSchedule = toUnwrappedModel(userSchedule);

		boolean isNew = userSchedule.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userSchedule, merge);

			userSchedule.setNew(false);
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

		EntityCacheUtil.putResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
			UserScheduleImpl.class, userSchedule.getPrimaryKey(), userSchedule);

		return userSchedule;
	}

	protected UserSchedule toUnwrappedModel(UserSchedule userSchedule) {
		if (userSchedule instanceof UserScheduleImpl) {
			return userSchedule;
		}

		UserScheduleImpl userScheduleImpl = new UserScheduleImpl();

		userScheduleImpl.setNew(userSchedule.isNew());
		userScheduleImpl.setPrimaryKey(userSchedule.getPrimaryKey());

		userScheduleImpl.setUser_schedule_id(userSchedule.getUser_schedule_id());
		userScheduleImpl.setUser_id(userSchedule.getUser_id());
		userScheduleImpl.setCreated_date(userSchedule.getCreated_date());
		userScheduleImpl.setModified_date(userSchedule.getModified_date());
		userScheduleImpl.setDeleted(userSchedule.isDeleted());

		return userScheduleImpl;
	}

	/**
	 * Returns the user schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user schedule
	 * @return the user schedule
	 * @throws com.liferay.portal.NoSuchModelException if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSchedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the user schedule with the primary key or throws a {@link com.fsoft.bn.NoSuchUserScheduleException} if it could not be found.
	 *
	 * @param user_schedule_id the primary key of the user schedule
	 * @return the user schedule
	 * @throws com.fsoft.bn.NoSuchUserScheduleException if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSchedule findByPrimaryKey(String user_schedule_id)
		throws NoSuchUserScheduleException, SystemException {
		UserSchedule userSchedule = fetchByPrimaryKey(user_schedule_id);

		if (userSchedule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + user_schedule_id);
			}

			throw new NoSuchUserScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				user_schedule_id);
		}

		return userSchedule;
	}

	/**
	 * Returns the user schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user schedule
	 * @return the user schedule, or <code>null</code> if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserSchedule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the user schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param user_schedule_id the primary key of the user schedule
	 * @return the user schedule, or <code>null</code> if a user schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserSchedule fetchByPrimaryKey(String user_schedule_id)
		throws SystemException {
		UserSchedule userSchedule = (UserSchedule)EntityCacheUtil.getResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
				UserScheduleImpl.class, user_schedule_id);

		if (userSchedule == _nullUserSchedule) {
			return null;
		}

		if (userSchedule == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userSchedule = (UserSchedule)session.get(UserScheduleImpl.class,
						user_schedule_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userSchedule != null) {
					cacheResult(userSchedule);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserScheduleModelImpl.ENTITY_CACHE_ENABLED,
						UserScheduleImpl.class, user_schedule_id,
						_nullUserSchedule);
				}

				closeSession(session);
			}
		}

		return userSchedule;
	}

	/**
	 * Returns all the user schedules.
	 *
	 * @return the user schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSchedule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user schedules
	 * @param end the upper bound of the range of user schedules (not inclusive)
	 * @return the range of user schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSchedule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user schedules
	 * @param end the upper bound of the range of user schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserSchedule> findAll(int start, int end,
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

		List<UserSchedule> list = (List<UserSchedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSCHEDULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSCHEDULE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserSchedule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserSchedule>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user schedules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserSchedule userSchedule : findAll()) {
			remove(userSchedule);
		}
	}

	/**
	 * Returns the number of user schedules.
	 *
	 * @return the number of user schedules
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSCHEDULE);

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
	 * Initializes the user schedule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.UserSchedule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserSchedule>> listenersList = new ArrayList<ModelListener<UserSchedule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserSchedule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserScheduleImpl.class.getName());
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
	private static final String _SQL_SELECT_USERSCHEDULE = "SELECT userSchedule FROM UserSchedule userSchedule";
	private static final String _SQL_COUNT_USERSCHEDULE = "SELECT COUNT(userSchedule) FROM UserSchedule userSchedule";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userSchedule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserSchedule exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserSchedulePersistenceImpl.class);
	private static UserSchedule _nullUserSchedule = new UserScheduleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserSchedule> toCacheModel() {
				return _nullUserScheduleCacheModel;
			}
		};

	private static CacheModel<UserSchedule> _nullUserScheduleCacheModel = new CacheModel<UserSchedule>() {
			public UserSchedule toEntityModel() {
				return _nullUserSchedule;
			}
		};
}