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

import com.fsoft.bn.NoSuchEnrolmentAttachedFileException;
import com.fsoft.bn.model.EnrolmentAttachedFile;
import com.fsoft.bn.model.impl.EnrolmentAttachedFileImpl;
import com.fsoft.bn.model.impl.EnrolmentAttachedFileModelImpl;

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
 * The persistence implementation for the enrolment attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentAttachedFilePersistence
 * @see EnrolmentAttachedFileUtil
 * @generated
 */
public class EnrolmentAttachedFilePersistenceImpl extends BasePersistenceImpl<EnrolmentAttachedFile>
	implements EnrolmentAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnrolmentAttachedFileUtil} to access the enrolment attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnrolmentAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			EnrolmentAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			EnrolmentAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the enrolment attached file in the entity cache if it is enabled.
	 *
	 * @param enrolmentAttachedFile the enrolment attached file
	 */
	public void cacheResult(EnrolmentAttachedFile enrolmentAttachedFile) {
		EntityCacheUtil.putResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileImpl.class,
			enrolmentAttachedFile.getPrimaryKey(), enrolmentAttachedFile);

		enrolmentAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the enrolment attached files in the entity cache if it is enabled.
	 *
	 * @param enrolmentAttachedFiles the enrolment attached files
	 */
	public void cacheResult(List<EnrolmentAttachedFile> enrolmentAttachedFiles) {
		for (EnrolmentAttachedFile enrolmentAttachedFile : enrolmentAttachedFiles) {
			if (EntityCacheUtil.getResult(
						EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						EnrolmentAttachedFileImpl.class,
						enrolmentAttachedFile.getPrimaryKey()) == null) {
				cacheResult(enrolmentAttachedFile);
			}
			else {
				enrolmentAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enrolment attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnrolmentAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnrolmentAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enrolment attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EnrolmentAttachedFile enrolmentAttachedFile) {
		EntityCacheUtil.removeResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileImpl.class,
			enrolmentAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EnrolmentAttachedFile> enrolmentAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EnrolmentAttachedFile enrolmentAttachedFile : enrolmentAttachedFiles) {
			EntityCacheUtil.removeResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				EnrolmentAttachedFileImpl.class,
				enrolmentAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new enrolment attached file with the primary key. Does not add the enrolment attached file to the database.
	 *
	 * @param enrolment_attached_id the primary key for the new enrolment attached file
	 * @return the new enrolment attached file
	 */
	public EnrolmentAttachedFile create(String enrolment_attached_id) {
		EnrolmentAttachedFile enrolmentAttachedFile = new EnrolmentAttachedFileImpl();

		enrolmentAttachedFile.setNew(true);
		enrolmentAttachedFile.setPrimaryKey(enrolment_attached_id);

		return enrolmentAttachedFile;
	}

	/**
	 * Removes the enrolment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enrolment_attached_id the primary key of the enrolment attached file
	 * @return the enrolment attached file that was removed
	 * @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnrolmentAttachedFile remove(String enrolment_attached_id)
		throws NoSuchEnrolmentAttachedFileException, SystemException {
		return remove((Serializable)enrolment_attached_id);
	}

	/**
	 * Removes the enrolment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enrolment attached file
	 * @return the enrolment attached file that was removed
	 * @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrolmentAttachedFile remove(Serializable primaryKey)
		throws NoSuchEnrolmentAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EnrolmentAttachedFile enrolmentAttachedFile = (EnrolmentAttachedFile)session.get(EnrolmentAttachedFileImpl.class,
					primaryKey);

			if (enrolmentAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnrolmentAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enrolmentAttachedFile);
		}
		catch (NoSuchEnrolmentAttachedFileException nsee) {
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
	protected EnrolmentAttachedFile removeImpl(
		EnrolmentAttachedFile enrolmentAttachedFile) throws SystemException {
		enrolmentAttachedFile = toUnwrappedModel(enrolmentAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, enrolmentAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(enrolmentAttachedFile);

		return enrolmentAttachedFile;
	}

	@Override
	public EnrolmentAttachedFile updateImpl(
		com.fsoft.bn.model.EnrolmentAttachedFile enrolmentAttachedFile,
		boolean merge) throws SystemException {
		enrolmentAttachedFile = toUnwrappedModel(enrolmentAttachedFile);

		boolean isNew = enrolmentAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, enrolmentAttachedFile, merge);

			enrolmentAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentAttachedFileImpl.class,
			enrolmentAttachedFile.getPrimaryKey(), enrolmentAttachedFile);

		return enrolmentAttachedFile;
	}

	protected EnrolmentAttachedFile toUnwrappedModel(
		EnrolmentAttachedFile enrolmentAttachedFile) {
		if (enrolmentAttachedFile instanceof EnrolmentAttachedFileImpl) {
			return enrolmentAttachedFile;
		}

		EnrolmentAttachedFileImpl enrolmentAttachedFileImpl = new EnrolmentAttachedFileImpl();

		enrolmentAttachedFileImpl.setNew(enrolmentAttachedFile.isNew());
		enrolmentAttachedFileImpl.setPrimaryKey(enrolmentAttachedFile.getPrimaryKey());

		enrolmentAttachedFileImpl.setEnrolment_attached_id(enrolmentAttachedFile.getEnrolment_attached_id());
		enrolmentAttachedFileImpl.setEnrolment_id(enrolmentAttachedFile.getEnrolment_id());
		enrolmentAttachedFileImpl.setAttached_file_id(enrolmentAttachedFile.getAttached_file_id());
		enrolmentAttachedFileImpl.setCreated_date(enrolmentAttachedFile.getCreated_date());
		enrolmentAttachedFileImpl.setModified_date(enrolmentAttachedFile.getModified_date());
		enrolmentAttachedFileImpl.setDeleted(enrolmentAttachedFile.isDeleted());

		return enrolmentAttachedFileImpl;
	}

	/**
	 * Returns the enrolment attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrolment attached file
	 * @return the enrolment attached file
	 * @throws com.liferay.portal.NoSuchModelException if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrolmentAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the enrolment attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentAttachedFileException} if it could not be found.
	 *
	 * @param enrolment_attached_id the primary key of the enrolment attached file
	 * @return the enrolment attached file
	 * @throws com.fsoft.bn.NoSuchEnrolmentAttachedFileException if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnrolmentAttachedFile findByPrimaryKey(String enrolment_attached_id)
		throws NoSuchEnrolmentAttachedFileException, SystemException {
		EnrolmentAttachedFile enrolmentAttachedFile = fetchByPrimaryKey(enrolment_attached_id);

		if (enrolmentAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					enrolment_attached_id);
			}

			throw new NoSuchEnrolmentAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				enrolment_attached_id);
		}

		return enrolmentAttachedFile;
	}

	/**
	 * Returns the enrolment attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrolment attached file
	 * @return the enrolment attached file, or <code>null</code> if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EnrolmentAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the enrolment attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enrolment_attached_id the primary key of the enrolment attached file
	 * @return the enrolment attached file, or <code>null</code> if a enrolment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EnrolmentAttachedFile fetchByPrimaryKey(String enrolment_attached_id)
		throws SystemException {
		EnrolmentAttachedFile enrolmentAttachedFile = (EnrolmentAttachedFile)EntityCacheUtil.getResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				EnrolmentAttachedFileImpl.class, enrolment_attached_id);

		if (enrolmentAttachedFile == _nullEnrolmentAttachedFile) {
			return null;
		}

		if (enrolmentAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				enrolmentAttachedFile = (EnrolmentAttachedFile)session.get(EnrolmentAttachedFileImpl.class,
						enrolment_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (enrolmentAttachedFile != null) {
					cacheResult(enrolmentAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EnrolmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						EnrolmentAttachedFileImpl.class, enrolment_attached_id,
						_nullEnrolmentAttachedFile);
				}

				closeSession(session);
			}
		}

		return enrolmentAttachedFile;
	}

	/**
	 * Returns all the enrolment attached files.
	 *
	 * @return the enrolment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<EnrolmentAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enrolment attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrolment attached files
	 * @param end the upper bound of the range of enrolment attached files (not inclusive)
	 * @return the range of enrolment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<EnrolmentAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enrolment attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrolment attached files
	 * @param end the upper bound of the range of enrolment attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enrolment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<EnrolmentAttachedFile> findAll(int start, int end,
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

		List<EnrolmentAttachedFile> list = (List<EnrolmentAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENROLMENTATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENROLMENTATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EnrolmentAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EnrolmentAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the enrolment attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EnrolmentAttachedFile enrolmentAttachedFile : findAll()) {
			remove(enrolmentAttachedFile);
		}
	}

	/**
	 * Returns the number of enrolment attached files.
	 *
	 * @return the number of enrolment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENROLMENTATTACHEDFILE);

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
	 * Initializes the enrolment attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.EnrolmentAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EnrolmentAttachedFile>> listenersList = new ArrayList<ModelListener<EnrolmentAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EnrolmentAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnrolmentAttachedFileImpl.class.getName());
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
	private static final String _SQL_SELECT_ENROLMENTATTACHEDFILE = "SELECT enrolmentAttachedFile FROM EnrolmentAttachedFile enrolmentAttachedFile";
	private static final String _SQL_COUNT_ENROLMENTATTACHEDFILE = "SELECT COUNT(enrolmentAttachedFile) FROM EnrolmentAttachedFile enrolmentAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enrolmentAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EnrolmentAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnrolmentAttachedFilePersistenceImpl.class);
	private static EnrolmentAttachedFile _nullEnrolmentAttachedFile = new EnrolmentAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EnrolmentAttachedFile> toCacheModel() {
				return _nullEnrolmentAttachedFileCacheModel;
			}
		};

	private static CacheModel<EnrolmentAttachedFile> _nullEnrolmentAttachedFileCacheModel =
		new CacheModel<EnrolmentAttachedFile>() {
			public EnrolmentAttachedFile toEntityModel() {
				return _nullEnrolmentAttachedFile;
			}
		};
}