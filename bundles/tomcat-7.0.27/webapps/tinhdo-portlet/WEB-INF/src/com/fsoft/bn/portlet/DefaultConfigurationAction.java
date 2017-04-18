package com.fsoft.bn.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.ResourceServingConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 */
public class DefaultConfigurationAction implements ConfigurationAction, ResourceServingConfigurationAction {

	private static final String CONFIG_JSP = "config-jsp";
	private static final String VIEW_JSP = "view-jsp";
	protected String viewJsp;
	protected String configJsp;

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(actionRequest, "portletResource");

		PortletPermissionUtil.check(themeDisplay.getPermissionChecker(), themeDisplay.getLayout(), portletResource,
				ActionKeys.CONFIGURATION);

		PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		if (SessionErrors.isEmpty(actionRequest)) {
			portletPreferences.store();

			LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;

			SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
					portletResource);

			SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId() + SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
		}
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		configJsp = getSelPortletConfig(renderRequest).getInitParameter(CONFIG_JSP);
		viewJsp = getSelPortletConfig(renderRequest).getInitParameter(VIEW_JSP);

		return configJsp;
	}

	public void serveResource(PortletConfig portletConfig, ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
	}

	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest) throws SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(portletRequest, "portletResource");

		Portlet selPortlet = PortletLocalServiceUtil.getPortletById(themeDisplay.getCompanyId(), portletResource);

		ServletContext servletContext = (ServletContext) portletRequest.getAttribute(WebKeys.CTX);

		PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(selPortlet, servletContext);

		return selPortletConfig;
	}

}