package com.fsoft.bn.portlet.delegate;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.BNVideoMappingModel;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryModel;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFolderModel;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
/**
 * Logic class for video gallery
 * @author VangND1
 *
 */
public class VideoGalleryDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(VideoGalleryDelegate.class);
	/**
	 * This class using get list video
	 * @param start 
	 * @param end 
	 * @param themeDisplay  
	 * @return {@link List<BNVideoModel>}
	 */
	@SuppressWarnings("unchecked")
	public List<BNVideoModel> getListVideo(int start , int end , ThemeDisplay themeDisplay) {
		BNVideoModel videoModel = null;
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class).add(
				PropertyFactoryUtil.forName(CommonConstants.PORTLET.VIDEO_GALLERY.FILE_ENTRY_TYPE_ID).eq(
						new Long(CommonConstants.PORTLET.VIDEO_GALLERY.VIDEO_FILE_ENTRY_TYPE_ID)));
		dq.addOrder(OrderFactoryUtil.desc(CommonConstants.PORTLET.VIDEO_GALLERY.CREATE_DATE));
		String urlVideo = StringPool.BLANK;
		List<BNVideoModel> listVideo = new ArrayList<BNVideoModel>();
		Gson gsonObj = new Gson();
		BNVideoMappingModel object = null;
		FileEntry tempFile = null;
		DLFileEntryType fileEntryType = null;
		try {
			//get list video
			List<DLFileEntry> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq , start , end);
			
			if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
				for (DLFileEntry videoFile : dlFileEntry) {
					videoModel = new BNVideoModel();
					tempFile = DLAppLocalServiceUtil.getFileEntry(videoFile.getFileEntryId());
					urlVideo = DLUtil
							.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(videoFile.getFileEntryTypeId());
					String json = CommonUtil.getMetadataDocumentMediaFieldByName(videoFile, fileEntryType,
							CommonConstants.THUMB_IMAGE);
					object = gsonObj.fromJson(json, BNVideoMappingModel.class);
					if (object != null) {
						object.setFolder(CommonConstants.THUMB_IMAGE);
						videoModel.setImageThums("/documents/ddm/" + object.getClassName() + "/" + object.getClassPK()
								+ "/" + object.getFolder());
					}
					// set properties
					videoModel.setTitle(videoFile.getTitle());
					videoModel.setUrl(urlVideo);
					videoModel.setFileId(videoFile.getFileEntryId());
					// add video to list
					listVideo.add(videoModel);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return listVideo;
	}
	

	
	/**
	 * This method using get total count video
	 * @return {@link Integer}
	 * @author VangND1
	 */
	@SuppressWarnings("unchecked")
	public int getCountVideo() {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class).add(
				PropertyFactoryUtil.forName(CommonConstants.PORTLET.VIDEO_GALLERY.FILE_ENTRY_TYPE_ID).eq(
						new Long(CommonConstants.PORTLET.VIDEO_GALLERY.VIDEO_FILE_ENTRY_TYPE_ID)));
		List<DLFileEntry> dlFileEntry = null;
		int count = CommonConstants.NUM_0;
		try {
			dlFileEntry =	DLFileEntryLocalServiceUtil.dynamicQuery(dq);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		count = dlFileEntry == null ? CommonConstants.NUM_0 : dlFileEntry.size();
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<FolderModel> getFolders(long groupId, int start, int end, PortletRequest request,
			ThemeDisplay themeDisplay) {
		List<FolderModel> folderModels = new ArrayList<FolderModel>();
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFolderModel.class);
			dq.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			List<DLFolderModel> folders = DLFileEntryLocalServiceUtil.dynamicQuery(dq , start , end);
			// add child folder
			FolderModel folderModel;
			List<BNVideoModel> bnVideoModel = null;
			PictureModel pictureModel = null;
			for (DLFolderModel dlFolderModel : folders) {
				folderModel = new FolderModel();
				folderModel = CommonUtil.convertObject(dlFolderModel, folderModel);
				folderModel.setUrl(getVideoPortletUrl(request, String.valueOf(folderModel.getFolderId()) , folderModel.getName()));
				bnVideoModel = getVideoForFolder(folderModel.getFolderId(), themeDisplay, CommonConstants.NUM_0,
						CommonConstants.NUM_1);
				if (!Validator.isBlankOrNull(bnVideoModel)) {
					pictureModel = new PictureModel();
					pictureModel.setUrl(bnVideoModel.get(CommonConstants.NUM_0).getImageThums());
					folderModel.setImageThumb(pictureModel);
				}
				folderModels.add(folderModel);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return folderModels;
	}
	/**
	 * get Count folder
	 * @param groupId
	 * @return
	 */
	public int getCountFolder(long groupId) {
		int count = CommonConstants.NUM_0;
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFolderModel.class);
			dq.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			count = (int) DLFileEntryLocalServiceUtil.dynamicQueryCount(dq);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return count;
	}
	
	/**
	 * 
	 * @param folderId 
	 * @param themeDisplay 
	 * @param start 
	 * @param end 
	 * @return {@link List<BNVideoModel>}
	 */
	@SuppressWarnings("unchecked")
	public List<BNVideoModel> getVideoForFolder(long folderId, ThemeDisplay themeDisplay , int start , int end) {
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		dq.add(PropertyFactoryUtil.forName("mimeType").in(CommonConstants.DOCUMENTMEDIA.VIDEO_MIME_TYPE));
		dq.addOrder(OrderFactoryUtil.desc(CommonConstants.PORTLET.VIDEO_GALLERY.CREATE_DATE));
		BNVideoModel videoModel = null;
		String urlVideo = StringPool.BLANK;
		List<BNVideoModel> listVideo = new ArrayList<BNVideoModel>();
		Gson gsonObj = new Gson();
		BNVideoMappingModel object = null;
		FileEntry tempFile = null;
		DLFileEntryType fileEntryType = null;
		try {
			//get list video
			List<DLFileEntry> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq , start , end);
			
			if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
				for (DLFileEntry videoFile : dlFileEntry) {
					videoModel = new BNVideoModel();
					tempFile = DLAppLocalServiceUtil.getFileEntry(videoFile.getFileEntryId());
					urlVideo = DLUtil
							.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(videoFile.getFileEntryTypeId());
					String json = CommonUtil.getMetadataDocumentMediaFieldByName(videoFile, fileEntryType,
							CommonConstants.THUMB_IMAGE);
					object = gsonObj.fromJson(json, BNVideoMappingModel.class);
					if (object != null) {
						object.setFolder(CommonConstants.THUMB_IMAGE);
						videoModel.setImageThums("/documents/ddm/" + object.getClassName() + "/" + object.getClassPK()
								+ "/" + object.getFolder());
					}
					// set properties
					videoModel.setTitle(videoFile.getTitle());
					videoModel.setUrl(urlVideo);
					videoModel.setFileId(videoFile.getFileEntryId());
					videoModel.setViewCount(String.valueOf(videoFile.getReadCount()));
					// add video to list
					listVideo.add(videoModel);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return listVideo;
	}
	/**
	 * 
	 * @param folderId 
	 * @return int
	 */
	public int getCountVideoForFolder(long folderId) {
		int count = CommonConstants.NUM_0;
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		dq.add(PropertyFactoryUtil.forName("mimeType").in(CommonConstants.DOCUMENTMEDIA.VIDEO_MIME_TYPE));
		dq.addOrder(OrderFactoryUtil.desc(CommonConstants.PORTLET.VIDEO_GALLERY.CREATE_DATE));
		try {
			//get list video
			count = (int) DLFileEntryLocalServiceUtil.dynamicQueryCount(dq);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return count;
	}
	/**
	 * 
	 * @param request 
	 * @param folderId 
	 * @param folderName  
	 * @return String
	 * @author VangND1
	 */
	public static String getVideoPortletUrl(PortletRequest request , String folderId , String folderName) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request, CommonConstants.PORTLET.VIDEO_GALLERY.NAME,
				PortalUtil.getLayoutIdViewDetail(request, CommonConstants.PORTLET.VIDEO_GALLERY.URL),
				PortletRequest.RENDER_PHASE);
		try {
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("folderId", folderId);
			portletURL.setParameter("folderName", folderName);
			portletURL.setParameter("viewMode", "listVideo");
			// must replace PERIOD to DASH because friendly URL don't accept PERIOD character
		} catch (WindowStateException e) {
			logger.info(e.getMessage());
		} catch (PortletModeException e) {
			logger.info(e.getMessage());
		}
		
		return portletURL.toString();
	}
}
