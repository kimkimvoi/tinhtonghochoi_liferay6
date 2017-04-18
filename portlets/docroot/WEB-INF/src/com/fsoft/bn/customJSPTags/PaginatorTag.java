package com.fsoft.bn.customJSPTags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.fsoft.bn.util.CommonUtil;
import com.fsoft.bn.util.Validator;
public class PaginatorTag extends SimpleTagSupport {
	private final int pageRange = 3;
	private int numOfPage;
	private String tableId;
	private String prevIcon;
	private String nextIcon;
	private String firstPageIcon;
	private String lastPageIcon;
	private String curPageStatusText;
	private String itemsPerPageText;
	private String numPerPage;

	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();  
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String pagingDivId = tableId + "_pagingDiv";
		String tagContent = "<div id='" + pagingDivId + "' style='padding:5px;' ><b>";
		String curPageId = tableId + "_curPageNum";
		String curPageStatusId = tableId + "_curPageStatus";
		String curPageTextId = tableId + "_curPageText";
		String pageNumId = tableId + "_pageNum";
		String totalPageStatusId = tableId + "_totalPageStatus";
		String nextPageButtonId = tableId + "_nextPageButton";
		String lastPageButtonId = tableId + "_lastPageButton";
		String prevPageButtonId = tableId + "_prevPageButton";
		String firstPageButtonId = tableId + "_firstPageButton";
		String itemsPerPageId = tableId + "_itemsPerPageInput";
		String itemsPerPageCurValId = tableId + "_itemsPerPageCurValId";
		String pageRangeId = tableId + "_pageRangeId";
		String tableMsgId = tableId + "_tableMsgId";
		
		if (numOfPage <= 0) {
			tagContent = "<div id='" + pagingDivId + "' style='padding:5px;display:none;' ><b>";
		}
		
		//build items per page status
		if (!Validator.isBlankOrNull(itemsPerPageText)) {
			if (Validator.isBlankOrNull(numPerPage)) {
				numPerPage = "1";
			}
			
			tagContent += "<span style='margin-right: 5px;'>" + itemsPerPageText + "</span>";
			tagContent += "<input type='hidden' id='" + itemsPerPageCurValId + "' value='" + numPerPage + "' </input>";
			tagContent += "<select style='width: 42px!important;margin-right: 10px;' id='" + itemsPerPageId + "' onchange=\"updateItemsPerPageNum(this, '" +tableId + "', '" + curPageId + "')\">";
			
			for(int i=1; i<=10; i++) {
				// 2014/02/27: Fix bug FIBIXBP-116
				// - Incorrect display number of records selected on pagination results
				//tagContent += "<option value='" + i*5 + "'>" + i*5 + "</option>";
				tagContent += "<option value='" + i*5 + "' "+ ((i*5 == Integer.valueOf(numPerPage)) ? "selected='selected'" : "") + ">" + i*5 + "</option>";
			}
			
			tagContent += "</select>";
		}
		
		//build current page status
		tagContent += "<span id='" + curPageStatusId + "' style='margin-right: 20px;' >"
				+ curPageStatusText
				+ " <span id='" + curPageTextId + "' >"
				+ "1</span>/<span id='" + totalPageStatusId + "'>" + numOfPage + "</span></span>";

		//build first page icon
		tagContent += "<span id='" + firstPageButtonId + "'>";
		if (numOfPage > 1) {
			tagContent += "<span id=\"firstPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'>|<</span>";
		}
		tagContent += "</span>";

		//build previous page icon
		tagContent += "<span id='" + prevPageButtonId + "'>";
		if (numOfPage > 1) {
			tagContent += "<span id=\"previousPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'><</span>";
		}
		tagContent += "</span>";

		//build page number
		tagContent += "<span id='" + pageNumId + "s'>";
		if (numOfPage > 0) {
			int displayedNumOfPage = (numOfPage < pageRange) ? numOfPage : pageRange;
			for (int i=1; i <= displayedNumOfPage; i++) {
				if (i == 1) {
					tagContent += "<span id='" + pageNumId + i + "' class='pagingNumber activePage disabled' style='cursor: pointer;' onClick=\"getPage('" + tableId + "', this, 'page" + i + "', '" + curPageId + "')\" >" + i
							+ "<input type=\'hidden\' id=\'page" + i + "\' value=\'" + i + "\'/>"
							+ "</span>";
				} else {
					tagContent += "<span id='" + pageNumId + i + "' class='pagingNumber' style='cursor: pointer;' onClick=\"getPage('" + tableId + "', this, 'page" + i + "', '" + curPageId + "')\" >" + i
							+ "<input type=\'hidden\' id=\'page" + i + "\' value=\'" + i + "\'/>"
							+ "</span>";
				}
			}
			
			if (numOfPage > pageRange) {
				tagContent += " . . . ";
			}
		}
		tagContent += "</span>";
		tagContent += "<span id='" + nextPageButtonId + "'>";
		
		//build next page icon
		if (numOfPage > 1) {
			tagContent += "<span id=\"nextPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getNextPage('" +tableId + "', '" + curPageId + "', '" + numOfPage + "')\">></span>";
		}
		tagContent += "</span>";

		//build last page icon
		tagContent += "<span id='" + lastPageButtonId + "'>";
		if (numOfPage > 1) {
			tagContent += "<span id=\"lastPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getLastPage('" +tableId + "', '" + curPageId + "', '" + numOfPage + "')\">>|</span>";
		}
		tagContent += "</span>";

		//build input hidden tag to store current page number
		tagContent += "<input id='" + curPageId + "' type='hidden' value='1' />";
		
		//build input hidden tag to store page range
		tagContent += "<input id='" + pageRangeId + "' type='hidden' value='" + pageRange + "' />";
		tagContent += "</b></div>";
		
		//build table message span
		if (numOfPage <= 0) {
			String msg = CommonUtil.getText(request, "common.msg.noSearchResult");
			tagContent += "<div id='" + tableMsgId + "' style='text-align:center;'>" + msg + "</div>";
		} else {
			tagContent += "<div id='" + tableMsgId + "' style='text-align:center;'></div>";
		}
		out.println(tagContent);
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getPrevIcon() {
		return prevIcon;
	}

	public void setPrevIcon(String prevIcon) {
		this.prevIcon = prevIcon;
	}

	public String getNextIcon() {
		return nextIcon;
	}

	public void setNextIcon(String nextIcon) {
		this.nextIcon = nextIcon;
	}

	public String getFirstPageIcon() {
		return firstPageIcon;
	}

	public void setFirstPageIcon(String firstPageIcon) {
		this.firstPageIcon = firstPageIcon;
	}

	public String getLastPageIcon() {
		return lastPageIcon;
	}

	public void setLastPageIcon(String lastPageIcon) {
		this.lastPageIcon = lastPageIcon;
	}

	public String getCurPageStatusText() {
		return curPageStatusText;
	}

	public void setCurPageStatusText(String curPageStatusText) {
		this.curPageStatusText = curPageStatusText;
	}

	public String getItemsPerPageText() {
		return itemsPerPageText;
	}

	public void setItemsPerPageText(String itemsPerPageText) {
		this.itemsPerPageText = itemsPerPageText;
	}

	public String getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(String numPerPage) {
		this.numPerPage = numPerPage;
	}

}