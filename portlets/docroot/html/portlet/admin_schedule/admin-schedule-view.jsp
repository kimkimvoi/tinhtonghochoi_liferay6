<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script type="text/javascript">
$(document).ready( function() {
	$('#_user_schedule_save').click( function(e) {
		saveUserSchedules();
	});
	
	$('#_admin_schedule_search').click( function(e){
		searchUserMonthSchedule();
	});

	$('#_user_week_schedule_save').click( function(e){
		saveUserMonthSchedule();
	});
});

function saveUserSchedules() {
	hideMessage();
	var URL = $('#scheduleSaveUserAjaxActionURL').val();
	var userIDs = getUserIds();
	$.ajax({
		sync: false,
		url: URL,
		data: {'users':userIDs},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			$('#_user_msg_success').show();
			$('#_user_schedule_list').html('');
			rebindUsersSelection();
		},
		error: function(response) {
			$('#_user_msg_error').show();
		}
	});
	
}

function saveUserMonthSchedule() {
	hideMessage();
	var URL = $('#saveUserMonthScheduleAjaxActionURL').val();
	$.ajax({
		sync: false,
		url: URL,
		data: $('#_month_schedule_form').serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			$('#_msg_success').show();
			rebindUsersSelection();
		},
		error: function(response) {
			$('#_msg_error').show();
		}
	});
}

function searchUserMonthSchedule() {
	hideMessage();
	var URL = $('#scheduleSearchUserMonthScheduleAjaxActionURL').val();
	$.ajax({
		sync: false,
		url: URL,
		data: $('#_month_schedule_form').serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			rebindMonthSchedule(data);
		},
		error: function(response) {
			$('#_msg_error').show();
		}
	});
}

function rebindMonthSchedule(data) {
	var newHTML = '';
	newHTML +='<tbody>';
	newHTML +='<tr class="title">';
	newHTML +='	<th class="th1"></th>';
	newHTML +='	<th class="th2"><liferay-ui:message key="day.monday" /></th>';
	newHTML +='	<th class="th3"><liferay-ui:message key="day.tuesday" /></th>';
	newHTML +='	<th class="th4"><liferay-ui:message key="day.wednesday" /></th>';
	newHTML +='	<th class="th5"><liferay-ui:message key="day.thursday" /></th>';
	newHTML +='	<th class="th6"><liferay-ui:message key="day.friday" /></th>';
	newHTML +='</tr>';
	newHTML += bindScheduleRowData(data);
	newHTML +='</tbody>';
	$('#_user_schedule_list').html(newHTML);
	$('#monthOfSchedule').val('' + data.searchModel.selectedMonth);
	$('#yearOfSchedule').val('' + data.searchModel.selectedYear);
}

function bindScheduleRowData(data) {
	var rowStr = '';
	$(data.weekScheduleList).each(function(i, item) {
		$(item.schedule).each(function(index, e) {
			rowStr +='		<tr class="dataRow">';
			rowStr +='			<td class="td1">'+item.startDate+' - '+item.endDate+'</td>';
			rowStr +='			<td class="td2"><textarea name="'+item.weekOfYear+'_2" id="${item.weekOfYear}_2" cols="15" rows="3">'+e.monday+'</textarea></td>';
			rowStr +='			<td class="td3"><textarea name="'+item.weekOfYear+'_3" id="${item.weekOfYear}_3" cols="15" rows="3">'+e.tuesday+'</textarea></td>';
			rowStr +='			<td class="td4"><textarea name="'+item.weekOfYear+'_4" id="${item.weekOfYear}_4" cols="15" rows="3">'+e.wednesday+'</textarea></td>';
			rowStr +='			<td class="td5"><textarea name="'+item.weekOfYear+'_5" id="${item.weekOfYear}_5" cols="15" rows="3">'+e.thursday+'</textarea></td>';
			rowStr +='			<td class="td6"><textarea name="'+item.weekOfYear+'_6" id="${item.weekOfYear}_6" cols="15" rows="3">'+e.friday+'</textarea></td>';
			rowStr +='		</tr>';
		});
	});
	
	rowStr +='<c:forEach items="${admin.monthSchedule}" varStatus="sts" var="item">';
	rowStr +='	<c:forEach items="${item.schedule }" var="s" varStatus="i" >';
	
	rowStr +='	</c:forEach>';
	rowStr +='</c:forEach>';
	return rowStr;
}

