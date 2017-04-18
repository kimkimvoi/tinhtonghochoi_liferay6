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

import com.fsoft.bn.NoSuchOrganizationsException;
import com.fsoft.bn.model.Organizations;
import com.fsoft.bn.model.impl.OrganizationsImpl;
import com.fsoft.bn.model.impl.OrganizationsModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the organizations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see OrganizationsPersistence
 * @see OrganizationsUtil
 * @generated
 */
public class OrganizationsPersistenceImpl extends BasePersistenceImpl<Organizations>
	implements OrganizationsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationsUtil} to access the organizations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DELETED = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDeleted",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED =
		new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDeleted", new String[] { Boolean.class.getName() },
			OrganizationsModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DELETED = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeleted",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByName",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByName",
			new String[] { String.class.getName(), Boolean.class.getName() },
			OrganizationsModelImpl.ORGANIZATIONS_NAME_COLUMN_BITMASK |
			OrganizationsModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED,
			OrganizationsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the organizations in the entity cache if it is enabled.
	 *
	 * @param organizations the organizations
	 */
	public void cacheResult(Organizations organizations) {
		EntityCacheUtil.putResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsImpl.class, organizations.getPrimaryKey(),
			organizations);

		organizations.resetOriginalValues();
	}

	/**
	 * Caches the organizationses in the entity cache if it is enabled.
	 *
	 * @param organizationses the organizationses
	 */
	public void cacheResult(List<Organizations> organizationses) {
		for (Organizations organizations : organizationses) {
			if (EntityCacheUtil.getResult(
						OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationsImpl.class, organizations.getPrimaryKey()) == null) {
				cacheResult(organizations);
			}
			else {
				organizations.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organizationses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organizations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Organizations organizations) {
		EntityCacheUtil.removeResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsImpl.class, organizations.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Organizations> organizationses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Organizations organizations : organizationses) {
			EntityCacheUtil.removeResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationsImpl.class, organizations.getPrimaryKey());
		}
	}

	/**
	 * Creates a new organizations with the primary key. Does not add the organizations to the database.
	 *
	 * @param organizations_id the primary key for the new organizations
	 * @return the new organizations
	 */
	public Organizations create(long organizations_id) {
		Organizations organizations = new OrganizationsImpl();

		organizations.setNew(true);
		organizations.setPrimaryKey(organizations_id);

		return organizations;
	}

	/**
	 * Removes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizations_id the primary key of the organizations
	 * @return the organizations that was removed
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations remove(long organizations_id)
		throws NoSuchOrganizationsException, SystemException {
		return remove(Long.valueOf(organizations_id));
	}

	/**
	 * Removes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organizations
	 * @return the organizations that was removed
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizations remove(Serializable primaryKey)
		throws NoSuchOrganizationsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Organizations organizations = (Organizations)session.get(OrganizationsImpl.class,
					primaryKey);

			if (organizations == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organizations);
		}
		catch (NoSuchOrganizationsException nsee) {
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
	protected Organizations removeImpl(Organizations organizations)
		throws SystemException {
		organizations = toUnwrappedModel(organizations);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, organizations);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(organizations);

		return organizations;
	}

	@Override
	public Organizations updateImpl(
		com.fsoft.bn.model.Organizations organizations, boolean merge)
		throws SystemException {
		organizations = toUnwrappedModel(organizations);

		boolean isNew = organizations.isNew();

		OrganizationsModelImpl organizationsModelImpl = (OrganizationsModelImpl)organizations;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, organizations, merge);

			organizations.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizationsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organizationsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(organizationsModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED,
					args);

				args = new Object[] {
						Boolean.valueOf(organizationsModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED,
					args);
			}

			if ((organizationsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationsModelImpl.getOriginalOrganizations_name(),
						Boolean.valueOf(organizationsModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] {
						organizationsModelImpl.getOrganizations_name(),
						Boolean.valueOf(organizationsModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationsImpl.class, organizations.getPrimaryKey(),
			organizations);

		return organizations;
	}

	protected Organizations toUnwrappedModel(Organizations organizations) {
		if (organizations instanceof OrganizationsImpl) {
			return organizations;
		}

		OrganizationsImpl organizationsImpl = new OrganizationsImpl();

		organizationsImpl.setNew(organizations.isNew());
		organizationsImpl.setPrimaryKey(organizations.getPrimaryKey());

		organizationsImpl.setOrganizations_id(organizations.getOrganizations_id());
		organizationsImpl.setOrganizations_name(organizations.getOrganizations_name());
		organizationsImpl.setOrganizations_description(organizations.getOrganizations_description());
		organizationsImpl.setOrganizations_address(organizations.getOrganizations_address());
		organizationsImpl.setDeleted(organizations.isDeleted());
		organizationsImpl.setCreateDate(organizations.getCreateDate());
		organizationsImpl.setModifiedDate(organizations.getModifiedDate());

		return organizationsImpl;
	}

	/**
	 * Returns the organizations with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizations
	 * @return the organizations
	 * @throws com.liferay.portal.NoSuchModelException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the organizations with the primary key or throws a {@link com.fsoft.bn.NoSuchOrganizationsException} if it could not be found.
	 *
	 * @param organizations_id the primary key of the organizations
	 * @return the organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations findByPrimaryKey(long organizations_id)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = fetchByPrimaryKey(organizations_id);

		if (organizations == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + organizations_id);
			}

			throw new NoSuchOrganizationsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				organizations_id);
		}

		return organizations;
	}

	/**
	 * Returns the organizations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organizations
	 * @return the organizations, or <code>null</code> if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizations fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the organizations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizations_id the primary key of the organizations
	 * @return the organizations, or <code>null</code> if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations fetchByPrimaryKey(long organizations_id)
		throws SystemException {
		Organizations organizations = (Organizations)EntityCacheUtil.getResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationsImpl.class, organizations_id);

		if (organizations == _nullOrganizations) {
			return null;
		}

		if (organizations == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				organizations = (Organizations)session.get(OrganizationsImpl.class,
						Long.valueOf(organizations_id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (organizations != null) {
					cacheResult(organizations);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OrganizationsModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationsImpl.class, organizations_id,
						_nullOrganizations);
				}

				closeSession(session);
			}
		}

		return organizations;
	}

	/**
	 * Returns all the organizationses where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByDeleted(boolean deleted)
		throws SystemException {
		return findByDeleted(deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationses where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByDeleted(boolean deleted, int start, int end)
		throws SystemException {
		return findByDeleted(deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationses where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByDeleted(boolean deleted, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED;
			finderArgs = new Object[] { deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DELETED;
			finderArgs = new Object[] { deleted, start, end, orderByComparator };
		}

		List<Organizations> list = (List<Organizations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organizations organizations : list) {
				if ((deleted != organizations.getDeleted())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ORGANIZATIONS_WHERE);

			query.append(_FINDER_COLUMN_DELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrganizationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deleted);

				list = (List<Organizations>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first organizations in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations findByDeleted_First(boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = fetchByDeleted_First(deleted,
				orderByComparator);

		if (organizations != null) {
			return organizations;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationsException(msg.toString());
	}

	/**
	 * Returns the first organizations in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations fetchByDeleted_First(boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organizations> list = findByDeleted(deleted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizations in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations findByDeleted_Last(boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = fetchByDeleted_Last(deleted,
				orderByComparator);

		if (organizations != null) {
			return organizations;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationsException(msg.toString());
	}

	/**
	 * Returns the last organizations in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations fetchByDeleted_Last(boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeleted(deleted);

		List<Organizations> list = findByDeleted(deleted, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizationses before and after the current organizations in the ordered set where deleted = &#63;.
	 *
	 * @param organizations_id the primary key of the current organizations
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations[] findByDeleted_PrevAndNext(long organizations_id,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = findByPrimaryKey(organizations_id);

		Session session = null;

		try {
			session = openSession();

			Organizations[] array = new OrganizationsImpl[3];

			array[0] = getByDeleted_PrevAndNext(session, organizations,
					deleted, orderByComparator, true);

			array[1] = organizations;

			array[2] = getByDeleted_PrevAndNext(session, organizations,
					deleted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organizations getByDeleted_PrevAndNext(Session session,
		Organizations organizations, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONS_WHERE);

		query.append(_FINDER_COLUMN_DELETED_DELETED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(OrganizationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizations);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organizations> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the organizationses where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @return the matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByName(String organizations_name,
		boolean deleted) throws SystemException {
		return findByName(organizations_name, deleted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationses where organizations_name = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByName(String organizations_name,
		boolean deleted, int start, int end) throws SystemException {
		return findByName(organizations_name, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationses where organizations_name = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findByName(String organizations_name,
		boolean deleted, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { organizations_name, deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] {
					organizations_name, deleted,
					
					start, end, orderByComparator
				};
		}

		List<Organizations> list = (List<Organizations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organizations organizations : list) {
				if (!Validator.equals(organizations_name,
							organizations.getOrganizations_name()) ||
						(deleted != organizations.getDeleted())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ORGANIZATIONS_WHERE);

			if (organizations_name == null) {
				query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_1);
			}
			else {
				if (organizations_name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_2);
				}
			}

			query.append(_FINDER_COLUMN_NAME_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(OrganizationsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (organizations_name != null) {
					qPos.add(organizations_name);
				}

				qPos.add(deleted);

				list = (List<Organizations>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations findByName_First(String organizations_name,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = fetchByName_First(organizations_name,
				deleted, orderByComparator);

		if (organizations != null) {
			return organizations;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizations_name=");
		msg.append(organizations_name);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationsException(msg.toString());
	}

	/**
	 * Returns the first organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations fetchByName_First(String organizations_name,
		boolean deleted, OrderByComparator orderByComparator)
		throws SystemException {
		List<Organizations> list = findByName(organizations_name, deleted, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations findByName_Last(String organizations_name,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = fetchByName_Last(organizations_name,
				deleted, orderByComparator);

		if (organizations != null) {
			return organizations;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizations_name=");
		msg.append(organizations_name);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationsException(msg.toString());
	}

	/**
	 * Returns the last organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations fetchByName_Last(String organizations_name,
		boolean deleted, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByName(organizations_name, deleted);

		List<Organizations> list = findByName(organizations_name, deleted,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizationses before and after the current organizations in the ordered set where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_id the primary key of the current organizations
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizations
	 * @throws com.fsoft.bn.NoSuchOrganizationsException if a organizations with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Organizations[] findByName_PrevAndNext(long organizations_id,
		String organizations_name, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationsException, SystemException {
		Organizations organizations = findByPrimaryKey(organizations_id);

		Session session = null;

		try {
			session = openSession();

			Organizations[] array = new OrganizationsImpl[3];

			array[0] = getByName_PrevAndNext(session, organizations,
					organizations_name, deleted, orderByComparator, true);

			array[1] = organizations;

			array[2] = getByName_PrevAndNext(session, organizations,
					organizations_name, deleted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organizations getByName_PrevAndNext(Session session,
		Organizations organizations, String organizations_name,
		boolean deleted, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATIONS_WHERE);

		if (organizations_name == null) {
			query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_1);
		}
		else {
			if (organizations_name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_2);
			}
		}

		query.append(_FINDER_COLUMN_NAME_DELETED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(OrganizationsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (organizations_name != null) {
			qPos.add(organizations_name);
		}

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organizations);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organizations> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the organizationses.
	 *
	 * @return the organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Organizations> findAll(int start, int end,
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

		List<Organizations> list = (List<Organizations>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATIONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATIONS.concat(OrganizationsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Organizations>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Organizations>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the organizationses where deleted = &#63; from the database.
	 *
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDeleted(boolean deleted) throws SystemException {
		for (Organizations organizations : findByDeleted(deleted)) {
			remove(organizations);
		}
	}

	/**
	 * Removes all the organizationses where organizations_name = &#63; and deleted = &#63; from the database.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String organizations_name, boolean deleted)
		throws SystemException {
		for (Organizations organizations : findByName(organizations_name,
				deleted)) {
			remove(organizations);
		}
	}

	/**
	 * Removes all the organizationses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Organizations organizations : findAll()) {
			remove(organizations);
		}
	}

	/**
	 * Returns the number of organizationses where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the number of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDeleted(boolean deleted) throws SystemException {
		Object[] finderArgs = new Object[] { deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DELETED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATIONS_WHERE);

			query.append(_FINDER_COLUMN_DELETED_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deleted);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DELETED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of organizationses where organizations_name = &#63; and deleted = &#63;.
	 *
	 * @param organizations_name the organizations_name
	 * @param deleted the deleted
	 * @return the number of matching organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String organizations_name, boolean deleted)
		throws SystemException {
		Object[] finderArgs = new Object[] { organizations_name, deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATIONS_WHERE);

			if (organizations_name == null) {
				query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_1);
			}
			else {
				if (organizations_name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_2);
				}
			}

			query.append(_FINDER_COLUMN_NAME_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (organizations_name != null) {
					qPos.add(organizations_name);
				}

				qPos.add(deleted);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of organizationses.
	 *
	 * @return the number of organizationses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATIONS);

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
	 * Initializes the organizations persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Organizations")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Organizations>> listenersList = new ArrayList<ModelListener<Organizations>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Organizations>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationsImpl.class.getName());
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
	private static final String _SQL_SELECT_ORGANIZATIONS = "SELECT organizations FROM Organizations organizations";
	private static final String _SQL_SELECT_ORGANIZATIONS_WHERE = "SELECT organizations FROM Organizations organizations WHERE ";
	private static final String _SQL_COUNT_ORGANIZATIONS = "SELECT COUNT(organizations) FROM Organizations organizations";
	private static final String _SQL_COUNT_ORGANIZATIONS_WHERE = "SELECT COUNT(organizations) FROM Organizations organizations WHERE ";
	private static final String _FINDER_COLUMN_DELETED_DELETED_2 = "organizations.deleted = ?";
	private static final String _FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_1 = "organizations.organizations_name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_2 = "organizations.organizations_name = ? AND ";
	private static final String _FINDER_COLUMN_NAME_ORGANIZATIONS_NAME_3 = "(organizations.organizations_name IS NULL OR organizations.organizations_name = ?) AND ";
	private static final String _FINDER_COLUMN_NAME_DELETED_2 = "organizations.deleted = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organizations.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Organizations exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Organizations exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationsPersistenceImpl.class);
	private static Organizations _nullOrganizations = new OrganizationsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Organizations> toCacheModel() {
				return _nullOrganizationsCacheModel;
			}
		};

	private static CacheModel<Organizations> _nullOrganizationsCacheModel = new CacheModel<Organizations>() {
			public Organizations toEntityModel() {
				return _nullOrganizations;
			}
		};
}