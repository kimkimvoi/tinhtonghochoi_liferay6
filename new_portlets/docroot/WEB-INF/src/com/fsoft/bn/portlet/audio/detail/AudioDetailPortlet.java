package com.fsoft.bn.portlet.audio.detail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.VoteChoiceResult;
import com.fsoft.bn.portlet.audiolibrary.AudioLibrary;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;
import com.liferay.portlet.polls.service.PollsVoteServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class AudioDetailPortlet
 */
public class AudioDetailPortlet extends MVCPortlet {
	
	
	private static Logger logger = Logger.getLogger(AudioDetailPortlet.class);
	
	Gson gson = new Gson();
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String categoryId = ParamUtil.getString(renderRequest, "categoryId");
		String fileEntryId = null;
		if (categoryId != null && categoryId.length() > 0) {
			try {
				fileEntryId = String.valueOf(DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), NumberUtils.toLong(categoryId), 0, 1, null).get(0).getFileEntryId());
			} catch (SystemException e) {
				logger.error(e);
			}
		} else {
			fileEntryId = ParamUtil.getString(renderRequest, "fileEntryId");
		}
		//declare delegate
		// get parameters from request of others portlets
		long groupId = PortalUtil.getGroupId(renderRequest);
		
		if(fileEntryId != null && fileEntryId.length() > 0) {
			//String languageId = LanguageUtil.getLanguageId(renderRequest);
			//boolean print = ParamUtil.getBoolean(renderRequest,"print");
			DLFileEntry file = null;
			try {
				file = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(fileEntryId));
			} catch (NumberFormatException e3) {
				logger.error(e3);
			} catch (PortalException e3) {
				logger.error(e3);
			} catch (SystemException e3) {
				logger.error(e3);
			}
			file.setReadCount(file.getReadCount() + 1);
			try {
				DLFileEntryLocalServiceUtil.updateDLFileEntry(file, true);
			} catch (SystemException e3) {
				logger.error(e3);
			}
			
			News newsDetail = new News();
			newsDetail.setId(String.valueOf(file.getFileEntryId()));
			newsDetail.setTitle(file.getTitle());
			newsDetail.setViewCount(file.getReadCount());
			newsDetail.setCreatedDate(file.getCreateDate().toString());
			
			try {
				newsDetail.setCateName(DLFolderLocalServiceUtil
						.getFolder(file.getFolderId()).getName());
			} catch (PortalException e1) {
				logger.error(e1);
			} catch (SystemException e2) {
				logger.error(e2);
			}
			
			newsDetail.setAuthor(AudioLibrary.getAuthor(file));
			newsDetail.setSource(AudioLibrary.createDownloadLink(file, themeDisplay));
		
			renderRequest.setAttribute("newsDetail", newsDetail);
			
			if (StringUtils.isNotBlank(newsDetail.getVoteQuestion())) {
				PollsQuestion question = CommonUtil.getPollsQuestion(newsDetail.getVoteQuestion());
				renderRequest.setAttribute("pollsQuestion", question);
			}
			
			/*PortletURL printPageURL = renderResponse.createRenderURL();
			printPageURL.setWindowState(LiferayWindowState.POP_UP);
			printPageURL.setParameter("version", String.valueOf(version));
			printPageURL.setParameter("languageId", languageId);
			printPageURL.setParameter("viewMode", Constants.PRINT);
			printPageURL.setParameter("print", String.valueOf(true));
			renderRequest.setAttribute("print", print);
			renderRequest.setAttribute("printPageURL", printPageURL.toString());*/
			//List<News> lstOtherNews =  BNJournalArticleLocalServiceUtil.getListOtherNewsInDetailPage(renderRequest, groupId, "27523" , articleId, "27518 ", StringPool.BLANK, null);
			//NewsPage newsPage = BNJournalArticleLocalServiceUtil.getNews(renderRequest,structureId, Long.parseLong(categoryId), 10, 0, false, null);
			//int quanOtherNewsShow = 5;
			
			String urlAuthor = renderRequest.getParameter("urlAuthor");
			List<DLFileEntry> fileList = new ArrayList<DLFileEntry>();
			try {
				if (Validator.isBlankOrNull(urlAuthor)) {
					fileList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, file.getFolderId(), -1, -1, null);
				} else {
					List<DLFolder> folderList = AudioLibrary.getAllFolders(groupId, AudioLibrary.PHAP_AM_FOLDER_ID);
					List<DLFileEntry> tmpFileList = new ArrayList<DLFileEntry>();
					for (DLFolder dlFolder : folderList) {
						tmpFileList.addAll(DLFileEntryLocalServiceUtil.getFileEntries(
							groupId, dlFolder.getFolderId(), -1, -1, null));
					}
					for (DLFileEntry dlFileEntry : tmpFileList) {
						if (AudioLibrary.getAuthor(file).equals(AudioLibrary.getAuthor(dlFileEntry))) {
							fileList.add(dlFileEntry);
						}
					}
				}
			} catch (SystemException e) {
				logger.error(e);
			}
			List<News> otherAudioList = new ArrayList<News>();
			for (DLFileEntry fileEntry : fileList) {
				otherAudioList.add(AudioLibrary.getAudioDetail(renderRequest, fileEntry, themeDisplay));
			}
			
			renderRequest.setAttribute("lstOtherNews", otherAudioList);
			//renderRequest.setAttribute("quanOtherNewsShow", quanOtherNewsShow);
		}
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * @author YenMC
	 * @param groupId
	 * @param articleId
	 * @param version
	 * @return newsDetail
	 */
	private News getNewsDetail(long groupId, String articleId, double version, String languageId) {
		News newsDetail = null;
		try {
			JournalArticle ja = JournalArticleLocalServiceUtil.getArticle(groupId, articleId, version);
			
			// get category of Journal Article 
			List<AssetCategory> lstCategories = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), ja.getResourcePrimKey());
			
			newsDetail = new News(ja, null, languageId);
			// set category name to news record
			if (CollectionUtils.isNotEmpty(lstCategories)) {
					newsDetail.setCateName(lstCategories.get(0).getTitle(languageId));
			}
						
			// increment view count
			AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), ja.getResourcePrimKey());

		} catch (PortalException e) {
			logger.error(e.getMessage());
		} catch (SystemException e) {
			logger.error(e.getMessage());
		}

		return newsDetail;
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		
		String resourceID = resourceRequest.getResourceID();
		
		if ("handleVoteAjaxAction".equals(resourceID)) {
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
				long questionId = Long.parseLong(resourceRequest.getParameter("questionId"));
				long choiceId = Long.parseLong(resourceRequest.getParameter("choiceId"));
				PollsVoteServiceUtil.addVote(questionId, choiceId, serviceContext);
				
				// get Data for display
				PollsQuestion question = PollsQuestionLocalServiceUtil.getPollsQuestion(questionId);
				List<PollsChoice> choices = question.getChoices();
				List<VoteChoiceResult> results = new ArrayList<VoteChoiceResult>();
				
				int totalVotes = question.getVotesCount();
				for (int i = 0; i < choices.size(); i++) {
					PollsChoice choice = (PollsChoice)choices.get(i);
					VoteChoiceResult result = new VoteChoiceResult();
				
					choice = choice.toEscapedModel();
				
					int choiceVotes = choice.getVotesCount();
				
					double votesPercent = 0.0;
				
					if (totalVotes > 0) {
						votesPercent = (double)choiceVotes / totalVotes;
					}
				
					result.setNumberOfChoices(choiceVotes);
					result.setQuestionText(choice.getDescription(PortalUtil.getThemeDisplay(resourceRequest).getLocale()));
					result.setPercentage((int)Math.floor(votesPercent*100));
					result.setTotalVoteOfQuestions(totalVotes);
					
					results.add(result);
				}
				
				resourceResponse.getWriter().write(gson.toJson(results));
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	}
 

}
