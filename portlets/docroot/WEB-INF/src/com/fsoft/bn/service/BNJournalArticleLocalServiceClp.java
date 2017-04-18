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

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author FSOFT
 */
public class BNJournalArticleLocalServiceClp
	implements BNJournalArticleLocalService {
	public BNJournalArticleLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getNewsPage";

		_methodParameterTypes3 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsConfig", "long",
				"java.lang.String", "int"
			};

		_methodName4 = "getNewsPage";

		_methodParameterTypes4 = new String[] {
				"javax.portlet.PortletRequest",
				"com.fsoft.bn.domain.news.NewsListConfig", "int"
			};

		_methodName5 = "getNews";

		_methodParameterTypes5 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"int", "int", "boolean", "java.util.List"
			};

		_methodName6 = "getNews";

		_methodParameterTypes6 = new String[] {
				"javax.portlet.PortletRequest", "java.lang.String", "long",
				"java.lang.String", "int", "int", "boolean", "java.util.List"
			};

		_methodName7 = "getNewsInCategories";

		_methodParameterTypes7 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.util.List", "int", "java.util.List", "java.util.Date",
				"java.util.Date"
			};

		_methodName8 = "getListOtherNewsInDetailPage";

		_methodParameterTypes8 = new String[] {
				"javax.portlet.PortletRequest", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.List"
			};
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsConfig config, long categoryid,
		java.lang.String cateName, int currentPageNum) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					ClpSerializer.translateInput(config),
						
					categoryid,
						
					ClpSerializer.translateInput(cateName),
						
					currentPageNum
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.fsoft.bn.domain.news.NewsPage)ClpSerializer.translateOutput(returnObj);
	}

	public com.fsoft.bn.domain.news.NewsPage getNewsPage(
		javax.portlet.PortletRequest req,
		com.fsoft.bn.domain.news.NewsListConfig config, int currentPageNum) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					ClpSerializer.translateInput(config),
						
					currentPageNum
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.fsoft.bn.domain.news.NewsPage)ClpSerializer.translateOutput(returnObj);
	}

	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, int numPerPage, int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					ClpSerializer.translateInput(structId),
						
					categoryId,
						
					numPerPage,
						
					currentPageNum,
						
					paging,
						
					ClpSerializer.translateInput(sortbys)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.fsoft.bn.domain.news.NewsPage)ClpSerializer.translateOutput(returnObj);
	}

	public com.fsoft.bn.domain.news.NewsPage getNews(
		javax.portlet.PortletRequest req, java.lang.String structId,
		long categoryId, java.lang.String cateName, int numPerPage,
		int currentPageNum, boolean paging,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					ClpSerializer.translateInput(structId),
						
					categoryId,
						
					ClpSerializer.translateInput(cateName),
						
					numPerPage,
						
					currentPageNum,
						
					paging,
						
					ClpSerializer.translateInput(sortbys)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.fsoft.bn.domain.news.NewsPage)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.fsoft.bn.domain.news.News> getNewsInCategories(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId,
		java.util.List<com.fsoft.bn.domain.news.NewsCategory> lstNewsCate,
		int numberOfRecord,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys,
		java.util.Date fromDate, java.util.Date toDate) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					groupId,
						
					ClpSerializer.translateInput(structureId),
						
					ClpSerializer.translateInput(lstNewsCate),
						
					numberOfRecord,
						
					ClpSerializer.translateInput(sortbys),
						
					ClpSerializer.translateInput(fromDate),
						
					ClpSerializer.translateInput(toDate)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.fsoft.bn.domain.news.News>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.fsoft.bn.domain.news.News> getListOtherNewsInDetailPage(
		javax.portlet.PortletRequest req, long groupId,
		java.lang.String structureId, java.lang.String articleId,
		java.lang.String categoriesId, java.lang.String cateName,
		java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(req),
						
					groupId,
						
					ClpSerializer.translateInput(structureId),
						
					ClpSerializer.translateInput(articleId),
						
					ClpSerializer.translateInput(categoriesId),
						
					ClpSerializer.translateInput(cateName),
						
					ClpSerializer.translateInput(sortbys)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.fsoft.bn.domain.news.News>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
}