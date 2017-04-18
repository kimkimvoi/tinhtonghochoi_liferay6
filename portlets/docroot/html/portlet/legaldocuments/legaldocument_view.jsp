<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<portlet:defineObjects />
<portlet:resourceURL var="legalDocsSearchAction" id="legalDocsSearchID"></portlet:resourceURL>
<portlet:resourceURL var="legalDocsGetDetailAction" id="legalDocsGetDetailID"></portlet:resourceURL>
<input type="hidden" id="getDetailsLegalDocAjax_Url" value="${legalDocsGetDetailAction }"/>
<input type="hidden" id="portletNameSpace" value="<portlet:namespace />" />

<div class = "legal_documents">
	<div class="legal_doc_content-padding">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.legaldocument.title"></liferay-ui:message></span>
		</h2>
		<div class="clear"></div>
		<div id = "legal_doc_list_content">
			<!-- search doc -->
			<div class="vbpq-search">
				<form action="" name="legalDocsSearchAction">
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.domain.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<input type="hidden" value="${legalDomailSearch }" id="legalDomailSearch-hidden"> 
							<select name="legalDomailSearch" class="selectbox-search" id="legalDomailSearch" >
								<option value="0">
									<liferay-ui:message key="portlet.search-staff.search.type.selectlegalDomail.value"></liferay-ui:message>
								</option>
								<c:if test="${legalDocsDomailList != null }">
									<c:forEach items="${legalDocsDomailList}" var="legalDocItem">
										<option value="${legalDocItem.key }">
											${legalDocItem.value }
										</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<!-- loai van ban  -->
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.doccategory.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<input type="hidden" value="${legalDocCategorySearch }" id="legalDocCategorySearch-hidden"> 
							<select name="legalDocCategorySearch" class="selectbox-search" id="legalDocCategorySearch">
								<option value="0">
									<liferay-ui:message key="portlet.search-staff.search.type.doccategory.value"></liferay-ui:message>
								</option>
								<c:if test="${legalDocsCategoryList != null }">
									<c:forEach items="${legalDocsCategoryList}" var="legalDocCatetoryItem">
										<option value="${legalDocCatetoryItem.key }">
											${legalDocCatetoryItem.value }
										</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<!-- trich yeu -->
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.abstract.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<input class="textbox-search" id="legalDocs-legalAbstractID" name="legalAbstractSearch" value = "">
						</div>
					</div>
					<!-- nam ban hanh -->
					<%-- <div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.releaseyear.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<input type="hidden" value="${yearPublish }" id = "yearPublish-hidden"> 
							<select name="yearPublish" class="selectbox-search" id="yearPublish">
								<option value="0">
									<liferay-ui:message key="portlet.search-legaldocs.search.releaseyear.value"></liferay-ui:message>
								</option>
								<c:if test="${yearPublishList != null }">
									<c:forEach items="${yearPublishList}" var="yearPublish">
										<option value="${yearPublish}">${yearPublish}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div> --%>
					<!-- ky hieu van ban -->
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.textsymbols.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<input class="textbox-search" id="legalDocs-textSymbolsID" name="textSymbolsSearch" value = "">
						</div>
					</div>
					<!-- start date -->
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.startdatesearch.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<!-- <input class="short_textbox-search" id="legalDocs-startDateSearchID" name="startDateSearchSearch" value = "">
							&nbsp;<span style="font-size: 12px;">(dd-mm-yyyy)</span> -->	
							<liferay-ui:input-date cssClass="inputDateRowA" dayNullable="<%=true%>" monthNullable="<%=true%>" yearNullable="<%=true%>" formName="startTime" yearRangeStart="1950" yearRangeEnd="2100"  dayParam="startDay" monthParam="startMonth" yearParam="startYear"/>			
						</div>
					</div>
					<div class="clear"></div>
					<!-- end date -->
					<div class="legalDocsSearch-contentField">
						<div class="legalDocsSearch-contentRowA">
							<liferay-ui:message key="portlet.search-legaldocs.search.enddatesearch.title"></liferay-ui:message>
						</div>
						
						<div class="legalDocsSearch-contentRowB">
							<!-- <input class="short_textbox-search" id="legalDocs-endDateSearchID" name="endDateSearchSearch" value = "">
							 &nbsp;<span style="font-size: 12px;"> (dd-mm-yyyy)</span> -->
							 <liferay-ui:input-date cssClass="inputDateRowB" dayNullable="<%=true%>" monthNullable="<%=true%>" yearNullable="<%=true%>" formName="endTime" yearRangeStart="1950" yearRangeEnd="2100"  dayParam="endDay" monthParam="endMonth" yearParam="endYear"/>
						</div>
					</div>
					<div class="clear"></div>
					<div class="legalDocsSearch-buttonField">
						<input class="legalDocsSearch-button-search" id="button-legalDoc-searchId" type="button" onclick="legalDocsSearchActionAjax('${legalDocsSearchAction}');" value="<liferay-ui:message key="portlet.search-staff.search.buttonlegalsearch.label"></liferay-ui:message>" />
					</div>
				</form>
			</div>
			<!-- display list legal documents -->
			<div class="clear"></div>
			<div class="list_result">
				<cus:table dataList="${legalDocumentsList }" displayedPropertyList="${displayedPropertyList }" headerClass="title" headers="${headersList }" id="resultSearchLegalDocumentsTable" hiddenPropertyList="${hiddenPropertyList}"/>
				<cus:paginator curPageStatusText="${curPageStatusText }" numOfPage="${numOfPage}" tableId="resultSearchLegalDocumentsTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
				<portlet:resourceURL escapeXml="false" id="resultSearchLegalDocumentsTable_LoadPage" var="resultSearchLegalDocumentsTable_LoadPage">
				</portlet:resourceURL>
				<input id="resultSearchLegalDocumentsTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(resultSearchLegalDocumentsTable_LoadPage.toString()) %>" />
				<input id="resultSearchLegalDocumentsTable_headerList" type="hidden" value="${headersList}" />
				<input id="resultSearchLegalDocumentsTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
				<%-- <input id="resultSearchLegalDocumentsTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" /> --%>
				<input id="resultSearchLegalDocumentsTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
				<input id="resultSearchLegalDocumentsTable_headerClass" type="hidden" value="title" />
			</div>
			<input id= "getDetailLegalDocUrl" type = "hidden" value="${legalDocsGetDetailAction}">
		</div>
		
		<div id="legal_doc_detail_content"  class="legal_doc_detail_content_css" hidden="true">
			<div class ="article clearfix">
				<button type="button" id="bt_legal_back" onclick="backToListLegalDoc()" style="margin-left: 10px; margin-bottom: 5px; margin-top: 5px;">
					<liferay-ui:message key="common.button.back"/>
				</button>
			</div>
			<table>
            	<tr>
                	<td width="35%"><strong><liferay-ui:message key="portlet.legal_documents.table.header.doc_symbols"/></strong></td>
                    <td width="65%" id="details_doc_symbol"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legal_documents.table.header.doc.description"/></strong></td>
                    <td id="details_doc_description"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legaldocument.detail.date.publish"/></strong></td>
                    <td id="details_doc_date_publish"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.effect_date.label"/></strong></td>
                    <td id="details_doc_effect_date"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legaldocument.detail.category"/></strong></td>
                    <td id="details_doc_category"></td>
                </tr>
                
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legaldocument.detail.lable.grade_publisher"/></strong></td>
                    <td id="details_doc_grade_publisher"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legaldocument.detail.lable.organ_publisher"/></strong></td>
                    <td id="details_doc_organ_publisher"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.legaldocument.detail.lable.signer"/></strong></td>
                    <td id="details_doc_signer"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.attach_file.label"/></strong></td>
                    <td id="details_file_attach"></td>
                </tr> 
                                                     
           </table>
		</div>
	</div>
</div>
