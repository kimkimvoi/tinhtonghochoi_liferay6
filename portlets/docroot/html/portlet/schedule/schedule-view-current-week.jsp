<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script type="text/javascript">
$(document).ready( function() {
	$('#searchWeek').click( function(e) {
		searchWeekSchedules();
	});
});
	
function searchWeekSchedules() {
	var portletNameSpace = $("#portletNameSpace").val();
	var selectDay = $('#'+ portletNameSpace + "daySelect").val();
	var selectMonth = $('#'+ portletNameSpace + "monthSelect").val();
	var selectYear = $('#'+ portletNameSpace + "yearSelect").val();	
	console.log("selectDay: " + selectDay + "**monthSelect: " + selectMonth + "**yearSelect: " + selectYear);
	
	var URL = $('#scheduleSearchAjaxActionURL').val();
	$.ajax({
		sync: false,
		url: URL,
		data: {daySelect: selectDay, monthSelect: selectMonth, yearSelect: selectYear},
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
	<div class="clear"></div>
	<c:if test="${schedule.searchCondition == 'AllowSearch'}">
		<div class="schedule_week_form_content">
			<form id="scheduleSearchWeekForm">
				<div class="scheSearchPn">
					<label class="aui-field-label" for="cbx_schedule_month"> <liferay-ui:message key="portlet.schedule.select.dayinmonth"/>: </label>
					<liferay-ui:input-date dayNullable="<%=true%>" monthNullable="<%=true%>" yearNullable="<%=true%>" formName="startTime" yearRangeStart="1950" yearRangeEnd="2100"  
						dayParam="daySelect" monthParam="monthSelect" yearParam="yearSelect" />
				</div>
				<div class="scheSearchPn">
					<input type="button" id ="searchWeek" value ="<liferay-ui:message key="portlet.schedule.button.search"/>"/> 
				</div>
			</form>
		</div>
	</c:if>
	<div class="weekly_schedule" id="weekSchedules">
		<c:set var="item" value="${schedule.weekScheduleList[0]}"/>
		<div class="weekly_schedule_title">${item.weekScheduleTitle}</div>
		<div class="box_calender_work">
			<cus:table id="week_schedule_${item.weekOfYear}" headers="${item.weekScheduleHeader}" headerClass="title" displayedPropertyList="${schedule.displayedPropertyList}" dataList="${item.schedule}" />
		</div>
	</div>
	<portlet:resourceURL escapeXml="false" id="scheduleSearchByWeekAjaxAction" var="scheduleSearchByWeekAjaxAction" />
	<input id="scheduleSearchAjaxActionURL" type="hidden" value="<%=renderResponse.encodeURL(scheduleSearchByWeekAjaxAction.toString()) %>" />
	<input type="hidden" id="portletNameSpace" value="<portlet:namespace />" />
</div>