package com.fsoft.bn.portlet.booklibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;

import com.fsoft.bn.constant.CommonConstants;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMContent;
import com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BookLibraryPortlet
 */
public class BookLibraryPortlet extends MVCPortlet {
	
	Logger logger = Logger.getLogger(BookLibraryPortlet.class);
	
	private final long KINH_SACH_FOLDER_ID = 43423;
	//private final long KICH_SACH_STRUCTURE_ID = 186903;
	private final long KICH_SACH_STRUCTURE_ID = 194246;
	
	Gson gson = new Gson();

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<DLFolder> folderList = null;
		List<DLFileEntry> fileList = new ArrayList<DLFileEntry>();
		List<BookModel> bookList = new ArrayList<BookModel>();
		List<String> authorList = new ArrayList<String>();
		List<String> categoryList = new ArrayList<String>();
		try {
			folderList = DLFolderLocalServiceUtil.getFolders(
					CommonConstants.STRUCTURE.GROUP_ID, KINH_SACH_FOLDER_ID);
			for (DLFolder dlFolder : folderList) {
				List<DLFileEntry> tmpFileList = null;
				tmpFileList = DLFileEntryLocalServiceUtil.getFileEntries(
						themeDisplay.getScopeGroupId(), dlFolder.getFolderId(), -1, -1, null);
				fileList.addAll(tmpFileList);
			}
		} catch (SystemException e) {
			logger.error(e);
		}
		
		for (DLFileEntry file : fileList) {
			
			DLFileVersion fileVersion;
			DDMContent content = null;
			try {
				fileVersion = file.getFileVersion();
				
				DLFileEntryMetadata metadata = DLFileEntryMetadataLocalServiceUtil
						.getFileEntryMetadata(KICH_SACH_STRUCTURE_ID, 
								fileVersion.getFileVersionId());
				if (metadata == null) {
					continue;
				}
				BookModel book = new BookModel();
				book.setId(String.valueOf(file.getFileEntryId()));
				book.setTitle(file.getTitle());
				
				try {
					String tmpCategory = DLFolderLocalServiceUtil
							.getFolder(file.getFolderId()).getName();
					if (categoryList.isEmpty()) {
						categoryList.add(tmpCategory);
					} else {
						boolean isExist = false;
						for (String category : categoryList) {
							if (category.equals(tmpCategory)) {
								isExist = true;
								break;
							}
						}
						if (!isExist) {
							categoryList.add(tmpCategory);
						}
					}
					book.setCategory(tmpCategory);
				} catch (PortalException e1) {
					logger.error(e1);
				} catch (SystemException e2) {
					logger.error(e2);
				}
				
				content = DDMContentLocalServiceUtil.getContent(metadata.getDDMStorageId());
				Document document = SAXReaderUtil.read(content.getXml());
				Element rootElement = document.getRootElement();
				for (Element e : rootElement.elements()) {
					if (e.getName().equals("dynamic-element")) {
						String key = e.attributeValue("name");
						String value = e.element("dynamic-content").getTextTrim();
						
						if (key.equals("bookAuthor")) {
							if (authorList.isEmpty()) {
								authorList.add(value);
							} else {
								boolean isExist = false;
								for (String author : authorList) {
									if (author.equals(value)) {
										isExist = true;
										break;
									}
								}
								if (!isExist) {
									authorList.add(value);
								}
							}
							book.setAuthor(value);
						}
						
						if (key.equals("bookCover")) {
							JSONObject jsonObject = JSONFactoryUtil.createJSONObject(value);
							String coverUrl = themeDisplay.getPortalURL() 
									+ themeDisplay.getPathContext() 
									+ "/documents/ddm/" + jsonObject.getString("className")
									+ "/" + jsonObject.getString("classPK") + "/"
									+ key;
							book.setCoverUrl(coverUrl);
						}
					}
				}
				book.setBookUrl(createDocumentLink(file, themeDisplay));
				bookList.add(book);
			} catch (PortalException e1) {
				logger.error(e1);
			} catch (SystemException e1) {
				logger.error(e1);
			} catch (DocumentException e1) {
				logger.error(e1);
			}
		}
		renderRequest.setAttribute("bookList", gson.toJson(bookList));
		renderRequest.setAttribute("bookAuthorList", gson.toJson(authorList));
		renderRequest.setAttribute("bookCategoryList", gson.toJson(categoryList));
		super.doView(renderRequest, renderResponse);
	}
 
	private String createDocumentLink(DLFileEntry fileEntry, ThemeDisplay themeDisplay) {
		
		long folderId = fileEntry.getFolderId();
		String filename = fileEntry.getName();
		AssetEntry entry = null;;
		try {
			entry = AssetEntryLocalServiceUtil
					.getEntry(DLFileEntry.class.getName(), fileEntry.getFileEntryId());
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
}
