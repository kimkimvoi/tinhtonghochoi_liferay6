package com.fsoft.bn.portlet.video.gallery;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.domain.news.NewsListConfig;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class AdvertisementConfiguration
 * @author KienNN
 */
@Controller
@RequestMapping(value = "CONFIG")
public class VideoConfiguration implements ConfigurationAction {
	
	Gson gson = new Gson();
	/** logger */
	private static Logger logger = Logger.getLogger(VideoConfiguration.class);
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String portletResource = ParamUtil.getString(renderRequest, CommonConstants.PORTLET_RESOURCE);
			PortletPreferences prefs = renderRequest.getPreferences();
			if (portletResource == null	|| StringPool.BLANK.equals(portletResource.trim())) {
				portletResource = themeDisplay.getPortletDisplay().getId();
			}
			if (!Validator.isBlankOrNull(portletResource)) {
			    prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
			}
			List<NewsCategory> categoriesUnselect = NewsUtils.getCategories(renderRequest,"Pháp Âm Video");
			List<NewsCategory> categoriesSelected = new ArrayList<NewsCategory>();
			String sortBy=prefs.getValue("sortBy","");
			String sortType=prefs.getValue("sortType","");
			String currentCatId=prefs.getValue("currentCatId","");
			String arraySelected=prefs.getValue("arraySelected","");
			String[] listArraySelected = null;
			if(!Validator.isBlankOrNull(arraySelected)) {
				listArraySelected = arraySelected.split(",");
				for (NewsCategory item : categoriesUnselect) {
					for (String string : listArraySelected) {
						if(String.valueOf(item.getId()).equals(string)) {
							categoriesSelected.add(item);
						}
					}
				}
				
			}
			categoriesUnselect.removeAll(categoriesSelected);
			renderRequest.setAttribute("sortBy", sortBy);
			renderRequest.setAttribute("sortType", sortType);
			renderRequest.setAttribute("currentCatId", currentCatId);
			renderRequest.setAttribute("currentCatId", currentCatId);
			renderRequest.setAttribute("categoriesUnselect", categoriesUnselect);
			renderRequest.setAttribute("categoriesSelected", categoriesSelected);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return "/html/portlet/video_gallery/video-gallery-config.jsp";
	}

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String portletResource = ParamUtil.getString(actionRequest, CommonConstants.PORTLET_RESOURCE);
    	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
    	String sortBy = actionRequest.getParameter("sortBys");
    	String arraySelected = actionRequest.getParameter("current_category_order");
    	String sortType = actionRequest.getParameter("sortTypes");
    	String currentCatId = actionRequest.getParameter("current_category");
    	prefs.setValue("sortBy", sortBy);
    	prefs.setValue("sortType", sortType);
    	prefs.setValue("currentCatId", currentCatId);
    	prefs.setValue("arraySelected", arraySelected);
        prefs.store();
        SessionMessages.add(actionRequest, "success");
	}
	private List<NewsCategory> getUnselectedCategories(List<NewsCategory> categories) {
		List<NewsCategory> result = new ArrayList<NewsCategory>();
		if(!Validator.isBlankOrNull(categories)) {
			for (NewsCategory newsCategory : categories) {
				if(!newsCategory.isSelected()) {
					result.add(newsCategory);
				}
			}
		}
		return result;
	}
}
