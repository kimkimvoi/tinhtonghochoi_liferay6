package com.fsoft.bn.service.persistence;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.util.BNCustomSQLUtil;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class BNJournalArticleFinderImpl extends BasePersistenceImpl<JournalArticle> implements BNJournalArticleFinder {
	/** logger */
	private static Logger logger = Logger.getLogger(BNJournalArticleFinderImpl.class);
	private static final String SQL_GET_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID = "getNews_Approved_Latest_GroupId_CategoryId";
	private static final String SQL_COUNT_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID = "countNews_Approved_Latest_GroupId_CategoryId";
	private static final String SQL_NEWS_APPROVED_LATEST_GROUP_ID_CATE_IDS_DISPLAY_DATE = "getNews_Approved_Latest_GroupId_CateIds_DisplayDate";
	private static final String SQL_LIST_OTHERS_NEWS_APPROVED_LATEST_GROUP_ID_CATEGORY_ID = "getOtherNews_Approved_Latest_GroupId_CategoryId";

	private static final String JOIN_ASSETENTRY_ASSETCATEGORY = "JOIN ASSETENTRIES_ASSETCATEGORIES "
			+ "ON ASSETENTRY.ENTRYID = ASSETENTRIES_ASSETCATEGORIES.ENTRYID " + "WHERE ASSETENTRIES_ASSETCATEGORIES.CATEGORYID = ?";
	
	private static final String JOIN_ASSETENTRY_ASSETCATEGORIES = "JOIN ASSETENTRIES_ASSETCATEGORIES "
			+ "ON ASSETENTRY.ENTRYID = ASSETENTRIES_ASSETCATEGORIES.ENTRYID " + "WHERE ASSETENTRIES_ASSETCATEGORIES.CATEGORYID ";
	private static final String APPEND_DISPLAYDATE_FROM = " AND DISPLAYDATE >= DATE'";
	private static final String APPEND_DISPLAYDATE_TO = " AND DISPLAYDATE <= DATE'";

	public int countNews(long groupId, String structureId, long categoryId) {
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;
		try {
			session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(SQL_COUNT_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID);

			if (categoryId > 0) {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORY$]", JOIN_ASSETENTRY_ASSETCATEGORY);
			} else {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORY$]", StringUtils.EMPTY);
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(WorkflowConstants.STATUS_APPROVED);
			qPos.add(structureId);
			if (categoryId > 0) {
				qPos.add(categoryId);
			}

			return BNCustomSQLUtil.getCount(q);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not perform query " + SQL_COUNT_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID + e.getMessage());
		} finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	public List<JournalArticle> getNews(long groupId, String structureId, final long categoryId, int start, int end,
			List<KeyValuePair> sortbys) {

		String sortBy;

		if (CollectionUtils.isEmpty(sortbys)) {
			sortBy = NewsContants.DEFAULT_SORT_FIELD;
		} else {
			sortBy = com.fsoft.bn.util.BNCustomSQLUtil.getOrderby(sortbys);
		}

		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;

		try {
			session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(SQL_GET_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID);

			if (categoryId > 0) {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORY$]", JOIN_ASSETENTRY_ASSETCATEGORY);
			} else {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORY$]", StringUtils.EMPTY);
			}
			sql = StringUtil.replace(sql, "[$ORDER_BY$]", sortBy);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("JournalArticle",
					PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.journal.model.impl.JournalArticleImpl"));

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(WorkflowConstants.STATUS_APPROVED);
			qPos.add(structureId);
			if (categoryId > 0) {
				qPos.add(categoryId);
			}

			return (List<JournalArticle>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not perform query " + SQL_GET_NEWS_LATEST_STATUS_GROUP_ID_CATEGORY_ID + e.getMessage());
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<JournalArticle> getNewsInCategories(long groupId, String structureId, String categoriesId, int numberRecord,
			List<KeyValuePair> sortbys, Date fromDate, Date toDate) {
		String sortBy;

		if (CollectionUtils.isEmpty(sortbys)) {
			sortBy = NewsContants.DEFAULT_SORT_FIELD;
		} else {
			sortBy = com.fsoft.bn.util.BNCustomSQLUtil.getOrderby(sortbys);
		}
		
		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;

		try {
			session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(SQL_NEWS_APPROVED_LATEST_GROUP_ID_CATE_IDS_DISPLAY_DATE);
			
			// get news in range dates
			if (null != fromDate && null != toDate) {
				DateUtils.date2String(fromDate, CommonConstants.DATE_FORMAT.YYYY_MM_DD);
				sql = StringUtil.replace(sql, "[$DISPLAYDATE_FROM$]", (APPEND_DISPLAYDATE_FROM 
						+ DateUtils.date2String(fromDate, CommonConstants.DATE_FORMAT.YYYY_MM_DD_DASH) + "'" + CommonConstants.SPACE));
				sql = StringUtil.replace(sql, "[$DISPLAYDATE_TO$]", (APPEND_DISPLAYDATE_TO
						+ DateUtils.date2String(toDate, CommonConstants.DATE_FORMAT.YYYY_MM_DD_DASH) + "'" + CommonConstants.SPACE));
			} else {
				sql = StringUtil.replace(sql, "[$DISPLAYDATE_FROM$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$DISPLAYDATE_TO$]", StringUtils.EMPTY);
			}
			
			//get news by category id
			if (!Validator.isBlankOrNull(categoriesId)) {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORIES$]", JOIN_ASSETENTRY_ASSETCATEGORIES);
				sql = StringUtil.replace(sql, "[$IN$]", " IN (");
				sql = StringUtil.replace(sql, "[$CATEGORIES_ID$]", categoriesId);
				sql = StringUtil.replace(sql, "[$END_CLOSE$]", ")");
			} else {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORIES$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$IN$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$CATEGORIES_ID$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$END_CLOSE$]", StringUtils.EMPTY);
			}
			sql = StringUtil.replace(sql, "[$ORDER_BY$]", sortBy);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("JournalArticle", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.journal.model.impl.JournalArticleImpl"));

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(WorkflowConstants.STATUS_APPROVED);
			qPos.add(structureId);

			return (List<JournalArticle>) QueryUtil.list(q, getDialect(), 0, numberRecord);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("Can not perform query " + SQL_NEWS_APPROVED_LATEST_GROUP_ID_CATE_IDS_DISPLAY_DATE + e.getMessage());
		} finally {
			closeSession(session);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getListOtherNewsInDetailPage(
			long groupId, java.lang.String structureId, String articleId, 
			java.lang.String categoriesId,
			java.util.List<com.liferay.portal.kernel.util.KeyValuePair> sortbys){

		String sortBy;

		if (CollectionUtils.isEmpty(sortbys)) {
			sortBy = NewsContants.DEFAULT_SORT_FIELD;
		} else {
			sortBy = com.fsoft.bn.util.BNCustomSQLUtil.getOrderby(sortbys);
		}

		SessionFactory sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
		Session session = null;

		try {
			session = sessionFactory.openSession();

			String sql = CustomSQLUtil.get(SQL_LIST_OTHERS_NEWS_APPROVED_LATEST_GROUP_ID_CATEGORY_ID);
			if (!Validator.isBlankOrNull(categoriesId)) {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORIES$]", JOIN_ASSETENTRY_ASSETCATEGORIES);
				sql = StringUtil.replace(sql, "[$IN$]", " IN (");
				sql = StringUtil.replace(sql, "[$CATEGORIES_ID$]", categoriesId);
				sql = StringUtil.replace(sql, "[$END_CLOSE$]", ")");
			} else {
				sql = StringUtil.replace(sql, "[$JOIN_ASSETENTRY_ASSETCATEGORIES$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$IN$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$CATEGORIES_ID$]", StringUtils.EMPTY);
				sql = StringUtil.replace(sql, "[$END_CLOSE$]", StringUtils.EMPTY);
			}
			sql = StringUtil.replace(sql, "[$ORDER_BY$]", sortBy + " DESC");

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("JournalArticle",
					PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.journal.model.impl.JournalArticleImpl"));

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(WorkflowConstants.STATUS_APPROVED);
			qPos.add(structureId);

			return (List<JournalArticle>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not perform query " + SQL_LIST_OTHERS_NEWS_APPROVED_LATEST_GROUP_ID_CATEGORY_ID + e.getMessage());
		} finally {
			closeSession(session);
		}
	}
}
