package com.fsoft.bn.portlet.video.gallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.portlet.delegate.VideoGalleryDelegate;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoGallery
 */
@Controller
@RequestMapping(value = "VIEW")
public class VideoGallery extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(VideoGallery.class);
	/**
	 * default method view mode
	 * @param renderRequest  
	 * @param renderResponse  
	 * @return {@link ModelAndView}
	 * @throws Exception 
	 * @author VangND1
	 */
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		//return to view
		VideoGalleryDelegate videoGalleryDelegate = new VideoGalleryDelegate();
		List<BNVideoModel> listVideoModel = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletResource = ParamUtil.getString(renderRequest, CommonConstants.PORTLET_RESOURCE);
		PortletPreferences prefs = renderRequest.getPreferences();
		
		if (portletResource == null	|| StringPool.BLANK.equals(portletResource.trim())) {
			portletResource = themeDisplay.getPortletDisplay().getId();
		}
		if (!Validator.isBlankOrNull(portletResource)) {
		    prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		}
		String sortBy=prefs.getValue("sortBy","");
		String sortType=prefs.getValue("sortType","");
		String arraySelected=prefs.getValue("arraySelected","");
		String[] listArraySelected = null;
		List<NewsCategory> listCategorySelected = new ArrayList<NewsCategory>();
		if(!Validator.isBlankOrNull(arraySelected)) {
			listArraySelected = arraySelected.split(",");
			for (String str : listArraySelected) {
				listCategorySelected.add(new NewsCategory(Long.parseLong(str),""));
			}
		}
		List<KeyValuePair> sortbys = new ArrayList<KeyValuePair>();
		sortbys.add(new KeyValuePair(sortBy, sortType));
		listVideoModel = videoGalleryDelegate.getListVideo(renderRequest, listCategorySelected, sortbys);
		renderRequest.setAttribute("listVideo", listVideoModel);
		return new ModelAndView("video_gallery/video-gallery-view", model);
	}
}
