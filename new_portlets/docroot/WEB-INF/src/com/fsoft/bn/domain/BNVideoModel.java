/**
 * 
 */
package com.fsoft.bn.domain;

import java.io.Serializable;

import com.fsoft.bn.util.StructureUtil;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * This class using handle video on jsp
 * 
 * @author VangND1
 * 
 */
public class BNVideoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String id;
	
	public BNVideoModel() {
	}
	public BNVideoModel(String title, String id) {
		super();
		this.title = title;
		this.id = id;
	}
	public BNVideoModel(JournalArticle item) {
		String xml = item.getContent();
		setTitle(item.getTitleCurrentValue());
		this.id = StructureUtil.getXsdContentArticle(xml, "id");
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	

}
