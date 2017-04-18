package com.fsoft.bn.portlet.marketinfomation;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.MarketInfo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
public class MarketInfoCommonUntils {
	/** logger */
	private static Logger logger = Logger.getLogger(MarketInfoCommonUntils.class);
	/**
	 * @author DucNH1
	 * @param ja
	 * @return
	 * This function set new a News Article
	 */
	public MarketInfo setNewsArticle(JournalArticle ja) {
		MarketInfo newsResult = new MarketInfo();
		String jaContent = ja.getContent();
		String jaTitle = ja.getTitle();
		String jaID = ja.getArticleId();
		newsResult.setMarketInfoId(jaID);
		newsResult.setTitle(getXsdTitleArticle(jaTitle));
		newsResult.setCreatedDate(ja.getCreateDate().toString());
		newsResult.setSummary(getXsdContentArticle(jaContent, "Description"));
		newsResult.setImageURL(getXsdContentArticle(jaContent, "Picture"));
		newsResult.setContent(getXsdContentArticle(jaContent, "Content"));
		return newsResult;
	}


	/**
	 * @author DucNH1
	 * @param articleContent
	 * @param itemName
	 * @return
	 * This function get content of a tag on Content article (this data on structure)
	 */
	public String getXsdContentArticle(String articleContent, String itemName) {
		Document document = null;
		String result="";
		try
		{
			if (null != articleContent && articleContent.length()!=0) {
				document = SAXReaderUtil.read(new StringReader(articleContent));
		Node node = document.selectSingleNode("/root/dynamic-element[@name='"+ itemName +"']/dynamic-content");
		if (node.getText().length() > 0) {
			result = node.getText();
		}
			}

	}
	catch (Exception e)
	{
	logger.info(e.getMessage());
	}

		return result;
	}

	/**
	 * @author DucNH1
	 * @param articleTitle
	 * @return
	 * This function get content of field title on xsd file title of article
	 */
	public String getXsdTitleArticle(String articleTitle) {
		Document document = null;
		String result="";
		try
		{
			if (null != articleTitle && articleTitle.length()!=0) {
				document = SAXReaderUtil.read(new StringReader(articleTitle));
				Node node = document.selectSingleNode("/root/Title");
				if (node.getText().length() > 0) {
					result = node.getText();
				}
			}
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}

		return result;
	}

	/**
	 * @author DucNH1
	 * @param groupId
	 * @param articleId
	 * @param version
	 * @return
	 * This function check last version of article
	 */
	public boolean checkIsArticleLastVersion(long groupId, String articleId, double version) {
		boolean isLastVersion = false;
		try {
			isLastVersion = JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleId, version);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		} catch (SystemException e) {
			logger.info(e.getMessage());
		}

		return isLastVersion;
	}

	public static java.util.List<com.fsoft.bn.domain.MarketInfo> getListPaginatorInfo(List<MarketInfo> listAllMarketInfos, int start, int end)
			throws com.liferay.portal.kernel.exception.SystemException {
		List<MarketInfo> listVideoPaginator = new ArrayList<MarketInfo>();
		for (int i=start; i<end; i++ ) {
			if (i < listAllMarketInfos.size()) {
				listVideoPaginator.add(listAllMarketInfos.get(i));
			}else {
				break;
			}
		}

		return listVideoPaginator;
	}
}