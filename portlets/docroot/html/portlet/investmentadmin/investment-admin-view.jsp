<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/html/common/init.jsp" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>

<portlet:defineObjects />

<div class="box_investment_projects_admin">

<form id="investmentProjectSearchForm">
	<table class="tableWithoutBorder">
		<tr>
			<td>
				<label> <liferay-ui:message key="portlet.investmentadmin.form.investmentotal"/></label>
			</td>
			<td>
				<label><liferay-ui:message key="common.questionAnswer.questionkeyword" /></label>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="text" type="text" name="searchTotalInvestmentMin"></input> ~ <input type="text" name="searchTotalInvestmentMax"></input>
				<select name="searchCurrencyTypeId">
					<option value="-1"><liferay-ui:message key="portlet.common.form.dropdownlist.alloption" /></option>
					<c:forEach items="${currency}" var="item">
			            <aui:option value="${item.key}" label="${item.value}" />
			        </c:forEach>
				</select>
			</td>
			<td>
				<input name="investmentProjectSearchKeyWord" class="input_text" type="text" />
			 	<input id="investmentProjectSearchButton" type="button" value="<liferay-ui:message key="common.questionAnswer.button.search" />" />
			 	<portlet:resourceURL escapeXml="false" id="investmentProjectTable_Search" var="investmentProjectTable_Search" />
				<input id="investmentProjectTable_SearchURL" type="hidden" value="<%=renderResponse.encodeURL(investmentProjectTable_Search.toString()) %>" />
			</td>
		</tr>
	</table>
</form>


<br/>
<cus:table id="investmentProjectTable" dataList="${projectList}" displayedPropertyList="${displayedPropertyList}" headerClass="title" headers="${headerList}" 
	hiddenPropertyList="${hiddenPropertyList}" />
<cus:paginator curPageStatusText="${curPageStatusText}" numOfPage="${numOfPage}" tableId="investmentProjectTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
<portlet:resourceURL escapeXml="false" id="investmentProjectTable_LoadPage" var="investmentProjectTable_LoadPage" />
<input id="investmentProjectTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(investmentProjectTable_LoadPage.toString()) %>" />
<input id="investmentProjectTable_headerList" type="hidden" value="${headerList}" />
<input id="investmentProjectTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
<input id="investmentProjectTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
<input id="investmentProjectTable_headerClass" type="hidden" value="title" />

<br/>
<input type="button" id="addNewProjectBtn" value="<liferay-ui:message key="common.button.addnew" />"/>
<br/><br/>


<div id="addNewInvestmentProjectDiv" style="display:none;">
	
	<portlet:actionURL name="addNewInvestmentProject" var="addNewInvestmentProjectUrl" />
	<aui:form action="${addNewInvestmentProjectUrl}" method="POST">
		<fieldset>
			<legend>
				<h2 id="addNewProjectFormHeader" style="display:none;"><liferay-ui:message key="portlet.investmentadmin.title.addnewprojectform" /></h2>
				<h2 id="editProjectFormHeader" style="display:none;"><liferay-ui:message key="portlet.investmentadmin.title.editprojectform" /></h2>
			</legend>
			
			<table id="projectDetailsTable" class="tableWithoutBorder">
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.projectname" />:</label></td>
				<td>
					<aui:input type="text" name="projectName" label="">
						<aui:validator name="required" errorMessage="portlet.common.validator.required" />
					</aui:input>
					<input type="hidden" name="selectedProjectId" id="selectedProjectId" />
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.investmentotal" />:</label></td>
				<td>
					<aui:input type="text" name="totalInvestmentMin" label=""> 
						<aui:validator name="required" errorMessage="portlet.common.validator.required" />
						<aui:validator name="number" errorMessage="portlet.common.validator.number" />
					</aui:input>
					~ 
					<aui:input type="text" name="totalInvestmentMax" label="">
						<aui:validator name="required" errorMessage="portlet.common.validator.required" />
						<aui:validator name="number" errorMessage="portlet.common.validator.number" />
					</aui:input>
					<select name="currencyTypeId">
						<c:forEach items="${currency}" var="item">
				            <aui:option value="${item.key}" label="${item.value}" />
				        </c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.implementlocation" />:</label></td>
				<td><input type="text" name="implementationLocation" /></td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.starttime" />:</label></td>
				<td>
					<liferay-ui:input-date formName="startTime" yearRangeStart="1950" yearRangeEnd="2100"  dayParam="startDay" monthParam="startMonth" yearParam="startYear"/>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.endtime" />:</label></td>
				<td>
					<liferay-ui:input-date formName="endTime" yearRangeStart="1950" yearRangeEnd="2100"  dayParam="endDay" monthParam="endMonth" yearParam="endYear" />
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.projectpurpose" />:</label></td>
				<td>
					<aui:input type="textarea" name="projectPurpose" rows="3" cols="30" placeholder="portlet.common.form.textarea.placeholder" />
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.chartercapital" />:</label></td>
				<td>
					<aui:input type="text" name="charterCapital" label=""> 
						<aui:validator name="required" errorMessage="portlet.common.validator.required" />
						<aui:validator name="number" errorMessage="portlet.common.validator.number" />
					</aui:input>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.projectcategory" />:</label></td>
				<td>
					<select name="projectCategoryId">
						<option value=""><liferay-ui:message key="portlet.common.form.dropdownlist.firstoption" /></option>
						<c:forEach items="${projectCategory}" var="item">
				            <aui:option value="${item.key}" label="${item.value}" />
				        </c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.investmentform" />:</label></td>
				<td>
					<select name="investmentFormId">
						<option value="-1"><liferay-ui:message key="portlet.common.form.dropdownlist.firstoption" /></option>
						<c:forEach items="${investmentForm}" var="item">
				            <aui:option value="${item.key}" label="${item.value}" />
				        </c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.competentorganization" />:</label></td>
				<td>
					<select name="competentOrganizationId">
						<option value="-1"><liferay-ui:message key="portlet.common.form.dropdownlist.firstoption" /></option>
						<c:forEach items="${competentOrganization}" var="item">
				            <aui:option value="${item.key}" label="${item.value}" />
				        </c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.keyproject" />:</label></td>
				<td><input type="checkbox" name="keyProject" /></td>
			</tr>
			
			<tr>
				<td class="textAlignRight"><label ><liferay-ui:message key="portlet.investmentadmin.form.technicalspecifications" />:</label></td>
				<td>
					<aui:input type="textarea" name="technicalSpecifications" rows="3" cols="30" placeholder="portlet.common.form.textarea.placeholder" />
				</td>
			</tr>
			
			<tr>
			<td colspan="2" style="text-align:center;">
				<input type="submit" value="<liferay-ui:message key="common.button.save" />"/>
				<input type="button" id="cancelBtn" value="<liferay-ui:message key="common.button.cancel" />"/>
			</td>
			</tr>
			
			</table>
		</fieldset>
	</aui:form>
	
	
	<portlet:resourceURL escapeXml="false" id="investmentProject_LoadDetail" var="investmentProject_LoadDetail" />
	<input id="investmentProject_LoadDetailURL" type="hidden" value="<%=renderResponse.encodeURL(investmentProject_LoadDetail.toString()) %>" />
	<input type="hidden" id="portletNameSpace" value="<portlet:namespace />" />
</div>
</div>









