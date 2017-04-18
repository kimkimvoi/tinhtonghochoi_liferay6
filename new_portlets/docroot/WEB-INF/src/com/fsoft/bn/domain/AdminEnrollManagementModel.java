package com.fsoft.bn.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.fsoft.bn.customJSPTags.TableTag;
import com.liferay.portal.theme.ThemeDisplay;

public class AdminEnrollManagementModel {
	
	private String enrolmentStatusSelected;
	private String enrolmentTextSearch;
	private List<EnrolmentModel> enrolmentList;
	private List<AttachFileModel> listEnrolmentAttach;
	private List<DataDictionary> listEnrolmentStatus;
	private int enrolmentPerPage;
	private long numOfPage;
	private String curPageStatusText;
	private String itemsPerPageText;
	private int startNumberOfPage;
	private int endNumberOfPage;
	private File []file;
	private String [] fileName;
	private ActionRequest request; 
	private DataDictionary defaultCombobox;
	private List<String> displayedPropertyList;
	private List<String> hiddenPropertyList;
	private List<String> headerList;
	private ThemeDisplay themeDisplay;
	private String enrolmentId;
	private String resultUpdate;
	
	public AdminEnrollManagementModel() {
		this.enrolmentPerPage 		= 10;
		this.startNumberOfPage  	= 0;
		this.endNumberOfPage 		= 10;
		this.displayedPropertyList 	= getDefaultDisplayedPropertyList();
		this.hiddenPropertyList 	= getDefaultHiddenPropertiesList();
	}
	
