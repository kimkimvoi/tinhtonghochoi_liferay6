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

import com.fsoft.bn.NoSuchPrimarySchoolStudentException;
import com.fsoft.bn.model.PrimarySchoolStudent;
import com.fsoft.bn.model.impl.PrimarySchoolStudentImpl;
import com.fsoft.bn.model.impl.PrimarySchoolStudentModelImpl;

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
 * The persistence implementation for the primary school student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolStudentPersistence
 * @see PrimarySchoolStudentUtil
 * @generated
 */
public class PrimarySchoolStudentPersistenceImpl extends BasePersistenceImpl<PrimarySchoolStudent>
	implements PrimarySchoolStudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrimarySchoolStudentUtil} to access the primary school student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrimarySchoolStudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolStudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolStudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the primary school student in the entity cache if it is enabled.
	 *
	 * @param primarySchoolStudent the primary school student
	 */
	public void cacheResult(PrimarySchoolStudent primarySchoolStudent) {
		EntityCacheUtil.putResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentImpl.class,
			primarySchoolStudent.getPrimaryKey(), primarySchoolStudent);

		primarySchoolStudent.resetOriginalValues();
	}

	/**
	 * Caches the primary school students in the entity cache if it is enabled.
	 *
	 * @param primarySchoolStudents the primary school students
	 */
	public void cacheResult(List<PrimarySchoolStudent> primarySchoolStudents) {
		for (PrimarySchoolStudent primarySchoolStudent : primarySchoolStudents) {
			if (EntityCacheUtil.getResult(
						PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolStudentImpl.class,
						primarySchoolStudent.getPrimaryKey()) == null) {
				cacheResult(primarySchoolStudent);
			}
			else {
				primarySchoolStudent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all primary school students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrimarySchoolStudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrimarySchoolStudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the primary school student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrimarySchoolStudent primarySchoolStudent) {
		EntityCacheUtil.removeResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentImpl.class, primarySchoolStudent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PrimarySchoolStudent> primarySchoolStudents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrimarySchoolStudent primarySchoolStudent : primarySchoolStudents) {
			EntityCacheUtil.removeResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolStudentImpl.class,
				primarySchoolStudent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new primary school student with the primary key. Does not add the primary school student to the database.
	 *
	 * @param primaryStudent_id the primary key for the new primary school student
	 * @return the new primary school student
	 */
	public PrimarySchoolStudent create(String primaryStudent_id) {
		PrimarySchoolStudent primarySchoolStudent = new PrimarySchoolStudentImpl();

		primarySchoolStudent.setNew(true);
		primarySchoolStudent.setPrimaryKey(primaryStudent_id);

		return primarySchoolStudent;
	}

	/**
	 * Removes the primary school student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryStudent_id the primary key of the primary school student
	 * @return the primary school student that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolStudent remove(String primaryStudent_id)
		throws NoSuchPrimarySchoolStudentException, SystemException {
		return remove((Serializable)primaryStudent_id);
	}

	/**
	 * Removes the primary school student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the primary school student
	 * @return the primary school student that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolStudent remove(Serializable primaryKey)
		throws NoSuchPrimarySchoolStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrimarySchoolStudent primarySchoolStudent = (PrimarySchoolStudent)session.get(PrimarySchoolStudentImpl.class,
					primaryKey);

			if (primarySchoolStudent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrimarySchoolStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(primarySchoolStudent);
		}
		catch (NoSuchPrimarySchoolStudentException nsee) {
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
	protected PrimarySchoolStudent removeImpl(
		PrimarySchoolStudent primarySchoolStudent) throws SystemException {
		primarySchoolStudent = toUnwrappedModel(primarySchoolStudent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, primarySchoolStudent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(primarySchoolStudent);

		return primarySchoolStudent;
	}

	@Override
	public PrimarySchoolStudent updateImpl(
		com.fsoft.bn.model.PrimarySchoolStudent primarySchoolStudent,
		boolean merge) throws SystemException {
		primarySchoolStudent = toUnwrappedModel(primarySchoolStudent);

		boolean isNew = primarySchoolStudent.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, primarySchoolStudent, merge);

			primarySchoolStudent.setNew(false);
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

		EntityCacheUtil.putResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolStudentImpl.class,
			primarySchoolStudent.getPrimaryKey(), primarySchoolStudent);

		return primarySchoolStudent;
	}

	protected PrimarySchoolStudent toUnwrappedModel(
		PrimarySchoolStudent primarySchoolStudent) {
		if (primarySchoolStudent instanceof PrimarySchoolStudentImpl) {
			return primarySchoolStudent;
		}

		PrimarySchoolStudentImpl primarySchoolStudentImpl = new PrimarySchoolStudentImpl();

		primarySchoolStudentImpl.setNew(primarySchoolStudent.isNew());
		primarySchoolStudentImpl.setPrimaryKey(primarySchoolStudent.getPrimaryKey());

		primarySchoolStudentImpl.setPrimaryStudent_id(primarySchoolStudent.getPrimaryStudent_id());
		primarySchoolStudentImpl.setStudent_name(primarySchoolStudent.getStudent_name());
		primarySchoolStudentImpl.setStudent_sex(primarySchoolStudent.getStudent_sex());
		primarySchoolStudentImpl.setStudent_dob(primarySchoolStudent.getStudent_dob());
		primarySchoolStudentImpl.setStudent_placeOfBirth(primarySchoolStudent.getStudent_placeOfBirth());
		primarySchoolStudentImpl.setStudent_nationality(primarySchoolStudent.getStudent_nationality());
		primarySchoolStudentImpl.setStudent_address(primarySchoolStudent.getStudent_address());
		primarySchoolStudentImpl.setStudent_contactName(primarySchoolStudent.getStudent_contactName());
		primarySchoolStudentImpl.setStudent_contactRelationship(primarySchoolStudent.getStudent_contactRelationship());
		primarySchoolStudentImpl.setStudent_contactPhoneNumber(primarySchoolStudent.getStudent_contactPhoneNumber());
		primarySchoolStudentImpl.setStudent_contactEmail(primarySchoolStudent.getStudent_contactEmail());
		primarySchoolStudentImpl.setStudent_schoolName(primarySchoolStudent.getStudent_schoolName());
		primarySchoolStudentImpl.setStudent_schoolYear(primarySchoolStudent.getStudent_schoolYear());
		primarySchoolStudentImpl.setStudent_academicLevel(primarySchoolStudent.getStudent_academicLevel());
		primarySchoolStudentImpl.setStudent_studiedLanguage(primarySchoolStudent.getStudent_studiedLanguage());
		primarySchoolStudentImpl.setStudent_languageCenter(primarySchoolStudent.getStudent_languageCenter());
		primarySchoolStudentImpl.setStudent_prizes(primarySchoolStudent.getStudent_prizes());
		primarySchoolStudentImpl.setStudent_skippedGrade(primarySchoolStudent.getStudent_skippedGrade());
		primarySchoolStudentImpl.setStudent_penalty(primarySchoolStudent.getStudent_penalty());
		primarySchoolStudentImpl.setStudent_interests(primarySchoolStudent.getStudent_interests());
		primarySchoolStudentImpl.setStudent_note(primarySchoolStudent.getStudent_note());
		primarySchoolStudentImpl.setStudent_registrationClass(primarySchoolStudent.getStudent_registrationClass());
		primarySchoolStudentImpl.setStudent_expectedEnrollTime(primarySchoolStudent.getStudent_expectedEnrollTime());
		primarySchoolStudentImpl.setStudent_userCar(primarySchoolStudent.getStudent_userCar());
		primarySchoolStudentImpl.setStudent_theLightClub(primarySchoolStudent.getStudent_theLightClub());
		primarySchoolStudentImpl.setStudent_oversea(primarySchoolStudent.getStudent_oversea());
		primarySchoolStudentImpl.setStudent_howToKnowBM(primarySchoolStudent.getStudent_howToKnowBM());
		primarySchoolStudentImpl.setStudent_whoIntroduce(primarySchoolStudent.getStudent_whoIntroduce());
		primarySchoolStudentImpl.setStudent_anyConfuse(primarySchoolStudent.getStudent_anyConfuse());
		primarySchoolStudentImpl.setStatus(primarySchoolStudent.getStatus());
		primarySchoolStudentImpl.setCreated_date(primarySchoolStudent.getCreated_date());
		primarySchoolStudentImpl.setModified_date(primarySchoolStudent.getModified_date());
		primarySchoolStudentImpl.setDeleted(primarySchoolStudent.isDeleted());

		return primarySchoolStudentImpl;
	}

	/**
	 * Returns the primary school student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school student
	 * @return the primary school student
	 * @throws com.liferay.portal.NoSuchModelException if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolStudent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school student with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolStudentException} if it could not be found.
	 *
	 * @param primaryStudent_id the primary key of the primary school student
	 * @return the primary school student
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolStudentException if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolStudent findByPrimaryKey(String primaryStudent_id)
		throws NoSuchPrimarySchoolStudentException, SystemException {
		PrimarySchoolStudent primarySchoolStudent = fetchByPrimaryKey(primaryStudent_id);

		if (primarySchoolStudent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryStudent_id);
			}

			throw new NoSuchPrimarySchoolStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryStudent_id);
		}

		return primarySchoolStudent;
	}

	/**
	 * Returns the primary school student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school student
	 * @return the primary school student, or <code>null</code> if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolStudent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryStudent_id the primary key of the primary school student
	 * @return the primary school student, or <code>null</code> if a primary school student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolStudent fetchByPrimaryKey(String primaryStudent_id)
		throws SystemException {
		PrimarySchoolStudent primarySchoolStudent = (PrimarySchoolStudent)EntityCacheUtil.getResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolStudentImpl.class, primaryStudent_id);

		if (primarySchoolStudent == _nullPrimarySchoolStudent) {
			return null;
		}

		if (primarySchoolStudent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				primarySchoolStudent = (PrimarySchoolStudent)session.get(PrimarySchoolStudentImpl.class,
						primaryStudent_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (primarySchoolStudent != null) {
					cacheResult(primarySchoolStudent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PrimarySchoolStudentModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolStudentImpl.class, primaryStudent_id,
						_nullPrimarySchoolStudent);
				}

				closeSession(session);
			}
		}

		return primarySchoolStudent;
	}

	/**
	 * Returns all the primary school students.
	 *
	 * @return the primary school students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolStudent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary school students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school students
	 * @param end the upper bound of the range of primary school students (not inclusive)
	 * @return the range of primary school students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolStudent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary school students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school students
	 * @param end the upper bound of the range of primary school students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of primary school students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolStudent> findAll(int start, int end,
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

		List<PrimarySchoolStudent> list = (List<PrimarySchoolStudent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRIMARYSCHOOLSTUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRIMARYSCHOOLSTUDENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PrimarySchoolStudent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PrimarySchoolStudent>)QueryUtil.list(q,
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
	 * Removes all the primary school students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PrimarySchoolStudent primarySchoolStudent : findAll()) {
			remove(primarySchoolStudent);
		}
	}

	/**
	 * Returns the number of primary school students.
	 *
	 * @return the number of primary school students
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRIMARYSCHOOLSTUDENT);

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
	 * Initializes the primary school student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PrimarySchoolStudent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrimarySchoolStudent>> listenersList = new ArrayList<ModelListener<PrimarySchoolStudent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrimarySchoolStudent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrimarySchoolStudentImpl.class.getName());
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
	private static final String _SQL_SELECT_PRIMARYSCHOOLSTUDENT = "SELECT primarySchoolStudent FROM PrimarySchoolStudent primarySchoolStudent";
	private static final String _SQL_COUNT_PRIMARYSCHOOLSTUDENT = "SELECT COUNT(primarySchoolStudent) FROM PrimarySchoolStudent primarySchoolStudent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "primarySchoolStudent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrimarySchoolStudent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrimarySchoolStudentPersistenceImpl.class);
	private static PrimarySchoolStudent _nullPrimarySchoolStudent = new PrimarySchoolStudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrimarySchoolStudent> toCacheModel() {
				return _nullPrimarySchoolStudentCacheModel;
			}
		};

	private static CacheModel<PrimarySchoolStudent> _nullPrimarySchoolStudentCacheModel =
		new CacheModel<PrimarySchoolStudent>() {
			public PrimarySchoolStudent toEntityModel() {
				return _nullPrimarySchoolStudent;
			}
		};
}