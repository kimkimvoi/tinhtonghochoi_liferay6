<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"  description="Create paging html markup, new page will be loaded using Ajax"%>
<%@tag import="org.apache.commons.lang.RandomStringUtils"%>
<%@tag import="org.apache.commons.lang.StringUtils"%>
<%@tag import="com.fsoft.bn.util.GsonUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ attribute name="renderPageJsFunction" required="true" description="javascript callback function name to render page after receive data from pageLoadURL Ajax call, 
in format 'function renderXYZ(data,cssSelector)' with data is js object corresponding to dataObject in java, cssSelector is the CSS selector of wrapper html element for page content"%>
<%@ attribute name="pageWrapperCSSSelector" required="true" description="CSS selector of wrapper html element for page content, for example '#someId'"%>
<%@ attribute name="loadPageURL" description="URL for load page, can either set in the data object or set directly here"%>
<%@ attribute name="dataObject"
	description="Object contain model data for default open page, must be an instance of com.fsoft.bn.domain.Page subclass. If not set, paging tag will automatically load 1st page"
	type="com.fsoft.bn.domain.Page"%>
<%@ attribute name="loadingClass" description="Loading indicator CSS class"%>
<%
if (StringUtils.isBlank(loadPageURL) && dataObject != null){
	loadPageURL = dataObject.getLoadPageURL();
}

if (StringUtils.isBlank(loadPageURL) ){
	throw new RuntimeException(" Page load URL can not be empty, either specify it through tag declaration or data object");
} 
%>
<c:set value="<%= RandomStringUtils.randomAlphabetic(10)%>" var="idVal"></c:set>
<div id="${idVal}"> </div>
<script type="text/javascript">
	 ${idVal} = <%=dataObject != null ? GsonUtils.toJson(dataObject) :  "{}"%> ;
	 ${idVal}.loadPageURL = '<%= loadPageURL %>';
	 ${idVal}.id = '${idVal}';
	 ${idVal}.renderPageJsFunction = '${renderPageJsFunction}';
	 ${idVal}.pageWrapperCSSSelector = '${pageWrapperCSSSelector}';
	 ${idVal}.loadingClass= '<%= StringUtils.isNotBlank(loadingClass) ? loadingClass : "pagingLoadingIndicator_default" %>';
	 ${idVal}.contextPath= '${contextPath}';
	 
	 renderPageAndPaginator_new(${idVal});
</script>