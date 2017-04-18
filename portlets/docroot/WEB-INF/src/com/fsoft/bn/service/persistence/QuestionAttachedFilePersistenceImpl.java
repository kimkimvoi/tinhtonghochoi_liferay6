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

import com.fsoft.bn.NoSuchQuestionAttachedFileException;
import com.fsoft.bn.model.QuestionAttachedFile;
import com.fsoft.bn.model.impl.QuestionAttachedFileImpl;
import com.fsoft.bn.model.impl.QuestionAttachedFileModelImpl;

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
 * The persistence implementation for the question attached file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see QuestionAttachedFilePersistence
 * @see QuestionAttachedFileUtil
 * @generated
 */
public class QuestionAttachedFilePersistenceImpl extends BasePersistenceImpl<QuestionAttachedFile>
	implements QuestionAttachedFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionAttachedFileUtil} to access the question attached file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionAttachedFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			QuestionAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileModelImpl.FINDER_CACHE_ENABLED,
			QuestionAttachedFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the question attached file in the entity cache if it is enabled.
	 *
	 * @param questionAttachedFile the question attached file
	 */
	public void cacheResult(QuestionAttachedFile questionAttachedFile) {
		EntityCacheUtil.putResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileImpl.class,
			questionAttachedFile.getPrimaryKey(), questionAttachedFile);

		questionAttachedFile.resetOriginalValues();
	}

	/**
	 * Caches the question attached files in the entity cache if it is enabled.
	 *
	 * @param questionAttachedFiles the question attached files
	 */
	public void cacheResult(List<QuestionAttachedFile> questionAttachedFiles) {
		for (QuestionAttachedFile questionAttachedFile : questionAttachedFiles) {
			if (EntityCacheUtil.getResult(
						QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						QuestionAttachedFileImpl.class,
						questionAttachedFile.getPrimaryKey()) == null) {
				cacheResult(questionAttachedFile);
			}
			else {
				questionAttachedFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question attached files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionAttachedFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionAttachedFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question attached file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionAttachedFile questionAttachedFile) {
		EntityCacheUtil.removeResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileImpl.class, questionAttachedFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QuestionAttachedFile> questionAttachedFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionAttachedFile questionAttachedFile : questionAttachedFiles) {
			EntityCacheUtil.removeResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				QuestionAttachedFileImpl.class,
				questionAttachedFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question attached file with the primary key. Does not add the question attached file to the database.
	 *
	 * @param question_attached_id the primary key for the new question attached file
	 * @return the new question attached file
	 */
	public QuestionAttachedFile create(String question_attached_id) {
		QuestionAttachedFile questionAttachedFile = new QuestionAttachedFileImpl();

		questionAttachedFile.setNew(true);
		questionAttachedFile.setPrimaryKey(question_attached_id);

		return questionAttachedFile;
	}

	/**
	 * Removes the question attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param question_attached_id the primary key of the question attached file
	 * @return the question attached file that was removed
	 * @throws com.fsoft.bn.NoSuchQuestionAttachedFileException if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAttachedFile remove(String question_attached_id)
		throws NoSuchQuestionAttachedFileException, SystemException {
		return remove((Serializable)question_attached_id);
	}

	/**
	 * Removes the question attached file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question attached file
	 * @return the question attached file that was removed
	 * @throws com.fsoft.bn.NoSuchQuestionAttachedFileException if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAttachedFile remove(Serializable primaryKey)
		throws NoSuchQuestionAttachedFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			QuestionAttachedFile questionAttachedFile = (QuestionAttachedFile)session.get(QuestionAttachedFileImpl.class,
					primaryKey);

			if (questionAttachedFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionAttachedFile);
		}
		catch (NoSuchQuestionAttachedFileException nsee) {
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
	protected QuestionAttachedFile removeImpl(
		QuestionAttachedFile questionAttachedFile) throws SystemException {
		questionAttachedFile = toUnwrappedModel(questionAttachedFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, questionAttachedFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(questionAttachedFile);

		return questionAttachedFile;
	}

	@Override
	public QuestionAttachedFile updateImpl(
		com.fsoft.bn.model.QuestionAttachedFile questionAttachedFile,
		boolean merge) throws SystemException {
		questionAttachedFile = toUnwrappedModel(questionAttachedFile);

		boolean isNew = questionAttachedFile.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, questionAttachedFile, merge);

			questionAttachedFile.setNew(false);
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

		EntityCacheUtil.putResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
			QuestionAttachedFileImpl.class,
			questionAttachedFile.getPrimaryKey(), questionAttachedFile);

		return questionAttachedFile;
	}

	protected QuestionAttachedFile toUnwrappedModel(
		QuestionAttachedFile questionAttachedFile) {
		if (questionAttachedFile instanceof QuestionAttachedFileImpl) {
			return questionAttachedFile;
		}

		QuestionAttachedFileImpl questionAttachedFileImpl = new QuestionAttachedFileImpl();

		questionAttachedFileImpl.setNew(questionAttachedFile.isNew());
		questionAttachedFileImpl.setPrimaryKey(questionAttachedFile.getPrimaryKey());

		questionAttachedFileImpl.setQuestion_attached_id(questionAttachedFile.getQuestion_attached_id());
		questionAttachedFileImpl.setQuestion_id(questionAttachedFile.getQuestion_id());
		questionAttachedFileImpl.setAttached_file_id(questionAttachedFile.getAttached_file_id());
		questionAttachedFileImpl.setCreated_date(questionAttachedFile.getCreated_date());
		questionAttachedFileImpl.setModified_date(questionAttachedFile.getModified_date());
		questionAttachedFileImpl.setDeleted(questionAttachedFile.isDeleted());

		return questionAttachedFileImpl;
	}

	/**
	 * Returns the question attached file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question attached file
	 * @return the question attached file
	 * @throws com.liferay.portal.NoSuchModelException if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAttachedFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the question attached file with the primary key or throws a {@link com.fsoft.bn.NoSuchQuestionAttachedFileException} if it could not be found.
	 *
	 * @param question_attached_id the primary key of the question attached file
	 * @return the question attached file
	 * @throws com.fsoft.bn.NoSuchQuestionAttachedFileException if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAttachedFile findByPrimaryKey(String question_attached_id)
		throws NoSuchQuestionAttachedFileException, SystemException {
		QuestionAttachedFile questionAttachedFile = fetchByPrimaryKey(question_attached_id);

		if (questionAttachedFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					question_attached_id);
			}

			throw new NoSuchQuestionAttachedFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				question_attached_id);
		}

		return questionAttachedFile;
	}

	/**
	 * Returns the question attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question attached file
	 * @return the question attached file, or <code>null</code> if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public QuestionAttachedFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the question attached file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param question_attached_id the primary key of the question attached file
	 * @return the question attached file, or <code>null</code> if a question attached file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public QuestionAttachedFile fetchByPrimaryKey(String question_attached_id)
		throws SystemException {
		QuestionAttachedFile questionAttachedFile = (QuestionAttachedFile)EntityCacheUtil.getResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
				QuestionAttachedFileImpl.class, question_attached_id);

		if (questionAttachedFile == _nullQuestionAttachedFile) {
			return null;
		}

		if (questionAttachedFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				questionAttachedFile = (QuestionAttachedFile)session.get(QuestionAttachedFileImpl.class,
						question_attached_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (questionAttachedFile != null) {
					cacheResult(questionAttachedFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
						QuestionAttachedFileImpl.class, question_attached_id,
						_nullQuestionAttachedFile);
				}

				closeSession(session);
			}
		}

		return questionAttachedFile;
	}

	/**
	 * Returns all the question attached files.
	 *
	 * @return the question attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAttachedFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of question attached files
	 * @param end the upper bound of the range of question attached files (not inclusive)
	 * @return the range of question attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAttachedFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the question attached files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of question attached files
	 * @param end the upper bound of the range of question attached files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of question attached files
	 * @throws SystemException if a system exception occurred
	 */
	public List<QuestionAttachedFile> findAll(int start, int end,
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

		List<QuestionAttachedFile> list = (List<QuestionAttachedFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTIONATTACHEDFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONATTACHEDFILE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<QuestionAttachedFile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<QuestionAttachedFile>)QueryUtil.list(q,
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
	 * Removes all the question attached files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (QuestionAttachedFile questionAttachedFile : findAll()) {
			remove(questionAttachedFile);
		}
	}

	/**
	 * Returns the number of question attached files.
	 *
	 * @return the number of question attached files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONATTACHEDFILE);

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
	 * Initializes the question attached file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.QuestionAttachedFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<QuestionAttachedFile>> listenersList = new ArrayList<ModelListener<QuestionAttachedFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<QuestionAttachedFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuestionAttachedFileImpl.class.getName());
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
	private static final String _SQL_SELECT_QUESTIONATTACHEDFILE = "SELECT questionAttachedFile FROM QuestionAttachedFile questionAttachedFile";
	private static final String _SQL_COUNT_QUESTIONATTACHEDFILE = "SELECT COUNT(questionAttachedFile) FROM QuestionAttachedFile questionAttachedFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionAttachedFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionAttachedFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionAttachedFilePersistenceImpl.class);
	private static QuestionAttachedFile _nullQuestionAttachedFile = new QuestionAttachedFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QuestionAttachedFile> toCacheModel() {
				return _nullQuestionAttachedFileCacheModel;
			}
		};

	private static CacheModel<QuestionAttachedFile> _nullQuestionAttachedFileCacheModel =
		new CacheModel<QuestionAttachedFile>() {
			public QuestionAttachedFile toEntityModel() {
				return _nullQuestionAttachedFile;
			}
		};
}