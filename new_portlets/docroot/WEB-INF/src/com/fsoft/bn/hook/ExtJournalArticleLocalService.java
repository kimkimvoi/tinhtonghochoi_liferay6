package com.fsoft.bn.hook;

import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceWrapper;
public class ExtJournalArticleLocalService extends JournalArticleLocalServiceWrapper {

	public ExtJournalArticleLocalService(JournalArticleLocalService journalArticleLocalService) {
		super(journalArticleLocalService);
	}


}