package com.fsoft.bn.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.util.CommonUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public class FolderModel implements Serializable {
	/**
	 * default serial
	 */
	private static final long serialVersionUID = 1L;
	/** logger */
	private static Logger logger = Logger.getLogger(FolderModel.class);
	private long folderId;
	private String name;
	private String description;
	private long parentFolderId;
	private int level = 0;
	private long groupId;
	private long companyId;
	private long countSubFolder;
	
	private PictureModel imageThumb;
	private List<FolderModel> folders;
	private List<FileModel> files;
	/** url view list item*/
	private String url;
	private long countFileInFolder;
	
	public FolderModel() {}
	
	public FolderModel(long folderId, String name) {
		this.folderId = folderId;
		this.name = name;
	}
	
	public FolderModel(long folderId, String name, String description, long parentFolderId, long groupId) {
		this.folderId = folderId;
		this.name = name;
		this.description = description;
		this.parentFolderId = parentFolderId;
		this.groupId = groupId;
	}
	
	public FolderModel(long folderId, String name, String description, long parentFolderId,PictureModel imageThumb) {
		this.folderId = folderId;
		this.name = name;
		this.description = description;
		this.parentFolderId = parentFolderId;
		this.imageThumb = imageThumb;
	}
	
	//contructor to count subfolder
	public FolderModel(long folderId, String name, String description, long parentFolderId, long countSubFolder,long countFileInFolder,PictureModel imageThumb){
		this.folderId = folderId;
		this.name = name;
		this.description = description;
		this.parentFolderId = parentFolderId;
		this.imageThumb = imageThumb;
		this.countSubFolder = countSubFolder;
		this.countFileInFolder = countFileInFolder;
	}
	
	//contructor to count file 
	public FolderModel(long folderId, String name, String description, long parentFolderId, long countSubFolder,PictureModel imageThumb){
		this.folderId = folderId;
		this.name = name;
		this.description = description;
		this.parentFolderId = parentFolderId;
		this.imageThumb = imageThumb;
		this.countSubFolder = countSubFolder;
	}
	
	@Override
	public String toString() {
		return "folerId:" + folderId + "," 
				+ "name:" + name + ","
				+ "parentFolder:" + parentFolderId + ","
				+ "level:" + level;
	}
	
	public static void main(String[] args) {
		// Home folder
		FolderModel rootFolder = new FolderModel(0, CommonConstants.FOLDER_HOME, CommonConstants.FOLDER_HOME, -1, 10180);
		
		try {
			FolderModel newFolder = new FolderModel();
//			newFolder.setLevel(4);
			CommonUtil.convertObject(rootFolder, newFolder);
			System.out.println(newFolder);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}  
		
//		// init
//		List<FolderModel> subFolders;
//		FolderModel subFolder;
//		List<FileModel> subFiles;
//		
//		// build subFiles
//		subFiles = new ArrayList<FileModel>();
//		subFiles.add(new FileModel(1, "Sub File 1", ""));
//		subFiles.add(new FileModel(2, "Sub File 2", ""));
//		subFiles.add(new FileModel(3, "Sub File 3", ""));
//		
//		// SubFolders of Home
//		subFolders = new ArrayList<FolderModel>();
//		subFolder = new FolderModel(1, "Sub Folder 1", "Sub Folder 1", 0, 10180);subFolder.setFiles(subFiles);subFolders.add(subFolder);
//		subFolder = new FolderModel(2, "Sub Folder 2", "Sub Folder 2", 0, 10180);subFolder.setFiles(subFiles);subFolders.add(subFolder);
//		subFolder = new FolderModel(3, "Sub Folder 3", "Sub Folder 3", 0, 10180);subFolder.setFiles(subFiles);subFolders.add(subFolder);
//		subFolder = new FolderModel(4, "Sub Folder 4", "Sub Folder 4", 0, 10180);subFolder.setFiles(subFiles);subFolders.add(subFolder);
//		rootFolder.setFolders(subFolders);
//		
//		rootFolder.setFiles(subFiles);
//		
//		System.out.println(rootFolder.toTreeView());
	}
	
	public String toTreeView() {
		// open tag
		StringBuffer result = new StringBuffer("<ul class=\"filetree\"><li>");
		
		// folder tag
		result.append("<span class=\"folder\" id='" + folderId + "'>" + name + "</span>");
		
		// add tags for folders
		folders = getSubFolders(folderId, groupId);
		if (folders != null && folders.size() > 0) {
			result.append("<ul>");
			for (FolderModel folder : folders) {
				result.append(folder.toTreeView());
			}
			result.append("</ul>");
		}
		
//		// add tags for files
//		if (files != null && files.size() > 0) {
//			result.append("<ul id=\"folder" + folderId + "\">");
//			for (FileModel file : files) {
//				result.append(file.toTreeView());
//			}
//			result.append("</ul>");
//		}
		
		// closed tag
		result.append("</li></ul>");
		
		return result.toString();
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getParentFolderId() {
		return parentFolderId;
	}

	public void setParentFolderId(long parentFolderId) {
		this.parentFolderId = parentFolderId;
	}

	public PictureModel getImageThumb() {
		return imageThumb;
	}

	public void setImageThumb(PictureModel imageThumb) {
		this.imageThumb = imageThumb;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	private List<FolderModel> getSubFolders(long folderId, long groupId) {
		List<FolderModel> subFolders = new ArrayList<FolderModel>();
		try {
			List<DLFolder> dlFolders = DLFolderLocalServiceUtil.getFolders(groupId,folderId);
			FolderModel folderModel;
			for (DLFolder dlFolder : dlFolders) {
				folderModel = new FolderModel();
				subFolders.add(CommonUtil.convertObject(dlFolder, folderModel));
			}
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		
		return subFolders;
	}
	
	public List<FolderModel> getFolders() {
		return folders;
	}
	
	public void setFolders(List<FolderModel> folders) {
		this.folders = folders;
	}

	public List<FileModel> getFiles() {
		return files;
	}

	public void setFiles(List<FileModel> files) {
		this.files = files;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public long getCountSubFolder() {
		return countSubFolder;
	}

	public void setCountSubFolder(long countSubFolder) {
		this.countSubFolder = countSubFolder;
	}

	public long getCountFileInFolder() {
		return countFileInFolder;
	}

	public void setCountFileInFolder(long countFileInFolder) {
		this.countFileInFolder = countFileInFolder;
	}
	
	
}
