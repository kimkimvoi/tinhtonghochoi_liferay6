package com.fsoft.bn.domain.news;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_DEFAULT_VALUE;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_KEY;
import com.fsoft.bn.util.predicate.FindStructureByIdPredicate;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;

public class NewsConfig extends Config {
	
	protected List<NewsStructure> structures;
	protected NewsStructure currentStruct;
	protected List<KeyValuePair> sortbys;
	private String displayType;
	protected int numPerPage;
	protected boolean includePaging;
	protected int summaryMaxLength;

	public NewsConfig() {
		super();
	}

	public NewsConfig(PortletRequest req) {
		super(req);

		currentStruct = new NewsStructure();

		if (!configured)
			return;
		numPerPage = Integer.valueOf(prefs.getValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(CONFIG_DEFAULT_VALUE.NUM_PER_PAGE)));
		displayType = prefs.getValue(CONFIG_KEY.DISPLAY_TYPE, StringUtils.EMPTY);

		KeyValuePair keyValue = toKeyValue(CONFIG_KEY.CURRENT_STRUCT);
		if (keyValue != null) {
			currentStruct.setId(keyValue.getKey());
			currentStruct.setName(keyValue.getValue());
		}

		includePaging = Boolean.valueOf(prefs.getValue(CONFIG_KEY.INCLUDE_PAGING, CommonConstants.STRING_FALSE));
		summaryMaxLength = Integer.valueOf(prefs.getValue(CONFIG_KEY.SUMMARY_MAX_LENGTH,
				String.valueOf(CONFIG_DEFAULT_VALUE.SUMMARY_MAX_LENGTH)));

		sortbys = toKeyValueList(CONFIG_KEY.SORTBYS);
	}

	public void updateConfig̣(ActionRequest actionRequest, PortletPreferences prefs) throws ReadOnlyException {
		String structId = ParamUtil.getString(actionRequest, CONFIG_KEY.CURRENT_STRUCT, StringUtils.EMPTY);
		NewsStructure nc = (NewsStructure) CollectionUtils.find(structures, new FindStructureByIdPredicate(structId));
		if (nc != null) {
			currentStruct = nc;
		} else {
			currentStruct = new NewsStructure();
		}
		prefs.setValue(CONFIG_KEY.CURRENT_STRUCT, KVtoPref(currentStruct));

		numPerPage = ParamUtil.getInteger(actionRequest, CONFIG_KEY.NUM_PER_PAGE, 0);
		prefs.setValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(numPerPage));

		includePaging = ParamUtil.getBoolean(actionRequest, CONFIG_KEY.INCLUDE_PAGING, false);
		prefs.setValue(CONFIG_KEY.INCLUDE_PAGING, String.valueOf(includePaging));

		displayType = ParamUtil.getString(actionRequest, CONFIG_KEY.DISPLAY_TYPE, NewsContants.DISPLAY_TYPE_SUMMARY);
		prefs.setValue(CONFIG_KEY.DISPLAY_TYPE, String.valueOf(displayType));

		prefs.setValue(CONFIG_KEY.SORTBYS, parallelParams2Pref(actionRequest, CONFIG_KEY.SORT_BY_NAME, CONFIG_KEY.SORT_BY_TYPE));

		summaryMaxLength = ParamUtil.getInteger(actionRequest, CONFIG_KEY.SUMMARY_MAX_LENGTH, CONFIG_DEFAULT_VALUE.SUMMARY_MAX_LENGTH);
		prefs.setValue(CONFIG_KEY.SUMMARY_MAX_LENGTH, String.valueOf(summaryMaxLength));

	}

	public int getSummaryMaxLength() {
		return summaryMaxLength;
	}

	public void setSummaryMaxLength(int summaryMaxLength) {
		this.summaryMaxLength = summaryMaxLength;
	}

	public List<KeyValuePair> getSortbys() {
		return sortbys;
	}

	public void setSortbys(List<KeyValuePair> sortBys) {
		this.sortbys = sortBys;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public boolean isIncludePaging() {
		return includePaging;
	}

	public void setIncludePaging(boolean includePaging) {
		this.includePaging = includePaging;
	}

	public List<NewsStructure> getStructures() {
		return structures;
	}

	public void setStructures(List<NewsStructure> structures) {
		this.structures = structures;
	}

	public boolean isConfigured() {
		return configured;
	}

	public void setConfigured(boolean configured) {
		this.configured = configured;
	}

	public NewsStructure getCurrentStruct() {
		return currentStruct;
	}

	public void setCurrentStruct(NewsStructure currentStruct) {
		this.currentStruct = currentStruct;
	}

	public PortletPreferences getPrefs() {
		return prefs;
	}

	public void setPrefs(PortletPreferences prefs) {
		this.prefs = prefs;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	@Override
	public String toString() {
		return "NewsConfig [structures=" + structures + ", currentStruct=" + currentStruct + ", sortbys=" + sortbys + ", displayType="
				+ displayType + ", numPerPage=" + numPerPage + ", includePaging=" + includePaging + ", summaryMaxLength="
				+ summaryMaxLength + ", configured=" + configured + ", prefs=" + prefs + "]";
	}

}
