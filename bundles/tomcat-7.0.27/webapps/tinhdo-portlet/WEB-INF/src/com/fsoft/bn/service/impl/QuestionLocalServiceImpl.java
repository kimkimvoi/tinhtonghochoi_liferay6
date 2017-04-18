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

package com.fsoft.bn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.bn.model.Question;
import com.fsoft.bn.service.base.QuestionLocalServiceBaseImpl;
import com.fsoft.bn.service.persistence.QuestionFinderUtil;
import com.fsoft.bn.service.persistence.QuestionUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fsoft.bn.service.QuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author YenMC
 * @see com.fsoft.bn.service.base.QuestionLocalServiceBaseImpl
 * @see com.fsoft.bn.service.QuestionLocalServiceUtil
 */
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {
	/** logger */
	private static Logger logger = Logger.getLogger(QuestionLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fsoft.bn.service.QuestionLocalServiceUtil} to access the question local service.
	 */
	public List<Question> getListQuestion() {
		List<Question> listQuestion = new ArrayList<Question>();
		try {
			listQuestion = QuestionUtil.findAll();
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		return listQuestion;
	}
	
	public List<Question> getListQuestion(String typeOfQues, String statusOfQues, String startIndex, String endIndex) {
		List<Question> listQuestion = new ArrayList<Question>();
		listQuestion = QuestionFinderUtil.searchQuestion("", "", "", 1, 2);
		//List<QuesTestModel> listQues = QuestionFinderUtil.searchContent("", "", "", 1, 2);
		return listQuestion;
	}

	@Override
	public List<Question> findAnsweredQuestions(String quesType,
			String searchKeyWord, int begin, int end) {
		// TODO Auto-generated method stub
		return null;
	}
}