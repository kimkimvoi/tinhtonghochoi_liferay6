package com.fsoft.bn.util.transformer;

import org.apache.commons.collections.Transformer;

import com.fsoft.bn.service.impl.BNJournalArticleLocalServiceImpl;
import com.liferay.portal.kernel.util.KeyValuePair;

final class GetKeyTransformer implements Transformer {
	/**
	 * 
	 */
	private final BNJournalArticleLocalServiceImpl GetKeyTransformer;

	/**
	 * @param bnJournalArticleLocalServiceImpl
	 */
	GetKeyTransformer(BNJournalArticleLocalServiceImpl bnJournalArticleLocalServiceImpl) {
		GetKeyTransformer = bnJournalArticleLocalServiceImpl;
	}

	public Object transform(Object arg0) {
		return ((KeyValuePair) arg0).getKey();
	}
}