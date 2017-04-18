package com.fsoft.bn.portlet.administrative.organization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdministrativeOrganizationModel;
import com.fsoft.bn.domain.LinkModel;
import com.fsoft.bn.domain.LinkPageModel;
import com.fsoft.bn.portlet.linkpage.delegate.LinkPageDelegate;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AdministrativeOrganization
 */
public class AdministrativeOrganizationPortlet extends MVCPortlet {
	/** static*/
	private static Logger 	logger = Logger.getLogger(AdministrativeOrganizationPortlet.class);
	private static int		NUMBER_OF_ARTICLE_DISPLAY = 3;

	private String	amindOrganizationStructure;
	private String 	tinhUy;
	private String	hoiDongNhanDan;
	private String	uyBanNhanDan;
	private String 	tinhUyChucNangNhiemVu;
	private String 	tinhUyGioiThieu;
	private String 	tinhUyToChucBoMay;
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		logger.info("======= AdministrativeOrganizationPortlet START=======");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// get group id by scope
		long groupId = themeDisplay.getScopeGroupId();
		amindOrganizationStructure = CommonUtil.getText(renderRequest, "portlet.administrative.organization.structure.key");
		tinhUy = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.tinhuy");
		hoiDongNhanDan = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.hoidongnhandan");
		uyBanNhanDan = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.uybannhandan");
		tinhUyChucNangNhiemVu = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.chucnangnhiemvu");
		tinhUyGioiThieu = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.giothieu");
		tinhUyToChucBoMay = CommonUtil.getText(renderRequest, "portlet.administrative.organization.key.tochubomay");
		
		//get Tabs info
		getTinhUyInfo(renderRequest, renderResponse, groupId);
		getHoiDongNhanDanInfo(renderRequest, renderResponse, groupId);
		getUyBanNhanDanInfo(renderRequest, renderResponse, groupId);
		getListLinkPage(renderRequest, renderResponse);
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String cateType = null;
		String structureId = StructureUtil.getStructureId(amindOrganizationStructure);
		if (null != actionRequest.getParameter("cateTypeTinhUy")) {
			cateType = actionRequest.getParameter("cateTypeTinhUy");
		}
		if (null != actionRequest.getParameter("cateTypeHoiDongNhanDan")) {
			cateType = actionRequest.getParameter("cateTypeTinhUy");
		}
		if (null != actionRequest.getParameter("cateTypeUyBanNhanDan")) {
			cateType = actionRequest.getParameter("cateTypeUyBanNhanDan");
		}
		String portletURL = NewsUtils.returnPortletURLByNewsCategory(actionRequest, "/view-all-news", PORTLET_NAME.ALL_NEWS_BY_CATEGORY, String.valueOf(PortalUtil.getGroupId(actionRequest)), structureId, cateType);
		actionResponse.sendRedirect(portletURL);
		
