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

import com.fsoft.bn.NoSuchContactException;
import com.fsoft.bn.model.BNContact;
import com.fsoft.bn.model.impl.BNContactImpl;
import com.fsoft.bn.model.impl.BNContactModelImpl;

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
 * The persistence implementation for the b n contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see BNContactPersistence
 * @see BNContactUtil
 * @generated
 */
public class BNContactPersistenceImpl extends BasePersistenceImpl<BNContact>
	implements BNContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BNContactUtil} to access the b n contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BNContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactModelImpl.FINDER_CACHE_ENABLED, BNContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactModelImpl.FINDER_CACHE_ENABLED, BNContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the b n contact in the entity cache if it is enabled.
	 *
	 * @param bnContact the b n contact
	 */
	public void cacheResult(BNContact bnContact) {
		EntityCacheUtil.putResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactImpl.class, bnContact.getPrimaryKey(), bnContact);

		bnContact.resetOriginalValues();
	}

	/**
	 * Caches the b n contacts in the entity cache if it is enabled.
	 *
	 * @param bnContacts the b n contacts
	 */
	public void cacheResult(List<BNContact> bnContacts) {
		for (BNContact bnContact : bnContacts) {
			if (EntityCacheUtil.getResult(
						BNContactModelImpl.ENTITY_CACHE_ENABLED,
						BNContactImpl.class, bnContact.getPrimaryKey()) == null) {
				cacheResult(bnContact);
			}
			else {
				bnContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all b n contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BNContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BNContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the b n contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BNContact bnContact) {
		EntityCacheUtil.removeResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactImpl.class, bnContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BNContact> bnContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BNContact bnContact : bnContacts) {
			EntityCacheUtil.removeResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
				BNContactImpl.class, bnContact.getPrimaryKey());
		}
	}

	/**
	 * Creates a new b n contact with the primary key. Does not add the b n contact to the database.
	 *
	 * @param contactId the primary key for the new b n contact
	 * @return the new b n contact
	 */
	public BNContact create(long contactId) {
		BNContact bnContact = new BNContactImpl();

		bnContact.setNew(true);
		bnContact.setPrimaryKey(contactId);

		return bnContact;
	}

	/**
	 * Removes the b n contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the b n contact
	 * @return the b n contact that was removed
	 * @throws com.fsoft.bn.NoSuchContactException if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNContact remove(long contactId)
		throws NoSuchContactException, SystemException {
		return remove(Long.valueOf(contactId));
	}

	/**
	 * Removes the b n contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the b n contact
	 * @return the b n contact that was removed
	 * @throws com.fsoft.bn.NoSuchContactException if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNContact remove(Serializable primaryKey)
		throws NoSuchContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BNContact bnContact = (BNContact)session.get(BNContactImpl.class,
					primaryKey);

			if (bnContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bnContact);
		}
		catch (NoSuchContactException nsee) {
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
	protected BNContact removeImpl(BNContact bnContact)
		throws SystemException {
		bnContact = toUnwrappedModel(bnContact);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bnContact);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bnContact);

		return bnContact;
	}

	@Override
	public BNContact updateImpl(com.fsoft.bn.model.BNContact bnContact,
		boolean merge) throws SystemException {
		bnContact = toUnwrappedModel(bnContact);

		boolean isNew = bnContact.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bnContact, merge);

			bnContact.setNew(false);
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

		EntityCacheUtil.putResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
			BNContactImpl.class, bnContact.getPrimaryKey(), bnContact);

		return bnContact;
	}

	protected BNContact toUnwrappedModel(BNContact bnContact) {
		if (bnContact instanceof BNContactImpl) {
			return bnContact;
		}

		BNContactImpl bnContactImpl = new BNContactImpl();

		bnContactImpl.setNew(bnContact.isNew());
		bnContactImpl.setPrimaryKey(bnContact.getPrimaryKey());

		bnContactImpl.setContactId(bnContact.getContactId());
		bnContactImpl.setDepartmentKey(bnContact.getDepartmentKey());
		bnContactImpl.setName(bnContact.getName());
		bnContactImpl.setRegency(bnContact.getRegency());
		bnContactImpl.setPhoneNumber(bnContact.getPhoneNumber());
		bnContactImpl.setEmail(bnContact.getEmail());
		bnContactImpl.setCreatedDate(bnContact.getCreatedDate());
		bnContactImpl.setModifiedDate(bnContact.getModifiedDate());
		bnContactImpl.setDeleted(bnContact.isDeleted());

		return bnContactImpl;
	}

	/**
	 * Returns the b n contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the b n contact
	 * @return the b n contact
	 * @throws com.liferay.portal.NoSuchModelException if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the b n contact with the primary key or throws a {@link com.fsoft.bn.NoSuchContactException} if it could not be found.
	 *
	 * @param contactId the primary key of the b n contact
	 * @return the b n contact
	 * @throws com.fsoft.bn.NoSuchContactException if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNContact findByPrimaryKey(long contactId)
		throws NoSuchContactException, SystemException {
		BNContact bnContact = fetchByPrimaryKey(contactId);

		if (bnContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
			}

			throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactId);
		}

		return bnContact;
	}

	/**
	 * Returns the b n contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the b n contact
	 * @return the b n contact, or <code>null</code> if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BNContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the b n contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the b n contact
	 * @return the b n contact, or <code>null</code> if a b n contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public BNContact fetchByPrimaryKey(long contactId)
		throws SystemException {
		BNContact bnContact = (BNContact)EntityCacheUtil.getResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
				BNContactImpl.class, contactId);

		if (bnContact == _nullBNContact) {
			return null;
		}

		if (bnContact == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bnContact = (BNContact)session.get(BNContactImpl.class,
						Long.valueOf(contactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bnContact != null) {
					cacheResult(bnContact);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BNContactModelImpl.ENTITY_CACHE_ENABLED,
						BNContactImpl.class, contactId, _nullBNContact);
				}

				closeSession(session);
			}
		}

		return bnContact;
	}

	/**
	 * Returns all the b n contacts.
	 *
	 * @return the b n contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the b n contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of b n contacts
	 * @param end the upper bound of the range of b n contacts (not inclusive)
	 * @return the range of b n contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the b n contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of b n contacts
	 * @param end the upper bound of the range of b n contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of b n contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<BNContact> findAll(int start, int end,
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

		List<BNContact> list = (List<BNContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BNCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BNCONTACT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<BNContact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<BNContact>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the b n contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (BNContact bnContact : findAll()) {
			remove(bnContact);
		}
	}

	/**
	 * Returns the number of b n contacts.
	 *
	 * @return the number of b n contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BNCONTACT);

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
	 * Initializes the b n contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.BNContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BNContact>> listenersList = new ArrayList<ModelListener<BNContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BNContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BNContactImpl.class.getName());
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
	private static final String _SQL_SELECT_BNCONTACT = "SELECT bnContact FROM BNContact bnContact";
	private static final String _SQL_COUNT_BNCONTACT = "SELECT COUNT(bnContact) FROM BNContact bnContact";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bnContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BNContact exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BNContactPersistenceImpl.class);
	private static BNContact _nullBNContact = new BNContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BNContact> toCacheModel() {
				return _nullBNContactCacheModel;
			}
		};

	private static CacheModel<BNContact> _nullBNContactCacheModel = new CacheModel<BNContact>() {
			public BNContact toEntityModel() {
				return _nullBNContact;
			}
		};
}