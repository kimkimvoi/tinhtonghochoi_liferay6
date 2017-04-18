package com.fsoft.bn.domain.news;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;

import com.fsoft.bn.portlet.news.NewsContants.CONFIG_KEY;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;

public class NewsListTableConfig extends NewsListConfig {

	private List<String> detailTableFields;

	public NewsListTableConfig(RenderRequest req) {
		super(req);
		detailTableFields = toStringList(CONFIG_KEY.DETAIL_TABLE_FIELDS);
	}

	@Override
	public void updateConfig̣(ActionRequest actionRequest, PortletPreferences prefs) throws ReadOnlyException {
		super.updateConfig̣(actionRequest, prefs);
		Map<String , String> map = StructureUtil.extractXSDPropNamesStructure(currentStruct.getXSD());
		if (!Validator.isBlankOrNull(map)) {
			detailTableFields = new ArrayList<String>();
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			Entry<String , String> entry;
			while(iterator.hasNext()) {
				entry = iterator.next();
				if(!Validator.isBlankOrNull(entry.getKey())) {
					detailTableFields.add(entry.getValue());
				}
			}
				
		}

		prefs.setValue(CONFIG_KEY.DETAIL_TABLE_FIELDS, StringList2Pref(detailTableFields));
	}

	public List<String> getDetailTableFields() {
		return detailTableFields;
	}

	public void setDetailTableFields(List<String> structureFields) {
		this.detailTableFields = structureFields;
	}

	@Override
	public String toString() {
		return "NewsListTableConfig [detailTableFields=" + detailTableFields + ", structures=" + structures + ", currentStruct="
				+ currentStruct + ", sortbys=" + sortbys + ", numPerPage=" + numPerPage + ", includePaging=" + includePaging
				+ ", summaryMaxLength=" + summaryMaxLength + ", configured=" + configured + ", prefs=" + prefs + "]";
	}

}
