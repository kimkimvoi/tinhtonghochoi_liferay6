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

import com.fsoft.bn.NoSuchRecruitmentAttachedFileException;
import com.fsoft.bn.model.RecruitmentAttachedFile;
import com.fsoft.bn.model.impl.RecruitmentAttachedFileImpl;
import com.fsoft.bn.model.impl.RecruitmentAttachedFileModelImpl;

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
 * The persistence implementation for the recruitment attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see RecruitmentAttachedFilePersistence
 * @see RecruitmentAttachedFileUtil
 * @generated
 */
public class RecruitmentAttachedFilePersistenceImpl extends BasePersistenceImpl<RecruitmentAttachedFile>
	implements RecruitmentAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RecruitmentAttachedFileUtil} to access the recruitment attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RecruitmentAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			RecruitmentAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the recruitment attached file in the entity cache if it is enabled.
	 *
	 * @param recruitmentAttachedFile the recruitment attached file
	 */
	public void cacheResult(RecruitmentAttachedFile recruitmentAttachedFile) {
		EntityCacheUtil.putResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileImpl.class,
			recruitmentAttachedFile.getPrimaryKey(), recruitmentAttachedFile);

		recruitmentAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the recruitment attached files in the entity cache if it is enabled.
	 *
	 * @param recruitmentAttachedFiles the recruitment attached files
	 */
	public void cacheResult(
		List<RecruitmentAttachedFile> recruitmentAttachedFiles) {
		for (RecruitmentAttachedFile recruitmentAttachedFile : recruitmentAttachedFiles) {
			if (EntityCacheUtil.getResult(
						RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentAttachedFileImpl.class,
						recruitmentAttachedFile.getPrimaryKey()) == null) {
				cacheResult(recruitmentAttachedFile);
			}
			else {
				recruitmentAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all recruitment attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RecruitmentAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RecruitmentAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recruitment attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RecruitmentAttachedFile recruitmentAttachedFile) {
		EntityCacheUtil.removeResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileImpl.class,
			recruitmentAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RecruitmentAttachedFile> recruitmentAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RecruitmentAttachedFile recruitmentAttachedFile : recruitmentAttachedFiles) {
			EntityCacheUtil.removeResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentAttachedFileImpl.class,
				recruitmentAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new recruitment attached file with the primary key. Does not add the recruitment attached file to the database.
	 *
	 * @param recruitment_attached_id the primary key for the new recruitment attached file
	 * @return the new recruitment attached file
	 */
	public RecruitmentAttachedFile create(String recruitment_attached_id) {
		RecruitmentAttachedFile recruitmentAttachedFile = new RecruitmentAttachedFileImpl();

		recruitmentAttachedFile.setNew(true);
		recruitmentAttachedFile.setPrimaryKey(recruitment_attached_id);

		return recruitmentAttachedFile;
	}

	/**
	 * Removes the recruitment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_attached_id the primary key of the recruitment attached file
	 * @return the recruitment attached file that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentAttachedFile remove(String recruitment_attached_id)
		throws NoSuchRecruitmentAttachedFileException, SystemException {
		return remove((Serializable)recruitment_attached_id);
	}

	/**
	 * Removes the recruitment attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recruitment attached file
	 * @return the recruitment attached file that was removed
	 * @throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentAttachedFile remove(Serializable primaryKey)
		throws NoSuchRecruitmentAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RecruitmentAttachedFile recruitmentAttachedFile = (RecruitmentAttachedFile)session.get(RecruitmentAttachedFileImpl.class,
					primaryKey);

			if (recruitmentAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecruitmentAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(recruitmentAttachedFile);
		}
		catch (NoSuchRecruitmentAttachedFileException nsee) {
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
	protected RecruitmentAttachedFile removeImpl(
		RecruitmentAttachedFile recruitmentAttachedFile)
		throws SystemException {
		recruitmentAttachedFile = toUnwrappedModel(recruitmentAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, recruitmentAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(recruitmentAttachedFile);

		return recruitmentAttachedFile;
	}

	@Override
	public RecruitmentAttachedFile updateImpl(
		com.fsoft.bn.model.RecruitmentAttachedFile recruitmentAttachedFile,
		boolean merge) throws SystemException {
		recruitmentAttachedFile = toUnwrappedModel(recruitmentAttachedFile);

		boolean isNew = recruitmentAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, recruitmentAttachedFile, merge);

			recruitmentAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			RecruitmentAttachedFileImpl.class,
			recruitmentAttachedFile.getPrimaryKey(), recruitmentAttachedFile);

		return recruitmentAttachedFile;
	}

	protected RecruitmentAttachedFile toUnwrappedModel(
		RecruitmentAttachedFile recruitmentAttachedFile) {
		if (recruitmentAttachedFile instanceof RecruitmentAttachedFileImpl) {
			return recruitmentAttachedFile;
		}

		RecruitmentAttachedFileImpl recruitmentAttachedFileImpl = new RecruitmentAttachedFileImpl();

		recruitmentAttachedFileImpl.setNew(recruitmentAttachedFile.isNew());
		recruitmentAttachedFileImpl.setPrimaryKey(recruitmentAttachedFile.getPrimaryKey());

		recruitmentAttachedFileImpl.setRecruitment_attached_id(recruitmentAttachedFile.getRecruitment_attached_id());
		recruitmentAttachedFileImpl.setRecruitment_id(recruitmentAttachedFile.getRecruitment_id());
		recruitmentAttachedFileImpl.setAttached_file_id(recruitmentAttachedFile.getAttached_file_id());
		recruitmentAttachedFileImpl.setCreated_date(recruitmentAttachedFile.getCreated_date());
		recruitmentAttachedFileImpl.setModified_date(recruitmentAttachedFile.getModified_date());
		recruitmentAttachedFileImpl.setDeleted(recruitmentAttachedFile.isDeleted());

		return recruitmentAttachedFileImpl;
	}

	/**
	 * Returns the recruitment attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment attached file
	 * @return the recruitment attached file
	 * @throws com.liferay.portal.NoSuchModelException if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchRecruitmentAttachedFileException} if it could not be found.
	 *
	 * @param recruitment_attached_id the primary key of the recruitment attached file
	 * @return the recruitment attached file
	 * @throws com.fsoft.bn.NoSuchRecruitmentAttachedFileException if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentAttachedFile findByPrimaryKey(
		String recruitment_attached_id)
		throws NoSuchRecruitmentAttachedFileException, SystemException {
		RecruitmentAttachedFile recruitmentAttachedFile = fetchByPrimaryKey(recruitment_attached_id);

		if (recruitmentAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					recruitment_attached_id);
			}

			throw new NoSuchRecruitmentAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				recruitment_attached_id);
		}

		return recruitmentAttachedFile;
	}

	/**
	 * Returns the recruitment attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recruitment attached file
	 * @return the recruitment attached file, or <code>null</code> if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RecruitmentAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the recruitment attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recruitment_attached_id the primary key of the recruitment attached file
	 * @return the recruitment attached file, or <code>null</code> if a recruitment attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentAttachedFile fetchByPrimaryKey(
		String recruitment_attached_id) throws SystemException {
		RecruitmentAttachedFile recruitmentAttachedFile = (RecruitmentAttachedFile)EntityCacheUtil.getResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				RecruitmentAttachedFileImpl.class, recruitment_attached_id);

		if (recruitmentAttachedFile == _nullRecruitmentAttachedFile) {
			return null;
		}

		if (recruitmentAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				recruitmentAttachedFile = (RecruitmentAttachedFile)session.get(RecruitmentAttachedFileImpl.class,
						recruitment_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (recruitmentAttachedFile != null) {
					cacheResult(recruitmentAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RecruitmentAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						RecruitmentAttachedFileImpl.class,
						recruitment_attached_id, _nullRecruitmentAttachedFile);
				}

				closeSession(session);
			}
		}

		return recruitmentAttachedFile;
	}

	/**
	 * Returns all the recruitment attached files.
	 *
	 * @return the recruitment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the recruitment attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment attached files
	 * @param end the upper bound of the range of recruitment attached files (not inclusive)
	 * @return the range of recruitment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the recruitment attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment attached files
	 * @param end the upper bound of the range of recruitment attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recruitment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentAttachedFile> findAll(int start, int end,
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

		List<RecruitmentAttachedFile> list = (List<RecruitmentAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RECRUITMENTATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RECRUITMENTATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RecruitmentAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RecruitmentAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the recruitment attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RecruitmentAttachedFile recruitmentAttachedFile : findAll()) {
			remove(recruitmentAttachedFile);
		}
	}

	/**
	 * Returns the number of recruitment attached files.
	 *
	 * @return the number of recruitment attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RECRUITMENTATTACHEDFILE);

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
	 * Initializes the recruitment attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.RecruitmentAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RecruitmentAttachedFile>> listenersList = new ArrayList<ModelListener<RecruitmentAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RecruitmentAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RecruitmentAttachedFileImpl.class.getName());
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
	private static final String _SQL_SELECT_RECRUITMENTATTACHEDFILE = "SELECT recruitmentAttachedFile FROM RecruitmentAttachedFile recruitmentAttachedFile";
	private static final String _SQL_COUNT_RECRUITMENTATTACHEDFILE = "SELECT COUNT(recruitmentAttachedFile) FROM RecruitmentAttachedFile recruitmentAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "recruitmentAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RecruitmentAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RecruitmentAttachedFilePersistenceImpl.class);
	private static RecruitmentAttachedFile _nullRecruitmentAttachedFile = new RecruitmentAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RecruitmentAttachedFile> toCacheModel() {
				return _nullRecruitmentAttachedFileCacheModel;
			}
		};

	private static CacheModel<RecruitmentAttachedFile> _nullRecruitmentAttachedFileCacheModel =
		new CacheModel<RecruitmentAttachedFile>() {
			public RecruitmentAttachedFile toEntityModel() {
				return _nullRecruitmentAttachedFile;
			}
		};
}