function getUserIds() {
	var userIDs = '';
	$('#allowedDisplayScheduleUsers').find('tr').each(function(e, item){
		userIDs += $(this).attr('id') + ',';
	});
	return userIDs;
}

function rebindUsersSelection() {
	var newOps = '';
	var URL = $('#getUsersSchedule').val();
	$.ajax({
		sync: false,
		url: URL,
		dataType: 'json',
		type: "GET",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {
				newOps += '<option value="'+data[i].userId+'">'+data[i].userName+'</option>';
			}
			$('#_cbx_users').html(newOps);
		},
		error: function(response) {
			$('#_msg_error').show();
		}
	});
	
}

function hideMessage() {
	$('#_msg_error').hide();
	$('#_msg_success').hide();
	$('#_user_msg_error').hide();
	$('#_user_msg_success').hide();
	$('#_user_dulicate_msg_error').hide();
}
function renderUsersTable(data, cssSelector) {
	var htmlContent = '';
	htmlContent += '<table class="user_schedule_table" id="_user_list">';
	htmlContent += '	<tbody>';
	htmlContent += '		<tr class="title">';
	htmlContent += '			<th class="th2">'+$('#tableHeaderTitleUserName').val()+'</th>';
	htmlContent += '		<th class="th3">'+$('#tableHeaderTitleJobName').val()+'</th>';
	htmlContent += '		<th class="th4">'+$('#tableHeaderTitleAllowDisplay').val()+'</th>';
	htmlContent += '	</tr>';
	if(data.items != undefined && data.items.length > 0) {
		for(var i = 0 ; i < data.items.length; i++) {
			htmlContent += generateUsersTableHTML(data.items[i]);
		}
	}
	htmlContent += '</tbody>';
	htmlContent += '</table>';
	$(cssSelector).html(htmlContent);
}
function generateUsersTableHTML(data) {
	var htmlContent = '';
	htmlContent += '	<tr class="dataRow">';
	htmlContent += '		<td class="td2">'+data.userName+'</td>';
	htmlContent += '		<td class="td3">'+data.jobTitleName+'</td>';
	htmlContent += '	<td class="td4"><input class="_schedule_check" type="button" value="<liferay-ui:message key="common.button.add"/>" name="'+data.userId+'" id="'+data.userId+'" onclick="addUserSchedule(this)" ></td>';
	htmlContent += '</tr>';
	
	return htmlContent;
}
function getContextPath() {
	   return $('#CONTEXT_PATH').val();
}
function removeUserSchedule(obj) {
	hideMessage();
	$($(obj).parent()).parent().remove();
}
function addUserSchedule(obj) {
	hideMessage();
	var trObj = $($(obj).parent()).parent();
	var id = $(trObj.find('td:nth-child(3)')).find('input').attr('id');
	if (isExisteduserWithId(id)) {
		$('#_user_dulicate_msg_error').show();
		return;
	}
	var name = trObj.find('td:nth-child(1)').html();
	var job = trObj.find('td:nth-child(2)').html();
    var newRow = $("<tr id='"+id+"' class='datarow'>");
    var cols = "";

    cols += '<td class="td2">'+name+'</td>';
    cols += '<td class="td3">'+job+'</td>';
    cols += '<td class="td4"><input type="button" onclick="removeUserSchedule(this)" value="<liferay-ui:message key="common.button.delete"/>" /></td>';
    newRow.append(cols);
    $("#allowedDisplayScheduleUsers").append(newRow);
}
function isExisteduserWithId(id) {
	var isExised = false;
	if(id == undefined && id.length() == 0) {
		return isExised;
	}
	$('#allowedDisplayScheduleUsers').find('tr').each(function(e, item){
		if (undefined != $(this).attr('id') && id == $(this).attr('id')) {
			isExised = true;
			return false;
		}
	});
	return isExised;
}
</script>
<div>
	<div style="display:none" id="_msg_success" class="portlet-msg-success"><liferay-ui:message key="common.msg.success" /></div>
	<div style="display:none" id="_msg_error" class="portlet-msg-error"><liferay-ui:message key="common.msg.error" /></div>
	<div class="week_schedule_pn">
		<div class="user_schedule_title"><h2><liferay-ui:message key="portlet.adminschedule.usersweektable.title" /></h2></div>
		<form id="_month_schedule_form">
		<div class="schedule_week_search_pn">
				<div class="scheSearchPn">
					<label class="aui-field-label" for="_cbx_users"> <liferay-ui:message key="portlet.adminschedule.header.username"/>: </label>
					<span class="aui-field aui-field-select aui-field-menu schedule_cbx_user">
					<select class="aui-field-input aui-field-input-select aui-field-input-menu" name="_cbx_users" id="_cbx_users">
						<c:forEach items="${admin.scheduleSearch.users}" var="item">
							<c:if test="${item.displaySchedule}">
								<option value="${item.userId}">${item.userName}</option>	
							</c:if>
						</c:forEach>
					</select>
					</span>
				</div>
				<div class="scheSearchPn">
					<label class="aui-field-label" for="cbx_schedule_month"> <liferay-ui:message key="portlet.schedule.month"/>: </label>
					<aui:select cssClass="schedule_cbx_month" label="" name="cbx_schedule_month" id="cbx_schedule_month">
						<c:forEach items="${admin.scheduleSearch.months}" var="item">
							<aui:option selected="${admin.scheduleSearch.selectedMonth==item.key}" value="${item.key}" label="${item.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="scheSearchPn">
					<label class="aui-field-label" for="cbx_schedule_year"> <liferay-ui:message key="portlet.schedule.year"/>: </label>
					<aui:select cssClass="schedule_cbx_year" label="" name="cbx_schedule_year" id="cbx_schedule_year">
						<c:forEach items="${admin.scheduleSearch.years}" var="item">
							<aui:option selected="${admin.scheduleSearch.selectedYear==item.key}" value="${item.key}" label="${item.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="scheSearchPn">
					<input type="button" id ="_admin_schedule_search" value ="<liferay-ui:message key="portlet.schedule.button.search"/>"/> 
				</div>
			</div>
			<hr/>
			<div id="_user_month_schedule_title" class="user_month_title"><h2><liferay-ui:message key="portlet.adminschedule.usersweektable.edittitle" /></h2></div>
			<div class="box_calender_work">
				<table class="week_schedule_table" id="_user_schedule_list">
					<tbody>
						<tr class="title">
							<th class="th1"></th>
							<th class="th2"><liferay-ui:message key="day.monday" /></th>
							<th class="th3"><liferay-ui:message key="day.tuesday" /></th>
							<th class="th4"><liferay-ui:message key="day.wednesday" /></th>
							<th class="th5"><liferay-ui:message key="day.thursday" /></th>
							<th class="th6"><liferay-ui:message key="day.friday" /></th>
						</tr>
						<c:forEach items="${admin.monthSchedule}" varStatus="sts" var="item">
							<c:forEach items="${item.schedule }" var="s" varStatus="i" >
								<tr class="dataRow">
									<td class="td1">${item.startDate} - ${item.endDate}</td>
									<td class="td2"><textarea name="${item.weekOfYear}_2" id="${item.weekOfYear}_2" cols="15" rows="3">${s.monday}</textarea></td>
									<td class="td3"><textarea name="${item.weekOfYear}_3" id="${item.weekOfYear}_3" cols="15" rows="3">${s.tuesday}</textarea></td>
									<td class="td4"><textarea name="${item.weekOfYear}_4" id="${item.weekOfYear}_4" cols="15" rows="3">${s.wednesday}</textarea></td>
									<td class="td5"><textarea name="${item.weekOfYear}_5" id="${item.weekOfYear}_5" cols="15" rows="3">${s.thursday}</textarea></td>
									<td class="td6"><textarea name="${item.weekOfYear}_6" id="${item.weekOfYear}_6" cols="15" rows="3">${s.friday}</textarea></td>
								</tr>
							</c:forEach>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="buttons_panel">
				<input type="button" id ="_user_week_schedule_save" value ="<liferay-ui:message key="common.button.save"/>"/> 
			</div>
			<input id="monthOfSchedule" name="monthOfSchedule" type="hidden" value="${admin.monthOfSchedule}" />
			<input id="yearOfSchedule" name="yearOfSchedule" type="hidden" value="${admin.yearOfSchedule}" />
		</form>
	</div>
	<hr />
		
	<div class="box_calender_work">
		<div class="user_schedule_title"><h2><liferay-ui:message key="portlet.adminschedule.userstable.title" /></h2></div>
		<div style="display:none" id="_user_msg_success" class="portlet-msg-success"><liferay-ui:message key="common.msg.success" /></div>
		<div style="display:none" id="_user_msg_error" class="portlet-msg-error"><liferay-ui:message key="common.msg.error" /></div>
		<div style="display:none" id="_user_dulicate_msg_error" class="portlet-msg-error"><liferay-ui:message key="common.msg.error.duplicateUser" /></div>
		<div class="right">
			<h4>
				<liferay-ui:message key="portlet.adminschedule.userstable.userScheduleSearchTableTitle" />
			</h4>
			<div class="search_user_panel">
				<input id="userSearchKey" class="aui-field-input aui-field-input-select aui-field-input-menu" type="text" name="userSearchKey" />
				<input id="btnSearch" type="button" value="<liferay-ui:message key="portlet.schedule.button.search"/>" />
			</div>
			<br/>
			<div id="usersTable">
				<!-- content ajax load data -->
			</div>
			<portlet:resourceURL escapeXml="false" id="getAllUsers" var="getAllUsers" />
			<tag:paging searchKey="#userSearchKey" searchButton="#btnSearch" loadPageURL="${renderResponse.encodeURL(getAllUsers.toString())}" pageWrapperCSSSelector="#usersTable" renderPageJsFunction="renderUsersTable"></tag:paging>
		</div>
		<br/>
		<div class="left">
			<form id="_users_schedule_form">
				<div class="user_schedule_table">
					<h4>
						<liferay-ui:message key="portlet.adminschedule.userstable.userScheduleTableTitle" />
					</h4>
				</div>
				<table class="user_schedule_table" id="allowedDisplayScheduleUsers">
					<tbody>
						<tr class="title">
							<th class="th2"><liferay-ui:message key="portlet.adminschedule.header.username" /></th>
							<th class="th3"><liferay-ui:message key="portlet.adminschedule.jobname" /></th>
							<th class="th4"></th>
						</tr>
						<c:forEach items="${admin.usersSchedule}" varStatus="status"
							var="item">
							<c:if test="${item.displaySchedule}">
								<tr id='${item.userId }' class="dataRow">
									<td class="td2">${item.userName}</td>
									<td class="td3">${item.jobTitleName}</td>
									<td class="td4"><input type="button" onclick="removeUserSchedule(this)" value="<liferay-ui:message key="common.button.delete"/>" /></td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<div class="buttons_panel">
			<input type="button" id ="_user_schedule_save" value ="<liferay-ui:message key="common.button.save"/>"/> 
		</div>
	</div>
	<div>
		
	</div>
	<input type="hidden" id="tableHeaderTitleNo" value="<liferay-ui:message key="portlet.adminschedule.header.no" />">
	<input type="hidden" id="tableHeaderTitleUserName" value="<liferay-ui:message key="portlet.adminschedule.header.username" />">
	<input type="hidden" id="tableHeaderTitleJobName" value="<liferay-ui:message key="portlet.adminschedule.jobname" />">
	<input type="hidden" id="tableHeaderTitleAllowDisplay" value="<liferay-ui:message key="portlet.adminschedule.allowdisplay" />">
	<portlet:resourceURL escapeXml="false" id="scheduleSaveUserAjaxAction" var="scheduleSaveUserAjaxAction" />
	<portlet:resourceURL escapeXml="false" id="scheduleSearchUserMonthScheduleAjaxAction" var="scheduleSearchUserMonthScheduleAjaxAction" />
	<portlet:resourceURL escapeXml="false" id="saveUserMonthScheduleAjaxAction" var="saveUserMonthScheduleAjaxAction" />
	<portlet:resourceURL escapeXml="false" id="getUsersSchedule" var="getUsersSchedule" />
	<input id="scheduleSaveUserAjaxActionURL" type="hidden" value="<%=renderResponse.encodeURL(scheduleSaveUserAjaxAction.toString()) %>" />
	<input id="scheduleSearchUserMonthScheduleAjaxActionURL" type="hidden" value="<%=renderResponse.encodeURL(scheduleSearchUserMonthScheduleAjaxAction.toString()) %>" />
	<input id="saveUserMonthScheduleAjaxActionURL" type="hidden" value="<%=renderResponse.encodeURL(saveUserMonthScheduleAjaxAction.toString()) %>" />
	<input id="getUsersSchedule" type="hidden" value="<%=renderResponse.encodeURL(getUsersSchedule.toString()) %>" />
</div>
