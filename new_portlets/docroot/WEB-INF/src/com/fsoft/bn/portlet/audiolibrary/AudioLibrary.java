package com.fsoft.bn.portlet.audiolibrary;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.util.DateUtils;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMContent;
import com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AudioLibrary
 */
public class AudioLibrary extends MVCPortlet {

	public final static long PHAP_AM_FOLDER_ID = 26606;
	public final static long PHAP_AM_STRUCTURE_ID = 26605;
	public List<KeyValuePair> categoryList;
	public List<String> authorList;
	public static Map<Long, String> categoryMap = new HashMap<Long, String>();
	public static ThemeDisplay themeDisplay;
	Gson gson = new Gson();

	static Logger logger = Logger.getLogger(AudioLibrary.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AudioLibraryConfigModel config = new AudioLibraryConfigModel(renderRequest);
		List<News> audioList = getAudioList(renderRequest);
		renderRequest.setAttribute("config", config);
		renderRequest.setAttribute("audioList", gson.toJson(audioList));
		renderRequest.setAttribute("audioAuthorList", gson.toJson(authorList));
		renderRequest.setAttribute("audioCategoryList", gson.toJson(categoryList));
		renderRequest.setAttribute("categoryMap", gson.toJson(categoryMap));
		super.doView(renderRequest, renderResponse);
	}

	public List<News> getAudioList(PortletRequest renderRequest) {
		List<News> audioList = new ArrayList<News>();
		List<DLFolder> folderList = new ArrayList<DLFolder>();
		List<DLFileEntry> fileList = new ArrayList<DLFileEntry>();
		AudioLibraryConfigModel config = new AudioLibraryConfigModel(renderRequest);

		try {
			List<DLFileEntry> tmpFileList = null;
			if (config.getSelectedCategoryList().isEmpty()) {
				folderList = getAllFolders(themeDisplay.getScopeGroupId(), PHAP_AM_FOLDER_ID);
			} else {
				for (KeyValuePair category : config.getSelectedCategoryList()) {
					folderList.addAll(getAllFolders(themeDisplay.getScopeGroupId(), Long.valueOf(category.getKey())));
					folderList.add(DLFolderLocalServiceUtil.fetchDLFolder(NumberUtils.toLong(category.getKey())));
				}
			}
			for (DLFolder dlFolder : folderList) {
				tmpFileList = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
						dlFolder.getFolderId(), -1, -1, null);
				fileList.addAll(tmpFileList);
			}
		} catch (SystemException e) {
			logger.error(e);
		}

		categoryList = getCategoryList(folderList, renderRequest);
		authorList = getAuthorList(fileList);

		for (DLFileEntry file : fileList) {
			try {
				if (config.getSelectedAuthor() == StringPool.BLANK
						|| getAuthor(file).equals(config.getSelectedAuthor())) {
					DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(PHAP_AM_STRUCTURE_ID,
							file.getFileVersion().getFileVersionId());
					audioList.add(getAudioDetail(renderRequest, file, themeDisplay));
				}
			} catch (PortalException e) {
			} catch (SystemException e) {
			}
		}

