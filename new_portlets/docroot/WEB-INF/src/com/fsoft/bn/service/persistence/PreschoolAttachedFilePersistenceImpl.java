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

import com.fsoft.bn.NoSuchPreschoolAttachedFileException;
import com.fsoft.bn.model.PreschoolAttachedFile;
import com.fsoft.bn.model.impl.PreschoolAttachedFileImpl;
import com.fsoft.bn.model.impl.PreschoolAttachedFileModelImpl;

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
 * The persistence implementation for the preschool attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see PreschoolAttachedFilePersistence
 * @see PreschoolAttachedFileUtil
 * @generated
 */
public class PreschoolAttachedFilePersistenceImpl extends BasePersistenceImpl<PreschoolAttachedFile>
	implements PreschoolAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PreschoolAttachedFileUtil} to access the preschool attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PreschoolAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			PreschoolAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			PreschoolAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the preschool attached file in the entity cache if it is enabled.
	 *
	 * @param preschoolAttachedFile the preschool attached file
	 */
	public void cacheResult(PreschoolAttachedFile preschoolAttachedFile) {
		EntityCacheUtil.putResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileImpl.class,
			preschoolAttachedFile.getPrimaryKey(), preschoolAttachedFile);

		preschoolAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the preschool attached files in the entity cache if it is enabled.
	 *
	 * @param preschoolAttachedFiles the preschool attached files
	 */
	public void cacheResult(List<PreschoolAttachedFile> preschoolAttachedFiles) {
		for (PreschoolAttachedFile preschoolAttachedFile : preschoolAttachedFiles) {
			if (EntityCacheUtil.getResult(
						PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolAttachedFileImpl.class,
						preschoolAttachedFile.getPrimaryKey()) == null) {
				cacheResult(preschoolAttachedFile);
			}
			else {
				preschoolAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all preschool attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PreschoolAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PreschoolAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the preschool attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PreschoolAttachedFile preschoolAttachedFile) {
		EntityCacheUtil.removeResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileImpl.class,
			preschoolAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PreschoolAttachedFile> preschoolAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PreschoolAttachedFile preschoolAttachedFile : preschoolAttachedFiles) {
			EntityCacheUtil.removeResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolAttachedFileImpl.class,
				preschoolAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new preschool attached file with the primary key. Does not add the preschool attached file to the database.
	 *
	 * @param preschool_attached_id the primary key for the new preschool attached file
	 * @return the new preschool attached file
	 */
	public PreschoolAttachedFile create(String preschool_attached_id) {
		PreschoolAttachedFile preschoolAttachedFile = new PreschoolAttachedFileImpl();

		preschoolAttachedFile.setNew(true);
		preschoolAttachedFile.setPrimaryKey(preschool_attached_id);

		return preschoolAttachedFile;
	}

	/**
	 * Removes the preschool attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param preschool_attached_id the primary key of the preschool attached file
	 * @return the preschool attached file that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolAttachedFile remove(String preschool_attached_id)
		throws NoSuchPreschoolAttachedFileException, SystemException {
		return remove((Serializable)preschool_attached_id);
	}

	/**
	 * Removes the preschool attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the preschool attached file
	 * @return the preschool attached file that was removed
	 * @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolAttachedFile remove(Serializable primaryKey)
		throws NoSuchPreschoolAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PreschoolAttachedFile preschoolAttachedFile = (PreschoolAttachedFile)session.get(PreschoolAttachedFileImpl.class,
					primaryKey);

			if (preschoolAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPreschoolAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(preschoolAttachedFile);
		}
		catch (NoSuchPreschoolAttachedFileException nsee) {
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
	protected PreschoolAttachedFile removeImpl(
		PreschoolAttachedFile preschoolAttachedFile) throws SystemException {
		preschoolAttachedFile = toUnwrappedModel(preschoolAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, preschoolAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(preschoolAttachedFile);

		return preschoolAttachedFile;
	}

	@Override
	public PreschoolAttachedFile updateImpl(
		com.fsoft.bn.model.PreschoolAttachedFile preschoolAttachedFile,
		boolean merge) throws SystemException {
		preschoolAttachedFile = toUnwrappedModel(preschoolAttachedFile);

		boolean isNew = preschoolAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, preschoolAttachedFile, merge);

			preschoolAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			PreschoolAttachedFileImpl.class,
			preschoolAttachedFile.getPrimaryKey(), preschoolAttachedFile);

		return preschoolAttachedFile;
	}

	protected PreschoolAttachedFile toUnwrappedModel(
		PreschoolAttachedFile preschoolAttachedFile) {
		if (preschoolAttachedFile instanceof PreschoolAttachedFileImpl) {
			return preschoolAttachedFile;
		}

		PreschoolAttachedFileImpl preschoolAttachedFileImpl = new PreschoolAttachedFileImpl();

		preschoolAttachedFileImpl.setNew(preschoolAttachedFile.isNew());
		preschoolAttachedFileImpl.setPrimaryKey(preschoolAttachedFile.getPrimaryKey());

		preschoolAttachedFileImpl.setPreschool_attached_id(preschoolAttachedFile.getPreschool_attached_id());
		preschoolAttachedFileImpl.setStudent_id(preschoolAttachedFile.getStudent_id());
		preschoolAttachedFileImpl.setAttached_file_id(preschoolAttachedFile.getAttached_file_id());
		preschoolAttachedFileImpl.setCreated_date(preschoolAttachedFile.getCreated_date());
		preschoolAttachedFileImpl.setModified_date(preschoolAttachedFile.getModified_date());
		preschoolAttachedFileImpl.setDeleted(preschoolAttachedFile.isDeleted());

		return preschoolAttachedFileImpl;
	}

	/**
	 * Returns the preschool attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool attached file
	 * @return the preschool attached file
	 * @throws com.liferay.portal.NoSuchModelException if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchPreschoolAttachedFileException} if it could not be found.
	 *
	 * @param preschool_attached_id the primary key of the preschool attached file
	 * @return the preschool attached file
	 * @throws com.fsoft.bn.NoSuchPreschoolAttachedFileException if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolAttachedFile findByPrimaryKey(String preschool_attached_id)
		throws NoSuchPreschoolAttachedFileException, SystemException {
		PreschoolAttachedFile preschoolAttachedFile = fetchByPrimaryKey(preschool_attached_id);

		if (preschoolAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					preschool_attached_id);
			}

			throw new NoSuchPreschoolAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				preschool_attached_id);
		}

		return preschoolAttachedFile;
	}

	/**
	 * Returns the preschool attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the preschool attached file
	 * @return the preschool attached file, or <code>null</code> if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreschoolAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the preschool attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param preschool_attached_id the primary key of the preschool attached file
	 * @return the preschool attached file, or <code>null</code> if a preschool attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreschoolAttachedFile fetchByPrimaryKey(String preschool_attached_id)
		throws SystemException {
		PreschoolAttachedFile preschoolAttachedFile = (PreschoolAttachedFile)EntityCacheUtil.getResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				PreschoolAttachedFileImpl.class, preschool_attached_id);

		if (preschoolAttachedFile == _nullPreschoolAttachedFile) {
			return null;
		}

		if (preschoolAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				preschoolAttachedFile = (PreschoolAttachedFile)session.get(PreschoolAttachedFileImpl.class,
						preschool_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (preschoolAttachedFile != null) {
					cacheResult(preschoolAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PreschoolAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						PreschoolAttachedFileImpl.class, preschool_attached_id,
						_nullPreschoolAttachedFile);
				}

				closeSession(session);
			}
		}

		return preschoolAttachedFile;
	}

	/**
	 * Returns all the preschool attached files.
	 *
	 * @return the preschool attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the preschool attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool attached files
	 * @param end the upper bound of the range of preschool attached files (not inclusive)
	 * @return the range of preschool attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the preschool attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of preschool attached files
	 * @param end the upper bound of the range of preschool attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of preschool attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreschoolAttachedFile> findAll(int start, int end,
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

		List<PreschoolAttachedFile> list = (List<PreschoolAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRESCHOOLATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRESCHOOLATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PreschoolAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PreschoolAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the preschool attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PreschoolAttachedFile preschoolAttachedFile : findAll()) {
			remove(preschoolAttachedFile);
		}
	}

	/**
	 * Returns the number of preschool attached files.
	 *
	 * @return the number of preschool attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRESCHOOLATTACHEDFILE);

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
	 * Initializes the preschool attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.PreschoolAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PreschoolAttachedFile>> listenersList = new ArrayList<ModelListener<PreschoolAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PreschoolAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PreschoolAttachedFileImpl.class.getName());
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
	private static final String _SQL_SELECT_PRESCHOOLATTACHEDFILE = "SELECT preschoolAttachedFile FROM PreschoolAttachedFile preschoolAttachedFile";
	private static final String _SQL_COUNT_PRESCHOOLATTACHEDFILE = "SELECT COUNT(preschoolAttachedFile) FROM PreschoolAttachedFile preschoolAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "preschoolAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PreschoolAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PreschoolAttachedFilePersistenceImpl.class);
	private static PreschoolAttachedFile _nullPreschoolAttachedFile = new PreschoolAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PreschoolAttachedFile> toCacheModel() {
				return _nullPreschoolAttachedFileCacheModel;
			}
		};

	private static CacheModel<PreschoolAttachedFile> _nullPreschoolAttachedFileCacheModel =
		new CacheModel<PreschoolAttachedFile>() {
			public PreschoolAttachedFile toEntityModel() {
				return _nullPreschoolAttachedFile;
			}
		};
}