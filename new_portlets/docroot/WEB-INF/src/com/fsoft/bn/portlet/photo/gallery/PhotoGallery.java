package com.fsoft.bn.portlet.photo.gallery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.Page;
import com.fsoft.bn.portlet.delegate.PictureGalleryDelegate;
import com.fsoft.bn.portlet.delegate.VideoGalleryDelegate;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortletRequestUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoGallery
 */
@Controller
@RequestMapping(value = "VIEW")
public class PhotoGallery extends MVCPortlet {
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
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String viewMode = ParamUtil.getString(renderRequest , "viewMode");
		renderRequest.setAttribute("viewMode", viewMode);
		List<FolderModel> listAlbum = pictureGalleryDelegate
				.getFolders(CommonConstants.STRUCTURE.GROUP_ID,
						renderRequest, themeDisplay);
		if (!Validator.isBlankOrNull(viewMode)) {
			String folderId = ParamUtil.getString(renderRequest , "folderId");
			renderRequest.setAttribute("folderName", ParamUtil.getString(renderRequest , "folderName"));
			renderRequest.setAttribute(
					"listPhoto",
					pictureGalleryDelegate.getPicturesForFolder(
							Long.parseLong(folderId), themeDisplay));
			for (FolderModel folderModel : listAlbum) {
				if(folderId.equals(String.valueOf(folderModel.getFolderId()))) {
					listAlbum.remove(folderModel);
					break;
				}
			}
		}
		
		renderRequest.setAttribute("listAlbum", listAlbum);
		return new ModelAndView("photo_gallery/view", model);
	}
}
