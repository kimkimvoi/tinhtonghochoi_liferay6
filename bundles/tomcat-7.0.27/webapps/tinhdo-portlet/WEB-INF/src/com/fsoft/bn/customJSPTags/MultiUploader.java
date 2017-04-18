package com.fsoft.bn.customJSPTags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
/**
 * 
 * @author SonNT18
 *
 */
public class MultiUploader extends SimpleTagSupport {
	/** logger */
	private static Logger logger = Logger.getLogger(MultiUploader.class);
	/** name to get value on server*/
	private String tagName;
	/** hidden field contain file name*/
	private String hiddenTagName;
	/** mime type*/
	private String mimeType;
	/** label add file*/
	private String labelAddFile;
	
	/**
	 * @author VangND1
	 * @throws
	 */
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		String contextPath = getContextPath();
		labelAddFile = Validator.isBlankOrNull(labelAddFile) ? (CommonUtil.getText(
				((PageContext) getJspContext()).getRequest(), "portlet.common.form.add.attach.file")) : labelAddFile;
		try {
			String tagContent = "<input type=\"hidden\" name=\"" + hiddenTagName + "\"/>"
					+ " <input name=\"" + tagName + "\" type=\"file\""
					+ " onchange=\"setFileNameToHiddenField(this,this.value)\" onblur=\"isValidFile(this, this.value ,'"
					+ mimeType + "')\"  class=\"multi-uploader\"  />"
					+ "<span style=\"display:block;\">" 
					+ "<span class=\"btnAddFile\" onclick=\"addFileTag(this ,'" + tagName + "','"
					+ hiddenTagName + "',' " + mimeType + "' )\" > " 
					+ labelAddFile + "</span></span><input type=\"hidden\" id=\"CONTEXT_PATH\" value=\"" 
					+ contextPath + "\"/>";
			out.println(tagContent);
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return the hiddenTagName
	 */
	public String getHiddenTagName() {
		return hiddenTagName;
	}

	/**
	 * @param hiddenTagName the hiddenTagName to set
	 */
	public void setHiddenTagName(String hiddenTagName) {
		this.hiddenTagName = hiddenTagName;
	}

	/**
	 * @return the labelAddFile
	 */
	public String getLabelAddFile() {
		return labelAddFile;
	}

	/**
	 * @param labelAddFile the labelAddFile to set
	 */
	public void setLabelAddFile(String labelAddFile) {
		this.labelAddFile = labelAddFile;
	}
	/**
	 * get context path
	 * @return String
	 * @author VangND1
	 */
	public String getContextPath() {
		return ((HttpServletRequest) ((PageContext) getJspContext()).getRequest()).getContextPath();
	}
	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
}
