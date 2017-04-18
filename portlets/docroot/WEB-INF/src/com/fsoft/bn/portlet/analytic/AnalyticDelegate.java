package com.fsoft.bn.portlet.analytic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.bn.domain.AnalyticViewMode;
import com.fsoft.bn.util.StructureUtil;
import com.liferay.portlet.journal.model.JournalArticle;

public class AnalyticDelegate {
	/** logger */
	private static Logger logger = Logger.getLogger(AnalyticDelegate.class);
	public static AnalyticViewMode getAllAnanlytic(JournalArticle journalArticle) {
		AnalyticViewMode analyticViewMode = new AnalyticViewMode();
		try {
			analyticViewMode.setId(journalArticle.getArticleId());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		analyticViewMode.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
		analyticViewMode.setContent(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "Noidunghienthi"));
		analyticViewMode.setSolieu(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "Solieu"));
		return analyticViewMode;
	}

	// get All
	public static List<AnalyticViewMode> getAllAnalyticViewModes(List<JournalArticle> articles) {
		List<AnalyticViewMode> viewModes = new ArrayList<AnalyticViewMode>();
		for (JournalArticle journalArticle : articles) {
			AnalyticViewMode mode = getByFieldAnalytic(journalArticle);
			viewModes.add(mode);
		}
		return viewModes;
	}

	// get content
	public static AnalyticViewMode getByFieldAnalytic(
			JournalArticle journalArticle) {
		AnalyticViewMode viewMode = new AnalyticViewMode();
		try {
			viewMode.setId(journalArticle.getArticleId());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		viewMode.setTitle(StructureUtil.getXsdTitleArticle(journalArticle.getTitle()));
		viewMode.setContent(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "Noidunghienthi"));
		viewMode.setSolieu(StructureUtil.getXsdContentArticle(journalArticle.getContent(), "Solieu"));
		return viewMode;
	}
}
