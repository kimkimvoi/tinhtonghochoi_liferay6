package com.fsoft.bn.domain.news;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.constant.ResourceBundleConstants;
import com.fsoft.bn.domain.Page;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.util.DateUtils;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.StringUtil;

public class NewsPage extends Page<News> {

	private static final long serialVersionUID = 3511068756542401517L;

	private String displayType;

	private String viewMoreText;
	
	private String currentDate;

	public NewsPage(PortletRequest req, int numOfPage, int pageNum, int recordPerPage, List<News> items) {
		super(req, numOfPage, pageNum, recordPerPage, items);
		this.currentDate = DateUtils.getSystemDate(CommonConstants.DATE_FORMAT.DD_MM_YYYY_DASH);
	}

	public NewsPage(PortletRequest req) {
		super(req);
	}

	public NewsPage() {
	}

	public void updateConfig(NewsConfig config) {
		setDisplayType(config.getDisplayType());
		trimSummary(config.getSummaryMaxLength());
	}

	public void trimSummary(int maximum_word_length) {
		if (displayType.equals(NewsContants.DISPLAY_TYPE_SUMMARY)) {
			for (News item : items) {
				item.setSummary(StringUtil.shorten(item.getSummary(), maximum_word_length, StringUtils.EMPTY));
			}
		}
	}

	@Override
	public void setLocale(Locale locale) {
		super.setLocale(locale);
		viewMoreText = LanguageUtil.get(locale, ResourceBundleConstants.NEWS.VIEW_MORE);
	}

	public String getViewMoreText() {
		return viewMoreText;
	}

	public void setViewMoreText(String viewMoreText) {
		this.viewMoreText = viewMoreText;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	
	/**
	 * @return the currentDate
	 */
	public String getCurrentDate() {
		return currentDate;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "NewsPage [displayType=" + displayType + ", viewMoreText=" + viewMoreText + ", totalPageNum=" + totalPageNum
				+ ", currentPageNum=" + currentPageNum + ", recordPerPage=" + recordPerPage + ", pageRange=" + pageRange
				+ ", hasFirtPageButton=" + hasFirtPageButton + ", hasPreviousPageButton=" + hasPreviousPageButton + ", hasNextPageButton="
				+ hasNextPageButton + ", hasLastPageButton=" + hasLastPageButton + ", loadPageURL=" + loadPageURL + ", currentPageText="
				+ currentPageText + ", itemsPerPageText=" + itemsPerPageText + ", items=" + items + ", locale=" + locale + "]";
	}
	
}
