package com.fsoft.bn.portlet.audio.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.audio.Audio;
import com.fsoft.bn.domain.audio.AudioPage;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.NewsListConfig;
import com.fsoft.bn.domain.news.NewsPage;
import com.fsoft.bn.portlet.audiolibrary.AudioLibrary;
import com.fsoft.bn.portlet.audiolibrary.AudioLibraryConfigModel;
import com.fsoft.bn.portlet.delegate.AudioGalleryDelegate;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_DEFAULT_VALUE;
import com.fsoft.bn.portlet.news.NewsContants.CONFIG_KEY;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION;
import com.fsoft.bn.portlet.news.NewsContants.RESOURCE_ACTION.PARAMETER;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.PortletRequestUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AudioPlayerPortlet
 */
public class AudioPlayerPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		//get prefs from request
		PortletPreferences prefs = PortalUtil.getPortletPreferences(renderRequest);
		//get value from prefs stored 
		int numPerPage = Integer.valueOf(prefs.getValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(CONFIG_DEFAULT_VALUE.NUM_PER_PAGE)));
		boolean includePaging = Boolean.valueOf(prefs.getValue(CONFIG_KEY.INCLUDE_PAGING, CommonConstants.STRING_FALSE));
		//set value to request and return to client 
		renderRequest.setAttribute("numPerPage", numPerPage);
		renderRequest.setAttribute("includePaging", includePaging);

		AudioLibrary audioLibrary = new AudioLibrary();
		List<News> audioList = audioLibrary.getAudioList(renderRequest);
		List<Audio> items = new ArrayList<Audio>();
		int i = 0;
		for (News news : audioList) {
			if (i >= 0 && i <numPerPage) {
				Audio item = new Audio(news.getId(), news.getAuthor(), news.getTitle(), news.getSource(), news.getCateName());
				items.add(item);
			}
			i++;
		}
		//AudioGalleryDelegate audioGalleryDelegate = new AudioGalleryDelegate();
		//ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//AudioPage audioPage = audioGalleryDelegate.getListAudio(renderRequest, themeDisplay, numPerPage, 1, 0, numPerPage);
		long audioCount = audioList.size();
		long numberOfPage = CommonUtil.getNumberOfPage(audioCount, numPerPage);
		if(numberOfPage < 1) {
			numberOfPage = 1;
		}
		AudioPage audioPage = new AudioPage(renderRequest, CommonUtil.convertLongToInt(numberOfPage), 1, numPerPage, items);
		//set audio page to attribute
		renderRequest.setAttribute("audioPage", audioPage);
		super.doView(renderRequest, renderResponse);
	}
	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res) throws IOException, PortletException {
		if (!req.getResourceID().equals(RESOURCE_ACTION.LOAD_PAGE)) {
			return;
		}
		PortletPreferences prefs = PortalUtil.getPortletPreferences(req);
		//get value from prefs stored 
		int numPerPage = Integer.valueOf(prefs.getValue(CONFIG_KEY.NUM_PER_PAGE, String.valueOf(CONFIG_DEFAULT_VALUE.NUM_PER_PAGE)));
		
		//AudioGalleryDelegate audioGalleryDelegate = new AudioGalleryDelegate();
		int pageNum = PortletRequestUtil.getIntParameter(req, PARAMETER.PAGE_NUM, 1);
		//ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		int start = (pageNum - 1) * numPerPage;
		int end = pageNum * numPerPage;
		
		AudioLibrary audioLibrary = new AudioLibrary();
		List<News> audioList = audioLibrary.getAudioList(req);
		List<Audio> items = new ArrayList<Audio>();
		int i = 0;
		for (News news : audioList) {
			if (i >= start && i < end) {
				Audio item = new Audio(news.getId(), news.getAuthor(), news.getTitle(), news.getSource(), news.getCateName());
				items.add(item);
			}
			i++;
		}
		long audioCount = audioList.size();
		long numberOfPage = CommonUtil.getNumberOfPage(audioCount, numPerPage);
		if(numberOfPage < 1) {
			numberOfPage = 1;
		}
		//AudioPage audioPage = audioGalleryDelegate.getListAudio(req, themeDisplay, numPerPage, pageNum, start, end);
		AudioPage audioPage = new AudioPage(req, CommonUtil.convertLongToInt(numberOfPage), pageNum, numPerPage, items);
		//set audio page to attribute
		req.setAttribute("audioPage", audioPage);

		super.serveResource(req, PortalUtil.toJson(res, audioPage));
	}
}
