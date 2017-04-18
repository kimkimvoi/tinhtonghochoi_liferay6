package com.fsoft.bn.util.transformer;

import javax.portlet.PortletRequest;

import org.apache.commons.collections.Transformer;

import com.fsoft.bn.domain.news.News;
import com.fsoft.bn.portlet.news.NewsContants.FRIENDLY_URL;
import com.fsoft.bn.portlet.news.NewsContants.PORTLET_NAME;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class JournalArticle2NewsTransformer implements Transformer {
	private final PortletRequest req;
	private String structId = "";

	public JournalArticle2NewsTransformer(PortletRequest req) {
		this.req = req;
	}
	
	public JournalArticle2NewsTransformer(PortletRequest req, String structId) {
		this.req = req;
		this.structId = structId;
	}
	
	public Object transform(Object arg0) {
		JournalArticle ja = (JournalArticle) arg0;
		// get small image
		ja.setSmallImageURL(NewsUtils.getSmallImageURLArticle(ja, req));
		return new News(ja, NewsUtils.getURL(req, ja, FRIENDLY_URL.NEWS_VIEW_DETAIL, PORTLET_NAME.NEWS_DETAIL, structId), LanguageUtil.getLanguageId(req));
	}
}