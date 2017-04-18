package com.fsoft.bn.portlet.newsboxtinhdo.list;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class WritingAbouttinhdoList
 */
public class NewsBoxTinhDoList extends MVCPortlet {
	
	/**
	 * do view method
	 * @param request  
	 * @param response  
	 * @throws IOException 
	 * @throws PortletException 
	 */
	public void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		/*NewsBoxTinhDoDelegate writingAbouttinhdoDelegate = new NewsBoxTinhDoDelegate();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		String mode = httpRequest.getParameter("mode");
		if ("detail".equals(mode)) {
			
			request.setAttribute("mode", "detail");
			String id = httpRequest.getParameter("id");
			WritingAbouttinhdoModel model = writingAbouttinhdoDelegate.getWritingAbouttinhdoModelById(Long
					.parseLong(id));
			request.setAttribute("writingAbouttinhdoModel", model);
			List<WritingAbouttinhdoModel> listLatest = writingAbouttinhdoDelegate.getListWritingAbouttinhdoModel(
					CommonConstants.NUM_0, CommonConstants.NUM_9);
			
			request.setAttribute("listLatest", listLatest);
		} else if ("list".equals(mode)) {
			String itemsPerPageText = CommonUtil.getText(request, "portlet.common.paging.itemsPerPageText");
			int numOfPage = CommonUtil.getNumberOfPage(writingAbouttinhdoDelegate.getCountWritingAbouttinhdo(),
					CommonConstants.PAGING.RECORDS_PER_PAGE);
			request.setAttribute(CommonConstants.PAGING.NUMBER_OF_PAGE, numOfPage);
			request.setAttribute("numPerPage", CommonConstants.PAGING.RECORDS_PER_PAGE);
			request.setAttribute("itemsPerPageText", itemsPerPageText);

			String curPageStatusText = CommonUtil.getText(request, "portlet.common.paging.curPageStatusText");
			request.setAttribute(CommonConstants.PAGING.CURRENT_PAGE_STATUS, curPageStatusText);
			List<WritingAbouttinhdoModel> listWritingAbouttinhdo = writingAbouttinhdoDelegate
					.getListWritingAbouttinhdoModel(CommonConstants.NUM_0, CommonConstants.PAGING.RECORDS_PER_PAGE);
			request.setAttribute("mode", "list");
			request.setAttribute("listWritingAbouttinhdo" , listWritingAbouttinhdo);
		}*/
		super.doView(request, response);
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		if ("writingAbouttinhdo_LoadPage".equals(resourceID)) {
			//call method get data to render
			writingAbouttinhdoLoadPage(resourceRequest, resourceResponse);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	/**
	 * This method using when ajax paging call load page
	 * @param request 
	 * @param response 
	 * @author VangND1 
	 */
	private void writingAbouttinhdoLoadPage(ResourceRequest request, ResourceResponse response) {
		/*NewsBoxTinhDoDelegate writingAbouttinhdoDelegate = new NewsBoxTinhDoDelegate();
		String pageNumStr = ParamUtil.getString(request, "pageNum");		
		int numPerPage = ParamUtil.getInteger(request, "numPerPage");
		if (numPerPage == 0) {
			numPerPage = CommonConstants.RECORDS_PER_PAGE;
		}
		int pageNum = Integer.parseInt(pageNumStr);					
		int start = numPerPage * (pageNum - 1);					
		int end = start + numPerPage;
		int numOfPage = CommonUtil.getNumberOfPage(writingAbouttinhdoDelegate.getCountWritingAbouttinhdo(),
				numPerPage);
		List<WritingAbouttinhdoModel> listWritingAbouttinhdoModel;			
		try {					
			listWritingAbouttinhdoModel = writingAbouttinhdoDelegate.getListWritingAbouttinhdoModel(start, end);
			Gson gson = new Gson();				
			JSONObject json = JSONFactoryUtil.createJSONObject();				
			json.put("items", gson.toJson(listWritingAbouttinhdoModel));				
			json.put("recordPerPage", numPerPage);
			json.put("numOfPage", numOfPage);
			response.getWriter().write(json.toString());				
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
 

}
