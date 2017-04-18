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

import com.fsoft.bn.NoSuchQuestionException;
import com.fsoft.bn.model.Question;
import com.fsoft.bn.model.impl.QuestionImpl;
import com.fsoft.bn.model.impl.QuestionModelImpl;

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
 * The persistence implementation for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see QuestionPersistence
 * @see QuestionUtil
 * @generated
 */
public class QuestionPersistenceImpl extends BasePersistenceImpl<Question>
	implements QuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	public void cacheResult(Question question) {
		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		question.resetOriginalValues();
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	public void cacheResult(List<Question> questions) {
		for (Question question : questions) {
			if (EntityCacheUtil.getResult(
						QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, question.getPrimaryKey()) == null) {
				cacheResult(question);
			}
			else {
				question.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(QuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(QuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Question question) {
		EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Question> questions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Question question : questions) {
			EntityCacheUtil.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, question.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param question_id the primary key for the new question
	 * @return the new question
	 */
	public Question create(String question_id) {
		Question question = new QuestionImpl();

		question.setNew(true);
		question.setPrimaryKey(question_id);

		return question;
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param question_id the primary key of the question
	 * @return the question that was removed
	 * @throws com.fsoft.bn.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question remove(String question_id)
		throws NoSuchQuestionException, SystemException {
		return remove((Serializable)question_id);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question that was removed
	 * @throws com.fsoft.bn.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question remove(Serializable primaryKey)
		throws NoSuchQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Question question = (Question)session.get(QuestionImpl.class,
					primaryKey);

			if (question == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchQuestionException nsee) {
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
	protected Question removeImpl(Question question) throws SystemException {
		question = toUnwrappedModel(question);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, question);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(question);

		return question;
	}

	@Override
	public Question updateImpl(com.fsoft.bn.model.Question question,
		boolean merge) throws SystemException {
		question = toUnwrappedModel(question);

		boolean isNew = question.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, question, merge);

			question.setNew(false);
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

		EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		return question;
	}

	protected Question toUnwrappedModel(Question question) {
		if (question instanceof QuestionImpl) {
			return question;
		}

		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setNew(question.isNew());
		questionImpl.setPrimaryKey(question.getPrimaryKey());

		questionImpl.setQuestion_id(question.getQuestion_id());
		questionImpl.setQuestion_title(question.getQuestion_title());
		questionImpl.setQuestion_type_id(question.getQuestion_type_id());
		questionImpl.setQuestion_content(question.getQuestion_content());
		questionImpl.setCitizen_name(question.getCitizen_name());
		questionImpl.setCitizen_mail(question.getCitizen_mail());
		questionImpl.setCitizen_phone(question.getCitizen_phone());
		questionImpl.setCitizen_address(question.getCitizen_address());
		questionImpl.setQuestion_status_id(question.getQuestion_status_id());
		questionImpl.setAnswer_id(question.getAnswer_id());
		questionImpl.setCreated_date(question.getCreated_date());
		questionImpl.setModified_date(question.getModified_date());
		questionImpl.setDeleted(question.isDeleted());

		return questionImpl;
	}

	/**
	 * Returns the question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question
	 * @throws com.liferay.portal.NoSuchModelException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the question with the primary key or throws a {@link com.fsoft.bn.NoSuchQuestionException} if it could not be found.
	 *
	 * @param question_id the primary key of the question
	 * @return the question
	 * @throws com.fsoft.bn.NoSuchQuestionException if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question findByPrimaryKey(String question_id)
		throws NoSuchQuestionException, SystemException {
		Question question = fetchByPrimaryKey(question_id);

		if (question == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + question_id);
			}

			throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				question_id);
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Question fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param question_id the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Question fetchByPrimaryKey(String question_id)
		throws SystemException {
		Question question = (Question)EntityCacheUtil.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, question_id);

		if (question == _nullQuestion) {
			return null;
		}

		if (question == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				question = (Question)session.get(QuestionImpl.class, question_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (question != null) {
					cacheResult(question);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, question_id, _nullQuestion);
				}

				closeSession(session);
			}
		}

		return question;
	}

	/**
	 * Returns all the questions.
	 *
	 * @return the questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<Question> findAll(int start, int end,
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

		List<Question> list = (List<Question>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTION);

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
	 * Initializes the question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Question")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Question>> listenersList = new ArrayList<ModelListener<Question>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Question>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(QuestionImpl.class.getName());
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
	private static final String _SQL_SELECT_QUESTION = "SELECT question FROM Question question";
	private static final String _SQL_COUNT_QUESTION = "SELECT COUNT(question) FROM Question question";
	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Question exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(QuestionPersistenceImpl.class);
	private static Question _nullQuestion = new QuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Question> toCacheModel() {
				return _nullQuestionCacheModel;
			}
		};

	private static CacheModel<Question> _nullQuestionCacheModel = new CacheModel<Question>() {
			public Question toEntityModel() {
				return _nullQuestion;
			}
		};
}