<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@ include file="/html/common/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL name="staffSearchAction" var="staffSearchAction">

</portlet:actionURL>

<portlet:resourceURL id="staffSearchAjax" var="staffSearchAjax">

</portlet:resourceURL>

<script type="text/javascript">
	$( document ).ready(function() {
		searchButtonClick('${staffSearchAjax}');
	});
</script>

<div class="searchStaffInfo">
	<h2 class="title_tab">
		<label><liferay-ui:message key="portlet.search_staff.portlet.title" /></label>
	</h2>
	<%-- <div class="searchStaffInfo-info">
		<div class="searchStaffInfo-title">
			<liferay-ui:message key="portlet.search-staff.title"></liferay-ui:message>
		</div>
		<div class="searchStaffInfo-content">
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRow">
					<liferay-ui:message key="portlet.search-staff.portal"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.license.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.license.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.agency.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.agency.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.responsible.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.responsible.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.headquarters.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.headquarters.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.phone.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.phone.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.fax.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.fax.value"></liferay-ui:message>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="contact.email.title"></liferay-ui:message>
				</div>
	
				<div class="searchStaffInfo-contentRowB">
					<liferay-ui:message key="contact.email.value"></liferay-ui:message>
				</div>
			</div>
		</div>
	</div> 
	<div class="clear"></div>--%>
	<div class="searchStaffInfo-search">
		<%-- <div class="searchStaffInfo-title">
			<liferay-ui:message key="portlet.search-staff.search.title"></liferay-ui:message>
		</div> --%>
		<div class="searchStaffInfo-content">
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="portlet.search-staff.search.content.title"></liferay-ui:message>
				</div>

				<div class="searchStaffInfo-contentRowB">
					<input class="textbox-search input" id="searchStaffInfo-contentSearchId" name="contentSearch" value = "${contentSearch}">
					<input class="button-search button" id="button-searchId" onclick="searchButtonClick('${staffSearchAjax}')" type="button" value="<liferay-ui:message key="portlet.search-staff.search.button.label"></liferay-ui:message>" />
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message key="portlet.search-staff.search.type.title"></liferay-ui:message>
				</div>

				<div class="searchStaffInfo-contentRowB">
					<select id="searchStaffInfo-typeSearchId" name="typeSearch"
						class="selectbox-search select">
						<option
							value="<liferay-ui:message key="portlet.search-staff.search.type.all.title" />">
							<liferay-ui:message
								key="portlet.search-staff.search.type.all.value" />
						</option>
						<option
							value="<liferay-ui:message key="portlet.search-staff.search.type.name.title" />">
							<liferay-ui:message
								key="portlet.search-staff.search.type.name.value" />
						</option>
						<option
							value="<liferay-ui:message key="portlet.search-staff.search.type.role.title" />">
							<liferay-ui:message
								key="portlet.search-staff.search.type.role.value" />
						</option>
						<option
							value="<liferay-ui:message key="portlet.search-staff.search.type.phone.title" />">
							<liferay-ui:message
								key="portlet.search-staff.search.type.phone.value" />
						</option>
						<option
							value="<liferay-ui:message key="portlet.search-staff.search.type.email.title" />">
							<liferay-ui:message
								key="portlet.search-staff.search.type.email.value" />
						</option>
					</select>
				</div>
			</div>
			<div class="searchStaffInfo-contentField">
				<div class="searchStaffInfo-contentRowA">
					<liferay-ui:message
						key="portlet.search-staff.search.organizations.title"></liferay-ui:message>
				</div>

				<div class="searchStaffInfo-contentRowB">
					<select name="organizationsSearch" class="selectbox-search select"
						id="searchStaffInfo-organizationsId">
						<option value="0">
							<liferay-ui:message key="portlet.search-staff.search.type.all.value"></liferay-ui:message>
						</option>
						<c:if test="${organizationsList != null }">
							<c:forEach items="${organizationsList}" var="organizations">
								<option value="${organizations.organizations_id }">
									${organizations.organizations_name }
								</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>
		</div>
		<div class="searchStaffInfo-result">
			<cus:table dataList="${staffsList }" displayedPropertyList="${displayedPropertyList }" headerClass="title" headers="${headersList }" id="resultSearchStaffTable" />
			<cus:paginator curPageStatusText="${curPageStatusText }" numOfPage="${numOfPage}" tableId="resultSearchStaffTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
			<portlet:resourceURL escapeXml="false" id="resultSearchStaffTable_LoadPage" var="resultSearchStaffTable_LoadPage"></portlet:resourceURL>
			<input id="resultSearchStaffTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(resultSearchStaffTable_LoadPage.toString()) %>" />
			<input id="resultSearchStaffTable_headerList" type="hidden" value="${headersList}" />
			<input id="resultSearchStaffTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
			<input id="resultSearchStaffTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
			<input id="resultSearchStaffTable_headerClass" type="hidden" value="title" />
			<input id="resultSearchStaffTable_curPageId" type="hidden" value="1" />
		
		</div>
	</div>
</div>