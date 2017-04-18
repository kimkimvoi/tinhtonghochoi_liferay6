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

import com.fsoft.bn.NoSuchUserfulContactPhoneException;
import com.fsoft.bn.model.UserfulContactPhone;
import com.fsoft.bn.model.impl.UserfulContactPhoneImpl;
import com.fsoft.bn.model.impl.UserfulContactPhoneModelImpl;

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
 * The persistence implementation for the userful contact phone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see UserfulContactPhonePersistence
 * @see UserfulContactPhoneUtil
 * @generated
 */
public class UserfulContactPhonePersistenceImpl extends BasePersistenceImpl<UserfulContactPhone>
	implements UserfulContactPhonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserfulContactPhoneUtil} to access the userful contact phone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserfulContactPhoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneModelImpl.FINDER_CACHE_ENABLED,
			UserfulContactPhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneModelImpl.FINDER_CACHE_ENABLED,
			UserfulContactPhoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the userful contact phone in the entity cache if it is enabled.
	 *
	 * @param userfulContactPhone the userful contact phone
	 */
	public void cacheResult(UserfulContactPhone userfulContactPhone) {
		EntityCacheUtil.putResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneImpl.class, userfulContactPhone.getPrimaryKey(),
			userfulContactPhone);

		userfulContactPhone.resetOriginalValues();
	}

	/**
	 * Caches the userful contact phones in the entity cache if it is enabled.
	 *
	 * @param userfulContactPhones the userful contact phones
	 */
	public void cacheResult(List<UserfulContactPhone> userfulContactPhones) {
		for (UserfulContactPhone userfulContactPhone : userfulContactPhones) {
			if (EntityCacheUtil.getResult(
						UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
						UserfulContactPhoneImpl.class,
						userfulContactPhone.getPrimaryKey()) == null) {
				cacheResult(userfulContactPhone);
			}
			else {
				userfulContactPhone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all userful contact phones.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserfulContactPhoneImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserfulContactPhoneImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the userful contact phone.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserfulContactPhone userfulContactPhone) {
		EntityCacheUtil.removeResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneImpl.class, userfulContactPhone.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserfulContactPhone> userfulContactPhones) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserfulContactPhone userfulContactPhone : userfulContactPhones) {
			EntityCacheUtil.removeResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
				UserfulContactPhoneImpl.class,
				userfulContactPhone.getPrimaryKey());
		}
	}

	/**
	 * Creates a new userful contact phone with the primary key. Does not add the userful contact phone to the database.
	 *
	 * @param userful_contact_phone_id the primary key for the new userful contact phone
	 * @return the new userful contact phone
	 */
	public UserfulContactPhone create(String userful_contact_phone_id) {
		UserfulContactPhone userfulContactPhone = new UserfulContactPhoneImpl();

		userfulContactPhone.setNew(true);
		userfulContactPhone.setPrimaryKey(userful_contact_phone_id);

		return userfulContactPhone;
	}

	/**
	 * Removes the userful contact phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userful_contact_phone_id the primary key of the userful contact phone
	 * @return the userful contact phone that was removed
	 * @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserfulContactPhone remove(String userful_contact_phone_id)
		throws NoSuchUserfulContactPhoneException, SystemException {
		return remove((Serializable)userful_contact_phone_id);
	}

	/**
	 * Removes the userful contact phone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the userful contact phone
	 * @return the userful contact phone that was removed
	 * @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserfulContactPhone remove(Serializable primaryKey)
		throws NoSuchUserfulContactPhoneException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserfulContactPhone userfulContactPhone = (UserfulContactPhone)session.get(UserfulContactPhoneImpl.class,
					primaryKey);

			if (userfulContactPhone == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserfulContactPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userfulContactPhone);
		}
		catch (NoSuchUserfulContactPhoneException nsee) {
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
	protected UserfulContactPhone removeImpl(
		UserfulContactPhone userfulContactPhone) throws SystemException {
		userfulContactPhone = toUnwrappedModel(userfulContactPhone);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userfulContactPhone);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userfulContactPhone);

		return userfulContactPhone;
	}

	@Override
	public UserfulContactPhone updateImpl(
		com.fsoft.bn.model.UserfulContactPhone userfulContactPhone,
		boolean merge) throws SystemException {
		userfulContactPhone = toUnwrappedModel(userfulContactPhone);

		boolean isNew = userfulContactPhone.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userfulContactPhone, merge);

			userfulContactPhone.setNew(false);
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

		EntityCacheUtil.putResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
			UserfulContactPhoneImpl.class, userfulContactPhone.getPrimaryKey(),
			userfulContactPhone);

		return userfulContactPhone;
	}

	protected UserfulContactPhone toUnwrappedModel(
		UserfulContactPhone userfulContactPhone) {
		if (userfulContactPhone instanceof UserfulContactPhoneImpl) {
			return userfulContactPhone;
		}

		UserfulContactPhoneImpl userfulContactPhoneImpl = new UserfulContactPhoneImpl();

		userfulContactPhoneImpl.setNew(userfulContactPhone.isNew());
		userfulContactPhoneImpl.setPrimaryKey(userfulContactPhone.getPrimaryKey());

		userfulContactPhoneImpl.setUserful_contact_phone_id(userfulContactPhone.getUserful_contact_phone_id());
		userfulContactPhoneImpl.setUserful_contact_name(userfulContactPhone.getUserful_contact_name());
		userfulContactPhoneImpl.setUserful_contact_phone(userfulContactPhone.getUserful_contact_phone());
		userfulContactPhoneImpl.setUserful_contact_email(userfulContactPhone.getUserful_contact_email());
		userfulContactPhoneImpl.setUserful_contact_position(userfulContactPhone.getUserful_contact_position());
		userfulContactPhoneImpl.setUserful_contact_address(userfulContactPhone.getUserful_contact_address());
		userfulContactPhoneImpl.setCreated_date(userfulContactPhone.getCreated_date());
		userfulContactPhoneImpl.setModified_date(userfulContactPhone.getModified_date());
		userfulContactPhoneImpl.setDeleted(userfulContactPhone.isDeleted());

		return userfulContactPhoneImpl;
	}

	/**
	 * Returns the userful contact phone with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the userful contact phone
	 * @return the userful contact phone
	 * @throws com.liferay.portal.NoSuchModelException if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserfulContactPhone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the userful contact phone with the primary key or throws a {@link com.fsoft.bn.NoSuchUserfulContactPhoneException} if it could not be found.
	 *
	 * @param userful_contact_phone_id the primary key of the userful contact phone
	 * @return the userful contact phone
	 * @throws com.fsoft.bn.NoSuchUserfulContactPhoneException if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserfulContactPhone findByPrimaryKey(String userful_contact_phone_id)
		throws NoSuchUserfulContactPhoneException, SystemException {
		UserfulContactPhone userfulContactPhone = fetchByPrimaryKey(userful_contact_phone_id);

		if (userfulContactPhone == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					userful_contact_phone_id);
			}

			throw new NoSuchUserfulContactPhoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userful_contact_phone_id);
		}

		return userfulContactPhone;
	}

	/**
	 * Returns the userful contact phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the userful contact phone
	 * @return the userful contact phone, or <code>null</code> if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserfulContactPhone fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the userful contact phone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userful_contact_phone_id the primary key of the userful contact phone
	 * @return the userful contact phone, or <code>null</code> if a userful contact phone with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserfulContactPhone fetchByPrimaryKey(
		String userful_contact_phone_id) throws SystemException {
		UserfulContactPhone userfulContactPhone = (UserfulContactPhone)EntityCacheUtil.getResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
				UserfulContactPhoneImpl.class, userful_contact_phone_id);

		if (userfulContactPhone == _nullUserfulContactPhone) {
			return null;
		}

		if (userfulContactPhone == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userfulContactPhone = (UserfulContactPhone)session.get(UserfulContactPhoneImpl.class,
						userful_contact_phone_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userfulContactPhone != null) {
					cacheResult(userfulContactPhone);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserfulContactPhoneModelImpl.ENTITY_CACHE_ENABLED,
						UserfulContactPhoneImpl.class,
						userful_contact_phone_id, _nullUserfulContactPhone);
				}

				closeSession(session);
			}
		}

		return userfulContactPhone;
	}

	/**
	 * Returns all the userful contact phones.
	 *
	 * @return the userful contact phones
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserfulContactPhone> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the userful contact phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of userful contact phones
	 * @param end the upper bound of the range of userful contact phones (not inclusive)
	 * @return the range of userful contact phones
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserfulContactPhone> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the userful contact phones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of userful contact phones
	 * @param end the upper bound of the range of userful contact phones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of userful contact phones
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserfulContactPhone> findAll(int start, int end,
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

		List<UserfulContactPhone> list = (List<UserfulContactPhone>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERFULCONTACTPHONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERFULCONTACTPHONE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserfulContactPhone>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserfulContactPhone>)QueryUtil.list(q,
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
	 * Removes all the userful contact phones from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserfulContactPhone userfulContactPhone : findAll()) {
			remove(userfulContactPhone);
		}
	}

	/**
	 * Returns the number of userful contact phones.
	 *
	 * @return the number of userful contact phones
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERFULCONTACTPHONE);

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
	 * Initializes the userful contact phone persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.UserfulContactPhone")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserfulContactPhone>> listenersList = new ArrayList<ModelListener<UserfulContactPhone>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserfulContactPhone>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserfulContactPhoneImpl.class.getName());
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
	private static final String _SQL_SELECT_USERFULCONTACTPHONE = "SELECT userfulContactPhone FROM UserfulContactPhone userfulContactPhone";
	private static final String _SQL_COUNT_USERFULCONTACTPHONE = "SELECT COUNT(userfulContactPhone) FROM UserfulContactPhone userfulContactPhone";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userfulContactPhone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserfulContactPhone exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserfulContactPhonePersistenceImpl.class);
	private static UserfulContactPhone _nullUserfulContactPhone = new UserfulContactPhoneImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserfulContactPhone> toCacheModel() {
				return _nullUserfulContactPhoneCacheModel;
			}
		};

	private static CacheModel<UserfulContactPhone> _nullUserfulContactPhoneCacheModel =
		new CacheModel<UserfulContactPhone>() {
			public UserfulContactPhone toEntityModel() {
				return _nullUserfulContactPhone;
			}
		};
}