<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<div class="investment_and_development_list">
	<cus:table id="legalDocumentTable"
		dataList="${legalDocumentList}"
		displayedPropertyList="${listPropertyDisplay}"
		headerClass="title"
		headers="${listHeaderDisplay}" />
	<cus:paginator
		curPageStatusText="${curPageStatusText}"
		numOfPage="${numOfPage}"
		tableId="legalDocumentTable"
		itemsPerPageText="${itemsPerPageText}"
		numPerPage="${numPerPage}" />
	<%-- 
	<portlet:resourceURL var="legalDocumentTable_LoadPage"
		escapeXml="false" id="legalDocumentTable_LoadPage" />
	<input id="investmentAndDevelopmentTable_loadPageURL" type="hidden"
		value="<%=renderResponse.encodeURL(legalDocumentTable_LoadPage.toString()) %>" />
	<input id="investmentAndDevelopmentTable_loadPageURL" type="hidden"
		value="<%=renderResponse.encodeURL(legalDocumentTable_LoadPage.toString()) %>" />
	<input id="legalDocumentTable_headerList" type="hidden"
		value="${investmentAndDevelopmentModel.headerList}" /> <input
		id="legalDocumentTable_displayedPropertyList" type="hidden"
		value="${listPropertyDisplay}" />
	<input id="legalDocumentTable_headerClass" type="hidden"
		value="title" /> --%>
</div>
