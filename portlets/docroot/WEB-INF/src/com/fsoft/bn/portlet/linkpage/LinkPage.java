package com.fsoft.bn.portlet.linkpage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.LinkPageModel;
import com.fsoft.bn.portlet.linkpage.delegate.LinkPageDelegate;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LinkPage
 */
public class LinkPage extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) 
			throws IOException, PortletException {
		LinkPageDelegate linkPageDelegate = new LinkPageDelegate();
		//get all link page
		List<LinkPageModel> listLinkPageModel = linkPageDelegate.getAllLinkPage();
		renderRequest.setAttribute(CommonConstants.PORTLET.LINK_PAGE.LIST_LINK_PAGE, listLinkPageModel);
		//list type
		List<DataDictionary> dataDictionaries = linkPageDelegate.getListLinkPageCategory();
		renderRequest.setAttribute(CommonConstants.PORTLET.LINK_PAGE.LIST_TYPE, dataDictionaries);
		//list type empty data
		List<DataDictionary> dataDictionariesClone = getListLinkTypeEmptyData(dataDictionaries, listLinkPageModel);
		renderRequest.setAttribute(CommonConstants.PORTLET.LINK_PAGE.LIST_TYPE_EMPTY_DATA, dataDictionariesClone);
		//get link page type
		super.doView(renderRequest, renderResponse);
	}
	/**
	 * This method using filter list type emtpty
	 * @param dataDictionaries 
	 * @param listLinkPageModel 
	 * @return {@link List<DataDictionary>}
	 */
	private List<DataDictionary> getListLinkTypeEmptyData(List<DataDictionary> dataDictionaries,
			List<LinkPageModel> listLinkPageModel) {
		
		List<DataDictionary> dataDictionariesClone = new ArrayList<DataDictionary>(dataDictionaries);
		for (DataDictionary type : dataDictionaries) {
			for (LinkPageModel link : listLinkPageModel) {
				if (type.getKey() == Long.parseLong(link.getType())) {
					dataDictionariesClone.remove(type);
				}
				
			}
		}
		return dataDictionariesClone;
	}
}

