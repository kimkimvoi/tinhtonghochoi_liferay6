package com.fsoft.bn.domain.news;

import java.util.List;

import javax.portlet.PortletRequest;

import com.fsoft.bn.domain.Structure;
import com.fsoft.bn.portlet.news.NewsUtils;
import com.liferay.portlet.journal.model.JournalStructure;

/**
 * @author ThangBN1
 */
public class NewsStructure extends Structure {
	private static final long serialVersionUID = -8091855706478729635L;
	private List<NewsCategory> categories;

	public NewsStructure(JournalStructure js, PortletRequest req) {
		this(js, req, false);
	}

	public NewsStructure(JournalStructure js, PortletRequest req, boolean getContent) {
		if (js != null) {
			setName(js.getNameCurrentValue());
			setId(js.getStructureId());
			setCategories(NewsUtils.getCategories(req, getName()));

			if (getContent) {
				XSD = js.getMergedXsd();
			}
		}
	}

	public NewsStructure(String value) {
		super(value);
	}

	public NewsStructure() {
		super();
	}

	public List<NewsCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<NewsCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "NewsStructure [categories=" + categories + "]";
	}

}
