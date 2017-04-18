package com.fsoft.bn.util.predicate;

import org.apache.commons.collections.Predicate;

import com.fsoft.bn.domain.news.NewsCategory;

public final class FindCategoryByIdPredicate implements Predicate {
	private final long id;

	public FindCategoryByIdPredicate(long id) {
		this.id = id;
	}

	public boolean evaluate(Object arg0) {
		return ((NewsCategory) arg0).getId() == id;
	}
}