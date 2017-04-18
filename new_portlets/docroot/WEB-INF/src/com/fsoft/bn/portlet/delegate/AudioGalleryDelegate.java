package com.fsoft.bn.portlet.delegate;

import java.io.Serializable;
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
import com.fsoft.bn.domain.AudioModel;
import com.fsoft.bn.domain.BNVideoMappingModel;
import com.fsoft.bn.domain.BNVideoModel;
import com.fsoft.bn.domain.FileModel;
import com.fsoft.bn.domain.FolderModel;
import com.fsoft.bn.domain.PictureModel;
import com.fsoft.bn.domain.audio.Audio;
import com.fsoft.bn.domain.audio.AudioPage;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
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
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryModel;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.model.DLFolderModel;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.taglib.aui.AUIUtil;
/**
 * Logic class for video gallery
 * @author VangND1
 *
 */
public class AudioGalleryDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(AudioGalleryDelegate.class);
	/**
	 * 
	 * @param folderId 
	 * @param themeDisplay 
	 * @param start 
	 * @param end 
	 * @return {@link List<BNVideoModel>}
	 */
	public AudioPage getListAudio(PortletRequest req , ThemeDisplay themeDisplay,int numberPerPage , int pageNum, int start, int end) {
		//create audio model
		AudioPage audioPage = null; 
		List<Audio> items = null;
		if (pageNum < 1) {
			pageNum = 1;
		}
		try {
			//Create Dynamic Query
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(DLFileEntry.class);
			dq.add(PropertyFactoryUtil.forName(CommonConstants.FILE_ENTRY_TYPE_ID).eq(new Long(CommonConstants.DOCUMENTMEDIA.AUDIO_FILE_ENTRY_TYPE_ID)));
			dq.addOrder(OrderFactoryUtil.desc(CommonConstants.CREATE_DATE));
			//create a dynamic query to count list audio
			DynamicQuery dqCount = DynamicQueryFactoryUtil.forClass(DLFileEntry.class);
			dqCount.add(PropertyFactoryUtil.forName(CommonConstants.FILE_ENTRY_TYPE_ID).eq(new Long(CommonConstants.DOCUMENTMEDIA.AUDIO_FILE_ENTRY_TYPE_ID)));
			dqCount.addOrder(OrderFactoryUtil.desc(CommonConstants.CREATE_DATE));
			String imageURL = StringPool.BLANK;
			//Get Advertisement Files
			List<DLFileEntry> dlFileEntry = DLFileEntryLocalServiceUtil.dynamicQuery(dq, start, end);
			//get count audio
			long audioCount = DLFileEntryLocalServiceUtil.dynamicQueryCount(dqCount);
			//prepare number of page
			long numberOfPage = CommonUtil.getNumberOfPage(audioCount, numberPerPage);
			if(numberOfPage < 1) {
				numberOfPage = 1;
			}
			if (dlFileEntry != null && dlFileEntry.size() > CommonConstants.NUM_0) {
				DLFileEntryType fileEntryType = null;
				items = new ArrayList<Audio>();
				for (DLFileEntry file : dlFileEntry) {
					//prepare audio model
					FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(file.getFileEntryId());
					imageURL = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
					fileEntryType = DLFileEntryTypeLocalServiceUtil.getDLFileEntryType(file.getFileEntryTypeId());
					String author = CommonUtil.getMetadataDocumentMediaFieldByName(file, fileEntryType , "txtAuthor");
					String category = CommonUtil.getMetadataDocumentMediaFieldByName(file, fileEntryType , "selectCategory");
					//push to audio list
					items.add(new Audio(String.valueOf(file.getFileEntryId()), author, file.getTitle(), imageURL, category));
				}
				audioPage = new AudioPage(req, CommonUtil.convertLongToInt(numberOfPage), pageNum, numberPerPage , items);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		//return result
		return audioPage;
	}
	/**
	 * 
	 * @param folderId 
	 * @return int
	 */
	public int getCountVideoForFolder() {
		int count = CommonConstants.NUM_0;
		return count;
	}
}

