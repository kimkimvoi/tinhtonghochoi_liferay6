package com.fsoft.bn.portlet.login.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class LoginPortlet extends GenericPortlet {

	protected String viewJsp;
	protected String editJsp;
	private static Log _log = LogFactory.getLog(LoginPortlet.class);

	public void init() throws PortletException {
		viewJsp = getInitParameter("view-jsp");
		editJsp = getInitParameter("edit-jsp");
	}

	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		 PortletPreferences prefs = request.getPreferences();
		    String username = (String) prefs.getValue("name", "no");
		    if (username.equalsIgnoreCase("no")) {
		        username = "";
		    }
		    request.setAttribute("userName", username);

		include(viewJsp, request, response);
	}

	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		    renderResponse.setContentType("text/html");
		    // add parameters, set window state, set portlet mode
		    // parameters get from this method can be used by processAction method
		    PortletURL addNameURL = renderResponse.createActionURL();
		    addNameURL.setParameter("addName", "addName");
		    renderRequest.setAttribute("addNameURL", addNameURL.toString());

		    // add parameters, set window state, set portlet mode
		    include(editJsp, renderRequest, renderResponse);
	}

	private void include(String path, RenderRequest renderRequest,
	RenderResponse renderResponse) throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher =
			getPortletContext().getRequestDispatcher(path);
			if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
			} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
			}
	}

	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	throws IOException, PortletException {
		    String addName = actionRequest.getParameter("addName");
	        if (addName != null) {
	            PortletPreferences prefs = actionRequest.getPreferences();
	            prefs.setValue("name", actionRequest.getParameter("username"));
	            prefs.store();
	            // return View mode of portlet
	            actionResponse.setPortletMode(PortletMode.VIEW);
	        }
	}
}