package com.fsoft.bn.domain;

import java.util.List;

public class InvestmentAndDevelopmentConfigModel {
	public List<DataDictionary> listViewModel;
	public DataDictionary defaultCombobox;
	public String defaultModeSelected;
	
	

	/**
	 * @return the defaultModeSelected
	 */
	public String getDefaultModeSelected() {
		return defaultModeSelected;
	}

	/**
	 * @param defaultModeSelected the defaultModeSelected to set
	 */
	public void setDefaultModeSelected(String defaultModeSelected) {
		this.defaultModeSelected = defaultModeSelected;
	}

	/**
	 * @return the defaultCombobox
	 */
	public DataDictionary getDefaultCombobox() {
		return defaultCombobox;
	}

	/**
	 * @param defaultCombobox the defaultCombobox to set
	 */
	public void setDefaultCombobox(DataDictionary defaultCombobox) {
		this.defaultCombobox = defaultCombobox;
	}

	/**
	 * @return the listViewModel
	 */
	public List<DataDictionary> getListViewModel() {
		return listViewModel;
	}

	/**
	 * @param listViewModel the listViewModel to set
	 */
	public void setListViewModel(List<DataDictionary> listViewModel) {
		this.listViewModel = listViewModel;
	}
	
}
