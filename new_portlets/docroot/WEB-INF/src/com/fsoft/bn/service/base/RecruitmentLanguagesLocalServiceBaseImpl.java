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

package com.fsoft.bn.service.base;

import com.fsoft.bn.model.RecruitmentLanguages;
import com.fsoft.bn.service.AnswerAttachedFileLocalService;
import com.fsoft.bn.service.AnswerLocalService;
import com.fsoft.bn.service.BNContactLocalService;
import com.fsoft.bn.service.BNJournalArticleLocalService;
import com.fsoft.bn.service.BNJournalArticleService;
import com.fsoft.bn.service.BNNewsLocalService;
import com.fsoft.bn.service.EnrolmentAttachedFileLocalService;
import com.fsoft.bn.service.EnrolmentLocalService;
import com.fsoft.bn.service.InvestmentProjectsLocalService;
import com.fsoft.bn.service.InvestmentProjectsService;
import com.fsoft.bn.service.OrganizationsLocalService;
import com.fsoft.bn.service.PreschoolAttachedFileLocalService;
import com.fsoft.bn.service.PreschoolParentLocalService;
import com.fsoft.bn.service.PreschoolStudentLocalService;
import com.fsoft.bn.service.PrimarySchoolAttachedFileLocalService;
import com.fsoft.bn.service.PrimarySchoolParentLocalService;
import com.fsoft.bn.service.PrimarySchoolStudentLocalService;
import com.fsoft.bn.service.QuestionAttachedFileLocalService;
import com.fsoft.bn.service.QuestionLocalService;
import com.fsoft.bn.service.RecruitmentAttachedFileLocalService;
import com.fsoft.bn.service.RecruitmentEducationalHistoryLocalService;
import com.fsoft.bn.service.RecruitmentLanguagesLocalService;
import com.fsoft.bn.service.RecruitmentLocalService;
import com.fsoft.bn.service.RecruitmentProgrammingsLocalService;
import com.fsoft.bn.service.RecruitmentTrainingCoursesLocalService;
import com.fsoft.bn.service.ScheduleLocalService;
import com.fsoft.bn.service.StaffInfoLocalService;
import com.fsoft.bn.service.UserScheduleLocalService;
import com.fsoft.bn.service.UserfulContactPhoneLocalService;
import com.fsoft.bn.service.persistence.AnswerAttachedFilePersistence;
import com.fsoft.bn.service.persistence.AnswerPersistence;
import com.fsoft.bn.service.persistence.BNContactPersistence;
import com.fsoft.bn.service.persistence.BNJournalArticleFinder;
import com.fsoft.bn.service.persistence.BNNewsPersistence;
import com.fsoft.bn.service.persistence.EnrolmentAttachedFilePersistence;
import com.fsoft.bn.service.persistence.EnrolmentPersistence;
import com.fsoft.bn.service.persistence.InvestmentProjectsPersistence;
import com.fsoft.bn.service.persistence.OrganizationsPersistence;
import com.fsoft.bn.service.persistence.PreschoolAttachedFilePersistence;
import com.fsoft.bn.service.persistence.PreschoolParentPersistence;
import com.fsoft.bn.service.persistence.PreschoolStudentPersistence;
import com.fsoft.bn.service.persistence.PrimarySchoolAttachedFilePersistence;
import com.fsoft.bn.service.persistence.PrimarySchoolParentPersistence;
import com.fsoft.bn.service.persistence.PrimarySchoolStudentPersistence;
import com.fsoft.bn.service.persistence.QuestionAttachedFilePersistence;
import com.fsoft.bn.service.persistence.QuestionFinder;
import com.fsoft.bn.service.persistence.QuestionPersistence;
import com.fsoft.bn.service.persistence.RecruitmentAttachedFilePersistence;
import com.fsoft.bn.service.persistence.RecruitmentEducationalHistoryPersistence;
import com.fsoft.bn.service.persistence.RecruitmentLanguagesPersistence;
import com.fsoft.bn.service.persistence.RecruitmentPersistence;
import com.fsoft.bn.service.persistence.RecruitmentProgrammingsPersistence;
import com.fsoft.bn.service.persistence.RecruitmentTrainingCoursesPersistence;
import com.fsoft.bn.service.persistence.ScheduleFinder;
import com.fsoft.bn.service.persistence.SchedulePersistence;
import com.fsoft.bn.service.persistence.StaffInfoPersistence;
import com.fsoft.bn.service.persistence.UserSchedulePersistence;
import com.fsoft.bn.service.persistence.UserfulContactPhonePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the recruitment languages local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.fsoft.bn.service.impl.RecruitmentLanguagesLocalServiceImpl}.
 * </p>
 *
 * @author FSOFT
 * @see com.fsoft.bn.service.impl.RecruitmentLanguagesLocalServiceImpl
 * @see com.fsoft.bn.service.RecruitmentLanguagesLocalServiceUtil
 * @generated
 */
