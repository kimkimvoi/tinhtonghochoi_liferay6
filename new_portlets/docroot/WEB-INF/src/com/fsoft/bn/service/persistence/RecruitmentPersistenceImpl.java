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

import com.fsoft.bn.NoSuchRecruitmentException;
import com.fsoft.bn.model.Recruitment;
import com.fsoft.bn.model.impl.RecruitmentImpl;
import com.fsoft.bn.model.impl.RecruitmentModelImpl;

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
 * The persistence implementation for the recruitment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentPersistence
 * @see RecruitmentUtil
 * @generated
 */
public class RecruitmentPersistenceImpl extends BasePersistenceImpl<Recruitment>
	implements RecruitmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitmentUtil} to access the recruitment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentModelImpl.FINDER_CACHE_ENABLED, RecruitmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentModelImpl.FINDER_CACHE_ENABLED, RecruitmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the recruitment in the entity cache if it is enabled.
	 *
	 * @param recruitment the recruitment
	 */
	public void cacheResult(Recruitment recruitment) {
		EntityCacheUtil.putResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentImpl.class, recruitment.getPrimaryKey(), recruitment);

		recruitment.resetOriginalValues();
	}

	/**
	 * Caches the recruitments in the entity cache if it is enabled.
	 *
	 * @param recruitments the recruitments
	 */
	public void cacheResult(List<Recruitment> recruitments) {
		for (Recruitment recruitment : recruitments) {
			if (EntityCacheUtil.getResult(
						RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentImpl.class, recruitment.getPrimaryKey()) == null) {
				cacheResult(recruitment);
			}
			else {
				recruitment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruitments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecruitmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecruitmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruitment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Recruitment recruitment) {
		EntityCacheUtil.removeResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentImpl.class, recruitment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Recruitment> recruitments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Recruitment recruitment : recruitments) {
			EntityCacheUtil.removeResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentImpl.class, recruitment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recruitment with the primary key. Does not add the recruitment to the database.
	 *
	 * @param recruitment_id the primary key for the new recruitment
	 * @return the new recruitment
	 */
	public Recruitment create(String recruitment_id) {
		Recruitment recruitment = new RecruitmentImpl();

		recruitment.setNew(true);
		recruitment.setPrimaryKey(recruitment_id);

		return recruitment;
	}

	/**
	 * Removes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_id the primary key of the recruitment
	 * @return the recruitment that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Recruitment remove(String recruitment_id)
		throws NoSuchRecruitmentException, SystemException {
		return remove((Serializable)recruitment_id);
	}

	/**
	 * Removes the recruitment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruitment
	 * @return the recruitment that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recruitment remove(Serializable primaryKey)
		throws NoSuchRecruitmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Recruitment recruitment = (Recruitment)session.get(RecruitmentImpl.class,
					primaryKey);

			if (recruitment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitment);
		}
		catch (NoSuchRecruitmentException nsee) {
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
	protected Recruitment removeImpl(Recruitment recruitment)
		throws SystemException {
		recruitment = toUnwrappedModel(recruitment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, recruitment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(recruitment);

		return recruitment;
	}

	@Override
	public Recruitment updateImpl(com.fsoft.bn.model.Recruitment recruitment,
		boolean merge) throws SystemException {
		recruitment = toUnwrappedModel(recruitment);

		boolean isNew = recruitment.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, recruitment, merge);

			recruitment.setNew(false);
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

		EntityCacheUtil.putResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentImpl.class, recruitment.getPrimaryKey(), recruitment);

		return recruitment;
	}

	protected Recruitment toUnwrappedModel(Recruitment recruitment) {
		if (recruitment instanceof RecruitmentImpl) {
			return recruitment;
		}

		RecruitmentImpl recruitmentImpl = new RecruitmentImpl();

		recruitmentImpl.setNew(recruitment.isNew());
		recruitmentImpl.setPrimaryKey(recruitment.getPrimaryKey());

		recruitmentImpl.setRecruitment_id(recruitment.getRecruitment_id());
		recruitmentImpl.setCandidate_name(recruitment.getCandidate_name());
		recruitmentImpl.setCandidate_sex(recruitment.getCandidate_sex());
		recruitmentImpl.setCandidate_dob(recruitment.getCandidate_dob());
		recruitmentImpl.setCandidate_placeOfBirth(recruitment.getCandidate_placeOfBirth());
		recruitmentImpl.setCandidate_nationality(recruitment.getCandidate_nationality());
		recruitmentImpl.setCandidate_race(recruitment.getCandidate_race());
		recruitmentImpl.setCandidate_religion(recruitment.getCandidate_religion());
		recruitmentImpl.setCandidate_IdCardNumber(recruitment.getCandidate_IdCardNumber());
		recruitmentImpl.setCandidate_placeOfIssue(recruitment.getCandidate_placeOfIssue());
		recruitmentImpl.setCandidate_permanentPlace(recruitment.getCandidate_permanentPlace());
		recruitmentImpl.setCandidate_temporaryPlace(recruitment.getCandidate_temporaryPlace());
		recruitmentImpl.setCandidate_phoneNumber(recruitment.getCandidate_phoneNumber());
		recruitmentImpl.setCandidate_email(recruitment.getCandidate_email());
		recruitmentImpl.setCandidate_position(recruitment.getCandidate_position());
		recruitmentImpl.setCandidate_canStartDate(recruitment.getCandidate_canStartDate());
		recruitmentImpl.setCandidate_currentSalary(recruitment.getCandidate_currentSalary());
		recruitmentImpl.setCandidate_expectedSalary(recruitment.getCandidate_expectedSalary());
		recruitmentImpl.setCandidate_howToKnowBM(recruitment.getCandidate_howToKnowBM());
		recruitmentImpl.setCandidate_whoIntroduce(recruitment.getCandidate_whoIntroduce());
		recruitmentImpl.setCandidate_anyConfuse(recruitment.getCandidate_anyConfuse());
		recruitmentImpl.setStatus(recruitment.getStatus());
		recruitmentImpl.setCreated_date(recruitment.getCreated_date());
		recruitmentImpl.setModified_date(recruitment.getModified_date());
		recruitmentImpl.setDeleted(recruitment.isDeleted());

		return recruitmentImpl;
	}

	/**
	 * Returns the recruitment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment
	 * @return the recruitment
	 * @throws com.liferay.portal.NoSuchModelException if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recruitment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentException} if it could not be found.
	 *
	 * @param recruitment_id the primary key of the recruitment
	 * @return the recruitment
	 * @throws com.fsoft.bn.NoSuchRecruitmentException if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Recruitment findByPrimaryKey(String recruitment_id)
		throws NoSuchRecruitmentException, SystemException {
		Recruitment recruitment = fetchByPrimaryKey(recruitment_id);

		if (recruitment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + recruitment_id);
			}

			throw new NoSuchRecruitmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recruitment_id);
		}

		return recruitment;
	}

	/**
	 * Returns the recruitment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment
	 * @return the recruitment, or <code>null</code> if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Recruitment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitment_id the primary key of the recruitment
	 * @return the recruitment, or <code>null</code> if a recruitment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Recruitment fetchByPrimaryKey(String recruitment_id)
		throws SystemException {
		Recruitment recruitment = (Recruitment)EntityCacheUtil.getResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentImpl.class, recruitment_id);

		if (recruitment == _nullRecruitment) {
			return null;
		}

		if (recruitment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				recruitment = (Recruitment)session.get(RecruitmentImpl.class,
						recruitment_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (recruitment != null) {
					cacheResult(recruitment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RecruitmentModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentImpl.class, recruitment_id, _nullRecruitment);
				}

				closeSession(session);
			}
		}

		return recruitment;
	}

	/**
	 * Returns all the recruitments.
	 *
	 * @return the recruitments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Recruitment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruitments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitments
	 * @param end the upper bound of the range of recruitments (not inclusive)
	 * @return the range of recruitments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Recruitment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruitments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitments
	 * @param end the upper bound of the range of recruitments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruitments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Recruitment> findAll(int start, int end,
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

		List<Recruitment> list = (List<Recruitment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECRUITMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITMENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Recruitment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Recruitment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the recruitments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Recruitment recruitment : findAll()) {
			remove(recruitment);
		}
	}

	/**
	 * Returns the number of recruitments.
	 *
	 * @return the number of recruitments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITMENT);

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
	 * Initializes the recruitment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Recruitment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Recruitment>> listenersList = new ArrayList<ModelListener<Recruitment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Recruitment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecruitmentImpl.class.getName());
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
	private static final String _SQL_SELECT_RECRUITMENT = "SELECT recruitment FROM Recruitment recruitment";
	private static final String _SQL_COUNT_RECRUITMENT = "SELECT COUNT(recruitment) FROM Recruitment recruitment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Recruitment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecruitmentPersistenceImpl.class);
	private static Recruitment _nullRecruitment = new RecruitmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Recruitment> toCacheModel() {
				return _nullRecruitmentCacheModel;
			}
		};

	private static CacheModel<Recruitment> _nullRecruitmentCacheModel = new CacheModel<Recruitment>() {
			public Recruitment toEntityModel() {
				return _nullRecruitment;
			}
		};
}