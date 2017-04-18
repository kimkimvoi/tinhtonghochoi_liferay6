package com.fsoft.bn.portlet.news;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.StringUtils;

import com.fsoft.bn.domain.news.NewsCategory;
import com.fsoft.bn.domain.news.NewsStructure;
import com.fsoft.bn.model.UserfulContactPhone;
import com.fsoft.bn.model.impl.UserfulContactPhoneImpl;
import com.fsoft.bn.portlet.news.NewsContants.FRIENDLY_URL;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetCategoryProperty;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

public class NewsUtils {
	/** logger */
	private static Log logger = LogFactoryUtil.getLog(NewsUtils.class);

	public static UserfulContactPhone setUsefulContactArticle(JournalArticle ja) {
		UserfulContactPhone mContactPhone = new UserfulContactPhoneImpl();
		String jaContent = ja.getContent();

		mContactPhone.setUserful_contact_name(getXsdContentArticle(jaContent, "CONTACT_NAME"));
		mContactPhone.setUserful_contact_email(getXsdContentArticle(jaContent, "CONTACT_EMAIL"));
		mContactPhone.setUserful_contact_phone(getXsdContentArticle(jaContent, "CONTACT_PHONE"));
		mContactPhone.setUserful_contact_position(getXsdContentArticle(jaContent, "CONTACT_WORK"));
		mContactPhone.setUserful_contact_address(getXsdContentArticle(jaContent, "CONTACT_ADDRESS"));
		return mContactPhone;
	}

