package com.fsoft.bn.domain.news;

import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portlet.asset.model.AssetCategory;

public class NewsCategory extends KeyValuePair {
	private static final long serialVersionUID = -4326912760580483333L;
	public String name = "";
	public long id;
	boolean selected;

	public NewsCategory(long id) {
		super();
		this.id = id;
	}

	public NewsCategory(long id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public NewsCategory(AssetCategory assetCategory, String languageId) {
		setId(assetCategory.getCategoryId());
		setName(assetCategory.getTitle(languageId));
	}

	public NewsCategory() {
		super();
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getName() {
		return name;
	}

	public void setName(String categoryName) {
		this.name = categoryName;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

	@Override
	public void setKey(String key) {
		id = Long.parseLong(key);
	}

	@Override
	public void setValue(String value) {
		name = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsCategory other = (NewsCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewsCategory [name=" + name + ", id=" + id + ", selected=" + selected + "]";
	}

}
