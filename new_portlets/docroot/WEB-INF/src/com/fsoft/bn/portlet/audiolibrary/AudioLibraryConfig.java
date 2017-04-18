package com.fsoft.bn.portlet.audiolibrary;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants.REQUEST.STATUS;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class AudioLibraryConfig extends DefaultConfigurationAction {

	private AudioLibraryConfigModel config;
	
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DLFolder> folderList = AudioLibrary.getAllFolders(themeDisplay.getScopeGroupId(), AudioLibrary.PHAP_AM_FOLDER_ID);
		List<KeyValuePair> categoryList = AudioLibrary.getCategoryList(folderList, renderRequest);
		List<DLFileEntry> fileList = new ArrayList<DLFileEntry>();
		for (DLFolder folder : folderList) {
			 fileList.addAll(DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), 
					folder.getFolderId(), -1, -1, null));
		}
		
		List<String> authorList = AudioLibrary.getAuthorList(fileList);
		renderRequest.setAttribute("audioAuthorList", authorList);
		
		config = new AudioLibraryConfigModel(renderRequest);
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
		renderRequest.setAttribute("config", config);
		
		return "/html/portlet/audiolibrary/config.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(actionRequest);
        config.updateConfig(actionRequest, prefs);
		SessionMessages.add(actionRequest, STATUS.SUCCESS);
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
