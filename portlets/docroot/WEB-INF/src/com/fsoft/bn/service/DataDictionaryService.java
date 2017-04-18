package com.fsoft.bn.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.DataDictionarySet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSetConstants;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;

public class DataDictionaryService {
	/** logger */
	private static Logger logger = Logger.getLogger(DataDictionaryService.class);
	private static final String KEY = "key";
	private static final String VALUE = "value";
	private static final String DISPLAY_ORDER = "display_order";
	public static final String CURRENCY_TYPES = "currency";
	public static final String PROJECT_CATEGORIES = "project_category";
	public static final String INVESTMENT_FORMS = "investment_form";
	public static final String PROVINCIAL_DEPARTMENTS = "provincial_departments";
	public static final String QUESTION_TYPE = "questionType";
	public static final String QUESTION_STATUS = "QuestionStatus";
	public static final String INVESTMENT_AND_DEVELOPMENT_VIEW_MODE = "InvestmentAndDevelopmentViewMode";
	
	public static DataDictionarySet searchListByNameDomain(String name, PortletRequest request) {
		DataDictionarySet dataDictionarySet = new DataDictionarySet();
		List<DataDictionary> dataList = new ArrayList<DataDictionary>();
		DDLRecordSet recordSet = searchListByName(name, request);
		Set<String> listField = null;
		if (recordSet == null) {
			return null;
		}
		
		List<DDLRecord> records = null;
		
		try {
			records = recordSet.getRecords();
		} catch (SystemException e) {
			logger.info(e.getMessage());
			return null;
		}

		for (DDLRecord ddlRecord : records) {
			DataDictionary target = new DataDictionary();
			try {
				listField = ddlRecord.getFields().getNames();
				if(listField != null && listField.size() > CommonConstants.NUM_0) {
					if(listField.contains(KEY)) {
						target.setKey(Long.parseLong(ddlRecord.getFieldValue(KEY).toString()));
					}
					if(listField.contains(VALUE)) {
						target.setValue(ddlRecord.getFieldValue(VALUE).toString());
					}
					if(listField.contains(DISPLAY_ORDER)) {
						target.setDisplay_order(Long.parseLong(ddlRecord.getFieldValue(DISPLAY_ORDER).toString()));
					}
					dataList.add(target);
				}
			} catch (PortalException e) {
				logger.info(e.getMessage());
			}
		}
		
		dataDictionarySet.setName(name);
		Collections.sort(dataList);
		dataDictionarySet.setRecords(dataList);
		return dataDictionarySet;
	}
	
	public static DDLRecordSet searchListByName(String name, PortletRequest request) {
		List<DDLRecordSet> result = null;
		try {
			long companyId = PortalUtil.getCompanyId(request);
			long scopeGroupId = com.fsoft.bn.util.PortalUtil.getGlobalGroupId();
			result = DDLRecordSetLocalServiceUtil.search(companyId, scopeGroupId, name,
					DDLRecordSetConstants.SCOPE_DYNAMIC_DATA_LISTS, 0, 1, null);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.get(0);
	}

}
