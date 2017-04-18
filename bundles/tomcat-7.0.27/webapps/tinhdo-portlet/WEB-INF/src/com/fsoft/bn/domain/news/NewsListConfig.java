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
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.predicate.FindCategoryByIdPredicate;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;

public class NewsListConfig extends NewsConfig {

	private List<NewsCategory> categories;

	private NewsCategory currentCat;

	public NewsListConfig(PortletRequest req) {
		super(req);

		currentCat = new NewsCategory();
		categories = new ArrayList<NewsCategory>();

		if (configured) {
			KeyValuePair curCat = toKeyValue(CONFIG_KEY.CURRENT_CATEGORY);
			if (curCat != null) {
				long[] id = {Long.parseLong(curCat.getKey())};
				currentCat = NewsUtils.getCategories(req, id).get(0);
			} else {
				return;
			}	
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
		categories = currentStruct.getCategories();
		if (currentCat != null) {
			NewsCategory cat = (NewsCategory) CollectionUtils.find(currentStruct.getCategories(), new EqualPredicate(currentCat));
			
			if (cat == null) {
				logger.warn("current category not exist in current structure,set it to first one");
			}
		}
		return;
	}

	/**
	 * update config from request to Preferences object
	 */
	public void updateConfig̣(ActionRequest actionRequest, PortletPreferences prefs) throws ReadOnlyException {
		super.updateConfig̣(actionRequest, prefs);

		categories = currentStruct.getCategories();

		Long valueOf = ParamUtil.getLong(actionRequest, CONFIG_KEY.CURRENT_CATEGORY, 0);
		NewsCategory nc = (NewsCategory) CollectionUtils.find(categories, new FindCategoryByIdPredicate(valueOf));
		if (nc != null) {
			currentCat = nc;
		} else {
			currentCat = new NewsCategory();
		}
		prefs.setValue(CONFIG_KEY.CURRENT_CATEGORY, KVtoPref(currentCat));
	}

	public List<NewsCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<NewsCategory> categories) {
		this.categories = categories;
	}

	public NewsCategory getCurrentCat() {
		return currentCat;
	}

	public void setCurrentCat(NewsCategory currentCat) {
		this.currentCat = currentCat;
	}

	@Override
	public String toString() {
		return "NewsListConfig [categories=" + categories + ", currentCat=" + currentCat + ", structures=" + structures
				+ ", currentStruct=" + currentStruct + ", sortbys=" + sortbys + ", numPerPage=" + numPerPage + ", includePaging="
				+ includePaging + ", summaryMaxLength=" + summaryMaxLength + ", configured=" + configured + ", prefs=" + prefs + "]";
	}

}
