<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script type="text/javascript">
$(document).ready( function() {
	$('#search').click( function(e) {
		searchSchedules();
	});
});

function searchSchedules() {
	var URL = $('#scheduleSearchAjaxActionURL').val();
	$.ajax({
		sync: false,
		url: URL,
		data: $('#scheduleSearchForm').serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			rebindSchedule(data);
		},
		error: function(response) {
		}
	});
}

function buildScheduleTableHeader(data) {
	var retVal = '';
		retVal += '<tr class="title">';
		$(data).each(function(i, item) {
			retVal += '<th>'+item+'</th>';
		});
		retVal += '</tr>';
	return retVal;
}

function buildScheduleTableBody(data) {
	var retVal = '';
	$(data).each(function(i, item) {
		retVal += '<tr class="dataRow">';
		retVal += '<td>'+ item.userName +'</td>';
		retVal += '<td>'+item.monday+'</td>';
		retVal += '<td>'+item.tuesday+'</td>';
		retVal += '<td>'+item.wednesday+'</td>';
		retVal += '<td>'+item.thursday+'</td>';
		retVal += '<td>'+item.friday+'</td>';
		retVal += '<td style="display: none;"></td>';
		retVal += '</tr>';
	});
	
	return retVal;
}

function rebindSchedule(data) {
	var str = '';
	$(data.weekScheduleList).each(function(i, item) {
		str += '<div class="weekly_schedule_title">'+item.weekScheduleTitle+'</div>';
		str += '<div class="box_calender_work">';
		str += '<table id="week_schedule_'+item.weekOfYear+'">';
		str += '<tbody>';
		str += buildScheduleTableHeader(item.weekScheduleHeader);
		str += buildScheduleTableBody(item.schedule);
		str += '</tbody>';
		str += '</table>';
		str += '</div>';
	});
	$('#weekSchedules').html(str);
}
</script>
<div class="portlet_wrapper">
	<div><h2 class="title_tab"><label><liferay-ui:message key="portlet.schedule.title"/></label></h2></div>
	<c:if test="${schedule.searchCondition == 'AllowSearch'}">
		<div class="schedule_form_content">
			<form id="scheduleSearchForm">
				<div class="scheSearchPn">
					<label class="aui-field-label" for="cbx_schedule_month"> <liferay-ui:message key="portlet.schedule.month"/>: </label>
					<aui:select cssClass="schedule_cbx" label="" name="cbx_schedule_month" id="cbx_schedule_month">
						<c:forEach items="${schedule.searchModel.months}" var="item">
							<aui:option selected="${schedule.searchModel.selectedMonth==item.key}" value="${item.key}" label="${item.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="scheSearchPn">
					<label class="aui-field-label" for="cbx_schedule_year"> <liferay-ui:message key="portlet.schedule.year"/>: </label>
					<aui:select cssClass="schedule_cbx" label="" name="cbx_schedule_year" id="cbx_schedule_year">
						<c:forEach items="${schedule.searchModel.years}" var="item">
							<aui:option value="${item.key}" label="${item.value}" />
						</c:forEach>
					</aui:select>
				</div>
				<div class="scheSearchPn">
					<input type="button" id ="search" value ="<liferay-ui:message key="portlet.schedule.button.search"/>"/> 
				</div>
			</form>
		</div>
	</c:if>
	
	<div class="weekly_schedule" id="weekSchedules">
		<c:forEach items="${schedule.weekScheduleList}" var="item">
			<div class="weekly_schedule_title">${item.weekScheduleTitle}</div>
			<div class="box_calender_work">
				<cus:table id="week_schedule_${item.weekOfYear}" headers="${item.weekScheduleHeader}" headerClass="title" displayedPropertyList="${schedule.displayedPropertyList}" dataList="${item.schedule}" />
			</div>
		</c:forEach>
	</div>
	<portlet:resourceURL escapeXml="false" id="scheduleSearchAjaxAction" var="scheduleSearchAjaxAction" />
	<input id="scheduleSearchAjaxActionURL" type="hidden" value="<%=renderResponse.encodeURL(scheduleSearchAjaxAction.toString()) %>" />
</div>
