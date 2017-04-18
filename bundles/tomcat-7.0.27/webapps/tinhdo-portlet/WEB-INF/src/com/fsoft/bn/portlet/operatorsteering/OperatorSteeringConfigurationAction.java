package com.fsoft.bn.portlet.operatorsteering;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.Structure;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class OperatorSteeringConfigurationAction implements ConfigurationAction{
	
	private static Logger logger = Logger.getLogger(OperatorSteeringConfigurationAction.class);
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		logger.info("*******Configuration OperatorSteering : processAction********");	
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 
		String structureId = ParamUtil.getString(actionRequest, "structureId");
		
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("structureId", structureId);
		prefs.store();
		
		//SessionMessages.add(actionRequest, "success");
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		logger.info("*******Configuration OperatorSteering : render********");
		
		//get list structure
		List<Structure> operatorSteeringStructures = OperatorSteeringDelegate.getStructureNameList(renderRequest, CommonConstants.OPERATOR_STEERING_STRUCTURE_NAME);
		renderRequest.setAttribute("operatorSteeringStructures", operatorSteeringStructures);
		
		//get preferences
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		String structureIdChoose = prefs.getValue("structureId", portletResource);
		renderRequest.setAttribute("structureIdChoose", structureIdChoose);		
		return "/html/portlet/operatorsteering/operator_steering_config.jsp";
	}
	
}
