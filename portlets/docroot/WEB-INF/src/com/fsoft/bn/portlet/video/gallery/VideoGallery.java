package com.fsoft.bn.portlet.video.gallery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

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
import com.fsoft.bn.portlet.delegate.VideoGalleryDelegate;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortletRequestUtil;
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
		renderRequest.setAttribute("viewMode", ParamUtil.getString(renderRequest , "viewMode"));
		renderRequest.setAttribute("folderName", ParamUtil.getString(renderRequest , "folderName"));
		Map<String, Object> model = new HashMap<String, Object>();
		//return to view
		return new ModelAndView("video_gallery/video-gallery-view", model);
	}
	/**
	 * 
	 * @param request 
	 * @param response 
	 * @author VangND1 
	 */
	@ResourceMapping("getListFolder")
	public void getListFolder(ResourceRequest request, ResourceResponse response) {						
		VideoGalleryDelegate videoGalleryDelegate = new VideoGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		int pageNum = PortletRequestUtil.getIntParameter(request, PARAMETER.PAGE_NUM);
		int start = CommonConstants.NUM_8 * (pageNum - 1);					
		int end = start + CommonConstants.NUM_8;
		List<FolderModel> listFolderModel = null;
		try {					
			//set list video to request
			listFolderModel = videoGalleryDelegate.getFolders(CommonConstants.STRUCTURE.GROUP_ID,
					start, end , request , themeDisplay);
			//create new page
			int numOfPage = CommonUtil.getNumberOfPage(
					videoGalleryDelegate.getCountFolder(CommonConstants.STRUCTURE.GROUP_ID),
					CommonConstants.NUM_8);
			Page<FolderModel> page = new Page<FolderModel>(request , numOfPage , pageNum,
					CommonConstants.NUM_8, listFolderModel);
			Gson gson = new Gson();				
			response.getWriter().write(gson.toJson(page));				
		} catch (Exception e) {
			logger.info(e.getMessage());
		}					
	}
	/**
	 * This method using get list video
	 * @param request 
	 * @param response 
	 */
	@ResourceMapping("getListVideo")
	public void getListVideo(ResourceRequest request, ResourceResponse response) {						
		VideoGalleryDelegate videoGalleryDelegate = new VideoGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		int pageNum = PortletRequestUtil.getIntParameter(request, PARAMETER.PAGE_NUM);
		int start = CommonConstants.NUM_8 * (pageNum - 1);					
		int end = start + CommonConstants.NUM_8;
		List<BNVideoModel> listVideoModel = null;
		String folderId = ParamUtil.getString(request , "folderId");
		try {					
			//set list video to request
			listVideoModel = videoGalleryDelegate.getVideoForFolder(Long.parseLong(folderId), themeDisplay, start, end);
			int numOfPage = CommonUtil.getNumberOfPage(
					videoGalleryDelegate.getCountVideoForFolder(Long.parseLong(folderId)),
					CommonConstants.NUM_8);
			Page<BNVideoModel> page = new Page<BNVideoModel>(request , numOfPage , pageNum,
					CommonConstants.NUM_8, listVideoModel);
			Gson gson = new Gson();				
			response.getWriter().write(gson.toJson(page));				
		} catch (Exception e) {
			logger.info(e.getMessage());
		}					
	}
	


}
