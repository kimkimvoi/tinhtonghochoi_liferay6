package com.fsoft.bn.domain;

import java.util.ArrayList;
import java.util.List;
import com.liferay.portal.kernel.repository.model.FileEntry;

public class BNFolder {
	private long id;
	private String name;
	
	public List<FileEntry> files = new ArrayList<FileEntry>();

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
