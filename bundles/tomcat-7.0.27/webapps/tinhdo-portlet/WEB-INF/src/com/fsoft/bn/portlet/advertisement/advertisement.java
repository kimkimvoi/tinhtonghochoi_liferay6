package com.fsoft.bn.portlet.advertisement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AdvertisementConfigModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * Portlet implementation class advertisement
 */
@Controller
@RequestMapping(value = "VIEW")
public class advertisement {
 
Gson gson = new Gson();
	
	/**
	 * init view
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 * @throws Exception
	 */
	@RenderMapping
	public ModelAndView handleRenderRequest(PortletRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
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
        String imageList = prefs.getValue(CommonConstants.PREFS_IMAGE_DISPLAYED_IDS, StringPool.BLANK);
        String durationTime = prefs.getValue(CommonConstants.PREFS_DURATION_TIME, CommonConstants.STRING_5);
        String imageWidth = prefs.getValue(CommonConstants.PREFS_IMAGE_WIDTH, CommonConstants.STRING_200);
        String imageHeigh = prefs.getValue(CommonConstants.PREFS_IMAGE_HEIGH, CommonConstants.STRING_200);
        String[] itemsDisplayed = imageList.split(CommonConstants.COMMA);
		
		List<PictureModel> listImages = getDisplayAdvertiesmentFiles(themeDisplay);
		List<PictureModel> listDisplayed = new ArrayList<PictureModel>();
		
		for (PictureModel p : listImages) {
			for (String id : itemsDisplayed) {
				if (id.equalsIgnoreCase(String.valueOf(p.getFileId()))) {
					listDisplayed.add(p);
				}
			}
		}
		
		AdvertisementConfigModel model = new AdvertisementConfigModel();
		model.setPictures(listDisplayed);
		model.setDurationTime(durationTime);
		model.setImageWidth(imageWidth);
		model.setImageHeigh(imageHeigh);
		model.setPortletId(UUID.randomUUID().toString());
		renderRequest.setAttribute("adv", model);
		
		return new ModelAndView("advertisement/advertisement-view");
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
	protected List<PictureModel> getDisplayAdvertiesmentFiles(ThemeDisplay themeDisplay) throws SystemException, PortalException {
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
			
			DLFileEntryType fileEntryType = null;
			for (DLFileEntry file : dlFileEntry) {
				
				image = new PictureModel();
				FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(file.getFileEntryId());
				imageURL = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(file.getFileEntryTypeId());
				String fieldValue = CommonUtil.getMetadataDocumentMediaFieldByName(file, fileEntryType , "txtURL");
				
				image.setFileId(file.getFileEntryId());
				image.setTitle(file.getTitle());
				image.setUrl(imageURL);
				image.setLink(fieldValue);
				listImages.add(image);
			}
		}
		return listImages;
	}
}
