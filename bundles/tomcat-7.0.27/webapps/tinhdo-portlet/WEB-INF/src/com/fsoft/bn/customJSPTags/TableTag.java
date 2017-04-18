package com.fsoft.bn.customJSPTags;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.fsoft.bn.util.Validator;
import com.google.gson.Gson;
/**
 * 
 * @author SonNT18
 *
 */
public class TableTag extends SimpleTagSupport {
	public static final String STT = "_stt";
	public static final String AND_PROPERTY_KEY = "&";
	
	/**
	 * table id
	 */
	private String id;
	
	/**
	 * header texts
	 */
	private List<String> headers;
	
	/**
	 * css class for header row
	 */
	private String headerClass;
	
	/**
	 * properties which are displayed on the table
	 */
	private List<String> displayedPropertyList;
	
	/**
	 * properties which are hidden on the table
	 */
	private List<String> hiddenPropertyList;
	
	/**
	 * unknown
	 */
	private List<String> customCellDisplay;
	
	/**
	 * row data list
	 */
	private List<Object> dataList;
	
	/**
	 * indicators to show that the rows are expendable
	 */
	private List<Integer> indicatorList;
	
	/**
	 * context path
	 */
	private String contextPath;

	@SuppressWarnings("unchecked")
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();

		//build table header
		String tagContent = "<table id='" + id + "'><tr class='" + headerClass + "'>";
		int thNum = 1;
		String headerId = "";
		
		for (String header : headers) {
			headerId = id + "_th" + thNum;
			tagContent += "<th id='" + headerId + "'>" + header + "</th>";
			thNum++;
		}

		tagContent += "</tr>";

		//build table rows
		Gson gson = new Gson();
		Map<String, String> objMap = new HashMap<String, String>();
		String json = "";
		String boundTag = "";
		String displayedProperty = "";
		Object propertyValue = "";
		int stt = 0;
		boolean showIndicator = (indicatorList != null) && (!indicatorList.isEmpty());
		
		if (!Validator.isBlankOrNull(dataList)) {
			for (Object obj : dataList) {
				stt++;
				json = gson.toJson(obj);
				objMap = (Map<String, String>) gson.fromJson(json, objMap.getClass());
				
				if(showIndicator) {
					tagContent += "<tr class='dataRow' onclick='toggleIndicator(this)' >";
				} else {
					tagContent += "<tr class='dataRow'>";
				}
				
				//build displayed properties
				for (int i = 0; i < displayedPropertyList.size(); i++) {
					displayedProperty = displayedPropertyList.get(i);
					if (null != customCellDisplay && i < customCellDisplay.size()) {
						boundTag = getCustomCellDisplay().get(i);
					}
					if (STT.equalsIgnoreCase(displayedProperty)) {
						propertyValue = "";
						
						if (showIndicator) {
							tagContent += "<td>" + addIndicator(i, stt) +"</td>";
						} else {
							tagContent += "<td>" + stt +"</td>";
						}
						
					}else {
						String[] displayedPropertySubArray = displayedProperty.split(AND_PROPERTY_KEY);
						propertyValue = objMap.get(displayedPropertySubArray[0]);
						//propertyValue = objMap.get(displayedProperty);
						if(displayedPropertySubArray.length > 1){
							for(int j = 1; j < displayedPropertySubArray.length; j++){
								propertyValue = propertyValue + " " +objMap.get(displayedPropertySubArray[j]);
							}
						}
						if (!Validator.isBlankOrNull(boundTag)) {
							boundTag = boundTag.trim();
							tagContent += "<td><" + boundTag + ">" + propertyValue + "</" + boundTag + "></td>";
						} else {
							if (showIndicator) {
								tagContent += "<td>" + addIndicator(i, propertyValue) +"</td>";
							} else {
								tagContent += "<td>" + propertyValue +"</td>";
							}
						}
					}
				}
				
				//build hidden properties
				tagContent += "<td style='display:none;'>";
				
				if (null != hiddenPropertyList) {
					
					for (String hiddenProperty : hiddenPropertyList) {
						propertyValue = objMap.get(hiddenProperty);				
						tagContent += "<input type='hidden' class='" + hiddenProperty + "' value='" + propertyValue + "'/>";
					}
				}
				
				tagContent += "</td>";
				tagContent += "</tr>";
			}
		}

		tagContent += "</table>";
		tagContent += "<input id='contextPath' type='hidden' value='" + contextPath + "'/>";
		if (showIndicator) {
			tagContent += "<input id='indicatorList' type='hidden' value='" + indicatorList + "'/>";
		}
		out.println(tagContent);
	}

	private String addIndicator(int col, Object tdContent) {
		if (!indicatorList.contains(col)) {
			return String.valueOf(tdContent);
		}
		
		if (Validator.isBlankOrNull(contextPath)) {
			contextPath = "";
		}
		String indicatorImage = "<img class='expandRowIndicator' src='" + contextPath + "/html/images/arrows/bullet-arrow-down-icon.png' alt='+' />"
								+ "<img class='collapseRowIndicator' style='display:none;' src='" + contextPath + "/html/images/arrows/bullet-arrow-up-icon.png' alt='+' />";
		String result = "<table style='border:none' ><tr>";
		result += "<td style='border:none; padding:0px;' >" + tdContent + "</td>";
		result += "<td style='border:none; padding:0px;' width='16px' height='16px' align='right' >" + indicatorImage + "</td>";
		result += "</tr></table>";
		return result;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public String getHeaderClass() {
		return headerClass;
	}

	public void setHeaderClass(String headerClass) {
		this.headerClass = headerClass;
	}

	public List<String> getDisplayedPropertyList() {
		return displayedPropertyList;
	}

	public void setDisplayedPropertyList(List<String> displayedPropertyList) {
		this.displayedPropertyList = displayedPropertyList;
	}

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getHiddenPropertyList() {
		return hiddenPropertyList;
	}

	public void setHiddenPropertyList(List<String> hiddenPropertyList) {
		this.hiddenPropertyList = hiddenPropertyList;
	}

	public List<String> getCustomCellDisplay() {
		return customCellDisplay;
	}

	public void setCustomCellDisplay(List<String> customCellDisplay) {
		this.customCellDisplay = customCellDisplay;
	}

	public List<Integer> getIndicatorList() {
		return indicatorList;
	}

	public void setIndicatorList(List<Integer> indicatorList) {
		this.indicatorList = indicatorList;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}