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
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryModel;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * @author QuangND5
 * CommonUtil for picture gallery
 */
public class PictureGalleryDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(PictureGalleryDelegate.class);
	/**
	 * Get lastest picture
	 * @param themeDisplay
	 * @return
	 */
	public PictureModel getLastestPicture(ThemeDisplay themeDisplay) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		try {
			@SuppressWarnings("unchecked")
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq, 0, 1);
			DLFileEntry pictureFile;
			String urlPicture = "";
			if (dlFileEntry != null && dlFileEntry.size() == 1) {
				pictureFile = (DLFileEntry) dlFileEntry.get(0);
				FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(pictureFile.getFileEntryId());
				urlPicture = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				
				//set properties
				return new PictureModel(pictureFile.getFileEntryId(), pictureFile.getTitle(), urlPicture);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Get Picture by pictureId
	 * @param pictureId
	 * @return
	 */
	public PictureModel getPictureById(long pictureId, ThemeDisplay themeDisplay) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.add(PropertyFactoryUtil.forName("fileEntryId").eq(pictureId));
		try {
			@SuppressWarnings("unchecked")
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq, 0, 1);
			DLFileEntry pictureFile;
			String urlPicture = "";
			if (dlFileEntry != null && dlFileEntry.size() == 1) {
				pictureFile = (DLFileEntry) dlFileEntry.get(0);
				FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(pictureFile.getFileEntryId());
				urlPicture = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				
				//set properties
				return new PictureModel(pictureFile.getFileEntryId(), pictureFile.getTitle(), urlPicture);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}
	
	/**
	 * Find 'end' number of pictures in database
	 * @param start
	 * @param end
	 * @param themeDisplay
	 * @return
	 */
	public List<PictureModel> getPicturesByMimeType(int start , int end , ThemeDisplay themeDisplay) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class).add(
				PropertyFactoryUtil.forName("mimeType").in(CommonConstants.DOCUMENTMEDIA.PICTURE_MIME_TYPE));
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		List<PictureModel> listPicture = new ArrayList<PictureModel>();
		
		try {
			@SuppressWarnings("unchecked")
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq , start , end);
			PictureModel pictureModel;
			DLFileEntry pictureFile;
			String urlPicture = "";
			if (dlFileEntry != null && dlFileEntry.size() > 0) {
				for (int i = 0; i < dlFileEntry.size(); i++) {
					pictureFile = (DLFileEntry) dlFileEntry.get(i);
					FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(pictureFile.getFileEntryId());
					urlPicture = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					
					//set properties
					pictureModel = new PictureModel(pictureFile.getFileEntryId(), pictureFile.getTitle(), urlPicture);
					
					//add video to list
					listPicture.add(pictureModel);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return listPicture;
	}
	/**
	 * Get all folders in database
	 * @return
	 */
	@Transactional
	public List<FolderModel> getFolders(long groupId , PortletRequest request , ThemeDisplay themeDisplay) {
		List<FolderModel> folderModels = new ArrayList<FolderModel>();
		
		try {
			List<DLFolder> listFolders = DLFolderLocalServiceUtil.getFolders(
					groupId, 48314l, 0, 10, OrderByComparatorFactoryUtil.create(
							"DLFileEntry", "createDate", false));
			// add child folder
			FolderModel folderModel;
			for (DLFolder folder  : listFolders) {
				folderModel = new FolderModel();
				folderModel = CommonUtil.convertObject(folder, folderModel);
				folderModel.setUrl(getPhotoPortletUrl(request,
						String.valueOf(folderModel.getFolderId()),
						folderModel.getName()));
				folderModel.setImageThumb(getThumbForFolder(folderModel.getFolderId(), themeDisplay));
				folderModels.add(folderModel);
				
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return folderModels;
	}	
	//count file like '%image%' in database
	public Long countFileInSubFolderByMimeType(long folderId,String strMimeType ) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class);
		dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		dq.add(PropertyFactoryUtil.forName("mimeType").like("%"+strMimeType+"%"));
		long folderIdCount = DLFileEntryLocalServiceUtil.dynamicQueryCount(dq);
		return folderIdCount;
	}
	/**
	 * Get image thumbnail for folder
	 * @param folderId
	 * @param themeDisplay
	 * @return
	 */
	private PictureModel getThumbForFolder(long folderId, ThemeDisplay themeDisplay) {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		dq.add(PropertyFactoryUtil.forName("mimeType").in(CommonConstants.DOCUMENTMEDIA.PICTURE_MIME_TYPE));
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		
		try {
			@SuppressWarnings("unchecked")
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq , 0, 1);
			PictureModel pictureModel = null;	
			DLFileEntry pictureFile;
			String urlPicture = "";
			if (dlFileEntry != null && dlFileEntry.size() > 0) {
				pictureFile = (DLFileEntry) dlFileEntry.get(0);
				FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(pictureFile.getFileEntryId());
				urlPicture = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				
				//set properties
				pictureModel = new PictureModel(pictureFile.getFileEntryId(), pictureFile.getTitle(), urlPicture);
				return pictureModel;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return new PictureModel(-1, "", "");
	}
	
	/**
	 * Get all pictures in folder
	 * @param folderId
	 * @param themeDisplay
	 * @return
	 */
	public List<PictureModel> getPicturesForFolder(long folderId, ThemeDisplay themeDisplay) {
		List<PictureModel> pictures = new ArrayList<PictureModel>();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntryModel.class);
		dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
		dq.add(PropertyFactoryUtil.forName("mimeType").in(CommonConstants.DOCUMENTMEDIA.PICTURE_MIME_TYPE));
		dq.addOrder(OrderFactoryUtil.desc("createDate"));
		try {
			@SuppressWarnings("unchecked")
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq); // TODO: paging here
			String urlPicture = "";
			DLFileEntry pictureFile;
			if (dlFileEntry != null && dlFileEntry.size() > 0) {
				for (int i = 0; i < dlFileEntry.size(); i++) {
					pictureFile = (DLFileEntry) dlFileEntry.get(i);
					FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(pictureFile.getFileEntryId());
					urlPicture = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					pictures.add(new PictureModel(pictureFile.getFileEntryId(), pictureFile.getTitle(), urlPicture));
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return pictures;
	}
	/**
	 * 
	 * @param request 
	 * @param folderId 
	 * @param folderName  
	 * @return String
	 * @author VangND1
	 */
	public static String getPhotoPortletUrl(PortletRequest request , String folderId , String folderName) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request, CommonConstants.PORTLET.PHOTO_GALLERY.NAME,
				PortalUtil.getLayoutIdViewDetail(request, CommonConstants.PORTLET.PHOTO_GALLERY.URL),
				PortletRequest.RENDER_PHASE);
		try {
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("folderId", folderId);
			portletURL.setParameter("folderName", folderName);
			portletURL.setParameter("viewMode", "viewPhoto");
			// must replace PERIOD to DASH because friendly URL don't accept PERIOD character
		} catch (WindowStateException e) {
			logger.info(e.getMessage());
		} catch (PortletModeException e) {
			logger.info(e.getMessage());
		}
		
		return portletURL.toString();
	}
}
