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

import com.fsoft.bn.NoSuchPreschoolParentException;
import com.fsoft.bn.model.PreschoolParent;
import com.fsoft.bn.model.impl.PreschoolParentImpl;
import com.fsoft.bn.model.impl.PreschoolParentModelImpl;

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
 * The persistence implementation for the preschool parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolParentPersistence
 * @see PreschoolParentUtil
 * @generated
 */
public class PreschoolParentPersistenceImpl extends BasePersistenceImpl<PreschoolParent>
	implements PreschoolParentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PreschoolParentUtil} to access the preschool parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PreschoolParentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentModelImpl.FINDER_CACHE_ENABLED,
			PreschoolParentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentModelImpl.FINDER_CACHE_ENABLED,
			PreschoolParentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the preschool parent in the entity cache if it is enabled.
	 *
	 * @param preschoolParent the preschool parent
	 */
	public void cacheResult(PreschoolParent preschoolParent) {
		EntityCacheUtil.putResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentImpl.class, preschoolParent.getPrimaryKey(),
			preschoolParent);

		preschoolParent.resetOriginalValues();
	}

	/**
	 * Caches the preschool parents in the entity cache if it is enabled.
	 *
	 * @param preschoolParents the preschool parents
	 */
	public void cacheResult(List<PreschoolParent> preschoolParents) {
		for (PreschoolParent preschoolParent : preschoolParents) {
			if (EntityCacheUtil.getResult(
						PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolParentImpl.class,
						preschoolParent.getPrimaryKey()) == null) {
				cacheResult(preschoolParent);
			}
			else {
				preschoolParent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all preschool parents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PreschoolParentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PreschoolParentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the preschool parent.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PreschoolParent preschoolParent) {
		EntityCacheUtil.removeResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentImpl.class, preschoolParent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PreschoolParent> preschoolParents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PreschoolParent preschoolParent : preschoolParents) {
			EntityCacheUtil.removeResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolParentImpl.class, preschoolParent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new preschool parent with the primary key. Does not add the preschool parent to the database.
	 *
	 * @param preschoolParent_id the primary key for the new preschool parent
	 * @return the new preschool parent
	 */
	public PreschoolParent create(String preschoolParent_id) {
		PreschoolParent preschoolParent = new PreschoolParentImpl();

		preschoolParent.setNew(true);
		preschoolParent.setPrimaryKey(preschoolParent_id);

		return preschoolParent;
	}

	/**
	 * Removes the preschool parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param preschoolParent_id the primary key of the preschool parent
	 * @return the preschool parent that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolParentException if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolParent remove(String preschoolParent_id)
		throws NoSuchPreschoolParentException, SystemException {
		return remove((Serializable)preschoolParent_id);
	}

	/**
	 * Removes the preschool parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the preschool parent
	 * @return the preschool parent that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolParentException if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolParent remove(Serializable primaryKey)
		throws NoSuchPreschoolParentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PreschoolParent preschoolParent = (PreschoolParent)session.get(PreschoolParentImpl.class,
					primaryKey);

			if (preschoolParent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPreschoolParentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(preschoolParent);
		}
		catch (NoSuchPreschoolParentException nsee) {
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
	protected PreschoolParent removeImpl(PreschoolParent preschoolParent)
		throws SystemException {
		preschoolParent = toUnwrappedModel(preschoolParent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, preschoolParent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(preschoolParent);

		return preschoolParent;
	}

	@Override
	public PreschoolParent updateImpl(
		com.fsoft.bn.model.PreschoolParent preschoolParent, boolean merge)
		throws SystemException {
		preschoolParent = toUnwrappedModel(preschoolParent);

		boolean isNew = preschoolParent.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, preschoolParent, merge);

			preschoolParent.setNew(false);
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

		EntityCacheUtil.putResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolParentImpl.class, preschoolParent.getPrimaryKey(),
			preschoolParent);

		return preschoolParent;
	}

	protected PreschoolParent toUnwrappedModel(PreschoolParent preschoolParent) {
		if (preschoolParent instanceof PreschoolParentImpl) {
			return preschoolParent;
		}

		PreschoolParentImpl preschoolParentImpl = new PreschoolParentImpl();

		preschoolParentImpl.setNew(preschoolParent.isNew());
		preschoolParentImpl.setPrimaryKey(preschoolParent.getPrimaryKey());

		preschoolParentImpl.setPreschoolParent_id(preschoolParent.getPreschoolParent_id());
		preschoolParentImpl.setStudent_id(preschoolParent.getStudent_id());
		preschoolParentImpl.setName(preschoolParent.getName());
		preschoolParentImpl.setDob(preschoolParent.getDob());
		preschoolParentImpl.setPlaceOfBirth(preschoolParent.getPlaceOfBirth());
		preschoolParentImpl.setNationality(preschoolParent.getNationality());
		preschoolParentImpl.setIdCardNumber(preschoolParent.getIdCardNumber());
		preschoolParentImpl.setJob(preschoolParent.getJob());
		preschoolParentImpl.setPhoneNumber(preschoolParent.getPhoneNumber());
		preschoolParentImpl.setEmail(preschoolParent.getEmail());
		preschoolParentImpl.setIsMother(preschoolParent.isIsMother());
		preschoolParentImpl.setCreated_date(preschoolParent.getCreated_date());
		preschoolParentImpl.setModified_date(preschoolParent.getModified_date());
		preschoolParentImpl.setDeleted(preschoolParent.isDeleted());

		return preschoolParentImpl;
	}

	/**
	 * Returns the preschool parent with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool parent
	 * @return the preschool parent
	 * @throws com.liferay.portal.NoSuchModelException if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolParent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool parent with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolParentException} if it could not be found.
	 *
	 * @param preschoolParent_id the primary key of the preschool parent
	 * @return the preschool parent
	 * @throws com.fsoft.bn.NoSuchPreschoolParentException if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolParent findByPrimaryKey(String preschoolParent_id)
		throws NoSuchPreschoolParentException, SystemException {
		PreschoolParent preschoolParent = fetchByPrimaryKey(preschoolParent_id);

		if (preschoolParent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					preschoolParent_id);
			}

			throw new NoSuchPreschoolParentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				preschoolParent_id);
		}

		return preschoolParent;
	}

	/**
	 * Returns the preschool parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool parent
	 * @return the preschool parent, or <code>null</code> if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolParent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param preschoolParent_id the primary key of the preschool parent
	 * @return the preschool parent, or <code>null</code> if a preschool parent with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolParent fetchByPrimaryKey(String preschoolParent_id)
		throws SystemException {
		PreschoolParent preschoolParent = (PreschoolParent)EntityCacheUtil.getResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolParentImpl.class, preschoolParent_id);

		if (preschoolParent == _nullPreschoolParent) {
			return null;
		}

		if (preschoolParent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				preschoolParent = (PreschoolParent)session.get(PreschoolParentImpl.class,
						preschoolParent_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (preschoolParent != null) {
					cacheResult(preschoolParent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PreschoolParentModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolParentImpl.class, preschoolParent_id,
						_nullPreschoolParent);
				}

				closeSession(session);
			}
		}

		return preschoolParent;
	}

	/**
	 * Returns all the preschool parents.
	 *
	 * @return the preschool parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolParent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the preschool parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool parents
	 * @param end the upper bound of the range of preschool parents (not inclusive)
	 * @return the range of preschool parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolParent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the preschool parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool parents
	 * @param end the upper bound of the range of preschool parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of preschool parents
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolParent> findAll(int start, int end,
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

		List<PreschoolParent> list = (List<PreschoolParent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRESCHOOLPARENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRESCHOOLPARENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PreschoolParent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PreschoolParent>)QueryUtil.list(q,
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
	 * Removes all the preschool parents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PreschoolParent preschoolParent : findAll()) {
			remove(preschoolParent);
		}
	}

	/**
	 * Returns the number of preschool parents.
	 *
	 * @return the number of preschool parents
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRESCHOOLPARENT);

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
	 * Initializes the preschool parent persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PreschoolParent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PreschoolParent>> listenersList = new ArrayList<ModelListener<PreschoolParent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PreschoolParent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PreschoolParentImpl.class.getName());
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
	private static final String _SQL_SELECT_PRESCHOOLPARENT = "SELECT preschoolParent FROM PreschoolParent preschoolParent";
	private static final String _SQL_COUNT_PRESCHOOLPARENT = "SELECT COUNT(preschoolParent) FROM PreschoolParent preschoolParent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "preschoolParent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PreschoolParent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PreschoolParentPersistenceImpl.class);
	private static PreschoolParent _nullPreschoolParent = new PreschoolParentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PreschoolParent> toCacheModel() {
				return _nullPreschoolParentCacheModel;
			}
		};

	private static CacheModel<PreschoolParent> _nullPreschoolParentCacheModel = new CacheModel<PreschoolParent>() {
			public PreschoolParent toEntityModel() {
				return _nullPreschoolParent;
			}
		};
}