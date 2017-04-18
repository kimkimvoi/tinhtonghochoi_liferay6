package com.fsoft.bn.portlet.audio.player;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.portlet.DefaultConfigurationAction;
import com.fsoft.bn.portlet.audiolibrary.AudioLibrary;
import com.fsoft.bn.portlet.audiolibrary.AudioLibraryConfigModel;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_DEFAULT_VALUE;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_KEY;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class AudioPortletConfiguration extends DefaultConfigurationAction {
	
	private AudioLibraryConfigModel config;
	
	public String render(PortletConfig portletConfig, RenderRequest req, RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		List<DLFolder> folderList = AudioLibrary.getAllFolders(themeDisplay.getScopeGroupId(), AudioLibrary.PHAP_AM_FOLDER_ID);
		List<KeyValuePair> categoryList = AudioLibrary.getCategoryList(folderList, req);
		
		List<DLFileEntry> fileList = new ArrayList<DLFileEntry>();
		for (DLFolder folder : folderList) {
			 fileList.addAll(DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), 
					folder.getFolderId(), -1, -1, null));
		}
		
		List<String> authorList = AudioLibrary.getAuthorList(fileList);
		req.setAttribute("audioAuthorList", authorList);
		
		config = new AudioLibraryConfigModel(req);
		if (config.getSelectedCategoryList().isEmpty()) {
			config.setAvailableCategoryList(categoryList);
		} else {
			List<KeyValuePair> tempList = new ArrayList<KeyValuePair>();
			for (KeyValuePair category : categoryList) {
				boolean selected = false;
				for (KeyValuePair selectedCategory : config.getSelectedCategoryList()) {
					if (category.getKey().equals(selectedCategory.getKey())) {
						selected = true;
						break;
					}
				}
				if (!selected) {
					tempList.add(category);
				}
			}
			config.setAvailableCategoryList(tempList);
		}
		req.setAttribute("config", config);
		
		//get prefs from request
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		//get value from prefs stored 
		int numPerPage = Integer.valueOf(prefs.getValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(CONFIG_DEFAULT_VALUE.NUM_PER_PAGE)));
		boolean includePaging = Boolean.valueOf(prefs.getValue(CONFIG_KEY.INCLUDE_PAGING, CommonConstants.STRING_FALSE));
		//set value to request and return to client 
		req.setAttribute("numPerPage", numPerPage);
		req.setAttribute("includePaging", includePaging);
		
		return "/html/portlet/audioplayer/view-config.jsp";
	}
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest req, ActionResponse actionResponse) throws Exception {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		int numPerPage = ParamUtil.getInteger(req, CONFIG_KEY.NUM_PER_PAGE,CONFIG_DEFAULT_VALUE.NUM_PER_PAGE);
		config.updateConfig(req, prefs);
		prefs.setValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(numPerPage));
		boolean includePaging = ParamUtil.getBoolean(req, CONFIG_KEY.INCLUDE_PAGING, false);
		prefs.setValue(CONFIG_KEY.INCLUDE_PAGING, String.valueOf(includePaging));
		//store value of configuration on database
        prefs.store();
		SessionMessages.add(req, "success");
		
		super.processAction(portletConfig, req, actionResponse);
	}
}
