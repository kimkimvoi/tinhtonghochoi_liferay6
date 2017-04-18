package com.fsoft.bn.portlet.picturegallery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.portlet.delegate.PictureGalleryDelegate;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PictureLibraryDetailPortlet
 */
public class PictureGalleryPortlet extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(PictureGalleryPortlet.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences prefs = PortalUtil.getPortletPreferences(renderRequest);
		long folderId = 0;
		
		String strFolderClick = (String) renderRequest.getAttribute("previewFolderId");
		String strFolderIdConfiguration = prefs.getValue("picturegalleryfolId", null);
		
		if(strFolderClick != null){
			try{
				folderId = Long.parseLong(strFolderClick);
			}catch(Exception e){
				logger.info(e.getMessage());
			}
		}else{
			try{
				folderId = Long.parseLong(strFolderIdConfiguration);
			}catch (Exception e){
				logger.info(e.getMessage());
			}
		}
		doPreviewPicture(renderRequest, renderResponse, folderId);		
		super.doView(renderRequest, renderResponse);
	}

	public void previewPictureByFolder(ActionRequest request,
			ActionResponse response) {
		String folderId = ParamUtil.getString(request, "folderId");
		request.setAttribute("previewFolderId", folderId);
	}

	private void doPreviewPicture(PortletRequest request,
			PortletResponse response, long folderId) {
		// init
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();

		// get pictures
		List<PictureModel> pictures = pictureGalleryDelegate
				.getPicturesForFolder(folderId, themeDisplay);
		request.setAttribute("pictures", pictures);

		// paging
		String curPageStatusText = CommonUtil.getText(request, "portlet.public_news.table.page");
		request.setAttribute("curPageStatusText", curPageStatusText);
		String itemsPerPageText = CommonUtil.getText(request, "portlet.common.paging.itemsPerPageText");
		request.setAttribute("itemsPerPageText", itemsPerPageText);

		List<FolderModel> subFolders = pictureGalleryDelegate.getSubFoldersWithThumb(folderId, groupId, themeDisplay);

		int numPerPage = CommonConstants.NUM_10;
		request.setAttribute("numPerPage", numPerPage);

		int start = 0;
		int end = start + numPerPage;
		List<FolderModel> onPage;
		try {
			onPage = getListPaginatorPicture(subFolders, start, end);
			request.setAttribute("subFolders", onPage);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		int total = subFolders.size();
		int numOfPage = getNumOfPage(total, numPerPage);
		request.setAttribute("numOfPage", numOfPage);
		// end paging

		// get breadcumbs
		Map<Long, String> breadcumbs = pictureGalleryDelegate.getBreadcumbs(folderId, themeDisplay.getLayout().getGroupId());
		request.setAttribute("breadcumbs", breadcumbs);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		if ("listPictureModel_LoadPage".equals(resourceID)) {
			listPictureModelLoadPage(resourceRequest, resourceResponse);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	// get list to paging list
	public static List<FolderModel> getListPaginatorPicture(
			List<FolderModel> listAll, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		List<FolderModel> listPictureModel = new ArrayList<FolderModel>();
		for (int i = start; i < end; i++) {
			if (i < listAll.size()) {
				listPictureModel.add(listAll.get(i));
			} else {
				break;
			}
		}
		return listPictureModel;
	}

	// set paging
	public void listPictureModelLoadPage(ResourceRequest request,
			ResourceResponse response) {
		PictureGalleryDelegate pictureGalleryDelegate = new PictureGalleryDelegate();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();

		List<FolderModel> subFolders = null;
		List<FolderModel> models = null;

		// get subFolders
		subFolders = pictureGalleryDelegate.getSubFoldersWithThumb(0, groupId,themeDisplay);
		String pageNumStr = ParamUtil.getString(request, "pageNum");
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		int pageNum = Integer.parseInt(pageNumStr);
		int start = numPerPage * (pageNum - 1);
		int end = start + numPerPage;

		try {
			models = getListPaginatorPicture(subFolders, start, end);
			int total = subFolders.size();
			int numOfPage = getNumOfPage(total, numPerPage);

			Gson gson = new Gson();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("items", gson.toJson(models));
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);

			// logging.info("json ssss: " + json.toString());
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	// get number of page
	public int getNumOfPage(int total, int numInRow) {
		int numOfPage = 0;
		if ((total % numInRow) == 0) {
			numOfPage = total / numInRow;
		} else {
			numOfPage = total / numInRow + 1;
		}
		return numOfPage;
	}
}
