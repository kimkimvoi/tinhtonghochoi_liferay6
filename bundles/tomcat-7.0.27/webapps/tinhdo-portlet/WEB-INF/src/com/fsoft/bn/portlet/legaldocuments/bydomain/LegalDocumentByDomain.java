package com.fsoft.bn.portlet.legaldocuments.bydomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.LegalDocumentByDomainModel;
import com.fsoft.bn.portlet.legaldocuments.bydomain.delegate.LegalDocumentByDomainDelegate;
import com.fsoft.bn.util.CommonUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LegalDocumentByDomain
 */
@Controller
@RequestMapping(value = "VIEW")
public class LegalDocumentByDomain extends MVCPortlet {

	/**
	 * This method using render request
	 * @param renderRequest 
	 * @param renderResponse 
	 * @return {@link ModelAndView}
	 * @throws Exception 
	 */
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		LegalDocumentByDomainDelegate legalDocumentByDomainDelegate = new LegalDocumentByDomainDelegate();
		List<LegalDocumentByDomainModel> legalDocumentList = legalDocumentByDomainDelegate
				.getLegalDocumentByDomainModel(CommonConstants.NUM_0, CommonConstants.NUM_5, "Nội chính",
						languageId);
		//set value to request
		renderRequest.setAttribute("legalDocumentList", legalDocumentList);
		renderRequest.setAttribute("listPropertyDisplay", getListPropertyDisplay());
		renderRequest.setAttribute("listHeaderDisplay",
				CommonUtil.getHeaderList(renderRequest, CommonConstants.LEGAL_DOCUMENT_BYDOMAIN_HEADER_KEYS));
		//set paging value
		String itemsPerPageText = CommonUtil.getText(renderRequest, "portlet.common.paging.itemsPerPageText");
		int numOfPage = CommonUtil.getNumberOfPage(
				legalDocumentByDomainDelegate.getCountLegalDocumentByDomainModel("Nội chính", languageId),
				CommonConstants.PAGING.RECORDS_PER_PAGE);
		renderRequest.setAttribute(CommonConstants.PAGING.NUMBER_OF_PAGE, numOfPage);
		renderRequest.setAttribute("numPerPage", CommonConstants.PAGING.RECORDS_PER_PAGE);
		renderRequest.setAttribute("itemsPerPageText", itemsPerPageText);

		String curPageStatusText = CommonUtil.getText(renderRequest, "portlet.common.paging.curPageStatusText");
		renderRequest.setAttribute(CommonConstants.PAGING.CURRENT_PAGE_STATUS, curPageStatusText);
		//create mov
		Map<String, Object> mv = new HashMap<String, Object>();
		return new ModelAndView("legal_document_by_domain/legal-document-by-domain-main-view", mv);
	}
	/**
	 * 
	 * @return {@link List<String>}
	 */
	private List<String> getListPropertyDisplay(){
		List<String> listProperty = new ArrayList<String>();
		listProperty.add("no");
		listProperty.add("title");
		return listProperty;
	}
}
