<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/html/common/init.jsp" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>

<portlet:defineObjects />

<div class="box_question">
    <h3 class="padding5"><strong><liferay-ui:message key="portlet.answeredquestions.header.portletheader" />:</strong></h3>
        <div class="rowa">
        	<liferay-ui:message key="common.questionAnswer.questiontype" /><br />
			<aui:select id="questionTypes" name="">
				<aui:option value="-1" label="portlet.common.form.dropdownlist.alloption" />
		        <c:forEach items="${questionTypeList}" var="questionTypeList">
		            <aui:option value="${questionTypeList.key}" label="${questionTypeList.value}" />
		        </c:forEach>
		    </aui:select>
        </div>
<div class="rowb">
	<liferay-ui:message key="common.questionAnswer.questionkeyword" /><br />
	<input id="answeredQuestionKeyWord" class="input_text" type="text" onkeypress="searchKeyPress(event);"/>
 	<input id="answeredQuestionSearchButton" type="button" value="<liferay-ui:message key="common.questionAnswer.button.search" />" />
</div>
<portlet:resourceURL escapeXml="false" id="answeredQuestionTable_Search" var="answeredQuestionTable_Search" />
<input id="answeredQuestionTable_SearchURL" type="hidden" value="<%=renderResponse.encodeURL(answeredQuestionTable_Search.toString()) %>" />

<cus:table id="answeredQuestionTable" dataList="${questionList}" displayedPropertyList="${displayedPropertyList}" headerClass="title" headers="${headerList}" 
	hiddenPropertyList="${hiddenPropertyList}" indicatorList="${indicatorList}" contextPath="${pageContext.request.contextPath}"/>
<cus:paginator curPageStatusText="${curPageStatusText}" numOfPage="${numOfPage}" tableId="answeredQuestionTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
<portlet:resourceURL escapeXml="false" id="answeredQuestionTable_LoadPage" var="answeredQuestionTable_LoadPage" />
<input id="answeredQuestionTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(answeredQuestionTable_LoadPage.toString()) %>" />
<input id="answeredQuestionTable_headerList" type="hidden" value="${headerList}" />
<input id="answeredQuestionTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
<input id="answeredQuestionTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
<input id="answeredQuestionTable_headerClass" type="hidden" value="title" />

<input id="answeredQuestionTable_questionList" type="hidden" value='${questionListJson}' />
<input id="answeredQuestionTable_answerList" type="hidden" value='${answerList}' />
<input id="answerAttachFiles" type="hidden" name="answerAttachFiles" value='${answerAttachFiles}'/>
<input id="questionAttachFiles" type="hidden" name="questionAttachFiles" value='${questionAttachFiles}'/>
</div>
