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

import com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException;
import com.fsoft.bn.model.PrimarySchoolAttachedFile;
import com.fsoft.bn.model.impl.PrimarySchoolAttachedFileImpl;
import com.fsoft.bn.model.impl.PrimarySchoolAttachedFileModelImpl;

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
 * The persistence implementation for the primary school attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PrimarySchoolAttachedFilePersistence
 * @see PrimarySchoolAttachedFileUtil
 * @generated
 */
public class PrimarySchoolAttachedFilePersistenceImpl
	extends BasePersistenceImpl<PrimarySchoolAttachedFile>
	implements PrimarySchoolAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrimarySchoolAttachedFileUtil} to access the primary school attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrimarySchoolAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			PrimarySchoolAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the primary school attached file in the entity cache if it is enabled.
	 *
	 * @param primarySchoolAttachedFile the primary school attached file
	 */
	public void cacheResult(PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		EntityCacheUtil.putResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileImpl.class,
			primarySchoolAttachedFile.getPrimaryKey(), primarySchoolAttachedFile);

		primarySchoolAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the primary school attached files in the entity cache if it is enabled.
	 *
	 * @param primarySchoolAttachedFiles the primary school attached files
	 */
	public void cacheResult(
		List<PrimarySchoolAttachedFile> primarySchoolAttachedFiles) {
		for (PrimarySchoolAttachedFile primarySchoolAttachedFile : primarySchoolAttachedFiles) {
			if (EntityCacheUtil.getResult(
						PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolAttachedFileImpl.class,
						primarySchoolAttachedFile.getPrimaryKey()) == null) {
				cacheResult(primarySchoolAttachedFile);
			}
			else {
				primarySchoolAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all primary school attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrimarySchoolAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrimarySchoolAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the primary school attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		EntityCacheUtil.removeResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileImpl.class,
			primarySchoolAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<PrimarySchoolAttachedFile> primarySchoolAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PrimarySchoolAttachedFile primarySchoolAttachedFile : primarySchoolAttachedFiles) {
			EntityCacheUtil.removeResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolAttachedFileImpl.class,
				primarySchoolAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new primary school attached file with the primary key. Does not add the primary school attached file to the database.
	 *
	 * @param primarySchool_attached_id the primary key for the new primary school attached file
	 * @return the new primary school attached file
	 */
	public PrimarySchoolAttachedFile create(String primarySchool_attached_id) {
		PrimarySchoolAttachedFile primarySchoolAttachedFile = new PrimarySchoolAttachedFileImpl();

		primarySchoolAttachedFile.setNew(true);
		primarySchoolAttachedFile.setPrimaryKey(primarySchool_attached_id);

		return primarySchoolAttachedFile;
	}

	/**
	 * Removes the primary school attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primarySchool_attached_id the primary key of the primary school attached file
	 * @return the primary school attached file that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolAttachedFile remove(String primarySchool_attached_id)
		throws NoSuchPrimarySchoolAttachedFileException, SystemException {
		return remove((Serializable)primarySchool_attached_id);
	}

	/**
	 * Removes the primary school attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the primary school attached file
	 * @return the primary school attached file that was removed
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolAttachedFile remove(Serializable primaryKey)
		throws NoSuchPrimarySchoolAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PrimarySchoolAttachedFile primarySchoolAttachedFile = (PrimarySchoolAttachedFile)session.get(PrimarySchoolAttachedFileImpl.class,
					primaryKey);

			if (primarySchoolAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrimarySchoolAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(primarySchoolAttachedFile);
		}
		catch (NoSuchPrimarySchoolAttachedFileException nsee) {
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
	protected PrimarySchoolAttachedFile removeImpl(
		PrimarySchoolAttachedFile primarySchoolAttachedFile)
		throws SystemException {
		primarySchoolAttachedFile = toUnwrappedModel(primarySchoolAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, primarySchoolAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(primarySchoolAttachedFile);

		return primarySchoolAttachedFile;
	}

	@Override
	public PrimarySchoolAttachedFile updateImpl(
		com.fsoft.bn.model.PrimarySchoolAttachedFile primarySchoolAttachedFile,
		boolean merge) throws SystemException {
		primarySchoolAttachedFile = toUnwrappedModel(primarySchoolAttachedFile);

		boolean isNew = primarySchoolAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, primarySchoolAttachedFile, merge);

			primarySchoolAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PrimarySchoolAttachedFileImpl.class,
			primarySchoolAttachedFile.getPrimaryKey(), primarySchoolAttachedFile);

		return primarySchoolAttachedFile;
	}

	protected PrimarySchoolAttachedFile toUnwrappedModel(
		PrimarySchoolAttachedFile primarySchoolAttachedFile) {
		if (primarySchoolAttachedFile instanceof PrimarySchoolAttachedFileImpl) {
			return primarySchoolAttachedFile;
		}

		PrimarySchoolAttachedFileImpl primarySchoolAttachedFileImpl = new PrimarySchoolAttachedFileImpl();

		primarySchoolAttachedFileImpl.setNew(primarySchoolAttachedFile.isNew());
		primarySchoolAttachedFileImpl.setPrimaryKey(primarySchoolAttachedFile.getPrimaryKey());

		primarySchoolAttachedFileImpl.setPrimarySchool_attached_id(primarySchoolAttachedFile.getPrimarySchool_attached_id());
		primarySchoolAttachedFileImpl.setPrimaryStudent_id(primarySchoolAttachedFile.getPrimaryStudent_id());
		primarySchoolAttachedFileImpl.setAttached_file_id(primarySchoolAttachedFile.getAttached_file_id());
		primarySchoolAttachedFileImpl.setCreated_date(primarySchoolAttachedFile.getCreated_date());
		primarySchoolAttachedFileImpl.setModified_date(primarySchoolAttachedFile.getModified_date());
		primarySchoolAttachedFileImpl.setDeleted(primarySchoolAttachedFile.isDeleted());

		return primarySchoolAttachedFileImpl;
	}

	/**
	 * Returns the primary school attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school attached file
	 * @return the primary school attached file
	 * @throws com.liferay.portal.NoSuchModelException if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException} if it could not be found.
	 *
	 * @param primarySchool_attached_id the primary key of the primary school attached file
	 * @return the primary school attached file
	 * @throws com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolAttachedFile findByPrimaryKey(
		String primarySchool_attached_id)
		throws NoSuchPrimarySchoolAttachedFileException, SystemException {
		PrimarySchoolAttachedFile primarySchoolAttachedFile = fetchByPrimaryKey(primarySchool_attached_id);

		if (primarySchoolAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primarySchool_attached_id);
			}

			throw new NoSuchPrimarySchoolAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primarySchool_attached_id);
		}

		return primarySchoolAttachedFile;
	}

	/**
	 * Returns the primary school attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the primary school attached file
	 * @return the primary school attached file, or <code>null</code> if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PrimarySchoolAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the primary school attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primarySchool_attached_id the primary key of the primary school attached file
	 * @return the primary school attached file, or <code>null</code> if a primary school attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PrimarySchoolAttachedFile fetchByPrimaryKey(
		String primarySchool_attached_id) throws SystemException {
		PrimarySchoolAttachedFile primarySchoolAttachedFile = (PrimarySchoolAttachedFile)EntityCacheUtil.getResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				PrimarySchoolAttachedFileImpl.class, primarySchool_attached_id);

		if (primarySchoolAttachedFile == _nullPrimarySchoolAttachedFile) {
			return null;
		}

		if (primarySchoolAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				primarySchoolAttachedFile = (PrimarySchoolAttachedFile)session.get(PrimarySchoolAttachedFileImpl.class,
						primarySchool_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (primarySchoolAttachedFile != null) {
					cacheResult(primarySchoolAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PrimarySchoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						PrimarySchoolAttachedFileImpl.class,
						primarySchool_attached_id,
						_nullPrimarySchoolAttachedFile);
				}

				closeSession(session);
			}
		}

		return primarySchoolAttachedFile;
	}

	/**
	 * Returns all the primary school attached files.
	 *
	 * @return the primary school attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the primary school attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school attached files
	 * @param end the upper bound of the range of primary school attached files (not inclusive)
	 * @return the range of primary school attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the primary school attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of primary school attached files
	 * @param end the upper bound of the range of primary school attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of primary school attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PrimarySchoolAttachedFile> findAll(int start, int end,
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

		List<PrimarySchoolAttachedFile> list = (List<PrimarySchoolAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRIMARYSCHOOLATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRIMARYSCHOOLATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PrimarySchoolAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PrimarySchoolAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the primary school attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PrimarySchoolAttachedFile primarySchoolAttachedFile : findAll()) {
			remove(primarySchoolAttachedFile);
		}
	}

	/**
	 * Returns the number of primary school attached files.
	 *
	 * @return the number of primary school attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRIMARYSCHOOLATTACHEDFILE);

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
	 * Initializes the primary school attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PrimarySchoolAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PrimarySchoolAttachedFile>> listenersList = new ArrayList<ModelListener<PrimarySchoolAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PrimarySchoolAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrimarySchoolAttachedFileImpl.class.getName());
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
	private static final String _SQL_SELECT_PRIMARYSCHOOLATTACHEDFILE = "SELECT primarySchoolAttachedFile FROM PrimarySchoolAttachedFile primarySchoolAttachedFile";
	private static final String _SQL_COUNT_PRIMARYSCHOOLATTACHEDFILE = "SELECT COUNT(primarySchoolAttachedFile) FROM PrimarySchoolAttachedFile primarySchoolAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "primarySchoolAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PrimarySchoolAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrimarySchoolAttachedFilePersistenceImpl.class);
	private static PrimarySchoolAttachedFile _nullPrimarySchoolAttachedFile = new PrimarySchoolAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PrimarySchoolAttachedFile> toCacheModel() {
				return _nullPrimarySchoolAttachedFileCacheModel;
			}
		};

	private static CacheModel<PrimarySchoolAttachedFile> _nullPrimarySchoolAttachedFileCacheModel =
		new CacheModel<PrimarySchoolAttachedFile>() {
			public PrimarySchoolAttachedFile toEntityModel() {
				return _nullPrimarySchoolAttachedFile;
			}
		};
}