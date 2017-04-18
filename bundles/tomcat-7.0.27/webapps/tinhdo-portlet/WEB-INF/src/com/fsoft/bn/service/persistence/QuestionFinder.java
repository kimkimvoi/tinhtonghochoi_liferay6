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

/**
 * @author FSOFT
 */
public interface QuestionFinder {
	public java.util.List<com.fsoft.bn.model.Question> searchQuestion(
		java.lang.String quesType, java.lang.String quesSts,
		java.lang.String content, int begin, int end);

	public java.util.List<com.fsoft.bn.model.Question> searchQues(
		java.lang.String quesType, java.lang.String quesSts,
		java.lang.String content, int begin, int end);

	public java.util.List searchContent(java.lang.String quesType,
		java.lang.String quesSts, java.lang.String content, int begin, int end);
}