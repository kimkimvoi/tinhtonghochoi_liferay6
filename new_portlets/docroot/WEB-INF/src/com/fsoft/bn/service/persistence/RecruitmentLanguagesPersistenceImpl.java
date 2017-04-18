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

import com.fsoft.bn.NoSuchRecruitmentLanguagesException;
import com.fsoft.bn.model.RecruitmentLanguages;
import com.fsoft.bn.model.impl.RecruitmentLanguagesImpl;
import com.fsoft.bn.model.impl.RecruitmentLanguagesModelImpl;

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
 * The persistence implementation for the recruitment languages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentLanguagesPersistence
 * @see RecruitmentLanguagesUtil
 * @generated
 */
public class RecruitmentLanguagesPersistenceImpl extends BasePersistenceImpl<RecruitmentLanguages>
	implements RecruitmentLanguagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitmentLanguagesUtil} to access the recruitment languages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitmentLanguagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentLanguagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentLanguagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the recruitment languages in the entity cache if it is enabled.
	 *
	 * @param recruitmentLanguages the recruitment languages
	 */
	public void cacheResult(RecruitmentLanguages recruitmentLanguages) {
		EntityCacheUtil.putResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesImpl.class,
			recruitmentLanguages.getPrimaryKey(), recruitmentLanguages);

		recruitmentLanguages.resetOriginalValues();
	}

	/**
	 * Caches the recruitment languageses in the entity cache if it is enabled.
	 *
	 * @param recruitmentLanguageses the recruitment languageses
	 */
	public void cacheResult(List<RecruitmentLanguages> recruitmentLanguageses) {
		for (RecruitmentLanguages recruitmentLanguages : recruitmentLanguageses) {
			if (EntityCacheUtil.getResult(
						RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentLanguagesImpl.class,
						recruitmentLanguages.getPrimaryKey()) == null) {
				cacheResult(recruitmentLanguages);
			}
			else {
				recruitmentLanguages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruitment languageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecruitmentLanguagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecruitmentLanguagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruitment languages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RecruitmentLanguages recruitmentLanguages) {
		EntityCacheUtil.removeResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesImpl.class, recruitmentLanguages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RecruitmentLanguages> recruitmentLanguageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecruitmentLanguages recruitmentLanguages : recruitmentLanguageses) {
			EntityCacheUtil.removeResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentLanguagesImpl.class,
				recruitmentLanguages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recruitment languages with the primary key. Does not add the recruitment languages to the database.
	 *
	 * @param recruitment_languages_id the primary key for the new recruitment languages
	 * @return the new recruitment languages
	 */
	public RecruitmentLanguages create(String recruitment_languages_id) {
		RecruitmentLanguages recruitmentLanguages = new RecruitmentLanguagesImpl();

		recruitmentLanguages.setNew(true);
		recruitmentLanguages.setPrimaryKey(recruitment_languages_id);

		return recruitmentLanguages;
	}

	/**
	 * Removes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_languages_id the primary key of the recruitment languages
	 * @return the recruitment languages that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentLanguagesException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentLanguages remove(String recruitment_languages_id)
		throws NoSuchRecruitmentLanguagesException, SystemException {
		return remove((Serializable)recruitment_languages_id);
	}

	/**
	 * Removes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruitment languages
	 * @return the recruitment languages that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentLanguagesException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentLanguages remove(Serializable primaryKey)
		throws NoSuchRecruitmentLanguagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RecruitmentLanguages recruitmentLanguages = (RecruitmentLanguages)session.get(RecruitmentLanguagesImpl.class,
					primaryKey);

			if (recruitmentLanguages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitmentLanguagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitmentLanguages);
		}
		catch (NoSuchRecruitmentLanguagesException nsee) {
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
	protected RecruitmentLanguages removeImpl(
		RecruitmentLanguages recruitmentLanguages) throws SystemException {
		recruitmentLanguages = toUnwrappedModel(recruitmentLanguages);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, recruitmentLanguages);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(recruitmentLanguages);

		return recruitmentLanguages;
	}

	@Override
	public RecruitmentLanguages updateImpl(
		com.fsoft.bn.model.RecruitmentLanguages recruitmentLanguages,
		boolean merge) throws SystemException {
		recruitmentLanguages = toUnwrappedModel(recruitmentLanguages);

		boolean isNew = recruitmentLanguages.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, recruitmentLanguages, merge);

			recruitmentLanguages.setNew(false);
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

		EntityCacheUtil.putResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentLanguagesImpl.class,
			recruitmentLanguages.getPrimaryKey(), recruitmentLanguages);

		return recruitmentLanguages;
	}

	protected RecruitmentLanguages toUnwrappedModel(
		RecruitmentLanguages recruitmentLanguages) {
		if (recruitmentLanguages instanceof RecruitmentLanguagesImpl) {
			return recruitmentLanguages;
		}

		RecruitmentLanguagesImpl recruitmentLanguagesImpl = new RecruitmentLanguagesImpl();

		recruitmentLanguagesImpl.setNew(recruitmentLanguages.isNew());
		recruitmentLanguagesImpl.setPrimaryKey(recruitmentLanguages.getPrimaryKey());

		recruitmentLanguagesImpl.setRecruitment_languages_id(recruitmentLanguages.getRecruitment_languages_id());
		recruitmentLanguagesImpl.setRecruitment_id(recruitmentLanguages.getRecruitment_id());
		recruitmentLanguagesImpl.setLanguage(recruitmentLanguages.getLanguage());
		recruitmentLanguagesImpl.setLevel(recruitmentLanguages.getLevel());
		recruitmentLanguagesImpl.setCertificate(recruitmentLanguages.getCertificate());
		recruitmentLanguagesImpl.setCreated_date(recruitmentLanguages.getCreated_date());
		recruitmentLanguagesImpl.setModified_date(recruitmentLanguages.getModified_date());
		recruitmentLanguagesImpl.setDeleted(recruitmentLanguages.isDeleted());

		return recruitmentLanguagesImpl;
	}

	/**
	 * Returns the recruitment languages with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment languages
	 * @return the recruitment languages
	 * @throws com.liferay.portal.NoSuchModelException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentLanguages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment languages with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentLanguagesException} if it could not be found.
	 *
	 * @param recruitment_languages_id the primary key of the recruitment languages
	 * @return the recruitment languages
	 * @throws com.fsoft.bn.NoSuchRecruitmentLanguagesException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentLanguages findByPrimaryKey(
		String recruitment_languages_id)
		throws NoSuchRecruitmentLanguagesException, SystemException {
		RecruitmentLanguages recruitmentLanguages = fetchByPrimaryKey(recruitment_languages_id);

		if (recruitmentLanguages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					recruitment_languages_id);
			}

			throw new NoSuchRecruitmentLanguagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recruitment_languages_id);
		}

		return recruitmentLanguages;
	}

	/**
	 * Returns the recruitment languages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment languages
	 * @return the recruitment languages, or <code>null</code> if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentLanguages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment languages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitment_languages_id the primary key of the recruitment languages
	 * @return the recruitment languages, or <code>null</code> if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentLanguages fetchByPrimaryKey(
		String recruitment_languages_id) throws SystemException {
		RecruitmentLanguages recruitmentLanguages = (RecruitmentLanguages)EntityCacheUtil.getResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentLanguagesImpl.class, recruitment_languages_id);

		if (recruitmentLanguages == _nullRecruitmentLanguages) {
			return null;
		}

		if (recruitmentLanguages == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				recruitmentLanguages = (RecruitmentLanguages)session.get(RecruitmentLanguagesImpl.class,
						recruitment_languages_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (recruitmentLanguages != null) {
					cacheResult(recruitmentLanguages);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RecruitmentLanguagesModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentLanguagesImpl.class,
						recruitment_languages_id, _nullRecruitmentLanguages);
				}

				closeSession(session);
			}
		}

		return recruitmentLanguages;
	}

	/**
	 * Returns all the recruitment languageses.
	 *
	 * @return the recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentLanguages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruitment languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment languageses
	 * @param end the upper bound of the range of recruitment languageses (not inclusive)
	 * @return the range of recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentLanguages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruitment languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment languageses
	 * @param end the upper bound of the range of recruitment languageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentLanguages> findAll(int start, int end,
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

		List<RecruitmentLanguages> list = (List<RecruitmentLanguages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECRUITMENTLANGUAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITMENTLANGUAGES;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RecruitmentLanguages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RecruitmentLanguages>)QueryUtil.list(q,
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
	 * Removes all the recruitment languageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RecruitmentLanguages recruitmentLanguages : findAll()) {
			remove(recruitmentLanguages);
		}
	}

	/**
	 * Returns the number of recruitment languageses.
	 *
	 * @return the number of recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITMENTLANGUAGES);

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
	 * Initializes the recruitment languages persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.RecruitmentLanguages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RecruitmentLanguages>> listenersList = new ArrayList<ModelListener<RecruitmentLanguages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RecruitmentLanguages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecruitmentLanguagesImpl.class.getName());
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
	private static final String _SQL_SELECT_RECRUITMENTLANGUAGES = "SELECT recruitmentLanguages FROM RecruitmentLanguages recruitmentLanguages";
	private static final String _SQL_COUNT_RECRUITMENTLANGUAGES = "SELECT COUNT(recruitmentLanguages) FROM RecruitmentLanguages recruitmentLanguages";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitmentLanguages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecruitmentLanguages exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecruitmentLanguagesPersistenceImpl.class);
	private static RecruitmentLanguages _nullRecruitmentLanguages = new RecruitmentLanguagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RecruitmentLanguages> toCacheModel() {
				return _nullRecruitmentLanguagesCacheModel;
			}
		};

	private static CacheModel<RecruitmentLanguages> _nullRecruitmentLanguagesCacheModel =
		new CacheModel<RecruitmentLanguages>() {
			public RecruitmentLanguages toEntityModel() {
				return _nullRecruitmentLanguages;
			}
		};
}