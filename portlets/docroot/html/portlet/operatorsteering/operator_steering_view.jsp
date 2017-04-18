<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />

<div class="operator_steering_box">
	<h2 class="title_tab">
		<label><liferay-ui:message key="${portlertHeaderKey }" /></label>
	</h2>
	<div class="clear"></div>
	<div class="operator_steering_result">
		<cus:table dataList="${operatorSteerings }" displayedPropertyList="${displayedPropertyList }" headerClass="title" headers="${headersList }" id="resultOperatorSteeringTable" hiddenPropertyList="${hiddenPropertyList}"/>
		<cus:paginator curPageStatusText="${curPageStatusText }" numOfPage="${numOfPage}" tableId="resultOperatorSteeringTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
		<portlet:resourceURL escapeXml="false" id="resultOperatorSteeringTable_LoadPage" var="resultOperatorSteeringTable_LoadPage">
		</portlet:resourceURL>
		<input id="resultOperatorSteeringTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(resultOperatorSteeringTable_LoadPage.toString()) %>" />
		<input id="resultOperatorSteeringTable_headerList" type="hidden" value="${headersList}" />
		<input id="resultOperatorSteeringTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
		<input id="resultOperatorSteeringTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
		<input id="resultOperatorSteeringTable_headerClass" type="hidden" value="title" />
		<input id="resultOperatorSteeringTable_curPageId" type="hidden" value="1" />
	</div>
</div>
