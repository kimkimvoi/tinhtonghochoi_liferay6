package com.fsoft.bn.portlet.delegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.util.CommonUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryModel;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.model.DLFolderModel;
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
	 * get full tree view
	 * @param groupId
	 * @return
	 */
	public String getFoldersTreeView(long groupId) {
		FolderModel rootFolderModel = new FolderModel(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CommonConstants.FOLDER_HOME, CommonConstants.FOLDER_HOME, -1, groupId);
		return rootFolderModel.toTreeView();
	}
	
	/**
	 * Get all folders in database
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<FolderModel> getFolders(long groupId) {
		List<FolderModel> folderModels = new ArrayList<FolderModel>();
		
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFolderModel.class);
			dq.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			List<DLFolderModel> folders = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
			
			// add Home folder
			FolderModel rootFolderModel = new FolderModel(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CommonConstants.FOLDER_HOME, CommonConstants.FOLDER_HOME, -1, groupId);
			folderModels.add(rootFolderModel);
			
			// add child folder
			FolderModel folderModel;
			for (DLFolderModel dlFolderModel : folders) {
				folderModel = new FolderModel();
				folderModels.add(CommonUtil.convertObject(dlFolderModel, folderModel));
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return resortFolders(folderModels);
	}
	
	/**
	 * resort folders by level
	 * @param orgFolders
	 * @return
	 * @throws Exception 
	 */
	private List<FolderModel> resortFolders(List<FolderModel> orgFolders) {
		List<FolderModel> targetFolders = new ArrayList<FolderModel>();
		
		// add Home Folder first
		targetFolders.add(orgFolders.get(0));
		orgFolders.remove(0);
		
		if (orgFolders.size() == 0) {
			return targetFolders;
		}
		
		FolderModel tmpFolder;
		FolderModel tmpOrgFolder;
		int beforeSize, afterSize;
		while (orgFolders.size() > 0) {
			beforeSize = orgFolders.size();
			for (int i = targetFolders.size() - 1; i >= 0; i--) {
				tmpFolder = targetFolders.get(i);
				for (int j = orgFolders.size() - 1; j >= 0; j--) {
					tmpOrgFolder = orgFolders.get(j);
					if (tmpOrgFolder.getParentFolderId() == tmpFolder.getFolderId()) {
						tmpOrgFolder.setLevel(tmpFolder.getLevel() + 1);
						targetFolders.add(i + 1, tmpOrgFolder);
						orgFolders.remove(j);
					}
				}
			}
			
			afterSize = orgFolders.size();
			if (beforeSize == afterSize) {
				System.out.println("Wrong data. Cannot find sub folders");
				return targetFolders;
			}
		}
		
		return targetFolders;
	}
	
	/**
	 * Get all folders with thumbnail
	 * @param themeDisplay
	 * @return
	 */
	public List<FolderModel> getHomeFolderWithThumb(ThemeDisplay themeDisplay) {
		// get infor for Home folder
		List<FolderModel> folderModels = new ArrayList<FolderModel>();
		folderModels.add(new FolderModel(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CommonConstants.FOLDER_HOME, CommonConstants.FOLDER_HOME, -1, getThumbForFolder(0, themeDisplay)));
		
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
	 * Get all subFolders with thumbnail
	 * @param themeDisplay
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public List<FolderModel> getSubFoldersWithThumb(long parentFolderId, long groupId, ThemeDisplay themeDisplay) {
		List<FolderModel> folderModels = new ArrayList<FolderModel>();
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFolderModel.class);
			dq.add(PropertyFactoryUtil.forName("parentFolderId").eq(parentFolderId));
			dq.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			List<DLFolderModel> folders = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
			long folderId;
			for (DLFolderModel dlFolderModel : folders) {
				folderId = dlFolderModel.getFolderId();
				FolderModel model = new FolderModel(
						folderId, 
						dlFolderModel.getName(),
						dlFolderModel.getDescription(),
						dlFolderModel.getParentFolderId(),
						DLFolderLocalServiceUtil.getFoldersCount(groupId, folderId),
						countFileInSubFolderByMimeType(folderId, "image"),
						getThumbForFolder(folderId, themeDisplay));
				folderModels.add(model);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return folderModels;
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
			List<DLFileEntryModel> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq, 0 , 10); // TODO: paging here
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
	 * get infor for folder's breadcumbs
	 * @param folderId
	 * @return
	 */
	public Map<Long, String> getBreadcumbs(long folderId, long groupId) {
		Map<Long, String> map = new LinkedHashMap<Long, String>();
		if (folderId <= 0) {
			map.put(0L, CommonConstants.FOLDER_HOME);
			return map;
		}
		
		// get parentFolderId of this folder
		FolderModel folder;
		boolean isHome = false;
		long tempId = folderId;
		List<FolderModel> folders = new ArrayList<FolderModel>();
		while(!isHome) {
			folder = getFolder(tempId, groupId);
			if (folder != null) {
				folders.add(folder);
				tempId = folder.getParentFolderId();
				
				if (folder.getParentFolderId() <= 0) {
					folders.add(new FolderModel(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CommonConstants.FOLDER_HOME));
					isHome = true;
				}
			} else {
				folders.add(new FolderModel(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, CommonConstants.FOLDER_HOME));
				isHome = true;
			}
		}
		
		// re-order
		for (int i = folders.size() - 1; i >= 0; i--) {
			folder = folders.get(i);
			map.put(folder.getFolderId(), folder.getName());
		}
		
		return map;
	}
	
	/**
	 * get folder by folderId
	 * @param folderId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FolderModel getFolder(long folderId, long groupId) {
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFolderModel.class);
			dq.add(PropertyFactoryUtil.forName("folderId").eq(folderId));
			List<DLFolderModel> folders = DLFileEntryLocalServiceUtil.dynamicQuery(dq);
			if (folders != null && folders.size() == 1) {
				DLFolderModel dlFolderModel = folders.get(0);
				return new FolderModel(
						dlFolderModel.getFolderId(), 
						dlFolderModel.getName(),
						dlFolderModel.getDescription(),
						dlFolderModel.getParentFolderId(),
						groupId); 
			} else {
				System.out.println("Can't find folder with id " + folderId);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}
}
