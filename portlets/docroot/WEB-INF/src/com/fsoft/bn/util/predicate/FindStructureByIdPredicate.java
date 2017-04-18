package com.fsoft.bn.util.predicate;

import org.apache.commons.collections.Predicate;

import com.fsoft.bn.domain.news.NewsStructure;

public final class FindStructureByIdPredicate implements Predicate {
	private final String id;

	public FindStructureByIdPredicate(String id) {
		this.id = id;
	}

	public boolean evaluate(Object arg0) {
		return ((NewsStructure) arg0).getId().equals(id) ;
	}
}