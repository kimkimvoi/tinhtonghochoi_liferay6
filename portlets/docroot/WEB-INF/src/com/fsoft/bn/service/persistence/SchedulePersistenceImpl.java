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

import com.fsoft.bn.NoSuchScheduleException;
import com.fsoft.bn.model.Schedule;
import com.fsoft.bn.model.impl.ScheduleImpl;
import com.fsoft.bn.model.impl.ScheduleModelImpl;

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
 * The persistence implementation for the schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see SchedulePersistence
 * @see ScheduleUtil
 * @generated
 */
public class SchedulePersistenceImpl extends BasePersistenceImpl<Schedule>
	implements SchedulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScheduleUtil} to access the schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScheduleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, ScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the schedule in the entity cache if it is enabled.
	 *
	 * @param schedule the schedule
	 */
	public void cacheResult(Schedule schedule) {
		EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey(), schedule);

		schedule.resetOriginalValues();
	}

	/**
	 * Caches the schedules in the entity cache if it is enabled.
	 *
	 * @param schedules the schedules
	 */
	public void cacheResult(List<Schedule> schedules) {
		for (Schedule schedule : schedules) {
			if (EntityCacheUtil.getResult(
						ScheduleModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleImpl.class, schedule.getPrimaryKey()) == null) {
				cacheResult(schedule);
			}
			else {
				schedule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all schedules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScheduleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScheduleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the schedule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Schedule schedule) {
		EntityCacheUtil.removeResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Schedule> schedules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Schedule schedule : schedules) {
			EntityCacheUtil.removeResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleImpl.class, schedule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new schedule with the primary key. Does not add the schedule to the database.
	 *
	 * @param schedule_id the primary key for the new schedule
	 * @return the new schedule
	 */
	public Schedule create(String schedule_id) {
		Schedule schedule = new ScheduleImpl();

		schedule.setNew(true);
		schedule.setPrimaryKey(schedule_id);

		return schedule;
	}

	/**
	 * Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schedule_id the primary key of the schedule
	 * @return the schedule that was removed
	 * @throws com.fsoft.bn.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Schedule remove(String schedule_id)
		throws NoSuchScheduleException, SystemException {
		return remove((Serializable)schedule_id);
	}

	/**
	 * Removes the schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule that was removed
	 * @throws com.fsoft.bn.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule remove(Serializable primaryKey)
		throws NoSuchScheduleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Schedule schedule = (Schedule)session.get(ScheduleImpl.class,
					primaryKey);

			if (schedule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(schedule);
		}
		catch (NoSuchScheduleException nsee) {
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
	protected Schedule removeImpl(Schedule schedule) throws SystemException {
		schedule = toUnwrappedModel(schedule);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, schedule);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(schedule);

		return schedule;
	}

	@Override
	public Schedule updateImpl(com.fsoft.bn.model.Schedule schedule,
		boolean merge) throws SystemException {
		schedule = toUnwrappedModel(schedule);

		boolean isNew = schedule.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, schedule, merge);

			schedule.setNew(false);
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

		EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
			ScheduleImpl.class, schedule.getPrimaryKey(), schedule);

		return schedule;
	}

	protected Schedule toUnwrappedModel(Schedule schedule) {
		if (schedule instanceof ScheduleImpl) {
			return schedule;
		}

		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setNew(schedule.isNew());
		scheduleImpl.setPrimaryKey(schedule.getPrimaryKey());

		scheduleImpl.setSchedule_id(schedule.getSchedule_id());
		scheduleImpl.setSchedule_date(schedule.getSchedule_date());
		scheduleImpl.setContent(schedule.getContent());
		scheduleImpl.setUser_id(schedule.getUser_id());
		scheduleImpl.setCreated_date(schedule.getCreated_date());
		scheduleImpl.setModified_date(schedule.getModified_date());
		scheduleImpl.setDeleted(schedule.isDeleted());

		return scheduleImpl;
	}

	/**
	 * Returns the schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule
	 * @throws com.liferay.portal.NoSuchModelException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the schedule with the primary key or throws a {@link com.fsoft.bn.NoSuchScheduleException} if it could not be found.
	 *
	 * @param schedule_id the primary key of the schedule
	 * @return the schedule
	 * @throws com.fsoft.bn.NoSuchScheduleException if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Schedule findByPrimaryKey(String schedule_id)
		throws NoSuchScheduleException, SystemException {
		Schedule schedule = fetchByPrimaryKey(schedule_id);

		if (schedule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + schedule_id);
			}

			throw new NoSuchScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				schedule_id);
		}

		return schedule;
	}

	/**
	 * Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule
	 * @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Schedule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param schedule_id the primary key of the schedule
	 * @return the schedule, or <code>null</code> if a schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Schedule fetchByPrimaryKey(String schedule_id)
		throws SystemException {
		Schedule schedule = (Schedule)EntityCacheUtil.getResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
				ScheduleImpl.class, schedule_id);

		if (schedule == _nullSchedule) {
			return null;
		}

		if (schedule == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				schedule = (Schedule)session.get(ScheduleImpl.class, schedule_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (schedule != null) {
					cacheResult(schedule);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ScheduleModelImpl.ENTITY_CACHE_ENABLED,
						ScheduleImpl.class, schedule_id, _nullSchedule);
				}

				closeSession(session);
			}
		}

		return schedule;
	}

	/**
	 * Returns all the schedules.
	 *
	 * @return the schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Schedule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @return the range of schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Schedule> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedules
	 * @param end the upper bound of the range of schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schedules
	 * @throws SystemException if a system exception occurred
	 */
	public List<Schedule> findAll(int start, int end,
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

		List<Schedule> list = (List<Schedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCHEDULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Schedule>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the schedules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Schedule schedule : findAll()) {
			remove(schedule);
		}
	}

	/**
	 * Returns the number of schedules.
	 *
	 * @return the number of schedules
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SCHEDULE);

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
	 * Initializes the schedule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Schedule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Schedule>> listenersList = new ArrayList<ModelListener<Schedule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Schedule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScheduleImpl.class.getName());
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
	private static final String _SQL_SELECT_SCHEDULE = "SELECT schedule FROM Schedule schedule";
	private static final String _SQL_COUNT_SCHEDULE = "SELECT COUNT(schedule) FROM Schedule schedule";
	private static final String _ORDER_BY_ENTITY_ALIAS = "schedule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Schedule exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SchedulePersistenceImpl.class);
	private static Schedule _nullSchedule = new ScheduleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Schedule> toCacheModel() {
				return _nullScheduleCacheModel;
			}
		};

	private static CacheModel<Schedule> _nullScheduleCacheModel = new CacheModel<Schedule>() {
			public Schedule toEntityModel() {
				return _nullSchedule;
			}
		};
}