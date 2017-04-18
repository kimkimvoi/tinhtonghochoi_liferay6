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

import com.fsoft.bn.NoSuchNewsException;
import com.fsoft.bn.model.BNNews;
import com.fsoft.bn.model.impl.BNNewsImpl;
import com.fsoft.bn.model.impl.BNNewsModelImpl;

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
 * The persistence implementation for the b n news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see BNNewsPersistence
 * @see BNNewsUtil
 * @generated
 */
public class BNNewsPersistenceImpl extends BasePersistenceImpl<BNNews>
	implements BNNewsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BNNewsUtil} to access the b n news persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BNNewsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsModelImpl.FINDER_CACHE_ENABLED, BNNewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsModelImpl.FINDER_CACHE_ENABLED, BNNewsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the b n news in the entity cache if it is enabled.
	 *
	 * @param bnNews the b n news
	 */
	public void cacheResult(BNNews bnNews) {
		EntityCacheUtil.putResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsImpl.class, bnNews.getPrimaryKey(), bnNews);

		bnNews.resetOriginalValues();
	}

	/**
	 * Caches the b n newses in the entity cache if it is enabled.
	 *
	 * @param bnNewses the b n newses
	 */
	public void cacheResult(List<BNNews> bnNewses) {
		for (BNNews bnNews : bnNewses) {
			if (EntityCacheUtil.getResult(
						BNNewsModelImpl.ENTITY_CACHE_ENABLED, BNNewsImpl.class,
						bnNews.getPrimaryKey()) == null) {
				cacheResult(bnNews);
			}
			else {
				bnNews.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all b n newses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BNNewsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BNNewsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the b n news.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BNNews bnNews) {
		EntityCacheUtil.removeResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsImpl.class, bnNews.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BNNews> bnNewses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BNNews bnNews : bnNewses) {
			EntityCacheUtil.removeResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
				BNNewsImpl.class, bnNews.getPrimaryKey());
		}
	}

	/**
	 * Creates a new b n news with the primary key. Does not add the b n news to the database.
	 *
	 * @param newsId the primary key for the new b n news
	 * @return the new b n news
	 */
	public BNNews create(long newsId) {
		BNNews bnNews = new BNNewsImpl();

		bnNews.setNew(true);
		bnNews.setPrimaryKey(newsId);

		return bnNews;
	}

	/**
	 * Removes the b n news with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsId the primary key of the b n news
	 * @return the b n news that was removed
	 * @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNNews remove(long newsId)
		throws NoSuchNewsException, SystemException {
		return remove(Long.valueOf(newsId));
	}

	/**
	 * Removes the b n news with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the b n news
	 * @return the b n news that was removed
	 * @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNNews remove(Serializable primaryKey)
		throws NoSuchNewsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BNNews bnNews = (BNNews)session.get(BNNewsImpl.class, primaryKey);

			if (bnNews == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bnNews);
		}
		catch (NoSuchNewsException nsee) {
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
	protected BNNews removeImpl(BNNews bnNews) throws SystemException {
		bnNews = toUnwrappedModel(bnNews);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bnNews);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bnNews);

		return bnNews;
	}

	@Override
	public BNNews updateImpl(com.fsoft.bn.model.BNNews bnNews, boolean merge)
		throws SystemException {
		bnNews = toUnwrappedModel(bnNews);

		boolean isNew = bnNews.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bnNews, merge);

			bnNews.setNew(false);
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

		EntityCacheUtil.putResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
			BNNewsImpl.class, bnNews.getPrimaryKey(), bnNews);

		return bnNews;
	}

	protected BNNews toUnwrappedModel(BNNews bnNews) {
		if (bnNews instanceof BNNewsImpl) {
			return bnNews;
		}

		BNNewsImpl bnNewsImpl = new BNNewsImpl();

		bnNewsImpl.setNew(bnNews.isNew());
		bnNewsImpl.setPrimaryKey(bnNews.getPrimaryKey());

		bnNewsImpl.setNewsId(bnNews.getNewsId());
		bnNewsImpl.setNewsTitle(bnNews.getNewsTitle());
		bnNewsImpl.setNewsContent(bnNews.getNewsContent());
		bnNewsImpl.setCreatedDate(bnNews.getCreatedDate());
		bnNewsImpl.setModifiedDate(bnNews.getModifiedDate());
		bnNewsImpl.setDeleted(bnNews.isDeleted());

		return bnNewsImpl;
	}

	/**
	 * Returns the b n news with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the b n news
	 * @return the b n news
	 * @throws com.liferay.portal.NoSuchModelException if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNNews findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the b n news with the primary key or throws a {@link com.fsoft.bn.NoSuchNewsException} if it could not be found.
	 *
	 * @param newsId the primary key of the b n news
	 * @return the b n news
	 * @throws com.fsoft.bn.NoSuchNewsException if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNNews findByPrimaryKey(long newsId)
		throws NoSuchNewsException, SystemException {
		BNNews bnNews = fetchByPrimaryKey(newsId);

		if (bnNews == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + newsId);
			}

			throw new NoSuchNewsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				newsId);
		}

		return bnNews;
	}

	/**
	 * Returns the b n news with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the b n news
	 * @return the b n news, or <code>null</code> if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNNews fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the b n news with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsId the primary key of the b n news
	 * @return the b n news, or <code>null</code> if a b n news with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNNews fetchByPrimaryKey(long newsId) throws SystemException {
		BNNews bnNews = (BNNews)EntityCacheUtil.getResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
				BNNewsImpl.class, newsId);

		if (bnNews == _nullBNNews) {
			return null;
		}

		if (bnNews == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bnNews = (BNNews)session.get(BNNewsImpl.class,
						Long.valueOf(newsId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bnNews != null) {
					cacheResult(bnNews);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BNNewsModelImpl.ENTITY_CACHE_ENABLED,
						BNNewsImpl.class, newsId, _nullBNNews);
				}

				closeSession(session);
			}
		}

		return bnNews;
	}

	/**
	 * Returns all the b n newses.
	 *
	 * @return the b n newses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNNews> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the b n newses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of b n newses
	 * @param end the upper bound of the range of b n newses (not inclusive)
	 * @return the range of b n newses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNNews> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the b n newses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of b n newses
	 * @param end the upper bound of the range of b n newses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of b n newses
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNNews> findAll(int start, int end,
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

		List<BNNews> list = (List<BNNews>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BNNEWS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BNNEWS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BNNews>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BNNews>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the b n newses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BNNews bnNews : findAll()) {
			remove(bnNews);
		}
	}

	/**
	 * Returns the number of b n newses.
	 *
	 * @return the number of b n newses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BNNEWS);

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
	 * Initializes the b n news persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.BNNews")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BNNews>> listenersList = new ArrayList<ModelListener<BNNews>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BNNews>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BNNewsImpl.class.getName());
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
	private static final String _SQL_SELECT_BNNEWS = "SELECT bnNews FROM BNNews bnNews";
	private static final String _SQL_COUNT_BNNEWS = "SELECT COUNT(bnNews) FROM BNNews bnNews";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bnNews.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BNNews exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BNNewsPersistenceImpl.class);
	private static BNNews _nullBNNews = new BNNewsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BNNews> toCacheModel() {
				return _nullBNNewsCacheModel;
			}
		};

	private static CacheModel<BNNews> _nullBNNewsCacheModel = new CacheModel<BNNews>() {
			public BNNews toEntityModel() {
				return _nullBNNews;
			}
		};
}