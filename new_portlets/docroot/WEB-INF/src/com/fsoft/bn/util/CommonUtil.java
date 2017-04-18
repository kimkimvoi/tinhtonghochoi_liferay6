package com.fsoft.bn.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;
import org.w3c.dom.NodeList;

import com.fsoft.bn.constant.CommonConstants;
import com.fsoft.bn.domain.AttachFileModel;
import com.fsoft.bn.domain.DataDictionary;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata;
import com.liferay.portlet.documentlibrary.model.DLFileEntryType;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryMetadataLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;

public class CommonUtil {
	/** logger */
	private static Logger logger = Logger.getLogger(CommonUtil.class);
	/**
	 * 
	 * @param l
	 * @return
	 * @author son
	 */
	public static int convertLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}

	/**
	 * 
	 * @param request
	 * @param headerKeys
	 * @return
	 * @author son
	 */
	public static List<String> getHeaderList(PortletRequest request, String[] headerKeys) {
		List<String> headerList = new ArrayList<String>();
		String headerStr = "";

		for (String key : headerKeys) {
			headerStr = getText(request, key);
			headerList.add(headerStr);
		}
		return headerList;
	}

	/**
	 * 
	 * @param request
	 * @param key
	 * @return
	 * @author son
	 */
	public static String getText(Object requestObj, String key) {
		ThemeDisplay themeDisplay = null;

		if (requestObj instanceof HttpServletRequest) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) requestObj;
			themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		} else if (requestObj instanceof PortletRequest) {
			PortletRequest portletRequest = (PortletRequest) requestObj;
			themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		}

		if (themeDisplay != null) {
			Locale locale = themeDisplay.getLocale();
			return LanguageUtil.get(locale, key);
		}

		return StringPool.BLANK;
	}

	/**
	 * This method using get captcha value from session
	 * 
	 * @param session
	 * @return String
	 * @author VangND1
	 */
	public static String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}

		return null;
	}

	/**
	 * This method using validate captcha
	 * 
	 * @param request
	 * @return boolean
	 * @author VangND1
	 */
	public static boolean isValidCaptcha(UploadPortletRequest uploadRequest, PortletRequest request) {
		String enteredCaptchaText = ParamUtil.getString(uploadRequest, "captchaText");
		PortletSession session = request.getPortletSession();
		String captchaText = getCaptchaValueFromSession(session);
		if (captchaText != null && captchaText.length() > 0) {
			if (captchaText.equals(enteredCaptchaText)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * common method using get structure by id
	 * 
	 * @param groupId
	 * @param structureId
	 * @param start
	 * @param end
	 * @return {@link List<JournalArticle>}
	 */
	public static List<JournalArticle> getListStructure(long groupId, String structureId, int start, int end) {
		// create sort param
		OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", "modifiedDate", false);
		List<JournalArticle> listStructure;
		List<JournalArticle> result = new ArrayList<JournalArticle>();
		try {
			// get all structure
			listStructure = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, start, end, obc);
			// filter latest version
			result = getLastVersionList(listStructure);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static List<JournalArticle> getListStructureByContentFieldValue(long groupId, String structureId, int start, int end,
			String field, String fieldValue) {
		// create sort param
		List<JournalArticle> listStructure;
		List<JournalArticle> result = new ArrayList<JournalArticle>();
		try {
			// get all structure
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(JournalArticle.class)
					.add(PropertyFactoryUtil.forName("structureId").eq(structureId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("content").like("%<dynamic-content><![CDATA[" + fieldValue + "]]></dynamic-content>%"));
			listStructure = JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
			result = getLastVersionListWithType(listStructure, field, fieldValue);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static int getCountStructureContentFieldValue(long groupId, String structureId, String field, String fieldValue) {
		// create sort param
		List<JournalArticle> listStructure;
		List<JournalArticle> result = new ArrayList<JournalArticle>();
		try {
			// get all structure
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
					.forClass(JournalArticle.class)
					.add(PropertyFactoryUtil.forName("structureId").eq(structureId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("content").like("%<dynamic-content><![CDATA[" + fieldValue + "]]></dynamic-content>%"));
			listStructure = JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
			result = getLastVersionListWithType(listStructure, field, fieldValue);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result.size();
	}

	/**
	 * x
	 * 
	 * @param articlesFull
	 * @return
	 */
	private static List<JournalArticle> getLastVersionList(List<JournalArticle> articlesFull) {
		List<JournalArticle> listLastVersionList = new ArrayList<JournalArticle>();
		JournalArticle lastVersOfRecord = null;
		for (JournalArticle article : articlesFull) {
			try {
				// get latest version of article
				lastVersOfRecord = JournalArticleLocalServiceUtil.getLatestArticle(article.getGroupId(), article.getArticleId());
			} catch (Exception e) {
				PortalUtil.logger.error("Can not get last version article: " + e.getMessage());
				lastVersOfRecord = article;
			}
			if (!listLastVersionList.contains(lastVersOfRecord)) {
				listLastVersionList.add(lastVersOfRecord);
			}
		}
		return listLastVersionList;
	}

	/**
	 * 
	 * @param articlesFull
	 * @return
	 */
	private static List<JournalArticle> getLastVersionListWithType(List<JournalArticle> articlesFull, String type, String typeValue) {
		List<JournalArticle> listLastVersionList = new ArrayList<JournalArticle>();
		JournalArticle lastVersOfRecord = null;
		for (JournalArticle article : articlesFull) {
			try {
				// get latest version of article
				lastVersOfRecord = JournalArticleLocalServiceUtil.getLatestArticle(article.getGroupId(), article.getArticleId());
				if (!getXsdContentArticle(lastVersOfRecord.getContent(), type).equals(typeValue)) {
					continue;
				}
			} catch (Exception e) {
				PortalUtil.logger.error("Can not get last version article: " + e.getMessage());
				lastVersOfRecord = article;
			}
			if (!listLastVersionList.contains(lastVersOfRecord)) {
				listLastVersionList.add(lastVersOfRecord);
			}
		}
		return listLastVersionList;
	}

	/**
	 * This function get content of a tag on Content article (this data on structure)
	 * 
	 * @author DucNH1
	 * @param articleContent
	 * @param itemName
	 * @return String
	 */
	public static String getXsdContentArticle(String articleContent, String itemName) {
		Document document = null;
		String result = StringPool.BLANK;
		try {
			if (null != articleContent && articleContent.length() > CommonConstants.NUM_0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				Node node = document.selectSingleNode("/root/dynamic-element[@name='" + itemName + "']/dynamic-content");
				if (node.getText().length() > 0) {
					result = node.getText();
				}
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	/**
	 * get count JournalArticle
	 * 
	 * @param groupId
	 * @param structureId
	 * @return {@link Integer}
	 * @author VangND1
	 */
	public static int getCountStructure(long groupId, String structureId) {
		int count = CommonConstants.NUM_0;
		try {
			count = JournalArticleLocalServiceUtil.getStructureArticlesCount(groupId, structureId);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		return count;
	}

	/**
	 * @param id
	 * @return {@link JournalArticle}
	 * @author VangND1
	 */
	public static JournalArticle getStructureById(long id) {
		JournalArticle journalArticle = null;
		try {
			journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(CommonConstants.STRUCTURE.GROUP_ID, String.valueOf(id));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return journalArticle;
	}

	/**
	 * @author DucNH1
	 * @param articleTitle
	 * @return This function get content of field title on xsd file title of article
	 */
	public static String getXsdTitleArticle(String articleTitle) {
		Document document = null;
		String result = "";
		try {
			if (null != articleTitle && articleTitle.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleTitle));
				Node node = document.selectSingleNode("/root/Title");
				if (node.getText().length() > 0) {
					result = node.getText();
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return result;
	}

	/**
	 * @author QuangTN3
	 * @param date
	 * @return date convert to String example yyyy/MM/dd -> 2013/12/12
	 */
	public static String Date2String(Date date, String formatDate) {
		try {
			if (date != null) {
				DateFormat dtf = new SimpleDateFormat(formatDate);
				return dtf.format(date);
			} else {
				return StringPool.BLANK;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			return StringPool.BLANK;
		}
	}

	/**
	 * @author QuangTN3
	 * @param money
	 * @param formatMoney
	 * @return money with format exmaple : money 2346234 and format :###,###,### -> result : 2,236,234
	 */
	public static String formatMoney(Object money, String formatMoney) {
		DecimalFormat df = new DecimalFormat(formatMoney);
		// DecimalFormat df = new DecimalFormat("$###,###,###");
		BigDecimal moneyTemp = new BigDecimal(CommonConstants.NUM_0);
		if (!Validator.isBlankOrNull(money)) {
			if (money instanceof String) {
				moneyTemp = new BigDecimal(money.toString());
			}
		}
		return df.format(moneyTemp);
	}

	/**
	 * get page number from total item count and item count per page
	 * 
	 * @param count
	 *            total record
	 * @param recordPerPage
	 *            record per page
	 * @author QuangTN3, ThangBN1, SonNT18
	 */
	public static long getNumberOfPage(long totalItemCount, int itemPerPage) {
		return getNumberOfPage(convertLongToInt(totalItemCount), itemPerPage);
	}

	/**
	 * get page number from total item count and item count per page
	 * 
	 * @param count
	 *            total record
	 * @param recordPerPage
	 *            record per page
	 * @author VangND1, ThangBN1
	 */
	public static int getNumberOfPage(int totalItemCount, int itemPerPage) {
		if (totalItemCount < 0 && itemPerPage < 0)
			throw new RuntimeException("Invalid parameter: total item count or record per page number can not be negative");

		return (int) Math.ceil((float) totalItemCount / (float) itemPerPage);
	}

	/**
	 * 
	 * @param itemName
	 * @param structureId
	 * @return
	 */
	public static List<DataDictionary> getSelectionListFromXSDContent(String itemName, String structureId) {
		List<DataDictionary> listDataDictionary = new ArrayList<DataDictionary>();
		try {
			JournalStructure journalStructure = JournalStructureLocalServiceUtil.getStructure(CommonConstants.STRUCTURE.LINK_PAGE_GROUP_ID,
					structureId);
			String xsd = journalStructure.getXsd();
			DataDictionary dictionary = null;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(new ByteArrayInputStream(xsd.getBytes("UTF-8")));

			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xPath.evaluate("//root/dynamic-element[@name='" + itemName + "']/dynamic-element", doc,
					XPathConstants.NODESET);
			org.w3c.dom.Node node;
			for (int i = 0; i < nodes.getLength(); i++) {
				node = nodes.item(i);
				dictionary = new DataDictionary();
				dictionary.setKey(Long.parseLong(node.getAttributes().getNamedItem("type").getNodeValue()));
				dictionary.setValue(node.getAttributes().getNamedItem("name").getNodeValue());
				listDataDictionary.add(dictionary);
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return listDataDictionary;
	}

	/**
	 * @author YenMC
	 * @param request
	 * @param portletName
	 * @param groupId
	 * @param structureId
	 * @param articleId
	 * @param vers
	 * @return String portletURLString
	 */
	public static String getPortletURL(PortletRequest request, String friendlyURL, String portletName, String groupId, String structureId,
			String articleId, String vers) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portletName, PortalUtil.getLayoutIdViewDetail(request, friendlyURL),
				PortletRequest.RENDER_PHASE);

		try {
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("groupId", groupId);
			portletURL.setParameter("structureId", structureId);
			portletURL.setParameter("articleId", articleId);
			portletURL.setParameter("version", vers);
		} catch (WindowStateException e) {
			logger.info(e.getMessage());
		} catch (PortletModeException e) {
			logger.info(e.getMessage());
		}

		return portletURL.toString();
	}

	/**
	 * This method using get meta data on document and media
	 * 
	 * @param fileEntry
	 * @param fileEntryType
	 * @param fieldName
	 * @return String
	 * @author VangND1
	 */
	public static String getMetadataDocumentMediaFieldByName(DLFileEntry fileEntry, DLFileEntryType fileEntryType, String fieldName) {
		String result = StringPool.BLANK;
		try {
			List<DDMStructure> ddmStructures = fileEntryType.getDDMStructures();
			Fields fields = null;
			Field f = null;
			FileEntry tempFile = DLAppLocalServiceUtil.getFileEntry(fileEntry.getFileEntryId());
			for (DDMStructure ddmStructure : ddmStructures) {
				DLFileEntryMetadata fileEntryMetadata = DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(
						ddmStructure.getStructureId(), tempFile.getFileVersion().getFileVersionId());
				fields = StorageEngineUtil.getFields(fileEntryMetadata.getDDMStorageId());
				Iterator<Field> listField = fields.iterator();
				while (listField.hasNext()) {
					f = listField.next();
					if (fieldName.equals(f.getName())) {
						result = String.valueOf(f.getValue());
						break;
					}
				}
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	private static Map<String, Object> introspect(Object obj) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		BeanInfo info = Introspector.getBeanInfo(obj.getClass());
		String name = "";
		for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
			Method reader = pd.getReadMethod();
			if (reader != null) {
				name = pd.getName();
				if (name.startsWith("_")) {
					name = name.substring(1);
				}
				result.put(name, reader.invoke(obj));
			}
		}
		return result;
	}

	public static <K, T> T convertObject(K input, T output) {
		Map<String, Object> map;
		try {
			map = introspect(input);
			BeanUtils.populate(output, map);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return output;
	}

	/**
	 * 
	 * @param attachFileIds
	 * @param documentId
	 * @param themeDisplay
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@SuppressWarnings("unchecked")
	public static List<AttachFileModel> getAttachFiles(Long[] attachFileIds, String documentId, ThemeDisplay themeDisplay)
			throws SystemException, PortalException {
		String urlDocument = StringPool.BLANK;
		List<AttachFileModel> listAttachFileModel = new ArrayList<AttachFileModel>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLFileEntry.class).add(
				PropertyFactoryUtil.forName("fileEntryId").in(attachFileIds));
		List<DLFileEntry> dlFileEntryList = DLFileEntryLocalServiceUtil.dynamicQuery(dynamicQuery);
		FileEntry tempFile = null;

		if (!Validator.isBlankOrNull(dlFileEntryList)) {
			for (DLFileEntry dLFileEntry : dlFileEntryList) {
				tempFile = DLAppLocalServiceUtil.getFileEntry(dLFileEntry.getFileEntryId());
				urlDocument = DLUtil.getPreviewURL(tempFile, tempFile.getFileVersion(), themeDisplay, StringPool.BLANK);
				listAttachFileModel.add(new AttachFileModel(dLFileEntry.getFileEntryId(), dLFileEntry.getTitle(), dLFileEntry
						.getDescription(), urlDocument, documentId));
			}
		}
		return listAttachFileModel;
	}
	/**
	 * @author QuangTN3
	 * @param fullText
	 * @param keyWord
	 * @return
	 */
	public static boolean searchWithSubText(String fullText, String keyWord){
		
		if (StringUtil.isEmpty(keyWord)) {
			return true;
		} 
		
		if (!StringUtil.isEmpty(keyWord) && StringUtil.isEmpty(fullText)) {
			return false;
		}
		
		if (!StringUtil.isEmpty(keyWord) && !StringUtil.isEmpty(fullText)) {
			String[] keyPublicNewsArray = keyWord.split(StringPool.SPACE);
			for(int i = 0; i < keyPublicNewsArray.length; i++){
				String subKey = keyPublicNewsArray[i];
				if(fullText.toLowerCase().contains(subKey.toLowerCase())){
					return true;
				}
			}
		}
		
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static List getPage(List records, int pageNum, int recordPerPage) {
		int size = records.size();
		int i = pageNum * recordPerPage;
		if (i > size) {
			i = size;
		}
		return records.subList((pageNum - 1) * recordPerPage, i);
	}
	
	@SuppressWarnings("unchecked")
	public static PollsQuestion getPollsQuestion(String voteQuestion) {
		// create sort param
		List<PollsQuestion> listQuestion;
		PollsQuestion result = null;
		try {
			// get all structure
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
					PollsQuestion.class).add(
					PropertyFactoryUtil.forName("title").like(
							"%>" + voteQuestion + "<%"));
			listQuestion = PollsQuestionLocalServiceUtil.dynamicQuery(
					dynamicQuery, -1, -1);
			if (CollectionUtils.isNotEmpty(listQuestion)) {
				result = listQuestion.get(0);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}
	/**
	 * 
	 * @param min
	 * @param max
	 * @return number between max and min
	 */
	public static int randomNumberInRange(int min, int max) {

	    // Usually this should be a field rather than a method variable so
	    // that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
