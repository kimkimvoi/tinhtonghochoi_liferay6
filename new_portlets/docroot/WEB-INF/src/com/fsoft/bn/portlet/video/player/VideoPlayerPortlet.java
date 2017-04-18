package com.fsoft.bn.portlet.video.player;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoMappingModel;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoPlayerPortlet
 */
public class VideoPlayerPortlet extends MVCPortlet {
	private static Logger logger = Logger.getLogger(VideoPlayerPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = PortalUtil.getThemeDisplay(renderRequest);
		PortletPreferences prefs = null;
		
		try {
			prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		String[] videoChoose = prefs.getMap().get("videoChoose");
		
		//get data
		Long[] videoIdArray = convertArrayStringToLong(videoChoose);
		List<BNVideoModel> videoModels = new ArrayList<BNVideoModel>();
		videoModels = getListVideoById(themeDisplay, videoIdArray);
		String urlFirst = "";
		/*if(!videoModels.isEmpty()){
			urlFirst = videoModels.get(0).getUrl();
		}*/
		urlFirst = URLEncoder.encode(urlFirst, "UTF-8");
		renderRequest.setAttribute("urlFirst", urlFirst);
		renderRequest.setAttribute("videoModels", videoModels);
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 *	Get list videos are choosed. If no choose, get 3 videos lastest
	 */
	public List<BNVideoModel> getListVideoById(ThemeDisplay themeDisplay, Long[] videoIdChoosed) {
		BNVideoModel videoModel = null;
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class).add(
				PropertyFactoryUtil.forName("fileEntryTypeId").eq(
						new Long(CommonConstants.PORTLET.VIDEO_GALLERY.VIDEO_FILE_ENTRY_TYPE_ID)));
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		String urlVideo = StringPool.BLANK;
		List<BNVideoModel> listVideo = new ArrayList<BNVideoModel>();
		Gson gsonObj = new Gson();
		BNVideoMappingModel object = null;
		FileEntry tempFile = null;
		DLFileEntryType fileEntryType = null;
		List<DLFileEntry> dlFileEntry = null;
		/*try {
			//get list video
			if(videoIdChoosed != null){
				dq.add(PropertyFactoryUtil.forName("fileEntryId").in(videoIdChoosed));
				dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
			}else{
				dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq, 0, 3);
			}
			if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
				for (DLFileEntry videoFile : dlFileEntry) {
					videoModel = new BNVideoModel();
					tempFile = DLAppLocalServiceUtil.getFileEntry(videoFile.getFileEntryId());
					urlVideo = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(videoFile.getFileEntryTypeId());
					String json = CommonUtil.getMetadataDocumentMediaFieldByName(videoFile , fileEntryType , CommonConstants.THUMB_IMAGE);
					object = gsonObj.fromJson(json, BNVideoMappingModel.class);
					if(object != null) {
						object.setFolder(CommonConstants.THUMB_IMAGE);
						videoModel.setImageThums("/documents/ddm/" + object.getClassName() + "/"
								+ object.getClassPK() + "/" + object.getFolder());
					}
					//set properties
					videoModel.setTitle(videoFile.getTitle());
					videoModel.setUrl(urlVideo);
					videoModel.setFileId(videoFile.getFileEntryId());
					//add video to list
					listVideo.add(videoModel);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}*/
		
		return listVideo;
	}
	
	/**
	 * convertArray : String to Long
	 */
	private Long[] convertArrayStringToLong(String[] input){
		if(input != null){
			Long[] longArray = new Long[input.length];
			long current = 0;
			int index = 0;
			for(int i = 0; i < input.length; i++){
				try {
					current = Long.parseLong(input[i]);
					longArray[index] = current;
					index++;
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
			return longArray;
		}
		return null;
	}
}