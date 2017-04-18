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

import com.fsoft.bn.NoSuchStaffInfoException;
import com.fsoft.bn.model.StaffInfo;
import com.fsoft.bn.model.impl.StaffInfoImpl;
import com.fsoft.bn.model.impl.StaffInfoModelImpl;

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
 * The persistence implementation for the staff info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see StaffInfoPersistence
 * @see StaffInfoUtil
 * @generated
 */
public class StaffInfoPersistenceImpl extends BasePersistenceImpl<StaffInfo>
	implements StaffInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StaffInfoUtil} to access the staff info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StaffInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DELETED = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeleted",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED =
		new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeleted",
			new String[] { Boolean.class.getName() },
			StaffInfoModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DELETED = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeleted",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			StaffInfoModelImpl.STAFF_FIRSTNAME_COLUMN_BITMASK |
			StaffInfoModelImpl.STAFF_MIDDLENAME_COLUMN_BITMASK |
			StaffInfoModelImpl.STAFF_LASTNAME_COLUMN_BITMASK |
			StaffInfoModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
			new String[] { String.class.getName(), Boolean.class.getName() },
			StaffInfoModelImpl.STAFF_EMAIL_COLUMN_BITMASK |
			StaffInfoModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRole",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRole",
			new String[] { String.class.getName(), Boolean.class.getName() },
			StaffInfoModelImpl.STAFF_ROLE_COLUMN_BITMASK |
			StaffInfoModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRole",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPhone",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPhone",
			new String[] { String.class.getName(), Boolean.class.getName() },
			StaffInfoModelImpl.STAFF_PHONE_COLUMN_BITMASK |
			StaffInfoModelImpl.DELETED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PHONE = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPhone",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, StaffInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the staff info in the entity cache if it is enabled.
	 *
	 * @param staffInfo the staff info
	 */
	public void cacheResult(StaffInfo staffInfo) {
		EntityCacheUtil.putResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoImpl.class, staffInfo.getPrimaryKey(), staffInfo);

		staffInfo.resetOriginalValues();
	}

	/**
	 * Caches the staff infos in the entity cache if it is enabled.
	 *
	 * @param staffInfos the staff infos
	 */
	public void cacheResult(List<StaffInfo> staffInfos) {
		for (StaffInfo staffInfo : staffInfos) {
			if (EntityCacheUtil.getResult(
						StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
						StaffInfoImpl.class, staffInfo.getPrimaryKey()) == null) {
				cacheResult(staffInfo);
			}
			else {
				staffInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all staff infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StaffInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StaffInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the staff info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StaffInfo staffInfo) {
		EntityCacheUtil.removeResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoImpl.class, staffInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StaffInfo> staffInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StaffInfo staffInfo : staffInfos) {
			EntityCacheUtil.removeResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
				StaffInfoImpl.class, staffInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new staff info with the primary key. Does not add the staff info to the database.
	 *
	 * @param staff_id the primary key for the new staff info
	 * @return the new staff info
	 */
	public StaffInfo create(long staff_id) {
		StaffInfo staffInfo = new StaffInfoImpl();

		staffInfo.setNew(true);
		staffInfo.setPrimaryKey(staff_id);

		return staffInfo;
	}

	/**
	 * Removes the staff info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param staff_id the primary key of the staff info
	 * @return the staff info that was removed
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo remove(long staff_id)
		throws NoSuchStaffInfoException, SystemException {
		return remove(Long.valueOf(staff_id));
	}

	/**
	 * Removes the staff info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the staff info
	 * @return the staff info that was removed
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StaffInfo remove(Serializable primaryKey)
		throws NoSuchStaffInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StaffInfo staffInfo = (StaffInfo)session.get(StaffInfoImpl.class,
					primaryKey);

			if (staffInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStaffInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(staffInfo);
		}
		catch (NoSuchStaffInfoException nsee) {
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
	protected StaffInfo removeImpl(StaffInfo staffInfo)
		throws SystemException {
		staffInfo = toUnwrappedModel(staffInfo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, staffInfo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(staffInfo);

		return staffInfo;
	}

	@Override
	public StaffInfo updateImpl(com.fsoft.bn.model.StaffInfo staffInfo,
		boolean merge) throws SystemException {
		staffInfo = toUnwrappedModel(staffInfo);

		boolean isNew = staffInfo.isNew();

		StaffInfoModelImpl staffInfoModelImpl = (StaffInfoModelImpl)staffInfo;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, staffInfo, merge);

			staffInfo.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StaffInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((staffInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(staffInfoModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED,
					args);

				args = new Object[] {
						Boolean.valueOf(staffInfoModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETED,
					args);
			}

			if ((staffInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						staffInfoModelImpl.getOriginalStaff_firstname(),
						
						staffInfoModelImpl.getOriginalStaff_middlename(),
						
						staffInfoModelImpl.getOriginalStaff_lastname(),
						Boolean.valueOf(staffInfoModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] {
						staffInfoModelImpl.getStaff_firstname(),
						
						staffInfoModelImpl.getStaff_middlename(),
						
						staffInfoModelImpl.getStaff_lastname(),
						Boolean.valueOf(staffInfoModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((staffInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						staffInfoModelImpl.getOriginalStaff_email(),
						Boolean.valueOf(staffInfoModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] {
						staffInfoModelImpl.getStaff_email(),
						Boolean.valueOf(staffInfoModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((staffInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						staffInfoModelImpl.getOriginalStaff_role(),
						Boolean.valueOf(staffInfoModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLE,
					args);

				args = new Object[] {
						staffInfoModelImpl.getStaff_role(),
						Boolean.valueOf(staffInfoModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLE,
					args);
			}

			if ((staffInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						staffInfoModelImpl.getOriginalStaff_phone(),
						Boolean.valueOf(staffInfoModelImpl.getOriginalDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONE,
					args);

				args = new Object[] {
						staffInfoModelImpl.getStaff_phone(),
						Boolean.valueOf(staffInfoModelImpl.getDeleted())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PHONE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONE,
					args);
			}
		}

		EntityCacheUtil.putResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
			StaffInfoImpl.class, staffInfo.getPrimaryKey(), staffInfo);

		return staffInfo;
	}

	protected StaffInfo toUnwrappedModel(StaffInfo staffInfo) {
		if (staffInfo instanceof StaffInfoImpl) {
			return staffInfo;
		}

		StaffInfoImpl staffInfoImpl = new StaffInfoImpl();

		staffInfoImpl.setNew(staffInfo.isNew());
		staffInfoImpl.setPrimaryKey(staffInfo.getPrimaryKey());

		staffInfoImpl.setStaff_id(staffInfo.getStaff_id());
		staffInfoImpl.setStaff_firstname(staffInfo.getStaff_firstname());
		staffInfoImpl.setStaff_middlename(staffInfo.getStaff_middlename());
		staffInfoImpl.setStaff_lastname(staffInfo.getStaff_lastname());
		staffInfoImpl.setStaff_birthday(staffInfo.getStaff_birthday());
		staffInfoImpl.setStaff_phone(staffInfo.getStaff_phone());
		staffInfoImpl.setStaff_email(staffInfo.getStaff_email());
		staffInfoImpl.setStaff_sex(staffInfo.getStaff_sex());
		staffInfoImpl.setStaff_role(staffInfo.getStaff_role());
		staffInfoImpl.setDeleted(staffInfo.isDeleted());
		staffInfoImpl.setCreateDate(staffInfo.getCreateDate());
		staffInfoImpl.setModifiedDate(staffInfo.getModifiedDate());
		staffInfoImpl.setOrganizations_id(staffInfo.getOrganizations_id());

		return staffInfoImpl;
	}

	/**
	 * Returns the staff info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff info
	 * @return the staff info
	 * @throws com.liferay.portal.NoSuchModelException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StaffInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the staff info with the primary key or throws a {@link com.fsoft.bn.NoSuchStaffInfoException} if it could not be found.
	 *
	 * @param staff_id the primary key of the staff info
	 * @return the staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByPrimaryKey(long staff_id)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByPrimaryKey(staff_id);

		if (staffInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + staff_id);
			}

			throw new NoSuchStaffInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				staff_id);
		}

		return staffInfo;
	}

	/**
	 * Returns the staff info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the staff info
	 * @return the staff info, or <code>null</code> if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StaffInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the staff info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param staff_id the primary key of the staff info
	 * @return the staff info, or <code>null</code> if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByPrimaryKey(long staff_id) throws SystemException {
		StaffInfo staffInfo = (StaffInfo)EntityCacheUtil.getResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
				StaffInfoImpl.class, staff_id);

		if (staffInfo == _nullStaffInfo) {
			return null;
		}

		if (staffInfo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				staffInfo = (StaffInfo)session.get(StaffInfoImpl.class,
						Long.valueOf(staff_id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (staffInfo != null) {
					cacheResult(staffInfo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StaffInfoModelImpl.ENTITY_CACHE_ENABLED,
						StaffInfoImpl.class, staff_id, _nullStaffInfo);
				}

				closeSession(session);
			}
		}

		return staffInfo;
	}

	/**
	 * Returns all the staff infos where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByDeleted(boolean deleted)
		throws SystemException {
		return findByDeleted(deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByDeleted(boolean deleted, int start, int end)
		throws SystemException {
		return findByDeleted(deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByDeleted(boolean deleted, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StaffInfo staffInfo : list) {
				if ((deleted != staffInfo.getDeleted())) {
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

			query.append(_SQL_SELECT_STAFFINFO_WHERE);

			query.append(_FINDER_COLUMN_DELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deleted);

				list = (List<StaffInfo>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first staff info in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByDeleted_First(boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByDeleted_First(deleted, orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the first staff info in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByDeleted_First(boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<StaffInfo> list = findByDeleted(deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staff info in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByDeleted_Last(boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByDeleted_Last(deleted, orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the last staff info in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByDeleted_Last(boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeleted(deleted);

		List<StaffInfo> list = findByDeleted(deleted, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staff infos before and after the current staff info in the ordered set where deleted = &#63;.
	 *
	 * @param staff_id the primary key of the current staff info
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo[] findByDeleted_PrevAndNext(long staff_id,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = findByPrimaryKey(staff_id);

		Session session = null;

		try {
			session = openSession();

			StaffInfo[] array = new StaffInfoImpl[3];

			array[0] = getByDeleted_PrevAndNext(session, staffInfo, deleted,
					orderByComparator, true);

			array[1] = staffInfo;

			array[2] = getByDeleted_PrevAndNext(session, staffInfo, deleted,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StaffInfo getByDeleted_PrevAndNext(Session session,
		StaffInfo staffInfo, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STAFFINFO_WHERE);

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
			query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(staffInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StaffInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @return the matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByName(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted)
		throws SystemException {
		return findByName(staff_firstname, staff_middlename, staff_lastname,
			deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByName(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		int start, int end) throws SystemException {
		return findByName(staff_firstname, staff_middlename, staff_lastname,
			deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByName(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] {
					staff_firstname, staff_middlename, staff_lastname, deleted
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] {
					staff_firstname, staff_middlename, staff_lastname, deleted,
					
					start, end, orderByComparator
				};
		}

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StaffInfo staffInfo : list) {
				if (!Validator.equals(staff_firstname,
							staffInfo.getStaff_firstname()) ||
						!Validator.equals(staff_middlename,
							staffInfo.getStaff_middlename()) ||
						!Validator.equals(staff_lastname,
							staffInfo.getStaff_lastname()) ||
						(deleted != staffInfo.getDeleted())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_STAFFINFO_WHERE);

			if (staff_firstname == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_1);
			}
			else {
				if (staff_firstname.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_2);
				}
			}

			if (staff_middlename == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_1);
			}
			else {
				if (staff_middlename.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_2);
				}
			}

			if (staff_lastname == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_1);
			}
			else {
				if (staff_lastname.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_2);
				}
			}

			query.append(_FINDER_COLUMN_NAME_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_firstname != null) {
					qPos.add(staff_firstname);
				}

				if (staff_middlename != null) {
					qPos.add(staff_middlename);
				}

				if (staff_lastname != null) {
					qPos.add(staff_lastname);
				}

				qPos.add(deleted);

				list = (List<StaffInfo>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByName_First(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByName_First(staff_firstname,
				staff_middlename, staff_lastname, deleted, orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_firstname=");
		msg.append(staff_firstname);

		msg.append(", staff_middlename=");
		msg.append(staff_middlename);

		msg.append(", staff_lastname=");
		msg.append(staff_lastname);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the first staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByName_First(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<StaffInfo> list = findByName(staff_firstname, staff_middlename,
				staff_lastname, deleted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByName_Last(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByName_Last(staff_firstname,
				staff_middlename, staff_lastname, deleted, orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_firstname=");
		msg.append(staff_firstname);

		msg.append(", staff_middlename=");
		msg.append(staff_middlename);

		msg.append(", staff_lastname=");
		msg.append(staff_lastname);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the last staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByName_Last(String staff_firstname,
		String staff_middlename, String staff_lastname, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(staff_firstname, staff_middlename,
				staff_lastname, deleted);

		List<StaffInfo> list = findByName(staff_firstname, staff_middlename,
				staff_lastname, deleted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staff infos before and after the current staff info in the ordered set where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_id the primary key of the current staff info
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo[] findByName_PrevAndNext(long staff_id,
		String staff_firstname, String staff_middlename, String staff_lastname,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = findByPrimaryKey(staff_id);

		Session session = null;

		try {
			session = openSession();

			StaffInfo[] array = new StaffInfoImpl[3];

			array[0] = getByName_PrevAndNext(session, staffInfo,
					staff_firstname, staff_middlename, staff_lastname, deleted,
					orderByComparator, true);

			array[1] = staffInfo;

			array[2] = getByName_PrevAndNext(session, staffInfo,
					staff_firstname, staff_middlename, staff_lastname, deleted,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StaffInfo getByName_PrevAndNext(Session session,
		StaffInfo staffInfo, String staff_firstname, String staff_middlename,
		String staff_lastname, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STAFFINFO_WHERE);

		if (staff_firstname == null) {
			query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_1);
		}
		else {
			if (staff_firstname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_2);
			}
		}

		if (staff_middlename == null) {
			query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_1);
		}
		else {
			if (staff_middlename.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_2);
			}
		}

		if (staff_lastname == null) {
			query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_1);
		}
		else {
			if (staff_lastname.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_2);
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
			query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (staff_firstname != null) {
			qPos.add(staff_firstname);
		}

		if (staff_middlename != null) {
			qPos.add(staff_middlename);
		}

		if (staff_lastname != null) {
			qPos.add(staff_lastname);
		}

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(staffInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StaffInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the staff infos where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @return the matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByEmail(String staff_email, boolean deleted)
		throws SystemException {
		return findByEmail(staff_email, deleted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos where staff_email = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByEmail(String staff_email, boolean deleted,
		int start, int end) throws SystemException {
		return findByEmail(staff_email, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos where staff_email = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByEmail(String staff_email, boolean deleted,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { staff_email, deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] {
					staff_email, deleted,
					
					start, end, orderByComparator
				};
		}

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StaffInfo staffInfo : list) {
				if (!Validator.equals(staff_email, staffInfo.getStaff_email()) ||
						(deleted != staffInfo.getDeleted())) {
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

			query.append(_SQL_SELECT_STAFFINFO_WHERE);

			if (staff_email == null) {
				query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_1);
			}
			else {
				if (staff_email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_2);
				}
			}

			query.append(_FINDER_COLUMN_EMAIL_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_email != null) {
					qPos.add(staff_email);
				}

				qPos.add(deleted);

				list = (List<StaffInfo>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByEmail_First(String staff_email, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByEmail_First(staff_email, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_email=");
		msg.append(staff_email);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the first staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByEmail_First(String staff_email, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<StaffInfo> list = findByEmail(staff_email, deleted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByEmail_Last(String staff_email, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByEmail_Last(staff_email, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_email=");
		msg.append(staff_email);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the last staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByEmail_Last(String staff_email, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmail(staff_email, deleted);

		List<StaffInfo> list = findByEmail(staff_email, deleted, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staff infos before and after the current staff info in the ordered set where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_id the primary key of the current staff info
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo[] findByEmail_PrevAndNext(long staff_id,
		String staff_email, boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = findByPrimaryKey(staff_id);

		Session session = null;

		try {
			session = openSession();

			StaffInfo[] array = new StaffInfoImpl[3];

			array[0] = getByEmail_PrevAndNext(session, staffInfo, staff_email,
					deleted, orderByComparator, true);

			array[1] = staffInfo;

			array[2] = getByEmail_PrevAndNext(session, staffInfo, staff_email,
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

	protected StaffInfo getByEmail_PrevAndNext(Session session,
		StaffInfo staffInfo, String staff_email, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STAFFINFO_WHERE);

		if (staff_email == null) {
			query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_1);
		}
		else {
			if (staff_email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_2);
			}
		}

		query.append(_FINDER_COLUMN_EMAIL_DELETED_2);

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
			query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (staff_email != null) {
			qPos.add(staff_email);
		}

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(staffInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StaffInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the staff infos where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @return the matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByRole(String staff_role, boolean deleted)
		throws SystemException {
		return findByRole(staff_role, deleted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos where staff_role = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByRole(String staff_role, boolean deleted,
		int start, int end) throws SystemException {
		return findByRole(staff_role, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos where staff_role = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByRole(String staff_role, boolean deleted,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLE;
			finderArgs = new Object[] { staff_role, deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLE;
			finderArgs = new Object[] {
					staff_role, deleted,
					
					start, end, orderByComparator
				};
		}

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StaffInfo staffInfo : list) {
				if (!Validator.equals(staff_role, staffInfo.getStaff_role()) ||
						(deleted != staffInfo.getDeleted())) {
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

			query.append(_SQL_SELECT_STAFFINFO_WHERE);

			if (staff_role == null) {
				query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_1);
			}
			else {
				if (staff_role.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_2);
				}
			}

			query.append(_FINDER_COLUMN_ROLE_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_role != null) {
					qPos.add(staff_role);
				}

				qPos.add(deleted);

				list = (List<StaffInfo>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByRole_First(String staff_role, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByRole_First(staff_role, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_role=");
		msg.append(staff_role);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the first staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByRole_First(String staff_role, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<StaffInfo> list = findByRole(staff_role, deleted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByRole_Last(String staff_role, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByRole_Last(staff_role, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_role=");
		msg.append(staff_role);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the last staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByRole_Last(String staff_role, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRole(staff_role, deleted);

		List<StaffInfo> list = findByRole(staff_role, deleted, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staff infos before and after the current staff info in the ordered set where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_id the primary key of the current staff info
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo[] findByRole_PrevAndNext(long staff_id, String staff_role,
		boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = findByPrimaryKey(staff_id);

		Session session = null;

		try {
			session = openSession();

			StaffInfo[] array = new StaffInfoImpl[3];

			array[0] = getByRole_PrevAndNext(session, staffInfo, staff_role,
					deleted, orderByComparator, true);

			array[1] = staffInfo;

			array[2] = getByRole_PrevAndNext(session, staffInfo, staff_role,
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

	protected StaffInfo getByRole_PrevAndNext(Session session,
		StaffInfo staffInfo, String staff_role, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STAFFINFO_WHERE);

		if (staff_role == null) {
			query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_1);
		}
		else {
			if (staff_role.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_2);
			}
		}

		query.append(_FINDER_COLUMN_ROLE_DELETED_2);

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
			query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (staff_role != null) {
			qPos.add(staff_role);
		}

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(staffInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StaffInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the staff infos where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @return the matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByPhone(String staff_phone, boolean deleted)
		throws SystemException {
		return findByPhone(staff_phone, deleted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos where staff_phone = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByPhone(String staff_phone, boolean deleted,
		int start, int end) throws SystemException {
		return findByPhone(staff_phone, deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos where staff_phone = &#63; and deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findByPhone(String staff_phone, boolean deleted,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PHONE;
			finderArgs = new Object[] { staff_phone, deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PHONE;
			finderArgs = new Object[] {
					staff_phone, deleted,
					
					start, end, orderByComparator
				};
		}

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StaffInfo staffInfo : list) {
				if (!Validator.equals(staff_phone, staffInfo.getStaff_phone()) ||
						(deleted != staffInfo.getDeleted())) {
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

			query.append(_SQL_SELECT_STAFFINFO_WHERE);

			if (staff_phone == null) {
				query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_1);
			}
			else {
				if (staff_phone.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_2);
				}
			}

			query.append(_FINDER_COLUMN_PHONE_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_phone != null) {
					qPos.add(staff_phone);
				}

				qPos.add(deleted);

				list = (List<StaffInfo>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByPhone_First(String staff_phone, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByPhone_First(staff_phone, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_phone=");
		msg.append(staff_phone);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the first staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByPhone_First(String staff_phone, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		List<StaffInfo> list = findByPhone(staff_phone, deleted, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo findByPhone_Last(String staff_phone, boolean deleted,
		OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = fetchByPhone_Last(staff_phone, deleted,
				orderByComparator);

		if (staffInfo != null) {
			return staffInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("staff_phone=");
		msg.append(staff_phone);

		msg.append(", deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStaffInfoException(msg.toString());
	}

	/**
	 * Returns the last staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching staff info, or <code>null</code> if a matching staff info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo fetchByPhone_Last(String staff_phone, boolean deleted,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPhone(staff_phone, deleted);

		List<StaffInfo> list = findByPhone(staff_phone, deleted, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the staff infos before and after the current staff info in the ordered set where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_id the primary key of the current staff info
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next staff info
	 * @throws com.fsoft.bn.NoSuchStaffInfoException if a staff info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StaffInfo[] findByPhone_PrevAndNext(long staff_id,
		String staff_phone, boolean deleted, OrderByComparator orderByComparator)
		throws NoSuchStaffInfoException, SystemException {
		StaffInfo staffInfo = findByPrimaryKey(staff_id);

		Session session = null;

		try {
			session = openSession();

			StaffInfo[] array = new StaffInfoImpl[3];

			array[0] = getByPhone_PrevAndNext(session, staffInfo, staff_phone,
					deleted, orderByComparator, true);

			array[1] = staffInfo;

			array[2] = getByPhone_PrevAndNext(session, staffInfo, staff_phone,
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

	protected StaffInfo getByPhone_PrevAndNext(Session session,
		StaffInfo staffInfo, String staff_phone, boolean deleted,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STAFFINFO_WHERE);

		if (staff_phone == null) {
			query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_1);
		}
		else {
			if (staff_phone.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_3);
			}
			else {
				query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_2);
			}
		}

		query.append(_FINDER_COLUMN_PHONE_DELETED_2);

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
			query.append(StaffInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (staff_phone != null) {
			qPos.add(staff_phone);
		}

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(staffInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StaffInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the staff infos.
	 *
	 * @return the staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the staff infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @return the range of staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the staff infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of staff infos
	 * @param end the upper bound of the range of staff infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<StaffInfo> findAll(int start, int end,
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

		List<StaffInfo> list = (List<StaffInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STAFFINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STAFFINFO.concat(StaffInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StaffInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StaffInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the staff infos where deleted = &#63; from the database.
	 *
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDeleted(boolean deleted) throws SystemException {
		for (StaffInfo staffInfo : findByDeleted(deleted)) {
			remove(staffInfo);
		}
	}

	/**
	 * Removes all the staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63; from the database.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String staff_firstname, String staff_middlename,
		String staff_lastname, boolean deleted) throws SystemException {
		for (StaffInfo staffInfo : findByName(staff_firstname,
				staff_middlename, staff_lastname, deleted)) {
			remove(staffInfo);
		}
	}

	/**
	 * Removes all the staff infos where staff_email = &#63; and deleted = &#63; from the database.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmail(String staff_email, boolean deleted)
		throws SystemException {
		for (StaffInfo staffInfo : findByEmail(staff_email, deleted)) {
			remove(staffInfo);
		}
	}

	/**
	 * Removes all the staff infos where staff_role = &#63; and deleted = &#63; from the database.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRole(String staff_role, boolean deleted)
		throws SystemException {
		for (StaffInfo staffInfo : findByRole(staff_role, deleted)) {
			remove(staffInfo);
		}
	}

	/**
	 * Removes all the staff infos where staff_phone = &#63; and deleted = &#63; from the database.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPhone(String staff_phone, boolean deleted)
		throws SystemException {
		for (StaffInfo staffInfo : findByPhone(staff_phone, deleted)) {
			remove(staffInfo);
		}
	}

	/**
	 * Removes all the staff infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StaffInfo staffInfo : findAll()) {
			remove(staffInfo);
		}
	}

	/**
	 * Returns the number of staff infos where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the number of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDeleted(boolean deleted) throws SystemException {
		Object[] finderArgs = new Object[] { deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DELETED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STAFFINFO_WHERE);

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
	 * Returns the number of staff infos where staff_firstname = &#63; and staff_middlename = &#63; and staff_lastname = &#63; and deleted = &#63;.
	 *
	 * @param staff_firstname the staff_firstname
	 * @param staff_middlename the staff_middlename
	 * @param staff_lastname the staff_lastname
	 * @param deleted the deleted
	 * @return the number of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String staff_firstname, String staff_middlename,
		String staff_lastname, boolean deleted) throws SystemException {
		Object[] finderArgs = new Object[] {
				staff_firstname, staff_middlename, staff_lastname, deleted
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_STAFFINFO_WHERE);

			if (staff_firstname == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_1);
			}
			else {
				if (staff_firstname.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_FIRSTNAME_2);
				}
			}

			if (staff_middlename == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_1);
			}
			else {
				if (staff_middlename.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_MIDDLENAME_2);
				}
			}

			if (staff_lastname == null) {
				query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_1);
			}
			else {
				if (staff_lastname.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_STAFF_LASTNAME_2);
				}
			}

			query.append(_FINDER_COLUMN_NAME_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_firstname != null) {
					qPos.add(staff_firstname);
				}

				if (staff_middlename != null) {
					qPos.add(staff_middlename);
				}

				if (staff_lastname != null) {
					qPos.add(staff_lastname);
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
	 * Returns the number of staff infos where staff_email = &#63; and deleted = &#63;.
	 *
	 * @param staff_email the staff_email
	 * @param deleted the deleted
	 * @return the number of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmail(String staff_email, boolean deleted)
		throws SystemException {
		Object[] finderArgs = new Object[] { staff_email, deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STAFFINFO_WHERE);

			if (staff_email == null) {
				query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_1);
			}
			else {
				if (staff_email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_STAFF_EMAIL_2);
				}
			}

			query.append(_FINDER_COLUMN_EMAIL_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_email != null) {
					qPos.add(staff_email);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of staff infos where staff_role = &#63; and deleted = &#63;.
	 *
	 * @param staff_role the staff_role
	 * @param deleted the deleted
	 * @return the number of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRole(String staff_role, boolean deleted)
		throws SystemException {
		Object[] finderArgs = new Object[] { staff_role, deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STAFFINFO_WHERE);

			if (staff_role == null) {
				query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_1);
			}
			else {
				if (staff_role.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_ROLE_STAFF_ROLE_2);
				}
			}

			query.append(_FINDER_COLUMN_ROLE_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_role != null) {
					qPos.add(staff_role);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of staff infos where staff_phone = &#63; and deleted = &#63;.
	 *
	 * @param staff_phone the staff_phone
	 * @param deleted the deleted
	 * @return the number of matching staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPhone(String staff_phone, boolean deleted)
		throws SystemException {
		Object[] finderArgs = new Object[] { staff_phone, deleted };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PHONE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STAFFINFO_WHERE);

			if (staff_phone == null) {
				query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_1);
			}
			else {
				if (staff_phone.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_3);
				}
				else {
					query.append(_FINDER_COLUMN_PHONE_STAFF_PHONE_2);
				}
			}

			query.append(_FINDER_COLUMN_PHONE_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (staff_phone != null) {
					qPos.add(staff_phone);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PHONE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of staff infos.
	 *
	 * @return the number of staff infos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STAFFINFO);

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
	 * Initializes the staff info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.StaffInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StaffInfo>> listenersList = new ArrayList<ModelListener<StaffInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StaffInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StaffInfoImpl.class.getName());
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
	private static final String _SQL_SELECT_STAFFINFO = "SELECT staffInfo FROM StaffInfo staffInfo";
	private static final String _SQL_SELECT_STAFFINFO_WHERE = "SELECT staffInfo FROM StaffInfo staffInfo WHERE ";
	private static final String _SQL_COUNT_STAFFINFO = "SELECT COUNT(staffInfo) FROM StaffInfo staffInfo";
	private static final String _SQL_COUNT_STAFFINFO_WHERE = "SELECT COUNT(staffInfo) FROM StaffInfo staffInfo WHERE ";
	private static final String _FINDER_COLUMN_DELETED_DELETED_2 = "staffInfo.deleted = ?";
	private static final String _FINDER_COLUMN_NAME_STAFF_FIRSTNAME_1 = "staffInfo.staff_firstname IS NULL AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_FIRSTNAME_2 = "staffInfo.staff_firstname = ? AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_FIRSTNAME_3 = "(staffInfo.staff_firstname IS NULL OR staffInfo.staff_firstname = ?) AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_MIDDLENAME_1 = "staffInfo.staff_middlename IS NULL AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_MIDDLENAME_2 = "staffInfo.staff_middlename = ? AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_MIDDLENAME_3 = "(staffInfo.staff_middlename IS NULL OR staffInfo.staff_middlename = ?) AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_LASTNAME_1 = "staffInfo.staff_lastname IS NULL AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_LASTNAME_2 = "staffInfo.staff_lastname = ? AND ";
	private static final String _FINDER_COLUMN_NAME_STAFF_LASTNAME_3 = "(staffInfo.staff_lastname IS NULL OR staffInfo.staff_lastname = ?) AND ";
	private static final String _FINDER_COLUMN_NAME_DELETED_2 = "staffInfo.deleted = ?";
	private static final String _FINDER_COLUMN_EMAIL_STAFF_EMAIL_1 = "staffInfo.staff_email IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAIL_STAFF_EMAIL_2 = "staffInfo.staff_email = ? AND ";
	private static final String _FINDER_COLUMN_EMAIL_STAFF_EMAIL_3 = "(staffInfo.staff_email IS NULL OR staffInfo.staff_email = ?) AND ";
	private static final String _FINDER_COLUMN_EMAIL_DELETED_2 = "staffInfo.deleted = ?";
	private static final String _FINDER_COLUMN_ROLE_STAFF_ROLE_1 = "staffInfo.staff_role IS NULL AND ";
	private static final String _FINDER_COLUMN_ROLE_STAFF_ROLE_2 = "staffInfo.staff_role = ? AND ";
	private static final String _FINDER_COLUMN_ROLE_STAFF_ROLE_3 = "(staffInfo.staff_role IS NULL OR staffInfo.staff_role = ?) AND ";
	private static final String _FINDER_COLUMN_ROLE_DELETED_2 = "staffInfo.deleted = ?";
	private static final String _FINDER_COLUMN_PHONE_STAFF_PHONE_1 = "staffInfo.staff_phone IS NULL AND ";
	private static final String _FINDER_COLUMN_PHONE_STAFF_PHONE_2 = "staffInfo.staff_phone = ? AND ";
	private static final String _FINDER_COLUMN_PHONE_STAFF_PHONE_3 = "(staffInfo.staff_phone IS NULL OR staffInfo.staff_phone = ?) AND ";
	private static final String _FINDER_COLUMN_PHONE_DELETED_2 = "staffInfo.deleted = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "staffInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StaffInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StaffInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StaffInfoPersistenceImpl.class);
	private static StaffInfo _nullStaffInfo = new StaffInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StaffInfo> toCacheModel() {
				return _nullStaffInfoCacheModel;
			}
		};

	private static CacheModel<StaffInfo> _nullStaffInfoCacheModel = new CacheModel<StaffInfo>() {
			public StaffInfo toEntityModel() {
				return _nullStaffInfo;
			}
		};
}