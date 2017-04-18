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

import com.fsoft.bn.NoSuchAnswerAttachedFileException;
import com.fsoft.bn.model.AnswerAttachedFile;
import com.fsoft.bn.model.impl.AnswerAttachedFileImpl;
import com.fsoft.bn.model.impl.AnswerAttachedFileModelImpl;

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
 * The persistence implementation for the answer attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see AnswerAttachedFilePersistence
 * @see AnswerAttachedFileUtil
 * @generated
 */
public class AnswerAttachedFilePersistenceImpl extends BasePersistenceImpl<AnswerAttachedFile>
	implements AnswerAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnswerAttachedFileUtil} to access the answer attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnswerAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			AnswerAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			AnswerAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the answer attached file in the entity cache if it is enabled.
	 *
	 * @param answerAttachedFile the answer attached file
	 */
	public void cacheResult(AnswerAttachedFile answerAttachedFile) {
		EntityCacheUtil.putResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileImpl.class, answerAttachedFile.getPrimaryKey(),
			answerAttachedFile);

		answerAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the answer attached files in the entity cache if it is enabled.
	 *
	 * @param answerAttachedFiles the answer attached files
	 */
	public void cacheResult(List<AnswerAttachedFile> answerAttachedFiles) {
		for (AnswerAttachedFile answerAttachedFile : answerAttachedFiles) {
			if (EntityCacheUtil.getResult(
						AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						AnswerAttachedFileImpl.class,
						answerAttachedFile.getPrimaryKey()) == null) {
				cacheResult(answerAttachedFile);
			}
			else {
				answerAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all answer attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnswerAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnswerAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the answer attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnswerAttachedFile answerAttachedFile) {
		EntityCacheUtil.removeResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileImpl.class, answerAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnswerAttachedFile> answerAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnswerAttachedFile answerAttachedFile : answerAttachedFiles) {
			EntityCacheUtil.removeResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				AnswerAttachedFileImpl.class, answerAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new answer attached file with the primary key. Does not add the answer attached file to the database.
	 *
	 * @param answer_attached_id the primary key for the new answer attached file
	 * @return the new answer attached file
	 */
	public AnswerAttachedFile create(String answer_attached_id) {
		AnswerAttachedFile answerAttachedFile = new AnswerAttachedFileImpl();

		answerAttachedFile.setNew(true);
		answerAttachedFile.setPrimaryKey(answer_attached_id);

		return answerAttachedFile;
	}

	/**
	 * Removes the answer attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answer_attached_id the primary key of the answer attached file
	 * @return the answer attached file that was removed
	 * @throws com.fsoft.bn.NoSuchAnswerAttachedFileException if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnswerAttachedFile remove(String answer_attached_id)
		throws NoSuchAnswerAttachedFileException, SystemException {
		return remove((Serializable)answer_attached_id);
	}

	/**
	 * Removes the answer attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answer attached file
	 * @return the answer attached file that was removed
	 * @throws com.fsoft.bn.NoSuchAnswerAttachedFileException if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnswerAttachedFile remove(Serializable primaryKey)
		throws NoSuchAnswerAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AnswerAttachedFile answerAttachedFile = (AnswerAttachedFile)session.get(AnswerAttachedFileImpl.class,
					primaryKey);

			if (answerAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswerAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(answerAttachedFile);
		}
		catch (NoSuchAnswerAttachedFileException nsee) {
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
	protected AnswerAttachedFile removeImpl(
		AnswerAttachedFile answerAttachedFile) throws SystemException {
		answerAttachedFile = toUnwrappedModel(answerAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, answerAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(answerAttachedFile);

		return answerAttachedFile;
	}

	@Override
	public AnswerAttachedFile updateImpl(
		com.fsoft.bn.model.AnswerAttachedFile answerAttachedFile, boolean merge)
		throws SystemException {
		answerAttachedFile = toUnwrappedModel(answerAttachedFile);

		boolean isNew = answerAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, answerAttachedFile, merge);

			answerAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			AnswerAttachedFileImpl.class, answerAttachedFile.getPrimaryKey(),
			answerAttachedFile);

		return answerAttachedFile;
	}

	protected AnswerAttachedFile toUnwrappedModel(
		AnswerAttachedFile answerAttachedFile) {
		if (answerAttachedFile instanceof AnswerAttachedFileImpl) {
			return answerAttachedFile;
		}

		AnswerAttachedFileImpl answerAttachedFileImpl = new AnswerAttachedFileImpl();

		answerAttachedFileImpl.setNew(answerAttachedFile.isNew());
		answerAttachedFileImpl.setPrimaryKey(answerAttachedFile.getPrimaryKey());

		answerAttachedFileImpl.setAnswer_attached_id(answerAttachedFile.getAnswer_attached_id());
		answerAttachedFileImpl.setAnswer_id(answerAttachedFile.getAnswer_id());
		answerAttachedFileImpl.setAttached_file_id(answerAttachedFile.getAttached_file_id());
		answerAttachedFileImpl.setCreated_date(answerAttachedFile.getCreated_date());
		answerAttachedFileImpl.setModified_date(answerAttachedFile.getModified_date());
		answerAttachedFileImpl.setDeleted(answerAttachedFile.isDeleted());

		return answerAttachedFileImpl;
	}

	/**
	 * Returns the answer attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer attached file
	 * @return the answer attached file
	 * @throws com.liferay.portal.NoSuchModelException if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnswerAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the answer attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchAnswerAttachedFileException} if it could not be found.
	 *
	 * @param answer_attached_id the primary key of the answer attached file
	 * @return the answer attached file
	 * @throws com.fsoft.bn.NoSuchAnswerAttachedFileException if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnswerAttachedFile findByPrimaryKey(String answer_attached_id)
		throws NoSuchAnswerAttachedFileException, SystemException {
		AnswerAttachedFile answerAttachedFile = fetchByPrimaryKey(answer_attached_id);

		if (answerAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					answer_attached_id);
			}

			throw new NoSuchAnswerAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				answer_attached_id);
		}

		return answerAttachedFile;
	}

	/**
	 * Returns the answer attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer attached file
	 * @return the answer attached file, or <code>null</code> if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AnswerAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the answer attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answer_attached_id the primary key of the answer attached file
	 * @return the answer attached file, or <code>null</code> if a answer attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AnswerAttachedFile fetchByPrimaryKey(String answer_attached_id)
		throws SystemException {
		AnswerAttachedFile answerAttachedFile = (AnswerAttachedFile)EntityCacheUtil.getResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				AnswerAttachedFileImpl.class, answer_attached_id);

		if (answerAttachedFile == _nullAnswerAttachedFile) {
			return null;
		}

		if (answerAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				answerAttachedFile = (AnswerAttachedFile)session.get(AnswerAttachedFileImpl.class,
						answer_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (answerAttachedFile != null) {
					cacheResult(answerAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnswerAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						AnswerAttachedFileImpl.class, answer_attached_id,
						_nullAnswerAttachedFile);
				}

				closeSession(session);
			}
		}

		return answerAttachedFile;
	}

	/**
	 * Returns all the answer attached files.
	 *
	 * @return the answer attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnswerAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answer attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of answer attached files
	 * @param end the upper bound of the range of answer attached files (not inclusive)
	 * @return the range of answer attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnswerAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the answer attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of answer attached files
	 * @param end the upper bound of the range of answer attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answer attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<AnswerAttachedFile> findAll(int start, int end,
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

		List<AnswerAttachedFile> list = (List<AnswerAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANSWERATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWERATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AnswerAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AnswerAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the answer attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AnswerAttachedFile answerAttachedFile : findAll()) {
			remove(answerAttachedFile);
		}
	}

	/**
	 * Returns the number of answer attached files.
	 *
	 * @return the number of answer attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANSWERATTACHEDFILE);

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
	 * Initializes the answer attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.AnswerAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AnswerAttachedFile>> listenersList = new ArrayList<ModelListener<AnswerAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AnswerAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnswerAttachedFileImpl.class.getName());
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
	@BeanReference(type = InvestmentProjectsPersistence.class)
	protected InvestmentProjectsPersistence investmentProjectsPersistence;
	@BeanReference(type = OrganizationsPersistence.class)
	protected OrganizationsPersistence organizationsPersistence;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionAttachedFilePersistence.class)
	protected QuestionAttachedFilePersistence questionAttachedFilePersistence;
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
	private static final String _SQL_SELECT_ANSWERATTACHEDFILE = "SELECT answerAttachedFile FROM AnswerAttachedFile answerAttachedFile";
	private static final String _SQL_COUNT_ANSWERATTACHEDFILE = "SELECT COUNT(answerAttachedFile) FROM AnswerAttachedFile answerAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "answerAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnswerAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnswerAttachedFilePersistenceImpl.class);
	private static AnswerAttachedFile _nullAnswerAttachedFile = new AnswerAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AnswerAttachedFile> toCacheModel() {
				return _nullAnswerAttachedFileCacheModel;
			}
		};

	private static CacheModel<AnswerAttachedFile> _nullAnswerAttachedFileCacheModel =
		new CacheModel<AnswerAttachedFile>() {
			public AnswerAttachedFile toEntityModel() {
				return _nullAnswerAttachedFile;
			}
		};
}