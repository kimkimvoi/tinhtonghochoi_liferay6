package com.fsoft.bn.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.portlet.PortletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fsoft.bn.portlet.news.NewsContants.XSD_ELEMENT_NAME;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureServiceUtil;

/**
 * Utils for liferay structure handling
 * 
 * @author ThangBN1
 * 
 */
public class StructureUtil {

	private static final String XSD_PROPS_AVAILABLE_LOCALES = "available-locales";
	private static final String XSD_PROPS_DEFAULT_LOCALES = "default-locale";
	private static final String XPATH_DYNAMIC_ELEMENT = "./dynamic-element";
	private static final String XPATH_DYNAMIC_CONTENT = "./dynamic-content";
	/** logger */
	private static Logger logger = Logger.getLogger(StructureUtil.class);
	// get Article by id and group
	public static JournalArticle getArticleByIdAndGroup(String id, long groupId) {
		JournalArticle journalArticle = null;
		try {
			journalArticle = JournalArticleServiceUtil.getArticle(groupId, id);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		return journalArticle;
	}

	// get All Article Last version
	public static List<JournalArticle> getAllArticleLastVersion(PortletRequest request, String structureName) {
		List<JournalArticle> allArticles = new ArrayList<JournalArticle>();
		List<JournalArticle> allArticlesLastVersionList = new ArrayList<JournalArticle>();
		try {
			long groupId = PortalUtil.getGroupId(request);

			// get structure id by name or title
			String structureId = StructureUtil.getStructureId(structureName);

			// get all articles by group id and structure id
			if (null != structureId) {
				allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId);
			}
			if (allArticles != null) {
				if (allArticles.size() > 0) {
					// get data last version
					allArticlesLastVersionList = StructureUtil.getLastVersionList(allArticles);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return allArticlesLastVersionList;
	}

	// get All Article Last version by groupId and struture name
	public static List<JournalArticle> getAllArticleLastVersionByGroupId(long groupId, String structureName) {
		List<JournalArticle> allArticles = new ArrayList<JournalArticle>();
		List<JournalArticle> allArticlesLastVersionList = new ArrayList<JournalArticle>();
		try {
			// get structure id by name or title
			String structureId = StructureUtil.getStructureId(structureName);

			// get all articles by group id and structure id
			if (null != structureId) {
				allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId);
			}
			if (allArticles != null) {
				if (allArticles.size() > 0) {
					// get data last version
					allArticlesLastVersionList = StructureUtil.getLastVersionList(allArticles);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return allArticlesLastVersionList;
	}

	// get All Article Last version By Structure Id
	public static List<JournalArticle> getAllArticleLastVersionByStructureId(PortletRequest request, String structureId) {
		List<JournalArticle> allArticles = new ArrayList<JournalArticle>();
		List<JournalArticle> allArticlesLastVersionList = new ArrayList<JournalArticle>();
		try {
			long groupId = PortalUtil.getGroupId(request);

			// get all articles by group id and structure id
			if (null != structureId) {
				allArticles = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId);
			}
			if (allArticles != null) {
				if (allArticles.size() > 0) {
					// get data last version
					allArticlesLastVersionList = StructureUtil.getLastVersionList(allArticles);
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return allArticlesLastVersionList;
	}

	// Get list Article last version from list Article full version
	public static List<JournalArticle> getLastVersionList(List<JournalArticle> articlesFull) {
		List<JournalArticle> publicNewsLastVersionList = new ArrayList<JournalArticle>();
		JournalArticle lastVersOfRecord = null;
		for (JournalArticle article : articlesFull) {
			try {
				// get latest version of article
				lastVersOfRecord = JournalArticleLocalServiceUtil.getLatestArticle(article.getGroupId(), article.getArticleId());
			} catch (Exception e) {
				PortalUtil.logger.error("Can not get last version article: " + e.getMessage());
				lastVersOfRecord = article;
			}
			if (!publicNewsLastVersionList.contains(lastVersOfRecord)) {
				publicNewsLastVersionList.add(lastVersOfRecord);
			}
		}
		return publicNewsLastVersionList;
	}

	/**
	 * function get structure id given name
	 * 
	 * @author ThangBN1
	 */
	// TODO: find a way to enforce user can not change structure name
	public static String getStructureId(String name) {
		JournalStructure structure = StructureUtil.getStructure(name);
		return structure != null ? structure.getStructureId() : null;
	}

	/**
	 * Get data for selection list, global scope
	 * 
	 * @author ThangBN1
	 */
	public static Map<String, String> getStructureXSDSelectionListGlobal(String structureName, String itemName) {
		try {
			String xsd = getStructureXSD(structureName);
			return extractSelectionListFromXSDContent(itemName, xsd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	/**
	 * Get data for selection list
	 * 
	 * @author QuangND5
	 * @param structureName
	 * @param itemName
	 * @return Map<String, String>
	 */
	public static Map<String, String> getStructureXSDSelectionList(PortletRequest request, String structureName, String itemName) {
		try {
			long groupId = PortalUtil.getGroupId(request);
			String structureId = getStructureId(structureName);
			JournalStructure journal = JournalStructureServiceUtil.getStructure(groupId, structureId);
			String xsd = journal.getXsd();
			return extractSelectionListFromXSDContent(itemName, xsd);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Map<String, String> extractJournalXML(String xmlContent, String localeId , Map<String , String> structureOtherProps) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		Map<String, String> result = new LinkedHashMap<String, String>();

		Element rootElement = XMLUtils.getDocLF(xmlContent).getRootElement();
		String defaultLocale = rootElement.attribute(XSD_PROPS_DEFAULT_LOCALES).toString();

		if (!rootElement.attribute(XSD_PROPS_AVAILABLE_LOCALES).toString().contains(localeId) && StringUtils.isNotBlank(localeId)) {
			localeId = defaultLocale;
		}

		String xpathContent = XPATH_DYNAMIC_CONTENT;
		if (StringUtils.isNotBlank(localeId)) {
			xpathContent += "[@language-id='" + localeId + "']";
		}

		List<Node> nodes = rootElement.selectNodes(XPATH_DYNAMIC_ELEMENT);
		for (Node node : nodes) {
			if (!(node instanceof Element))
				continue;
			Element element = (Element) node;
			String propName = StringPool.BLANK;
			try {
				//decode url to utf-8
				propName = URLDecoder.decode(element.attributeValue("name") , "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.info(e.getMessage());
			}
			Node selectNode = element.selectSingleNode(xpathContent);

			if (selectNode == null) {
				if (!defaultLocale.equals(localeId)) {
					selectNode = element.selectSingleNode(XPATH_DYNAMIC_CONTENT + "[@language-id='" + defaultLocale + "']");
				}
				if (selectNode == null) {
					selectNode = element.selectSingleNode(XPATH_DYNAMIC_CONTENT);
				}
			}
			if (map.containsKey(selectNode)) {
				// TODO: need to enhance format of repeatable prop here
				map.put(propName, map.get(propName) + StringPool.COMMA + selectNode.getText());
			} else {
				map.put(propName, selectNode.getText());
			}
		}
		if (!Validator.isBlankOrNull(structureOtherProps)) {
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			Entry<String , String> entry;
			String value = StringPool.BLANK;
			while(iterator.hasNext()) {
				entry = iterator.next();
				value = structureOtherProps.get(entry.getKey());
				if(!Validator.isBlankOrNull(value)) {
					result.put(value, entry.getValue());
				}
				
			}
		} else {
			result = map;
		}
		return result;
	}

	public static List<String> extractXSDPropNames(String xsdContent) {
		List<String> names = new ArrayList<String>();

		Element rootElement = XMLUtils.getDocLF(xsdContent).getRootElement();
		List<Node> nodes = rootElement.selectNodes(XPATH_DYNAMIC_ELEMENT);
		for (Node node : nodes) {
			if (!(node instanceof Element))
				continue;
			Element element = (Element) node;
			names.add(element.attributeValue("name"));
		}

		return names;
	}
	public static Map<String , String> extractXSDPropNamesStructure(String xsdContent) {
		Map<String, String> map = new LinkedHashMap<String, String>();

		Element rootElement = XMLUtils.getDocLF(xsdContent).getRootElement();
		List<Node> nodes = rootElement.selectNodes("./dynamic-element/meta-data/*");
		String parentNodeName = StringPool.BLANK;
		for (Node node : nodes) {
			if (!(node instanceof Element))
				continue;
			Element element = (Element) node;
			if("label".equalsIgnoreCase(element.attributeValue("name"))) {
				parentNodeName = element.getParent().getParent().attributeValue("name");
				if (!Validator.isBlankOrNull(parentNodeName)
						&& !parentNodeName.equalsIgnoreCase(XSD_ELEMENT_NAME.CONTENT)
						&& !parentNodeName.equalsIgnoreCase(XSD_ELEMENT_NAME.SOURCE)
						&& !parentNodeName.equalsIgnoreCase(XSD_ELEMENT_NAME.AUTHOR)) {
					map.put(parentNodeName, element.getText());
				}
				
			}
		}
		return map;
	}

	/**
	 * @author ThangBN1
	 */
	private static Map<String, String> extractSelectionListFromXSDContent(String itemName, String xsd) throws ParserConfigurationException,
			SAXException, IOException, UnsupportedEncodingException, XPathExpressionException {
		Map<String, String> map = new TreeMap<String, String>();
		org.w3c.dom.Document doc = XMLUtils.getDoc(xsd);

		NodeList nodes = (NodeList) XMLUtils.XPath().evaluate("//root/dynamic-element[@name='" + itemName + "']/dynamic-element", doc,
				XPathConstants.NODESET);
		org.w3c.dom.Node node;
		for (int i = 0; i < nodes.getLength(); i++) {
			node = nodes.item(i);
			map.put(node.getAttributes().getNamedItem("type").getNodeValue(), node.getAttributes().getNamedItem("name").getNodeValue());
		}
		return map;
	}

	/**
	 * @author ThangBN1
	 * @return
	 */
	private static String getStructureXSD(String structureName) {
		JournalStructure structure = getStructure(structureName);
		return structure == null ? "" : structure.getXsd();
	}

	// Get Article content for Repeatable node
	public static List<String> getXsdContentArticleList(String articleContent, String itemName) {
		com.liferay.portal.kernel.xml.Document document = null;
		List<String> resultList = new ArrayList<String>();
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				List<com.liferay.portal.kernel.xml.Node> nodeList = document.selectNodes("/root/dynamic-element[@name='" + itemName
						+ "']/dynamic-content");
				if (nodeList != null) {
					for (int i = 0; i < nodeList.size(); i++) {
						com.liferay.portal.kernel.xml.Node node = nodeList.get(i);

						if (node.getText().length() > 0) {
							String result = node.getText();
							resultList.add(result);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return resultList;
	}

	// Get Article content for single node
	public static String getXsdContentArticle(String articleContent, String itemName) {
		com.liferay.portal.kernel.xml.Document document = null;
		String result = "";
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				com.liferay.portal.kernel.xml.Node node = document.selectSingleNode("/root/dynamic-element[@name='" + itemName
						+ "']/dynamic-content");
				if (node != null) {
					if (node.getText().length() > 0) {
						result = node.getText();
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	// Get Article Title
	public static String getXsdTitleArticle(String articleTitle) {
		com.liferay.portal.kernel.xml.Document document = null;
		String result = "";
		try {
			if (null != articleTitle && articleTitle.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleTitle));
				com.liferay.portal.kernel.xml.Node node = document.selectSingleNode("/root/Title");
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
	 * get structure by name using partial match regardless of scope, group id
	 * 
	 * @author ThangBN1
	 */
	@SuppressWarnings("unchecked")
	public static JournalStructure getStructure(String name) {
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(JournalStructure.class);
			dq.add(PropertyFactoryUtil.forName("name").like("%" + name + "%"));

			List<JournalStructure> lstStructure = JournalStructureLocalServiceUtil.dynamicQuery(dq, 0, 1);

			if (CollectionUtils.isNotEmpty(lstStructure))
				return lstStructure.get(0);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}

		return null;
	}
	/**
	 * get structure by name using partial match regardless of scope, group id
	 * 
	 * @author ThangBN1
	 */
	@SuppressWarnings("unchecked")
	public static JournalStructure getStructureById(String id) {
		try {
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(JournalStructure.class);
			dq.add(PropertyFactoryUtil.forName("structureId").eq(id));
			
			List<JournalStructure> lstStructure = JournalStructureLocalServiceUtil.dynamicQuery(dq, 0, 1);
			
			if (CollectionUtils.isNotEmpty(lstStructure))
				return lstStructure.get(0);
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}
		
		return null;
	}

	// Get Article content for single node
	public static String getXsdContentArticleMultiLanguage(String articleContent, String itemName, String languageId) {
		com.liferay.portal.kernel.xml.Document document = null;
		com.liferay.portal.kernel.xml.Node node = null;
		String result = StringPool.BLANK;
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				node = document.selectSingleNode("/root/dynamic-element[@name='" + itemName + "']/dynamic-content[@language-id='"
						+ languageId + "']");
				if (Validator.isBlankOrNull(node)) {
					node = document.selectSingleNode("/root/dynamic-element[@name='" + itemName + "']/dynamic-content");
				}
				if (!Validator.isBlankOrNull(node)) {
					if (node.getText().length() > 0) {
						result = node.getText();
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	// Get Article Title
	public static String getXsdTitleArticleMultiLanguage(String articleTitle, String languageId) {
		com.liferay.portal.kernel.xml.Document document = null;
		com.liferay.portal.kernel.xml.Node node = null;
		String result = "";
		try {
			if (null != articleTitle && articleTitle.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleTitle));
				node = document.selectSingleNode("/root/Title[@language-id='" + languageId + "']");
				if (node == null) {
					node = document.selectSingleNode("/root/Title");
				}
				if (node.getText().length() > 0) {
					result = node.getText();
				}

			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}
}
