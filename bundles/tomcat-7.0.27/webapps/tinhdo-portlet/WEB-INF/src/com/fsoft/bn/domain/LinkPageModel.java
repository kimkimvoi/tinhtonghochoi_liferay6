/**
 * 
 */
package com.fsoft.bn.domain;

import java.util.List;

/**
 * @author VangND1
 *
 */
public class LinkPageModel {
	
	/** type */
	private String type;
	
	private List<LinkModel> links;
	
	
	public LinkPageModel() {
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public List<LinkModel> getLinks() {
		return links;
	}

	public void setLinks(List<LinkModel> links) {
		this.links = links;
	}
	
}