	/**
	 * @author QuangTN3
	 * @return display property in question list
	 */
	private static List<String> getDefaultDisplayedPropertyList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add(TableTag.STT);
		displayedPropertyList.add("hs_hoten");
		displayedPropertyList.add("hk_dia_chi");
		displayedPropertyList.add("ngay_tao");
		displayedPropertyList.add("trang_thai_hien_thi");
		return displayedPropertyList;
	}
	/**
	 * @author QuangTN3
	 * @return hidden property in question list
	 */
	private static List<String> getDefaultHiddenPropertiesList() {
		List<String> displayedPropertyList = new ArrayList<String>();
		displayedPropertyList.add("enrolmentId");
		displayedPropertyList.add("hs_quoc_tich");
		displayedPropertyList.add("hs_ngay_sinh");
		displayedPropertyList.add("hs_so_dien_thoai");
		displayedPropertyList.add("hs_nguoi_lien_he");
		displayedPropertyList.add("hs_quan_he_voi_hoc_sinh");
		displayedPropertyList.add("hk_thanh_pho");
		displayedPropertyList.add("hk_tinh");
		displayedPropertyList.add("hk_quoc_gia");
		displayedPropertyList.add("cm_ten");
		displayedPropertyList.add("cm_ho");
		displayedPropertyList.add("cm_hoten");
		displayedPropertyList.add("cm_quan_he_voi_hoc_sinh");
		displayedPropertyList.add("cm_dia_chi_email");
		displayedPropertyList.add("cm_so_dien_thoai_di_dong");
		displayedPropertyList.add("cm_dien_thoai_noi_lam_viec");
		displayedPropertyList.add("cm_ten_cong_ty");
		displayedPropertyList.add("cm_chuc_danh");
		displayedPropertyList.add("k_lop");
		displayedPropertyList.add("k_nam_hoc");
		displayedPropertyList.add("k_truong_hien_dang_hoc");
		displayedPropertyList.add("k_sao_ma_biet_den");
		displayedPropertyList.add("k_nguoi_gioi_thieu");
		displayedPropertyList.add("k_thac_mac");
		return displayedPropertyList;
	}
	
	/**
	 * @return the enrolmentStatusSelected
	 */
	public String getEnrolmentStatusSelected() {
		return enrolmentStatusSelected;
	}
	/**
	 * @param enrolmentStatusSelected the enrolmentStatusSelected to set
	 */
	public void setEnrolmentStatusSelected(String enrolmentStatusSelected) {
		this.enrolmentStatusSelected = enrolmentStatusSelected;
	}
	/**
	 * @return the enrolmentTextSearch
	 */
	public String getEnrolmentTextSearch() {
		return enrolmentTextSearch;
	}
	/**
	 * @param enrolmentTextSearch the enrolmentTextSearch to set
	 */
	public void setEnrolmentTextSearch(String enrolmentTextSearch) {
		this.enrolmentTextSearch = enrolmentTextSearch;
	}
	/**
	 * @return the enrolmentList
	 */
	public List<EnrolmentModel> getEnrolmentList() {
		return enrolmentList;
	}
	/**
	 * @param enrolmentList the enrolmentList to set
	 */
	public void setEnrolmentList(List<EnrolmentModel> enrolmentList) {
		this.enrolmentList = enrolmentList;
	}
	/**
	 * @return the listEnrolmentAttach
	 */
	public List<AttachFileModel> getListEnrolmentAttach() {
		return listEnrolmentAttach;
	}
	/**
	 * @param listEnrolmentAttach the listEnrolmentAttach to set
	 */
	public void setListEnrolmentAttach(List<AttachFileModel> listEnrolmentAttach) {
		this.listEnrolmentAttach = listEnrolmentAttach;
	}
	/**
	 * @return the enrolmentPerPage
	 */
	public int getEnrolmentPerPage() {
		return enrolmentPerPage;
	}
	/**
	 * @param enrolmentPerPage the enrolmentPerPage to set
	 */
	public void setEnrolmentPerPage(int enrolmentPerPage) {
		this.enrolmentPerPage = enrolmentPerPage;
	}
	/**
	 * @return the numOfPage
	 */
	public long getNumOfPage() {
		return numOfPage;
	}
	/**
	 * @param numOfPage the numOfPage to set
	 */
	public void setNumOfPage(long numOfPage) {
		this.numOfPage = numOfPage;
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
	 * @return the startNumberOfPage
	 */
	public int getStartNumberOfPage() {
		return startNumberOfPage;
	}
	/**
	 * @param startNumberOfPage the startNumberOfPage to set
	 */
	public void setStartNumberOfPage(int startNumberOfPage) {
		this.startNumberOfPage = startNumberOfPage;
	}
	/**
	 * @return the endNumberOfPage
	 */
	public int getEndNumberOfPage() {
		return endNumberOfPage;
	}
	/**
	 * @param endNumberOfPage the endNumberOfPage to set
	 */
	public void setEndNumberOfPage(int endNumberOfPage) {
		this.endNumberOfPage = endNumberOfPage;
	}
	/**
	 * @return the file
	 */
	public File [] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(File [] file) {
		this.file = file;
	}
	/**
	 * @return the fileName
	 */
	public String [] getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String [] fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the request
	 */
	public ActionRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(ActionRequest request) {
		this.request = request;
	}
	/**
	 * @return the listEnrolmentStatus
	 */
	public List<DataDictionary> getListEnrolmentStatus() {
		return listEnrolmentStatus;
	}
	/**
	 * @param listEnrolmentStatus the listEnrolmentStatus to set
	 */
	public void setListEnrolmentStatus(List<DataDictionary> listEnrolmentStatus) {
		this.listEnrolmentStatus = listEnrolmentStatus;
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
	 * @return the displayedPropertyList
	 */
	public List<String> getDisplayedPropertyList() {
		return displayedPropertyList;
	}

	/**
	 * @param displayedPropertyList the displayedPropertyList to set
	 */
	public void setDisplayedPropertyList(List<String> displayedPropertyList) {
		this.displayedPropertyList = displayedPropertyList;
	}

	/**
	 * @return the hiddenPropertyList
	 */
	public List<String> getHiddenPropertyList() {
		return hiddenPropertyList;
	}

	/**
	 * @param hiddenPropertyList the hiddenPropertyList to set
	 */
	public void setHiddenPropertyList(List<String> hiddenPropertyList) {
		this.hiddenPropertyList = hiddenPropertyList;
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
	 * @return the themeDisplay
	 */
	public ThemeDisplay getThemeDisplay() {
		return themeDisplay;
	}

	/**
	 * @param themeDisplay the themeDisplay to set
	 */
	public void setThemeDisplay(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
	}

	/**
	 * @return the enrolmentId
	 */
	public String getEnrolmentId() {
		return enrolmentId;
	}

	/**
	 * @param enrolmentId the enrolmentId to set
	 */
	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}

	/**
	 * @return the resultUpdate
	 */
	public String getResultUpdate() {
		return resultUpdate;
	}

	/**
	 * @param resultUpdate the resultUpdate to set
	 */
	public void setResultUpdate(String resultUpdate) {
		this.resultUpdate = resultUpdate;
	}
		
}
