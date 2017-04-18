package com.fsoft.bn.portlet.news.detail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.domain.news.VoteChoiceResult;
import com.fsoft.bn.portlet.news.NewsContants;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.fsoft.bn.service.BNJournalArticleLocalServiceUtil;
import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.PortalUtil;
import com.fsoft.bn.util.StructureUtil;
import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.polls.model.PollsChoice;
import com.liferay.portlet.polls.model.PollsQuestion;
import com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil;
import com.liferay.portlet.polls.service.PollsVoteServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
public class NewsDetailPortlet extends MVCPortlet {
	
	private static Logger log = Logger.getLogger(NewsDetailPortlet.class);
	Gson gson = new Gson();
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		long groupId = PortalUtil.getGroupId(renderRequest);
		String urlTitle = ParamUtil.getString(renderRequest, "urlTitle");
		String languageId = LanguageUtil.getLanguageId(renderRequest);
		boolean print = ParamUtil.getBoolean(renderRequest,"print");
		
		News newsDetail = this.getNewsDetailByUrlTitle(groupId, urlTitle, languageId , renderRequest);
		renderRequest.setAttribute("newsDetail", newsDetail);
		
		if (StringUtils.isNotBlank(newsDetail.getVoteQuestion())) {
			PollsQuestion question = CommonUtil.getPollsQuestion(newsDetail.getVoteQuestion());
			renderRequest.setAttribute("pollsQuestion", question);
		}
		String articleId = newsDetail.getId();
		String structureId = newsDetail.getStrucId();
		List<News> lstOtherNews =  BNJournalArticleLocalServiceUtil.getListOtherNewsInDetailPage(renderRequest, groupId, structureId, articleId, StringPool.BLANK, StringPool.BLANK, null);
		int quanOtherNewsShow = 5;
		renderRequest.setAttribute("lstOtherNews", lstOtherNews);
		renderRequest.setAttribute("quanOtherNewsShow", quanOtherNewsShow);
		
		//prepare print url
		PortletURL printPageURL = renderResponse.createRenderURL();
		printPageURL.setWindowState(LiferayWindowState.POP_UP);
		printPageURL.setParameter("urlTitle", urlTitle);
		printPageURL.setParameter("languageId", languageId);
		printPageURL.setParameter("viewMode", Constants.PRINT);
		printPageURL.setParameter("print", String.valueOf(true));
		renderRequest.setAttribute("print", print);
		renderRequest.setAttribute("printPageURL", printPageURL.toString());
		
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
			if(Validator.isBlankOrNull(newsDetail.getContent())) {
				newsDetail.setContent(StructureUtil.getXsdContentArticle(ja.getContent(), NewsContants.CONTENT));
			}
						
			// increment view count
			AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), ja.getResourcePrimKey());

		} catch (PortalException e) {
			log.error(e.getMessage());
		} catch (SystemException e) {
			log.error(e.getMessage());
		}

		return newsDetail;
	}
	/**
	 * @author kiennn
	 * @param groupId
	 * @param urlTitle
	 * @param languageId
	 * @return News
	 */
	private News getNewsDetailByUrlTitle(long groupId, String urlTitle, String languageId , RenderRequest req) {
		News newsDetail = null;
		try {
			JournalArticle ja = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, urlTitle);
			
			// get category of Journal Article 
			List<AssetCategory> lstCategories = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), ja.getResourcePrimKey());
			
			newsDetail = new News(ja, null, languageId);
			// set category name to news record
			if (CollectionUtils.isNotEmpty(lstCategories)) {
				newsDetail.setCateName(lstCategories.get(0).getTitle(languageId));
			}
			if(Validator.isBlankOrNull(newsDetail.getContent())) {
				newsDetail.setContent(StructureUtil.getXsdContentArticle(ja.getContent(), NewsContants.CONTENT));
			}
			if(Validator.isBlankOrNull(newsDetail.getImageURL())) {
				newsDetail.setImageURL("http://tinhtonghochoi.vn/image/journal/article?img_id="+ja.getSmallImageId());
			}	
			if(Validator.isBlankOrNull(newsDetail.getUrlDetail())) {
				newsDetail.setUrlDetail(NewsUtils.getURL(req, ja,
						NewsContants.FRIENDLY_URL.VIEW_DETAIL,
						NewsContants.PORTLET_NAME.NEWS_DETAIL,
						ja.getStructureId()));
			}
			// increment view count
			AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), ja.getResourcePrimKey());

		} catch (PortalException e) {
			log.error(e.getMessage());
		} catch (SystemException e) {
			log.error(e.getMessage());
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
				log.info(e.getMessage());
			}
		}
	}
}