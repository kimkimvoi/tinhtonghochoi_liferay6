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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author FSOFT
 */
public class QuestionFinderUtil {
	public static java.util.List<com.fsoft.bn.model.Question> searchQuestion(
		java.lang.String quesType, java.lang.String quesSts,
		java.lang.String content, int begin, int end) {
		return getFinder().searchQuestion(quesType, quesSts, content, begin, end);
	}

	public static java.util.List<com.fsoft.bn.model.Question> searchQues(
		java.lang.String quesType, java.lang.String quesSts,
		java.lang.String content, int begin, int end) {
		return getFinder().searchQues(quesType, quesSts, content, begin, end);
	}

	public static java.util.List searchContent(java.lang.String quesType,
		java.lang.String quesSts, java.lang.String content, int begin, int end) {
		return getFinder().searchContent(quesType, quesSts, content, begin, end);
	}

	public static QuestionFinder getFinder() {
		if (_finder == null) {
			_finder = (QuestionFinder)PortletBeanLocatorUtil.locate(com.fsoft.bn.service.ClpSerializer.getServletContextName(),
					QuestionFinder.class.getName());

			ReferenceRegistry.registerReference(QuestionFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(QuestionFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(QuestionFinderUtil.class, "_finder");
	}

	private static QuestionFinder _finder;
}