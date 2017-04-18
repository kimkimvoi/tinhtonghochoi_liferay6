package com.fsoft.bn.domain;

import java.util.List;

import com.fsoft.bn.model.InvestmentProjects;

public class InvestmentAndDevelopmentModel {
	public String keyProject;
	public String InvestmentAmountSelected;
	public List<DataDictionary> listInvestmentAmount;
	public List<InvestmentProjects> listInvestmentProjects;
	public String keyWordSearch;
	public UploadedFile uploadedFile;
	public List<String> investmentPropertyDisplay;
	public List<String> headerList;
	public String curPageStatusText;
	public String itemsPerPageText;
	public String numOfPage;
	public String numPerPage;
	public String investmentAmountMax;
	public String investmentAmountMin;
	public List<DataDictionary> currency;
	public List<DataDictionary> projectCategory;
	public String strLanguage;
	public String language;
	
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the projectCategory
	 */
	public List<DataDictionary> getProjectCategory() {
		return projectCategory;
	}
	/**
	 * @param projectCategory the projectCategory to set
	 */
	public void setProjectCategory(List<DataDictionary> projectCategory) {
		this.projectCategory = projectCategory;
	}
	/**
	 * @return the strLanguage
	 */
	public String getStrLanguage() {
		return strLanguage;
	}
	/**
	 * @param strLanguage the strLanguage to set
	 */
	public void setStrLanguage(String strLanguage) {
		this.strLanguage = strLanguage;
	}
	/**
	 * @return the investmentAmountMax
	 */
	public String getInvestmentAmountMax() {
		return investmentAmountMax;
	}
	/**
	 * @param investmentAmountMax the investmentAmountMax to set
	 */
	public void setInvestmentAmountMax(String investmentAmountMax) {
		this.investmentAmountMax = investmentAmountMax;
	}
	/**
	 * @return the investmentAmountMin
	 */
	public String getInvestmentAmountMin() {
		return investmentAmountMin;
	}
	/**
	 * @param investmentAmountMin the investmentAmountMin to set
	 */
	public void setInvestmentAmountMin(String investmentAmountMin) {
		this.investmentAmountMin = investmentAmountMin;
	}
	/**
	 * @return the currency
	 */
	public List<DataDictionary> getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(List<DataDictionary> currency) {
		this.currency = currency;
	}
	/**
	 * @return the numOfPage
	 */
	public String getNumOfPage() {
		return numOfPage;
	}
	/**
	 * @param numOfPage the numOfPage to set
	 */
	public void setNumOfPage(String numOfPage) {
		this.numOfPage = numOfPage;
	}
	/**
	 * @return the numPerPage
	 */
	public String getNumPerPage() {
		return numPerPage;
	}
	/**
	 * @param numPerPage the numPerPage to set
	 */
	public void setNumPerPage(String numPerPage) {
		this.numPerPage = numPerPage;
	}
	/**
	 * @return the curPageStatusText
	 */
	public String getCurPageStatusText() {
		return curPageStatusText;
	}
	/**
	 * @param curPageStatusText the curPageStatusText to set
	 */
	public void setCurPageStatusText(String curPageStatusText) {
		this.curPageStatusText = curPageStatusText;
	}
	/**
	 * @return the itemsPerPageText
	 */
	public String getItemsPerPageText() {
		return itemsPerPageText;
	}
	/**
	 * @param itemsPerPageText the itemsPerPageText to set
	 */
	public void setItemsPerPageText(String itemsPerPageText) {
		this.itemsPerPageText = itemsPerPageText;
	}
	/**
	 * @return the headerList
	 */
	public List<String> getHeaderList() {
		return headerList;
	}
	/**
	 * @param headerList the headerList to set
	 */
	public void setHeaderList(List<String> headerList) {
		this.headerList = headerList;
	}
	/**
	 * @return the investmentPropertyDisplay
	 */
	public List<String> getInvestmentPropertyDisplay() {
		return investmentPropertyDisplay;
	}
	/**
	 * @param investmentPropertyDisplay the investmentPropertyDisplay to set
	 */
	public void setInvestmentPropertyDisplay(List<String> investmentPropertyDisplay) {
		this.investmentPropertyDisplay = investmentPropertyDisplay;
	}
	/**
	 * @return the listInvestmentProjects
	 */
	public List<InvestmentProjects> getListInvestmentProjects() {
		return listInvestmentProjects;
	}
	/**
	 * @param listInvestmentProjects the listInvestmentProjects to set
	 */
	public void setListInvestmentProjects(
			List<InvestmentProjects> listInvestmentProjects) {
		this.listInvestmentProjects = listInvestmentProjects;
	}
	/**
	 * @return the listInvestmentAmount
	 */
	public List<DataDictionary> getListInvestmentAmount() {
		return listInvestmentAmount;
	}
	/**
	 * @param listInvestmentAmount the listInvestmentAmount to set
	 */
	public void setListInvestmentAmount(List<DataDictionary> listInvestmentAmount) {
		this.listInvestmentAmount = listInvestmentAmount;
	}
	/**
	 * @return the keyProject
	 */
	public String getKeyProject() {
		return keyProject;
	}
	/**
	 * @param keyProject the keyProject to set
	 */
	public void setKeyProject(String keyProject) {
		this.keyProject = keyProject;
	}
	/**
	 * @return the investmentAmountSelected
	 */
	public String getInvestmentAmountSelected() {
		return InvestmentAmountSelected;
	}
	/**
	 * @param investmentAmountSelected the investmentAmountSelected to set
	 */
	public void setInvestmentAmountSelected(String investmentAmountSelected) {
		InvestmentAmountSelected = investmentAmountSelected;
	}
	/**
	 * @return the keyWordSearch
	 */
	public String getKeyWordSearch() {
		return keyWordSearch;
	}
	/**
	 * @param keyWordSearch the keyWordSearch to set
	 */
	public void setKeyWordSearch(String keyWordSearch) {
		this.keyWordSearch = keyWordSearch;
	}
	/**
	 * @return the uploadedFile
	 */
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
}