	/**
	 * @author DucNH1
	 * @param articleContent
	 * @param itemName
	 * @return This function get content of a tag on Content article (this data on structure)
	 */
	public static String getXsdContentArticle(String articleContent, String itemName) {
		Document document = null;
		String result = "";
		try {
			if (null != articleContent && articleContent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
				Node node = document.selectSingleNode("/root/dynamic-element[@name='" + itemName + "']/dynamic-content");
				if (node != null && node.getText().length() > 0) {
					result = node.getText();
				}
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return result;
	}

	/**
	 * get element value from journal structure XSD content
	 * 
	 * @author ThangBN1
	 * @param XSDContent
	 *            XSD content string
	 * @param elementName
	 *            name of element need to extract
	 * @return
	 */
	public static List<Node> getStructureXSDElement(String XSDContent, String elementName) {
		if (StringUtils.isNotEmpty(XSDContent)) {
			Document document = null;
			try {
				document = SAXReaderUtil.read(new StringReader(XSDContent));
			} catch (DocumentException e) {
				logger.info(e.getMessage());
				logger.error("Error occurred when parse XSD content of structure");
				return null;
			}
			List<Node> nodes = document.selectNodes("/root/dynamic-element[@name='" + elementName + "']/dynamic-element");
			return nodes;
		}

		return null;
	}

	/**
	 * @author DucNH1
	 * @author ThangBN1
	 * @param XSDcontent
	 * @return This function get content of field title on xsd file title of article
	 */
	public static String getXsdTitleArticle(String XSDcontent) {
		Document document = null;
		String result = "";
		try {
			if (null != XSDcontent && XSDcontent.length() != 0) {
				document = SAXReaderUtil.read(new StringReader(XSDcontent));
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
	 * @author DucNH1
	 * @param groupId
	 * @param structureId
	 * @param sortBy
	 * @return this function get all journal article by groupId and StructureId
	 */
	public static List<JournalArticle> getJournalArticles(long groupId, String structureId, String sortBy) {
		try {
			OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy, false);
			return JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return null;
	}

	/**
	 * @author ThangBN1
	 */
	public static List<NewsCategory> getCategories(PortletRequest req, final String vocalName) {
		return convert(getCategoriesModelObj(req, vocalName), LanguageUtil.getLanguageId(req));
	}

	public static List<NewsCategory> getCategories(PortletRequest req, final long[] ids) {
		return convert(getCategoriesModelObj(req, ids), LanguageUtil.getLanguageId(req));
	}

	@SuppressWarnings("unchecked")
	private static List<NewsCategory> convert(List<AssetCategory> categories, final String languageId) {
		return (List<NewsCategory>) CollectionUtils.collect(categories, new Transformer() {
			public Object transform(Object arg0) {
				return new NewsCategory((AssetCategory) arg0, languageId);
			}
		});
	}

	/**
	 * @author ThangBN1
	 */
	private static List<AssetCategory> getCategoriesModelObj(PortletRequest req, final String vocalName) {
		AssetVocabulary vocabulary = getVocabulary(req, vocalName);
		try {
			if (null == vocabulary) {
				return new ArrayList<AssetCategory>();
			}

			return AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabulary.getVocabularyId(), -1, -1, null);
		} catch (SystemException e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not load vocalbulary " + e.getLocalizedMessage());
		}
	}

	private static List<AssetCategory> getCategoriesModelObj(PortletRequest req, final long[] ids) {
		try {
			List<AssetCategory> vocabularyCategories = new ArrayList<AssetCategory>();
			for (long l : ids) {
				vocabularyCategories.add(AssetCategoryLocalServiceUtil.getAssetCategory(l));
			}
			return vocabularyCategories;
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not load vocalbulary " + e.getLocalizedMessage());
		}
	}

	/**
	 * get a vocabulary by name
	 * 
	 * @author ThangBN1
	 * @return Map of key and name of all categories
	 */
	private static AssetVocabulary getVocabulary(PortletRequest req, String vocalName) {
		return getVocabulary(PortalUtil.getGroupId(req), vocalName, LanguageUtil.getLanguageId(req));
	}

	/**
	 * get a vocabulary by name
	 * 
	 * @author ThangBN1
	 * @return Map of key and name of all categories
	 */
	private static AssetVocabulary getVocabulary(long groupId, final String vocalName, final String languageId) {
		try {
			List<AssetVocabulary> vocals = AssetVocabularyLocalServiceUtil.getGroupVocabularies(groupId);
			return (AssetVocabulary) CollectionUtils.find(vocals, new Predicate() {
				public boolean evaluate(Object arg0) {
					return vocalName.equalsIgnoreCase(((AssetVocabulary) arg0).getTitle(languageId, true));
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("Can not load vocalbulary " + e.getLocalizedMessage());
		}
	}

	public static String getURL(PortletRequest request, JournalArticle article, String friendlyURL, String portletName, String structId) {
		//++kien 28/03/2014 - get detail link for news by category
		try {
			List<AssetCategory> lstCategories = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), article.getResourcePrimKey());
			if (CollectionUtils.isNotEmpty(lstCategories)) {
				AssetCategoryProperty categoryProperty = AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(lstCategories.get(0).getCategoryId(), FRIENDLY_URL.DETAIL_URL_CONFIG);
				if (categoryProperty != null) {
					friendlyURL = "/" + categoryProperty.getValue();
				}
			}
		} catch (Exception e) {
//			logger.error(e.getMessage());
		}
		//--kien 28/03/2014 - get detail link for news by category
		try {
			PortletURL portletURL = PortletURLFactoryUtil.create(request, portletName, PortalUtil.getLayoutIdViewDetail(request, friendlyURL),
					PortletRequest.RENDER_PHASE);
		
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("structId", structId);
			portletURL.setParameter("articleId", String.valueOf(article.getArticleId()));
			portletURL.setParameter("version", StringUtil.replace(String.valueOf(article.getVersion()), StringPool.PERIOD, StringPool.DASH));
			
			return portletURL.toString();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return StringPool.BLANK;
	}

	/**
	 * @author YenMC
	 */
	public static String returnPortletURL(PortletRequest request, String friendlyURL, String portletName, String groupId,
			String structureId, String articleId, String vers) {
		PortletURL portletURL = PortletURLFactoryUtil.create(request, portletName, PortalUtil.getLayoutIdViewDetail(request, friendlyURL),
				PortletRequest.RENDER_PHASE);
		try {
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setParameter("articleId", articleId);
			// must replace PERIOD to DASH because friendly URL don't accept PERIOD character
			portletURL.setParameter("version", StringUtil.replace(vers, StringPool.PERIOD, StringPool.DASH));
		} catch (WindowStateException e) {
			logger.info(e.getMessage());
		} catch (PortletModeException e) {
			logger.info(e.getMessage());
		}

		return portletURL.toString();
	}

	/**
	 * @author YenMC
	 * @param request
	 * @param friendlyURL
	 * @param portletName
	 * @param groupId
	 * @param structureId
	 * @param cateType
	 * @return String portletURLString
	 */
	public static String returnPortletURLByNewsCategory(ActionRequest request, String friendlyURL, String portletName, String groupId,
			String structureId, String cateType) {
		PortletURL portletURL = null;
		portletURL = PortletURLFactoryUtil.create(request, portletName, PortalUtil.getLayoutIdViewDetail(request, friendlyURL),
				PortletRequest.RENDER_PHASE);
		try {
			portletURL.setWindowState(WindowState.NORMAL);
			portletURL.setPortletMode(PortletMode.VIEW);
		} catch (WindowStateException e) {
			logger.info(e.getMessage());
		} catch (PortletModeException e) {
			logger.info(e.getMessage());
		}

		portletURL.setParameter("groupId", groupId);
		portletURL.setParameter("structureId", structureId);
		portletURL.setParameter("cateType", cateType);
		
		return portletURL.toString();
	}

	/**
	 * @author YenMC
	 * @param resourcePrimKey
	 * @return viewCount
	 */
	public static int getViewCountArticle(long resourcePrimKey) {
		int viewCount = 0;
		AssetEntry assetEntry;
		
		try {
			assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), resourcePrimKey);
			if (null != assetEntry && assetEntry.getViewCount() > 0) {
				viewCount = assetEntry.getViewCount();
			} else {
				viewCount = 0;
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		} catch (SystemException e) {
			logger.error(e.getMessage());
		}
		
		return viewCount;
	}

	/**
	 * @author ThangBN1
	 */
	@SuppressWarnings("unchecked")
	private static List<JournalStructure> getChildrenOfJournalStruct(String structName) {
		final JournalStructure parentStruct = StructureUtil.getStructure(structName);
		if (parentStruct == null) {
			throw new RuntimeException("Can not find structure with given name");
		}
		List<JournalStructure> structures;
		try {
			structures = JournalStructureLocalServiceUtil.getStructures();
		} catch (SystemException e) {
			logger.info(e.getMessage());
			throw new RuntimeException("Can not load children struture " + e.getMessage());
		}

		return (List<JournalStructure>) CollectionUtils.select(structures, new Predicate() {
			public boolean evaluate(Object paramObject) {
				return parentStruct.getStructureId().equals(((JournalStructure) paramObject).getParentStructureId());
			}
		});
	}

	/**
	 * @author ThangBN1
	 */
	private static List<JournalStructure> getChildrenOfNewsStructModelObj() {
		return getChildrenOfJournalStruct(NewsContants.NEWS_COMMON_STRUCTURE_NAME);
	}

	/**
	 * get all children structure of common news structure, with the current locale
	 * 
	 * @author ThangBN1
	 */
	@SuppressWarnings("unchecked")
	public static List<NewsStructure> getChildrenOfNewsStruct(final PortletRequest req) {
		return (List<NewsStructure>) CollectionUtils.collect(getChildrenOfNewsStructModelObj(), new Transformer() {
			public Object transform(Object arg0) {
				return new NewsStructure((JournalStructure) arg0, req, true);
			}
		});
	}

	/**
	 * @author YenMC
	 */
	public static String getSmallImageURLArticle(JournalArticle ja, PortletRequest req) {
		// get small image from image URL or image id
		String imageURL = null;

		if (ja.isSmallImage()) {
			if (!Validator.isBlankOrNull(ja.getSmallImageURL())) {
				imageURL = ja.getSmallImageURL();
			} else {
				imageURL = PortalUtil.getThemeDisplay(req).getPathImage() + "/journal/article?img_id=" + ja.getSmallImageId() + "&t=" + WebServerServletTokenUtil.getToken(ja.getSmallImageId());
			}
		}

		return imageURL;
	}

}
