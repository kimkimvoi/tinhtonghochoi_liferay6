package com.fsoft.bn.portlet.newsboxtinhdo;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.portlet.newsboxtinhdo.delegate.NewsBoxTinhDoDelegate;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * Portlet implementation class WritingAbouttinhdo
 */
@Controller
@RequestMapping(value = "CONFIG")
public class NewsBoxTinhDoConfiguration implements ConfigurationAction {
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		NewsBoxTinhDoDelegate NewsBoxTinhDoDelegate = new NewsBoxTinhDoDelegate();
		List<DataDictionary> listBoxType = NewsBoxTinhDoDelegate.getListBoxType();
		
		PortletPreferences prefs = PortalUtil.getPortletPreferences(renderRequest);
		String boxType = prefs.getValue("typeBox", "none");
	    String recordPerPage = prefs.getValue(CommonConstants.PAGING.RECORD_PER_PAGE, CommonConstants.BLANK);
	    
	    //set value to request
	    renderRequest.setAttribute("listBoxType", listBoxType);
	    renderRequest.setAttribute("currentType", Integer.valueOf(boxType));
	    renderRequest.setAttribute("currentPageDisplay", recordPerPage);
	    
		return "/html/portlet/news_box_tinhdo/news-box-tinhdo-config.jsp";
	}
	
	/**
	 * Process action
	 * @param portletConfig 
	 * @param actionRequest 
	 * @param actionResponse 
	 * @throws Exception 
	 */
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		String typeBox = ParamUtil.getString(actionRequest, "typeBox");
		String recordPerPage = ParamUtil.getString(actionRequest, "recordPerPage");
    	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
        prefs.setValue("typeBox", typeBox);
        prefs.setValue(CommonConstants.PAGING.RECORD_PER_PAGE, recordPerPage);
        prefs.store();
        SessionMessages.add(actionRequest, CommonConstants.REQUEST.STATUS.SUCCESS);
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
				portletResource);
	}
}
