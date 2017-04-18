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

import com.fsoft.bn.NoSuchEnrolmentException;
import com.fsoft.bn.model.Enrolment;
import com.fsoft.bn.model.impl.EnrolmentImpl;
import com.fsoft.bn.model.impl.EnrolmentModelImpl;

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
 * The persistence implementation for the enrolment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author FSOFT
 * @see EnrolmentPersistence
 * @see EnrolmentUtil
 * @generated
 */
public class EnrolmentPersistenceImpl extends BasePersistenceImpl<Enrolment>
	implements EnrolmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EnrolmentUtil} to access the enrolment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EnrolmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentModelImpl.FINDER_CACHE_ENABLED, EnrolmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentModelImpl.FINDER_CACHE_ENABLED, EnrolmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the enrolment in the entity cache if it is enabled.
	 *
	 * @param enrolment the enrolment
	 */
	public void cacheResult(Enrolment enrolment) {
		EntityCacheUtil.putResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentImpl.class, enrolment.getPrimaryKey(), enrolment);

		enrolment.resetOriginalValues();
	}

	/**
	 * Caches the enrolments in the entity cache if it is enabled.
	 *
	 * @param enrolments the enrolments
	 */
	public void cacheResult(List<Enrolment> enrolments) {
		for (Enrolment enrolment : enrolments) {
			if (EntityCacheUtil.getResult(
						EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
						EnrolmentImpl.class, enrolment.getPrimaryKey()) == null) {
				cacheResult(enrolment);
			}
			else {
				enrolment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all enrolments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EnrolmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EnrolmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the enrolment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Enrolment enrolment) {
		EntityCacheUtil.removeResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentImpl.class, enrolment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Enrolment> enrolments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Enrolment enrolment : enrolments) {
			EntityCacheUtil.removeResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
				EnrolmentImpl.class, enrolment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new enrolment with the primary key. Does not add the enrolment to the database.
	 *
	 * @param enrolment_id the primary key for the new enrolment
	 * @return the new enrolment
	 */
	public Enrolment create(String enrolment_id) {
		Enrolment enrolment = new EnrolmentImpl();

		enrolment.setNew(true);
		enrolment.setPrimaryKey(enrolment_id);

		return enrolment;
	}

	/**
	 * Removes the enrolment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param enrolment_id the primary key of the enrolment
	 * @return the enrolment that was removed
	 * @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Enrolment remove(String enrolment_id)
		throws NoSuchEnrolmentException, SystemException {
		return remove((Serializable)enrolment_id);
	}

	/**
	 * Removes the enrolment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the enrolment
	 * @return the enrolment that was removed
	 * @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enrolment remove(Serializable primaryKey)
		throws NoSuchEnrolmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Enrolment enrolment = (Enrolment)session.get(EnrolmentImpl.class,
					primaryKey);

			if (enrolment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEnrolmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(enrolment);
		}
		catch (NoSuchEnrolmentException nsee) {
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
	protected Enrolment removeImpl(Enrolment enrolment)
		throws SystemException {
		enrolment = toUnwrappedModel(enrolment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, enrolment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(enrolment);

		return enrolment;
	}

	@Override
	public Enrolment updateImpl(com.fsoft.bn.model.Enrolment enrolment,
		boolean merge) throws SystemException {
		enrolment = toUnwrappedModel(enrolment);

		boolean isNew = enrolment.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, enrolment, merge);

			enrolment.setNew(false);
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

		EntityCacheUtil.putResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
			EnrolmentImpl.class, enrolment.getPrimaryKey(), enrolment);

		return enrolment;
	}

	protected Enrolment toUnwrappedModel(Enrolment enrolment) {
		if (enrolment instanceof EnrolmentImpl) {
			return enrolment;
		}

		EnrolmentImpl enrolmentImpl = new EnrolmentImpl();

		enrolmentImpl.setNew(enrolment.isNew());
		enrolmentImpl.setPrimaryKey(enrolment.getPrimaryKey());

		enrolmentImpl.setEnrolment_id(enrolment.getEnrolment_id());
		enrolmentImpl.setHs_ten(enrolment.getHs_ten());
		enrolmentImpl.setHs_ho(enrolment.getHs_ho());
		enrolmentImpl.setHs_quoc_tich(enrolment.getHs_quoc_tich());
		enrolmentImpl.setHs_ngay_sinh(enrolment.getHs_ngay_sinh());
		enrolmentImpl.setHs_so_dien_thoai(enrolment.getHs_so_dien_thoai());
		enrolmentImpl.setHs_nguoi_lien_he(enrolment.getHs_nguoi_lien_he());
		enrolmentImpl.setHs_quan_he_voi_hoc_sinh(enrolment.getHs_quan_he_voi_hoc_sinh());
		enrolmentImpl.setHk_dia_chi(enrolment.getHk_dia_chi());
		enrolmentImpl.setHk_thanh_pho(enrolment.getHk_thanh_pho());
		enrolmentImpl.setHk_tinh(enrolment.getHk_tinh());
		enrolmentImpl.setHk_quoc_gia(enrolment.getHk_quoc_gia());
		enrolmentImpl.setCm_ten(enrolment.getCm_ten());
		enrolmentImpl.setCm_ho(enrolment.getCm_ho());
		enrolmentImpl.setCm_quan_he_voi_hoc_sinh(enrolment.getCm_quan_he_voi_hoc_sinh());
		enrolmentImpl.setCm_dia_chi_email(enrolment.getCm_dia_chi_email());
		enrolmentImpl.setCm_so_dien_thoai_di_dong(enrolment.getCm_so_dien_thoai_di_dong());
		enrolmentImpl.setCm_dien_thoai_noi_lam_viec(enrolment.getCm_dien_thoai_noi_lam_viec());
		enrolmentImpl.setCm_ten_cong_ty(enrolment.getCm_ten_cong_ty());
		enrolmentImpl.setCm_chuc_danh(enrolment.getCm_chuc_danh());
		enrolmentImpl.setK_lop(enrolment.getK_lop());
		enrolmentImpl.setK_nam_hoc(enrolment.getK_nam_hoc());
		enrolmentImpl.setK_truong_hien_dang_hoc(enrolment.getK_truong_hien_dang_hoc());
		enrolmentImpl.setK_sao_ma_biet_den(enrolment.getK_sao_ma_biet_den());
		enrolmentImpl.setK_nguoi_gioi_thieu(enrolment.getK_nguoi_gioi_thieu());
		enrolmentImpl.setK_thac_mac(enrolment.getK_thac_mac());
		enrolmentImpl.setTrang_thai(enrolment.getTrang_thai());
		enrolmentImpl.setCreated_date(enrolment.getCreated_date());
		enrolmentImpl.setModified_date(enrolment.getModified_date());
		enrolmentImpl.setDeleted(enrolment.isDeleted());

		return enrolmentImpl;
	}

	/**
	 * Returns the enrolment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrolment
	 * @return the enrolment
	 * @throws com.liferay.portal.NoSuchModelException if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enrolment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the enrolment with the primary key or throws a {@link com.fsoft.bn.NoSuchEnrolmentException} if it could not be found.
	 *
	 * @param enrolment_id the primary key of the enrolment
	 * @return the enrolment
	 * @throws com.fsoft.bn.NoSuchEnrolmentException if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Enrolment findByPrimaryKey(String enrolment_id)
		throws NoSuchEnrolmentException, SystemException {
		Enrolment enrolment = fetchByPrimaryKey(enrolment_id);

		if (enrolment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + enrolment_id);
			}

			throw new NoSuchEnrolmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				enrolment_id);
		}

		return enrolment;
	}

	/**
	 * Returns the enrolment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the enrolment
	 * @return the enrolment, or <code>null</code> if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Enrolment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the enrolment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param enrolment_id the primary key of the enrolment
	 * @return the enrolment, or <code>null</code> if a enrolment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Enrolment fetchByPrimaryKey(String enrolment_id)
		throws SystemException {
		Enrolment enrolment = (Enrolment)EntityCacheUtil.getResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
				EnrolmentImpl.class, enrolment_id);

		if (enrolment == _nullEnrolment) {
			return null;
		}

		if (enrolment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				enrolment = (Enrolment)session.get(EnrolmentImpl.class,
						enrolment_id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (enrolment != null) {
					cacheResult(enrolment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EnrolmentModelImpl.ENTITY_CACHE_ENABLED,
						EnrolmentImpl.class, enrolment_id, _nullEnrolment);
				}

				closeSession(session);
			}
		}

		return enrolment;
	}

	/**
	 * Returns all the enrolments.
	 *
	 * @return the enrolments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Enrolment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the enrolments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrolments
	 * @param end the upper bound of the range of enrolments (not inclusive)
	 * @return the range of enrolments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Enrolment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the enrolments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of enrolments
	 * @param end the upper bound of the range of enrolments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of enrolments
	 * @throws SystemException if a system exception occurred
	 */
	public List<Enrolment> findAll(int start, int end,
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

		List<Enrolment> list = (List<Enrolment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENROLMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENROLMENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Enrolment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Enrolment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the enrolments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Enrolment enrolment : findAll()) {
			remove(enrolment);
		}
	}

	/**
	 * Returns the number of enrolments.
	 *
	 * @return the number of enrolments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENROLMENT);

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
	 * Initializes the enrolment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fsoft.bn.model.Enrolment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Enrolment>> listenersList = new ArrayList<ModelListener<Enrolment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Enrolment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EnrolmentImpl.class.getName());
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
	private static final String _SQL_SELECT_ENROLMENT = "SELECT enrolment FROM Enrolment enrolment";
	private static final String _SQL_COUNT_ENROLMENT = "SELECT COUNT(enrolment) FROM Enrolment enrolment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "enrolment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Enrolment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EnrolmentPersistenceImpl.class);
	private static Enrolment _nullEnrolment = new EnrolmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Enrolment> toCacheModel() {
				return _nullEnrolmentCacheModel;
			}
		};

	private static CacheModel<Enrolment> _nullEnrolmentCacheModel = new CacheModel<Enrolment>() {
			public Enrolment toEntityModel() {
				return _nullEnrolment;
			}
		};
}