public abstract class RecruitmentLanguagesLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements RecruitmentLanguagesLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.fsoft.bn.service.RecruitmentLanguagesLocalServiceUtil} to access the recruitment languages local service.
	 */

	/**
	 * Adds the recruitment languages to the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitmentLanguages the recruitment languages
	 * @return the recruitment languages that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RecruitmentLanguages addRecruitmentLanguages(
		RecruitmentLanguages recruitmentLanguages) throws SystemException {
		recruitmentLanguages.setNew(true);

		return recruitmentLanguagesPersistence.update(recruitmentLanguages,
			false);
	}

	/**
	 * Creates a new recruitment languages with the primary key. Does not add the recruitment languages to the database.
	 *
	 * @param recruitment_languages_id the primary key for the new recruitment languages
	 * @return the new recruitment languages
	 */
	public RecruitmentLanguages createRecruitmentLanguages(
		String recruitment_languages_id) {
		return recruitmentLanguagesPersistence.create(recruitment_languages_id);
	}

	/**
	 * Deletes the recruitment languages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitment_languages_id the primary key of the recruitment languages
	 * @return the recruitment languages that was removed
	 * @throws PortalException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public RecruitmentLanguages deleteRecruitmentLanguages(
		String recruitment_languages_id)
		throws PortalException, SystemException {
		return recruitmentLanguagesPersistence.remove(recruitment_languages_id);
	}

	/**
	 * Deletes the recruitment languages from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recruitmentLanguages the recruitment languages
	 * @return the recruitment languages that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public RecruitmentLanguages deleteRecruitmentLanguages(
		RecruitmentLanguages recruitmentLanguages) throws SystemException {
		return recruitmentLanguagesPersistence.remove(recruitmentLanguages);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(RecruitmentLanguages.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return recruitmentLanguagesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return recruitmentLanguagesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return recruitmentLanguagesPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return recruitmentLanguagesPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public RecruitmentLanguages fetchRecruitmentLanguages(
		String recruitment_languages_id) throws SystemException {
		return recruitmentLanguagesPersistence.fetchByPrimaryKey(recruitment_languages_id);
	}

	/**
	 * Returns the recruitment languages with the primary key.
	 *
	 * @param recruitment_languages_id the primary key of the recruitment languages
	 * @return the recruitment languages
	 * @throws PortalException if a recruitment languages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RecruitmentLanguages getRecruitmentLanguages(
		String recruitment_languages_id)
		throws PortalException, SystemException {
		return recruitmentLanguagesPersistence.findByPrimaryKey(recruitment_languages_id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return recruitmentLanguagesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the recruitment languageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of recruitment languageses
	 * @param end the upper bound of the range of recruitment languageses (not inclusive)
	 * @return the range of recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public List<RecruitmentLanguages> getRecruitmentLanguageses(int start,
		int end) throws SystemException {
		return recruitmentLanguagesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of recruitment languageses.
	 *
	 * @return the number of recruitment languageses
	 * @throws SystemException if a system exception occurred
	 */
	public int getRecruitmentLanguagesesCount() throws SystemException {
		return recruitmentLanguagesPersistence.countAll();
	}

	/**
	 * Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param recruitmentLanguages the recruitment languages
	 * @return the recruitment languages that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RecruitmentLanguages updateRecruitmentLanguages(
		RecruitmentLanguages recruitmentLanguages) throws SystemException {
		return updateRecruitmentLanguages(recruitmentLanguages, true);
	}

	/**
	 * Updates the recruitment languages in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param recruitmentLanguages the recruitment languages
	 * @param merge whether to merge the recruitment languages with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the recruitment languages that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RecruitmentLanguages updateRecruitmentLanguages(
		RecruitmentLanguages recruitmentLanguages, boolean merge)
		throws SystemException {
		recruitmentLanguages.setNew(false);

		return recruitmentLanguagesPersistence.update(recruitmentLanguages,
			merge);
	}

	/**
	 * Returns the answer local service.
	 *
	 * @return the answer local service
	 */
	public AnswerLocalService getAnswerLocalService() {
		return answerLocalService;
	}

	/**
	 * Sets the answer local service.
	 *
	 * @param answerLocalService the answer local service
	 */
	public void setAnswerLocalService(AnswerLocalService answerLocalService) {
		this.answerLocalService = answerLocalService;
	}

	/**
	 * Returns the answer persistence.
	 *
	 * @return the answer persistence
	 */
	public AnswerPersistence getAnswerPersistence() {
		return answerPersistence;
	}

	/**
	 * Sets the answer persistence.
	 *
	 * @param answerPersistence the answer persistence
	 */
	public void setAnswerPersistence(AnswerPersistence answerPersistence) {
		this.answerPersistence = answerPersistence;
	}

	/**
	 * Returns the answer attached file local service.
	 *
	 * @return the answer attached file local service
	 */
	public AnswerAttachedFileLocalService getAnswerAttachedFileLocalService() {
		return answerAttachedFileLocalService;
	}

	/**
	 * Sets the answer attached file local service.
	 *
	 * @param answerAttachedFileLocalService the answer attached file local service
	 */
	public void setAnswerAttachedFileLocalService(
		AnswerAttachedFileLocalService answerAttachedFileLocalService) {
		this.answerAttachedFileLocalService = answerAttachedFileLocalService;
	}

	/**
	 * Returns the answer attached file persistence.
	 *
	 * @return the answer attached file persistence
	 */
	public AnswerAttachedFilePersistence getAnswerAttachedFilePersistence() {
		return answerAttachedFilePersistence;
	}

	/**
	 * Sets the answer attached file persistence.
	 *
	 * @param answerAttachedFilePersistence the answer attached file persistence
	 */
	public void setAnswerAttachedFilePersistence(
		AnswerAttachedFilePersistence answerAttachedFilePersistence) {
		this.answerAttachedFilePersistence = answerAttachedFilePersistence;
	}

	/**
	 * Returns the b n contact local service.
	 *
	 * @return the b n contact local service
	 */
	public BNContactLocalService getBNContactLocalService() {
		return bnContactLocalService;
	}

	/**
	 * Sets the b n contact local service.
	 *
	 * @param bnContactLocalService the b n contact local service
	 */
	public void setBNContactLocalService(
		BNContactLocalService bnContactLocalService) {
		this.bnContactLocalService = bnContactLocalService;
	}

	/**
	 * Returns the b n contact persistence.
	 *
	 * @return the b n contact persistence
	 */
	public BNContactPersistence getBNContactPersistence() {
		return bnContactPersistence;
	}

	/**
	 * Sets the b n contact persistence.
	 *
	 * @param bnContactPersistence the b n contact persistence
	 */
	public void setBNContactPersistence(
		BNContactPersistence bnContactPersistence) {
		this.bnContactPersistence = bnContactPersistence;
	}

	/**
	 * Returns the b n journal article local service.
	 *
	 * @return the b n journal article local service
	 */
	public BNJournalArticleLocalService getBNJournalArticleLocalService() {
		return bnJournalArticleLocalService;
	}

	/**
	 * Sets the b n journal article local service.
	 *
	 * @param bnJournalArticleLocalService the b n journal article local service
	 */
	public void setBNJournalArticleLocalService(
		BNJournalArticleLocalService bnJournalArticleLocalService) {
		this.bnJournalArticleLocalService = bnJournalArticleLocalService;
	}

	/**
	 * Returns the b n journal article remote service.
	 *
	 * @return the b n journal article remote service
	 */
	public BNJournalArticleService getBNJournalArticleService() {
		return bnJournalArticleService;
	}

	/**
	 * Sets the b n journal article remote service.
	 *
	 * @param bnJournalArticleService the b n journal article remote service
	 */
	public void setBNJournalArticleService(
		BNJournalArticleService bnJournalArticleService) {
		this.bnJournalArticleService = bnJournalArticleService;
	}

	/**
	 * Returns the b n journal article finder.
	 *
	 * @return the b n journal article finder
	 */
	public BNJournalArticleFinder getBNJournalArticleFinder() {
		return bnJournalArticleFinder;
	}

	/**
	 * Sets the b n journal article finder.
	 *
	 * @param bnJournalArticleFinder the b n journal article finder
	 */
	public void setBNJournalArticleFinder(
		BNJournalArticleFinder bnJournalArticleFinder) {
		this.bnJournalArticleFinder = bnJournalArticleFinder;
	}

	/**
	 * Returns the b n news local service.
	 *
	 * @return the b n news local service
	 */
	public BNNewsLocalService getBNNewsLocalService() {
		return bnNewsLocalService;
	}

	/**
	 * Sets the b n news local service.
	 *
	 * @param bnNewsLocalService the b n news local service
	 */
	public void setBNNewsLocalService(BNNewsLocalService bnNewsLocalService) {
		this.bnNewsLocalService = bnNewsLocalService;
	}

	/**
	 * Returns the b n news persistence.
	 *
	 * @return the b n news persistence
	 */
	public BNNewsPersistence getBNNewsPersistence() {
		return bnNewsPersistence;
	}

	/**
	 * Sets the b n news persistence.
	 *
	 * @param bnNewsPersistence the b n news persistence
	 */
	public void setBNNewsPersistence(BNNewsPersistence bnNewsPersistence) {
		this.bnNewsPersistence = bnNewsPersistence;
	}

	/**
	 * Returns the enrolment local service.
	 *
	 * @return the enrolment local service
	 */
	public EnrolmentLocalService getEnrolmentLocalService() {
		return enrolmentLocalService;
	}

	/**
	 * Sets the enrolment local service.
	 *
	 * @param enrolmentLocalService the enrolment local service
	 */
	public void setEnrolmentLocalService(
		EnrolmentLocalService enrolmentLocalService) {
		this.enrolmentLocalService = enrolmentLocalService;
	}

	/**
	 * Returns the enrolment persistence.
	 *
	 * @return the enrolment persistence
	 */
	public EnrolmentPersistence getEnrolmentPersistence() {
		return enrolmentPersistence;
	}

	/**
	 * Sets the enrolment persistence.
	 *
	 * @param enrolmentPersistence the enrolment persistence
	 */
	public void setEnrolmentPersistence(
		EnrolmentPersistence enrolmentPersistence) {
		this.enrolmentPersistence = enrolmentPersistence;
	}

	/**
	 * Returns the enrolment attached file local service.
	 *
	 * @return the enrolment attached file local service
	 */
	public EnrolmentAttachedFileLocalService getEnrolmentAttachedFileLocalService() {
		return enrolmentAttachedFileLocalService;
	}

	/**
	 * Sets the enrolment attached file local service.
	 *
	 * @param enrolmentAttachedFileLocalService the enrolment attached file local service
	 */
	public void setEnrolmentAttachedFileLocalService(
		EnrolmentAttachedFileLocalService enrolmentAttachedFileLocalService) {
		this.enrolmentAttachedFileLocalService = enrolmentAttachedFileLocalService;
	}

	/**
	 * Returns the enrolment attached file persistence.
	 *
	 * @return the enrolment attached file persistence
	 */
	public EnrolmentAttachedFilePersistence getEnrolmentAttachedFilePersistence() {
		return enrolmentAttachedFilePersistence;
	}

	/**
	 * Sets the enrolment attached file persistence.
	 *
	 * @param enrolmentAttachedFilePersistence the enrolment attached file persistence
	 */
	public void setEnrolmentAttachedFilePersistence(
		EnrolmentAttachedFilePersistence enrolmentAttachedFilePersistence) {
		this.enrolmentAttachedFilePersistence = enrolmentAttachedFilePersistence;
	}

	/**
	 * Returns the investment projects local service.
	 *
	 * @return the investment projects local service
	 */
	public InvestmentProjectsLocalService getInvestmentProjectsLocalService() {
		return investmentProjectsLocalService;
	}

	/**
	 * Sets the investment projects local service.
	 *
	 * @param investmentProjectsLocalService the investment projects local service
	 */
	public void setInvestmentProjectsLocalService(
		InvestmentProjectsLocalService investmentProjectsLocalService) {
		this.investmentProjectsLocalService = investmentProjectsLocalService;
	}

	/**
	 * Returns the investment projects remote service.
	 *
	 * @return the investment projects remote service
	 */
	public InvestmentProjectsService getInvestmentProjectsService() {
		return investmentProjectsService;
	}

	/**
	 * Sets the investment projects remote service.
	 *
	 * @param investmentProjectsService the investment projects remote service
	 */
	public void setInvestmentProjectsService(
		InvestmentProjectsService investmentProjectsService) {
		this.investmentProjectsService = investmentProjectsService;
	}

	/**
	 * Returns the investment projects persistence.
	 *
	 * @return the investment projects persistence
	 */
	public InvestmentProjectsPersistence getInvestmentProjectsPersistence() {
		return investmentProjectsPersistence;
	}

	/**
	 * Sets the investment projects persistence.
	 *
	 * @param investmentProjectsPersistence the investment projects persistence
	 */
	public void setInvestmentProjectsPersistence(
		InvestmentProjectsPersistence investmentProjectsPersistence) {
		this.investmentProjectsPersistence = investmentProjectsPersistence;
	}

	/**
	 * Returns the organizations local service.
	 *
	 * @return the organizations local service
	 */
	public OrganizationsLocalService getOrganizationsLocalService() {
		return organizationsLocalService;
	}

	/**
	 * Sets the organizations local service.
	 *
	 * @param organizationsLocalService the organizations local service
	 */
	public void setOrganizationsLocalService(
		OrganizationsLocalService organizationsLocalService) {
		this.organizationsLocalService = organizationsLocalService;
	}

	/**
	 * Returns the organizations persistence.
	 *
	 * @return the organizations persistence
	 */
	public OrganizationsPersistence getOrganizationsPersistence() {
		return organizationsPersistence;
	}

	/**
	 * Sets the organizations persistence.
	 *
	 * @param organizationsPersistence the organizations persistence
	 */
	public void setOrganizationsPersistence(
		OrganizationsPersistence organizationsPersistence) {
		this.organizationsPersistence = organizationsPersistence;
	}

	/**
	 * Returns the preschool attached file local service.
	 *
	 * @return the preschool attached file local service
	 */
	public PreschoolAttachedFileLocalService getPreschoolAttachedFileLocalService() {
		return preschoolAttachedFileLocalService;
	}

	/**
	 * Sets the preschool attached file local service.
	 *
	 * @param preschoolAttachedFileLocalService the preschool attached file local service
	 */
	public void setPreschoolAttachedFileLocalService(
		PreschoolAttachedFileLocalService preschoolAttachedFileLocalService) {
		this.preschoolAttachedFileLocalService = preschoolAttachedFileLocalService;
	}

	/**
	 * Returns the preschool attached file persistence.
	 *
	 * @return the preschool attached file persistence
	 */
	public PreschoolAttachedFilePersistence getPreschoolAttachedFilePersistence() {
		return preschoolAttachedFilePersistence;
	}

	/**
	 * Sets the preschool attached file persistence.
	 *
	 * @param preschoolAttachedFilePersistence the preschool attached file persistence
	 */
	public void setPreschoolAttachedFilePersistence(
		PreschoolAttachedFilePersistence preschoolAttachedFilePersistence) {
		this.preschoolAttachedFilePersistence = preschoolAttachedFilePersistence;
	}

	/**
	 * Returns the preschool parent local service.
	 *
	 * @return the preschool parent local service
	 */
	public PreschoolParentLocalService getPreschoolParentLocalService() {
		return preschoolParentLocalService;
	}

	/**
	 * Sets the preschool parent local service.
	 *
	 * @param preschoolParentLocalService the preschool parent local service
	 */
	public void setPreschoolParentLocalService(
		PreschoolParentLocalService preschoolParentLocalService) {
		this.preschoolParentLocalService = preschoolParentLocalService;
	}

	/**
	 * Returns the preschool parent persistence.
	 *
	 * @return the preschool parent persistence
	 */
	public PreschoolParentPersistence getPreschoolParentPersistence() {
		return preschoolParentPersistence;
	}

	/**
	 * Sets the preschool parent persistence.
	 *
	 * @param preschoolParentPersistence the preschool parent persistence
	 */
	public void setPreschoolParentPersistence(
		PreschoolParentPersistence preschoolParentPersistence) {
		this.preschoolParentPersistence = preschoolParentPersistence;
	}

	/**
	 * Returns the preschool student local service.
	 *
	 * @return the preschool student local service
	 */
	public PreschoolStudentLocalService getPreschoolStudentLocalService() {
		return preschoolStudentLocalService;
	}

	/**
	 * Sets the preschool student local service.
	 *
	 * @param preschoolStudentLocalService the preschool student local service
	 */
	public void setPreschoolStudentLocalService(
		PreschoolStudentLocalService preschoolStudentLocalService) {
		this.preschoolStudentLocalService = preschoolStudentLocalService;
	}

	/**
	 * Returns the preschool student persistence.
	 *
	 * @return the preschool student persistence
	 */
	public PreschoolStudentPersistence getPreschoolStudentPersistence() {
		return preschoolStudentPersistence;
	}

	/**
	 * Sets the preschool student persistence.
	 *
	 * @param preschoolStudentPersistence the preschool student persistence
	 */
	public void setPreschoolStudentPersistence(
		PreschoolStudentPersistence preschoolStudentPersistence) {
		this.preschoolStudentPersistence = preschoolStudentPersistence;
	}

	/**
	 * Returns the primary school attached file local service.
	 *
	 * @return the primary school attached file local service
	 */
	public PrimarySchoolAttachedFileLocalService getPrimarySchoolAttachedFileLocalService() {
		return primarySchoolAttachedFileLocalService;
	}

	/**
	 * Sets the primary school attached file local service.
	 *
	 * @param primarySchoolAttachedFileLocalService the primary school attached file local service
	 */
	public void setPrimarySchoolAttachedFileLocalService(
		PrimarySchoolAttachedFileLocalService primarySchoolAttachedFileLocalService) {
		this.primarySchoolAttachedFileLocalService = primarySchoolAttachedFileLocalService;
	}

	/**
	 * Returns the primary school attached file persistence.
	 *
	 * @return the primary school attached file persistence
	 */
	public PrimarySchoolAttachedFilePersistence getPrimarySchoolAttachedFilePersistence() {
		return primarySchoolAttachedFilePersistence;
	}

	/**
	 * Sets the primary school attached file persistence.
	 *
	 * @param primarySchoolAttachedFilePersistence the primary school attached file persistence
	 */
	public void setPrimarySchoolAttachedFilePersistence(
		PrimarySchoolAttachedFilePersistence primarySchoolAttachedFilePersistence) {
		this.primarySchoolAttachedFilePersistence = primarySchoolAttachedFilePersistence;
	}

	/**
	 * Returns the primary school parent local service.
	 *
	 * @return the primary school parent local service
	 */
	public PrimarySchoolParentLocalService getPrimarySchoolParentLocalService() {
		return primarySchoolParentLocalService;
	}

	/**
	 * Sets the primary school parent local service.
	 *
	 * @param primarySchoolParentLocalService the primary school parent local service
	 */
	public void setPrimarySchoolParentLocalService(
		PrimarySchoolParentLocalService primarySchoolParentLocalService) {
		this.primarySchoolParentLocalService = primarySchoolParentLocalService;
	}

	/**
	 * Returns the primary school parent persistence.
	 *
	 * @return the primary school parent persistence
	 */
	public PrimarySchoolParentPersistence getPrimarySchoolParentPersistence() {
		return primarySchoolParentPersistence;
	}

	/**
	 * Sets the primary school parent persistence.
	 *
	 * @param primarySchoolParentPersistence the primary school parent persistence
	 */
	public void setPrimarySchoolParentPersistence(
		PrimarySchoolParentPersistence primarySchoolParentPersistence) {
		this.primarySchoolParentPersistence = primarySchoolParentPersistence;
	}

	/**
	 * Returns the primary school student local service.
	 *
	 * @return the primary school student local service
	 */
	public PrimarySchoolStudentLocalService getPrimarySchoolStudentLocalService() {
		return primarySchoolStudentLocalService;
	}

	/**
	 * Sets the primary school student local service.
	 *
	 * @param primarySchoolStudentLocalService the primary school student local service
	 */
	public void setPrimarySchoolStudentLocalService(
		PrimarySchoolStudentLocalService primarySchoolStudentLocalService) {
		this.primarySchoolStudentLocalService = primarySchoolStudentLocalService;
	}

	/**
	 * Returns the primary school student persistence.
	 *
	 * @return the primary school student persistence
	 */
	public PrimarySchoolStudentPersistence getPrimarySchoolStudentPersistence() {
		return primarySchoolStudentPersistence;
	}

	/**
	 * Sets the primary school student persistence.
	 *
	 * @param primarySchoolStudentPersistence the primary school student persistence
	 */
	public void setPrimarySchoolStudentPersistence(
		PrimarySchoolStudentPersistence primarySchoolStudentPersistence) {
		this.primarySchoolStudentPersistence = primarySchoolStudentPersistence;
	}

	/**
	 * Returns the question local service.
	 *
	 * @return the question local service
	 */
	public QuestionLocalService getQuestionLocalService() {
		return questionLocalService;
	}

	/**
	 * Sets the question local service.
	 *
	 * @param questionLocalService the question local service
	 */
	public void setQuestionLocalService(
		QuestionLocalService questionLocalService) {
		this.questionLocalService = questionLocalService;
	}

	/**
	 * Returns the question persistence.
	 *
	 * @return the question persistence
	 */
	public QuestionPersistence getQuestionPersistence() {
		return questionPersistence;
	}

	/**
	 * Sets the question persistence.
	 *
	 * @param questionPersistence the question persistence
	 */
	public void setQuestionPersistence(QuestionPersistence questionPersistence) {
		this.questionPersistence = questionPersistence;
	}

	/**
	 * Returns the question finder.
	 *
	 * @return the question finder
	 */
	public QuestionFinder getQuestionFinder() {
		return questionFinder;
	}

	/**
	 * Sets the question finder.
	 *
	 * @param questionFinder the question finder
	 */
	public void setQuestionFinder(QuestionFinder questionFinder) {
		this.questionFinder = questionFinder;
	}

	/**
	 * Returns the question attached file local service.
	 *
	 * @return the question attached file local service
	 */
	public QuestionAttachedFileLocalService getQuestionAttachedFileLocalService() {
		return questionAttachedFileLocalService;
	}

	/**
	 * Sets the question attached file local service.
	 *
	 * @param questionAttachedFileLocalService the question attached file local service
	 */
	public void setQuestionAttachedFileLocalService(
		QuestionAttachedFileLocalService questionAttachedFileLocalService) {
		this.questionAttachedFileLocalService = questionAttachedFileLocalService;
	}

	/**
	 * Returns the question attached file persistence.
	 *
	 * @return the question attached file persistence
	 */
	public QuestionAttachedFilePersistence getQuestionAttachedFilePersistence() {
		return questionAttachedFilePersistence;
	}

	/**
	 * Sets the question attached file persistence.
	 *
	 * @param questionAttachedFilePersistence the question attached file persistence
	 */
	public void setQuestionAttachedFilePersistence(
		QuestionAttachedFilePersistence questionAttachedFilePersistence) {
		this.questionAttachedFilePersistence = questionAttachedFilePersistence;
	}

	/**
	 * Returns the recruitment local service.
	 *
	 * @return the recruitment local service
	 */
	public RecruitmentLocalService getRecruitmentLocalService() {
		return recruitmentLocalService;
	}

	/**
	 * Sets the recruitment local service.
	 *
	 * @param recruitmentLocalService the recruitment local service
	 */
	public void setRecruitmentLocalService(
		RecruitmentLocalService recruitmentLocalService) {
		this.recruitmentLocalService = recruitmentLocalService;
	}

	/**
	 * Returns the recruitment persistence.
	 *
	 * @return the recruitment persistence
	 */
	public RecruitmentPersistence getRecruitmentPersistence() {
		return recruitmentPersistence;
	}

	/**
	 * Sets the recruitment persistence.
	 *
	 * @param recruitmentPersistence the recruitment persistence
	 */
	public void setRecruitmentPersistence(
		RecruitmentPersistence recruitmentPersistence) {
		this.recruitmentPersistence = recruitmentPersistence;
	}

	/**
	 * Returns the recruitment attached file local service.
	 *
	 * @return the recruitment attached file local service
	 */
	public RecruitmentAttachedFileLocalService getRecruitmentAttachedFileLocalService() {
		return recruitmentAttachedFileLocalService;
	}

	/**
	 * Sets the recruitment attached file local service.
	 *
	 * @param recruitmentAttachedFileLocalService the recruitment attached file local service
	 */
	public void setRecruitmentAttachedFileLocalService(
		RecruitmentAttachedFileLocalService recruitmentAttachedFileLocalService) {
		this.recruitmentAttachedFileLocalService = recruitmentAttachedFileLocalService;
	}

	/**
	 * Returns the recruitment attached file persistence.
	 *
	 * @return the recruitment attached file persistence
	 */
	public RecruitmentAttachedFilePersistence getRecruitmentAttachedFilePersistence() {
		return recruitmentAttachedFilePersistence;
	}

	/**
	 * Sets the recruitment attached file persistence.
	 *
	 * @param recruitmentAttachedFilePersistence the recruitment attached file persistence
	 */
	public void setRecruitmentAttachedFilePersistence(
		RecruitmentAttachedFilePersistence recruitmentAttachedFilePersistence) {
		this.recruitmentAttachedFilePersistence = recruitmentAttachedFilePersistence;
	}

	/**
	 * Returns the recruitment educational history local service.
	 *
	 * @return the recruitment educational history local service
	 */
	public RecruitmentEducationalHistoryLocalService getRecruitmentEducationalHistoryLocalService() {
		return recruitmentEducationalHistoryLocalService;
	}

	/**
	 * Sets the recruitment educational history local service.
	 *
	 * @param recruitmentEducationalHistoryLocalService the recruitment educational history local service
	 */
	public void setRecruitmentEducationalHistoryLocalService(
		RecruitmentEducationalHistoryLocalService recruitmentEducationalHistoryLocalService) {
		this.recruitmentEducationalHistoryLocalService = recruitmentEducationalHistoryLocalService;
	}

	/**
	 * Returns the recruitment educational history persistence.
	 *
	 * @return the recruitment educational history persistence
	 */
	public RecruitmentEducationalHistoryPersistence getRecruitmentEducationalHistoryPersistence() {
		return recruitmentEducationalHistoryPersistence;
	}

	/**
	 * Sets the recruitment educational history persistence.
	 *
	 * @param recruitmentEducationalHistoryPersistence the recruitment educational history persistence
	 */
	public void setRecruitmentEducationalHistoryPersistence(
		RecruitmentEducationalHistoryPersistence recruitmentEducationalHistoryPersistence) {
		this.recruitmentEducationalHistoryPersistence = recruitmentEducationalHistoryPersistence;
	}

	/**
	 * Returns the recruitment languages local service.
	 *
	 * @return the recruitment languages local service
	 */
	public RecruitmentLanguagesLocalService getRecruitmentLanguagesLocalService() {
		return recruitmentLanguagesLocalService;
	}

	/**
	 * Sets the recruitment languages local service.
	 *
	 * @param recruitmentLanguagesLocalService the recruitment languages local service
	 */
	public void setRecruitmentLanguagesLocalService(
		RecruitmentLanguagesLocalService recruitmentLanguagesLocalService) {
		this.recruitmentLanguagesLocalService = recruitmentLanguagesLocalService;
	}

	/**
	 * Returns the recruitment languages persistence.
	 *
	 * @return the recruitment languages persistence
	 */
	public RecruitmentLanguagesPersistence getRecruitmentLanguagesPersistence() {
		return recruitmentLanguagesPersistence;
	}

	/**
	 * Sets the recruitment languages persistence.
	 *
	 * @param recruitmentLanguagesPersistence the recruitment languages persistence
	 */
	public void setRecruitmentLanguagesPersistence(
		RecruitmentLanguagesPersistence recruitmentLanguagesPersistence) {
		this.recruitmentLanguagesPersistence = recruitmentLanguagesPersistence;
	}

	/**
	 * Returns the recruitment programmings local service.
	 *
	 * @return the recruitment programmings local service
	 */
	public RecruitmentProgrammingsLocalService getRecruitmentProgrammingsLocalService() {
		return recruitmentProgrammingsLocalService;
	}

	/**
	 * Sets the recruitment programmings local service.
	 *
	 * @param recruitmentProgrammingsLocalService the recruitment programmings local service
	 */
	public void setRecruitmentProgrammingsLocalService(
		RecruitmentProgrammingsLocalService recruitmentProgrammingsLocalService) {
		this.recruitmentProgrammingsLocalService = recruitmentProgrammingsLocalService;
	}

	/**
	 * Returns the recruitment programmings persistence.
	 *
	 * @return the recruitment programmings persistence
	 */
	public RecruitmentProgrammingsPersistence getRecruitmentProgrammingsPersistence() {
		return recruitmentProgrammingsPersistence;
	}

	/**
	 * Sets the recruitment programmings persistence.
	 *
	 * @param recruitmentProgrammingsPersistence the recruitment programmings persistence
	 */
	public void setRecruitmentProgrammingsPersistence(
		RecruitmentProgrammingsPersistence recruitmentProgrammingsPersistence) {
		this.recruitmentProgrammingsPersistence = recruitmentProgrammingsPersistence;
	}

	/**
	 * Returns the recruitment training courses local service.
	 *
	 * @return the recruitment training courses local service
	 */
	public RecruitmentTrainingCoursesLocalService getRecruitmentTrainingCoursesLocalService() {
		return recruitmentTrainingCoursesLocalService;
	}

	/**
	 * Sets the recruitment training courses local service.
	 *
	 * @param recruitmentTrainingCoursesLocalService the recruitment training courses local service
	 */
	public void setRecruitmentTrainingCoursesLocalService(
		RecruitmentTrainingCoursesLocalService recruitmentTrainingCoursesLocalService) {
		this.recruitmentTrainingCoursesLocalService = recruitmentTrainingCoursesLocalService;
	}

	/**
	 * Returns the recruitment training courses persistence.
	 *
	 * @return the recruitment training courses persistence
	 */
	public RecruitmentTrainingCoursesPersistence getRecruitmentTrainingCoursesPersistence() {
		return recruitmentTrainingCoursesPersistence;
	}

	/**
	 * Sets the recruitment training courses persistence.
	 *
	 * @param recruitmentTrainingCoursesPersistence the recruitment training courses persistence
	 */
	public void setRecruitmentTrainingCoursesPersistence(
		RecruitmentTrainingCoursesPersistence recruitmentTrainingCoursesPersistence) {
		this.recruitmentTrainingCoursesPersistence = recruitmentTrainingCoursesPersistence;
	}

	/**
	 * Returns the schedule local service.
	 *
	 * @return the schedule local service
	 */
	public ScheduleLocalService getScheduleLocalService() {
		return scheduleLocalService;
	}

	/**
	 * Sets the schedule local service.
	 *
	 * @param scheduleLocalService the schedule local service
	 */
	public void setScheduleLocalService(
		ScheduleLocalService scheduleLocalService) {
		this.scheduleLocalService = scheduleLocalService;
	}

	/**
	 * Returns the schedule persistence.
	 *
	 * @return the schedule persistence
	 */
	public SchedulePersistence getSchedulePersistence() {
		return schedulePersistence;
	}

	/**
	 * Sets the schedule persistence.
	 *
	 * @param schedulePersistence the schedule persistence
	 */
	public void setSchedulePersistence(SchedulePersistence schedulePersistence) {
		this.schedulePersistence = schedulePersistence;
	}

	/**
	 * Returns the schedule finder.
	 *
	 * @return the schedule finder
	 */
	public ScheduleFinder getScheduleFinder() {
		return scheduleFinder;
	}

	/**
	 * Sets the schedule finder.
	 *
	 * @param scheduleFinder the schedule finder
	 */
	public void setScheduleFinder(ScheduleFinder scheduleFinder) {
		this.scheduleFinder = scheduleFinder;
	}

	/**
	 * Returns the staff info local service.
	 *
	 * @return the staff info local service
	 */
	public StaffInfoLocalService getStaffInfoLocalService() {
		return staffInfoLocalService;
	}

	/**
	 * Sets the staff info local service.
	 *
	 * @param staffInfoLocalService the staff info local service
	 */
	public void setStaffInfoLocalService(
		StaffInfoLocalService staffInfoLocalService) {
		this.staffInfoLocalService = staffInfoLocalService;
	}

	/**
	 * Returns the staff info persistence.
	 *
	 * @return the staff info persistence
	 */
	public StaffInfoPersistence getStaffInfoPersistence() {
		return staffInfoPersistence;
	}

	/**
	 * Sets the staff info persistence.
	 *
	 * @param staffInfoPersistence the staff info persistence
	 */
	public void setStaffInfoPersistence(
		StaffInfoPersistence staffInfoPersistence) {
		this.staffInfoPersistence = staffInfoPersistence;
	}

	/**
	 * Returns the userful contact phone local service.
	 *
	 * @return the userful contact phone local service
	 */
	public UserfulContactPhoneLocalService getUserfulContactPhoneLocalService() {
		return userfulContactPhoneLocalService;
	}

	/**
	 * Sets the userful contact phone local service.
	 *
	 * @param userfulContactPhoneLocalService the userful contact phone local service
	 */
	public void setUserfulContactPhoneLocalService(
		UserfulContactPhoneLocalService userfulContactPhoneLocalService) {
		this.userfulContactPhoneLocalService = userfulContactPhoneLocalService;
	}

	/**
	 * Returns the userful contact phone persistence.
	 *
	 * @return the userful contact phone persistence
	 */
	public UserfulContactPhonePersistence getUserfulContactPhonePersistence() {
		return userfulContactPhonePersistence;
	}

	/**
	 * Sets the userful contact phone persistence.
	 *
	 * @param userfulContactPhonePersistence the userful contact phone persistence
	 */
	public void setUserfulContactPhonePersistence(
		UserfulContactPhonePersistence userfulContactPhonePersistence) {
		this.userfulContactPhonePersistence = userfulContactPhonePersistence;
	}

	/**
	 * Returns the user schedule local service.
	 *
	 * @return the user schedule local service
	 */
	public UserScheduleLocalService getUserScheduleLocalService() {
		return userScheduleLocalService;
	}

	/**
	 * Sets the user schedule local service.
	 *
	 * @param userScheduleLocalService the user schedule local service
	 */
	public void setUserScheduleLocalService(
		UserScheduleLocalService userScheduleLocalService) {
		this.userScheduleLocalService = userScheduleLocalService;
	}

	/**
	 * Returns the user schedule persistence.
	 *
	 * @return the user schedule persistence
	 */
	public UserSchedulePersistence getUserSchedulePersistence() {
		return userSchedulePersistence;
	}

	/**
	 * Sets the user schedule persistence.
	 *
	 * @param userSchedulePersistence the user schedule persistence
	 */
	public void setUserSchedulePersistence(
		UserSchedulePersistence userSchedulePersistence) {
		this.userSchedulePersistence = userSchedulePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.fsoft.bn.model.RecruitmentLanguages",
			recruitmentLanguagesLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.fsoft.bn.model.RecruitmentLanguages");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return RecruitmentLanguages.class;
	}

	protected String getModelClassName() {
		return RecruitmentLanguages.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = recruitmentLanguagesPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AnswerLocalService.class)
	protected AnswerLocalService answerLocalService;
	@BeanReference(type = AnswerPersistence.class)
	protected AnswerPersistence answerPersistence;
	@BeanReference(type = AnswerAttachedFileLocalService.class)
	protected AnswerAttachedFileLocalService answerAttachedFileLocalService;
	@BeanReference(type = AnswerAttachedFilePersistence.class)
	protected AnswerAttachedFilePersistence answerAttachedFilePersistence;
	@BeanReference(type = BNContactLocalService.class)
	protected BNContactLocalService bnContactLocalService;
	@BeanReference(type = BNContactPersistence.class)
	protected BNContactPersistence bnContactPersistence;
	@BeanReference(type = BNJournalArticleLocalService.class)
	protected BNJournalArticleLocalService bnJournalArticleLocalService;
	@BeanReference(type = BNJournalArticleService.class)
	protected BNJournalArticleService bnJournalArticleService;
	@BeanReference(type = BNJournalArticleFinder.class)
	protected BNJournalArticleFinder bnJournalArticleFinder;
	@BeanReference(type = BNNewsLocalService.class)
	protected BNNewsLocalService bnNewsLocalService;
	@BeanReference(type = BNNewsPersistence.class)
	protected BNNewsPersistence bnNewsPersistence;
	@BeanReference(type = EnrolmentLocalService.class)
	protected EnrolmentLocalService enrolmentLocalService;
	@BeanReference(type = EnrolmentPersistence.class)
	protected EnrolmentPersistence enrolmentPersistence;
	@BeanReference(type = EnrolmentAttachedFileLocalService.class)
	protected EnrolmentAttachedFileLocalService enrolmentAttachedFileLocalService;
	@BeanReference(type = EnrolmentAttachedFilePersistence.class)
	protected EnrolmentAttachedFilePersistence enrolmentAttachedFilePersistence;
	@BeanReference(type = InvestmentProjectsLocalService.class)
	protected InvestmentProjectsLocalService investmentProjectsLocalService;
	@BeanReference(type = InvestmentProjectsService.class)
	protected InvestmentProjectsService investmentProjectsService;
	@BeanReference(type = InvestmentProjectsPersistence.class)
	protected InvestmentProjectsPersistence investmentProjectsPersistence;
	@BeanReference(type = OrganizationsLocalService.class)
	protected OrganizationsLocalService organizationsLocalService;
	@BeanReference(type = OrganizationsPersistence.class)
	protected OrganizationsPersistence organizationsPersistence;
	@BeanReference(type = PreschoolAttachedFileLocalService.class)
	protected PreschoolAttachedFileLocalService preschoolAttachedFileLocalService;
	@BeanReference(type = PreschoolAttachedFilePersistence.class)
	protected PreschoolAttachedFilePersistence preschoolAttachedFilePersistence;
	@BeanReference(type = PreschoolParentLocalService.class)
	protected PreschoolParentLocalService preschoolParentLocalService;
	@BeanReference(type = PreschoolParentPersistence.class)
	protected PreschoolParentPersistence preschoolParentPersistence;
	@BeanReference(type = PreschoolStudentLocalService.class)
	protected PreschoolStudentLocalService preschoolStudentLocalService;
	@BeanReference(type = PreschoolStudentPersistence.class)
	protected PreschoolStudentPersistence preschoolStudentPersistence;
	@BeanReference(type = PrimarySchoolAttachedFileLocalService.class)
	protected PrimarySchoolAttachedFileLocalService primarySchoolAttachedFileLocalService;
	@BeanReference(type = PrimarySchoolAttachedFilePersistence.class)
	protected PrimarySchoolAttachedFilePersistence primarySchoolAttachedFilePersistence;
	@BeanReference(type = PrimarySchoolParentLocalService.class)
	protected PrimarySchoolParentLocalService primarySchoolParentLocalService;
	@BeanReference(type = PrimarySchoolParentPersistence.class)
	protected PrimarySchoolParentPersistence primarySchoolParentPersistence;
	@BeanReference(type = PrimarySchoolStudentLocalService.class)
	protected PrimarySchoolStudentLocalService primarySchoolStudentLocalService;
	@BeanReference(type = PrimarySchoolStudentPersistence.class)
	protected PrimarySchoolStudentPersistence primarySchoolStudentPersistence;
	@BeanReference(type = QuestionLocalService.class)
	protected QuestionLocalService questionLocalService;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = QuestionFinder.class)
	protected QuestionFinder questionFinder;
	@BeanReference(type = QuestionAttachedFileLocalService.class)
	protected QuestionAttachedFileLocalService questionAttachedFileLocalService;
	@BeanReference(type = QuestionAttachedFilePersistence.class)
	protected QuestionAttachedFilePersistence questionAttachedFilePersistence;
	@BeanReference(type = RecruitmentLocalService.class)
	protected RecruitmentLocalService recruitmentLocalService;
	@BeanReference(type = RecruitmentPersistence.class)
	protected RecruitmentPersistence recruitmentPersistence;
	@BeanReference(type = RecruitmentAttachedFileLocalService.class)
	protected RecruitmentAttachedFileLocalService recruitmentAttachedFileLocalService;
	@BeanReference(type = RecruitmentAttachedFilePersistence.class)
	protected RecruitmentAttachedFilePersistence recruitmentAttachedFilePersistence;
	@BeanReference(type = RecruitmentEducationalHistoryLocalService.class)
	protected RecruitmentEducationalHistoryLocalService recruitmentEducationalHistoryLocalService;
	@BeanReference(type = RecruitmentEducationalHistoryPersistence.class)
	protected RecruitmentEducationalHistoryPersistence recruitmentEducationalHistoryPersistence;
	@BeanReference(type = RecruitmentLanguagesLocalService.class)
	protected RecruitmentLanguagesLocalService recruitmentLanguagesLocalService;
	@BeanReference(type = RecruitmentLanguagesPersistence.class)
	protected RecruitmentLanguagesPersistence recruitmentLanguagesPersistence;
	@BeanReference(type = RecruitmentProgrammingsLocalService.class)
	protected RecruitmentProgrammingsLocalService recruitmentProgrammingsLocalService;
	@BeanReference(type = RecruitmentProgrammingsPersistence.class)
	protected RecruitmentProgrammingsPersistence recruitmentProgrammingsPersistence;
	@BeanReference(type = RecruitmentTrainingCoursesLocalService.class)
	protected RecruitmentTrainingCoursesLocalService recruitmentTrainingCoursesLocalService;
	@BeanReference(type = RecruitmentTrainingCoursesPersistence.class)
	protected RecruitmentTrainingCoursesPersistence recruitmentTrainingCoursesPersistence;
	@BeanReference(type = ScheduleLocalService.class)
	protected ScheduleLocalService scheduleLocalService;
	@BeanReference(type = SchedulePersistence.class)
	protected SchedulePersistence schedulePersistence;
	@BeanReference(type = ScheduleFinder.class)
	protected ScheduleFinder scheduleFinder;
	@BeanReference(type = StaffInfoLocalService.class)
	protected StaffInfoLocalService staffInfoLocalService;
	@BeanReference(type = StaffInfoPersistence.class)
	protected StaffInfoPersistence staffInfoPersistence;
	@BeanReference(type = UserfulContactPhoneLocalService.class)
	protected UserfulContactPhoneLocalService userfulContactPhoneLocalService;
	@BeanReference(type = UserfulContactPhonePersistence.class)
	protected UserfulContactPhonePersistence userfulContactPhonePersistence;
	@BeanReference(type = UserScheduleLocalService.class)
	protected UserScheduleLocalService userScheduleLocalService;
	@BeanReference(type = UserSchedulePersistence.class)
	protected UserSchedulePersistence userSchedulePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private RecruitmentLanguagesLocalServiceClpInvoker _clpInvoker = new RecruitmentLanguagesLocalServiceClpInvoker();
}