		super.processAction(actionRequest, actionResponse);
	}
	
	/**
	 * getTinhUy info
	 */
	private void getTinhUyInfo(RenderRequest renderRequest, RenderResponse renderResponse, long groupId){
		int start = 0;
		int end = start + NUMBER_OF_ARTICLE_DISPLAY;
		//get tinh uy introduce
		AdministrativeOrganizationModel tinhUyIntroduce = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, tinhUy, tinhUyGioiThieu);
		renderRequest.setAttribute("tinhUyIntroduce", tinhUyIntroduce);
		
		//get tinh uy functional
		AdministrativeOrganizationModel tinhUyfunctional = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, tinhUy, tinhUyChucNangNhiemVu);
		renderRequest.setAttribute("tinhUyFunctional", tinhUyfunctional);
		
		//get tinhuy administrative organization
		List<AdministrativeOrganizationModel> listAllAdminOrganization = AdministrativeOrganizationDelegate.
				getListAdminOrganization(renderRequest, groupId, amindOrganizationStructure, tinhUy, tinhUyToChucBoMay);
		
		if(null != listAllAdminOrganization){
			List<AdministrativeOrganizationModel> listAdminOrganizationPage = listAdminOrganizationPaging(
					listAllAdminOrganization, start, end);
			renderRequest.setAttribute("listAdminOrganizationPage", listAdminOrganizationPage);
		}
	}
	
	/**
	 * get hoi dong nhan dan info
	 */
	private void getHoiDongNhanDanInfo(RenderRequest renderRequest, RenderResponse renderResponse, long groupId){
		int start = 0;
		int end = start + NUMBER_OF_ARTICLE_DISPLAY;
		//get hoi dong introduce
		AdministrativeOrganizationModel hoidongIntroduce = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, hoiDongNhanDan, tinhUyGioiThieu);
		renderRequest.setAttribute("hoidongIntroduce", hoidongIntroduce);
		
		//get hoi dong functional
		AdministrativeOrganizationModel hoiDongFunctional = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, hoiDongNhanDan, tinhUyChucNangNhiemVu);
		renderRequest.setAttribute("hoiDongFunctional", hoiDongFunctional);
		
		//get hoi dong administrative organization
		List<AdministrativeOrganizationModel> listAllHoiDong = AdministrativeOrganizationDelegate.
				getListAdminOrganization(renderRequest, groupId, amindOrganizationStructure, hoiDongNhanDan, tinhUyToChucBoMay);
		
		if(null != listAllHoiDong){
			List<AdministrativeOrganizationModel> listHoiDongPage = listAdminOrganizationPaging(
					listAllHoiDong, start, end);
			renderRequest.setAttribute("hoiDongBoMay", listHoiDongPage);
		}
	}
	
	/**
	 * get uy ban nhan dan info
	 * @param renderRequest
	 * @param renderResponse
	 * @param groupId
	 */
	private void getUyBanNhanDanInfo(RenderRequest renderRequest, RenderResponse renderResponse, long groupId){
		int start = 0;
		int end = start + NUMBER_OF_ARTICLE_DISPLAY;
		//get uy ban nhan dan introduce
		AdministrativeOrganizationModel uybanIntroduce = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, uyBanNhanDan, tinhUyGioiThieu);
		renderRequest.setAttribute("uybanIntroduce", uybanIntroduce);
		
		//get uy ban nhan dan functional
		AdministrativeOrganizationModel uybanFunctional = AdministrativeOrganizationDelegate.
				getIntroduceArticel(renderRequest, groupId, amindOrganizationStructure, uyBanNhanDan, tinhUyChucNangNhiemVu);
		renderRequest.setAttribute("uybanFunctional", uybanFunctional);
		
		//get uy ban nhan dan administrative organization
		List<AdministrativeOrganizationModel> listAllUyBan = AdministrativeOrganizationDelegate.
				getListAdminOrganization(renderRequest, groupId, amindOrganizationStructure, uyBanNhanDan, tinhUyToChucBoMay);
		
		if(null != listAllUyBan){
			List<AdministrativeOrganizationModel> listUyBanPage = listAdminOrganizationPaging(
					listAllUyBan, start, end);
			renderRequest.setAttribute("uyBanBoMay", listUyBanPage);
		}
	}
	/**
	 * get list link page
	 */
	private void getListLinkPage(RenderRequest renderRequest, RenderResponse renderResponse){
		LinkPageDelegate linkPageDelegate = new LinkPageDelegate();
		//get all link page
		List<LinkPageModel> listLinkPageModel = linkPageDelegate.getAllLinkPage();
		List<LinkModel> listSoBanNganh = new ArrayList<LinkModel>();
		List<LinkModel> listHuyenThiThanh = new ArrayList<LinkModel>();
		
		for (LinkPageModel link: listLinkPageModel) {
			if(CommonConstants.STRING_01.equals(link.getType()))
				listSoBanNganh = link.getLinks();
			if(CommonConstants.STRING_02.equals(link.getType()))
				listHuyenThiThanh = link.getLinks();
		}
		
		renderRequest.setAttribute("listSoBanNganh", listSoBanNganh);
		renderRequest.setAttribute("listHuyenThiThanh", listHuyenThiThanh);
		
	}
	/**
	 * get list administrative organization paging
	 */
	private List<AdministrativeOrganizationModel> listAdminOrganizationPaging(
			List<AdministrativeOrganizationModel> listAllArticle, int start, int end){
		List<AdministrativeOrganizationModel> mListLegalDocPaging = new ArrayList<AdministrativeOrganizationModel>();
		
		if(listAllArticle.size() > 0 && listAllArticle.size() > start){
			for (int i = start; i < end; i++) {
				if(i < listAllArticle.size()){
					mListLegalDocPaging.add(listAllArticle.get(i));
				}else {
					break;
				}
			}
		}		
		return mListLegalDocPaging;
	}
}
