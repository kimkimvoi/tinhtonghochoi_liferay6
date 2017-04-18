package com.fsoft.bn.domain.audio;

import java.util.List;

import javax.portlet.PortletRequest;

import com.fsoft.bn.domain.Page;

/**
 * This class using for pagginator
 * @author VangND1
 *
 */
public class AudioPage extends Page<Audio> {

	/**
	 * Generated serial version id.
	 */
	private static final long serialVersionUID = 1059620189096122832L;
	/**
	 * Custom constructor with parameter
	 * @param req
	 * @param numOfPage
	 * @param pageNum
	 * @param recordPerPage
	 * @param items
	 */
	public AudioPage(PortletRequest req, int numOfPage, int pageNum, int recordPerPage, List<Audio> items) {
		super(req, numOfPage, pageNum, recordPerPage, items);
	}
}
