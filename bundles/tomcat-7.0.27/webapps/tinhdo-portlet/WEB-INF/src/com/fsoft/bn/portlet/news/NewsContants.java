package com.fsoft.bn.portlet.news;


import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.KeyValuePair;

/**
 * Constant for news structure
 * 
 * @author ThangBN1
 * 
 */
public class NewsContants {

	public static final String NEWS_STRUCTURE_NAME = "News";
	public static final String NEWS_COMMON_STRUCTURE_NAME = "Tin tức chung";

	public static final String DEFAULT_SORT_FIELD = "modifiedDate";
	public static final String VISITOR_STRUCTURE_NAME = "Du Khách 2";

	public final class PORTLET_NAME {
		public static final String NEWS_DETAIL = "newsdetail_WAR_tinhdoportlet";
		public static final String ALL_NEWS_BY_CATEGORY = "listallnewsbycategory_WAR_tinhdoportlet";
	}

	public final class XSD_ELEMENT_NAME {
		public static final String CONTENT = "content";
		public static final String CATEGORY = "type";
		public static final String SOURCE = "source";
		public static final String AUTHOR = "author";
	}

	public final class RESOURCE_ACTION {
		public static final String LOAD_PAGE = "loadPage";
		public static final String NEWS_BY_CATEGORY_SEARCH_AJAX = "newsByCategorySearchAjax";
		public static final String SWITCH_TAB = "switchTab";

		public final class PARAMETER {
			public static final String PARAMETER_CATEGORY_ID = "categoryId";
			public static final String PAGE_NUM = "pageNum";
			public static final String KEYWORD = "keyword";
			public static final String INPUT_TEXT = "inputText";
		}
	}

	public static final int[] NUM_PER_PAGE_VALUES = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 25, 30, 40, 50 };
	public static final int[] SUMMARY_MAX_LENGTH_VALUES = new int[] { 20, 30, 50, 100, 150, 200, 300 };

	public final class CONFIG_KEY {
		public static final String CURRENT_STRUCT = "current_struct";
		public static final String CURRENT_CATEGORY = "current_category";
		public static final String NUM_PER_PAGE = "num_per_page";
		public static final String INCLUDE_PAGING = "include_paging";
		public static final String INCLUDE_SEARCHING = "include_searching";
		public static final String CURRENT_CATEGORY_ORDER = "current_category_order";
		public static final String DISPLAY_TYPE = "display_type";
		public static final String SORTBYS = "sortbys";
		public static final String SORT_BY_TYPE = "sortbyType";
		public static final String SORT_BY_NAME = "sortbyName";
		public static final String SUMMARY_MAX_LENGTH = "summary_max_length";
		public static final String DETAIL_TABLE_FIELDS = "detail_table_fields";
	}

	public final class CONFIG_DEFAULT_VALUE {
		public static final int NUM_PER_PAGE = 3;
		public static final int SUMMARY_MAX_LENGTH = 100;
	}

	public final class FRIENDLY_URL {
		public static final String DETAIL_URL_CONFIG = "detailURL";
		public static final String NEWS_VIEW_DETAIL = "/news";
		public static final String THONGTINTINH_VIEW_DETAIL = "/thong-tin-tinh-chitiet";
		public static final String DAUTU_VIEW_DETAIL = "/dau-tu-phat-trien-chi-tiet";
		public static final String DUKHACH_VIEW_DETAIL = "/du-khach-chi-tiet";
	}

	public static final String DISPLAY_TYPE_SUMMARY = "portlet.news.config.display-type.summary";
	public static final String DISPLAY_TYPE_TABLE = "portlet.news.config.display-type.table";
	public static final String DISPLAY_TYPE_TITLE_ONLY = "portlet.news.config.display-type.title-only";
	public static final String DISPLAY_TYPE_VISITOR = "portlet.news.config.display-type.visitor";

	public static final String[] DISPLAY_TYPES = new String[] { DISPLAY_TYPE_TITLE_ONLY, DISPLAY_TYPE_SUMMARY, DISPLAY_TYPE_VISITOR };

	public static final List<KeyValuePair> SORTBY_OPTIONS;

	public static final List<KeyValuePair> SORTBY_TYPES;

	static {
		SORTBY_OPTIONS = new ArrayList<KeyValuePair>();
		SORTBY_OPTIONS.add(new KeyValuePair("title", "title"));
		SORTBY_OPTIONS.add(new KeyValuePair("createDate", "create-date"));
		SORTBY_OPTIONS.add(new KeyValuePair("modifiedDate", "modified-date"));
//		SORTBY_OPTIONS.add(new KeyValuePair("publishDate", "publish-date"));
		SORTBY_OPTIONS.add(new KeyValuePair("DISPLAYDATE", "publish-date"));
//		SORTBY_OPTIONS.add(new KeyValuePair("expirationDate", "expiration-date"));
//		SORTBY_OPTIONS.add(new KeyValuePair("priority", "priority"));
		SORTBY_OPTIONS.add(new KeyValuePair("viewCount", "view.count"));
//		SORTBY_OPTIONS.add(new KeyValuePair("ratings", "ratings"));

		SORTBY_TYPES = new ArrayList<KeyValuePair>();
		SORTBY_TYPES.add(new KeyValuePair("ASC", "ascending"));
		SORTBY_TYPES.add(new KeyValuePair("DESC", "descending"));
	}
}
