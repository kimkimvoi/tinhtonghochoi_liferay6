package com.fsoft.bn.portlet.usefulphone;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.model.UserfulContactPhone;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UsefulPhonePortlet
 */
public class UsefulPhonePortlet extends MVCPortlet {
	private static Logger _logger = Logger.getLogger(UsefulPhonePortlet.class);
	
	@Override
	public void doView(RenderRequest request,
			RenderResponse response) throws IOException, PortletException {

		/*try {
			countContact = BNContactLocalServiceUtil.getBNContactsCount();
			List<BNContact> listContact = BNContactLocalServiceUtil.getBNContacts(0, countContact);
			request.setAttribute("listContact", listContact);		
			List<UserfulContactPhone> listUserfulContactPhones = UserfulContactPhoneUtil.findAll();
			request.setAttribute("listContact", listUserfulContactPhones);		
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}*/	
		try{
			_logger.debug("START DO VIEW USEFUL PHONE");
			List<UserfulContactPhone> lstContactPhone = UserfulPhonePortletDelegate.getAllContactPhoneArticle(request);
			request.setAttribute("listContact", lstContactPhone);	
		}catch (Exception e) {
			// TODO: handle exception
		}
		super.doView(request, response);
	}
	
}
