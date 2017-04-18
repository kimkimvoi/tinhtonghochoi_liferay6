package com.fsoft.bn.domain.news;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.portlet.news.NewsContants.CONFIG_KEY;
import com.fsoft.bn.util.ListUtils;
import com.fsoft.bn.util.predicate.FindCategoryByIdPredicate;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

public class NewsListTabConfig extends NewsConfig {

	private List<NewsCategory> selectedCategories;
	private List<NewsCategory> unselectedCategories;
	protected List<KeyValuePair> catOrders;

	public NewsListTabConfig(PortletRequest req) {
		super(req);

		selectedCategories = new ArrayList<NewsCategory>();
		unselectedCategories = new ArrayList<NewsCategory>();
		catOrders = new ArrayList<KeyValuePair>();

		if (configured) {
			catOrders = toKeyValueList(CONFIG_KEY.CURRENT_CATEGORY_ORDER);
		}
	}

	public void validateConfig() {
		if (StringUtils.isBlank(currentStruct.getId())) {
			return;
		}

		final NewsStructure currentStructure = (NewsStructure) CollectionUtils.find(structures, new EqualPredicate(currentStruct));

		if (currentStructure == null) {
			logger.warn("current structure is not present");
			return;
		}
		currentStruct = currentStructure;

		reorganizeOptions();
	}

	public void reorganizeOptions() {
		unselectedCategories = new ArrayList<NewsCategory>(currentStruct.getCategories());
		selectedCategories = new ArrayList<NewsCategory>();
		if (catOrders.isEmpty()) {
			return;
		}
		
		for (int i = 0; i < catOrders.size(); i++) {
			int location = ListUtils.locate(unselectedCategories, new FindCategoryByIdPredicate(Long.parseLong(catOrders.get(i).getKey())));
			if (location > -1) {
				selectedCategories. add(unselectedCategories.remove(location));
			}
		}
	}

	/**
	 * update config from request to Preferences object
	 * 
	 * @param actionRequest
	 * @param prefs
	 * @throws ReadOnlyException
	 */
	public void updateConfig̣(ActionRequest actionRequest, PortletPreferences prefs) throws ReadOnlyException {
		super.updateConfig̣(actionRequest, prefs);

		String string = ParamUtil.getString(actionRequest, CONFIG_KEY.CURRENT_CATEGORY_ORDER, StringUtils.EMPTY);
		catOrders = new ArrayList<KeyValuePair>();
		String[] split = string.split(StringPool.COMMA);
		for (String string2 : split) {
			KeyValuePair keyValuePair = new KeyValuePair();
			keyValuePair.setKey(string2);
			catOrders.add(keyValuePair);
		}

		reorganizeOptions();
		prefs.setValue(CONFIG_KEY.CURRENT_CATEGORY_ORDER, KVList2Pref(selectedCategories));
	}

	public List<KeyValuePair> getCatOrders() {
		return catOrders;
	}

	public void setCatOrders(List<KeyValuePair> catOrders) {
		this.catOrders = catOrders;
	}

	public List<NewsCategory> getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(List<NewsCategory> categories) {
		this.selectedCategories = categories;
	}

	public List<NewsCategory> getUnselectedCategories() {
		return unselectedCategories;
	}

	public void setUnselectedCategories(List<NewsCategory> unselectedCategories) {
		this.unselectedCategories = unselectedCategories;
	}

}
