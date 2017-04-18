package com.fsoft.bn.portlet.cultureandtraveler;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CultureAndTravelerPortlet
 */
public class CultureAndTravelerPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		//
		List<News> listNews = null;

		String sortBy = CultureAndTravelerConstants.DEFAULT_SORT_FIELD;
		String portletTypeSelect = "";
		String isHotNews = "";
		String quantityItemForSlide = "";
		//
		if (renderRequest.getPreferences().getMap().containsKey("portletTypeSelect")) {
			portletTypeSelect = renderRequest.getPreferences().getMap().get("portletTypeSelect")[0];
		}
		if (Validator.isBlankOrNull(portletTypeSelect)) {
			portletTypeSelect = CultureAndTravelerConstants.DEFAULT_TYPE_CULTURE_AND_TRAVELER;	
		}
		listNews = CultureAndTravelerUtils.getCultureAndTravelerByCategory(renderRequest, sortBy, portletTypeSelect);
		renderRequest.setAttribute("portletTitle", portletTypeSelect);
		renderRequest.setAttribute("listNews", listNews);
		//
		if (renderRequest.getPreferences().getMap().containsKey("isHotNews")) {
			isHotNews = renderRequest.getPreferences().getMap().get("isHotNews")[0];
		}
		if (!Validator.isBlankOrNull(isHotNews)) {
			renderRequest.setAttribute("isHotNews", isHotNews);
		} else {
			renderRequest.setAttribute("isHotNews", "false");
		}
		
		//
		if (renderRequest.getPreferences().getMap().containsKey("quantityItemForSlide")) {
			quantityItemForSlide = renderRequest.getPreferences().getMap().get("quantityItemForSlide")[0];
		}
		if (!Validator.isBlankOrNull(quantityItemForSlide)) {
			renderRequest.setAttribute("quantityItemForSlide", quantityItemForSlide);
		} else {
			if (!Validator.isBlankOrNull(isHotNews)) {
				if (isHotNews.equals("true")) {
					renderRequest.setAttribute("quantityItemForSlide", CultureAndTravelerConstants.DEFAULT_QUANTITY_ITEMS_FOR_SLIDE);
				} else {
					renderRequest.setAttribute("quantityItemForSlide", CultureAndTravelerConstants.DEFAULT_QUANTITY_ITEMS_FOR_LIST_NEWS);
				}
			} else {
				renderRequest.setAttribute("quantityItemForSlide", CultureAndTravelerConstants.DEFAULT_QUANTITY_ITEMS_FOR_LIST_NEWS);
			}
		}
		
		super.doView(renderRequest, renderResponse);
	}

}
