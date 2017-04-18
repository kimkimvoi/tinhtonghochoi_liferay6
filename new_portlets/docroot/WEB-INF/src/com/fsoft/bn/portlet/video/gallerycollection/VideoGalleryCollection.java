package com.fsoft.bn.portlet.video.gallerycollection;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.portlet.delegate.VideoGalleryDelegate;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.PortletRequestUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoGalleryCollection
 */

public class VideoGalleryCollection extends MVCPortlet {
	/** logger */
	private static Logger logger = Logger.getLogger(VideoGalleryCollection.class);
	
	@Override
	public void doView(RenderRequest req, RenderResponse res) throws IOException, PortletException {
		//return to view
		VideoGalleryDelegate videoGalleryDelegate = new VideoGalleryDelegate();
		List<BNVideoModel> listVideoModel = videoGalleryDelegate.getListVideo(req);
		List<BNVideoModel> renderVideoList = null;
		
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		String numberOfItemsPerPage = prefs.getValue("numberOfItemsPerPage", 
				String.valueOf(CommonConstants.NUMBER_OF_ITEMS_IN_VIDEO_PAGE));
		
		int recordsInPage = Integer.valueOf(numberOfItemsPerPage);
		int totalPages = 0;
		if (listVideoModel != null) {
			int numberOfItems = listVideoModel.size() + 1;
			if (numberOfItems % recordsInPage == 0) {
				totalPages = numberOfItems / recordsInPage;
			} else {
				totalPages = numberOfItems / recordsInPage + 1;
			}
			
			int endIndex = recordsInPage;
			if (endIndex > listVideoModel.size()) {
				endIndex = listVideoModel.size();
			}
			
			renderVideoList = listVideoModel.subList(0, endIndex);
		}
		
		req.setAttribute("listVideo", renderVideoList);
		req.setAttribute("recordsInPage", recordsInPage);
		req.setAttribute("totalPages", listVideoModel == null ? 0 : totalPages);
		
		super.doView(req, res);
	}
	
	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		if (!req.getResourceID().equals(RESOURCE_ACTION.LOAD_PAGE)) {
			return;
		}

		//return to view
		VideoGalleryDelegate videoGalleryDelegate = new VideoGalleryDelegate();
		List<BNVideoModel> listVideoModel = videoGalleryDelegate.getListVideo(req);
		req.setAttribute("listVideo", listVideoModel);
		List<BNVideoModel> renderVideoList = null;
		
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		String numberOfItemsPerPage = prefs.getValue("numberOfItemsPerPage", 
				String.valueOf(CommonConstants.NUMBER_OF_ITEMS_IN_VIDEO_PAGE));
		int pageNum = PortletRequestUtil.getIntParameter(req, "pageNum", 1);
		
		int recordsInPage = Integer.valueOf(numberOfItemsPerPage);
		int totalPages = 0;
		if (listVideoModel != null) {
			int numberOfItems = listVideoModel.size() + 1;
			if (numberOfItems % recordsInPage == 0) {
				totalPages = numberOfItems / recordsInPage;
			} else {
				totalPages = numberOfItems / recordsInPage + 1;
			}
			
			int startIndex = (pageNum-1)*recordsInPage;
			int endIndex = startIndex + recordsInPage;
			if (endIndex > listVideoModel.size()) {
				endIndex = listVideoModel.size();
			}
			
			renderVideoList = listVideoModel.subList(startIndex, endIndex);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listVideo", renderVideoList);
		map.put("totalPages", totalPages);
		
		super.serveResource(req, PortalUtil.toJson(res, map));
	}
}
