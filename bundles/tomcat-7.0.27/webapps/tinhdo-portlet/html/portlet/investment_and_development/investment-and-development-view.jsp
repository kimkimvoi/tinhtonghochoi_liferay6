<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<form id="investment_and_development_form">
	<div class="investment_and_development content">
		<div>
			<c:choose>
				<c:when test="${investmentAndDevelopmentModel.keyProject ==1}">
					<h2 class="title_tab"><label><liferay-ui:message key="portlet.investmentanddevelopment.header.investmenent.title" /></label></h2>
				</c:when>
				<c:otherwise>
					<h2 class="title_tab"><label><liferay-ui:message key="portlet.investmentanddevelopment.header.keyproject.title" /></label></h2>
				</c:otherwise> 
			</c:choose> 
			
		</div>
			<ul class="investment_and_development">
				<li>
					<div style="display:none" id="MSG_ERROR" class="portlet-msg-error"><liferay-ui:message key="common.msg.error" /></div>
				<li>
					<div class="investment_and_development_text_search">
					    <label><liferay-ui:message key="common.questionAnswer.questionkeyword"/></label><br/>
					    <input id="textQuestionSearch" class="input_text" type="text" value="${investmentAndDevelopmentModel.keyWordSearch}"/>
						<input id="investmentAndDevelopmentSearch_Button"type="button" 
						value="<liferay-ui:message key="common.questionAnswer.button.search"/>" />
					    <portlet:resourceURL var="investmentAndDevelopment_Search" escapeXml="false" id="investmentAndDevelopment_Search" />					
						<input type="hidden" id="investmentAndDevelopment_SearchURL" 
							value="<%=renderResponse.encodeURL(investmentAndDevelopment_Search.toString()) %>"/>
					</div>
				<li>	
					<div class="investment_and_development_list">
						<cus:table id="investmentAndDevelopmentTable" 
							dataList="${investmentAndDevelopmentModel.listInvestmentProjects}" 
							displayedPropertyList="${investmentAndDevelopmentModel.investmentPropertyDisplay}" 
							headerClass="title" 
							headers="${investmentAndDevelopmentModel.headerList}" 
							indicatorList="${indicatorList}" 
							contextPath="${pageContext.request.contextPath}" />
						<cus:paginator curPageStatusText="${investmentAndDevelopmentModel.curPageStatusText}"
							numOfPage="${investmentAndDevelopmentModel.numOfPage}" tableId="investmentAndDevelopmentTable" 
							itemsPerPageText="${investmentAndDevelopmentModel.itemsPerPageText}" 
							numPerPage="${investmentAndDevelopmentModel.numPerPage}"/>
						<portlet:resourceURL var="investmentAndDevelopmentTable_LoadPage" escapeXml="false" id="investmentAndDevelopmentTable_LoadPage" />					
						<input id="investmentAndDevelopmentTable_loadPageURL" 				type="hidden" value="<%=renderResponse.encodeURL(investmentAndDevelopmentTable_LoadPage.toString()) %>"/>
						<input id="investmentAndDevelopmentTable_loadPageURL" 				type="hidden" value="<%=renderResponse.encodeURL(investmentAndDevelopmentTable_LoadPage.toString()) %>" />
						<input id="investmentAndDevelopmentTable_headerList" 				type="hidden" value="${investmentAndDevelopmentModel.headerList}" />
						<input id="investmentAndDevelopmentTable_displayedPropertyList" 	type="hidden" value="${investmentAndDevelopmentModel.investmentPropertyDisplay}" />
						<input id="investmentAndDevelopmentTable_headerClass" 				type="hidden" value="title" />
						<input id="investmentAndDevelopmentTable_investmentAndDevelopmentList" type="hidden" value='${investmentAndDevelopmentListJson}' />
					</div>
			</ul>
		</div>
	<input id="label_investamount" 		type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.investamount"/>" />
	<input id="label_category" 			type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.category"/>" />
	<input id="label_usd" 				type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.usd"/>" />
	<input id="label_vnd" 				type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.vnd"/>" />
	<input id="label_chartercapitar" 	type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.chartercapitar"/>" />
	<input id="label_localtion" 		type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.localtion"/>" />
	<input id="label_timeprocess" 		type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.timeprocess"/>" />
	<input id="label_target" 			type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.target"/>" />
	<input id="label_attachfile" 		type="hidden" value="<liferay-ui:message key="portlet.investmentanddevelopment.attachfile"/>" />
	<input id="language" 				type="hidden" value="${investmentAndDevelopmentModel.language}" />
</form>