package com.fsoft.bn.portlet.advertisement;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdvertisementConfigModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * Portlet implementation class AdvertisementConfiguration
 * @author KienNN
 */
@Controller
@RequestMapping(value = "CONFIG")
public class AdvertisementConfiguration implements ConfigurationAction {
	
	Gson gson = new Gson();
	/** logger */
	private static Logger logger = Logger.getLogger(AdvertisementConfiguration.class);
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		try {
			//Init Theme and Locale
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			String portletResource = ParamUtil.getString(renderRequest, CommonConstants.PORTLET_RESOURCE);
			PortletPreferences prefs = renderRequest.getPreferences();
			
			if (portletResource == null	|| StringPool.BLANK.equals(portletResource.trim())) {
				portletResource = themeDisplay.getPortletDisplay().getId();
			}
			if (!Validator.isBlankOrNull(portletResource)) {
			    prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
			}
			
			String displayType = prefs.getValue(CommonConstants.PREFS_DISPLAY_TYPE, StringPool.BLANK);
			String imageList = prefs.getValue(CommonConstants.PREFS_IMAGE_DISPLAYED_IDS, StringPool.BLANK);
			String[] itemsDisplayed = imageList.split(CommonConstants.COMMA);
			String imageHeigh = CommonConstants.STRING_200;
			String imageWidth  = CommonConstants.STRING_200;
			String durationTime = StringPool.BLANK;
			String title = StringPool.BLANK;
			if (!CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_LOGO.equalsIgnoreCase(displayType)) {
				durationTime = prefs.getValue(CommonConstants.PREFS_DURATION_TIME, CommonConstants.STRING_5);
				imageHeigh = prefs.getValue(CommonConstants.PREFS_IMAGE_HEIGH, CommonConstants.STRING_200);
				imageWidth = prefs.getValue(CommonConstants.PREFS_IMAGE_WIDTH, CommonConstants.STRING_200);
				title = prefs.getValue("title","Welcome to Ban Mai School");
			}
			List<PictureModel> listImages = getAdvertiesmentFiles(themeDisplay);
			
			for (PictureModel p : listImages) {
				p.setDisplay(false);
				for (String id : itemsDisplayed) {
					if (id.equalsIgnoreCase(String.valueOf(p.getFileId()))) {
						p.setDisplay(true);
						break;
					}
				}
			}
			
			AdvertisementConfigModel model = new AdvertisementConfigModel();
			model.setPictures(listImages);
			model.setDurationTime(durationTime);
			model.setImageWidth(imageWidth);
			model.setImageHeigh(imageHeigh);
			model.setDisplayType(displayType);
			model.setTitle(title);
			
			renderRequest.setAttribute("adv", model);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return "/html/portlet/advertisement/advertisement-config.jsp";
	}

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletResource = ParamUtil.getString(actionRequest, CommonConstants.PORTLET_RESOURCE);
		List<PictureModel> listImages = getAdvertiesmentFiles(themeDisplay);
		
		StringBuffer itemIds = new StringBuffer();
		String itemId = StringPool.BLANK;
		
		String durationTime = actionRequest.getParameter("_time_slide");
		String imageWidth = actionRequest.getParameter("_image_width");
		String imageHeigh = actionRequest.getParameter("_image_heigh");
		String displayType = actionRequest.getParameter("displayType");
		String title = actionRequest.getParameter("title");
		for (PictureModel p : listImages) {
			itemId = actionRequest.getParameter(String.valueOf(p.getFileId()));
			if (!Validator.isBlankOrNull(itemId)) {
				itemIds.append(itemId);
				itemIds.append(CommonConstants.COMMA);
			}
		}
		
    	PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource); 
        prefs.setValue(CommonConstants.PREFS_IMAGE_DISPLAYED_IDS, itemIds.toString());
        prefs.setValue(CommonConstants.PREFS_DURATION_TIME, durationTime);
        prefs.setValue(CommonConstants.PREFS_IMAGE_WIDTH, imageWidth);
        prefs.setValue(CommonConstants.PREFS_IMAGE_HEIGH, imageHeigh);
        prefs.setValue(CommonConstants.PREFS_DISPLAY_TYPE, displayType);
        if(!Validator.isBlankOrNull(title))
        prefs.setValue("title", title);
        prefs.store();
        SessionMessages.add(actionRequest, "success");
	}
	
	/**
	 * Get Advertisement files
	 * @author KienNN
	 * @param start
	 * @param end
	 * @param themeDisplay
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@SuppressWarnings("unchecked")
	protected List<PictureModel> getAdvertiesmentFiles(ThemeDisplay themeDisplay) throws SystemException, PortalException {
		//Create Dynamic Query
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class);
		dq.add(PropertyFactoryUtil.forName(CommonConstants.FILE_ENTRY_TYPE_ID).eq(new Long(CommonConstants.DOCUMENTMEDIA.ADVERTISEMENT_FILE_ENTRY_TYPE_ID)));
		dq.addOrder(OrderFactoryUtil.desc(CommonConstants.CREATE_DATE));
		
		String imageURL = StringPool.BLANK;
		PictureModel image = null;
		List<PictureModel> listImages = new ArrayList<PictureModel>();
		
		//Get Advertisement Files
		List<DLFileEntry> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
		
		//Build to list of BNPictureModel
		if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
			for (DLFileEntry file : dlFileEntry) {
				
				image = new PictureModel();
				FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(file.getFileEntryId());
				imageURL = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				
				image.setFileId(file.getFileEntryId());
				image.setTitle(file.getTitle());
				image.setUrl(imageURL);
				listImages.add(image);
			}
		}
		return listImages;
	}
	
}
