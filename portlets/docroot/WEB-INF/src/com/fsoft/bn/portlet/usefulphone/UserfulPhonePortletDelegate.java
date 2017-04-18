package com.fsoft.bn.portlet.usefulphone;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.fsoft.bn.model.UserfulContactPhone;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

public class UserfulPhonePortletDelegate {
	private static Log logger = LogFactoryUtil.getLog(UserfulPhonePortletDelegate.class);
	private static String NEWS_STRUCTURE = "Danh bạ điện tử";
	
	public static List<UserfulContactPhone> getAllContactPhoneArticle(PortletRequest request) throws PortalException, SystemException {
		
		logger.info("===UserfulPhonePortletDelegate===");
		List<UserfulContactPhone> lstLatestArticle = new ArrayList<UserfulContactPhone>();
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		// get group id by scope
        long groupId = themeDisplay.getScopeGroupId();
        // get structure id by name or title
     	String structureId = getStructureByName(NEWS_STRUCTURE);
        
        // TODO: hard code
		String sortBy = "modifiedDate";
		
		NewsUtils commonUtilsContact = new NewsUtils();
		OrderByComparator obc = OrderByComparatorFactoryUtil.create("JOURNALARTICLE", sortBy ,false);
		try {
			List<JournalArticle> listNews = JournalArticleLocalServiceUtil.getStructureArticles(groupId, structureId, -1, -1, obc);
			for (JournalArticle ja : listNews) {
				double articleVersion = ja.getVersion();
				String articleIdCheck = ja.getArticleId();
				if (JournalArticleLocalServiceUtil.isLatestVersion(groupId, articleIdCheck, articleVersion)){
					UserfulContactPhone mContactPhone = commonUtilsContact.setUsefulContactArticle(ja);
					lstLatestArticle.add(mContactPhone);
				}
			}
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
       
        return lstLatestArticle;
	}
	
	// function get structure id by name
	@SuppressWarnings("unused")
	private static String getStructureByName(String name) {
		
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(JournalStructure.class).
								add(PropertyFactoryUtil.forName("name"). like("%" + name + "%"));

		try {
			@SuppressWarnings("unchecked")
			List<JournalStructure> lstStructure = JournalStructureLocalServiceUtil.dynamicQuery(dq, 0, 1);
			
			if (null != lstStructure && lstStructure.size() > 0) {
				return lstStructure.get(0).getStructureId();
			} else {
				logger.info("No structure found!");
				return null;
			}
			
		} catch (SystemException e) {
			logger.error("Exception when get structure: " + e.getMessage());
		}
		return null;
	}
}
