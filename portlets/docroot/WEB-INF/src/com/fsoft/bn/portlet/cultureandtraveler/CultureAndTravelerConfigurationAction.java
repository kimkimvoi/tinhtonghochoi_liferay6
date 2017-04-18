package com.fsoft.bn.portlet.cultureandtraveler;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class CultureAndTravelerConfigurationAction implements
		ConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String portletTypeSelect = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"portletTypeSelect", StringPool.BLANK));
		String isHotNews = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"isHotNews", StringPool.FALSE));
		String quantityItemForSlide = HtmlUtil.escape(ParamUtil.getString(actionRequest,
				"quantityItemForSlide", StringPool.BLANK));
		
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);
		
		preferences.setValue("portletTypeSelect", portletTypeSelect);
		preferences.setValue("isHotNews", isHotNews);
		preferences.setValue("quantityItemForSlide", quantityItemForSlide);
		
		try {
			preferences.store();
		} catch (ValidatorException ve) {
			SessionErrors.add(actionRequest,
					ValidatorException.class.getName(), ve);
			return;
		}
		SessionMessages.add(actionRequest, "success");
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
	}

	@Override
	public String render(PortletConfig porletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		//
		Map<String, String> listTypes = StructureUtil
				.getStructureXSDSelectionList(
						renderRequest,
						CultureAndTravelerConstants.CULTURE_AND_TRAVELER_STRUCTURE_NAME,
						CultureAndTravelerConstants.CULTURE_AND_TRAVELER_CATEGORY_XSD_ELEMENT_NAME);
		renderRequest.setAttribute("listTypes", listTypes);

		//
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil .getPortletSetup(renderRequest, portletResource);

		//
		String portletTypeSelect = null;
		if (prefs.getMap().containsKey("portletTypeSelect")) {
			portletTypeSelect = prefs.getMap().get("portletTypeSelect")[0];
		}
		if (!Validator.isBlankOrNull(portletTypeSelect)) {
			renderRequest.setAttribute("portletTypeSelect", portletTypeSelect);
		} else {
			renderRequest.setAttribute("portletTypeSelect", CultureAndTravelerConstants.DEFAULT_TYPE_CULTURE_AND_TRAVELER);
		}
		
		//
		String isHotNews = null;
		if (prefs.getMap().containsKey("isHotNews")) {
			isHotNews = prefs.getMap().get("isHotNews")[0];
		}
		if (!Validator.isBlankOrNull(isHotNews)) {
			renderRequest.setAttribute("isHotNews", isHotNews);
		} else {
			renderRequest.setAttribute("isHotNews", "false");
		}

		//
		String quantityItemForSlide = null;
		if (prefs.getMap().containsKey("quantityItemForSlide")) {
			quantityItemForSlide = prefs.getMap().get("quantityItemForSlide")[0];
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
		
		
		return "/html/portlet/culture-and-traveler/culture-and-traveler-config.jsp";
	}

}
