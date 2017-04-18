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

import com.fsoft.bn.NoSuchAnswerException;
import com.fsoft.bn.model.Answer;
import com.fsoft.bn.model.impl.AnswerImpl;
import com.fsoft.bn.model.impl.AnswerModelImpl;

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
 * The persistence implementation for the answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see AnswerPersistence
 * @see AnswerUtil
 * @generated
 */
public class AnswerPersistenceImpl extends BasePersistenceImpl<Answer>
	implements AnswerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnswerUtil} to access the answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnswerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, AnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the answer in the entity cache if it is enabled.
	 *
	 * @param answer the answer
	 */
	public void cacheResult(Answer answer) {
		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		answer.resetOriginalValues();
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public void cacheResult(List<Answer> answers) {
		for (Answer answer : answers) {
			if (EntityCacheUtil.getResult(
						AnswerModelImpl.ENTITY_CACHE_ENABLED, AnswerImpl.class,
						answer.getPrimaryKey()) == null) {
				cacheResult(answer);
			}
			else {
				answer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all answers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AnswerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AnswerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the answer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Answer answer) {
		EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Answer> answers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Answer answer : answers) {
			EntityCacheUtil.removeResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new answer with the primary key. Does not add the answer to the database.
	 *
	 * @param answer_id the primary key for the new answer
	 * @return the new answer
	 */
	public Answer create(String answer_id) {
		Answer answer = new AnswerImpl();

		answer.setNew(true);
		answer.setPrimaryKey(answer_id);

		return answer;
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answer_id the primary key of the answer
	 * @return the answer that was removed
	 * @throws com.fsoft.bn.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer remove(String answer_id)
		throws NoSuchAnswerException, SystemException {
		return remove((Serializable)answer_id);
	}

	/**
	 * Removes the answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer that was removed
	 * @throws com.fsoft.bn.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer remove(Serializable primaryKey)
		throws NoSuchAnswerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Answer answer = (Answer)session.get(AnswerImpl.class, primaryKey);

			if (answer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(answer);
		}
		catch (NoSuchAnswerException nsee) {
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
	protected Answer removeImpl(Answer answer) throws SystemException {
		answer = toUnwrappedModel(answer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, answer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(answer);

		return answer;
	}

	@Override
	public Answer updateImpl(com.fsoft.bn.model.Answer answer, boolean merge)
		throws SystemException {
		answer = toUnwrappedModel(answer);

		boolean isNew = answer.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, answer, merge);

			answer.setNew(false);
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

		EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
			AnswerImpl.class, answer.getPrimaryKey(), answer);

		return answer;
	}

	protected Answer toUnwrappedModel(Answer answer) {
		if (answer instanceof AnswerImpl) {
			return answer;
		}

		AnswerImpl answerImpl = new AnswerImpl();

		answerImpl.setNew(answer.isNew());
		answerImpl.setPrimaryKey(answer.getPrimaryKey());

		answerImpl.setAnswer_id(answer.getAnswer_id());
		answerImpl.setAnswer_content(answer.getAnswer_content());
		answerImpl.setUser_id(answer.getUser_id());
		answerImpl.setCreated_date(answer.getCreated_date());
		answerImpl.setModified_date(answer.getModified_date());
		answerImpl.setDeleted(answer.isDeleted());

		return answerImpl;
	}

	/**
	 * Returns the answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer
	 * @throws com.liferay.portal.NoSuchModelException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the answer with the primary key or throws a {@link com.fsoft.bn.NoSuchAnswerException} if it could not be found.
	 *
	 * @param answer_id the primary key of the answer
	 * @return the answer
	 * @throws com.fsoft.bn.NoSuchAnswerException if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer findByPrimaryKey(String answer_id)
		throws NoSuchAnswerException, SystemException {
		Answer answer = fetchByPrimaryKey(answer_id);

		if (answer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + answer_id);
			}

			throw new NoSuchAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				answer_id);
		}

		return answer;
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Answer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answer_id the primary key of the answer
	 * @return the answer, or <code>null</code> if a answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Answer fetchByPrimaryKey(String answer_id) throws SystemException {
		Answer answer = (Answer)EntityCacheUtil.getResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
				AnswerImpl.class, answer_id);

		if (answer == _nullAnswer) {
			return null;
		}

		if (answer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				answer = (Answer)session.get(AnswerImpl.class, answer_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (answer != null) {
					cacheResult(answer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AnswerModelImpl.ENTITY_CACHE_ENABLED,
						AnswerImpl.class, answer_id, _nullAnswer);
				}

				closeSession(session);
			}
		}

		return answer;
	}

	/**
	 * Returns all the answers.
	 *
	 * @return the answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @return the range of answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers
	 * @param end the upper bound of the range of answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Answer> findAll(int start, int end,
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

		List<Answer> list = (List<Answer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ANSWER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANSWER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Answer>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the answers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Answer answer : findAll()) {
			remove(answer);
		}
	}

	/**
	 * Returns the number of answers.
	 *
	 * @return the number of answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANSWER);

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
	 * Initializes the answer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Answer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Answer>> listenersList = new ArrayList<ModelListener<Answer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Answer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AnswerImpl.class.getName());
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
	private static final String _SQL_SELECT_ANSWER = "SELECT answer FROM Answer answer";
	private static final String _SQL_COUNT_ANSWER = "SELECT COUNT(answer) FROM Answer answer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "answer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Answer exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AnswerPersistenceImpl.class);
	private static Answer _nullAnswer = new AnswerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Answer> toCacheModel() {
				return _nullAnswerCacheModel;
			}
		};

	private static CacheModel<Answer> _nullAnswerCacheModel = new CacheModel<Answer>() {
			public Answer toEntityModel() {
				return _nullAnswer;
			}
		};
}