package com.fsoft.bn.util;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.constant.CommonConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Utils common for portal
 * 
 * @author ThangBN1
 * 
 */
public class PortalUtil extends com.liferay.portal.util.PortalUtil {
	static Log logger = LogFactoryUtil.getLog(PortalUtil.class);
	
	/**
	 * get global group id
	 * 
	 * @author ThangBN1
	 * @return
	 */
	public static long getGlobalGroupId() {
		long groupId = 0;
		try {
			groupId = GroupLocalServiceUtil.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId();
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		return groupId;
	}

	/**
	 * @author ThangBN1
	 * @param request
	 * @return ThemeDisplay
	 */
	public static ThemeDisplay getThemeDisplay(PortletRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * @author ThangBN1
	 * @param request
	 * @return current group id
	 */
	public static long getGroupId(PortletRequest request) {
		return getThemeDisplay(request).getScopeGroupId();
	}

	/**
	 * @author YenMC
	 * @param request
	 * @return current layout(page) id
	 */
	public static long getLayoutId(PortletRequest request) {
		return getThemeDisplay(request).getPlid();
	}

	/**
	 * @author YenMC
	 * @param request
	 * @return layout(page) id of view detail page
	 */
	public static long getLayoutIdViewDetail(PortletRequest request, String friendlyURL) {
		// return news page layout
		try {
			long layoutId = LayoutLocalServiceUtil.getFriendlyURLLayout(getGroupId(request), false, friendlyURL).getPlid();
			if (layoutId > 0) {
				return layoutId;
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		// if null return current layout of portlet
		return getLayoutId(request);
	}

	/**
	 * @author ThangBN1
	 * @param request
	 * @return
	 */
	public static PortletDisplay getDisplayPortlet(PortletRequest request) {
		return getThemeDisplay(request).getPortletDisplay();
	}

	/**
	 * @author ThangBN1
	 * @param request
	 * @return
	 */
	public static PortletPreferences getPortletPreferences(PortletRequest request) {
		try {
			return PortletPreferencesFactoryUtil.getPortletSetup(request, getPortletInstanceId(request));
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not load preferences for portlet " + e.getLocalizedMessage());
		}
	}

	/**
	 * @author ThangBN1
	 */
	public static String getPortletInstanceId(PortletRequest req) {
		String portletId = ParamUtil.getString(req, CommonConstants.PORTLET_RESOURCE);
		return StringUtils.isNotBlank(portletId) ? portletId : PortalUtil.getPortletId(req);
	}

	/**
	 * @author ThangBN1
	 */
	public static ResourceResponse toJson(ResourceResponse res, Object obj) throws IOException {
		return toJSON(res, GsonUtils.toJson(obj));
	}

	/**
	 * @author ThangBN1
	 */
	public static ResourceResponse toJSON(ResourceResponse res, String json) throws IOException {
		res.getWriter().write(json);
		res.setContentType(ContentTypes.APPLICATION_JSON);
		res.setCharacterEncoding(StringPool.UTF8);
		return res;
	}

	public static String getResourceURL(ResourceResponse res, String ID) {
		ResourceURL resourceURL = res.createResourceURL();
		resourceURL.setResourceID(ID);
		return resourceURL.toString();
	}

}
