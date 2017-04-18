package com.fsoft.bn.portlet.picturegallery;

import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.portlet.delegate.PictureGalleryDelegate;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class PictureGalleryConfiguration implements ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		// init
		String portletResource = ParamUtil.getString(actionRequest,"portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

		// get selection folders
		String folderId = ParamUtil.getString(actionRequest, "picturegalleryfolId");
		String linkFolderId = ParamUtil.getString(actionRequest, "pictureLinkFolderId");
		prefs.setValue("pictureLinkFolderId", linkFolderId);
		if("".equals(linkFolderId)){
			prefs.setValue("picturegalleryfolId", folderId);
		}
		
		// store
		prefs.store();
		SessionMessages.add(actionRequest, portletConfig.getPortletName()+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
	}

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		String portletResource = ParamUtil.getString(renderRequest,"portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);

		// get folders
		long folderIdPictureGallery = 0;
		long linkSubFolder = 0;
		try{
			folderIdPictureGallery = Long.parseLong(prefs.getValue("picturegalleryfolId", null));
		}catch (Exception e){
			//logger.info(e.getMessage());
		}
		try{
			linkSubFolder = Long.parseLong(prefs.getValue("pictureLinkFolderId", null));
		}catch (Exception e){
			//logger.info(e.getMessage());
		}
		
		String actionName = ParamUtil.getString(renderRequest, "pictureGalleryActionName");
		if(actionName.equals("actionClickSubFolder")){
			listSubFolder(renderRequest, renderResponse, linkSubFolder);	
		}else{
			long parentFolderId = 0; 
			//get parentFolderId
			if(folderIdPictureGallery > 0){
				DLFolder parentFolder = DLFolderLocalServiceUtil.getDLFolder(folderIdPictureGallery);
				parentFolderId = parentFolder.getParentFolderId();
			}
			listSubFolder(renderRequest, renderResponse, parentFolderId);
		}
		
		// state of folder was choose
		String statusChooseFolder = prefs.getValue("picturegalleryfolId", null);
		if(statusChooseFolder != null){
			renderRequest.setAttribute("pictureGalleryFolderId", statusChooseFolder);
		}else{
			renderRequest.setAttribute("pictureGalleryFolderId", "0");
		}
		// set default options
		return "/html/portlet/picturegallery/picture_gallery_config.jsp";
	}
    
	// get list subfolder
	private static void listSubFolder(PortletRequest request, PortletResponse response, long folderId) {
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		
		// get pictures
		List<PictureModel> pictures = pictureGalleryDelegate.getPicturesForFolder(folderId, themeDisplay);
		request.setAttribute("pictures", pictures);

		List<FolderModel> subFolders = pictureGalleryDelegate.getSubFoldersWithThumb(folderId, groupId, themeDisplay);
		request.setAttribute("subFolders", subFolders);

		// get breadcumbs
		Map<Long, String> breadcumbs = pictureGalleryDelegate.getBreadcumbs(folderId, themeDisplay.getLayout().getGroupId());
		request.setAttribute("breadcumbs", breadcumbs);
	}
}
