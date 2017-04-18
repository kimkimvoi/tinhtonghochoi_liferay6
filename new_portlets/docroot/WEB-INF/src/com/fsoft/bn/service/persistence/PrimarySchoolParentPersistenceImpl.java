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

import com.fsoft.bn.NoSuchPrimarySchoolParentException;
import com.fsoft.bn.model.PrimarySchoolParent;
import com.fsoft.bn.model.impl.PrimarySchoolParentImpl;
import com.fsoft.bn.model.impl.PrimarySchoolParentModelImpl;

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
 * The persistence implementation for the primary school parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolParentPersistence
 * @see PrimarySchoolParentUtil
 * @generated
 */
public class PrimarySchoolParentPersistenceImpl extends BasePersistenceImpl<PrimarySchoolParent>
	implements PrimarySchoolParentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrimarySchoolParentUtil} to access the primary school parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrimarySchoolParentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolParentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolParentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the primary school parent in the entity cache if it is enabled.
	 *
	 * @param primarySchoolParent the primary school parent
	 */
	public void cacheResult(PrimarySchoolParent primarySchoolParent) {
		EntityCacheUtil.putResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentImpl.class, primarySchoolParent.getPrimaryKey(),
			primarySchoolParent);

		primarySchoolParent.resetOriginalValues();
	}

	/**
	 * Caches the primary school parents in the entity cache if it is enabled.
	 *
	 * @param primarySchoolParents the primary school parents
	 */
	public void cacheResult(List<PrimarySchoolParent> primarySchoolParents) {
		for (PrimarySchoolParent primarySchoolParent : primarySchoolParents) {
			if (EntityCacheUtil.getResult(
						PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolParentImpl.class,
						primarySchoolParent.getPrimaryKey()) == null) {
				cacheResult(primarySchoolParent);
			}
			else {
				primarySchoolParent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all primary school parents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrimarySchoolParentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrimarySchoolParentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the primary school parent.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrimarySchoolParent primarySchoolParent) {
		EntityCacheUtil.removeResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentImpl.class, primarySchoolParent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PrimarySchoolParent> primarySchoolParents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrimarySchoolParent primarySchoolParent : primarySchoolParents) {
			EntityCacheUtil.removeResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolParentImpl.class,
				primarySchoolParent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new primary school parent with the primary key. Does not add the primary school parent to the database.
	 *
	 * @param primarySchoolParent_id the primary key for the new primary school parent
	 * @return the new primary school parent
	 */
	public PrimarySchoolParent create(String primarySchoolParent_id) {
		PrimarySchoolParent primarySchoolParent = new PrimarySchoolParentImpl();

		primarySchoolParent.setNew(true);
		primarySchoolParent.setPrimaryKey(primarySchoolParent_id);

		return primarySchoolParent;
	}

	/**
	 * Removes the primary school parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primarySchoolParent_id the primary key of the primary school parent
	 * @return the primary school parent that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolParentException if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolParent remove(String primarySchoolParent_id)
		throws NoSuchPrimarySchoolParentException, SystemException {
		return remove((Serializable)primarySchoolParent_id);
	}

	/**
	 * Removes the primary school parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the primary school parent
	 * @return the primary school parent that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolParentException if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolParent remove(Serializable primaryKey)
		throws NoSuchPrimarySchoolParentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrimarySchoolParent primarySchoolParent = (PrimarySchoolParent)session.get(PrimarySchoolParentImpl.class,
					primaryKey);

			if (primarySchoolParent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrimarySchoolParentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(primarySchoolParent);
		}
		catch (NoSuchPrimarySchoolParentException nsee) {
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
	protected PrimarySchoolParent removeImpl(
		PrimarySchoolParent primarySchoolParent) throws SystemException {
		primarySchoolParent = toUnwrappedModel(primarySchoolParent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, primarySchoolParent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(primarySchoolParent);

		return primarySchoolParent;
	}

	@Override
	public PrimarySchoolParent updateImpl(
		com.fsoft.bn.model.PrimarySchoolParent primarySchoolParent,
		boolean merge) throws SystemException {
		primarySchoolParent = toUnwrappedModel(primarySchoolParent);

		boolean isNew = primarySchoolParent.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, primarySchoolParent, merge);

			primarySchoolParent.setNew(false);
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

		EntityCacheUtil.putResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolParentImpl.class, primarySchoolParent.getPrimaryKey(),
			primarySchoolParent);

		return primarySchoolParent;
	}

	protected PrimarySchoolParent toUnwrappedModel(
		PrimarySchoolParent primarySchoolParent) {
		if (primarySchoolParent instanceof PrimarySchoolParentImpl) {
			return primarySchoolParent;
		}

		PrimarySchoolParentImpl primarySchoolParentImpl = new PrimarySchoolParentImpl();

		primarySchoolParentImpl.setNew(primarySchoolParent.isNew());
		primarySchoolParentImpl.setPrimaryKey(primarySchoolParent.getPrimaryKey());

		primarySchoolParentImpl.setPrimarySchoolParent_id(primarySchoolParent.getPrimarySchoolParent_id());
		primarySchoolParentImpl.setPrimaryStudent_id(primarySchoolParent.getPrimaryStudent_id());
		primarySchoolParentImpl.setName(primarySchoolParent.getName());
		primarySchoolParentImpl.setNationality(primarySchoolParent.getNationality());
		primarySchoolParentImpl.setIdCardNumber(primarySchoolParent.getIdCardNumber());
		primarySchoolParentImpl.setPhoneNumber(primarySchoolParent.getPhoneNumber());
		primarySchoolParentImpl.setEmail(primarySchoolParent.getEmail());
		primarySchoolParentImpl.setJob(primarySchoolParent.getJob());
		primarySchoolParentImpl.setJob_position(primarySchoolParent.getJob_position());
		primarySchoolParentImpl.setWorkplace(primarySchoolParent.getWorkplace());
		primarySchoolParentImpl.setIsMother(primarySchoolParent.isIsMother());
		primarySchoolParentImpl.setCreated_date(primarySchoolParent.getCreated_date());
		primarySchoolParentImpl.setModified_date(primarySchoolParent.getModified_date());
		primarySchoolParentImpl.setDeleted(primarySchoolParent.isDeleted());

		return primarySchoolParentImpl;
	}

	/**
	 * Returns the primary school parent with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school parent
	 * @return the primary school parent
	 * @throws com.liferay.portal.NoSuchModelException if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolParent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school parent with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolParentException} if it could not be found.
	 *
	 * @param primarySchoolParent_id the primary key of the primary school parent
	 * @return the primary school parent
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolParentException if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolParent findByPrimaryKey(String primarySchoolParent_id)
		throws NoSuchPrimarySchoolParentException, SystemException {
		PrimarySchoolParent primarySchoolParent = fetchByPrimaryKey(primarySchoolParent_id);

		if (primarySchoolParent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primarySchoolParent_id);
			}

			throw new NoSuchPrimarySchoolParentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primarySchoolParent_id);
		}

		return primarySchoolParent;
	}

	/**
	 * Returns the primary school parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school parent
	 * @return the primary school parent, or <code>null</code> if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolParent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primarySchoolParent_id the primary key of the primary school parent
	 * @return the primary school parent, or <code>null</code> if a primary school parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolParent fetchByPrimaryKey(String primarySchoolParent_id)
		throws SystemException {
		PrimarySchoolParent primarySchoolParent = (PrimarySchoolParent)EntityCacheUtil.getResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolParentImpl.class, primarySchoolParent_id);

		if (primarySchoolParent == _nullPrimarySchoolParent) {
			return null;
		}

		if (primarySchoolParent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				primarySchoolParent = (PrimarySchoolParent)session.get(PrimarySchoolParentImpl.class,
						primarySchoolParent_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (primarySchoolParent != null) {
					cacheResult(primarySchoolParent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PrimarySchoolParentModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolParentImpl.class, primarySchoolParent_id,
						_nullPrimarySchoolParent);
				}

				closeSession(session);
			}
		}

		return primarySchoolParent;
	}

	/**
	 * Returns all the primary school parents.
	 *
	 * @return the primary school parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolParent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary school parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school parents
	 * @param end the upper bound of the range of primary school parents (not inclusive)
	 * @return the range of primary school parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolParent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary school parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school parents
	 * @param end the upper bound of the range of primary school parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of primary school parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolParent> findAll(int start, int end,
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

		List<PrimarySchoolParent> list = (List<PrimarySchoolParent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRIMARYSCHOOLPARENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRIMARYSCHOOLPARENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PrimarySchoolParent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PrimarySchoolParent>)QueryUtil.list(q,
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
	 * Removes all the primary school parents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PrimarySchoolParent primarySchoolParent : findAll()) {
			remove(primarySchoolParent);
		}
	}

	/**
	 * Returns the number of primary school parents.
	 *
	 * @return the number of primary school parents
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRIMARYSCHOOLPARENT);

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
	 * Initializes the primary school parent persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PrimarySchoolParent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrimarySchoolParent>> listenersList = new ArrayList<ModelListener<PrimarySchoolParent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrimarySchoolParent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrimarySchoolParentImpl.class.getName());
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
	private static final String _SQL_SELECT_PRIMARYSCHOOLPARENT = "SELECT primarySchoolParent FROM PrimarySchoolParent primarySchoolParent";
	private static final String _SQL_COUNT_PRIMARYSCHOOLPARENT = "SELECT COUNT(primarySchoolParent) FROM PrimarySchoolParent primarySchoolParent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "primarySchoolParent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrimarySchoolParent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrimarySchoolParentPersistenceImpl.class);
	private static PrimarySchoolParent _nullPrimarySchoolParent = new PrimarySchoolParentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrimarySchoolParent> toCacheModel() {
				return _nullPrimarySchoolParentCacheModel;
			}
		};

	private static CacheModel<PrimarySchoolParent> _nullPrimarySchoolParentCacheModel =
		new CacheModel<PrimarySchoolParent>() {
			public PrimarySchoolParent toEntityModel() {
				return _nullPrimarySchoolParent;
			}
		};
}