		if (config.getSelectedSortByName().equals("title")) {
			Collections.sort(audioList, sortByTitle(config.getSelectedSortByType()));
			// Collections.sort(categoryMap,
			// sortByTitle(config.getSelectedSortByType()));
		} else if (config.getSelectedSortByName().equals("createdDate")) {
			Collections.sort(audioList, sortByCreatedDate(config.getSelectedSortByType()));
		} else if (config.getSelectedSortByName().equals("viewCount")) {
			Collections.sort(audioList, sortByViewCount(config.getSelectedSortByType()));
		}
		return audioList;
	}

	public Comparator<News> sortByTitle(String type) {
		if (type.equals("asc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			};
		} else if (type.equals("desc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return o2.getTitle().compareTo(o1.getTitle());
				}
			};
		} else {
			return null;
		}
	}

	public Comparator<News> sortByCreatedDate(String type) {
		if (type.equals("asc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return DateUtils.string2Date(o1.getCreatedDate(), "dd/MM/yyyy")
							.compareTo(DateUtils.string2Date(o2.getCreatedDate(), "dd/MM/yyyy"));
				}
			};
		} else if (type.equals("desc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return DateUtils.string2Date(o2.getCreatedDate(), "dd/MM/yyyy")
							.compareTo(DateUtils.string2Date(o1.getCreatedDate(), "dd/MM/yyyy"));
				}
			};
		} else {
			return null;
		}
	}

	public Comparator<News> sortByViewCount(String type) {
		if (type.equals("asc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return o1.getViewCount() - o2.getViewCount();
				}
			};
		} else if (type.equals("desc")) {
			return new Comparator<News>() {
				@Override
				public int compare(News o1, News o2) {
					return o2.getViewCount() - o1.getViewCount();
				}
			};
		} else {
			return null;
		}
	}

	public static List<String> getAuthorList(List<DLFileEntry> fileList) {
		List<String> authorList = new ArrayList<String>();
		for (DLFileEntry file : fileList) {
			String author = getAuthor(file);
			if (author == null) {
				continue;
			}
			if (authorList.isEmpty()) {
				authorList.add(author);
			} else {
				boolean isExist = false;
				for (String tmpAuthor : authorList) {
					if (tmpAuthor.equals(author)) {
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					authorList.add(author);
				}
			}
		}
		return authorList;
	}

	public static String getAuthor(DLFileEntry file) {
		DLFileVersion fileVersion;
		DDMContent content = null;

		try {
			fileVersion = file.getFileVersion();
			DLFileEntryMetadata metadata = DLFileEntryMetadataLocalServiceUtil
					.getFileEntryMetadata(PHAP_AM_STRUCTURE_ID, fileVersion.getFileVersionId());
			content = DDMContentLocalServiceUtil.getContent(metadata.getDDMStorageId());
			Document document = SAXReaderUtil.read(content.getXml());
			Element rootElement = document.getRootElement();
			for (Element e : rootElement.elements()) {
				if (e.getName().equals("dynamic-element")) {
					String key = e.attributeValue("name");
					String value = e.element("dynamic-content").getTextTrim();

					if (key.equals("txtAuthor")) {
						if (value.isEmpty() || value == StringPool.BLANK) {
							value = "Không rõ";
						}
						return value;
					}
				}
			}
		} catch (PortalException e1) {

		} catch (SystemException e1) {
			logger.error(e1);
		} catch (DocumentException e1) {
			logger.error(e1);
		}
		return "Không rõ";
	}

	public static List<KeyValuePair> getCategoryList(List<DLFolder> folderList, PortletRequest request) {
		List<KeyValuePair> categoryList = new ArrayList<KeyValuePair>();
		List<DLFolder> notEmptyList = new ArrayList<DLFolder>();
		int count;
		try {
			for (DLFolder dlFolder : folderList) {
				count = DLAppLocalServiceUtil.getFileEntriesCount(themeDisplay.getScopeGroupId(),
						dlFolder.getFolderId());

				if (count > 0) {
					notEmptyList.add(dlFolder);
				}
			}

			Collections.sort(notEmptyList, new Comparator<DLFolder>() {

				@Override
				public int compare(DLFolder o1, DLFolder o2) {
					return o2.getLastPostDate().compareTo(o1.getLastPostDate());
				}
			});
			
			for (DLFolder dlFolder : notEmptyList) {
				categoryList.add(new KeyValuePair(String.valueOf(dlFolder.getFolderId()), dlFolder.getName()));
				// childFolderList =
				// getAllFolders(themeDisplay.getScopeGroupId(),
				// dlFolder.getFolderId());
				// long[] childFolderIds = new long[childFolderList.size()];
				// int i = 0;
				// for (DLFolder childFolder : childFolderList) {
				// childFolderIds[i++] = childFolder.getFolderId();
				// }
				JSONObject category = JSONFactoryUtil.createJSONObject();
				count = DLAppLocalServiceUtil.getFileEntriesCount(themeDisplay.getScopeGroupId(),
						dlFolder.getFolderId());
				category.put("count", count);
				category.put("createDate", DateUtils.date2String(dlFolder.getCreateDate(), "dd/MM/yyyy"));
				category.put("lastPostDate", DateUtils.date2String(dlFolder.getLastPostDate(), "dd/MM/yyyy"));
				category.put("modifiedDate", dlFolder.getModifiedDate());
				String username = "";
				username = UserLocalServiceUtil.getUserById(dlFolder.getUserId()).getFullName();
				category.put("username", username);
				category.put("categoryUrl", NewsUtils.getUrlByCategory(request, dlFolder, "/nghe-phap-am",
						NewsContants.PORTLET_NAME.AUDIO_DETAIL));
				int viewCount = 0;
				List<FileEntry> fileList = DLAppLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(),
						dlFolder.getFolderId());
				for (FileEntry file : fileList) {
					viewCount += file.getReadCount();
				}
				category.put("viewCount", viewCount);
				categoryMap.put(dlFolder.getFolderId(), category.toString());
			}
		} catch (PortalException e) {
			logger.error(e);
		} catch (SystemException e) {
			logger.error(e);
		}
		return categoryList;
	}

	public static News getAudioDetail(PortletRequest renderRequest, DLFileEntry file, ThemeDisplay themeDisplay) {

		News audio = new News();
		audio.setId(String.valueOf(file.getFileEntryId()));
		audio.setTitle(file.getTitle().split(".mp3")[0]);
		audio.setViewCount(file.getReadCount());
		Date date = file.getCreateDate();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = sdf.format(date);
		audio.setCreatedDate(dateStr);
		audio.setNew(NewsUtils.isNewNews(dateStr));
		audio.setCateName(file.getFolder().getName());
		audio.setAuthor(getAuthor(file));
		audio.setSource(createDownloadLink(file, themeDisplay));
		audio.setUrlDetailAudio(NewsUtils.getAudioDetailUrl(renderRequest, file, "/nghe-phap-am",
				NewsContants.PORTLET_NAME.AUDIO_DETAIL, String.valueOf(PHAP_AM_STRUCTURE_ID)));
		audio.setUrlDetail(audio.getUrlDetailAudio() + "/cung-tac-gia");
		// use strucId as categoryId
		audio.setStrucId(String.valueOf(file.getFolderId()));
		return audio;
	}

	public static String createDownloadLink(DLFileEntry fileEntry, ThemeDisplay themeDisplay) {

		long folderId = fileEntry.getFolderId();
		String filename = fileEntry.getName();
		AssetEntry entry = null;
		try {
			entry = AssetEntryLocalServiceUtil.getEntry(DLFileEntry.class.getName(), fileEntry.getFileEntryId());
		} catch (PortalException e) {
			logger.error(e);
		} catch (SystemException e) {
			logger.error(e);
		}

		StringBuilder builder = new StringBuilder();
		builder.append(themeDisplay.getPortalURL());
		builder.append(themeDisplay.getPathContext());
		builder.append("/documents/");
		builder.append(themeDisplay.getScopeGroupId());
		builder.append("/");
		builder.append(folderId);
		builder.append("/");
		builder.append(filename);
		builder.append("/");
		builder.append(entry.getClassUuid());
		builder.append("?version=");
		builder.append(fileEntry.getVersion());

		String result = builder.toString();
		return result;
	}

	public static List<DLFolder> getAllFolders(long groupId, long folderId) {
		List<DLFolder> folderList = new ArrayList<DLFolder>();
		List<DLFolder> unmodifiedFolderList = null;
		try {
			unmodifiedFolderList = DLFolderLocalServiceUtil.getFolders(groupId, folderId);
		} catch (SystemException e) {
			logger.error(e);
		}
		folderList.addAll(unmodifiedFolderList);

		for (DLFolder dlFolder : unmodifiedFolderList) {
			folderList.addAll(getAllFolders(groupId, dlFolder.getFolderId()));
		}
		return folderList;
	}
}
