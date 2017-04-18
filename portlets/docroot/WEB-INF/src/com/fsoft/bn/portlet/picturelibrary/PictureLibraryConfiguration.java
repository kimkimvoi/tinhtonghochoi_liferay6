package com.fsoft.bn.portlet.picturelibrary;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.portlet.delegate.PictureGalleryDelegate;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class PictureLibraryConfiguration implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// init
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		// get selected folder
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		if (folderId > 0) { // case change folder
			prefs.setValue("isChangeFolder", "true");
			prefs.setValue("folderId", folderId + "");
		} else { // case update picture
			// get selection picture
			String pictureId = ParamUtil.getString(actionRequest, "radioPicture");

			// store
			prefs.setValue("radioPicture", pictureId);
			prefs.setValue("isChangeFolder", "false");
	        SessionMessages.add(actionRequest, "success");
	        SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		}
		
		prefs.store();
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		// init
		String portletResource = ParamUtil.getString(renderRequest, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		
		// get folders tree view
		String treeview = pictureGalleryDelegate.getFoldersTreeView(groupId);
		renderRequest.setAttribute("treeview", treeview);
		
		// get picture for first page, order by createDate
		long folderId = 0;
		String isChangeFolder = prefs.getValue("isChangeFolder", "false");
		if (isChangeFolder.equals("true")) {
			folderId = Long.parseLong(prefs.getValue("folderId", "0"));
		} else {
			folderId = ParamUtil.getLong(renderRequest, "folderId");
		}
		List<PictureModel> pictures = pictureGalleryDelegate.getPicturesForFolder(folderId, themeDisplay);
		
		renderRequest.setAttribute("pictures", pictures);
		
		// TODO: get information for paging
		
		
		// build default options
		String radioPicture = prefs.getValue("radioPicture", "");
        renderRequest.setAttribute("radioPicture", radioPicture);

        return "/html/portlet/picturelibrary/picture_library_config.jsp";
	}
	
}
