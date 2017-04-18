<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp" %>

<%@include file="/html/portlet/admin_qa_management/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<portlet:defineObjects />
<portlet:actionURL name="updateAnswer" var="updateAnswerUrl" />
<aui:form action="${updateAnswerUrl}" method="POST" enctype="multipart/form-data" name="questionSubmit"  >


		<%-- <portlet:resourceURL escapeXml="false" id="updateAnswer" var="updateAnswer"/>
		<input id="updateAnswer_URL" type="hidden" value="<%=renderResponse.encodeURL(updateAnswer.toString()) %>" /> --%>
		
		<%-- this is url call ajax function reject question --%>
		<portlet:resourceURL escapeXml="false" id="rejectQuestion" var="rejectQuestion" />
		<input id="rejectQuestion_URL" type="hidden" value="<%=renderResponse.encodeURL(rejectQuestion.toString()) %>" />
		
		<%-- this is url call ajax function revert question --%>
		<portlet:resourceURL escapeXml="false" id="revertQuestion" var="revertQuestion" />
		<input id="revertQuestion_URL" type="hidden" value="<%=renderResponse.encodeURL(revertQuestion.toString()) %>" />
		
	<div class="admin_qa_management">
	
		<div class="question_list">
			<div style="display:none" id="result"></div>
			<ul>
				<li>
					<div>
						<div class="questionTypeSelecetion">
							<label class ="label"> <liferay-ui:message key="common.questionAnswer.questiontype"/></label> 
							<aui:select name="" label="" id="questionSelected" >
								<aui:option value="${adminQaManaModel.defaultCombobox.key}" label="${adminQaManaModel.defaultCombobox.value}"
									selected="${adminQaManaModel.defaultCombobox.key == adminQaManaModel.questionTypeSelected}"/>
						        <c:forEach items="${adminQaManaModel.listQuestionType}" var="quesType">
						            <aui:option value="${quesType.key}" label="${quesType.value}" 
						            	selected="${quesType.key == adminQaManaModel.questionTypeSelected}"/>
						        </c:forEach>
						    </aui:select>
					    </div>
					    <div class="questionStatusSelection">
						    <label class ="label"> <liferay-ui:message key="common.questionAnswer.questionstatus"/></label> 
						    <aui:select name="" label="" id="questionStatus">
						   		<aui:option value="${adminQaManaModel.defaultCombobox.key}" label="${adminQaManaModel.defaultCombobox.value}"
						            selected="${adminQaManaModel.defaultCombobox.key == adminQaManaModel.questionStatusSelected}" />
						        <c:forEach items="${adminQaManaModel.listQuestionStatus}" var="quesSts">
						            <aui:option value="${quesSts.key}" label="${quesSts.value}"
						            selected="${quesSts.key == adminQaManaModel.questionStatusSelected}" />
						        </c:forEach>
						    </aui:select>
					    </div>
				    </div>
			    <li>
				    <div class="questionTextSearch">
					    <label class ="label"><liferay-ui:message key="common.questionAnswer.questionkeyword"/></label><br/>
					    <input id="textQuestionSearch" class="input_text" type="text" value="${adminQaManaModel.questionTextSearch}" onkeypress="searchKeyPress(event);"/>
						<input id="questionSearchButton"type="button" value="<liferay-ui:message key="common.questionAnswer.button.search"/>" onclick="false;"/>
					</div>
				<li>
					<portlet:resourceURL escapeXml="false" id="answeredQuestionTable_Search" var="answeredQuestionTable_Search" />
					<input id="answeredQuestionTable_SearchURL" type="hidden" value="<%=renderResponse.encodeURL(answeredQuestionTable_Search.toString()) %>" />
					<cus:table id="answeredQuestionTable" dataList="${adminQaManaModel.questionList}" 
							displayedPropertyList="${adminQaManaModel.displayedPropertyList}" headerClass="title" 
							headers="${adminQaManaModel.headerList}"  
							hiddenPropertyList="${adminQaManaModel.hiddenPropertyList}" contextPath="${pageContext.request.contextPath}"/>
					<cus:paginator curPageStatusText="${adminQaManaModel.curPageStatusText}" 
						numOfPage="${adminQaManaModel.numOfPage}" tableId="answeredQuestionTable" 
						itemsPerPageText="${adminQaManaModel.itemsPerPageText}" 
						numPerPage="${adminQaManaModel.questionPerPage}"/>
					<portlet:resourceURL escapeXml="false" id="answeredQuestionTable_LoadPage" var="answeredQuestionTable_LoadPage" />
					<input id="answeredQuestionTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(answeredQuestionTable_LoadPage.toString()) %>" />
					<input id="answeredQuestionTable_headerList" type="hidden" value="${adminQaManaModel.headerList}" />
					<input id="answeredQuestionTable_displayedPropertyList" type="hidden" value="${adminQaManaModel.displayedPropertyList}" />
					<input id="answeredQuestionTable_hiddenPropertyList" type="hidden" value="${adminQaManaModel.hiddenPropertyList}" />
					<input id="answeredQuestionTable_headerClass" type="hidden" value="title" />
					<input id="answeredQuestionTable_questionList" type="hidden" value='${questionListJson}' />
					<input id="answeredQuestionTable_answerList" type="hidden" value='${answerList}' />
			</ul>
		</div>
		<div class="details" id="details">
			<div class="ques_detail">
				<ul>
					<li>
						<table>
							<tr>
								<td class="questionDetailLabel">
									<label class ="label"> <liferay-ui:message key="portlet.questionLists.citizen_name"/></label> 
								</td>
								<td>
									<label id="citizenName"></label>
								</td>
							</tr>
							<tr>
								<td>
									<label class ="label"> <liferay-ui:message key="portlet.questionLists.citizen_add"/></label>
								</td>
								<td>
									<label id="citizenAdd"></label>
								</td>
							</tr>
							<tr>
								<td>
									<label class ="label"> <liferay-ui:message key="portlet.questionLists.ques_title"/></label> 
								</td>
								<td>
									<label id="quesTitle"></label>
								</td>								
							</tr>
							<tr>
								<td>
									<label class ="label"> <liferay-ui:message key="portlet.common.form.attachedFile"/>:</label> 
								</td>
								<td>
									<div class="questionAttachFiles" >						
									</div>	
								</td>
							</tr>
						</table>
					<li>
						<label class ="label labelQuestionContent"><liferay-ui:message key="portlet.questionLists.ques_content"/></label> <br/>
	            		<div id="questionContent"></div>
				</ul>
			</div>
			<br/>
			<div class="answer_detail" >
				<ul>
					<li>
					<label class ="label"> <liferay-ui:message key="portlet.questionLists.ques_answer"/></label> <br/>
					<li>
					<label class ="label"> <liferay-ui:message key="portlet.common.form.attachedFile"/>:</label> <br/>
						<cus:mutil-uploader tagName="attachedFile" hiddenTagName="attachedFileName" mimeType="docx,png,jpg,xls,xlsx"/>		
					<%-- <aui:input name="attachedFile" label="" type="file" onChange="setFileNameToHiddenField(this.value)">
						<aui:validator name="acceptFiles">
						    'doc, docx , xls , xlsx , jpg , png , txt , gif, pdf'
						</aui:validator>
					</aui:input> --%>
					<li>
					<div class="answerAttachFiles" >						
					</div>
					<li>
					<liferay-ui:input-editor name="answerContent">
						<%-- <aui:validator errorMessage="portlet.common.validator.required"  name="required"/> --%>
					</liferay-ui:input-editor> 
					<script type="text/javascript">
			            function <portlet:namespace />initEditor() {
			            }
            		</script>
				</ul>
			</div> 
			<div class="button_area">
				<input type="submit" id ="submitButton" value="<liferay-ui:message key="portlet.questionLists.button.submit"/>"/>
				<input type="button" id ="rejectButton" value="<liferay-ui:message key="portlet.questionLists.button.reject"/>"/>
				<input type="button" id ="revertButton" value="<liferay-ui:message key="portlet.questionLists.button.revert"/>"/>
				<input type="button" id ="cancelButton" value="<liferay-ui:message key="portlet.questionLists.button.close"/>"/>
			</div>
		</div>
		<input id="questionIdProcess" 	type="hidden" name="questionIdProcess" />
		<input id="answerIdProcess" 	type="hidden" name="answerIdProcess"/>
		<input id="responServer" 		type="hidden" name="responServer" 		value="${responServer}"/>
		<input id="responServerContent" type="hidden" name="responServerContent"value="${responServerContent}"/>
		<input id="answerAttachFiles"   type="hidden" name="answerAttachFiles"	value='${answerAttachFiles}'/>
		<input id="questionAttachFiles" type="hidden" name="questionAttachFiles"value='${questionAttachFiles}'/>
		<input id="msgSuccess" 			type="hidden" name="msgSuccess" 		value ="<liferay-ui:message key="common.msg.success"/>" />
		<input id="msgError" 			type="hidden" name="msgError" 			value ="<liferay-ui:message key="common.msg.error"/>" />
		<input id="msgKeyWord" 			type="hidden" name="msgKeyWord" 		value ="<liferay-ui:message key="common.msg.keyWord"/>" />
		<input id="msgNoresult" 		type="hidden" name="msgNoresult" 		value ="<liferay-ui:message key="common.msg.noresult"/>" />
		<input id="msgSugg" 			type="hidden" name="msgSugg" 			value ="<liferay-ui:message key="common.msg.suggestions"/>" />
		<input id="msgSuggSt" 			type="hidden" name="msgSuggSt" 			value ="<liferay-ui:message key="common.msg.suggestions.first"/>" />
		<input id="msgSuggNd" 			type="hidden" name="msgSuggNd" 			value ="<liferay-ui:message key="common.msg.suggestions.second"/>" />
		<input id="msgSuggRd" 			type="hidden" name="msgSuggRd" 			value ="<liferay-ui:message key="common.msg.suggestions.third"/>" />
		<input id="msgSuggTh" 			type="hidden" name="msgSuggTh" 			value ="<liferay-ui:message key="common.msg.suggestions.fourth"/>" />
		<input id="contextPathAdminQa"	type="hidden" name="contextPathAdminQa" value ="${pageContext.request.contextPath}" />
		<input id="fileNameAttach"		type="hidden" name="fileNameAttach" 	/>
	</div>
</aui:form>