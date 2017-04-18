package com.fsoft.bn.portlet.documentviewer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.BNFolder;
import com.fsoft.bn.portlet.news.detail.NewsDetailPortlet;
import com.google.gson.Gson;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LiferayDocViewerAction
 */
public class DocumentViewerPortlet extends MVCPortlet {
	private static Logger log = Logger.getLogger(NewsDetailPortlet.class);
	private Gson gson = new Gson();
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {		
		String resourceID = resourceRequest.getResourceID();
		
		if ("handleAjaxAction".equals(resourceID)) {
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				OrderByComparator obc =  OrderByComparatorFactoryUtil.create("dlfolder", "createDate", true);
				
				long folderId = Long.parseLong(resourceRequest.getParameter("folderId"));
				List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), 
						folderId, -1, -1, obc);
				
				List<BNFolder> results = new ArrayList<BNFolder>();
				for (DLFolder folder: folders) {
					BNFolder temp = new BNFolder();
					temp.setId(folder.getFolderId());
					temp.setName(folder.getName());
					temp.files = DLAppLocalServiceUtil
							.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
					
					results.add(temp);
				}				
				
				resourceResponse.getWriter().write(gson.toJson(results));
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		}
	}
}
