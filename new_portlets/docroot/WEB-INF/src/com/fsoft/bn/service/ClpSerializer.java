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

package com.fsoft.bn.service;

import com.fsoft.bn.model.AnswerAttachedFileClp;
import com.fsoft.bn.model.AnswerClp;
import com.fsoft.bn.model.BNContactClp;
import com.fsoft.bn.model.BNNewsClp;
import com.fsoft.bn.model.EnrolmentAttachedFileClp;
import com.fsoft.bn.model.EnrolmentClp;
import com.fsoft.bn.model.InvestmentProjectsClp;
import com.fsoft.bn.model.OrganizationsClp;
import com.fsoft.bn.model.PreschoolAttachedFileClp;
import com.fsoft.bn.model.PreschoolParentClp;
import com.fsoft.bn.model.PreschoolStudentClp;
import com.fsoft.bn.model.PrimarySchoolAttachedFileClp;
import com.fsoft.bn.model.PrimarySchoolParentClp;
import com.fsoft.bn.model.PrimarySchoolStudentClp;
import com.fsoft.bn.model.QuestionAttachedFileClp;
import com.fsoft.bn.model.QuestionClp;
import com.fsoft.bn.model.RecruitmentAttachedFileClp;
import com.fsoft.bn.model.RecruitmentClp;
import com.fsoft.bn.model.RecruitmentEducationalHistoryClp;
import com.fsoft.bn.model.RecruitmentLanguagesClp;
import com.fsoft.bn.model.RecruitmentProgrammingsClp;
import com.fsoft.bn.model.RecruitmentTrainingCoursesClp;
import com.fsoft.bn.model.ScheduleClp;
import com.fsoft.bn.model.StaffInfoClp;
import com.fsoft.bn.model.UserScheduleClp;
import com.fsoft.bn.model.UserfulContactPhoneClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"tinhdo-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"tinhdo-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "tinhdo-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AnswerClp.class.getName())) {
			return translateInputAnswer(oldModel);
		}

		if (oldModelClassName.equals(AnswerAttachedFileClp.class.getName())) {
			return translateInputAnswerAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(BNContactClp.class.getName())) {
			return translateInputBNContact(oldModel);
		}

		if (oldModelClassName.equals(BNNewsClp.class.getName())) {
			return translateInputBNNews(oldModel);
		}

		if (oldModelClassName.equals(EnrolmentClp.class.getName())) {
			return translateInputEnrolment(oldModel);
		}

		if (oldModelClassName.equals(EnrolmentAttachedFileClp.class.getName())) {
			return translateInputEnrolmentAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(InvestmentProjectsClp.class.getName())) {
			return translateInputInvestmentProjects(oldModel);
		}

		if (oldModelClassName.equals(OrganizationsClp.class.getName())) {
			return translateInputOrganizations(oldModel);
		}

		if (oldModelClassName.equals(PreschoolAttachedFileClp.class.getName())) {
			return translateInputPreschoolAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(PreschoolParentClp.class.getName())) {
			return translateInputPreschoolParent(oldModel);
		}

		if (oldModelClassName.equals(PreschoolStudentClp.class.getName())) {
			return translateInputPreschoolStudent(oldModel);
		}

		if (oldModelClassName.equals(
					PrimarySchoolAttachedFileClp.class.getName())) {
			return translateInputPrimarySchoolAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(PrimarySchoolParentClp.class.getName())) {
			return translateInputPrimarySchoolParent(oldModel);
		}

		if (oldModelClassName.equals(PrimarySchoolStudentClp.class.getName())) {
			return translateInputPrimarySchoolStudent(oldModel);
		}

		if (oldModelClassName.equals(QuestionClp.class.getName())) {
			return translateInputQuestion(oldModel);
		}

		if (oldModelClassName.equals(QuestionAttachedFileClp.class.getName())) {
			return translateInputQuestionAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(RecruitmentClp.class.getName())) {
			return translateInputRecruitment(oldModel);
		}

		if (oldModelClassName.equals(RecruitmentAttachedFileClp.class.getName())) {
			return translateInputRecruitmentAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(
					RecruitmentEducationalHistoryClp.class.getName())) {
			return translateInputRecruitmentEducationalHistory(oldModel);
		}

		if (oldModelClassName.equals(RecruitmentLanguagesClp.class.getName())) {
			return translateInputRecruitmentLanguages(oldModel);
		}

		if (oldModelClassName.equals(RecruitmentProgrammingsClp.class.getName())) {
			return translateInputRecruitmentProgrammings(oldModel);
		}

		if (oldModelClassName.equals(
					RecruitmentTrainingCoursesClp.class.getName())) {
			return translateInputRecruitmentTrainingCourses(oldModel);
		}

		if (oldModelClassName.equals(ScheduleClp.class.getName())) {
			return translateInputSchedule(oldModel);
		}

		if (oldModelClassName.equals(StaffInfoClp.class.getName())) {
			return translateInputStaffInfo(oldModel);
		}

		if (oldModelClassName.equals(UserfulContactPhoneClp.class.getName())) {
			return translateInputUserfulContactPhone(oldModel);
		}

		if (oldModelClassName.equals(UserScheduleClp.class.getName())) {
			return translateInputUserSchedule(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAnswer(BaseModel<?> oldModel) {
		AnswerClp oldClpModel = (AnswerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnswerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAnswerAttachedFile(BaseModel<?> oldModel) {
		AnswerAttachedFileClp oldClpModel = (AnswerAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAnswerAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBNContact(BaseModel<?> oldModel) {
		BNContactClp oldClpModel = (BNContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBNContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBNNews(BaseModel<?> oldModel) {
		BNNewsClp oldClpModel = (BNNewsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBNNewsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEnrolment(BaseModel<?> oldModel) {
		EnrolmentClp oldClpModel = (EnrolmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnrolmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEnrolmentAttachedFile(
		BaseModel<?> oldModel) {
		EnrolmentAttachedFileClp oldClpModel = (EnrolmentAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEnrolmentAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInvestmentProjects(BaseModel<?> oldModel) {
		InvestmentProjectsClp oldClpModel = (InvestmentProjectsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInvestmentProjectsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrganizations(BaseModel<?> oldModel) {
		OrganizationsClp oldClpModel = (OrganizationsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrganizationsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPreschoolAttachedFile(
		BaseModel<?> oldModel) {
		PreschoolAttachedFileClp oldClpModel = (PreschoolAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPreschoolAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPreschoolParent(BaseModel<?> oldModel) {
		PreschoolParentClp oldClpModel = (PreschoolParentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPreschoolParentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPreschoolStudent(BaseModel<?> oldModel) {
		PreschoolStudentClp oldClpModel = (PreschoolStudentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPreschoolStudentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrimarySchoolAttachedFile(
		BaseModel<?> oldModel) {
		PrimarySchoolAttachedFileClp oldClpModel = (PrimarySchoolAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrimarySchoolAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrimarySchoolParent(
		BaseModel<?> oldModel) {
		PrimarySchoolParentClp oldClpModel = (PrimarySchoolParentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrimarySchoolParentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPrimarySchoolStudent(
		BaseModel<?> oldModel) {
		PrimarySchoolStudentClp oldClpModel = (PrimarySchoolStudentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPrimarySchoolStudentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestion(BaseModel<?> oldModel) {
		QuestionClp oldClpModel = (QuestionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQuestionAttachedFile(
		BaseModel<?> oldModel) {
		QuestionAttachedFileClp oldClpModel = (QuestionAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQuestionAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitment(BaseModel<?> oldModel) {
		RecruitmentClp oldClpModel = (RecruitmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitmentAttachedFile(
		BaseModel<?> oldModel) {
		RecruitmentAttachedFileClp oldClpModel = (RecruitmentAttachedFileClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentAttachedFileRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitmentEducationalHistory(
		BaseModel<?> oldModel) {
		RecruitmentEducationalHistoryClp oldClpModel = (RecruitmentEducationalHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentEducationalHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitmentLanguages(
		BaseModel<?> oldModel) {
		RecruitmentLanguagesClp oldClpModel = (RecruitmentLanguagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentLanguagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitmentProgrammings(
		BaseModel<?> oldModel) {
		RecruitmentProgrammingsClp oldClpModel = (RecruitmentProgrammingsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentProgrammingsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecruitmentTrainingCourses(
		BaseModel<?> oldModel) {
		RecruitmentTrainingCoursesClp oldClpModel = (RecruitmentTrainingCoursesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecruitmentTrainingCoursesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSchedule(BaseModel<?> oldModel) {
		ScheduleClp oldClpModel = (ScheduleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScheduleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStaffInfo(BaseModel<?> oldModel) {
		StaffInfoClp oldClpModel = (StaffInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStaffInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserfulContactPhone(
		BaseModel<?> oldModel) {
		UserfulContactPhoneClp oldClpModel = (UserfulContactPhoneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserfulContactPhoneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserSchedule(BaseModel<?> oldModel) {
		UserScheduleClp oldClpModel = (UserScheduleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserScheduleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.AnswerImpl")) {
			return translateOutputAnswer(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.AnswerAttachedFileImpl")) {
			return translateOutputAnswerAttachedFile(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.BNContactImpl")) {
			return translateOutputBNContact(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.BNNewsImpl")) {
			return translateOutputBNNews(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.EnrolmentImpl")) {
			return translateOutputEnrolment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.EnrolmentAttachedFileImpl")) {
			return translateOutputEnrolmentAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.InvestmentProjectsImpl")) {
			return translateOutputInvestmentProjects(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.OrganizationsImpl")) {
			return translateOutputOrganizations(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PreschoolAttachedFileImpl")) {
			return translateOutputPreschoolAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PreschoolParentImpl")) {
			return translateOutputPreschoolParent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PreschoolStudentImpl")) {
			return translateOutputPreschoolStudent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PrimarySchoolAttachedFileImpl")) {
			return translateOutputPrimarySchoolAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PrimarySchoolParentImpl")) {
			return translateOutputPrimarySchoolParent(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.PrimarySchoolStudentImpl")) {
			return translateOutputPrimarySchoolStudent(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.QuestionImpl")) {
			return translateOutputQuestion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.QuestionAttachedFileImpl")) {
			return translateOutputQuestionAttachedFile(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.RecruitmentImpl")) {
			return translateOutputRecruitment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.RecruitmentAttachedFileImpl")) {
			return translateOutputRecruitmentAttachedFile(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.RecruitmentEducationalHistoryImpl")) {
			return translateOutputRecruitmentEducationalHistory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.RecruitmentLanguagesImpl")) {
			return translateOutputRecruitmentLanguages(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.RecruitmentProgrammingsImpl")) {
			return translateOutputRecruitmentProgrammings(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.RecruitmentTrainingCoursesImpl")) {
			return translateOutputRecruitmentTrainingCourses(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.ScheduleImpl")) {
			return translateOutputSchedule(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.StaffInfoImpl")) {
			return translateOutputStaffInfo(oldModel);
		}

		if (oldModelClassName.equals(
					"com.fsoft.bn.model.impl.UserfulContactPhoneImpl")) {
			return translateOutputUserfulContactPhone(oldModel);
		}

		if (oldModelClassName.equals("com.fsoft.bn.model.impl.UserScheduleImpl")) {
			return translateOutputUserSchedule(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.fsoft.bn.NoSuchAnswerException")) {
			return new com.fsoft.bn.NoSuchAnswerException();
		}

		if (className.equals("com.fsoft.bn.NoSuchAnswerAttachedFileException")) {
			return new com.fsoft.bn.NoSuchAnswerAttachedFileException();
		}

		if (className.equals("com.fsoft.bn.NoSuchContactException")) {
			return new com.fsoft.bn.NoSuchContactException();
		}

		if (className.equals("com.fsoft.bn.NoSuchNewsException")) {
			return new com.fsoft.bn.NoSuchNewsException();
		}

		if (className.equals("com.fsoft.bn.NoSuchEnrolmentException")) {
			return new com.fsoft.bn.NoSuchEnrolmentException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchEnrolmentAttachedFileException")) {
			return new com.fsoft.bn.NoSuchEnrolmentAttachedFileException();
		}

		if (className.equals("com.fsoft.bn.NoSuchInvestmentProjectsException")) {
			return new com.fsoft.bn.NoSuchInvestmentProjectsException();
		}

		if (className.equals("com.fsoft.bn.NoSuchOrganizationsException")) {
			return new com.fsoft.bn.NoSuchOrganizationsException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchPreschoolAttachedFileException")) {
			return new com.fsoft.bn.NoSuchPreschoolAttachedFileException();
		}

		if (className.equals("com.fsoft.bn.NoSuchPreschoolParentException")) {
			return new com.fsoft.bn.NoSuchPreschoolParentException();
		}

		if (className.equals("com.fsoft.bn.NoSuchPreschoolStudentException")) {
			return new com.fsoft.bn.NoSuchPreschoolStudentException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException")) {
			return new com.fsoft.bn.NoSuchPrimarySchoolAttachedFileException();
		}

		if (className.equals("com.fsoft.bn.NoSuchPrimarySchoolParentException")) {
			return new com.fsoft.bn.NoSuchPrimarySchoolParentException();
		}

		if (className.equals("com.fsoft.bn.NoSuchPrimarySchoolStudentException")) {
			return new com.fsoft.bn.NoSuchPrimarySchoolStudentException();
		}

		if (className.equals("com.fsoft.bn.NoSuchQuestionException")) {
			return new com.fsoft.bn.NoSuchQuestionException();
		}

		if (className.equals("com.fsoft.bn.NoSuchQuestionAttachedFileException")) {
			return new com.fsoft.bn.NoSuchQuestionAttachedFileException();
		}

		if (className.equals("com.fsoft.bn.NoSuchRecruitmentException")) {
			return new com.fsoft.bn.NoSuchRecruitmentException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchRecruitmentAttachedFileException")) {
			return new com.fsoft.bn.NoSuchRecruitmentAttachedFileException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException")) {
			return new com.fsoft.bn.NoSuchRecruitmentEducationalHistoryException();
		}

		if (className.equals("com.fsoft.bn.NoSuchRecruitmentLanguagesException")) {
			return new com.fsoft.bn.NoSuchRecruitmentLanguagesException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchRecruitmentProgrammingsException")) {
			return new com.fsoft.bn.NoSuchRecruitmentProgrammingsException();
		}

		if (className.equals(
					"com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException")) {
			return new com.fsoft.bn.NoSuchRecruitmentTrainingCoursesException();
		}

		if (className.equals("com.fsoft.bn.NoSuchScheduleException")) {
			return new com.fsoft.bn.NoSuchScheduleException();
		}

		if (className.equals("com.fsoft.bn.NoSuchStaffInfoException")) {
			return new com.fsoft.bn.NoSuchStaffInfoException();
		}

		if (className.equals("com.fsoft.bn.NoSuchUserfulContactPhoneException")) {
			return new com.fsoft.bn.NoSuchUserfulContactPhoneException();
		}

		if (className.equals("com.fsoft.bn.NoSuchUserScheduleException")) {
			return new com.fsoft.bn.NoSuchUserScheduleException();
		}

		return throwable;
	}

	public static Object translateOutputAnswer(BaseModel<?> oldModel) {
		AnswerClp newModel = new AnswerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnswerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAnswerAttachedFile(
		BaseModel<?> oldModel) {
		AnswerAttachedFileClp newModel = new AnswerAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAnswerAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBNContact(BaseModel<?> oldModel) {
		BNContactClp newModel = new BNContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBNContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBNNews(BaseModel<?> oldModel) {
		BNNewsClp newModel = new BNNewsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBNNewsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEnrolment(BaseModel<?> oldModel) {
		EnrolmentClp newModel = new EnrolmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnrolmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEnrolmentAttachedFile(
		BaseModel<?> oldModel) {
		EnrolmentAttachedFileClp newModel = new EnrolmentAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEnrolmentAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInvestmentProjects(
		BaseModel<?> oldModel) {
		InvestmentProjectsClp newModel = new InvestmentProjectsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInvestmentProjectsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrganizations(BaseModel<?> oldModel) {
		OrganizationsClp newModel = new OrganizationsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrganizationsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPreschoolAttachedFile(
		BaseModel<?> oldModel) {
		PreschoolAttachedFileClp newModel = new PreschoolAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPreschoolAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPreschoolParent(BaseModel<?> oldModel) {
		PreschoolParentClp newModel = new PreschoolParentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPreschoolParentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPreschoolStudent(BaseModel<?> oldModel) {
		PreschoolStudentClp newModel = new PreschoolStudentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPreschoolStudentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrimarySchoolAttachedFile(
		BaseModel<?> oldModel) {
		PrimarySchoolAttachedFileClp newModel = new PrimarySchoolAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrimarySchoolAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrimarySchoolParent(
		BaseModel<?> oldModel) {
		PrimarySchoolParentClp newModel = new PrimarySchoolParentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrimarySchoolParentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPrimarySchoolStudent(
		BaseModel<?> oldModel) {
		PrimarySchoolStudentClp newModel = new PrimarySchoolStudentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPrimarySchoolStudentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestion(BaseModel<?> oldModel) {
		QuestionClp newModel = new QuestionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQuestionAttachedFile(
		BaseModel<?> oldModel) {
		QuestionAttachedFileClp newModel = new QuestionAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQuestionAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitment(BaseModel<?> oldModel) {
		RecruitmentClp newModel = new RecruitmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitmentAttachedFile(
		BaseModel<?> oldModel) {
		RecruitmentAttachedFileClp newModel = new RecruitmentAttachedFileClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentAttachedFileRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitmentEducationalHistory(
		BaseModel<?> oldModel) {
		RecruitmentEducationalHistoryClp newModel = new RecruitmentEducationalHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentEducationalHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitmentLanguages(
		BaseModel<?> oldModel) {
		RecruitmentLanguagesClp newModel = new RecruitmentLanguagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentLanguagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitmentProgrammings(
		BaseModel<?> oldModel) {
		RecruitmentProgrammingsClp newModel = new RecruitmentProgrammingsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentProgrammingsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecruitmentTrainingCourses(
		BaseModel<?> oldModel) {
		RecruitmentTrainingCoursesClp newModel = new RecruitmentTrainingCoursesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecruitmentTrainingCoursesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSchedule(BaseModel<?> oldModel) {
		ScheduleClp newModel = new ScheduleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScheduleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStaffInfo(BaseModel<?> oldModel) {
		StaffInfoClp newModel = new StaffInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStaffInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserfulContactPhone(
		BaseModel<?> oldModel) {
		UserfulContactPhoneClp newModel = new UserfulContactPhoneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserfulContactPhoneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserSchedule(BaseModel<?> oldModel) {
		UserScheduleClp newModel = new UserScheduleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserScheduleRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}