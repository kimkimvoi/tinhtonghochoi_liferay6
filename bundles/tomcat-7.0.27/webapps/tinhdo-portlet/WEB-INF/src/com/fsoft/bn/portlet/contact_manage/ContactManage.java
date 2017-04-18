package com.fsoft.bn.portlet.contact_manage;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.log4j.Logger;

import com.fsoft.bn.portlet.news.hot.HotNewsPortlet;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ContactManage
 */
public class ContactManage extends MVCPortlet {
	/** static*/
	private static Logger logging = Logger.getLogger(HotNewsPortlet.class);
	/** jsp view*/
	private String viewJsp;

	public void addNewContact(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

	/*	System.out.println("VangND1 first action");
		String name = ParamUtil.getString(request, "name");
		String phoneNumber = ParamUtil.getString(request, "phoneNumber");

		long id = 0l;
		try {
			// create new entity id
			id = CounterLocalServiceUtil.increment(this.getClass().getName());
		} catch (SystemException e) {
			logging.error(e);
		}

		BNContact model = new BNContactImpl();

		model.setContactId(id);
		model.setName(name);
		model.setPhoneNumber(phoneNumber);
		model.setCreatedDate(new Date());
		model.setModifiedDate(new Date());

		try {
			BNContactLocalServiceUtil.addBNContact(model);
		} catch (SystemException e) {
			logging.error(e);
		}

		logging.info("end action VangND1");
		String redirectUrl = ParamUtil.getString(request, "renderURL");
		response.sendRedirect(redirectUrl);
		logging.info("Redirect to --> View mode:" + redirectUrl);*/
	}

	public void removeContact(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
		/*String id = ParamUtil.getString(request, "id");
		try {
			BNContactLocalServiceUtil.deleteBNContact(Long.parseLong(id));
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}*/
	}
}