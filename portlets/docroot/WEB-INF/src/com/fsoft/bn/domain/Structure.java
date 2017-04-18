package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.KeyValuePair;

public class Structure extends KeyValuePair {
	private static final long serialVersionUID = 9022945108258442136L;
	protected String id;
	protected String name;
	protected String keyName;
	protected String keyNameDisplay;
	protected String keyPortletHeaderDisplay;
	protected String XSD;

	public Structure() {
	}

	public Structure(String id) {
		super();
		this.id = id;
	}

	public String getXSD() {
		return XSD;
	}

	public void setXSD(String xSD) {
		XSD = xSD;
	}

	public String getKeyPortletHeaderDisplay() {
		return keyPortletHeaderDisplay;
	}

	public void setKeyPortletHeaderDisplay(String keyPortletHeaderDisplay) {
		this.keyPortletHeaderDisplay = keyPortletHeaderDisplay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyNameDisplay() {
		return keyNameDisplay;
	}

	public void setKeyNameDisplay(String keyNameDisplay) {
		this.keyNameDisplay = keyNameDisplay;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Structure other = (Structure) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
		id = key;
	}

	@Override
	public void setValue(String value) {
		name = value;
	}

}
