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
		_methodName76 = "getBeanIdentifier";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "setBeanIdentifier";

		_methodParameterTypes77 = new String[] { "java.lang.String" };

		_methodName80 = "getNewsPage";

		_methodParameterTypes80 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsConfig", "long",
				"java.lang.String", "int"
			};

		_methodName81 = "getNewsPage";

		_methodParameterTypes81 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsListConfig", "int"
			};

		_methodName82 = "getNews";

		_methodParameterTypes82 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"int", "int", "boolean", "java.util.List"
			};

		_methodName83 = "getNews";

		_methodParameterTypes83 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"java.lang.String", "int", "int", "boolean", "java.util.List"
			};

		_methodName84 = "getNewsInCategories";

		_methodParameterTypes84 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.util.List", "int", "java.util.List", "java.util.Date",
				"java.util.Date"
			};

		_methodName85 = "getListOtherNewsInDetailPage";

		_methodParameterTypes85 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			BNJournalArticleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsPage((javax.portlet.PortletRequest)arguments[0],
				(com.fsoft.bn.domain.news.NewsConfig)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsPage((javax.portlet.PortletRequest)arguments[0],
				(com.fsoft.bn.domain.news.NewsListConfig)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNews((javax.portlet.PortletRequest)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Boolean)arguments[5]).booleanValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[6]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNews((javax.portlet.PortletRequest)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue(),
				((Boolean)arguments[6]).booleanValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[7]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getNewsInCategories((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				(java.util.List<com.fsoft.bn.domain.news.NewsCategory>)arguments[3],
				((Integer)arguments[4]).intValue(),
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[5],
				(java.util.Date)arguments[6], (java.util.Date)arguments[7]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return BNJournalArticleLocalServiceUtil.getListOtherNewsInDetailPage((javax.portlet.PortletRequest)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.util.List<com.liferay.portal.kernel.util.KeyValuePair>)arguments[6]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
}