package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.fsoft.bn.constant.CommonConstants.PAGING;
import com.fsoft.bn.constant.ResourceBundleConstants;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.language.LanguageUtil;

public class Page<T> implements Serializable {

	private static final long serialVersionUID = -3031582573898226071L;
	protected int totalPageNum;
	protected int currentPageNum = 1;
	protected int recordPerPage = 1;
	protected int pageRange = PAGING.DEFAULT_PAGE_RANGE;

	protected boolean isClickRow;
	protected boolean hasFirtPageButton;
	protected boolean hasPreviousPageButton;
	protected boolean hasNextPageButton;
	protected boolean hasLastPageButton;
	protected String loadPageURL;

	protected String currentPageText;
	protected String itemsPerPageText;

	protected List<T> items;
	protected Locale locale;

	public Page(PortletRequest req, int totalPageNum, int currentPageNum, int recordPerPage, List<T> items) {
		setTotalPageNum(totalPageNum);
		setCurrentPageNum(currentPageNum);
		setItems(items);
		setRecordPerPage(recordPerPage);
		setLocale(PortalUtil.getLocale(PortalUtil.getHttpServletRequest(req)));

		if (currentPageNum > 1) {
			hasFirtPageButton = true;
			hasPreviousPageButton = true;
		}

		if (currentPageNum < totalPageNum) {
			hasNextPageButton = true;
			hasLastPageButton = true;
		}

	}

	public Page(PortletRequest req) {
		items = new ArrayList<T>();
		setLocale(PortalUtil.getLocale((RenderRequest) req));
	}

	public Page() {
		items = new ArrayList<T>();
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		currentPageText = LanguageUtil
				.get(locale, ResourceBundleConstants.PAGING.CURRENT_PAGE, ResourceBundleConstants.PAGING.CURRENT_PAGE);
		itemsPerPageText = LanguageUtil.get(locale, ResourceBundleConstants.PAGING.ITEM_PER_PAGE,
				ResourceBundleConstants.PAGING.ITEM_PER_PAGE);
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public String getCurrentPageText() {
		return currentPageText;
	}

	public void setCurrentPageText(String currentPageText) {
		this.currentPageText = currentPageText;
	}

	public String getItemsPerPageText() {
		return itemsPerPageText;
	}

	public void setItemsPerPageText(String itemsPerPageText) {
		this.itemsPerPageText = itemsPerPageText;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLoadPageURL() {
		return loadPageURL;
	}

	public void setLoadPageURL(String loadPageURL) {
		this.loadPageURL = loadPageURL;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public boolean isClickRow() {
		return isClickRow;
	}

	public void setClickRow(boolean isClickRow) {
		this.isClickRow = isClickRow;
	}

	public boolean isHasFirtPageButton() {
		return hasFirtPageButton;
	}

	public void setHasFirtPageButton(boolean hasFirtPageButton) {
		this.hasFirtPageButton = hasFirtPageButton;
	}

	public boolean isHasPreviousPageButton() {
		return hasPreviousPageButton;
	}

	public void setHasPreviousPageButton(boolean hasPreviousPageButton) {
		this.hasPreviousPageButton = hasPreviousPageButton;
	}

	public boolean isHasNextPageButton() {
		return hasNextPageButton;
	}

	public void setHasNextPageButton(boolean hasNextPageButton) {
		this.hasNextPageButton = hasNextPageButton;
	}

	public boolean isHasLastPageButton() {
		return hasLastPageButton;
	}

	public void setHasLastPageButton(boolean hasLastPageButton) {
		this.hasLastPageButton = hasLastPageButton;
	}

	public int getPageRange() {
		return pageRange;
	}

	public void setPageRange(int pageRange) {
		this.pageRange = pageRange;
	}

}