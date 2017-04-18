<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!-- Load JQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- Load jquery.cookie plugin (optional) jquery-1.9.1.js -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/html/js/jquery-1.9.1.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/html/portlet/publicadministrationprocedure/js/jquery.js"></script>
<!-- Load jquery.navgoco plugin js and css files -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/html/portlet/publicadministrationprocedure/css/accordionmenu.css" type="text/css" media="screen" />   
<script type="text/javascript">
	$(document).ready(function() {

		// Store variables
		
		var accordion_head = $('.accordion > li > a'),
			accordion_body = $('.accordion li > .sub-menu');

		// Open the first tab on load

		accordion_head.first().addClass('active').next().slideDown('normal');

		// Click function

		accordion_head.on('hover', function(event) {

			// Disable header links
			
			event.preventDefault();

			// Show and hide the tabs on click

			if ($(this).attr('class') != 'active'){
				accordion_body.slideUp('normal');
				$(this).next().stop(true,true).slideToggle('normal');
				accordion_head.removeClass('active');
				$(this).addClass('active');
			}

		});

	});

</script>    
<portlet:resourceURL var="getDetailsAdministrationProcedureAjax" id="getDetailsAdministrationProcedureAjax"></portlet:resourceURL>
<portlet:resourceURL var="searchPublicAdministrationProcedureAjax" id="searchPublicAdministrationProcedureAjax"></portlet:resourceURL>
<input type="hidden" id="getDetailsAdministrationProcedureAjax_Url" value="${getDetailsAdministrationProcedureAjax }"/>
<div class="box_dichvucong">
	<div class="dichvucong_left_content">
		<ul id="dichvucong_menu_right" class="accordion" >
			<li style="margin-bottom: 10px;" class="tilte_menu">
				<a class="active" style="padding-left: 5px;">Lĩnh vực dịch vụ công</a>
		        <c:if test="${fields != null }">
		        	<ul style="display: block;" class="sub-menu">
						<c:forEach items="${fields}" var="fieldsList">
							 <li><a onclick="menuItemOnclick('${fieldsList.value}', '${searchPublicAdministrationProcedureAjax}')">${fieldsList.value}</a></li>
						</c:forEach>
					</ul>
				</c:if>
		    </li>
		    
		    <li style="margin-bottom: 10px;" class="tilte_menu">
		    	<a class="" style="padding-left: 5px">TTHC cấp sở ban ngành</a>
		        <c:if test="${fields != null }">
		        	<ul style="display: none;" class="sub-menu">
						<c:forEach items="${organizations}" var="organizationsList">
							<c:if test="${organizationsList.value != 'TTHC cấp Huyện'}">
								<c:if test="${organizationsList.value != 'TTHC cấp Xã'}">
									<li><a onclick="menuItemSoBanNganhOnclick('${organizationsList.value}', '${searchPublicAdministrationProcedureAjax}')">${organizationsList.value}</a></li>
								</c:if>
							</c:if>
						</c:forEach>
					</ul>
				</c:if>
		    </li>
		</ul>
		
		<ul id="dichvucong_menu_TTHC_huyen_xa" class="menu_item_huyen_xa" >
			<li style="margin-bottom: 10px;">
				<a class="" style="padding-left: 5px;" onclick="menuItemSoBanNganhOnclick('TTHC cấp Huyện', '${searchPublicAdministrationProcedureAjax}')">TTHC cấp huyện</a>
			</li>
		    <li style="margin-bottom: 10px;">
		    	<a class="" style="padding-left: 5px;" onclick="menuItemSoBanNganhOnclick('TTHC cấp Xã', '${searchPublicAdministrationProcedureAjax}')">TTHC cấp xã</a>
		    </li>
		    <li style="margin-bottom: 10px;">
		    	<a style="padding-left: 5px;">Tra cứu tình trạng hồ sơ</a>
		    </li>
		    <li style="margin-bottom: 10px;">
		    	<a style="padding-left: 5px;">Thủ tục hành chính công</a>
		    </li>
		    <li style="margin-bottom: 10px;">
		    	<a style="padding-left: 5px;">Thống kê dịch vụ công</a>
		    </li>
		</ul>
	</div>
	
	<div class="dichvucong_right_content">
		<h2 class="title_tab">
			<label><liferay-ui:message key="portlet.publicadministrationprocedure.title" /></label>
		</h2>
		<div class="clear"></div>
		<div class="dich_vu_cong_right_content_wapper">
			<div id="tim_kiem_danh_sach_tthc">
				<ul class="list_tracuu">
					<li>
						<label><liferay-ui:message key="portlet.publicadministrationprocedure.field" /></label>
						<select class="select" name="publicFields" id="fields">
							<option value="0">
								<liferay-ui:message key="portlet.public_news.search.all.title" />
							</option>
							<c:if test="${fields != null }">
								<c:forEach items="${fields}" var="fieldsList">
									<option value="${fieldsList.key}">${fieldsList.value}</option>
								</c:forEach>
							</c:if>
						</select>
						</li>
					<li>
						<label><liferay-ui:message key="portlet.publicadministrationprocedure.agencie.and.sectors" />: </label> 
						<select class="select" name="publicOrganization" id="organization">
							<option value="0">
								<liferay-ui:message key="portlet.public_news.search.all.title" />
							</option>
							<c:if test="${organizations != null }">
								<c:forEach items="${organizations}" var="organizationsList">
									<option value="${organizationsList.key}">${organizationsList.value}</option>
								</c:forEach>
							</c:if>
					</select>
					</li>
					<li>
						<label><liferay-ui:message key="portlet.publicadministrationprocedure.level.title" />: </label> 
						<select class="select" name="levelAdministrationProcedureName" id="levelAdministrationProcedure">
							<option value="0">
								<liferay-ui:message key="portlet.public_news.search.all.title" />
							</option>
							<c:if test="${levelAdministrationProcedure != null }">
								<c:forEach items="${levelAdministrationProcedure}" var="levelList">
									<option value="${levelList.key}">${levelList.value}</option>
								</c:forEach>
							</c:if>
					</select>
					</li>
					<li><label><liferay-ui:message key="portlet.publicadministrationprocedure.content.search" />:</label> <input type="text" class="input" name="txtKeySearch" id="txtKeySearch" />
					</li>
					<li><input onclick="searchPublicAdministrationProcedureAjax('${searchPublicAdministrationProcedureAjax}')" type="button" value="<liferay-ui:message key="portlet.publicadministrationprocedure.search" />" class="buttons right">
					</li>
				</ul>
				<div class="clear"></div>
				<div class="boxlist_tracuu">
					<cus:table dataList="${administrationProcedureList }" displayedPropertyList="${displayedPropertyList }" headerClass="title" headers="${headersList }" id="administrationProcedureListTable" hiddenPropertyList="${hiddenPropertyList}" />
					<cus:paginator curPageStatusText="${curPageStatusText }" numOfPage="${numOfPage}" tableId="administrationProcedureListTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}" />
					<portlet:resourceURL escapeXml="false" id="administrationProcedureListTable_LoadPage" var="administrationProcedureListTable_LoadPage">
					</portlet:resourceURL>
					<input id="administrationProcedureListTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(administrationProcedureListTable_LoadPage.toString())%>" />
					<input id="administrationProcedureListTable_headerList" type="hidden" value="${headersList}" /> 
					<input id="administrationProcedureListTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" /> 
					<input id="administrationProcedureListTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" /> 
					<input id="administrationProcedureListTable_headerClass" type="hidden" value="title" />
					<input id="resultSearchPublicAdministrationTable_Id" type="hidden" value="1" />
				</div>
			</div>
			
			<!-- display detail -->
			<div class="clear" style="clear: both;"></div>
			
			<div class="publics_administration_procedure_details" id="publics_administration_procedure_details" style="display: none;" >				
				<table>
					<tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.name.procedure"/></strong></td>
		                 <td id="details_name_procedure"><strong style="font-weight: bold;" id="details_name_procedure" > </strong></td>
		             </tr>
		          	<tr>
		              	<td width="25%"><strong><liferay-ui:message key="portlet.publicadministrationprocedure.order"/></strong></td>
		                  <td width="60%" id="details_order"></td>
		              </tr>
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.perform"/></strong></td>
		                  <td id="details_perform"></td>
		              </tr>
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.profile"/></strong></td>
		                  <td id="details_profile"></td>
		              </tr> 
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.resolution"/></strong></td>
		                  <td id="details_resolution"></td>
		              </tr> 
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.object.procedure"/></strong></td>
		                  <td id="details_object_procedure"></td>
		              </tr>
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.object.ororganizations"/></strong></td>
		                  <td id="details_ororganizations"></td>
		              </tr>
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.result"/></strong></td>
		                  <td id="details_result"></td>
		              </tr>
		              
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.fees"/></strong></td>
		                  <td id="details_fees"></td>
		              </tr> 
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.application"/></strong></td>
		                  <td id="details_application"></td>
		              </tr> 
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.requirement"/></strong></td>
		                  <td id="details_requirement"></td>
		              </tr>
		              <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.legal.basis"/></strong></td>
		                  <td id="details_legal_basis"></td>
		              </tr> 
		               <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.contact"/></strong></td>
		                  <td id="details_contact"></td>
		              </tr> 
		               <tr>
		              	<td><strong><liferay-ui:message key="portlet.publicadministrationprocedure.attach.document"/></strong></td>
		                  <td id="details_attach_document"></td>
		              </tr> 
		        </table>
		        <div class="display_result_title" id="public_administration_procedure_bark_area">					
				</div>
		        <div class="display_result_title" id="list_other_public_administration_procedure">
				</div>
		     </div>	
		</div>
	</div>
</div>