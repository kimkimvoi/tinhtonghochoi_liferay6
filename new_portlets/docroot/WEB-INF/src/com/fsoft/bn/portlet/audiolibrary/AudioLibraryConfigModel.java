package com.fsoft.bn.portlet.audiolibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.Config;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class AudioLibraryConfigModel extends Config {
	
	Logger logger = Logger.getLogger(AudioLibraryConfigModel.class);
	
	private List<KeyValuePair> availableCategoryList;
	private List<KeyValuePair> selectedCategoryList;
	private String selectedAuthor;
	private String selectedSortByName;
	private String selectedSortByType;
	private int selectedNumPerPage;
	private boolean isPaging;
	private boolean byCategory;
	
	public AudioLibraryConfigModel() {
		super();
	}
	
	public AudioLibraryConfigModel(PortletRequest request) {
		super(request);

		availableCategoryList = new ArrayList<KeyValuePair>();
		selectedCategoryList = new ArrayList<KeyValuePair>();
		
		String temp = prefs.getValue("selectedCategories", StringPool.BLANK);
		
		if (!Validator.isBlankOrNull(temp)) {
			String[] categories = temp.split(StringPool.COMMA);
			for (String string : categories) {
				try {
					selectedCategoryList.add(new KeyValuePair(string, DLFolderLocalServiceUtil.getFolder(Long.valueOf(string)).getName()));
				} catch (NumberFormatException e) {
					logger.error(e);
				} catch (PortalException e) {
					logger.error(e);
				} catch (SystemException e) {
					logger.error(e);
				}
			}
		}
		
		selectedAuthor = prefs.getValue("selectedAuthor", StringPool.BLANK);
		selectedSortByName = prefs.getValue("selectedSortByName", StringPool.BLANK);
		selectedSortByType = prefs.getValue("selectedSortByType", StringPool.BLANK);
		selectedNumPerPage = Integer.valueOf(prefs.getValue("selectedNumPerPage", String.valueOf("5")));
		isPaging = Boolean.valueOf(prefs.getValue("isPaging", StringPool.TRUE));
		byCategory = Boolean.valueOf(prefs.getValue("byCategory", StringPool.TRUE));
	}
	
	public void updateConfig(ActionRequest request, PortletPreferences prefs) throws ReadOnlyException, ValidatorException, IOException {

		//String[] availableCategories = ParamUtil.getParameterValues(request, "selectedCategories", new String[0]);
		String selectedCategories = ParamUtil.getString(request, "categories", StringPool.BLANK);
		//System.out.println("xxx: " + availableCategories);
		//System.out.println("yyy: " + selectedCategories);
		selectedAuthor = ParamUtil.getString(request, "author", StringPool.BLANK);
		selectedSortByName = ParamUtil.getString(request, "sortByName", StringPool.BLANK);
		selectedSortByType = ParamUtil.getString(request, "sortByType", StringPool.BLANK);
		selectedNumPerPage = ParamUtil.getInteger(request, "numPerPage", 0);
		isPaging = ParamUtil.getBoolean(request, "isPaging", false);
		byCategory = ParamUtil.getBoolean(request, "byCategory", false);

		//prefs.setValue("availableCategories", availableCategories);
		prefs.setValue("selectedCategories", selectedCategories);
		prefs.setValue("selectedAuthor", selectedAuthor);
		prefs.setValue("selectedSortByName", selectedSortByName);
		prefs.setValue("selectedSortByType", selectedSortByType);
		prefs.setValue("selectedNumPerPage", String.valueOf(selectedNumPerPage));
		prefs.setValue("isPaging", String.valueOf(isPaging));
		prefs.setValue("byCategory", String.valueOf(byCategory));
		
		prefs.store();
	}

	public List<KeyValuePair> getAvailableCategoryList() {
		return availableCategoryList;
	}

	public void setAvailableCategoryList(List<KeyValuePair> availableCategoryList) {
		this.availableCategoryList = availableCategoryList;
	}

	public List<KeyValuePair> getSelectedCategoryList() {
		return selectedCategoryList;
	}

	public void setSelectedCategoryList(List<KeyValuePair> selectedCategoryList) {
		this.selectedCategoryList = selectedCategoryList;
	}

	public String getSelectedAuthor() {
		return selectedAuthor;
	}

	public void setSelectedAuthor(String selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}

	public String getSelectedSortByName() {
		return selectedSortByName;
	}

	public void setSelectedSortByName(String selectedSortByName) {
		this.selectedSortByName = selectedSortByName;
	}

	public String getSelectedSortByType() {
		return selectedSortByType;
	}

	public void setSelectedSortByType(String selectedSortByType) {
		this.selectedSortByType = selectedSortByType;
	}

	public int getSelectedNumPerPage() {
		return selectedNumPerPage;
	}

	public void setSelectedNumPerPage(int selectedNumPerPage) {
		this.selectedNumPerPage = selectedNumPerPage;
	}

	public boolean getIsPaging() {
		return isPaging;
	}

	public void setIsPaging(boolean isPaging) {
		this.isPaging = isPaging;
	}
	
	public boolean getByCategory() {
		return byCategory;
	}
	
	public void setByCategory(boolean byCategory) {
		this.byCategory = byCategory;
	}
}
