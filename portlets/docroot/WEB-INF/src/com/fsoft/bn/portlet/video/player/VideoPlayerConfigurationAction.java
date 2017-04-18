package com.fsoft.bn.portlet.video.player;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoMappingModel;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.util.CommonUtil;
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
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public class VideoPlayerConfigurationAction implements ConfigurationAction{
	
	private static Logger logger = Logger.getLogger(VideoPlayerConfigurationAction.class);
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		logger.info("*******Configuration Video Player : processAction********");	
		String portletResource = ParamUtil.getString(actionRequest, "portletResource"); 

		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		String[] videoCheckboxList = actionRequest.getParameterValues("video_checkbox");
		prefs.setValues("videoChoose", videoCheckboxList);
		prefs.store();
		
		//SessionMessages.add(actionRequest, "success");
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		logger.info("*******Configuration Video Player : render********");
		
		//get list video to request
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<BNVideoModel> listVideo = getFullListVideo(themeDisplay);
		renderRequest.setAttribute("videoList", listVideo);
		
		String portletResource = ParamUtil.getString(renderRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
		
		String[] videoChoose = prefs.getMap().get("videoChoose");
		List<Long> videoIdChoosed = convertArrayToList(videoChoose);
		renderRequest.setAttribute("videoIdChoosed", videoIdChoosed);
		
		return "/html/portlet/video_player/config/video_player_config.jsp";
	}
	/**
	 * Get full data video
	 */
	private List<BNVideoModel> getFullListVideo(ThemeDisplay themeDisplay) {
		BNVideoModel videoModel = null;
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class).add(
				PropertyFactoryUtil.forName("fileEntryTypeId").eq(
						new Long(CommonConstants.PORTLET.VIDEO_GALLERY.VIDEO_FILE_ENTRY_TYPE_ID)));
		dq.add(PropertyFactoryUtil.forName("mimeType").like("%video%"));
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		String urlVideo = StringPool.BLANK;
		List<BNVideoModel> listVideo = new ArrayList<BNVideoModel>();
		Gson gsonObj = new Gson();
		BNVideoMappingModel object = null;
		FileEntry tempFile = null;
		DLFileEntryType fileEntryType = null;
		try {
			//get list video
			List<DLFileEntry> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
			
			if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
				for (DLFileEntry videoFile : dlFileEntry) {
					videoModel = new BNVideoModel();
					tempFile = DLAppLocalServiceUtil.getFileEntry(videoFile.getFileEntryId());
					urlVideo = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(videoFile.getFileEntryTypeId());
					String json = CommonUtil.getMetadataDocumentMediaFieldByName(videoFile , fileEntryType , CommonConstants.THUMB_IMAGE);
					object = gsonObj.fromJson(json, BNVideoMappingModel.class);
					
					//set properties
					if(object != null) {
						object.setFolder(CommonConstants.THUMB_IMAGE);
						videoModel.setImageThums("/documents/ddm/" + object.getClassName() + "/"
								+ object.getClassPK() + "/" + object.getFolder());
					}
					videoModel.setTitle(videoFile.getTitle());
					videoModel.setUrl(urlVideo);
					videoModel.setFileId(videoFile.getFileEntryId());
					//add video to list
					listVideo.add(videoModel);
				}
			}
		} catch (SystemException e) {
			logger.info(e.getMessage());
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		
		return listVideo;
	}
	
	/**
	 * convert : Array String to List Long
	 */
	private List<Long> convertArrayToList(String[] input){
		List<Long> longList = new ArrayList<Long>();
		long current = 0;
		if(input != null){
			for(int i = 0; i < input.length; i++){
				try {
					current = Long.parseLong(input[i]);
					longList.add(current);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
		}
		return longList;
	}
}
