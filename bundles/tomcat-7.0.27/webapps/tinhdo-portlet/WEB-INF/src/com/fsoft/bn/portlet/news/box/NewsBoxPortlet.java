package com.fsoft.bn.portlet.news.box;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.DateUtils;
import com.fsoft.bn.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NewsBoxPortlet
 */
public class NewsBoxPortlet extends MVCPortlet {
	NewsUtils commonUtilsNews = new NewsUtils();

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		//
		List<News> listNews = null;

		String sortBy = "modifiedDate";
		String newsBoxTitle = null;
		String newsBoxTypeSelect = null;

		String displayFullSize = null;
		String displayImage = null;
		String displaySummary = null;

		//
		if (renderRequest.getPreferences().getMap().containsKey("newsBoxTypeSelect")) {
			newsBoxTypeSelect = renderRequest.getPreferences().getMap().get("newsBoxTypeSelect")[0];
		}
		if (!Validator.isBlankOrNull(newsBoxTypeSelect)) {
//			listNews = NewsUtils.getNews(renderRequest, newsBoxTypeSelect, sortBy);
			for (News news : listNews) {
				news.setCreatedDate(DateUtils.date2String(new Date(news.getCreatedDate()) 
						, CommonConstants.DATE_FORMAT.DD_MM_YYYY_HHMM));
			}
			renderRequest.setAttribute("listNews", listNews);
		}

		//
		if (renderRequest.getPreferences().getMap().containsKey("newsBoxTitle")) {
			newsBoxTitle = renderRequest.getPreferences().getMap().get("newsBoxTitle")[0];
		}
		if (Validator.isBlankOrNull(newsBoxTitle)) {
			newsBoxTitle = CommonConstants.BLANK;
		}
		renderRequest.setAttribute("newsBoxTitle", newsBoxTitle);

		//
		if (renderRequest.getPreferences().getMap().containsKey("displayFullSize")) {
			displayFullSize = renderRequest.getPreferences().getMap().get("displayFullSize")[0];
		}
		renderRequest.setAttribute("displayFullSize", displayFullSize);
		
		//
		if (renderRequest.getPreferences().getMap().containsKey("displayImage")) {
			displayImage = renderRequest.getPreferences().getMap().get("displayImage")[0];
		}
		renderRequest.setAttribute("displayImage", displayImage);
		
		//
		if (renderRequest.getPreferences().getMap().containsKey("displaySummary")) {
			displaySummary = renderRequest.getPreferences().getMap().get("displaySummary")[0];
		}
		renderRequest.setAttribute("displaySummary", displaySummary);
		
		super.doView(renderRequest, renderResponse);
	}

}
