package com.fsoft.bn.portlet.newsboxtinhdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.DataDictionary;
import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.newsboxtinhdo.delegate.NewsBoxTinhDoDelegate;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class WritingAbouttinhdo
 */
@Controller
@RequestMapping(value = "VIEW")
public class NewsBox extends MVCPortlet {
	
	/**
	 * 
	 * @param renderRequest 
	 * @param renderResponse 
	 * @return {@link ModelAndView}
	 * @throws Exception 
	 */
	@RenderMapping
	public ModelAndView handleRenderRequest(RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		NewsBoxTinhDoDelegate NewsBoxTinhDoDelegate = new NewsBoxTinhDoDelegate();
		PortletPreferences prefs = PortalUtil.getPortletPreferences(renderRequest);
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		//get new box type
        String boxType = prefs.getValue("typeBox", "none");
        String recordPerPage = prefs.getValue(CommonConstants.PAGING.RECORD_PER_PAGE, CommonConstants.STRING_5);
        List<DataDictionary> listBoxType = NewsBoxTinhDoDelegate.getListBoxType();
		renderRequest.setAttribute("listBoxType", listBoxType);
        
		if (CommonConstants.STRING_5.equals(boxType)) {
			List<News> listNews = NewsBoxTinhDoDelegate
					.getListBoxNew(renderRequest , CommonConstants.NUM_0, CommonConstants.NUM_1 , boxType , languageId);
			if (!Validator.isBlankOrNull(listNews)) {
				renderRequest.setAttribute("news", listNews.get(CommonConstants.NUM_0));
			}
		} else {
			List<News> listNews = NewsBoxTinhDoDelegate.getListBoxNew(renderRequest, CommonConstants.NUM_0,
					Integer.valueOf(recordPerPage), boxType, languageId);
			renderRequest.setAttribute("listNews", listNews);
		}
		renderRequest.setAttribute("boxType", boxType);
		Map<String, Object> mv = new HashMap<String, Object>();
		return new ModelAndView("news_box_tinhdo/news-box-tinhdo-view", mv);
	}

}
