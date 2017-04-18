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

import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class BNJournalArticleLocalServiceClpInvoker {
	public BNJournalArticleLocalServiceClpInvoker() {
		_methodName132 = "getBeanIdentifier";

		_methodParameterTypes132 = new String[] {  };

		_methodName133 = "setBeanIdentifier";

		_methodParameterTypes133 = new String[] { "java.lang.String" };

		_methodName136 = "getNewsPage";

		_methodParameterTypes136 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsConfig", "long",
				"java.lang.String", "int"
			};

		_methodName137 = "getNewsPage";

		_methodParameterTypes137 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsListConfig", "int"
			};

		_methodName138 = "getNews";

		_methodParameterTypes138 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"int", "int", "boolean", "java.util.List"
			};

		_methodName139 = "getNews";

		_methodParameterTypes139 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"java.lang.String", "int", "int", "boolean", "java.util.List"
			};

		_methodName140 = "getNewsInCategories";

		_methodParameterTypes140 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.util.List", "int", "java.util.List", "java.util.Date",
				"java.util.Date"
			};

		_methodName141 = "getListOtherNewsInDetailPage";

		_methodParameterTypes141 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			BNJournalArticleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsPage((javax.portlet.PortletRequest)arguments[0],
				(com.fsoft.bn.domain.news.NewsConfig)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue());
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsPage((javax.portlet.PortletRequest)arguments[0],
				(com.fsoft.bn.domain.news.NewsListConfig)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNews((javax.portlet.PortletRequest)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Boolean)arguments[5]).booleanValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[6]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNews((javax.portlet.PortletRequest)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[7]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsInCategories((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				(java.util.List<com.fsoft.bn.domain.news.NewsCategory>)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[5],
				(java.util.Date)arguments[6], (java.util.Date)arguments[7]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getListOtherNewsInDetailPage((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[6]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
}