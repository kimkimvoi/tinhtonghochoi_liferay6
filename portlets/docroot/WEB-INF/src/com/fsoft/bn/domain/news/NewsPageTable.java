package com.fsoft.bn.domain.news;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.fsoft.bn.portlet.news.NewsContants.XSD_ELEMENT_NAME;
import com.fsoft.bn.util.PortalUtil;

public class NewsPageTable extends NewsPage {

	private static final long serialVersionUID = 516065907939745804L;
	/** logger */
	private static Logger logger = Logger.getLogger(NewsPageTable.class);
	private List<String> detailTableFields;
	
	private String portalURL;

	public NewsPageTable(NewsPage newsPage, PortletRequest rq) {
		try {
			BeanUtils.copyProperties(this, newsPage);
			setPortalURL(PortalUtil.getThemeDisplay(rq).getPortalURL());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public List<String> getDetailTableFields() {
		return detailTableFields;
	}

	public void setDetailTableFields(List<String> detailTableFields) {
		this.detailTableFields = detailTableFields;
	}

	public void updateConfig(NewsListTableConfig config) {
		super.updateConfig(config);
		List<String> detailTableFields2 = new ArrayList<String>(config.getDetailTableFields());
		Iterator<String> it = detailTableFields2.iterator();
		for (; it.hasNext();) {
			String entry = it.next();
			if (entry.equalsIgnoreCase(XSD_ELEMENT_NAME.CONTENT) || entry.equalsIgnoreCase(XSD_ELEMENT_NAME.SOURCE)
					|| entry.equalsIgnoreCase(XSD_ELEMENT_NAME.AUTHOR)) {
				it.remove();
			}
		}
		setDetailTableFields(detailTableFields2);
	}

	/**
	 * @return the portalURL
	 */
	public String getPortalURL() {
		return portalURL;
	}

	/**
	 * @param portalURL the portalURL to set
	 */
	public void setPortalURL(String portalURL) {
		this.portalURL = portalURL;
	}
}
