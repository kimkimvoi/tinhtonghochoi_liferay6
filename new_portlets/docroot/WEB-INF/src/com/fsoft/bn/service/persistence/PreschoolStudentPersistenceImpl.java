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

import com.fsoft.bn.NoSuchPreschoolStudentException;
import com.fsoft.bn.model.PreschoolStudent;
import com.fsoft.bn.model.impl.PreschoolStudentImpl;
import com.fsoft.bn.model.impl.PreschoolStudentModelImpl;

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
 * The persistence implementation for the preschool student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolStudentPersistence
 * @see PreschoolStudentUtil
 * @generated
 */
public class PreschoolStudentPersistenceImpl extends BasePersistenceImpl<PreschoolStudent>
	implements PreschoolStudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PreschoolStudentUtil} to access the preschool student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PreschoolStudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentModelImpl.FINDER_CACHE_ENABLED,
			PreschoolStudentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentModelImpl.FINDER_CACHE_ENABLED,
			PreschoolStudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the preschool student in the entity cache if it is enabled.
	 *
	 * @param preschoolStudent the preschool student
	 */
	public void cacheResult(PreschoolStudent preschoolStudent) {
		EntityCacheUtil.putResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentImpl.class, preschoolStudent.getPrimaryKey(),
			preschoolStudent);

		preschoolStudent.resetOriginalValues();
	}

	/**
	 * Caches the preschool students in the entity cache if it is enabled.
	 *
	 * @param preschoolStudents the preschool students
	 */
	public void cacheResult(List<PreschoolStudent> preschoolStudents) {
		for (PreschoolStudent preschoolStudent : preschoolStudents) {
			if (EntityCacheUtil.getResult(
						PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolStudentImpl.class,
						preschoolStudent.getPrimaryKey()) == null) {
				cacheResult(preschoolStudent);
			}
			else {
				preschoolStudent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all preschool students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PreschoolStudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PreschoolStudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the preschool student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PreschoolStudent preschoolStudent) {
		EntityCacheUtil.removeResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentImpl.class, preschoolStudent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PreschoolStudent> preschoolStudents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PreschoolStudent preschoolStudent : preschoolStudents) {
			EntityCacheUtil.removeResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolStudentImpl.class, preschoolStudent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new preschool student with the primary key. Does not add the preschool student to the database.
	 *
	 * @param student_id the primary key for the new preschool student
	 * @return the new preschool student
	 */
	public PreschoolStudent create(String student_id) {
		PreschoolStudent preschoolStudent = new PreschoolStudentImpl();

		preschoolStudent.setNew(true);
		preschoolStudent.setPrimaryKey(student_id);

		return preschoolStudent;
	}

	/**
	 * Removes the preschool student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param student_id the primary key of the preschool student
	 * @return the preschool student that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolStudent remove(String student_id)
		throws NoSuchPreschoolStudentException, SystemException {
		return remove((Serializable)student_id);
	}

	/**
	 * Removes the preschool student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the preschool student
	 * @return the preschool student that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolStudent remove(Serializable primaryKey)
		throws NoSuchPreschoolStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PreschoolStudent preschoolStudent = (PreschoolStudent)session.get(PreschoolStudentImpl.class,
					primaryKey);

			if (preschoolStudent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPreschoolStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(preschoolStudent);
		}
		catch (NoSuchPreschoolStudentException nsee) {
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
	protected PreschoolStudent removeImpl(PreschoolStudent preschoolStudent)
		throws SystemException {
		preschoolStudent = toUnwrappedModel(preschoolStudent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, preschoolStudent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(preschoolStudent);

		return preschoolStudent;
	}

	@Override
	public PreschoolStudent updateImpl(
		com.fsoft.bn.model.PreschoolStudent preschoolStudent, boolean merge)
		throws SystemException {
		preschoolStudent = toUnwrappedModel(preschoolStudent);

		boolean isNew = preschoolStudent.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, preschoolStudent, merge);

			preschoolStudent.setNew(false);
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

		EntityCacheUtil.putResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolStudentImpl.class, preschoolStudent.getPrimaryKey(),
			preschoolStudent);

		return preschoolStudent;
	}

	protected PreschoolStudent toUnwrappedModel(
		PreschoolStudent preschoolStudent) {
		if (preschoolStudent instanceof PreschoolStudentImpl) {
			return preschoolStudent;
		}

		PreschoolStudentImpl preschoolStudentImpl = new PreschoolStudentImpl();

		preschoolStudentImpl.setNew(preschoolStudent.isNew());
		preschoolStudentImpl.setPrimaryKey(preschoolStudent.getPrimaryKey());

		preschoolStudentImpl.setStudent_id(preschoolStudent.getStudent_id());
		preschoolStudentImpl.setStudent_name(preschoolStudent.getStudent_name());
		preschoolStudentImpl.setStudent_sex(preschoolStudent.getStudent_sex());
		preschoolStudentImpl.setStudent_dob(preschoolStudent.getStudent_dob());
		preschoolStudentImpl.setStudent_placeOfBirth(preschoolStudent.getStudent_placeOfBirth());
		preschoolStudentImpl.setStudent_nationality(preschoolStudent.getStudent_nationality());
		preschoolStudentImpl.setStudent_phoneNumber(preschoolStudent.getStudent_phoneNumber());
		preschoolStudentImpl.setStudent_address(preschoolStudent.getStudent_address());
		preschoolStudentImpl.setStudent_heatlhStatus(preschoolStudent.getStudent_heatlhStatus());
		preschoolStudentImpl.setStudent_height(preschoolStudent.getStudent_height());
		preschoolStudentImpl.setStudent_weight(preschoolStudent.getStudent_weight());
		preschoolStudentImpl.setStudent_contactName(preschoolStudent.getStudent_contactName());
		preschoolStudentImpl.setStudent_contactRelationship(preschoolStudent.getStudent_contactRelationship());
		preschoolStudentImpl.setStudent_contactPhoneNumber(preschoolStudent.getStudent_contactPhoneNumber());
		preschoolStudentImpl.setStudent_contactEmail(preschoolStudent.getStudent_contactEmail());
		preschoolStudentImpl.setStudent_howToKnowBM(preschoolStudent.getStudent_howToKnowBM());
		preschoolStudentImpl.setStudent_whoIntroduce(preschoolStudent.getStudent_whoIntroduce());
		preschoolStudentImpl.setStudent_anyConfuse(preschoolStudent.getStudent_anyConfuse());
		preschoolStudentImpl.setStatus(preschoolStudent.getStatus());
		preschoolStudentImpl.setCreated_date(preschoolStudent.getCreated_date());
		preschoolStudentImpl.setModified_date(preschoolStudent.getModified_date());
		preschoolStudentImpl.setDeleted(preschoolStudent.isDeleted());

		return preschoolStudentImpl;
	}

	/**
	 * Returns the preschool student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool student
	 * @return the preschool student
	 * @throws com.liferay.portal.NoSuchModelException if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolStudent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool student with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolStudentException} if it could not be found.
	 *
	 * @param student_id the primary key of the preschool student
	 * @return the preschool student
	 * @throws com.fsoft.bn.NoSuchPreschoolStudentException if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolStudent findByPrimaryKey(String student_id)
		throws NoSuchPreschoolStudentException, SystemException {
		PreschoolStudent preschoolStudent = fetchByPrimaryKey(student_id);

		if (preschoolStudent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + student_id);
			}

			throw new NoSuchPreschoolStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				student_id);
		}

		return preschoolStudent;
	}

	/**
	 * Returns the preschool student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool student
	 * @return the preschool student, or <code>null</code> if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolStudent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param student_id the primary key of the preschool student
	 * @return the preschool student, or <code>null</code> if a preschool student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolStudent fetchByPrimaryKey(String student_id)
		throws SystemException {
		PreschoolStudent preschoolStudent = (PreschoolStudent)EntityCacheUtil.getResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolStudentImpl.class, student_id);

		if (preschoolStudent == _nullPreschoolStudent) {
			return null;
		}

		if (preschoolStudent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				preschoolStudent = (PreschoolStudent)session.get(PreschoolStudentImpl.class,
						student_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (preschoolStudent != null) {
					cacheResult(preschoolStudent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PreschoolStudentModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolStudentImpl.class, student_id,
						_nullPreschoolStudent);
				}

				closeSession(session);
			}
		}

		return preschoolStudent;
	}

	/**
	 * Returns all the preschool students.
	 *
	 * @return the preschool students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolStudent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the preschool students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool students
	 * @param end the upper bound of the range of preschool students (not inclusive)
	 * @return the range of preschool students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolStudent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the preschool students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool students
	 * @param end the upper bound of the range of preschool students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of preschool students
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolStudent> findAll(int start, int end,
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

		List<PreschoolStudent> list = (List<PreschoolStudent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRESCHOOLSTUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRESCHOOLSTUDENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PreschoolStudent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PreschoolStudent>)QueryUtil.list(q,
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
	 * Removes all the preschool students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PreschoolStudent preschoolStudent : findAll()) {
			remove(preschoolStudent);
		}
	}

	/**
	 * Returns the number of preschool students.
	 *
	 * @return the number of preschool students
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRESCHOOLSTUDENT);

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
	 * Initializes the preschool student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PreschoolStudent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PreschoolStudent>> listenersList = new ArrayList<ModelListener<PreschoolStudent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PreschoolStudent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PreschoolStudentImpl.class.getName());
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
	private static final String _SQL_SELECT_PRESCHOOLSTUDENT = "SELECT preschoolStudent FROM PreschoolStudent preschoolStudent";
	private static final String _SQL_COUNT_PRESCHOOLSTUDENT = "SELECT COUNT(preschoolStudent) FROM PreschoolStudent preschoolStudent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "preschoolStudent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PreschoolStudent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PreschoolStudentPersistenceImpl.class);
	private static PreschoolStudent _nullPreschoolStudent = new PreschoolStudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PreschoolStudent> toCacheModel() {
				return _nullPreschoolStudentCacheModel;
			}
		};

	private static CacheModel<PreschoolStudent> _nullPreschoolStudentCacheModel = new CacheModel<PreschoolStudent>() {
			public PreschoolStudent toEntityModel() {
				return _nullPreschoolStudent;
			}
		};
}